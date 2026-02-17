package com.pulse.nexoforge.recipe

import com.nexomc.nexo.api.NexoItems
import com.pulse.nexoforge.api.NexoForgeItem
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.*
import org.bukkit.plugin.Plugin

class RecipeManager(private val plugin: Plugin) {
    private val registeredItems = mutableListOf<NexoForgeItem>()
    private val registeredKeys = mutableListOf<NamespacedKey>()

    fun registerRecipe(item: NexoForgeItem) {
        require(item.data.containsKey("recipe")) { 
            "Item ${item.id} does not contain recipe data" 
        }
        
        if (!registeredItems.any { it.id == item.id }) {
            registeredItems.add(item)
        }
    }

    fun registerRecipes(items: Collection<NexoForgeItem>) {
        items.forEach { item ->
            if (item.data.containsKey("recipe")) {
                registerRecipe(item)
            }
        }
    }

    fun registerRecipes(vararg items: NexoForgeItem) {
        registerRecipes(items.toList())
    }

    fun processRecipes() {
        registeredItems.forEach { item ->
            val recipeData = item.data["recipe"] as? Map<*, *> ?: return@forEach
            val type = recipeData["type"] as? String ?: return@forEach
            val key = NamespacedKey(plugin, "nf_${item.id}")
            
            val amount = (recipeData["amount"] as? Number)?.toInt() ?: return@forEach
            val result = NexoItems.itemFromId(item.id)?.build() ?: return@forEach
            result.amount = amount

            val recipe = when (type) {
                "shaped" -> createShapedRecipe(key, result, recipeData)
                "shapeless" -> createShapelessRecipe(key, result, recipeData)
                "furnace" -> createCookingRecipe(key, result, recipeData, ::FurnaceRecipe)
                "blasting" -> createCookingRecipe(key, result, recipeData, ::BlastingRecipe)
                "smoking" -> createCookingRecipe(key, result, recipeData, ::SmokingRecipe)
                "campfire" -> createCookingRecipe(key, result, recipeData, ::CampfireRecipe)
                else -> null
            } ?: return@forEach

            Bukkit.addRecipe(recipe)
            registeredKeys.add(key)
        }
    }

    fun unregisterAll() {
        registeredKeys.forEach { Bukkit.removeRecipe(it) }
        registeredKeys.clear()
        registeredItems.clear()
    }

    private fun createShapedRecipe(
        key: NamespacedKey,
        result: ItemStack,
        data: Map<*, *>
    ): ShapedRecipe? {
        val shape = data["shape"] as? List<*> ?: return null
        val ingredients = data["ingredients"] as? Map<*, *> ?: return null

        return ShapedRecipe(key, result).apply {
            shape(*shape.map { it.toString() }.toTypedArray())
            
            ingredients.forEach { (char, ingredient) ->
                toRecipeChoice(ingredient)?.let { choice ->
                    setIngredient(char.toString()[0], choice)
                }
            }
        }
    }

    private fun createShapelessRecipe(
        key: NamespacedKey,
        result: ItemStack,
        data: Map<*, *>
    ): ShapelessRecipe? {
        val ingredients = data["ingredients"] as? List<*> ?: return null

        return ShapelessRecipe(key, result).apply {
            ingredients.forEach { ingredient ->
                toRecipeChoice(ingredient)?.let { choice ->
                    addIngredient(choice)
                }
            }
        }
    }

    private fun createCookingRecipe(
        key: NamespacedKey,
        result: ItemStack,
        data: Map<*, *>,
        factory: (NamespacedKey, ItemStack, RecipeChoice, Float, Int) -> CookingRecipe<*>
    ): CookingRecipe<*>? {
        val ingredient = toRecipeChoice(data["ingredient"]) ?: return null
        val experience = (data["experience"] as? Number)?.toFloat() ?: return null
        val cookingTime = (data["cookingTime"] as? Number)?.toInt() ?: return null

        return factory(key, result, ingredient, experience, cookingTime)
    }

    private fun toRecipeChoice(input: Any?): RecipeChoice? {
        return when (input) {
            is NexoForgeItem -> {
                NexoItems.itemFromId(input.id)?.build()?.let { 
                    RecipeChoice.ExactChoice(it)
                }
            }
            is Material -> RecipeChoice.itemType(input.asItemType()!!)
            is ItemStack -> RecipeChoice.ExactChoice(input)
            else -> null
        }
    }
}

package com.pulse.nexoforge.recipe

import com.pulse.nexoforge.api.NexoForgeItem
import com.pulse.nexoforge.recipe.data.RecipeRegistration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class RecipeManager(dataFolder: File) {
    private val recipesFolder = File(dataFolder.parentFile, "Nexo/recipes")
    private val registrations = mutableListOf<RecipeRegistration>()

    fun registerRecipe(item: NexoForgeItem, recipePath: String = "") {
        if (!item.data.containsKey("recipes")) return
        if (registrations.any { it.item.id == item.id }) return
        
        registrations.add(RecipeRegistration(item, recipePath))
    }

    fun registerRecipes(items: Collection<NexoForgeItem>, recipePath: String = "") {
        for (item in items) {
            registerRecipe(item, recipePath)
        }
    }

    fun registerRecipes(vararg items: NexoForgeItem, recipePath: String = "") {
        registerRecipes(items.toList(), recipePath)
    }

    fun generateRecipeFiles() {
        val recipes = mutableMapOf<String, MutableMap<String, MutableMap<String, Any>>>()
        
        for (registration in registrations) {
            val item = registration.item
            val recipesData = item.data["recipes"] as? Map<*, *> ?: continue
            val recipesList = recipesData["recipes"] as? List<*> ?: continue
            
            val recipeCounters = mutableMapOf<String, Int>()
            
            for (recipeData in recipesList) {
                val data = recipeData as? Map<*, *> ?: continue
                val type = data["type"] as? String ?: continue
                
                val counter = recipeCounters.getOrDefault(type, 0) + 1
                recipeCounters[type] = counter
                
                val recipeKey = "${item.id}_${type}_${counter}"
                val cleanData = data.toMutableMap().apply { remove("type") }
                
                val filename = registration.recipePath.ifEmpty { "${item.id}.yml" }
                
                recipes
                    .getOrPut(type) { mutableMapOf() }
                    .getOrPut(filename) { mutableMapOf() }[recipeKey] = cleanData
            }
        }
        
        if (!recipesFolder.exists()) recipesFolder.mkdirs()
        
        for ((type, fileMap) in recipes) {
            val typeFolder = File(recipesFolder, type)
            if (!typeFolder.exists()) typeFolder.mkdirs()
            
            for ((filename, recipeMap) in fileMap) {
                val file = File(typeFolder, filename)
                val yaml = YamlConfiguration()
                
                for ((key, value) in recipeMap) {
                    yaml.set(key, value)
                }
                
                yaml.save(file)
            }
        }
    }
}

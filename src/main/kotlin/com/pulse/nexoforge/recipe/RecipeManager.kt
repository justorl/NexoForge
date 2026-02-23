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
        val recipesByFile = mutableMapOf<String, MutableMap<String, Any>>()
        
        for (registration in registrations) {
            val item = registration.item
            val recipesData = item.data["recipes"] as? Map<*, *> ?: continue
            val recipes = recipesData["recipes"] as? List<*> ?: continue
            
            val recipeCounters = mutableMapOf<String, Int>()
            
            for (recipeData in recipes) {
                val data = recipeData as? Map<*, *> ?: continue
                val type = data["type"] as? String ?: continue
                
                val counter = recipeCounters.getOrDefault(type, 0) + 1
                recipeCounters[type] = counter
                
                val recipeKey = "${item.id}_${type}_${counter}"
                val cleanData = data.toMutableMap().apply { remove("type") }
                
                val filename = registration.recipePath.ifEmpty { "${type}_recipes.yml" }
                
                recipesByFile.getOrPut(filename) { mutableMapOf() }[recipeKey] = cleanData
            }
        }
        
        if (!recipesFolder.exists()) recipesFolder.mkdirs()
        
        for ((filename, recipes) in recipesByFile) {
            val file = File(recipesFolder, filename)
            val yaml = YamlConfiguration()
            
            for ((key, value) in recipes) {
                yaml.set(key, value)
            }
            
            yaml.save(file)
        }
    }
}

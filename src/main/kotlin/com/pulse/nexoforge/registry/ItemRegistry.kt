package com.pulse.nexoforge.registry

import com.pulse.nexoforge.api.NexoForgeItem
import com.pulse.nexoforge.recipe.RecipeManager
import com.pulse.nexoforge.yaml.YamlWriter

class ItemRegistry(
    private val yamlWriter: YamlWriter,
    private val recipeManager: RecipeManager
) {
    private val registeredItems = mutableMapOf<String, NexoForgeItem>()

    fun registerItem(
        item: NexoForgeItem, 
        path: String, 
        append: Boolean = false,
        recipePath: String = ""
    ) {
        val isBlank = item.id.isBlank()
        if (isBlank) {
            throw IllegalArgumentException("Item ID can't be blank")
        }
        
        registeredItems[item.id] = item
        yamlWriter.writeItem(item, path, append)

        if (item.data.containsKey("recipes")) {
            recipeManager.registerRecipe(item, recipePath)
        }
    }

    fun registerItems(
        items: Collection<NexoForgeItem>, 
        path: String, 
        append: Boolean = false,
        recipePath: String = ""
    ) {
        for (item in items) {
            val isBlank = item.id.isBlank()
            if (isBlank) {
                throw IllegalArgumentException("Item ID can't be blank")
            }
            
            registeredItems[item.id] = item

            if (item.data.containsKey("recipes")) {
                recipeManager.registerRecipe(item, recipePath)
            }
        }
        
        yamlWriter.writeItem(items.toList(), path, append)
    }

    fun registerItems(
        vararg items: NexoForgeItem, 
        path: String, 
        append: Boolean = false,
        recipePath: String = ""
    ) {
        registerItems(items.toList(), path, append, recipePath)
    }

    fun getItem(id: String): NexoForgeItem? {
        return registeredItems[id]
    }

    fun getAllItems(): Collection<NexoForgeItem> {
        return registeredItems.values.toList()
    }

    fun isRegistered(id: String): Boolean {
        return registeredItems.containsKey(id)
    }
}

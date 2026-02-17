package com.pulse.nexoforge.registry

import com.pulse.nexoforge.api.NexoForgeItem
import com.pulse.nexoforge.recipe.RecipeManager
import com.pulse.nexoforge.yaml.YamlWriter

class ItemRegistry(
    private val yamlWriter: YamlWriter,
    private val recipeManager: RecipeManager
) {
    private val registeredItems = mutableMapOf<String, NexoForgeItem>()

    fun registerItem(item: NexoForgeItem, path: String, append: Boolean = false) {
        require(item.id.isNotBlank()) { "Item ID can't be blank" }
        
        registeredItems[item.id] = item
        yamlWriter.writeItem(item, path, append)
        
        if (item.data.containsKey("recipe")) {
            recipeManager.registerRecipe(item)
        }
    }

    fun registerItems(items: Collection<NexoForgeItem>, path: String, append: Boolean = false) {
        items.forEach { item ->
            require(item.id.isNotBlank()) { "Item ID can't be blank" }
            registeredItems[item.id] = item
            
            if (item.data.containsKey("recipe")) {
                recipeManager.registerRecipe(item)
            }
        }
        
        yamlWriter.writeItem(items.toList(), path, append)
    }

    fun registerItems(vararg items: NexoForgeItem, path: String, append: Boolean = false) {
        registerItems(items.toList(), path, append)
    }

    fun getItem(id: String): NexoForgeItem? = registeredItems[id]

    fun getAllItems(): Collection<NexoForgeItem> = registeredItems.values.toList()

    fun isRegistered(id: String): Boolean = registeredItems.containsKey(id)

    fun clear() {
        registeredItems.clear()
    }
}

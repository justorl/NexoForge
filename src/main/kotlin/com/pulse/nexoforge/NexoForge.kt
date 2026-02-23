package com.pulse.nexoforge

import com.pulse.nexoforge.api.NexoForgeItem
import com.pulse.nexoforge.yaml.YamlWriter
import com.pulse.nexoforge.listener.NexoItemsListener
import com.pulse.nexoforge.recipe.RecipeManager
import com.pulse.nexoforge.registry.ItemRegistry
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin

class NexoForge(
    private val plugin: Plugin,
) {
    val recipeManager = RecipeManager(plugin.dataFolder)
    val yamlWriter = YamlWriter(plugin)
    val itemRegistry = ItemRegistry(yamlWriter, recipeManager)

    companion object {
        fun get(): NexoForge? {
            return (Bukkit.getPluginManager().getPlugin("NexoForge") as? NexoForgePlugin)?.nexoForge
        }
    }

    fun registerItem(
        item: NexoForgeItem, 
        path: String, 
        append: Boolean = false,
        recipePath: String = ""
    ) {
        itemRegistry.registerItem(item, path, append, recipePath)
    }

    fun registerItems(
        items: Collection<NexoForgeItem>, 
        path: String, 
        append: Boolean = false,
        recipePath: String = ""
    ) {
        itemRegistry.registerItems(items, path, append, recipePath)
    }

    fun registerItems(
        vararg items: NexoForgeItem, 
        path: String, 
        append: Boolean = false,
        recipePath: String = ""
    ) {
        itemRegistry.registerItems(*items, path = path, append = append, recipePath = recipePath)
    }

    fun getItem(id: String): NexoForgeItem? = itemRegistry.getItem(id)

    fun getAllItems(): Collection<NexoForgeItem> = itemRegistry.getAllItems()

    fun onEnable() {
        Bukkit.getPluginManager().registerEvents(NexoItemsListener(recipeManager), plugin)
    }
}

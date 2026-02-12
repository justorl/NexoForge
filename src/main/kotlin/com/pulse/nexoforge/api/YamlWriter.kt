package com.pulse.nexoforge.api

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import kotlin.collections.component1
import kotlin.collections.component2

class YamlWriter(
    plugin: JavaPlugin,
    val baseDir: File = File(plugin.dataFolder.parentFile, "Nexo/items")
) {
    init {
        if (!baseDir.exists()) baseDir.mkdirs()
    }

    fun writeItem(item: NexoForgeItem, file: File, append: Boolean = false) {
        val yaml = if (append && file.exists()) {
            YamlConfiguration.loadConfiguration(file)
        } else {
            YamlConfiguration()
        }

        item.data.forEach { (key, value) ->
            yaml.set("${item.id}.$key", value)
        }

        yaml.save(file)
    }


    fun writeItem(items: List<NexoForgeItem>, file: File, append: Boolean = false) {
        val yaml = if (append && file.exists()) {
            YamlConfiguration.loadConfiguration(file)
        } else {
            YamlConfiguration()
        }

        items.forEach { item ->
            item.data.forEach { (key, value) ->
                yaml.set("${item.id}.$key", value)
            }
        }

        yaml.save(file)
    }

    fun writeItem(item: NexoForgeItem, path: String, append: Boolean = false) {
        val file = File(baseDir, path)
        file.parentFile?.mkdirs()

        writeItem(item, file, append)
    }

    fun writeItem(items: List<NexoForgeItem>, path: String, append: Boolean = false) {
        val file = File(baseDir, path)
        file.parentFile?.mkdirs()

        writeItem(items, file, append)
    }

    fun writeItem(vararg items: NexoForgeItem, path: String, append: Boolean = false) =
        writeItem(items.toList(), path, append)
}
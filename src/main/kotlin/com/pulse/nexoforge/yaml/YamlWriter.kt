package com.pulse.nexoforge.yaml

import com.pulse.nexoforge.api.NexoForgeItem
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File

class YamlWriter(
    plugin: Plugin,
    val baseDir: File = File(plugin.server.pluginsFolder, "Nexo/items"),
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
            if (key != "recipe") {
                yaml.set("${item.id}.$key", value)
            }
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
                if (key != "recipe") {
                    yaml.set("${item.id}.$key", value)
                }
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
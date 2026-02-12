package com.pulse.nexoforge.api

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class YamlWriter(
    plugin: JavaPlugin,
    val baseDir: File = File(plugin.dataFolder.parentFile, "Nexo/items")
) {
    init {
        if (!baseDir.exists()) baseDir.mkdirs()
    }

    fun writeToFile(items: List<NexoForgeItem>, file: File, append: Boolean = false) {
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

    fun writeToString(item: NexoForgeItem, path: String = "${item.id}.yml", append: Boolean = false) {
        val file = File(baseDir, path)
        file.parentFile?.mkdirs()

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

    fun writeToString(vararg items: NexoForgeItem, path: String = "items.yml", append: Boolean = false) =
        writeToString(items.toList(), path, append)

    fun writeToString(items: List<NexoForgeItem>, path: String = "items.yml", append: Boolean = false) {
        val file = File(baseDir, path)
        file.parentFile?.mkdirs()

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
}
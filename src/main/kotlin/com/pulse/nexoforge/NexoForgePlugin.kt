package com.pulse.nexoforge

import org.bukkit.plugin.java.JavaPlugin

class NexoForgePlugin : JavaPlugin() {
    val nexoForge = NexoForge(this)

    override fun onEnable() {
        nexoForge.onEnable()
    }
}

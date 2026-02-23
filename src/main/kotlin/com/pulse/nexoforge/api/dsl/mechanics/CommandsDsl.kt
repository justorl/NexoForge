package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class CommandsDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun cooldown(seconds: Int) {
        data["cooldown"] = seconds
    }

    fun permission(perm: String) {
        data["permission"] = perm
    }

    fun oneUsage(value: Boolean = true) {
        data["one_usage"] = value
    }

    fun console(vararg commands: String) {
        data["console"] = commands.toList()
    }

    fun console(commands: List<String>) {
        data["console"] = commands
    }

    fun player(vararg commands: String) {
        data["player"] = commands.toList()
    }

    fun player(commands: List<String>) {
        data["player"] = commands
    }

    fun oppedPlayer(vararg commands: String) {
        data["opped_player"] = commands.toList()
    }

    fun oppedPlayer(commands: List<String>) {
        data["opped_player"] = commands
    }

    override fun build(): Map<String, Any> = data
}
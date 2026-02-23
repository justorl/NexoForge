package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder
import org.bukkit.Material

class BackpackDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun rows(value: Int) {
        data["rows"] = value
    }

    fun title(value: String) {
        data["title"] = value
    }

    fun openSound(value: String) {
        data["open_sound"] = value
    }

    fun closeSound(value: String) {
        data["close_sound"] = value
    }

    fun blacklist(block: BlacklistDsl.() -> Unit) {
        data["blacklist"] = BlacklistDsl().apply(block).build()
    }

    override fun build(): Map<String, Any> = data

    class BlacklistDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun nexoItems(vararg items: String) {
            data["nexo_items"] = items.toList()
        }

        fun nexoItems(items: List<String>) {
            data["nexo_items"] = items
        }

        fun materials(vararg materials: Material) {
            data["materials"] = materials.map { it.name }
        }

        fun materials(materials: List<Material>) {
            data["materials"] = materials.map { it.name }
        }

        override fun build(): Map<String, Any> = data
    }
}
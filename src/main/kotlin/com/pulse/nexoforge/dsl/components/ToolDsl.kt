package com.pulse.nexoforge.dsl.components

import com.pulse.nexoforge.dsl.SingleDslBuilder

class ToolDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private val rules = mutableListOf<Map<String, Any>>()

    fun damagePerBlock(value: Int) {
        data["damage_per_block"] = value
    }

    fun defaultMiningSpeed(speed: Double) {
        data["default_mining_speed"] = speed
    }

    fun rule(block: ToolRuleDsl.() -> Unit) {
        rules.add(ToolRuleDsl().apply(block).build())
    }

    override fun build(): Map<String, Any> {
        if (rules.isNotEmpty()) {
            data["rules"] = rules
        }
        return data
    }
}

class ToolRuleDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun speed(value: Double) {
        data["speed"] = value
    }

    fun correctForDrops(value: Boolean = true) {
        data["correct_for_drops"] = value
    }

    fun material(material: String) {
        data["material"] = material
    }

    fun materials(vararg materials: String) {
        data["materials"] = materials.toList()
    }

    fun tag(tag: String) {
        data["tag"] = tag
    }

    fun tags(vararg tags: String) {
        data["tags"] = tags.toList()
    }

    override fun build(): Map<String, Any> = data
}

package com.pulse.nexoforge.dsl.components

import com.pulse.nexoforge.dsl.SingleDslBuilder

class UseCooldownDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun seconds(value: Double) {
        data["seconds"] = value
    }

    fun group(group: String) {
        data["group"] = group
    }

    override fun build(): Map<String, Any> = data
}
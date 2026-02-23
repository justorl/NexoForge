package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class HarvestingDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun cooldown(milliseconds: Long) {
        data["cooldown"] = milliseconds
    }

    fun radius(value: Int) {
        data["radius"] = value
    }

    fun height(value: Int) {
        data["height"] = value
    }

    override fun build(): Map<String, Any> = data
}
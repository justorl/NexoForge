package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class SoulboundDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun loseChance(value: Double) {
        data["lose_chance"] = value
    }

    override fun build(): Map<String, Any> = data
}
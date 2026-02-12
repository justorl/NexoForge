package com.pulse.nexoforge.dsl.components

import com.pulse.nexoforge.dsl.SingleDslBuilder
import com.pulse.nexoforge.dsl.item.ItemReferenceDsl
import com.pulse.nexoforge.dsl.item.PotionEffectDsl

class FoodDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private val effects = mutableMapOf<String, Map<String, Any>>()

    fun nutrition(value: Int) {
        data["nutrition"] = value
    }

    fun saturation(value: Double) {
        data["saturation"] = value
    }

    fun canAlwaysEat(value: Boolean = false) {
        data["can_always_eat"] = value
    }

    fun eatSeconds(seconds: Double) {
        data["eat_seconds"] = seconds
    }

    fun replacement(block: ItemReferenceDsl.() -> Unit) {
        data["replacement"] = ItemReferenceDsl().apply(block).build()
    }

    fun effect(name: String, block: PotionEffectDsl.() -> Unit) {
        effects[name] = PotionEffectDsl().apply(block).build()
    }

    override fun build(): Map<String, Any> {
        if (effects.isNotEmpty()) {
            data["effects"] = effects
        }
        return data
    }
}

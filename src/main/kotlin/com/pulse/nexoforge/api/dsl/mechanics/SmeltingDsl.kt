package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class SmeltingDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun enabled(value: Boolean = true) {
        data["enabled"] = value
    }

    fun playSound(value: Boolean = true) {
        data["play_sound"] = value
    }

    override fun build(): Map<String, Any> = data
}
package com.pulse.nexoforge.dsl.item

import com.pulse.nexoforge.dsl.SingleDslBuilder

class PotionEffectDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun duration(value: String) {
        data["duration"] = value
    }

    fun amplifier(value: Int) {
        data["amplifier"] = value
    }

    fun ambient(value: Boolean) {
        data["ambient"] = value
    }

    fun showIcon(value: Boolean) {
        data["show_icon"] = value
    }

    fun showParticles(value: Boolean) {
        data["show_particles"] = value
    }

    fun probability(value: Double) {
        data["probability"] = value
    }

    override fun build(): Map<String, Any> = data
}
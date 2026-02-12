package com.pulse.nexoforge.dsl.components

import com.pulse.nexoforge.dsl.SingleDslBuilder

class ConsumableDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private val effects = mutableMapOf<String, Any>()
    private val applyEffects = mutableMapOf<String, Map<String, Any>>()

    fun sound(sound: String) {
        data["sound"] = sound
    }

    fun consumeParticles(value: Boolean = true) {
        data["consume_particles"] = value
    }

    fun consumeSeconds(seconds: Double) {
        data["consume_seconds"] = seconds
    }

    fun animation(type: String) {
        data["animation"] = type
    }

    fun effectApply(
        name: String,
        duration: String,
        amplifier: Int = 0,
        ambient: Boolean = false,
        showIcon: Boolean = true,
        showParticles: Boolean = true,
        probability: Double = 1.0
    ) {
        applyEffects[name] = mapOf(
            "duration" to duration,
            "amplifier" to amplifier,
            "ambient" to ambient,
            "show_icon" to showIcon,
            "show_particles" to showParticles,
            "probability" to probability
        )
    }

    fun effectRemove(vararg effects: String) {
        this.effects["REMOVE_EFFECTS"] = effects.toList()
    }

    fun clearEffects() {
        effects["CLEAR_ALL_EFFECTS"] = emptyMap<String, Any>()
    }

    fun teleportRandomly(diameter: Double) {
        effects["TELEPORT_RANDOMLY"] = mapOf("diameter" to diameter)
    }

    fun playSound(sound: String) {
        effects["PLAY_SOUND"] = mapOf("sound" to sound)
    }

    override fun build(): Map<String, Any> {
        if (applyEffects.isNotEmpty()) {
            effects["APPLY_EFFECTS"] = applyEffects
        }
        if (effects.isNotEmpty()) {
            data["effects"] = effects
        }
        return data
    }
}

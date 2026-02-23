package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class MiscDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun breaksFromCactus(value: Boolean = true) {
        data["breaks_from_cactus"] = value
    }

    fun burnsInFire(value: Boolean = true) {
        data["burns_in_fire"] = value
    }

    fun burnsInLava(value: Boolean = true) {
        data["burns_in_lava"] = value
    }

    fun disableVanillaInteractions(value: Boolean = false) {
        data["disable_vanilla_interactions"] = value
    }

    fun canStripLogs(value: Boolean = false) {
        data["can_strip_logs"] = value
    }

    fun piglinsIgnoreWhenEquipped(value: Boolean = false) {
        data["piglins_ignore_when_equipped"] = value
    }

    fun compostable(value: Boolean = false) {
        data["compostable"] = value
    }

    fun allowInVanillaRecipes(value: Boolean = true) {
        data["allow_in_vanilla_recipes"] = value
    }

    override fun build(): Map<String, Any> = data
}
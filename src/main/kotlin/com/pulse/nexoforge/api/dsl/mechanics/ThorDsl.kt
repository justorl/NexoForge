package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class ThorDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun lightningBoltsAmount(value: Int) {
        data["lightning_bolts_amount"] = value
    }

    fun randomLocationVariation(value: Double) {
        data["random_location_variation"] = value
    }

    fun delay(milliseconds: Long) {
        data["delay"] = milliseconds
    }

    override fun build(): Map<String, Any> = data
}
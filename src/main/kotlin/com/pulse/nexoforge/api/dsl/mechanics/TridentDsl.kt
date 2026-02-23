package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class TridentDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun displayTransform(value: String) {
        data["display_transform"] = value
    }

    override fun build(): Map<String, Any> = data
}
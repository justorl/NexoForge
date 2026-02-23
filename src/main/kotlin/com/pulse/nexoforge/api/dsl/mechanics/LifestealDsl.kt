package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class LifestealDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun amount(value: Int) {
        data["amount"] = value
    }

    override fun build(): Map<String, Any> = data
}
package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class WitherskullDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun charged(value: Boolean = false) {
        data["charged"] = value
    }

    fun delay(milliseconds: Long) {
        data["delay"] = milliseconds
    }

    override fun build(): Map<String, Any> = data
}
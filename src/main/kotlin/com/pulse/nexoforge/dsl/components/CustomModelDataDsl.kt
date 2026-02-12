package com.pulse.nexoforge.dsl.components

import com.pulse.nexoforge.dsl.SingleDslBuilder

class CustomModelDataDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun floats(vararg values: Float) {
        data["floats"] = values.toList()
    }

    fun colors(vararg values: Any) {
        data["colors"] = values.toList()
    }

    fun strings(vararg values: String) {
        data["strings"] = values.toList()
    }

    fun flags(vararg values: String) {
        data["flags"] = values.toList()
    }

    override fun build(): Map<String, Any> = data
}

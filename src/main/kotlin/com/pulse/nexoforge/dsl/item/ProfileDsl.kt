package com.pulse.nexoforge.dsl.item

import com.pulse.nexoforge.dsl.SingleDslBuilder

class ProfileDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun name(name: String) {
        data["name"] = name
    }

    fun uuid(uuid: String) {
        data["uuid"] = uuid
    }

    fun properties(name: String, value: String, signature: String? = null) {
        val props = mutableMapOf<String, Any>(
            "name" to name,
            "value" to value
        )
        signature?.let { props["signature"] = it }
        data["properties"] = props
    }

    override fun build(): Map<String, Any> = data
}
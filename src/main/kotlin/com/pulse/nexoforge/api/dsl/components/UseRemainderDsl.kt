package com.pulse.nexoforge.api.dsl.components

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class UseRemainderDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun nexoItem(id: String) {
        data["nexo_item"] = id
    }

    fun minecraftType(type: String) {
        data["minecraft_type"] = type
    }

    override fun build(): Map<String, Any> = data
}

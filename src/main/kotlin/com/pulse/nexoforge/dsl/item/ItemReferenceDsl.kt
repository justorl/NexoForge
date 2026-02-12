package com.pulse.nexoforge.dsl.item

import com.pulse.nexoforge.dsl.SingleDslBuilder

class ItemReferenceDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun nexoItem(id: String) {
        data["nexo_item"] = id
    }

    fun minecraftType(type: String) {
        data["minecraft_type"] = type
    }

    override fun build(): Map<String, Any> = data
}

class UseRemainderDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun nexoItem(id: String) {
        data["nexo_item"] = id
    }

    override fun build(): Map<String, Any> = data
}

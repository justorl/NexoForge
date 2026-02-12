package com.pulse.nexoforge.dsl.components

import com.pulse.nexoforge.dsl.SingleDslBuilder

class CustomDataDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun string(key: String, value: String) {
        data["$key:string"] = value
    }

    fun int(key: String, value: Int) {
        data["$key:integer"] = value
    }

    fun intList(key: String, values: List<Int>) {
        data["$key:integer_list"] = values
    }

    fun stringList(key: String, values: List<String>) {
        data["$key:string_list"] = values
    }

    fun boolean(key: String, value: Boolean) {
        data["$key:boolean"] = value
    }

    fun compound(key: String, block: CustomDataDsl.() -> Unit) {
        data["$key:compound"] = CustomDataDsl().apply(block).build()
    }

    override fun build(): Map<String, Any> = data
}

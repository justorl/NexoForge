package com.pulse.nexoforge.dsl.item

import com.pulse.nexoforge.dsl.ListDslBuilder

class PersistentDataDsl : ListDslBuilder {
    private val entries = mutableListOf<Map<String, Any>>()

    fun entry(type: String, key: String, value: Any) {
        entries.add(mapOf(
            "type" to type,
            "key" to key,
            "value" to value
        ))
    }

    fun string(key: String, value: String) = entry("STRING", key, value)
    fun int(key: String, value: Int) = entry("INTEGER", key, value)
    fun double(key: String, value: Double) = entry("DOUBLE", key, value)
    fun boolean(key: String, value: Boolean) = entry("BOOLEAN", key, value)

    override fun build(): List<Map<String, Any>> = entries
}
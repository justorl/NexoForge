package com.pulse.nexoforge.dsl.item

import com.pulse.nexoforge.dsl.ListDslBuilder
import com.pulse.nexoforge.dsl.SingleDslBuilder
import org.bukkit.attribute.Attribute

class AttributeModifiersDsl : ListDslBuilder {
    private val modifiers = mutableListOf<Map<String, Any>>()

    fun attribute(attribute: Attribute, block: AttributeModifierDsl.() -> Unit) {
        modifiers.add(AttributeModifierDsl(attribute).apply(block).build())
    }

    override fun build(): List<Map<String, Any>> = modifiers
}

class AttributeModifierDsl(private val attribute: Attribute) : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    init {
        data["attribute"] = attribute.key.key
    }

    fun amount(value: Double) {
        data["amount"] = value
    }

    fun operation(op: Int) {
        data["operation"] = op
    }

    fun slot(slot: String) {
        data["slot"] = slot
    }

    override fun build(): Map<String, Any> = data
}

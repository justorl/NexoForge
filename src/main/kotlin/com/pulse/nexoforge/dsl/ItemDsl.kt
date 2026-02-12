package com.pulse.nexoforge.dsl

import com.pulse.nexoforge.api.NexoForgeItem
import com.pulse.nexoforge.dsl.components.ComponentsDsl
import com.pulse.nexoforge.dsl.item.AttributeModifiersDsl
import com.pulse.nexoforge.dsl.item.EnchantmentsDsl
import com.pulse.nexoforge.dsl.item.ItemFlagsDsl
import com.pulse.nexoforge.dsl.item.PackDsl
import com.pulse.nexoforge.dsl.item.PersistentDataDsl
import org.bukkit.Material

fun nexoItem(id: String, block: ItemDsl.() -> Unit): NexoForgeItem {
    return ItemDsl(id).apply(block).build()
}

class ItemDsl(private val id: String) {
    private val data = mutableMapOf<String, Any>()
    private val components = mutableMapOf<String, Any>()

    fun material(mat: Material) {
        data["material"] = mat.name
    }

    fun itemName(name: String) {
        data["itemname"] = name
    }

    fun lore(vararg lines: String) {
        data["lore"] = lines.toList()
    }

    fun lore(lines: List<String>) {
        data["lore"] = lines
    }

    fun template(id: String) {
        data["template"] = id
    }

    fun templates(vararg ids: String) {
        data["templates"] = ids.toList()
    }

    fun excludeFromInventory(value: Boolean = true) {
        data["excludeFromInventory"] = value
    }

    fun unbreakable(value: Boolean = true) {
        data["unbreakable"] = value
    }

    fun color(r: Int, g: Int, b: Int) {
        data["color"] = "$r, $g, $b"
    }

    fun disableEnchanting(value: Boolean = true) {
        data["disable_enchanting"] = value
    }

    fun itemFlags(block: ItemFlagsDsl.() -> Unit) {
        data["ItemFlags"] = ItemFlagsDsl().apply(block).build()
    }

    fun persistentData(block: PersistentDataDsl.() -> Unit) {
        data["PersistentData"] = PersistentDataDsl().apply(block).build()
    }

    fun enchantments(block: EnchantmentsDsl.() -> Unit) {
        data["Enchantments"] = EnchantmentsDsl().apply(block).build()
    }

    fun attributeModifiers(block: AttributeModifiersDsl.() -> Unit) {
        data["AttributeModifiers"] = AttributeModifiersDsl().apply(block).build()
    }

    fun components(block: ComponentsDsl.() -> Unit) {
        components.putAll(ComponentsDsl().apply(block).build())
        data["Components"] = components
    }

    fun pack(block: PackDsl.() -> Unit) {
        data["Pack"] = PackDsl().apply(block).build()
    }

    fun build() = NexoForgeItem(id, data)
}

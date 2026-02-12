package com.pulse.nexoforge.dsl.item

import org.bukkit.inventory.ItemFlag

class ItemFlagsDsl {
    private val flags = mutableSetOf<ItemFlag>()

    fun hideEnchants() {
        flags.add(ItemFlag.HIDE_ENCHANTS)
    }

    fun hideAttributes() {
        flags.add(ItemFlag.HIDE_ATTRIBUTES)
    }

    fun hideUnbreakable() {
        flags.add(ItemFlag.HIDE_UNBREAKABLE)
    }

    fun hideDestroys() {
        flags.add(ItemFlag.HIDE_DESTROYS)
    }

    fun hidePlacedOn() {
        flags.add(ItemFlag.HIDE_PLACED_ON)
    }

    fun hideAdditionalTooltip() {
        flags.add(ItemFlag.HIDE_ADDITIONAL_TOOLTIP)
    }

    fun hideDye() {
        flags.add(ItemFlag.HIDE_DYE)
    }

    fun hideArmorTrim() {
        flags.add(ItemFlag.HIDE_ARMOR_TRIM)
    }

    fun hideStoredEnchants() {
        flags.add(ItemFlag.HIDE_STORED_ENCHANTS)
    }

    fun add(flag: ItemFlag) {
        flags.add(flag)
    }

    fun addAll(vararg itemFlags: ItemFlag) {
        flags.addAll(itemFlags)
    }

    fun build(): List<String> = flags.map { it.name }
}

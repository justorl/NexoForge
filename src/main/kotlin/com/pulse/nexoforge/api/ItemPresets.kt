package com.pulse.nexoforge.api

import com.pulse.nexoforge.dsl.ItemDsl
import com.pulse.nexoforge.dsl.item.EnchantmentsDsl
import com.pulse.nexoforge.dsl.nexoItem

object ItemPresets {

    fun basicFood(
        id: String,
        name: String,
        nutrition: Int,
        saturation: Double,
        block: ItemDsl.() -> Unit = {}
    ) = nexoItem(id) {
        itemName(name)
        components {
            food {
                nutrition(nutrition)
                saturation(saturation)
            }
        }
        block()
    }

    fun basicTool(
        id: String,
        name: String,
        durability: Int,
        miningSpeed: Double,
        block: ItemDsl.() -> Unit = {}
    ) = nexoItem(id) {
        itemName(name)
        components {
            maxDamage(durability)
            tool {
                defaultMiningSpeed(miningSpeed)
            }
        }
        block()
    }

    fun basicWeapon(
        id: String,
        name: String,
        durability: Int,
        damage: Int,
        block: ItemDsl.() -> Unit = {}
    ) = nexoItem(id) {
        itemName(name)
        components {
            maxDamage(durability)
            weapon {
                damagePerAttack(damage)
            }
        }
        block()
    }

    fun basicArmor(
        id: String,
        name: String,
        slot: String,
        durability: Int,
        block: ItemDsl.() -> Unit = {}
    ) = nexoItem(id) {
        itemName(name)
        components {
            maxDamage(durability)
            equippable {
                slot(slot)
            }
        }
        block()
    }
}
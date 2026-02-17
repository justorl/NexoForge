package com.pulse.nexoforge.api.dsl.item

import com.pulse.nexoforge.api.NexoForgeItem
import com.pulse.nexoforge.api.dsl.SingleDslBuilder
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RecipeDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun shaped(block: ShapedRecipeDsl.() -> Unit) {
        data.putAll(ShapedRecipeDsl().apply(block).build())
        data["type"] = "shaped"
    }

    fun shapeless(block: ShapelessRecipeDsl.() -> Unit) {
        data.putAll(ShapelessRecipeDsl().apply(block).build())
        data["type"] = "shapeless"
    }

    fun furnace(block: FurnaceRecipeDsl.() -> Unit) {
        data.putAll(FurnaceRecipeDsl().apply(block).build())
        data["type"] = "furnace"
    }

    fun blasting(block: FurnaceRecipeDsl.() -> Unit) {
        data.putAll(FurnaceRecipeDsl().apply(block).build())
        data["type"] = "blasting"
    }

    fun smoking(block: FurnaceRecipeDsl.() -> Unit) {
        data.putAll(FurnaceRecipeDsl().apply(block).build())
        data["type"] = "smoking"
    }

    fun campfire(block: FurnaceRecipeDsl.() -> Unit) {
        data.putAll(FurnaceRecipeDsl().apply(block).build())
        data["type"] = "campfire"
    }

    override fun build(): Map<String, Any> = data
}

class ShapedRecipeDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private val ingredients = mutableMapOf<Char, Any>()

    fun shape(vararg rows: String) {
        data["shape"] = rows.toList()
    }

    fun ingredient(key: Char, material: Material) {
        ingredients[key] = material
    }

    fun ingredient(key: Char, item: NexoForgeItem) {
        ingredients[key] = item
    }

    fun ingredient(key: Char, itemStack: ItemStack) {
        ingredients[key] = itemStack
    }

    fun amount(count: Int) {
        data["amount"] = count
    }

    override fun build(): Map<String, Any> {
        data["ingredients"] = ingredients
        return data
    }
}

class ShapelessRecipeDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private val ingredients = mutableListOf<Any>()

    fun ingredient(material: Material, count: Int = 1) {
        repeat(count) {
            ingredients.add(material)
        }
    }

    fun ingredient(item: NexoForgeItem, count: Int = 1) {
        repeat(count) {
            ingredients.add(item)
        }
    }

    fun ingredient(itemStack: ItemStack, count: Int = 1) {
        repeat(count) {
            ingredients.add(itemStack)
        }
    }

    fun amount(count: Int) {
        data["amount"] = count
    }

    override fun build(): Map<String, Any> {
        data["ingredients"] = ingredients
        return data
    }
}

class FurnaceRecipeDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun ingredient(material: Material) {
        data["ingredient"] = material
    }

    fun ingredient(item: NexoForgeItem) {
        data["ingredient"] = item
    }

    fun ingredient(itemStack: ItemStack) {
        data["ingredient"] = itemStack
    }

    fun experience(exp: Float) {
        data["experience"] = exp
    }

    fun cookingTime(ticks: Int) {
        data["cookingTime"] = ticks
    }

    fun amount(count: Int) {
        data["amount"] = count
    }

    override fun build(): Map<String, Any> = data
}

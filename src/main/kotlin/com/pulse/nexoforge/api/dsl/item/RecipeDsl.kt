package com.pulse.nexoforge.api.dsl.item

import com.pulse.nexoforge.api.NexoForgeItem
import com.pulse.nexoforge.api.dsl.SingleDslBuilder
import org.bukkit.Material

class RecipeDsl(private val itemId: String) : SingleDslBuilder {
    private val recipes = mutableListOf<Map<String, Any>>()

    fun shaped(block: ShapedRecipeDsl.() -> Unit) {
        recipes.add(ShapedRecipeDsl(itemId, "shaped").apply(block).build())
    }

    fun shapeless(block: ShapelessRecipeDsl.() -> Unit) {
        recipes.add(ShapelessRecipeDsl(itemId, "shapeless").apply(block).build())
    }

    fun furnace(block: CookingRecipeDsl.() -> Unit) {
        recipes.add(CookingRecipeDsl(itemId, "furnace").apply(block).build())
    }

    fun blasting(block: CookingRecipeDsl.() -> Unit) {
        recipes.add(CookingRecipeDsl(itemId, "blasting").apply(block).build())
    }

    fun smoking(block: CookingRecipeDsl.() -> Unit) {
        recipes.add(CookingRecipeDsl(itemId, "smoking").apply(block).build())
    }

    fun stonecutting(block: StonecuttingRecipeDsl.() -> Unit) {
        recipes.add(StonecuttingRecipeDsl(itemId, "stonecutting").apply(block).build())
    }

    fun brewing(block: BrewingRecipeDsl.() -> Unit) {
        recipes.add(BrewingRecipeDsl(itemId, "brewing").apply(block).build())
    }

    fun smithing(block: SmithingRecipeDsl.() -> Unit) {
        recipes.add(SmithingRecipeDsl(itemId, "smithing").apply(block).build())
    }

    override fun build(): Map<String, Any> = mapOf("recipes" to recipes)
}

class ShapedRecipeDsl(private val defaultItemId: String, private val type: String) : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private val ingredients = mutableMapOf<String, Any>()
    private var resultSet = false

    init {
        data["type"] = type
    }

    fun result(nexoItem: String, amount: Int = 1) {
        data["result"] = mapOf(
            "nexo_item" to nexoItem,
            "amount" to amount
        )
        resultSet = true
    }

    fun result(material: Material, amount: Int = 1) {
        data["result"] = mapOf(
            "minecraft_type" to material.name,
            "amount" to amount
        )
        resultSet = true
    }

    fun shape(vararg rows: String) {
        data["shape"] = rows.toList()
    }

    fun ingredient(key: String, material: Material) {
        ingredients[key] = mapOf("minecraft_type" to material.name)
    }

    fun ingredient(key: String, nexoItem: NexoForgeItem) {
        ingredients[key] = mapOf("nexo_item" to nexoItem.id)
    }

    fun ingredientNexo(key: String, nexoItem: String) {
        ingredients[key] = mapOf("nexo_item" to nexoItem)
    }

    fun ingredient(key: String, tag: String) {
        ingredients[key] = mapOf("tag" to tag)
    }

    override fun build(): Map<String, Any> {
        if (!resultSet) {
            data["result"] = mapOf(
                "nexo_item" to defaultItemId,
                "amount" to 1
            )
        }
        data["ingredients"] = ingredients
        return data
    }
}

class ShapelessRecipeDsl(private val defaultItemId: String, private val type: String) : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private val ingredients = mutableMapOf<String, Any>()
    private var resultSet = false

    init {
        data["type"] = type
    }

    fun result(nexoItem: String, amount: Int = 1) {
        data["result"] = mapOf(
            "nexo_item" to nexoItem,
            "amount" to amount
        )
        resultSet = true
    }

    fun result(material: Material, amount: Int = 1) {
        data["result"] = mapOf(
            "minecraft_type" to material.name,
            "amount" to amount
        )
        resultSet = true
    }

    fun ingredient(key: String, material: Material) {
        ingredients[key] = mapOf("minecraft_type" to material.name)
    }

    fun ingredient(key: String, nexoItem: NexoForgeItem) {
        ingredients[key] = mapOf("nexo_item" to nexoItem.id)
    }

    fun ingredientNexo(key: String, nexoItem: String) {
        ingredients[key] = mapOf("nexo_item" to nexoItem)
    }

    fun ingredient(key: String, tag: String) {
        ingredients[key] = mapOf("tag" to tag)
    }

    override fun build(): Map<String, Any> {
        if (!resultSet) {
            data["result"] = mapOf(
                "nexo_item" to defaultItemId,
                "amount" to 1
            )
        }
        data["ingredients"] = ingredients
        return data
    }
}

class CookingRecipeDsl(private val defaultItemId: String, private val type: String) : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private var resultSet = false

    init {
        data["type"] = type
    }

    fun result(nexoItem: String, amount: Int = 1) {
        data["result"] = mapOf(
            "nexo_item" to nexoItem,
            "amount" to amount
        )
        resultSet = true
    }

    fun result(material: Material, amount: Int = 1) {
        data["result"] = mapOf(
            "minecraft_type" to material.name,
            "amount" to amount
        )
        resultSet = true
    }

    fun input(material: Material) {
        data["input"] = mapOf("minecraft_type" to material.name)
    }

    fun inputNexo(nexoItem: NexoForgeItem) {
        data["input"] = mapOf("nexo_item" to nexoItem.id)
    }

    fun inputNexo(nexoItem: String) {
        data["input"] = mapOf("nexo_item" to nexoItem)
    }

    fun input(tag: String) {
        data["input"] = mapOf("tag" to tag)
    }

    fun experience(exp: Float) {
        data["experience"] = exp
    }

    fun cookingTime(ticks: Int) {
        data["cookingTime"] = ticks
    }

    override fun build(): Map<String, Any> {
        if (!resultSet) {
            data["result"] = mapOf(
                "nexo_item" to defaultItemId,
                "amount" to 1
            )
        }
        return data
    }
}

class StonecuttingRecipeDsl(private val defaultItemId: String, private val type: String) : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private var resultSet = false

    init {
        data["type"] = type
    }

    fun result(nexoItem: String, amount: Int = 1) {
        data["result"] = mapOf(
            "nexo_item" to nexoItem,
            "amount" to amount
        )
        resultSet = true
    }

    fun result(material: Material, amount: Int = 1) {
        data["result"] = mapOf(
            "minecraft_type" to material.name,
            "amount" to amount
        )
        resultSet = true
    }

    fun input(material: Material) {
        data["input"] = mapOf("minecraft_type" to material.name)
    }

    fun input(nexoItem: NexoForgeItem) {
        data["input"] = mapOf("nexo_item" to nexoItem.id)
    }

    fun inputNexo(nexoItem: String) {
        data["input"] = mapOf("nexo_item" to nexoItem)
    }

    fun input(tag: String) {
        data["input"] = mapOf("tag" to tag)
    }

    override fun build(): Map<String, Any> {
        if (!resultSet) {
            data["result"] = mapOf(
                "nexo_item" to defaultItemId,
                "amount" to 1
            )
        }
        return data
    }
}

class BrewingRecipeDsl(private val defaultItemId: String, private val type: String) : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private var resultSet = false

    init {
        data["type"] = type
    }

    fun result(nexoItem: String, amount: Int = 1) {
        data["result"] = mapOf(
            "nexo_item" to nexoItem,
            "amount" to amount
        )
        resultSet = true
    }

    fun result(material: Material, amount: Int = 1) {
        data["result"] = mapOf(
            "minecraft_type" to material.name,
            "amount" to amount
        )
        resultSet = true
    }

    fun input(material: Material) {
        data["input"] = mapOf("minecraft_type" to material.name)
    }

    fun input(nexoItem: String) {
        data["input"] = mapOf("nexo_item" to nexoItem)
    }

    fun ingredient(material: Material) {
        data["ingredient"] = mapOf("minecraft_type" to material.name)
    }

    fun ingredient(nexoItem: String) {
        data["ingredient"] = mapOf("nexo_item" to nexoItem)
    }

    override fun build(): Map<String, Any> {
        if (!resultSet) {
            data["result"] = mapOf(
                "nexo_item" to defaultItemId,
                "amount" to 1
            )
        }
        return data
    }
}

class SmithingRecipeDsl(private val defaultItemId: String, private val type: String) : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private var resultSet = false

    init {
        data["type"] = type
    }

    fun result(nexoItem: String, amount: Int = 1) {
        data["result"] = mapOf(
            "nexo_item" to nexoItem,
            "amount" to amount
        )
        resultSet = true
    }

    fun result(material: Material, amount: Int = 1) {
        data["result"] = mapOf(
            "minecraft_type" to material.name,
            "amount" to amount
        )
        resultSet = true
    }

    fun template(material: Material) {
        data["template"] = mapOf("minecraft_type" to material.name)
    }

    fun template(nexoItem: String) {
        data["template"] = mapOf("nexo_item" to nexoItem)
    }

    fun base(material: Material) {
        data["base"] = mapOf("minecraft_type" to material.name)
    }

    fun base(nexoItem: String) {
        data["base"] = mapOf("nexo_item" to nexoItem)
    }

    fun addition(material: Material) {
        data["addition"] = mapOf("minecraft_type" to material.name)
    }

    fun addition(nexoItem: String) {
        data["addition"] = mapOf("nexo_item" to nexoItem)
    }

    override fun build(): Map<String, Any> {
        if (!resultSet) {
            data["result"] = mapOf(
                "nexo_item" to defaultItemId,
                "amount" to 1
            )
        }
        return data
    }
}

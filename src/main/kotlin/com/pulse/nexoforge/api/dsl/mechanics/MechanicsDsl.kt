package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder

class MechanicsDsl : SingleDslBuilder {
    private val mechanics = mutableMapOf<String, Any>()

    fun backpack(block: BackpackDsl.() -> Unit) {
        mechanics["backpack"] = BackpackDsl().apply(block).build()
    }

    fun misc(block: MiscDsl.() -> Unit) {
        mechanics["misc"] = MiscDsl().apply(block).build()
    }

    fun commands(block: CommandsDsl.() -> Unit) {
        mechanics["commands"] = CommandsDsl().apply(block).build()
    }

    fun armorEffects(block: ArmorEffectsDsl.() -> Unit) {
        mechanics["armor_effects"] = ArmorEffectsDsl().apply(block).build()
    }

    fun itemType(value: String) {
        mechanics["itemtype"] = mapOf("value" to value)
    }

    fun soulbound(block: SoulboundDsl.() -> Unit) {
        mechanics["soulbound"] = SoulboundDsl().apply(block).build()
    }

    fun thor(block: ThorDsl.() -> Unit) {
        mechanics["thor"] = ThorDsl().apply(block).build()
    }

    fun lifesteal(block: LifestealDsl.() -> Unit) {
        mechanics["lifesteal"] = LifestealDsl().apply(block).build()
    }

    fun energyBlast(block: EnergyBlastDsl.() -> Unit) {
        mechanics["energyblast"] = EnergyBlastDsl().apply(block).build()
    }

    fun witherskull(block: WitherskullDsl.() -> Unit) {
        mechanics["witherskull"] = WitherskullDsl().apply(block).build()
    }

    fun harvesting(block: HarvestingDsl.() -> Unit) {
        mechanics["harvesting"] = HarvestingDsl().apply(block).build()
    }

    fun smelting(block: SmeltingDsl.() -> Unit) {
        mechanics["smelting"] = SmeltingDsl().apply(block).build()
    }

    fun trident(block: TridentDsl.() -> Unit) {
        mechanics["trident"] = TridentDsl().apply(block).build()
    }

    fun customBlock(block: CustomBlockDsl.() -> Unit) {
        mechanics["custom_block"] = CustomBlockDsl().apply(block).build()
    }

    fun furniture(block: FurnitureDsl.() -> Unit) {
        mechanics["furniture"] = FurnitureDsl().apply(block).build()
    }

    override fun build(): Map<String, Any> = mechanics
}
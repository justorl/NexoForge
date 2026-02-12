package com.pulse.nexoforge.dsl.components

import com.pulse.nexoforge.dsl.SingleDslBuilder
import com.pulse.nexoforge.dsl.item.*

class ComponentsDsl : SingleDslBuilder {
    private val components = mutableMapOf<String, Any>()

    fun maxStackSize(value: Int) {
        components["max_stack_size"] = value
    }

    fun enchantmentGlintOverride(value: Boolean = true) {
        components["enchantment_glint_override"] = value
    }

    fun fireResistant(value: Boolean = true) {
        components["fire_resistant"] = value
    }

    fun maxDamage(value: Int) {
        components["max_damage"] = value
    }

    fun hideTooltip(value: Boolean = true) {
        components["hide_tooltip"] = value
    }

    fun itemModel(key: String) {
        components["item_model"] = key
    }

    fun customModelData(block: CustomModelDataDsl.() -> Unit) {
        components["custom_model_data"] = CustomModelDataDsl().apply(block).build()
    }

    fun food(block: FoodDsl.() -> Unit) {
        components["food"] = FoodDsl().apply(block).build()
    }

    fun tool(block: ToolDsl.() -> Unit) {
        components["tool"] = ToolDsl().apply(block).build()
    }

    fun consumable(block: ConsumableDsl.() -> Unit) {
        components["consumable"] = ConsumableDsl().apply(block).build()
    }

    fun equippable(block: EquippableDsl.() -> Unit) {
        components["equippable"] = EquippableDsl().apply(block).build()
    }

    fun damageResistant(damageType: String) {
        components["damage_resistant"] = damageType
    }

    fun enchantable(value: Int) {
        components["enchantable"] = value
    }

    fun glider(value: Boolean = true) {
        components["glider"] = value
    }

    fun tooltipStyle(key: String) {
        components["tooltip_style"] = key
    }

    fun useCooldown(block: UseCooldownDsl.() -> Unit) {
        components["use_cooldown"] = UseCooldownDsl().apply(block).build()
    }

    fun useRemainder(block: UseRemainderDsl.() -> Unit) {
        components["use_remainder"] = UseRemainderDsl().apply(block).build()
    }

    fun repairable(material: String) {
        components["repairable"] = material
    }

    fun repairable(materials: List<String>) {
        components["repairable"] = materials
    }

    fun deathProtection(block: DeathProtectionDsl.() -> Unit) {
        components["death_protection"] = DeathProtectionDsl().apply(block).build()
    }

    fun profile(block: ProfileDsl.() -> Unit) {
        components["profile"] = ProfileDsl().apply(block).build()
    }

    fun unsetComponents(vararg components: String) {
        this.components["unset_components"] = components.toList()
    }

    fun tooltipDisplay(vararg components: String) {
        this.components["tooltip_display"] = components.toList()
    }

    fun customData(block: CustomDataDsl.() -> Unit) {
        components["custom_data"] = CustomDataDsl().apply(block).build()
    }

    fun jukeboxPlayable(songKey: String, showInTooltip: Boolean = true) {
        components["jukebox_playable"] = mapOf(
            "song_key" to songKey,
            "show_in_tooltip" to showInTooltip
        )
    }

    fun breakSound(key: String) {
        components["break_sound"] = key
    }

    fun weapon(block: WeaponDsl.() -> Unit) {
        components["weapon"] = WeaponDsl().apply(block).build()
    }

    fun blocksAttacks(block: BlocksAttacksDsl.() -> Unit) {
        components["blocks_attacks"] = BlocksAttacksDsl().apply(block).build()
    }

    fun canPlaceOn(block: CanPlaceOnDsl.() -> Unit) {
        components["can_place_on"] = CanPlaceOnDsl().apply(block).build()
    }

    fun canBreak(block: CanBreakDsl.() -> Unit) {
        components["can_break"] = CanBreakDsl().apply(block).build()
    }

    fun paintingVariant(key: String) {
        components["painting_variant"] = key
    }

    fun kineticWeapon(block: KineticWeaponDsl.() -> Unit) {
        components["kinetic_weapon"] = KineticWeaponDsl().apply(block).build()
    }

    fun piercingWeapon(block: PiercingWeaponDsl.() -> Unit) {
        components["piercing_weapon"] = PiercingWeaponDsl().apply(block).build()
    }

    fun attackRange(block: AttackRangeDsl.() -> Unit) {
        components["attack_range"] = AttackRangeDsl().apply(block).build()
    }

    fun swingAnimation(type: String, duration: String) {
        components["swing_animation"] = mapOf(
            "type" to type,
            "duration" to duration
        )
    }

    fun useEffects(block: UseEffectsDsl.() -> Unit) {
        components["use_effects"] = UseEffectsDsl().apply(block).build()
    }

    fun damageType(type: String) {
        components["damage_type"] = type
    }

    fun minimumAttackCharge(value: Float) {
        components["minimum_attack_charge"] = value
    }

    override fun build(): Map<String, Any> = components
}

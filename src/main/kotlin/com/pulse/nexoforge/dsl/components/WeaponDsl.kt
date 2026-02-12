package com.pulse.nexoforge.dsl.components

import com.pulse.nexoforge.dsl.SingleDslBuilder

class WeaponDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun damagePerAttack(value: Int) {
        data["damage_per_attack"] = value
    }

    fun disableBlocking(value: Double) {
        data["disable_blocking"] = value
    }

    override fun build(): Map<String, Any> = data
}

class BlocksAttacksDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()
    private val damageReductions = mutableListOf<Map<String, Any>>()

    fun blockDelay(value: Double) {
        data["block_delay"] = value
    }

    fun disableCooldownScale(value: Double) {
        data["disable_cooldown_scale"] = value
    }

    fun blockSound(key: String) {
        data["block_sound"] = key
    }

    fun disableSound(key: String) {
        data["disable_sound"] = key
    }

    fun bypassedBy(key: String) {
        data["bypassed_by"] = key
    }

    fun itemDamage(base: Double, factor: Double, threshold: Double) {
        data["item_damage"] = mapOf(
            "base" to base,
            "factor" to factor,
            "threshold" to threshold
        )
    }

    fun damageReduction(block: DamageReductionDsl.() -> Unit) {
        damageReductions.add(DamageReductionDsl().apply(block).build())
    }

    fun horizontalBlocking(value: Double) {
        data["horizontal_blocking"] = value
    }

    override fun build(): Map<String, Any> {
        if (damageReductions.isNotEmpty()) {
            data["damage_reductions"] = damageReductions
        }
        return data
    }
}

class DamageReductionDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun base(value: Double) {
        data["base"] = value
    }

    fun factor(value: Double) {
        data["factor"] = value
    }

    fun types(vararg types: String) {
        data["types"] = if (types.size == 1) types[0] else types.toList()
    }

    override fun build(): Map<String, Any> = data
}

class CanPlaceOnDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun block(block: String) {
        data["block"] = block
    }

    fun blocks(vararg blocks: String) {
        data["blocks"] = blocks.toList()
    }

    override fun build(): Map<String, Any> = data
}

class CanBreakDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun block(block: String) {
        data["block"] = block
    }

    fun blocks(vararg blocks: String) {
        data["blocks"] = blocks.toList()
    }

    override fun build(): Map<String, Any> = data
}

class KineticWeaponDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun contactCooldown(value: String) {
        data["contact_cooldown"] = value
    }

    fun delay(value: String) {
        data["delay"] = value
    }

    fun damageMultiplier(value: Double) {
        data["damage_multiplier"] = value
    }

    fun sound(key: String) {
        data["sound"] = key
    }

    fun hitSound(key: String) {
        data["hit_sound"] = key
    }

    fun dismountConditions(block: KineticConditionsDsl.() -> Unit) {
        data["dismount_conditions"] = KineticConditionsDsl().apply(block).build()
    }

    fun knockbackConditions(block: KineticConditionsDsl.() -> Unit) {
        data["knockback_conditions"] = KineticConditionsDsl().apply(block).build()
    }

    fun damageConditions(block: KineticConditionsDsl.() -> Unit) {
        data["damage_conditions"] = KineticConditionsDsl().apply(block).build()
    }

    override fun build(): Map<String, Any> = data
}

class KineticConditionsDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun maxDuration(value: String) {
        data["max_duration"] = value
    }

    fun minSpeed(value: Float) {
        data["min_speed"] = value
    }

    fun minRelativeSpeed(value: Float) {
        data["min_relative_speed"] = value
    }

    override fun build(): Map<String, Any> = data
}

class PiercingWeaponDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun sound(key: String) {
        data["sound"] = key
    }

    fun hitSound(key: String) {
        data["hit_sound"] = key
    }

    fun dismounts(value: Boolean) {
        data["dismounts"] = value
    }

    fun dealsKnockback(value: Boolean) {
        data["deals_knockback"] = value
    }

    override fun build(): Map<String, Any> = data
}

class AttackRangeDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun reach(range: String) {
        data["reach"] = range
    }

    fun minReach(value: Int) {
        data["min_reach"] = value
    }

    fun maxReach(value: Int) {
        data["max_reach"] = value
    }

    fun hitboxMargin(value: Double) {
        data["hitbox_margin"] = value
    }

    fun mobFactor(value: Int) {
        data["mob_factor"] = value
    }

    override fun build(): Map<String, Any> = data
}

class UseEffectsDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun canSprint(value: Boolean) {
        data["can_sprint"] = value
    }

    fun interactVibrations(value: Boolean) {
        data["interact_vibrations"] = value
    }

    fun speedMultiplier(value: Double) {
        data["speed_multiplier"] = value
    }

    override fun build(): Map<String, Any> = data
}

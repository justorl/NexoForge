package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder
import org.bukkit.potion.PotionEffectType

class ArmorEffectsDsl : SingleDslBuilder {
    private val effects = mutableMapOf<String, Any>()

    fun effect(effectType: PotionEffectType, block: PotionEffectDsl.() -> Unit) {
        effects[effectType.key.key] = PotionEffectDsl().apply(block).build()
    }

    fun nightVision(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.NIGHT_VISION, block)
    fun speed(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.SPEED, block)
    fun haste(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.HASTE, block)
    fun strength(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.STRENGTH, block)
    fun instantHealth(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.INSTANT_HEALTH, block)
    fun jumpBoost(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.JUMP_BOOST, block)
    fun regeneration(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.REGENERATION, block)
    fun resistance(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.RESISTANCE, block)
    fun fireResistance(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.FIRE_RESISTANCE, block)
    fun waterBreathing(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.WATER_BREATHING, block)
    fun invisibility(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.INVISIBILITY, block)
    fun blindness(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.BLINDNESS, block)
    fun slowness(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.SLOWNESS, block)
    fun miningFatigue(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.MINING_FATIGUE, block)
    fun weakness(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.WEAKNESS, block)
    fun poison(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.POISON, block)
    fun wither(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.WITHER, block)
    fun healthBoost(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.HEALTH_BOOST, block)
    fun absorption(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.ABSORPTION, block)
    fun saturation(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.SATURATION, block)
    fun glowing(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.GLOWING, block)
    fun levitation(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.LEVITATION, block)
    fun luck(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.LUCK, block)
    fun unluck(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.UNLUCK, block)
    fun slowFalling(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.SLOW_FALLING, block)
    fun conduitPower(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.CONDUIT_POWER, block)
    fun dolphinsGrace(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.DOLPHINS_GRACE, block)
    fun badOmen(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.BAD_OMEN, block)
    fun heroOfTheVillage(block: PotionEffectDsl.() -> Unit) = effect(PotionEffectType.HERO_OF_THE_VILLAGE, block)

    override fun build(): Map<String, Any> = effects

    class PotionEffectDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun duration(value: Int) {
            data["duration"] = value
        }

        fun amplifier(value: Int) {
            data["amplifier"] = value
        }

        fun ambient(value: Boolean = true) {
            data["ambient"] = value
        }

        fun particles(value: Boolean = true) {
            data["particles"] = value
        }

        fun icon(value: Boolean = true) {
            data["icon"] = value
        }

        fun requiresFullSet(value: Boolean = true) {
            data["requires_full_set"] = value
        }

        override fun build(): Map<String, Any> = data
    }
}
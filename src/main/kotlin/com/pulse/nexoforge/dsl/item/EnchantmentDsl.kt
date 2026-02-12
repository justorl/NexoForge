package com.pulse.nexoforge.dsl.item

import com.pulse.nexoforge.dsl.DslBuilder

class EnchantmentsDsl : DslBuilder<Map<String, Int>> {
    private val enchantments = mutableMapOf<String, Int>()

    fun enchantment(name: String, level: Int) {
        enchantments[name] = level
    }

    operator fun String.invoke(level: Int) = enchantment(this, level)

    fun aquaAffinity() = enchantment("aqua_affinity", 1)
    fun blastProtection(level: Int) = enchantment("blast_protection", level)
    fun curseOfBinding() = enchantment("curse_of_binding", 1)
    fun depthStrider(level: Int) = enchantment("depth_strider", level)
    fun featherFalling(level: Int) = enchantment("feather_falling", level)
    fun fireProtection(level: Int) = enchantment("fire_protection", level)
    fun frostWalker(level: Int) = enchantment("frost_walker", level)
    fun projectileProtection(level: Int) = enchantment("projectile_protection", level)
    fun protection(level: Int) = enchantment("protection", level)
    fun respiration(level: Int) = enchantment("respiration", level)
    fun soulSpeed(level: Int) = enchantment("soul_speed", level)
    fun swiftSneak(level: Int) = enchantment("swift_sneak", level)
    fun thorns(level: Int) = enchantment("thorns", level)
    fun baneOfArthropods(level: Int) = enchantment("bane_of_arthropods", level)
    fun breach(level: Int) = enchantment("breach", level)
    fun cleaving(level: Int) = enchantment("cleaving", level)
    fun density(level: Int) = enchantment("density", level)
    fun fireAspect(level: Int) = enchantment("fire_aspect", level)
    fun knockback(level: Int) = enchantment("knockback", level)
    fun looting(level: Int) = enchantment("looting", level)
    fun sharpness(level: Int) = enchantment("sharpness", level)
    fun smite(level: Int) = enchantment("smite", level)
    fun sweepingEdge(level: Int) = enchantment("sweeping_edge", level)
    fun efficiency(level: Int) = enchantment("efficiency", level)
    fun fortune(level: Int) = enchantment("fortune", level)
    fun silkTouch() = enchantment("silk_touch", 1)
    fun unbreaking(level: Int) = enchantment("unbreaking", level)
    fun flame(level: Int = 1) = enchantment("flame", level)
    fun infinity() = enchantment("infinity", 1)
    fun power(level: Int) = enchantment("power", level)
    fun punch(level: Int) = enchantment("punch", level)
    fun multishot() = enchantment("multishot", 1)
    fun piercing(level: Int) = enchantment("piercing", level)
    fun quickCharge(level: Int) = enchantment("quick_charge", level)
    fun channeling() = enchantment("channeling", 1)
    fun impaling(level: Int) = enchantment("impaling", level)
    fun loyalty(level: Int) = enchantment("loyalty", level)
    fun riptide(level: Int) = enchantment("riptide", level)
    fun luckOfTheSea(level: Int) = enchantment("luck_of_the_sea", level)
    fun lure(level: Int) = enchantment("lure", level)
    fun lunge(level: Int) = enchantment("lunge", level)
    fun windBurst(level: Int) = enchantment("wind_burst", level)
    fun mending() = enchantment("mending", 1)
    fun curseOfVanishing() = enchantment("curse_of_vanishing", 1)

    override fun build(): Map<String, Int> = enchantments
}

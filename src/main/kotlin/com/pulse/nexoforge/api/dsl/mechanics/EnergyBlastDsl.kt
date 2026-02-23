package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder
import org.bukkit.Particle

class EnergyBlastDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun delay(milliseconds: Long) {
        data["delay"] = milliseconds
    }

    fun length(value: Int) {
        data["length"] = value
    }

    fun damage(value: Double) {
        data["damage"] = value
    }

    fun particle(block: ParticleDsl.() -> Unit) {
        data["particle"] = ParticleDsl().apply(block).build()
    }

    override fun build(): Map<String, Any> = data

    class ParticleDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun type(value: Particle) {
            data["type"] = value.name
        }

        fun size(value: Int) {
            data["size"] = value
        }

        fun color(block: ColorDsl.() -> Unit) {
            data["color"] = ColorDsl().apply(block).build()
        }

        override fun build(): Map<String, Any> = data

        class ColorDsl : SingleDslBuilder {
            private val data = mutableMapOf<String, Any>()

            fun red(value: Int) {
                data["red"] = value
            }

            fun green(value: Int) {
                data["green"] = value
            }

            fun blue(value: Int) {
                data["blue"] = value
            }

            override fun build(): Map<String, Any> = data
        }
    }
}
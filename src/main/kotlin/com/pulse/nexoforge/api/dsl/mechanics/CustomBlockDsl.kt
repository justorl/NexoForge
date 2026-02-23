package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.ListDslBuilder
import com.pulse.nexoforge.api.dsl.SingleDslBuilder
import org.bukkit.Material

class CustomBlockDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun type(value: String) {
        data["type"] = value
    }

    fun customVariation(value: Int) {
        data["custom_variation"] = value
    }

    fun model(value: String) {
        data["model"] = value
    }

    fun hardness(value: Double) {
        data["hardness"] = value
    }

    fun beaconBaseBlock(value: Boolean = true) {
        data["beacon_base_block"] = value
    }

    fun blastResistant(value: Boolean = true) {
        data["blast_resistant"] = value
    }

    fun isFalling(value: Boolean = true) {
        data["is_falling"] = value
    }

    fun placeableOnWater(value: Boolean = true) {
        data["placeable_on_water"] = value
    }

    fun requiresSupporting(value: Boolean = true) {
        data["requires_supporting"] = value
    }

    fun isTall(value: Boolean = true) {
        data["is_tall"] = value
    }

    fun randomPlace(vararg blocks: String) {
        data["random_place"] = blocks.toList()
    }

    fun randomPlace(blocks: List<String>) {
        data["random_place"] = blocks
    }

    fun sapling(block: SaplingDsl.() -> Unit) {
        data["sapling"] = SaplingDsl().apply(block).build()
    }

    fun stackable(block: StackableDsl.() -> Unit) {
        data["stackable"] = StackableDsl().apply(block).build()
    }

    fun drop(block: CustomBlockDropDsl.() -> Unit) {
        data["drop"] = CustomBlockDropDsl().apply(block).build()
    }

    fun blockSounds(block: BlockSoundsDsl.() -> Unit) {
        data["block_sounds"] = BlockSoundsDsl().apply(block).build()
    }

    fun limitedPlacing(block: LimitedPlacingDsl.() -> Unit) {
        data["limited_placing"] = LimitedPlacingDsl().apply(block).build()
    }

    fun blocklocker(block: BlockLockerDsl.() -> Unit) {
        data["blocklocker"] = BlockLockerDsl().apply(block).build()
    }

    fun storage(block: StorageDsl.() -> Unit) {
        data["storage"] = StorageDsl().apply(block).build()
    }

    fun logStrip(block: LogStripDsl.() -> Unit) {
        data["log_strip"] = LogStripDsl().apply(block).build()
    }

    fun directional(block: DirectionalDsl.() -> Unit) {
        data["directional"] = DirectionalDsl().apply(block).build()
    }

    override fun build(): Map<String, Any> = data

    class CustomBlockDropDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun silktouch(value: Boolean = false) {
            data["silktouch"] = value
        }

        fun fortune(value: Boolean = false) {
            data["fortune"] = value
        }

        fun minimalType(value: String?) {
            if (value != null) data["minimal_type"] = value
        }

        fun bestTool(value: String?) {
            if (value != null) data["best_tool"] = value
        }

        fun loots(block: LootsDsl.() -> Unit) {
            data["loots"] = LootsDsl().apply(block).build()
        }

        override fun build(): Map<String, Any> = data

        class LootsDsl : ListDslBuilder {
            private val loots = mutableListOf<Map<String, Any>>()

            fun nexoItem(item: String, amount: Int = 1, probability: Double = 1.0, inExplosion: Boolean = false) {
                val loot = mutableMapOf<String, Any>(
                    "nexo_item" to item,
                    "amount" to amount,
                    "probability" to probability
                )
                if (inExplosion) loot["in_explosion"] = true
                loots.add(loot)
            }

            fun minecraftType(type: Material, amount: Int = 1, probability: Double = 1.0, inExplosion: Boolean = false) {
                val loot = mutableMapOf<String, Any>(
                    "minecraft_type" to type.name,
                    "amount" to amount,
                    "probability" to probability
                )
                if (inExplosion) loot["in_explosion"] = true
                loots.add(loot)
            }

            fun crucibleItem(item: String, amount: String = "1", probability: Double = 1.0, inExplosion: Boolean = false) {
                val loot = mutableMapOf<String, Any>(
                    "crucible_item" to item,
                    "amount" to amount,
                    "probability" to probability
                )
                if (inExplosion) loot["in_explosion"] = true
                loots.add(loot)
            }

            fun mmoItem(type: String, id: String, amount: Int = 1, probability: Double = 1.0, inExplosion: Boolean = false) {
                val loot = mutableMapOf<String, Any>(
                    "mmoitem_type" to type,
                    "mmoitem_id" to id,
                    "amount" to amount,
                    "probability" to probability
                )
                if (inExplosion) loot["in_explosion"] = true
                loots.add(loot)
            }

            override fun build(): List<Map<String, Any>> = loots
        }
    }

    class BlockSoundsDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun placeSound(sound: String) {
            data["place_sound"] = sound
        }

        fun breakSound(sound: String) {
            data["break_sound"] = sound
        }

        fun hitSound(sound: String) {
            data["hit_sound"] = sound
        }

        fun stepSound(sound: String) {
            data["step_sound"] = sound
        }

        fun fallSound(sound: String) {
            data["fall_sound"] = sound
        }

        fun place(block: SoundDetailDsl.() -> Unit) {
            data["place"] = SoundDetailDsl().apply(block).build()
        }

        override fun build(): Map<String, Any> = data

        class SoundDetailDsl : SingleDslBuilder {
            private val data = mutableMapOf<String, Any>()

            fun sound(value: String) {
                data["sound"] = value
            }

            fun volume(value: Double) {
                data["volume"] = value
            }

            fun pitch(value: Double) {
                data["pitch"] = value
            }

            override fun build(): Map<String, Any> = data
        }
    }

    class LimitedPlacingDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun roof(value: Boolean = true) {
            data["roof"] = value
        }

        fun floor(value: Boolean = true) {
            data["floor"] = value
        }

        fun wall(value: Boolean = true) {
            data["wall"] = value
        }

        fun type(value: String) {
            data["type"] = value
        }

        fun blockTypes(vararg types: Material) {
            data["block_types"] = types.map { it.name }
        }

        fun blockTypes(types: List<Material>) {
            data["block_types"] = types.map { it.name }
        }

        fun blockTags(vararg tags: String) {
            data["block_tags"] = tags.toList()
        }

        fun blockTags(tags: List<String>) {
            data["block_tags"] = tags
        }

        fun nexoBlocks(vararg blocks: String) {
            data["nexo_blocks"] = blocks.toList()
        }

        fun nexoBlocks(blocks: List<String>) {
            data["nexo_blocks"] = blocks
        }

        override fun build(): Map<String, Any> = data
    }

    class BlockLockerDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun canProtect(value: Boolean = true) {
            data["can_protect"] = value
        }

        fun protectionType(value: String) {
            data["protection_type"] = value
        }

        override fun build(): Map<String, Any> = data
    }

    class StorageDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun type(value: String) {
            data["type"] = value
        }

        fun rows(value: Int) {
            data["rows"] = value
        }

        fun title(value: String) {
            data["title"] = value
        }

        fun openSound(value: String) {
            data["open_sound"] = value
        }

        fun closeSound(value: String) {
            data["close_sound"] = value
        }

        override fun build(): Map<String, Any> = data
    }

    class LogStripDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun strippedLog(value: String) {
            data["stripped_log"] = value
        }

        fun drop(value: String) {
            data["drop"] = value
        }

        override fun build(): Map<String, Any> = data
    }

    class DirectionalDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun type(value: String) {
            data["type"] = value
        }

        fun yVariation(value: Int) {
            data["y_variation"] = value
        }

        fun xVariation(value: Int) {
            data["x_variation"] = value
        }

        fun zVariation(value: Int) {
            data["z_variation"] = value
        }

        fun yBlock(value: String) {
            data["y_block"] = value
        }

        fun xBlock(value: String) {
            data["x_block"] = value
        }

        fun zBlock(value: String) {
            data["z_block"] = value
        }

        fun northBlock(value: String) {
            data["north_block"] = value
        }

        fun eastBlock(value: String) {
            data["east_block"] = value
        }

        fun southBlock(value: String) {
            data["south_block"] = value
        }

        fun westBlock(value: String) {
            data["west_block"] = value
        }

        fun upBlock(value: String) {
            data["up_block"] = value
        }

        fun downBlock(value: String) {
            data["down_block"] = value
        }

        fun parentBlock(value: String) {
            data["parent_block"] = value
        }

        override fun build(): Map<String, Any> = data
    }

    class SaplingDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun growsNaturally(value: Boolean = true) {
            data["grows_naturally"] = value
        }

        fun naturalGrowthTime(ticks: Int) {
            data["natural_growth_time"] = ticks
        }

        fun growsFromBonemeal(value: Boolean = true) {
            data["grows_from_bonemeal"] = value
        }

        fun bonemealGrowthSpeedup(ticks: Int) {
            data["bonemeal_growth_speedup"] = ticks
        }

        fun growSound(sound: String) {
            data["grow_sound"] = sound
        }

        fun minLightLevel(level: Int) {
            data["min_light_level"] = level
        }

        fun requiresWaterSource(value: Boolean = false) {
            data["requires_water_source"] = value
        }

        fun schematic(name: String) {
            data["schematic"] = name
        }

        fun schematics(block: SchematicsDsl.() -> Unit) {
            data["schematic"] = SchematicsDsl().apply(block).build()
        }

        fun replaceBlocks(value: Boolean = false) {
            data["replace_blocks"] = value
        }

        fun copyBiomes(value: Boolean = false) {
            data["copy_biomes"] = value
        }

        fun copyEntities(value: Boolean = false) {
            data["copy_entities"] = value
        }

        override fun build(): Map<String, Any> = data

        class SchematicsDsl : ListDslBuilder {
            private val schematics = mutableListOf<Map<String, Any>>()

            fun schematic(name: String, chance: Double) {
                schematics.add(mapOf(
                    "schem" to name,
                    "chance" to chance
                ))
            }

            override fun build(): List<Map<String, Any>> = schematics
        }
    }

    class StackableDsl : ListDslBuilder {
        private val models = mutableListOf<Map<String, String>>()

        fun model(modelName: String) {
            models.add(mapOf("model" to modelName))
        }

        override fun build(): List<Map<String, String>> = models
    }
}
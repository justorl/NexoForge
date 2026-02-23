package com.pulse.nexoforge.api.dsl.mechanics

import com.pulse.nexoforge.api.dsl.SingleDslBuilder
import com.pulse.nexoforge.api.dsl.ListDslBuilder
import com.pulse.nexoforge.api.dsl.StringListDslBuilder
import org.bukkit.Material

class FurnitureDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun blockSounds(block: BlockSoundsDsl.() -> Unit) {
        data["block_sounds"] = BlockSoundsDsl().apply(block).build()
    }

    fun hitbox(block: HitboxDsl.() -> Unit) {
        data["hitbox"] = HitboxDsl().apply(block).build()
    }

    fun drop(block: CustomBlockDropDsl.() -> Unit) {
        data["drop"] = CustomBlockDropDsl().apply(block).build()
    }

    fun properties(block: FurniturePropertiesDsl.() -> Unit) {
        data["properties"] = FurniturePropertiesDsl().apply(block).build()
    }

    fun rotatable(value: Boolean = true) {
        data["rotatable"] = value
    }

    fun modelengineId(id: String) {
        data["modelengine_id"] = id
    }

    fun jukebox(block: JukeboxDsl.() -> Unit) {
        data["jukebox"] = JukeboxDsl().apply(block).build()
    }

    fun restrictedRotation(value: String) {
        data["restricted_rotation"] = value
    }

    fun limitedPlacing(block: LimitedPlacingDsl.() -> Unit) {
        data["limited_placing"] = LimitedPlacingDsl().apply(block).build()
    }

    fun storage(block: StorageDsl.() -> Unit) {
        data["storage"] = StorageDsl().apply(block).build()
    }

    fun waterloggable(value: Boolean = true) {
        data["waterloggable"] = value
    }

    fun blocklocker(block: BlockLockerDsl.() -> Unit) {
        data["blocklocker"] = BlockLockerDsl().apply(block).build()
    }

    fun seats(block: SeatsDsl.() -> Unit) {
        data["seats"] = SeatsDsl().apply(block).build()
    }

    fun beds(block: BedsDsl.() -> Unit) {
        data["beds"] = BedsDsl().apply(block).build()
    }

    fun lights(block: LightsDsl.() -> Unit) {
        data["lights"] = LightsDsl().apply(block).build()
    }

    fun evolution(block: EvolutionDsl.() -> Unit) {
        data["evolution"] = EvolutionDsl().apply(block).build()
    }

    fun door(block: DoorDsl.() -> Unit) {
        data["door"] = DoorDsl().apply(block).build()
    }

    fun item(itemId: String) {
        data["item"] = itemId
    }

    fun farmlandRequired(value: Boolean = true) {
        data["farmland_required"] = value
    }

    override fun build(): Map<String, Any> = data

    class FurniturePropertiesDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun displayTransform(value: String) {
            data["display_transform"] = value
        }

        fun trackingRotation(value: String) {
            data["tracking_rotation"] = value
        }

        fun translation(x: Double, y: Double, z: Double) {
            data["translation"] = "$x,$y,$z"
        }

        fun brightness(block: BrightnessDsl.() -> Unit) {
            data["brightness"] = BrightnessDsl().apply(block).build()
        }

        fun scale(x: Double, y: Double, z: Double) {
            data["scale"] = "$x,$y,$z"
        }

        fun viewRange(value: Double) {
            data["view_range"] = value
        }

        fun shadowRadius(value: Double) {
            data["shadow_radius"] = value
        }

        fun shadowStrength(value: Double) {
            data["shadow_strength"] = value
        }

        fun displayWidth(value: Double) {
            data["display_width"] = value
        }

        fun displayHeight(value: Double) {
            data["display_height"] = value
        }

        fun delay(value: String) {
            data["delay"] = value
        }

        override fun build(): Map<String, Any> = data

        class BrightnessDsl : SingleDslBuilder {
            private val data = mutableMapOf<String, Any>()

            fun blockLight(value: Int) {
                data["block_light"] = value
            }

            fun skyLight(value: Int) {
                data["sky_light"] = value
            }

            override fun build(): Map<String, Any> = data
        }
    }

    class HitboxDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun barriers(block: BarriersDsl.() -> Unit) {
            data["barriers"] = BarriersDsl().apply(block).build()
        }

        fun interactions(block: InteractionsDsl.() -> Unit) {
            data["interactions"] = InteractionsDsl().apply(block).build()
        }

        fun shulkers(block: ShulkersDsl.() -> Unit) {
            data["shulkers"] = ShulkersDsl().apply(block).build()
        }

        fun ghasts(block: GhastsDsl.() -> Unit) {
            data["ghasts"] = GhastsDsl().apply(block).build()
        }

        override fun build(): Map<String, Any> = data

        class BarriersDsl : StringListDslBuilder {
            private val barriers = mutableListOf<String>()

            fun barrier(x: Int, y: Int, z: Int) {
                barriers.add("$x,$y,$z")
            }

            fun barrier(position: String) {
                barriers.add(position)
            }

            override fun build(): List<String> = barriers
        }

        class InteractionsDsl : StringListDslBuilder {
            private val interactions = mutableListOf<String>()

            fun interaction(x: Double, y: Double, z: Double, width: Double, height: Double) {
                interactions.add("$x,$y,$z $width,$height")
            }

            fun interaction(definition: String) {
                interactions.add(definition)
            }

            override fun build(): List<String> = interactions
        }

        class ShulkersDsl : StringListDslBuilder {
            private val shulkers = mutableListOf<String>()

            fun shulker(x: Int, y: Int, z: Int, scale: Double, length: Double, direction: String? = null, visible: Boolean = false) {
                val parts = mutableListOf("$x,$y,$z", scale.toString(), length.toString())
                if (direction != null) parts.add(direction)
                if (visible) parts.add("true")
                shulkers.add(parts.joinToString(" "))
            }

            fun shulker(definition: String) {
                shulkers.add(definition)
            }

            override fun build(): List<String> = shulkers
        }

        class GhastsDsl : StringListDslBuilder {
            private val ghasts = mutableListOf<String>()

            fun ghast(x: Double, y: Double, z: Double, scale: Double = 0.25, rotation: Double = 0.0, visible: Boolean = false) {
                val parts = mutableListOf("$x,$y,$z", scale.toString())
                if (rotation != 0.0) parts.add(rotation.toString())
                if (visible) parts.add("true")
                ghasts.add(parts.joinToString(" "))
            }

            fun ghast(definition: String) {
                ghasts.add(definition)
            }

            override fun build(): List<String> = ghasts
        }
    }

    class JukeboxDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun volume(value: Double) {
            data["volume"] = value
        }

        fun pitch(value: Double) {
            data["pitch"] = value
        }

        fun permission(value: String) {
            data["permission"] = value
        }

        override fun build(): Map<String, Any> = data
    }

    class LimitedPlacingDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun radiusLimitation(block: RadiusLimitationDsl.() -> Unit) {
            data["radius_limitation"] = RadiusLimitationDsl().apply(block).build()
        }

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

        class RadiusLimitationDsl : SingleDslBuilder {
            private val data = mutableMapOf<String, Any>()

            fun radius(value: Int) {
                data["radius"] = value
            }

            fun amount(value: Int) {
                data["amount"] = value
            }

            override fun build(): Map<String, Any> = data
        }
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

    class SeatsDsl : StringListDslBuilder {
        private val seats = mutableListOf<String>()

        fun seat(x: Double, y: Double, z: Double) {
            seats.add("$x,$y,$z")
        }

        override fun build(): List<String> = seats
    }

    class BedsDsl : StringListDslBuilder {
        private val beds = mutableListOf<String>()

        fun bed(x: Double, y: Double, z: Double, skipNight: Boolean = true, resetPhantoms: Boolean = true) {
            beds.add("$x,$y,$z $skipNight $resetPhantoms")
        }

        override fun build(): List<String> = beds
    }

    class LightsDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()
        private val lightsList = mutableListOf<String>()

        fun toggleable(value: Boolean = false) {
            data["toggleable"] = value
        }

        fun toggledModel(value: String) {
            data["toggled_model"] = value
        }

        fun toggledItemModel(value: String) {
            data["toggled_item_model"] = value
        }

        fun light(x: Double, y: Double, z: Double, lightLevel: Int) {
            lightsList.add("$x,$y,$z $lightLevel")
        }

        override fun build(): Map<String, Any> {
            if (lightsList.isNotEmpty()) {
                data["lights"] = lightsList
            }
            return data
        }
    }

    class EvolutionDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun delay(value: String) {
            data["delay"] = value
        }

        fun probability(value: Double) {
            data["probability"] = value
        }

        fun lightBoost(value: Boolean = true) {
            data["light_boost"] = value
        }

        fun bonemealChance(value: Double) {
            data["bone_meal_chance"] = value
        }

        fun nextStage(value: String) {
            data["next_stage"] = value
        }

        override fun build(): Map<String, Any> = data
    }

    class DoorDsl : SingleDslBuilder {
        private val data = mutableMapOf<String, Any>()

        fun toggleHitboxOnOpen(value: Boolean = true) {
            data["toggle_hitbox_on_open"] = value
        }

        fun openSound(value: String) {
            data["open_sound"] = value
        }

        fun closeSound(value: String) {
            data["close_sound"] = value
        }

        fun openProperties(block: FurniturePropertiesDsl.() -> Unit) {
            data["open_properties"] = FurniturePropertiesDsl().apply(block).build()
        }

        fun isSliding(value: Boolean = false) {
            data["is_sliding"] = value
        }

        fun automaticCloseDelay(value: String) {
            data["automatic_close_delay"] = value
        }

        fun delayHitboxToggle(value: Boolean = false) {
            data["delay_hitbox_toggle"] = value
        }

        override fun build(): Map<String, Any> = data
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

            fun nexoItem(item: String, amount: Int = 1, maxAmount: Int? = null, probability: Double = 1.0) {
                val loot = mutableMapOf<String, Any>(
                    "nexo_item" to item,
                    "amount" to amount,
                    "probability" to probability
                )
                if (maxAmount != null) loot["max_amount"] = maxAmount
                loots.add(loot)
            }

            fun minecraftType(type: Material, amount: Int = 1, maxAmount: Int? = null, probability: Double = 1.0) {
                val loot = mutableMapOf<String, Any>(
                    "minecraft_type" to type.name,
                    "amount" to amount,
                    "probability" to probability
                )
                if (maxAmount != null) loot["max_amount"] = maxAmount
                loots.add(loot)
            }

            fun crucibleItem(item: String, amount: String = "1", maxAmount: Int? = null, probability: Double = 1.0) {
                val loot = mutableMapOf<String, Any>(
                    "crucible_item" to item,
                    "amount" to amount,
                    "probability" to probability
                )
                if (maxAmount != null) loot["max_amount"] = maxAmount
                loots.add(loot)
            }

            fun mmoItem(type: String, id: String, amount: Int = 1, maxAmount: Int? = null, probability: Double = 1.0) {
                val loot = mutableMapOf<String, Any>(
                    "mmoitem_type" to type,
                    "mmoitem_id" to id,
                    "amount" to amount,
                    "probability" to probability
                )
                if (maxAmount != null) loot["max_amount"] = maxAmount
                loots.add(loot)
            }

            override fun build(): List<Map<String, Any>> = loots
        }
    }
}
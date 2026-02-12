package com.pulse.nexoforge.dsl.components

import com.pulse.nexoforge.dsl.SingleDslBuilder

class EquippableDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun slot(slot: String) {
        data["slot"] = slot
    }

    fun assetId(id: String) {
        data["asset_id"] = id
    }

    fun cameraOverlay(overlay: String) {
        data["camera_overlay"] = overlay
    }

    fun equipSound(sound: String) {
        data["equip_sound"] = sound
    }

    fun allowedEntityTypes(vararg types: String) {
        data["allowed_entity_types"] = types.toList()
    }

    fun dispensable(value: Boolean = true) {
        data["dispensable"] = value
    }

    fun swappable(value: Boolean = true) {
        data["swappable"] = value
    }

    fun damageOnHurt(value: Boolean = true) {
        data["damage_on_hurt"] = value
    }

    override fun build(): Map<String, Any> = data
}

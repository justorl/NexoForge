package com.pulse.nexoforge.dsl.item

import com.pulse.nexoforge.dsl.SingleDslBuilder

class PackDsl : SingleDslBuilder {
    private val data = mutableMapOf<String, Any>()

    fun parentModel(model: String) {
        data["parent_model"] = model
    }

    fun model(model: String) {
        data["model"] = model
    }

    fun texture(texture: String) {
        data["texture"] = texture
    }

    fun textures(vararg textures: String) {
        data["textures"] = textures.toList()
    }

    fun customModelData(value: Int) {
        data["custom_model_data"] = value
    }

    fun oversizedInGui(value: Boolean = true) {
        data["oversized_in_gui"] = value
    }

    fun dyeableModel(model: String) {
        data["dyeable_model"] = model
    }

    fun dyeableTexture(texture: String) {
        data["dyeable_texture"] = texture
    }

    fun blockingModel(model: String) {
        data["blocking_model"] = model
    }

    fun blockingTexture(texture: String) {
        data["blocking_texture"] = texture
    }

    fun pullingModels(vararg models: String) {
        data["pulling_models"] = models.toList()
    }

    fun pullingModels(models: List<String>) {
        data["pulling_models"] = models
    }

    fun pullingTextures(vararg textures: String) {
        data["pulling_textures"] = textures.toList()
    }

    fun pullingTextures(textures: List<String>) {
        data["pulling_textures"] = textures
    }

    fun chargedModel(model: String) {
        data["charged_model"] = model
    }

    fun chargedTexture(texture: String) {
        data["charged_texture"] = texture
    }

    fun fireworkModel(model: String) {
        data["firework_model"] = model
    }

    fun fireworkTexture(texture: String) {
        data["firework_texture"] = texture
    }

    fun castModel(model: String) {
        data["cast_model"] = model
    }

    fun castTexture(texture: String) {
        data["cast_texture"] = texture
    }

    fun damagedModels(vararg models: String) {
        data["damaged_models"] = models.toList()
    }

    fun damagedModels(models: List<String>) {
        data["damaged_models"] = models
    }

    fun damagedTextures(vararg textures: String) {
        data["damaged_textures"] = textures.toList()
    }

    fun damagedTextures(textures: List<String>) {
        data["damaged_textures"] = textures
    }

    fun compositeModels(vararg models: String) {
        data["composite_models"] = models.toList()
    }

    fun compositeModels(models: List<String>) {
        data["composite_models"] = models
    }

    fun compositeTextures(vararg textures: String) {
        data["composite_textures"] = textures.toList()
    }

    fun compositeTextures(textures: List<String>) {
        data["composite_textures"] = textures
    }

    override fun build(): Map<String, Any> = data
}
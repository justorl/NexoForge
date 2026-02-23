package com.pulse.nexoforge.recipe.data

import com.pulse.nexoforge.api.NexoForgeItem

data class RecipeRegistration(
    val item: NexoForgeItem,
    val recipePath: String = ""
)
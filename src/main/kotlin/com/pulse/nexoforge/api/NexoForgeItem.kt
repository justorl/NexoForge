package com.pulse.nexoforge.api

data class NexoForgeItem(
    val id: String,
    val data: MutableMap<String, Any> = mutableMapOf()
)
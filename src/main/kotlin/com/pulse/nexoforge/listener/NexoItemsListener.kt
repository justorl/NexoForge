package com.pulse.nexoforge.listener

import com.nexomc.nexo.api.events.NexoItemsLoadedEvent
import com.pulse.nexoforge.recipe.RecipeManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class NexoItemsListener(
    private val recipeManager: RecipeManager
) : Listener {

    @EventHandler
    fun onNexoItemsLoaded(event: NexoItemsLoadedEvent) {
        recipeManager.generateRecipeFiles()
    }
}

package me.solunii.starscourge.feature.impl

import me.solunii.starscourge.feature.Feature
import me.solunii.starscourge.event.TickEvent
import net.minecraft.client.MinecraftClient

class Fullbright : Feature("Fullbright", "Brighten the world around you", Category.RENDER) {
    init {
        listen<TickEvent> { event ->
            val client = MinecraftClient.getInstance()
            val player = client.player ?: return@listen

            // Increase gamma to max brightness
            client.options.gamma.value = 16.0
        }
    }

    override fun onDisable() {
        val client = MinecraftClient.getInstance()
        client.options.gamma.value = 1.0
    }
}

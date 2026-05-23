package me.solunii.starscourge.util

import net.minecraft.client.MinecraftClient
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import kotlin.math.sqrt

object PlayerUtil {
    fun getDistance(entity: Entity?): Double {
        val player = MinecraftClient.getInstance().player ?: return Double.MAX_VALUE
        entity ?: return Double.MAX_VALUE
        return player.distanceTo(entity)
    }

    fun isPlayerInRange(entity: Entity?, range: Double): Boolean {
        return getDistance(entity) <= range
    }

    fun getClosestEntity(range: Double): Entity? {
        val player = MinecraftClient.getInstance().player ?: return null
        val world = MinecraftClient.getInstance().world ?: return null

        var closest: Entity? = null
        var closestDistance = range

        for (entity in world.entities) {
            if (entity == player || entity.isInvisible) continue
            if (entity is LivingEntity && entity.health > 0) {
                val distance = player.distanceTo(entity)
                if (distance < closestDistance) {
                    closest = entity
                    closestDistance = distance
                }
            }
        }

        return closest
    }
}

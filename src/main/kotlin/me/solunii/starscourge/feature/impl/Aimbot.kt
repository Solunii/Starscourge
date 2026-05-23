package me.solunii.starscourge.feature.impl

import me.solunii.starscourge.feature.Feature
import me.solunii.starscourge.event.TickEvent
import net.minecraft.client.MinecraftClient
import net.minecraft.util.math.Vec3d
import kotlin.math.atan2
import kotlin.math.sqrt

class Aimbot : Feature("Aimbot", "Automatically aim at enemies", Category.COMBAT) {
    private val range = 32.0
    private val speed = 1.0f

    init {
        listen<TickEvent> { event ->
            val client = MinecraftClient.getInstance()
            val player = client.player ?: return@listen
            val world = client.world ?: return@listen

            var closestEntity = player.targetedEntity
            var closestDistance = Double.MAX_VALUE

            for (entity in world.entities) {
                if (entity == player || entity.isInvisible) continue
                if (entity.isAlive && entity.health > 0) {
                    val distance = player.distanceTo(entity)
                    if (distance < range && distance < closestDistance) {
                        closestEntity = entity
                        closestDistance = distance
                    }
                }
            }

            closestEntity?.let { target ->
                val targetPos = target.eyePos
                val playerPos = player.eyePos
                val diff = targetPos.subtract(playerPos)

                val yaw = atan2(diff.z, diff.x) * 180 / Math.PI - 90
                val distance = sqrt(diff.x * diff.x + diff.z * diff.z)
                val pitch = atan2(diff.y, distance) * 180 / Math.PI

                player.yaw = player.yaw + ((yaw - player.yaw) * speed).toFloat()
                player.pitch = player.pitch + ((pitch - player.pitch) * speed).toFloat()
            }
        }
    }
}

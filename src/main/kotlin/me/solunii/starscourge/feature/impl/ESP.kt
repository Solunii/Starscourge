package me.solunii.starscourge.feature.impl

import me.solunii.starscourge.feature.Feature
import me.solunii.starscourge.event.RenderEvent

class ESP : Feature("ESP", "See players through walls", Category.RENDER) {
    private val range = 128.0

    init {
        listen<RenderEvent> { event ->
            // This would require mixin to actually render the ESP boxes
            // Placeholder for rendering logic
        }
    }
}

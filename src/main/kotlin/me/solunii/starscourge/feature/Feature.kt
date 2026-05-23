package me.solunii.starscourge.feature

import me.solunii.starscourge.event.Event
import me.solunii.starscourge.event.EventManager

abstract class Feature(
    val name: String,
    val description: String,
    val category: Category = Category.MISC
) {
    var enabled = false
    var keybind = -1

    open fun onEnable() {}
    open fun onDisable() {}

    fun enable() {
        if (!enabled) {
            enabled = true
            onEnable()
        }
    }

    fun disable() {
        if (enabled) {
            enabled = false
            onDisable()
        }
    }

    fun toggle() {
        if (enabled) disable() else enable()
    }

    protected inline fun <reified T : Event> listen(noinline handler: (T) -> Unit) {
        EventManager.subscribe(T::class.java) { event ->
            if (enabled && event is T) {
                handler(event)
            }
        }
    }

    enum class Category {
        MOVEMENT, COMBAT, RENDER, MISC, UTILITY
    }
}

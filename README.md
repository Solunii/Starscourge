# Starscourge - Minecraft Hack Client

A powerful Fabric-based Minecraft hack client with a modular feature system.

## Features

- **Flight** - Fly freely in any direction
- **Speed** - Move faster than normal movement speed
- **NoFall** - Take no damage from falling
- **Aimbot** - Automatically aim at enemies
- **ESP** - See players through walls
- **Fullbright** - Brighten the world around you
- **AutoClicker** - Automatically click for you

## Installation

1. Install Fabric for Minecraft 1.20.1
2. Place the compiled JAR in your mods folder
3. Launch the game

## Building

```bash
./gradlew build
```

The compiled JAR will be in `build/libs/starscourge-1.0.0.jar`

## Usage

All features can be toggled in-game. The mod initializes with all features disabled and ready to be toggled on/off as needed.

## Architecture

- **EventManager** - Handles all game events (tick, render, input)
- **FeatureManager** - Manages all hack features
- **Feature** - Base class for all hack features
- **PlayerUtil** - Utility functions for player operations

## Contributing

Feel free to add more features by:

1. Creating a new class in `src/main/kotlin/me/solunii/starscourge/feature/impl/`
2. Extending the `Feature` class
3. Registering it in `FeatureManager.init()`

## License

MIT

---

**⚠️ Warning**: Using this client on multiplayer servers may result in a ban. Use at your own risk and only on servers where client mods are allowed.

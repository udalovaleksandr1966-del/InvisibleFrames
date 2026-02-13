# InvisibleFrames

Minecraft Paper 1.21+ plugin for toggling item frame visibility without commands!

## Features

- **No commands needed** - Use Shears + Shift to toggle visibility
- **Protection** - Invisible frames can't be accidentally broken or interacted with
- **Easy to use** - Intuitive gameplay mechanic

## How to Use

1. **Make frame invisible:**
   - Hold **Shears**
   - Press **Shift** (sneak)
   - Right-click the item frame

2. **Make frame visible again:**
   - Same steps: Shears + Shift + Right-click

## Building

### Option 1: Windows (build.bat)
Simply double-click `build.bat` - it will automatically find Java and Maven!

### Option 2: GitHub Actions
Push to GitHub and the plugin will be built automatically. Download JAR from:
- Actions tab → Latest workflow run → Artifacts
- Or from Releases section

### Option 3: Manual
```bash
mvn clean package
```

## Installation

1. Copy `target/InvisibleFrames-2.0.0.jar` to your server's `plugins/` folder
2. Restart the server

## Permissions

- `invisibleframes.use` - Toggle frame visibility (default: true)
- `invisibleframes.interact` - Interact with invisible frames (default: op)
- `invisibleframes.break` - Break invisible frames (default: op)

## Requirements

- Paper 1.21+ (or compatible forks)
- Java 21+

## License

MIT License - feel free to modify and distribute!

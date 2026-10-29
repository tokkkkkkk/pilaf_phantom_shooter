# Pilaf Phantom Shooter

Pilaf Phantom Shooter is a two-player 2D Java game built with Swing. Players move around the map, fire projectiles, and try to survive.

## Requirements

- Java Development Kit (JDK) 16 or newer
- Eclipse IDE, IntelliJ IDEA, or VS Code with Java support

Eclipse is mentioned because this project includes Eclipse configuration files
(`.project`, `.classpath`, and `.settings`). It is not required; the game can
also be compiled and run from the command line.

## Run with Eclipse

1. Clone or download this repository.
2. In Eclipse, choose **File > Import > Existing Projects into Workspace**.
3. Select the `gioco` folder.
4. Run `src/Main/Main.java` as a Java application.

## Run from the command line

From the `gioco` directory:

```powershell
javac -d bin (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })
java -cp "bin;res" Main.Main
```

The `res` directory must remain available because it contains the maps, player sprites, projectile sprites, and tiles used by the game.

## Controls

### Player 1

| Action | Key |
|---|---|
| Move | `W` `A` `S` `D` |
| Shoot | `F` |

### Player 2

| Action | Key |
|---|---|
| Move | Arrow keys |
| Shoot | `M` |

### Menus

- Use the arrow keys to navigate the title screen.
- Press `Enter` to select an option.

## Project structure

```text
gioco/
├── src/       Java source code
├── res/       Maps and game assets
├── bin/       Compiled classes
├── .classpath Eclipse classpath configuration
└── .project   Eclipse project configuration
```

## Notes

- The game starts on the title screen.
- The window is fixed at 768 x 576 pixels.
- Compiled `.class` files are included in the existing `bin` directory for Eclipse compatibility; they can be regenerated from `src`.

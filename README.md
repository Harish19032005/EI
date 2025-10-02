# README.md

This repository contains **Space Rescue Mission** for **Exercise-1** and **Mars Rovers** for **Exercise-2**:

- `SpaceRescue` — a collection of design-pattern example programs (source under `src/`), with multiple runnable mains demonstrating Mediator, Strategy, Factory, Singleton, Composite, Facade, etc.

- `MarsRover` — a Mars Rover simulation (source under `app/`, `commands/`, `grid/`, `rover/`) that uses the Command Pattern and includes obstacle and bounds handling, logging, and input validation.

## Project 1 — SpaceRescue (Design Pattern Examples)

### What it is
`SpaceRescue` is a curated set of small Java programs that demonstrate classic design patterns in a space-themed context. The project includes both **source** (`src/`) and **compiled classes** (`out/`). Each pattern example has a `*Main.java` that can be executed to see the pattern in action.

### Top-level layout (inside `SpaceRescue/`)
```
SpaceRescue/
  README.md
  src/
    behavioral/
      mediator/         (Mediator example — `MediatorMain.java`)
      strategy/         (Strategy example — `StrategyMain.java`)
    creational/
      abstractfactory/  (Abstract Factory example — `AbstractFactoryMain.java`)
      singleton/        (Singleton example — `SingletonMain.java`)
    structural/
      composite/        (Composite example — `CompositeMain.java`)
      facade/           (Facade example — `FacadeMain.java`)
    common/
      exceptions/       (custom exceptions)
      logging/          (AppLogger utility)
      utils/            (InputValidator etc.)
  out/                  (compiled .class files — useful if you want to run without compiling)
  README.md
```

### Main (runnable) classes found
- `src/behavioral/mediator/MediatorMain.java`
- `src/behavioral/strategy/StrategyMain.java`
- `src/creational/abstractfactory/AbstractFactoryMain.java`
- `src/creational/singleton/SingletonMain.java`
- `src/structural/composite/CompositeMain.java`
- `src/structural/facade/FacadeMain.java`

### How to compile and run (recommended)
**Unix / macOS (bash):**
```bash
cd SpaceRescue
mkdir -p out
find src -name "*.java" > sources.txt
javac -d out @sources.txt
# Run one of the mains, e.g. mediator example:
java -cp out behavioral.mediator.MediatorMain
```

**Windows (CMD):**
```cmd
cd \path\to\SpaceRescue
mkdir out
(for /r %i in (*.java) do @echo %i) > sources.txt
javac -d out @sources.txt
REM Run mediator example:
java -cp out behavioral.mediator.MediatorMain
```

> Note: you can also run compiled classes directly from `out/` if present (no need to recompile). On Windows, be careful with `(` and `)` in commands — use the exact shell instructions above.

### Notes & features
- Project includes a small `common.logging.AppLogger` — a centralized logging helper used by examples (so output is consistent).  
- `common.utils.InputValidator` and `common.exceptions.InvalidActionException` are used by demos to enforce correct inputs.  
- This project is ideal for studying how patterns are structured and wired together in small examples.

---

## Project 2 — MarsRover (Rover Simulation)

### What it is
`MarsRover` is a console-based rover simulator that accepts a grid size, obstacles, start position/direction, and a sequence of commands. It uses the **Command Pattern** to model actions and includes logging, defensive input handling, and detailed status reporting (final coordinates, facing direction, obstacles encountered, out-of-bounds attempts).

### Top-level layout (inside `MarsRover/`)
```
MarsRover/
  README.md
  app/
    Main.java
    PositiveInput.java
  commands/
    Command.java
    ExecutionerCommand.java
    MoveCommand.java
    TurnLeftCommand.java
    TurnRightCommand.java
    TurnBackCommand.java
  grid/
    Grid.java
    Obstacle.java
  rover/
    Direction.java
    Rover.java
    StatusReport.java
```

### Entry point
- `app/Main.java` (package `app`) — the interactive CLI entry point

### How to compile and run (no output folder, simple)
**Windows CMD (from `MarsRover` directory):**
```cmd
cd \path\to\MarsRover
javac app\*.java commands\*.java grid\*.java rover\*.java
java app.Main
```

**Unix / macOS (bash):**
```bash
cd /path/to/MarsRover
javac app/*.java commands/*.java grid/*.java rover/*.java
java app.Main
```

(If you'd prefer compiled classes in a dedicated folder: `javac -d out app/*.java ...` then `java -cp out app.Main`.)

### Example run (interactive)
```
Enter grid width(Positive): 10
Enter grid height(Positive): 10
Enter number of obstacles(Positive): 2
Enter obstacle 1 x-coordinate(positive): 2
Enter obstacle 1 y-coordinate(positive): 2
Enter obstacle 2 x-coordinate(positive): 3
Enter obstacle 2 y-coordinate(positive): 5
Enter starting x-coordinate(positive): 0
Enter starting y-coordinate(positive): 0
Enter starting direction (N/E/S/W): N
Enter commands (M for move, L for turn left, R for turn right):
MMRMLM
```
**Expected output (example)**:
```
Final Position: (1, 3, N)
Status Report: "Rover is at (1, 3) facing North. No Obstacles detected. No Out-of-bounds detected."
```

> The `Direction` enum prints full direction names (North/East/South/West) in status messages, and short codes (N/E/S/W) appear in the `Final Position` line.

### Important implementation:
- `PositiveInput` performs defensive input parsing and retries on invalid tokens.  
- `Rover` stores encountered positions as formatted strings like `(x,y)` for reliable equality/printing.  
- `ExecutionerCommand` wraps command execution with logging and per-command exception handling (so one command failing won't abort the whole run).  
- `Grid` validates size and exposes `getWidth()`/`getHeight()` and a safe `getObstacles()` accessor.  

---


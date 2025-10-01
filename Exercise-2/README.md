
# Mars Rover Simulation

## Overview

The Mars Rover Simulation is a Java console application that simulates a Rover navigating a 2D grid-based terrain. The Rover can move forward, turn left, turn right, and turn back, while avoiding obstacles and staying within the grid boundaries.

This project emphasizes Object-Oriented Programming (OOP) principles, the Command Pattern, and modular design for extensibility.

## Problem Description

Manually simulating rover movements on Mars terrain can be cumbersome. This project automates rover navigation with:

- Grid boundary checks
- Obstacle detection
- Directional turns
- Status reporting

It allows interactive user input for grid size, obstacles, starting position, and command sequence.

## Features

### Rover Capabilities

- Move forward (M)
- Turn left (L)
- Turn right (R)
- Turn back (B)

### Obstacle & Grid Handling

- Detect and record obstacles
- Prevent rover from leaving the grid
- Report final rover status

### Status Reporting

- Final position (x, y)
- Facing direction (N/E/S/W)
- Obstacles encountered
- Out-of-bound attempts

## Application Flow

1. Enter grid dimensions
2. Add obstacles
3. Enter rover’s starting position and direction
4. Input command sequence (M, L, R, B)
5. View status report

## Project Structure

```text
app/
    Main.java
    PositiveInput.java
commands/
    Command.java
    ExecutionerCommand.java
    MoveCommand.java
    TurnBackCommand.java
    TurnLeftCommand.java
    TurnRightCommand.java
grid/
    Grid.java
    Obstacle.java
rover/
    Direction.java
    Rover.java
    StatusReport.java
```

- **app/**: Entry point and main application logic
- **commands/**: Command pattern implementations for rover actions
- **grid/**: Grid and obstacle management
- **rover/**: Rover state, direction, and status reporting

## How to Run

Open Command Prompt in the project directory and run:

```bat
javac app\*.java commands\*.java grid\*.java rover\*.java
java app.Main
```

## Sample Run

```text
Enter grid width(Positive): 10
Enter grid height(Positive): 10
Enter number of obstacles(Positive): 2
Enter obstacle 1 x-coordinate(positive): 1
Enter obstacle 1 y-coordinate(positive): 1
Enter obstacle 2 x-coordinate(positive): 1
Enter obstacle 2 y-coordinate(positive): 2
Enter starting x-coordinate(positive): 0
Enter starting y-coordinate(positive): 0
Enter starting direction (N/E/S/W): n
Enter commands (M for move, L for turn left, R for turn right, B for back):
mrmlmrmlmmmbm
Oct 02, 2025 12:57:24 AM commands.ExecutionerCommand execute
INFO: Beginning command execution: 13 commands.
Oct 02, 2025 12:57:25 AM commands.ExecutionerCommand execute
INFO: Finished command execution.
Rover is at (0, 4) facing South
Rover did not attempt to move out of bounds.
Rover encountered obstacles at:
    (1,2)
    (1,1)
```




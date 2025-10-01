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
```
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
1. Compile all Java files:
   ```sh
   javac app/*.java commands/*.java grid/*.java rover/*.java
   ```
2. Run the application:
   ```sh
   java app.Main
   ```
## Example

```console
E:\MarsRover> java app.Main

Enter the Grid Dimensions:
Enter grid width(Positive): 10
Enter grid height(Positive): 10

Enter the No. of Obstacles:
Enter number of obstacles(Positive): 2

Enter the Coordinates of the Obstacles:
Enter obstacle 1 x-coordinate(positive): 1
Enter obstacle 1 y-coordinate(positive): 1
Enter obstacle 2 x-coordinate(positive): 1
Enter obstacle 2 y-coordinate(positive): 2

Enter the Coordinates of the Rover:
Enter starting x-coordinate(positive): 0
Enter starting y-coordinate(positive): 0
Enter starting direction (N/E/S/W): n

Enter commands (M for move, L for turn left, R for turn right, B for turn back):
mrmlmrmlmrmmbm

Output : 
Rover is at (1, 3) facing West
Rover did not attempt to move out of bounds.
Rover encountered obstacles at:
    (1, 1)
    (1, 2)
```



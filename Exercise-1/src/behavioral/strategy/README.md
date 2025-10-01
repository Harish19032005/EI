# Strategy Pattern - SpaceRescueMission

This module demonstrates the **Strategy** design pattern in a space mission context. It enables dynamic selection of rescue strategies for missions.

## Structure
- `DirectRescue`, `EnergySavingRescue`, `StealthRescue`: Concrete strategy classes
- `MissionContext`: Context class for executing strategies
- `RescueStrategy`: Strategy interface
- `StrategyMain`: Demo main class


```

## Example

### How to Compile
```shell
javac -d out src\common\logging\AppLogger.java src\common\utils\InputValidator.java src\common\exceptions\*.java src\behavioral\strategy\interfaces\*.java src\behavioral\strategy\*.java
```

### How to Run
```shell
java -cp out behavioral.strategy.StrategyMain
```

### Sample Interaction

#### 1. Direct Rescue
```text
--- Rescue Mission Planning ---
1. Choose Rescue Strategy
2. Execute Mission
3. Exit
Enter choice: 1
Select a strategy:
1. Direct Rescue
2. Stealth Rescue
3. Energy-Saving Rescue
1
[INFO ] 2025-10-01 23:18:22 - Strategy set to: Direct Rescue

--- Rescue Mission Planning ---
1. Choose Rescue Strategy
2. Execute Mission
3. Exit
Enter choice: 2
Enter distance to target: 10
Enter available fuel: 100
Enter time limit: 25
[INFO ] 2025-10-01 23:19:31 - Direct Rescue succeeded.
[INFO ] 2025-10-01 23:19:31 - Result: Mission Success via Direct Rescue!
```

#### 2. Stealth Rescue
```text
Select a strategy:
1. Direct Rescue
2. Stealth Rescue
3. Energy-Saving Rescue
2
[INFO ] 2025-10-01 23:18:33 - Strategy set to: Stealth Rescue

--- Rescue Mission Planning ---
1. Choose Rescue Strategy
2. Execute Mission
3. Exit
Enter choice: 2
Enter distance to target: 10
Enter available fuel: 100
Enter time limit: 30
[INFO ] 2025-10-01 23:19:47 - Stealth Rescue succeeded.
[INFO ] 2025-10-01 23:19:47 - Result: Mission Success via Stealth Rescue!
```

#### 3. Energy-Saving Rescue
```text
Enter choice: 1
Select a strategy:
1. Direct Rescue
2. Stealth Rescue
3. Energy-Saving Rescue
3
[INFO ] 2025-10-01 23:18:40 - Strategy set to: Energy-Saving Rescue

--- Rescue Mission Planning ---
1. Choose Rescue Strategy
2. Execute Mission
3. Exit
Enter choice: 2
Enter distance to target: 10
Enter available fuel: 100
Enter time limit: 50
[INFO ] 2025-10-01 23:18:58 - Energy-Saving Rescue succeeded.
[INFO ] 2025-10-01 23:18:58 - Result: Mission Success via Energy-Saving Rescue!
```
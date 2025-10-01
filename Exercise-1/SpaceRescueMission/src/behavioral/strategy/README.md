# Strategy Pattern - SpaceRescueMission

This module demonstrates the **Strategy** design pattern in a space mission context. It enables dynamic selection of rescue strategies for missions.

## Structure
- `DirectRescue`, `EnergySavingRescue`, `StealthRescue`: Concrete strategy classes
- `MissionContext`: Context class for executing strategies
- `RescueStrategy`: Strategy interface
- `StrategyMain`: Demo main class

## How to Compile
To compile, use this command:
```
javac -d out src\common\logging\AppLogger.java src\common\utils\InputValidator.java src\common\exceptions\*.java src\behavioral\strategy\interfaces\*.java src\behavioral\strategy\*.java
```

## How to Run
```
java -cp out behavioral.strategy.StrategyMain
```

## Pattern Highlights
- Allows runtime selection of algorithms
- Promotes flexibility and code reuse

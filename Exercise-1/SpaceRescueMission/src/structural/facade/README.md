# Facade Pattern - SpaceRescueMission

This module demonstrates the **Facade** design pattern in a space mission context. It provides a simplified interface to complex life support subsystems.

## Structure
- `LifeSupportFacade`: Facade class
- `OxygenSystem`, `PowerSystem`, `WaterSystem`: Subsystem classes
- `FacadeMain`: Demo main class

## How to Compile
To compile, use this command:
```
javac -d out src\common\logging\AppLogger.java src\common\utils\InputValidator.java src\common\exceptions\*.java src\structural\facade\*.java
```

## How to Run
```
java -cp out structural.facade.FacadeMain
```

## Pattern Highlights
- Simplifies interaction with multiple subsystems
- Promotes loose coupling between client and subsystems

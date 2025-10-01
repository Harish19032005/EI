# Facade Pattern - SpaceRescueMission

This module demonstrates the **Facade** design pattern in a space mission context. It provides a simplified interface to complex life support subsystems.

## Structure
- `LifeSupportFacade`: Facade class
- `OxygenSystem`, `PowerSystem`, `WaterSystem`: Subsystem classes
- `FacadeMain`: Demo main class

## Example

**Step 1: Compile**
```shell
javac -d out src\common\logging\AppLogger.java src\common\utils\InputValidator.java src\common\exceptions\*.java src\structural\facade\*.java
```

**Step 2: Run**
```shell
java -cp out structural.facade.FacadeMain
```

**Sample Output:**
```
[INFO ] 2025-10-01 23:35:32 - --- Colony Life Support (Facade Pattern) ---
[INFO ] 2025-10-01 23:35:32 - Starting life support...
[INFO ] 2025-10-01 23:35:32 - Oxygen system started.
[INFO ] 2025-10-01 23:35:32 - Water circulation system started.
[INFO ] 2025-10-01 23:35:32 - Power grid activated.
[INFO ] 2025-10-01 23:35:32 - Life support fully operational.
[INFO ] 2025-10-01 23:35:32 - Colony systems running...
[INFO ] 2025-10-01 23:35:32 - Stopping life support...
[INFO ] 2025-10-01 23:35:32 - Oxygen system stopped.
[INFO ] 2025-10-01 23:35:32 - Water circulation system stopped.
[INFO ] 2025-10-01 23:35:32 - Power grid shut down.
[INFO ] 2025-10-01 23:35:32 - Life support systems offline.
```

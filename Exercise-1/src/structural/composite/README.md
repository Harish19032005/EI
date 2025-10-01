# Composite Pattern - SpaceRescueMission

This module demonstrates the **Composite** design pattern in a space mission context. It allows you to treat individual resources and groups of resources uniformly.

## Structure
- `ColonyResourceGroup`: Composite class for grouping resources
- `Food`, `Medicine`, `Water`: Leaf resource classes
- `Resource`: Resource interface
- `CompositeMain`: Demo main class

## Example

**Step 1: Compile**
```shell
javac -d out src\common\logging\AppLogger.java src\common\utils\InputValidator.java src\common\exceptions\*.java src\structural\composite\interfaces\*.java src\structural\composite\*.java
```

**Step 2: Run**
```shell
java -cp out structural.composite.CompositeMain
```

**Sample Output:**
```
[INFO ] 2025-10-01 23:45:56 - --- Colony Resource Management (Composite Pattern) ---
[INFO ] 2025-10-01 23:45:56 - Resource Group: Main Colony
[INFO ] 2025-10-01 23:45:56 - Resource Group: Storage Room
[INFO ] 2025-10-01 23:45:56 - Resource: Food | Quantity: 500
[INFO ] 2025-10-01 23:45:56 - Resource: Water | Quantity: 1000
[INFO ] 2025-10-01 23:45:56 - Total in Storage Room: 1500
[INFO ] 2025-10-01 23:45:56 - Resource Group: Hospital Wing
[INFO ] 2025-10-01 23:45:56 - Resource: Medicine | Quantity: 200
[INFO ] 2025-10-01 23:45:56 - Total in Hospital Wing: 200
[INFO ] 2025-10-01 23:45:56 - Total in Main Colony: 1700
```

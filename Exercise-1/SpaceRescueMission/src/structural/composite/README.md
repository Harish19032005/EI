# Composite Pattern - SpaceRescueMission

This module demonstrates the **Composite** design pattern in a space mission context. It allows you to treat individual resources and groups of resources uniformly.

## Structure
- `ColonyResourceGroup`: Composite class for grouping resources
- `Food`, `Medicine`, `Water`: Leaf resource classes
- `Resource`: Resource interface
- `CompositeMain`: Demo main class

## How to Compile
To compile, use this command:
```
javac -d out src\common\logging\AppLogger.java src\common\utils\InputValidator.java src\common\exceptions\*.java src\structural\composite\interfaces\*.java src\structural\composite\*.java
```

## How to Run
```
java -cp out structural.composite.CompositeMain
```

## Pattern Highlights
- Supports hierarchical resource management
- Treats individual and composite resources uniformly

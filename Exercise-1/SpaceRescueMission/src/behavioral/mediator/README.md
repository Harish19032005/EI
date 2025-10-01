# Mediator Pattern - SpaceRescueMission

This module demonstrates the **Mediator** design pattern in a space mission context. It centralizes communication between astronauts, satellites, and ground stations.

## Structure
- `Astronaut`, `Satellite`, `GroundStation`: Communicating entities
- `CommunicationCenter`: Mediator class
- `Message`: Message class
- `Communicator`, `MissionMediator`: Interfaces
- `MediatorMain`: Demo main class

## How to Compile
To compile, use this command:
```
javac -d out src\common\logging\AppLogger.java src\common\utils\InputValidator.java src\common\exceptions\InvalidActionException.java src\behavioral\mediator\interfaces\*.java src\behavioral\mediator\*.java
```

## How to Run
```
java -cp out behavioral.mediator.MediatorMain
```

## Pattern Highlights
- Centralizes and manages complex communication logic
- Reduces coupling between communicating entities

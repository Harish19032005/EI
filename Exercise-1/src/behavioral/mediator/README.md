# Mediator Pattern - SpaceRescueMission

This module demonstrates the **Mediator** design pattern in a space mission context. It centralizes communication between astronauts, satellites, and ground stations.

## Structure
- `Astronaut`, `Satellite`, `GroundStation`: Communicating entities
- `CommunicationCenter`: Mediator class
- `Message`: Message class
- `Communicator`, `MissionMediator`: Interfaces
- `MediatorMain`: Demo main class

## Example
### Example Usage

**Step 1: Compile**
```shell
javac -d out src\common\logging\AppLogger.java src\common\utils\InputValidator.java src\common\exceptions\InvalidActionException.java src\behavioral\mediator\interfaces\*.java src\behavioral\mediator\*.java
```

**Step 2: Run**
```shell
java -cp out behavioral.mediator.MediatorMain
```

**Sample Interaction:**
```
--- Communication Center Menu ---
1. Send Message
2. View Communication Log
3. Exit
Enter choice: 1
Choose sender:
1. Neil
2. Hubble
3. Houston
2
Choose recipient:
1. Neil
3. Houston
3
Enter your message: Hello Houston!!!
[INFO ] 2025-10-01 20:39:22 - GroundStation Houston received message from Hubble: Hello Houston!!!
[INFO ] 2025-10-01 20:39:22 - Message delivered from Hubble to Houston after 1 attempt(s).

--- Communication Center Menu ---
1. Send Message
2. View Communication Log
3. Exit
Enter choice: 2
[INFO ] 2025-10-01 20:39:26 - ---- Communication Log ----
[INFO ] 2025-10-01 20:39:26 - [From: Hubble -> To: Houston] Content: "Hello Houston!!!" | Delivered: true
```
3. Exit
Enter choice: 3
[INFO ] 2025-10-01 20:39:33 - Exiting Communication Center...
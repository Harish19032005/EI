# Abstract Factory Pattern - SpaceRescueMission

This module demonstrates the **Abstract Factory** design pattern in a space mission context. It allows the creation of families of related spacecraft (e.g., rovers and shuttles) without specifying their concrete classes.

## Structure
- `Rover`, `Shuttle`: Concrete spacecraft classes
- `RoverFactory`, `ShuttleFactory`: Concrete factories
- `Spacecraft`, `SpacecraftFactory`: Interfaces for spacecraft and factories
- `AbstractFactoryMain`: Demo main class

## Example

### Example Usage

**Step 1: Compile**
```shell
javac -d out src\common\exceptions\*.java src\common\logging\*.java src\common\utils\*.java src\creational\abstractfactory\interfaces\*.java src\creational\abstractfactory\*.java
```

**Step 2: Run**
```shell
java -cp out creational.abstractfactory.AbstractFactoryMain
```

**Sample Interaction (Rover):**
```
[INFO ] 2025-10-01 23:26:31 - Choose spacecraft type:
1. Rover
2. Shuttle
[INFO ] 2025-10-01 23:26:31 - Enter choice:
1
[INFO ] 2025-10-01 23:26:33 - Enter spacecraft name:
Pluto
[INFO ] 2025-10-01 23:26:52 - Enter crew capacity (1-10):
5
[INFO ] 2025-10-01 23:26:54 - Rover Pluto created with crew capacity 5

Menu:
1. Launch
2. Land
3. Refuel
4. Status
5. Exit
[INFO ] 2025-10-01 23:26:54 - Enter action:
1
[INFO ] 2025-10-01 23:26:57 - Rover Pluto launched. Fuel left: 80

Menu:
1. Launch
2. Land
3. Refuel
4. Status
5. Exit
[INFO ] 2025-10-01 23:26:57 - Enter action:
2
[INFO ] 2025-10-01 23:27:03 - Rover Pluto landed safely.

Menu:
1. Launch
2. Land
3. Refuel
4. Status
5. Exit
[INFO ] 2025-10-01 23:27:03 - Enter action:
3
[INFO ] 2025-10-01 23:27:06 - Enter fuel to add (10-50):
20
[INFO ] 2025-10-01 23:27:10 - Rover Pluto refueled. Current fuel: 100

Menu:
1. Launch
2. Land
3. Refuel
4. Status
5. Exit
[INFO ] 2025-10-01 23:27:10 - Enter action:
4
[INFO ] 2025-10-01 23:27:12 - Rover Pluto [Crew: 5, Fuel: 100, Status: LANDED]

Menu:
1. Launch
2. Land
3. Refuel
4. Status
5. Exit
[INFO ] 2025-10-01 23:27:12 - Enter action:
5
[INFO ] 2025-10-01 23:27:16 - Exiting mission control...
```

**Sample Interaction (Shuttle):**
```
[INFO ] 2025-10-01 23:27:26 - Choose spacecraft type:
1. Rover
2. Shuttle
[INFO ] 2025-10-01 23:27:27 - Enter choice:
2
[INFO ] 2025-10-01 23:27:28 - Enter spacecraft name:
Mercury
[INFO ] 2025-10-01 23:27:42 - Enter crew capacity (1-10):
10
[INFO ] 2025-10-01 23:27:45 - Shuttle Mercury created with crew capacity 10

Menu:
1. Launch
2. Land
3. Refuel
4. Status
5. Exit
[INFO ] 2025-10-01 23:27:45 - Enter action:
1
[INFO ] 2025-10-01 23:27:47 - Shuttle Mercury launched. Fuel left: 110

Menu:
1. Launch
2. Land
3. Refuel
4. Status
5. Exit
[INFO ] 2025-10-01 23:27:47 - Enter action:
2
[INFO ] 2025-10-01 23:27:55 - Shuttle Mercury landed successfully.

Menu:
1. Launch
2. Land
3. Refuel
4. Status
5. Exit
[INFO ] 2025-10-01 23:27:55 - Enter action:
3
[INFO ] 2025-10-01 23:27:57 - Enter fuel to add (10-50):
40
[INFO ] 2025-10-01 23:27:59 - Shuttle Mercury refueled. Current fuel: 150

Menu:
1. Launch
2. Land
3. Refuel
4. Status
5. Exit
[INFO ] 2025-10-01 23:27:59 - Enter action:
4
[INFO ] 2025-10-01 23:28:06 - Shuttle Mercury [Crew: 10, Fuel: 150, Status: LANDED]

Menu:
1. Launch
2. Land
3. Refuel
4. Status
5. Exit
[INFO ] 2025-10-01 23:28:06 - Enter action:
5
[INFO ] 2025-10-01 23:28:10 - Exiting mission control...
```

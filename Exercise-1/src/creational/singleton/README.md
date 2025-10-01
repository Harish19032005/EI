# Singleton Pattern - SpaceRescueMission

This module demonstrates the **Singleton** design pattern in a space mission context. It ensures that only one instance of the configuration manager exists throughout the application.

## Structure
- `ConfigManager`: Singleton class for managing configuration
- `SingletonMain`: Demo main class

## Example

**Step 1: Compile**
```shell
javac -d out src\creational\singleton\*.java src\common\logging\*.java
```

**Step 2: Run**
```shell
java -cp out creational.singleton.SingletonMain
```

**Sample Output:**
```
[INFO ] 2025-10-01 23:39:12 - Accessing ConfigManager Singleton...
[INFO ] 2025-10-01 23:39:12 - Loading configuration settings...
[INFO ] 2025-10-01 23:39:12 - Confirmed: Both variables reference the SAME instance!

Config Manager Menu:
1. Show all configs
2. Get a config value
3. Update a config value
4. Exit
Enter choice: 1
[INFO ] 2025-10-01 23:39:17 - Current configurations: {mission=Mars Rescue, fuelCapacity=1000, maxCrew=5}

Config Manager Menu:
1. Show all configs
2. Get a config value
3. Update a config value
4. Exit
Enter choice: 3
Enter config key: 2
Enter new value: 20
[INFO ] 2025-10-01 23:39:34 - Config updated: 2 = 20

Config Manager Menu:
1. Show all configs
2. Get a config value
3. Update a config value
4. Exit
Enter choice: 2
Enter config key: 2
[INFO ] 2025-10-01 23:39:40 - Value: 20

Config Manager Menu:
1. Show all configs
2. Get a config value
3. Update a config value
4. Exit
Enter choice: 1
[INFO ] 2025-10-01 23:39:44 - Current configurations: {mission=Mars Rescue, 2=20, fuelCapacity=1000, maxCrew=5}

Config Manager Menu:
1. Show all configs
2. Get a config value
3. Update a config value
4. Exit
Enter choice: 3
Enter config key: 1
Enter new value: 10
[INFO ] 2025-10-01 23:39:57 - Config updated: 1 = 10

Config Manager Menu:
1. Show all configs
2. Get a config value
3. Update a config value
4. Exit
Enter choice: 1
[INFO ] 2025-10-01 23:40:01 - Current configurations: {1=10, mission=Mars Rescue, 2=20, fuelCapacity=1000, maxCrew=5}

Config Manager Menu:
1. Show all configs
2. Get a config value
3. Update a config value
4. Exit
Enter choice: 4
[INFO ] 2025-10-01 23:40:06 - Exiting ConfigManager demo.
```

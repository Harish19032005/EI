package creational.singleton;

import common.logging.AppLogger;

import java.util.Scanner;

public class SingletonMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AppLogger.info("Accessing ConfigManager Singleton...");
        ConfigManager config1 = ConfigManager.getInstance();
        ConfigManager config2 = ConfigManager.getInstance();

        // Prove both references point to the same instance
        if (config1 == config2) {
            AppLogger.info("Confirmed: Both variables reference the SAME instance!");
        }

        boolean running = true;
        while (running) {
            System.out.println("\nConfig Manager Menu:");
            System.out.println("1. Show all configs");
            System.out.println("2. Get a config value");
            System.out.println("3. Update a config value");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> config1.showAllConfigs();
                case 2 -> {
                    System.out.print("Enter config key: ");
                    String key = sc.nextLine();
                    AppLogger.info("Value: " + config1.getConfig(key));
                }
                case 3 -> {
                    System.out.print("Enter config key: ");
                    String key = sc.nextLine();
                    System.out.print("Enter new value: ");
                    String value = sc.nextLine();
                    config1.setConfig(key, value);
                }
                case 4 -> running = false;
                default -> AppLogger.warning("Invalid choice!");
            }
        }

        sc.close();
        AppLogger.info("Exiting ConfigManager demo.");
    }
}

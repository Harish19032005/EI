package creational.abstractfactory;

import common.exceptions.InvalidActionException;
import common.logging.AppLogger;
import common.utils.InputValidator;
import creational.abstractfactory.interfaces.Spacecraft;
import creational.abstractfactory.interfaces.SpacecraftFactory;

import java.util.Scanner;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AppLogger.info("Choose spacecraft type:\n1. Rover\n2. Shuttle");
        int choice = InputValidator.getIntInput(sc, "Enter choice: ", 1, 2);
        String name = InputValidator.getStringInput(sc, "Enter spacecraft name: ");
        int crew = InputValidator.getIntInput(sc, "Enter crew capacity (1-10): ", 1, 10);

        SpacecraftFactory factory = (choice == 1) ? new RoverFactory() : new ShuttleFactory();
        Spacecraft spacecraft = factory.createSpacecraft(name, crew);

        boolean running = true;
        while (running) {
            AppLogger.info("\nMenu:\n1. Launch\n2. Land\n3. Refuel\n4. Status\n5. Exit");
            int action = InputValidator.getIntInput(sc, "Enter action: ", 1, 5);

            try {
                switch (action) {
                    case 1 -> spacecraft.launch();
                    case 2 -> spacecraft.land();
                    case 3 -> {
                        int fuel = InputValidator.getIntInput(sc, "Enter fuel to add (10-50): ", 10, 50);
                        spacecraft.refuel(fuel);
                    }
                    case 4 -> spacecraft.showStatus();
                    case 5 -> {
                        AppLogger.info("Exiting mission control...");
                        running = false;
                    }
                }
            } catch (InvalidActionException e) {
                AppLogger.error("Action failed: " + e.getMessage());
            } catch (Exception e) {
                AppLogger.error("Unexpected error: " + e.getMessage());
            }
        }
        sc.close();
    }
}

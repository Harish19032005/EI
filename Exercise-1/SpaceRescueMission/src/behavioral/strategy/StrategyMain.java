package behavioral.strategy;

import behavioral.strategy.interfaces.RescueStrategy;
import common.exceptions.InvalidActionException;
import common.logging.AppLogger;
import common.utils.InputValidator;

import java.util.Scanner;

public class StrategyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MissionContext context = new MissionContext();

        RescueStrategy[] strategies = {
                new DirectRescue(),
                new StealthRescue(),
                new EnergySavingRescue()
        };

        boolean running = true;
        while (running) {
            AppLogger.info("\n--- Rescue Mission Planning ---");
            System.out.println("1. Choose Rescue Strategy");
            System.out.println("2. Execute Mission");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = InputValidator.validateInt(scanner.nextLine(), 1, 3);

                switch (choice) {
                    case 1 -> {
                        System.out.println("Select a strategy:");
                        for (int i = 0; i < strategies.length; i++) {
                            System.out.println((i + 1) + ". " + strategies[i].getName());
                        }
                        int strategyChoice = InputValidator.validateInt(scanner.nextLine(), 1, strategies.length);
                        context.setStrategy(strategies[strategyChoice - 1]);
                        AppLogger.info("Strategy set to: " + context.getCurrentStrategyName());
                    }
                    case 2 -> {
                        if (context.getCurrentStrategyName().equals("None")) {
                            AppLogger.warning("No strategy selected. Please choose a strategy first.");
                            break;
                        }
                        System.out.print("Enter distance to target: ");
                        int distance = InputValidator.validateInt(scanner.nextLine(), 1, 1000);

                        System.out.print("Enter available fuel: ");
                        int fuel = InputValidator.validateInt(scanner.nextLine(), 1, 10000);

                        System.out.print("Enter time limit: ");
                        int timeLimit = InputValidator.validateInt(scanner.nextLine(), 1, 1000);

                        String result = context.executeStrategy(distance, fuel, timeLimit);
                        AppLogger.info("Result: " + result);
                    }
                    case 3 -> {
                        AppLogger.info("Exiting Rescue Mission Planning...");
                        running = false;
                    }
                }
            } catch (InvalidActionException e) {
                AppLogger.error("Invalid input: " + e.getMessage());
            }
        }
    }
}

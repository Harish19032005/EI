package common.utils;

import java.util.Scanner;

import common.exceptions.InvalidActionException;
import common.logging.AppLogger;

public class InputValidator {
    public static int getIntInput(Scanner sc, String prompt, int min, int max) {
        while (true) {
            try {
                AppLogger.info(prompt);
                int value = Integer.parseInt(sc.nextLine());
                if (value < min || value > max) {
                    AppLogger.warning("Value must be between " + min + " and " + max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                AppLogger.error("Invalid number. Try again.");
            }
        }
    }

    public static String getStringInput(Scanner sc, String prompt) {
        AppLogger.info(prompt);
        String value = sc.nextLine().trim();
        while (value.isEmpty()) {
            AppLogger.warning("Input cannot be empty. Try again.");
            value = sc.nextLine().trim();
        }
        return value;
    }

    public static int validateInt(String input, int min, int max) throws InvalidActionException {
        try {
            int value = Integer.parseInt(input);
            if (value < min || value > max) {
                throw new InvalidActionException("Input must be between " + min + " and " + max + ".");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new InvalidActionException("Invalid number format.");
        }
    }
}

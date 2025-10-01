package app;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PositiveInput {
    private static final Logger logger = Logger.getLogger(PositiveInput.class.getName());

    public int readPositiveInt(Scanner sc, String message) {
        int value;
        while (true) {
            System.out.print(message);
            try {
                String token = sc.next();
                value = Integer.parseInt(token);
                if (value > 0) return value;
                System.out.println("Please enter a positive integer greater than 0.");
            } catch (NumberFormatException ex) {
                logger.log(Level.WARNING, "Non-integer entered for positive int: {0}", ex.getMessage());
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Unexpected error while reading positive int", ex);
                System.out.println("Unexpected error. Please try again.");
            }
        }
    }

    public int readPositiveIntWithZero(Scanner sc, String message) {
        int value;
        while (true) {
            System.out.print(message);
            try {
                String token = sc.next();
                value = Integer.parseInt(token);
                if (value >= 0) return value;
                System.out.println("Please enter a non-negative integer (0 or greater).");
            } catch (NumberFormatException ex) {
                logger.log(Level.WARNING, "Non-integer entered for non-negative int: {0}", ex.getMessage());
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Unexpected error while reading non-negative int", ex);
                System.out.println("Unexpected error. Please try again.");
            }
        }
    }
}

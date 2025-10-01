package app;
import commands.*;
import grid.*;
import rover.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Main.class.getName());
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        logger.addHandler(ch);
        logger.setLevel(Level.INFO);
        logger.setUseParentHandlers(false);

        PositiveInput positiveInput = new PositiveInput();

        // Input Grid Size
        int width = positiveInput.readPositiveInt(scanner,"Enter grid width(Positive): ");
        int height = positiveInput.readPositiveInt(scanner,"Enter grid height(Positive): ");

        // Initialize Grid
        Grid grid = new Grid(width, height);

        // Input Obstacles
        int numObstacles = positiveInput.readPositiveIntWithZero(scanner,"Enter number of obstacles(Positive): ");
        for (int i = 0; i < numObstacles; i++) {
            int ox = positiveInput.readPositiveIntWithZero(scanner,"Enter obstacle " + (i + 1) + " x-coordinate(positive): ");
            int oy = positiveInput.readPositiveIntWithZero(scanner,"Enter obstacle " + (i + 1) + " y-coordinate(positive): ");
            if(ox >= width || oy >= height){
                System.out.println("Obstacle "+(i+1)+" is out of grid bounds and thus neglected. Re-enter the coordinates.");
                i--;
                continue;
            }
            grid.addObstacle(new Obstacle(ox, oy));
        }

        // Input Starting Position
        int startX = positiveInput.readPositiveIntWithZero(scanner,"Enter starting x-coordinate(positive): ");
        int startY = positiveInput.readPositiveIntWithZero(scanner,"Enter starting y-coordinate(positive): ");

        Direction startDirection = null;
        while (startDirection == null) {
            System.out.print("Enter starting direction (N/E/S/W): ");
            String dirToken = scanner.next().trim().toUpperCase();
            try {
                startDirection = Direction.valueOf(dirToken);
            } catch (IllegalArgumentException ex) {
                logger.warning("Invalid direction '" + dirToken + "'. Please enter one of: N, E, S, W");
            }
        }

        if (!grid.isWithinBounds(startX, startY)) {
            logger.warning("Starting coordinates are outside the grid. Clamping to (0,0).");
            startX = Math.max(0, Math.min(startX, width - 1));
            startY = Math.max(0, Math.min(startY, height - 1));
        }

        // Initialize Rover
        Rover rover = new Rover(startX, startY, startDirection, grid);

        // Input Commands
        System.out.println("Enter commands (M for move, L for turn left, R for turn right, B for back):");
        scanner.nextLine(); // consume leftover newline
        String commandString = scanner.nextLine().replaceAll("\\s+","");
        char[] commandChars = commandString.toCharArray();
        List<Command> commands=new LinkedList<>();
        for (char cmd:commandChars) {
            switch (Character.toUpperCase(cmd)) {
                case 'M' -> commands.add(new MoveCommand());
                case 'L' -> commands.add(new TurnLeftCommand());
                case 'R' -> commands.add(new TurnRightCommand());
                case 'B' -> commands.add(new TurnBackCommand());
                default -> logger.warning(cmd+" is an invalid command. Thus neglected.");
            }
        }

        // Execute Commands
        ExecutionerCommand commandExecuter = new ExecutionerCommand(commands);
        try {
            commandExecuter.execute(rover);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Unhandled exception while executing commands", ex);
        }

        // Get Status Report
        StatusReport statusReport = rover.getStatusReport();
        System.out.println(statusReport);

        // Print Encountered Obstacles / Out of Bounds
        Set<String> encounteredObstacles = rover.getEncounteredObstacles();
        Set<String> encounteredOutOfBounds = rover.getEncounteredOutOfBounds();

        if (!encounteredOutOfBounds.isEmpty()) {
            System.out.println("Rover attempted to move out of bounds at:");
            for (String outOfBound : encounteredOutOfBounds) {
                System.out.println(outOfBound);
            }
        } else {
            System.out.println("Rover did not attempt to move out of bounds.");
        }
        if (!encounteredObstacles.isEmpty()) {
            System.out.println("Rover encountered obstacles at:");
            for (String obstacle : encounteredObstacles) {
                System.out.println(obstacle);
            }
        } else {
            System.out.println("Rover did not encounter any obstacles.");
        }

        scanner.close();
    }
}

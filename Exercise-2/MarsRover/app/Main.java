package app;

import commands.*;
import grid.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import rover.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
             if(ox>=width || oy>=height){
                 System.out.println("Obstacle "+(i+1)+" is out of grid bounds and thus neglected.Re-enter the coordinates.");
                 i--;
                 continue;
             }
            grid.addObstacle(new Obstacle(ox, oy));
        }

        // Input Starting Position
        int startX = positiveInput.readPositiveIntWithZero(scanner,"Enter starting x-coordinate(positive): ");
        int startY = positiveInput.readPositiveIntWithZero(scanner,"Enter starting y-coordinate(positive): ");
        System.out.print("Enter starting direction (N/E/S/W): ");
        Direction startDirection = Direction.valueOf(scanner.next().toUpperCase());

        // Initialize Rover
        Rover rover = new Rover(startX, startY, startDirection, grid);

        // Input Commands
        System.out.println("Enter commands (M for move, L for turn left, R for turn right,B for turn back):");
        scanner.nextLine();
        String commandString = scanner.nextLine().replaceAll("\\s+","");
        char[] commandChars = commandString.toCharArray();
        List<Command> commands=new LinkedList<>();
        for (char cmd:commandChars) {
            switch (Character.toUpperCase(cmd)) {
                case 'M' -> commands.add(new MoveCommand());
                case 'L' -> commands.add(new TurnLeftCommand());
                case 'R' -> commands.add(new TurnRightCommand());
                case 'B' -> commands.add(new TurnBackCommand());
                default -> System.out.println(cmd+" is an invalid command.Thus Neglected"); 
            }
        }

        // Execute Commands
        ExecutionerCommand commandExecuter = new ExecutionerCommand(commands);
        commandExecuter.execute(rover);       

        // Get Status Report
        StatusReport statusReport = rover.getStatusReport();
        System.out.println(statusReport);

        // Print Encountered Out of Bounds
        Set<String> encounteredOutOfBounds = rover.getEncounteredOutOfBounds();
        if (!encounteredOutOfBounds.isEmpty()) {
            System.out.println("Rover attempted to move out of bounds at:");
            for (String outOfBound : encounteredOutOfBounds) {
                String[] parts = outOfBound.split(",");
                System.out.printf("(%s, %s)%n", parts[0], parts[1]);
            }
        } else {
            System.out.println("Rover did not attempt to move out of bounds.");
        }

        // Print Encountered Obstacles
        Set<String> encounteredObstacles = rover.getEncounteredObstacles();
        if (!encounteredObstacles.isEmpty()) {
            System.out.println("Rover encountered obstacles at:");
            for (String obstacle : encounteredObstacles) {
                String[] parts = obstacle.split(",");
                System.out.printf("(%s, %s)%n", parts[0], parts[1]);
            }
        } else {
            System.out.println("Rover did not encounter any obstacles.");
        }

        scanner.close();
    }
}

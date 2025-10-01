package behavioral.mediator;

import behavioral.mediator.interfaces.Communicator;
import common.exceptions.InvalidActionException;
import common.logging.AppLogger;
import common.utils.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MediatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommunicationCenter mediator = new CommunicationCenter();

        List<Communicator> communicators = new ArrayList<>();
        communicators.add(new Astronaut("Neil", mediator));
        communicators.add(new Satellite("Hubble", mediator));
        communicators.add(new GroundStation("Houston", mediator));

        boolean running = true;
        while (running) {
            AppLogger.info("\n--- Communication Center Menu ---");
            System.out.println("1. Send Message");
            System.out.println("2. View Communication Log");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = InputValidator.validateInt(scanner.nextLine(), 1, 3);
                switch (choice) {
                    case 1 -> {
                        System.out.println("Choose sender:");
                        for (int i = 0; i < communicators.size(); i++) {
                            System.out.println((i + 1) + ". " + communicators.get(i).getName());
                        }
                        int senderIdx = InputValidator.validateInt(scanner.nextLine(), 1, communicators.size()) - 1;
                        Communicator sender = communicators.get(senderIdx);

                        System.out.println("Choose recipient:");
                        for (int i = 0; i < communicators.size(); i++) {
                            if (i != senderIdx) {
                                System.out.println((i + 1) + ". " + communicators.get(i).getName());
                            }
                        }
                        int recipientIdx = InputValidator.validateInt(scanner.nextLine(), 1, communicators.size()) - 1;
                        Communicator recipient = communicators.get(recipientIdx);

                        System.out.print("Enter your message: ");
                        String msg = scanner.nextLine().trim();
                        if (msg.isEmpty()) throw new InvalidActionException("Message cannot be empty.");

                        sender.sendMessage(msg, recipient);
                    }
                    case 2 -> mediator.logAllMessages();
                    case 3 -> {
                        AppLogger.info("Exiting Communication Center...");
                        running = false;
                    }
                }
            } catch (InvalidActionException e) {
                AppLogger.error("Invalid input: " + e.getMessage());
            }
        }
    }
}

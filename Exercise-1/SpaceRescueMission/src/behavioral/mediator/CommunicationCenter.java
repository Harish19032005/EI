package behavioral.mediator;

import behavioral.mediator.interfaces.Communicator;
import behavioral.mediator.interfaces.MissionMediator;
import common.logging.AppLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommunicationCenter implements MissionMediator {
    private final List<Message> messageLog = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void sendMessage(String message, Communicator sender, Communicator recipient) {
        boolean delivered = attemptDelivery(message, sender, recipient, 0);
        messageLog.add(new Message(sender.getName(), recipient.getName(), message, delivered));
    }

    private boolean attemptDelivery(String message, Communicator sender, Communicator recipient, int attempt) {
        // 20% chance of failure
        if (random.nextInt(100) < 20) {
            AppLogger.warning("Delivery failed from " + sender.getName() +
                              " to " + recipient.getName() + " (Attempt " + (attempt + 1) + ")");
            if (attempt < 2) { // retry up to 2 times
                try {
                    Thread.sleep((long) Math.pow(2, attempt) * 500); // exponential backoff
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return attemptDelivery(message, sender, recipient, attempt + 1);
            }
            return false;
        }

        recipient.receiveMessage(message, sender.getName());
        AppLogger.info("Message delivered from " + sender.getName() +
                       " to " + recipient.getName() + " after " + (attempt + 1) + " attempt(s).");
        return true;
    }

    @Override
    public void logAllMessages() {
        AppLogger.info("---- Communication Log ----");
        if (messageLog.isEmpty()) {
            AppLogger.info("No messages recorded.");
        }
        for (Message msg : messageLog) {
            AppLogger.info(msg.toString());
        }
    }
}

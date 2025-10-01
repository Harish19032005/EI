package behavioral.mediator;

import behavioral.mediator.interfaces.Communicator;
import behavioral.mediator.interfaces.MissionMediator;
import common.logging.AppLogger;

public class Astronaut implements Communicator {
    private final String name;
    private final MissionMediator mediator;

    public Astronaut(String name, MissionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sendMessage(String message, Communicator recipient) {
        mediator.sendMessage(message, this, recipient);
    }

    @Override
    public void receiveMessage(String message, String sender) {
        AppLogger.info("Astronaut " + name + " received message from " + sender + ": " + message);
    }
}

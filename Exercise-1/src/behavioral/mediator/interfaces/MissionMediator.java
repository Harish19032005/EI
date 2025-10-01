package behavioral.mediator.interfaces;

public interface MissionMediator {
    void sendMessage(String message, Communicator sender, Communicator recipient);
    void logAllMessages();
}

package behavioral.mediator.interfaces;

public interface Communicator {
    String getName();
    void sendMessage(String message, Communicator recipient);
    void receiveMessage(String message, String sender);
}

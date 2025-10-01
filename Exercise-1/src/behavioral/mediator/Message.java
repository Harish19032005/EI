package behavioral.mediator;

public class Message {
    private final String sender;
    private final String recipient;
    private final String content;
    private final boolean delivered;

    public Message(String sender, String recipient, String content, boolean delivered) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.delivered = delivered;
    }

    @Override
    public String toString() {
        return "[From: " + sender + " -> To: " + recipient +
               "] Content: \"" + content + "\" | Delivered: " + delivered;
    }
}

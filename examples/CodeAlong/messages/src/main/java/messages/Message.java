package messages;

public sealed abstract class Message permits TextMessage, ImageMessage {

    private String sender;
    private long timestamp;

    public abstract void process();
}

package messages;

public final class TextMessage extends Message {

	private String text;

    @Override
    public void process() {
        System.out.println("Processing text message");
        // logic to process a text message
    }

}

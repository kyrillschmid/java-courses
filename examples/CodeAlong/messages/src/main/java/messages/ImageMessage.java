package messages;

public final class ImageMessage extends Message {

    private byte[] imageData;

    @Override
    public void process() {
        System.out.println("Processing image");
        // logic to process an image message
    }

}

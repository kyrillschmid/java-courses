package messages;


public class Main {

    public Main() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        Class<?> cls = Message.class;
        
        // Check if the class is sealed
        System.out.println("Is sealed: " + cls.isSealed());

        // Get the permitted subclasses
        Class<?>[] subclasses = cls.getPermittedSubclasses();
        
        // Print each subclass
        System.out.println("Permitted subclasses:");
        for (Class<?> subclass : subclasses) {
            System.out.println(subclass.getName());
        }
    }
}

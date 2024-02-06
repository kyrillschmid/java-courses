package solid_04_isp;

public class Bird implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Chirp!");
    }

    @Override
    public void swim() {
        // Not applicable for a bird
        throw new UnsupportedOperationException("Birds don't swim");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}

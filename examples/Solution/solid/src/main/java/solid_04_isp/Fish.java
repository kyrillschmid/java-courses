package solid_04_isp;

public class Fish implements Animal {

    @Override
    public void makeSound() {
        // Not applicable for a fish
        throw new UnsupportedOperationException("Fish don't make sounds");
    }

    @Override
    public void swim() {
        System.out.println("Fish is swimming");
    }

    @Override
    public void fly() {
        // Not applicable for a fish
        throw new UnsupportedOperationException("Fish can't fly");
    }
}

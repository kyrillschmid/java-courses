package solid_04_isp;

public class Dog implements Animal {

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void swim() {
        System.out.println("Dog is swimming");
    }

    @Override
    public void fly() {
        // Not applicable for a dog
        throw new UnsupportedOperationException("Dogs can't fly");
    }
}

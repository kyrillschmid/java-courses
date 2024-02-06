package solid_04_isp;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		List<Animal> animals = Arrays.asList(new Dog(), new Bird(), new Fish());
		for (Animal animal : animals){
		    animal.makeSound();
		}
	}

}

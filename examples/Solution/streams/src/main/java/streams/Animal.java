package streams;


import java.util.Arrays;
import java.util.List;

public class Animal {
	
	 private String name;
	 private String species;
	 private boolean vegetarian;
	 private double weight;


	public enum Gender {
     MALE, FEMALE
	}
 
	static List<Animal> animals = Arrays.asList(
		    new Animal("Alex", "Lion", false, 200.0),
		    new Animal("Gloria", "Hippo", true, 1600.0),
		    new Animal("Melman", "Giraffe", true, 1100.0),
		    new Animal("Marty", "Zebra", true, 300.0),
		    new Animal("Skipper", "Penguin", false, 5.0),
		    new Animal("Private", "Penguin", false, 4.0),
		    new Animal("Kowalski", "Penguin", false, 6.0),
		    new Animal("Rico", "Penguin", false, 7.0),
		    new Animal("Maurice", "Lemur", true, 3.0),
		    new Animal("Julien", "Lemur", true, 4.5)
		);




	public Animal(String name, String species, boolean vegetarian, double weight) {
        this.name = name;
        this.species = species;
        this.vegetarian = vegetarian;
        this.weight = weight;
    }

	 public String getName() {
	     return name;
	 }
	
	 public void setName(String name) {
	     this.name = name;
	 }

 public double getWeight() {
     return weight;
 }

 public void setWeight(double weight) {
     this.weight = weight;
 }

 public String getSpecies() {
     return species;
 }

 public void setSpecies(String species) {
     this.species = species;
 }
 
 public boolean getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(Boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", species=" + species + ", vegetarian=" + vegetarian + ", weight=" + weight + "]";
	}
}


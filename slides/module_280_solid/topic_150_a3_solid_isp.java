// j2 from 'macros.j2' import header
// {{ header("Interface-Segregation-Principle", "Interface-Segregation-Principle") }}

// %% [markdown] lang="de" tags=["slide"]
//
// ## SOLID: Interface-Segregation-Principle
//
// - Kein Client einer Klasse C sollte von Methoden abhängen, die er nicht
//   benutzt.
// - Wenn das nicht der Fall ist
//   - Unterteile die Schnittstelle von C in mehrere unabhängige Schnittstellen.
//   - Ersetze C in jedem Client durch die vom Client tatsächlich verwendeten
//     Schnittstellen.

// %% [markdown] lang="en" tags=["slide"]
//
// ## SOLID: Interface Segregation Principle
//
// - No client of a class C should depend on methods it doesn’t use
// - If that is not the case
//   - Divide the interface of C into multiple independent interfaces
//   - Replace C in each client with the interfaces actually used by the client

// %% tags=["keep", "slide"]
public interface Animal {
    void makeSound();
    void swim();
    void fly();
}

// %% tags=["keep", "subslide"]
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

// %% tags=["keep", "subslide"]
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

// %% tags=["keep", "subslide"]
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

// %% tags=["keep"]
List<Animal> animals = Arrays.asList(new Dog(), new Bird(), new Fish());

// %%
for (Animal animal : animals) {
            animal.makeSound();
        }

// %% tags=["subslide"]
public interface SoundMaker {
    void makeSound();
}

public interface Swimmer {
    void swim();
}

public interface Flyer {
    void fly();
}

// %% tags=["subslide"]
public class Dog implements SoundMaker, Swimmer {

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    @Override
    public void swim() {
        System.out.println("Dog is swimming");
    }
}

// %%
public class Fish implements Swimmer {

    @Override
    public void swim() {
        System.out.println("Fish is swimming");
    }
}

// %%
public class Bird implements SoundMaker, Flyer {

    @Override
    public void makeSound() {
        System.out.println("Chirp!");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}

// %% [markdown] lang="de"
// 
// Mini-Workshop 1: Interface Segregation Principle
// ===============================================
// - Erstelle ein Interface `Vehicle` mit den Methoden `drive`, `fly` und `swim`
// - Erstelle eine Klasse `Car` die das Interface `Vehicle` implementiert
// - Erstelle eine Klasse `Boat` die das Interface `Vehicle` implementiert
// - Erstelle eine Klasse `Helicopter` die das Interface `Vehicle` implementiert
// - Erstelle eine Klasse `Amphibian` die das Interface `Vehicle` implementiert
// - Refaktoriere das Interface `Vehicle` so, dass es dem Interface Segregation


// %% [markdown] lang="en"
//
// Mini-Workshop 1: Interface Segregation Principle
// ===============================================
// - Create an interface `Vehicle` with methods `drive`, `fly` and `swim`
// - Create a class `Car` that implements the interface `Vehicle`
// - Create a class `Boat` that implements the interface `Vehicle`
// - Create a class `Helicopter` that implements the interface `Vehicle`
// - Create a class `Amphibian` that implements the interface `Vehicle`
// - Refactor the interface `Vehicle` to follow the Interface Segregation


// %%
public interface Vehicle {
    void drive();
    void fly();
    void swim();
}

// %%
public class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Car is driving");
    }

    @Override
    public void fly() {
        // Not applicable for a car
        throw new UnsupportedOperationException("Cars can't fly");
    }

    @Override
    public void swim() {
        // Not applicable for a car
        throw new UnsupportedOperationException("Cars can't swim");
    }
}

// %%
public class Boat implements Vehicle {

    @Override
    public void drive() {
        // Not applicable for a boat
        throw new UnsupportedOperationException("Boats can't drive");
    }

    @Override
    public void fly() {
        // Not applicable for a boat
        throw new UnsupportedOperationException("Boats can't fly");
    }

    @Override
    public void swim() {
        System.out.println("Boat is swimming");
    }
}

// %% 
public class Helicopter implements Vehicle {

    @Override
    public void drive() {
        // Not applicable for a helicopter
        throw new UnsupportedOperationException("Helicopters can't drive");
    }

    @Override
    public void fly() {
        System.out.println("Helicopter is flying");
    }

    @Override
    public void swim() {
        // Not applicable for a helicopter
        throw new UnsupportedOperationException("Helicopters can't swim");
    }
}

// %% 
public class Amphibian implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Amphibian is driving");
    }

    @Override
    public void fly() {
        System.out.println("Amphibian is flying");
    }

    @Override
    public void swim() {
        System.out.println("Amphibian is swimming");
    }
}

// %% 
public interface Driveable {
    void drive();
}

// %% 
public interface Flyable {
    void fly();
}

// %%
public interface Swimmable {
    void swim();
}
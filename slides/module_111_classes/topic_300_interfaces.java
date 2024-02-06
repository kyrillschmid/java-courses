// j2 from 'macros.j2' import header
// {{ header("Interfaces", "Interfaces") }}

// %% [markdown] lang="de" tags=["slide"]
//
// ## Motivation
//
// - Vererbung in Java ist auf eine Vererbungsrelation beschraenkt.
// - Keine Mehrfachvererbung
// - Schnittstellen (Interfaces) ermöglichen es Spezifikationen und Implementierung zu trennen
//      - Interfaces: kümmert sich um das was (nicht um das wie)

// %% [markdown] lang="en" tags=["slide"]
//
// ## Motivation
//
// - Inheritance in Java is limited (no multiple inheritance).
// - Interface allow to separate specification and implementation
//      - Interfaces: specify what (not how)

// %% tags=["keep", "slide"]
public interface MathOperation {
    int calculate(int a, int b);
}

// %%
class Addition implements MathOperation {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

// %% tags=["keep", "slide"]
class Subtration implements MathOperation {
    @Override 
    public int calculate(int a, int b){
        return a - b;
    }
}

// %% tags=["keep"]
class Multiplication implements MathOperation {
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}

// %% [markdown] lang="de" tags=["subslide"]
// ## Dynamisches Binden
// - Durch dynamisches Binden kann können wir den Obertyp verwenden
// - Zur Laufzeit wird die richtige Methode ausgewaehlt

// %% [markdown] lang="en" tags=["subslide"]
// ## Dynamic binding
// - Dynamic binding allows us to use the underlying type
// - At runtime the correct method is selected

// %%
MathOperation operation = new Addition();

// %%
operation.calculate(1, 2);

// %%
MathOperation operation2 = new Subtraction();

// %%
operation2.calculate(1, 2);

// %% [markdown] lang="de" tags=["subslide"]
// ## Tagging Interfaces
// - Markierungsschnittstellen (Tagging Interfaces) sind häufig leere Interfaces, die durch andere Interfaces erweitert werden
// - Markieren Zusammenhänge zwischen Klassen

// %% [markdown] lang="en" tags=["subslide"]
// ## Tagging Interfaces
// - Tagging interfaces are often empty interfaces that are extended by other interfaces
// - Tag relationships between classes

// %% [markdown] lang="de" tags=["subslide"]
// Beispiel:
// EventListener wird von vielen anderen Interfaces erweitert (MouseListener, KeyListener, etc.)
// ```java
// EventListener listener = new MouseListener() {
//     ...
// };
// ```

// %% [markdown] lang="en" tags=["subslide"]
// Example:
// EventListener is extended by many other interfaces (MouseListener, KeyListener, etc.)
// ```java
// EventListener listener = new MouseListener() {
//     ...
// };
// ```

// %% [markdown] lang="de" tags=["subslide"]
// ## Mini-Workshop: Zoo
// - Erstellen Sie ein Interface `Animal` mit folgenden Methoden:
//   - `eat()`
//   - `getName()`
//   - `makeNoise()`
// - Einer Klasse `Lion`, die `Animal` implementiert
// - Einer Klasse `Zebra`, die `Animal` implementiert
// - Einer Klasse `Fish`, die `Animal` implementiert
// - Erstellen Sie eine Klasse `Zoo` mit folgenden Eigenschaften:
//   - Ein Array von Animal-Objekten
//   - Eine Methode `sayHello()`, die das `makeNoise` für alle Animal-Objekte aufruft

// %% [markdown] lang="en" tags=["subslide"]
// ## Mini-Workshop: Zoo
// - Create an interface `Animal` with the following methods:
//   - `eat()`
//   - `getName()`
//   - `makeNoise()`
// - Create a class `Lion` that implements `Animal`
// - Create a class `Zebra` that implements `Animal`
// - Create a class `Fish` that implements `Animal`
// - Create a class `Zoo` with the following properties:
//   - An array of Animal objects
//   - A method `sayHello()` that uses the `makeNoise` for all animals

// %% 
interface Animal {
    void eat();
    void sleep();
    void makeNoise();
}

class Lion implements Animal {
    @Override
    public void eat() {
        System.out.println("Lion is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Lion is sleeping");
    }

    @Override
    public void makeNoise() {
        System.out.println("Roar");
    }

}

class Zebra implements Animal {
    @Override
    public void eat() {
        System.out.println("Zebra is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Zebra is sleeping");
    }

    @Override
    public void makeNoise() {
        System.out.println("Bark");
    }
}

class Fish implements Animal {
    @Override
    public void eat() {
        System.out.println("Fish is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Fish is sleeping");
    }

    @Override
    public void makeNoise() {
        System.out.println("Blub");
    }
}

// %%
class Zoo {
    Animal[] animals = new Animal[10];
    int animalCount = 0;
    void sayHello() {
        for (Animal animal : animals) {
            if (animal != null) {
                animal.makeNoise();
                }
            }            
        }

    void addAnimal(Animal animal) {
        animals[animalCount++] = animal;
    }
}

// %% [markdown] lang="de" tags=["subslide"]
// - Erstelle einen Zoo mit ein paar Animal-Objekten

// %% [markdown] lang="en" tags=["subslide"]
// - Create a Zoo with some Animal objects

// %%
Zoo zoo = new Zoo();

// %%
zoo.addAnimal(new Lion());
zoo.addAnimal(new Zebra());
zoo.addAnimal(new Fish());

// %%
zoo.sayHello();

// %% [markdown] lang="de" tags=["subslide"]
// - Welche Probleme kannst du bei diesem Beispiel erkennen?

// %% [markdown] lang="en" tags=["subslide"]
// - What problems can you identify with this example?

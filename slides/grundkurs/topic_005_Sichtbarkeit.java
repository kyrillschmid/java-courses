// j2 from 'macros.j2' import header
// {{ header("Kapselung", "Encapsulation") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Sichtbarkeit von Instanzvariablen
//
// - Idee Klasse: fasse Daten und Methoden zusammen, die zusammengehören (Kapselung)
// - Daten werden in Instanzvariablen gespeichert, Methoden greifen auf diese Variablen zu
// - Es ist daher wichtig, dass die Variablen (nur) von den Methoden der Klasse gelesen und geschrieben werden können
// - In Java gibt es dafür vier Sichtbarkeitsstufen: `public`, `protected`, `package-private` (kein Schlüsselwort erforderlich) und `private`

// %% [markdown] lang="en" tags=["slide"]
// ## Visibility of Instance Variables
//
// - Idea class: combine data and methods that belong together (encapsulation)
// - Data is stored in instance variables, methods access these variables
// - It is therefore important that the variables can be read and written (only) by the methods of the class
// - In Java there are four levels of visibility: `public`, `protected`, `package-private` (no keyword required) and `private`

// %% [markdown] lang="de"
//
// In Java gibt es vier Sichtbarkeitsstufen: `public`, `protected`, `package-private` (kein Schlüsselwort erforderlich) und `private`.

// %% [markdown] lang="en"
//
// In Java, there are four levels of visibility: `public`, `protected`, `package-private` (no keyword needed), and `private`.

// %% [markdown] lang="de" tags=["subslide"]
//
// ### `public` Sichtbarkeit
// `public` Variablen sind von überall im Programm zugänglich (andere Klassen, andere Pakete).

// %% [markdown] lang="en" tags=["subslide"]
//
// ### `public` Visibility
// `public` variables are accessible from anywhere in the program (other classes, other packages).

// %% 
public class PublicExample {
    public int publicVar;
}

// %%
PublicExample p = new PublicExample();
p.publicVar;

// %% [markdown] lang="de" tags=["subslide"]
//
// ### `private` Sichtbarkeit
// `private` Variablen sind nur innerhalb der Klasse zugänglich, in der sie deklariert sind.

// %% [markdown] lang="en" tags=["subslide"]
//
// ### `private` Visibility
// `private` variables are accessible only within the class in which they are declared.

// %% 
public class PrivateExample {
    private int privateVar;
}

// %%
PrivateExample p = new PrivateExample();
p.privateVar;

// %% [markdown] lang="de" tags=["subslide"]
//
// ### `protected` Sichtbarkeit
// `protected` Variablen sind innerhalb der eigenen Klasse, in allen Klassen des gleichen Pakets und in allen Unterklassen zugänglich.

// %% [markdown] lang="en" tags=["subslide"]
//
// ### `protected` Visibility
// `protected` variables are accessible within their own class, in all classes in the same package, and in all subclasses.

// %% 
public class ProtectedExample {
    protected int protectedVar;
}

// %%
ProtectedExample p = new ProtectedExample();
p.protectedVar;

// %% [markdown] lang="de" tags=["subslide"]
//
// ### Paket-private Sichtbarkeit
// Variablen ohne Sichtbarkeitsmodifikator sind nur innerhalb ihres eigenen Pakets zugänglich.

// %% [markdown] lang="en" tags=["subslide"]
//
// ### Package-Private Visibility
// Variables without a visibility modifier are accessible only within their own package.

// %% 
public class PackagePrivateExample {
    int packagePrivateVar;
}

// %%
PackagePrivateExample p = new PackagePrivateExample();
p.packagePrivateVar;

// %% [markdown] lang="de" tags=["subslide"]
//
// ## `Getter` und `Setter` Methoden
// - Instanzvariablen sollten `private` sein, um die Kapselung zu gewährleisten
// - Zugriff auf die Variablen über `public` Methoden
// - `Getter` Methoden geben den Wert einer Variablen zurück
// - `Setter` Methoden setzen den Wert einer Variablen

// %% [markdown] lang="en" tags=["subslide"]
//
// ## `Getter` and `Setter` Methods
// - Instance variables should be `private` to ensure encapsulation
// - Access to the variables via `public` methods
// - `Getter` methods return the value of a variable

// %% 
public class PrivateExample {
    private int privateVar;

    public int getPrivateVar() {
        return privateVar;
    }

    public void setPrivateVar(int privateVar) {
        this.privateVar = privateVar;
    }
}

// %%
PrivateExample p = new PrivateExample();
p.setPrivateVar(42);
p.getPrivateVar();

// %% [markdown] lang="de" tags=["subslide"]
// ## Mini-Workshop: Zugriffsebenen (Teil 1)
//
// In diesem Workshop werden wir die verschiedenen Zugriffsebenen (`public`, `private`, `protected`, `package-private`) anhand eines praktischen Beispiels untersuchen.

// %% [markdown] lang="en" tags=["subslide"]
// ## Workshop: Access Levels (Part 1)
//
// In this workshop, we will explore the different access levels (`public`, `private`, `protected`, `package-private`) using a practical example.

// %% [markdown] lang="de"
// Definieren Sie eine Klasse `Car` mit verschiedenen Zugriffsebenen für die Instanzvariablen:
// - `public String brand` (Marke)
// - `protected int year` (Baujahr)
// - `private String licensePlate` (Kennzeichen)
// - Ohne Zugriffsmodifikator: `int mileage` (Kilometerstand)

// %% [markdown] lang="en"
// Define a class `Car` with different access levels for its instance variables:
// - `public String brand` (Brand)
// - `protected int year` (Year)
// - `private String licensePlate` (License Plate)
// - Without access modifier: `int mileage` (Mileage)

// %%
public class Car {
    public String brand;
    protected int year;
    private String licensePlate;
    int mileage;

    // Constructor
    public Car(String brand, int year, String licensePlate, int mileage) {
        this.brand = brand;
        this.year = year;
        this.licensePlate = licensePlate;
        this.mileage = mileage;
    }

    // Getter
    public String getLicensePlate() {
        return licensePlate;
    }
}

// %% [markdown] lang="de"
// Erstellen Sie eine Instanz von `Car` und experimentieren Sie mit dem Zugriff auf die verschiedenen Variablen.

// %% [markdown] lang="en"
// Create an instance of `Car` and experiment with accessing the different variables.

// %% 
Car myCar = new Car("Volkswagen", 2020, "XYZ-1234", 5000);

// %% 
System.out.println("Brand: " + myCar.brand);

// %% 
System.out.println("Year: " + myCar.year);

// %% 
System.out.println("License Plate: " + myCar.getLicensePlate());

// %% 
System.out.println("Mileage: " + myCar.mileage);

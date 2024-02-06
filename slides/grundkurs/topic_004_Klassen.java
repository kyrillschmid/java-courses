// j2 from 'macros.j2' import header
// {{ header("Klassen ", "Classes") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Benutzerdefinierte Datentypen
//
// Wir wollen uns jetzt der Definition von benutzerdefinierten Datentypen (Klassen)
// zuwenden:


// %% [markdown] lang="en" tags=["slide"]
// ## Custom data types
//
// Let us now turn to the definition of user-defined data types (classes):

// %%
public class PointV0 {

}

// %% [markdown] lang="de"
//
// Klassennamen werden in Pascal-Case (d.h. groß und mit Großbuchstaben zur
// Trennung von Namensbestandteilen) geschrieben, z.B. `MyVerySpecialClass`.

// %% [markdown] lang="en"
//
// Class names are in pascal case (i.e. capital letters separate components of
// names), e.g. `MyVerySpecialClass`.

// %% [markdown] lang="de"
//
// Wir verwenden im Folgenden [Python Tutor](https://pythontutor.com/render.html#code=public%20class%20MyPoint%20%7B%0A%20%20%0A%20%20public%20static%20void%20main%28String%5B%5D%20args%29%7B%0A%20%20%7D%0A%7D&cumulative=false&curInstr=1&heapPrimitives=nevernest&mode=display&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false)
// um die Klasse `Point` zu implementieren.

// %% [markdown] lang="en"
//
// In the following we will use
// [Python Tutor](https://pythontutor.com/render.html#code=public%20class%20MyPoint%20%7B%0A%20%20%0A%20%20public%20static%20void%20main%28String%5B%5D%20args%29%7B%0A%20%20%7D%0A%7D&cumulative=false&curInstr=1&heapPrimitives=nevernest&mode=display&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false) to implement
// the `Point` class.

// %% [markdown] lang="de" tags=["subslide"]
//
// Instanzen von benutzerdefinierten Klassen werden erzeugt, indem man den
// Konstruktor der Klasse aufruft. Manche Funktionen können auch ohne
// weitere Implementierung verwendet werden, z.B. `equals()`:

// %% [markdown] lang="en" tags=["subslide"]
//
// Instances of user-defined classes are created by calling the class's
// constructor. Some functions can also be used without further implementation,
// e.g. `equals()`:

// %% tags=["subslide"]
PointV0 p1 = new PointV0();
p1

// %%
PointV0 p2 = new PointV0();
p1.equals(p2)

// %% [markdown] lang="de" tags=["subslide"]
// Bisher hat unsere Klasse keine Attribute und keine Methoden

// %% [markdown] lang="en" tags=["subslide"]
// So far our class has no attributes and no methods

// %% [markdown] lang="de" tags=["subslide"]
// Wollen wir die Klasse `Point` um Attribute erweitern, so können wir
// diese einfach in der Klassendefinition angeben:

// %% [markdown] lang="en" tags=["subslide"]
// If we want to extend the `Point` class with attributes, we can simply
// specify them in the class definition:

// %% tags=["subslide"]
public class MyPoint {
    double x;
    double y;
}

// %%
MyPoint p1 = new MyPoint();
MyPoint p2 = new MyPoint();

// %% tags=["keep"]
void printPoint(MyPoint p) {
    System.out.println("(" + p.x + ", " + p.y + ")");
}

// %%
printPoint(p1);
printPoint(p2);

// %%
p1.equals(p2);

// %% [markdown] lang="de" tags=["subslide"]
//
// Die Werte von Attributen können verändert werden:

// %% [markdown] lang="en" tags=["subslide"]
//
// The values of attributes can be changed:

// %%
p1.x = 1.0;
p1.y = 2.0;
printPoint(p1);
printPoint(p2);


// %% [markdown] lang="de" tags=["subslide"]
// ## Konstruktor
//
// In vielen Fällen wäre es besser, bei der Konstruktion eines Objekts Werte für
// die Attribute anzugeben. Das ist möglich, indem man einen Konstruktor
// definiert, der zusätzliche Argumente entgegennimmt.

// %% [markdown] lang="en" tags=["subslide"]
// ## Constructor
//
// In many cases, when constructing an object, we would like to specify the attributes
// of the instance. This is possible by defining a constructor that takes additional
// arguments.

// %% tags=["start"]
public class MyPoint {
    double x;
    double y;
}

// %% tags=["alt"]
public class MyPoint {
    double x;
    double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

// %%
MyPoint p1 = new MyPoint(1.0, 2.0);
MyPoint p2 = new MyPoint(3.0, 4.0);
printPoint(p1);
printPoint(p2);

// %% [markdown] lang="de" tags=["subslide"]
// Eine Klasse kann mehrere Konstruktoren haben, die sich in der Anzahl und Art
// der Argumente unterscheiden. Java wählt den passenden Konstruktor anhand der
// Argumente aus.

// %% [markdown] lang="en" tags=["subslide"]
// A class can have multiple constructors that differ in the number and type of
// arguments. Java chooses the appropriate constructor based on the arguments.

// %% tags=["start"]
public class MyPoint {
    double x;
    double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

// %% tags=["alt"]
public class MyPoint {
    double x;
    double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint(double x) {
        this.x = x;
        this.y = 0.0;
    }
}

// %%
MyPoint p1 = new MyPoint(1.0, 2.0);
MyPoint p2 = new MyPoint(3.0);
printPoint(p1);
printPoint(p2);

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Mini-Workshop: Kraftfahrzeuge (Teil 1)
//
// Definieren Sie eine Klasse `Kfz`, deren Instanzen Kraftfahrzeuge beschreiben.
// Jedes KFZ soll Attribute `hersteller` und `kennzeichen` haben.


// %% lang="de"
public class Kfz {
    String hersteller;
    String kennzeichen;

    public Kfz(String hersteller, String kennzeichen) {
        this.hersteller = hersteller;
        this.kennzeichen = kennzeichen;
    }
}

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Mini Workshop: Motor Vehicles (Part 1)
//
// Define a class `MotorVehicle` whose instances describe motor vehicles.
// Every car should have attributes `manufacturer` and `license_plate`.


// %% lang="en"
public class MotorVehicle {
    String manufacturer;
    String license_plate;

    public MotorVehicle(String manufacturer, String license_plate) {
        this.manufacturer = manufacturer;
        this.license_plate = license_plate;
    }
}

// %% [markdown] lang="de"
//
// Erzeugen Sie zwei Kraftfahrzeuge:
// - einen BMW mit Kennzeichen "M-BW 123"
// - einen VW mit Kennzeichen "WOB-VW 246"
// und speichern Sie sie in Variablen `bmw` und `vw`

// %% [markdown] lang="en"
// Create two motor vehicles:
// - a BMW with license plate "M-BW 123"
// - a VW with license plate "WOB-VW 246"
// and store them in variables `bmw` and `vw`

// %% lang="de"
Kfz bmw = new Kfz("BMW", "M-BW 123");
Kfz vw = new Kfz("VW", "WOB-VW 246");

// %% lang="en"
MotorVehicle bmw_en = new MotorVehicle("BMW", "M-BW 123");
MotorVehicle vw_en = new MotorVehicle("VW", "WOB-VW 246");

// %% [markdown] lang="de"
//
// Erzeugen Sie eine neue Instanz von `Kfz` mit Hersteller BMW und Kennzeichen
// "M-BW 123" und speichern Sie sie in einer Variablen `bmw2`.

// %% [markdown] lang="en"
// Create a new instance of `MotorVehicle` with manufacturer BMW and registration number
// "M-BW 123" and store it in a variable `bmw2`.

// %% lang="de"
Kfz bmw2 = new Kfz("BMW", "M-BW 123")

// %% lang="en"
MotorVehicle bmw2_en = new MotorVehicle("BMW", "M-BW 123")

// %% [markdown] lang="de"
//
// Wie können Sie feststellen, ob `bmw` und `bmw2` (bzw. `bmw` und `vw`) das
// gleiche Fahrzeug beschreiben?

// %% [markdown] lang="en"
//
// How can you determine whether `bmw` and `bmw2` (or `bmw` and `vw`) describe
// the same vehicle?

// %% lang="de"
bmw.hersteller.equals(bmw2.hersteller) && bmw.kennzeichen.equals(bmw2.kennzeichen)

// %% lang="de"
bmw.hersteller.equals(vw.hersteller) && bmw.kennzeichen.equals(vw.kennzeichen)

// %% lang="en"
bmw_en.manufacturer.equals(bmw2_en.manufacturer) && bmw_en.license_plate.equals(bmw2_en.license_plate)
// j2 from 'macros.j2' import header
// {{ header("Methoden", "Methods") }}

// %% [markdown] lang="de" tags=["notes"]
//
// - Herzlich Willkommen!
// - Wir haben bisher schon gesehen, wie wir eigene Datentypen definieren können
//   und wie wir Attributen hinzufügen um ihnen einen gewünschten Zustand zu geben.
// - Das ist schon sehr hilfreich, aber nur die halbe Miete.
// - In diesem Video wollen wir uns ansehen, wie wir unsere Objekte mit neuer
//   Funktionalität ausstatten können.
// - Das geschieht über sogenannte Methoden.

// %% [markdown] lang="en" tags=["notes"]
//
// - Warm welcome!
// - So far we have seen how we can define our own data types and how we can add
//   attributes to give them a desired state.
// - That's very helpful, but only half the battle.
// - In this video we want to see how we can add new functionality to our objects.
// - This is done using so-called methods.

// %% [markdown] lang="de" tags=["subslide"]
// ## Methoden
//
// - Klassen können Methoden enthalten.
// - Methoden sind Funktionen, die "zu einem Objekt gehören".
// - Methoden werden mit der "Dot-Notation" aufgerufen: `myoObject.method()`.

// %% [markdown] lang="en" tags=["subslide"]
// ## Methods
//
// - Classes can contain methods.
// - Methods are functions that "belong to an object".
// - Methods are called using "dot-notation": `myObject.method()`.

// %% tags=["keep"]
public class MyClass {
    public void method() {
        System.out.println("Called method on " + this);
    }
}


// %% tags=["keep"]
MyClass myObject = new MyClass();
myObject.method();
System.out.println(myObject);

// %% [markdown] lang="de" tags=["notes"]
//
// **Methoden**
//
// - Klassen können Methoden enthalten.
// - Methoden sind Funktionen, die "zu einem Objekt gehören" oder "auf einem bestimmten
//   Objekt aufgerufen werden".
// - Im Abschnitt zu Vererbung werden wir sehen, dass sich dadurch interessante
//   Möglichkeiten eröffnen.
// - Aber wir können Methoden im Moment einfach als Funktionen betrachten, die, wie
//   wir gleich sehen werden, auf eine etwas seltsame Art aufgerufen werden.
// - Eine Methodendefinition sieht syntaktisch wie eine Funktionsdefinition aus,
//   steht aber im Rumpf einer Klassendefinition.
// - Wir sehen hier ein Beispiel in der Definition der Klasse `MyClass`.
// - Mit `this` referenzieren wir das Objekt, auf dem die Methode aufgerufen wird.
// - Der Aufruf passiert mit der "Dot-Notation":
//   `myObject.method()`.
// - Das Objekt vor dem Punkt wird implizit an `this`

// %% [markdown] lang="en" tags=["notes"]
//
// **Methods**
//
// - Classes can contain methods.
// - Methods are functions that "belong to an object" or "are called on a specific
//   object".
// - In the section on inheritance we will see that this opens up interesting
//   possibilities.
// - But for the moment we can simply consider methods as functions that, as we
//   will see in a moment, are called in a somewhat strange way.
// - A method definition looks syntactically like a function definition, but is
//   in the body of a class definition.
// - We see an example here in the definition of the class `MyClass`.
// - With `this` we reference the object on which the method is called.
// - The call is done with the "dot-notation":
//   `myObject.method()`.
// - The object before the dot is implicitly passed to `this`.

// %% [markdown] lang="de" tags=["subslide"]
//
// Wir können eine Methode zum Verschieben eines Punktes zu unserer `Point`
// Klasse hinzufügen:

// %% [markdown] lang="en" tags=["subslide"]
//
// We can add a method to move a point to our `Point` class:

// %% tags=["start"]
public class Point {
    public double x;
    public double y;
}
    
// %% tags=["alt"]
class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
}

// %% tags=["keep"]
void printPoint(Point p) {
    System.out.println("Point: x = " + p.x + ", y = " + p.y);
}

// %% tags=["subslide"]
Point p = new Point(2, 3);
printPoint(p)

// %%
p.move(3, 5);
printPoint(p)

// %% [markdown] lang="de" tags=["subslide"]
// ## Das Schlüsselwort `this`
//
// - Das Schlüsselwort `this` bezieht sich auf das aktuelle Objekt auf dem die Methode aufgerufen wird
// - Es kann verwendet werden, um Attribute und Methoden des aktuellen Objekts zu referenzieren

// %% [markdown] lang="en" tags=["subslide"]
// ## The keyword `this`
//
// - The keyword `this` refers to the current object on which the method is called
// - It can be used to reference attributes and methods of the current object

// %% [markdown] lang="de" tags=["subslide"]
// Für den Moment: Die Verwendung von this:
// - `this`: bezieht sich auf das aktuelle Objekt
// - `this.variable`: greift auf Instanzvariable des eigenen Objekts zurück
// - `this.variable = variable` : setzt den Wert der Instanzvariable auf den Wert der lokalen Variable bzw. des Parameters

// %% [markdown] lang="en" tags=["subslide"]
// For the moment: The use of this:
// - `this`: refers to the current object
// - `this.variable`: accesses instance variable of the current object
// - `this.variable = variable` : sets the value of the instance variable to the value of the local variable or parameter

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Mini-Workshop: Kraftfahrzeuge (Teil 2)
//
// In Teil 1 haben wir die folgende Klasse `Kfz` definiert:
//
// ```java
// public class Kfz{
//
//     public String hersteller;
//     public String kennzeichen;
//
//     public Kfz(String hersteller, String kennzeichen){
//         this.hersteller = hersteller
//         this.kennzeichen = kennzeichen
//         }
// }
// ```

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Mini-Workshop: Motor Vehicles (Part 2)
//
// In Part 1 we defined the following class `MotorVehicle`:
//
// ```java
// public class MotiveVehicle{
//
//     public String manufacturer;
//     public String licensePlate;
//
//     public MotiveVehicle(String hersteller, String kennzeichen){
//         this.manufacturer = manufacturer
//         this.licensePlate = licensePlate
//         }
// }
// ```


// %% [markdown] lang="de" tags=["subslide"]
//
// Erweitern Sie diese Klasse um eine Methode
//
// `meldeUm(String neuesKennzeichen)`,
//
// die das Kennzeichen des Fahrzeugs ändert.


// %% lang="de" tags=["start"]
public class Kfz {

    public String hersteller;
    public String kennzeichen;

    public Kfz(String hersteller, String kennzeichen){
        this.hersteller = hersteller;
        this.kennzeichen = kennzeichen;
        }
}

// %% lang="de" tags=["alt"]
public class Kfz {
    
    public String hersteller;
    public String kennzeichen;
    
    public Kfz(String hersteller, String kennzeichen){
        this.hersteller = hersteller;
        this.kennzeichen = kennzeichen;
        }

    public void meldeUm(String neues_kennzeichen) {
        this.kennzeichen = neues_kennzeichen;
    }
}

// %% [markdown] lang="en" tags=["subslide"]
//
// Extend the `MotorVehicle` class with a method
// `changeRegistration(String newLicensePlate)`,
// which changes the vehicle's license plate.


// %% lang="en" tags=["start"]
public class MotorVehicle {

    public String manufacturer;
    public String licensePlate;

    public MotorVehicle(String manufacturer, String licensePlate){
        this.manufacturer = manufacturer
        this.licensePlate = licensePlate
        }
}

// %% lang="en" tags=["alt"]
public class MotorVehicle {

    public String manufacturer;
    public String licensePlate;

    public MotorVehicle(String manufacturer, String licensePlate){
        this.manufacturer = manufacturer
        this.licensePlate = licensePlate
        }

    public void changeRegistration(String newLicensePlate) {
        this.licensePlate = newLicensePlate;
    }
}

// %% [markdown] lang="de" tags=["subslide"]
//
// Mit der folgenden Funktion können wir Fahrzeuge ausdrucken:

// %% lang="de" tags=["keep"]
void druckeKfz(Kfz kfz) {
    System.out.println("Kfz: " + kfz.hersteller + " mit Kennzeichen " + kfz.kennzeichen);
}

// %% [markdown] lang="en" tags=["subslide"]
//
// We can use the following function to print vehicles:


// %% lang="en" tags=["keep"]
void printMotorVehicle(MotorVehicle vehicle) {
    System.out.println(
        "Motor vehicle: " + vehicle.manufacturer + " "
        "with license plate " + vehicle.licensePlate
    );
}

// %% [markdown] lang="de" tags=["subslide"]
//
// Wir können dann wieder folgende Instanzen erzeugen:

// %% [markdown] lang="en" tags=["subslide"]
//
// We can then again create the following instances:

// %% lang="de" tags=["keep"]
Kfz bmw = new Kfz("BMW", "M-BW 123");
Kfz bmw2 = new Kfz("BMW", "M-BW 123");
Kfz vw = new Kfz("VW", "WOB-VW 246");

// %% lang="en" tags=["keep"]
MotiveVehicle bmw_en = new MotiveVehicle("BMW", "M-BW 123");
MotiveVehicle bmw2_en = new MotiveVehicle("BMW", "M-BW 123");
MotiveVehicle vw_en = new MotiveVehicle("VW", "WOB-VW 246");

// %% [markdown] lang="de" tags=["subslide"]
//
// Melden Sie den oben erzeugten VW um, so dass er das neue Kennzeichen "BGL-A
// 9" hat. Wie können Sie feststellen ob das Ummelden die gewünschte Änderung
// hatte?

// %% [markdown] lang="en" tags=["subslide"]
//
// Change the registration of the VW generated above so that it has the new
// license plate  "BGL-A 9". How can you tell if changing the registration
// resulted in the change you wanted?

// %% lang="de"
vw.meldeUm("BGL-A 9")

// %% lang="en"
vw_en.changeRegistration("BGL-A 9")

// %% lang="de"
druckeKfz(vw)

// %% lang="en"
printMotorVehicle(vw_en)

// %% [markdown] lang="de" tags=["subslide"]
//
// Melden Sie den in `bmw` gespeicherten BMW um (mit Kennzeichen "F-B 21"). Wirkt
// sich die Änderung auf das in `bmw2` gespeicherte KFZ aus?

// %% [markdown] lang="en" tags=["subslide"]
//
// Change the registration of the BMW saved in `bmw` (to the new registration
// number "F-B 21"). Does the change affect the car saved in `bmw2`?

// %% lang="de"
bmw.meldeUm("F-B 21")

// %% lang="de"
druckeKfz(bmw);
druckeKfz(bmw2)

// %% lang="en"
bmw_en.changeRegistration("F-B 21")

// %% lang="en"
printMotorVehicle(bmw_en);
printMotorVehicle(bmw2_en)
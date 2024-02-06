// j2 from 'macros.j2' import header
// {{ header("Abstrakte Klassen", "Abstract classes") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
//
// - Wir hatten bei einer Aufgabe zur Vererbung die folgende Klassenhierarchie:

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Motivation
//
// - We had the following class hierarchy in an exercise on inheritance:

// %% tags=["keep"]
class Employee {
 
}

// %% tags=["keep"]
class Manager extends Employee {
 
}

// %% tags=["keep"]
class Worker extends Employee {
 
}

// %% [markdown] lang="de" tags=["subslide"]
//
// - `Employee` dient nur dazu das gemeinsame Verhalten von `Manager` und `Worker`
//   zu definieren
// - Es sollten keine Instanzen von `Employee` erzeugt werden können
// - Im Moment ist das aber möglich

// %% [markdown] lang="en" tags=["subslide"]
//
// - `Employee` only serves to define the common behavior of `Manager` and `Worker`
// - It should be impossible to create instances of `Employee`
// - At the moment this is possible

// %% [markdown] lang="de" tags=["slide"]
//
// ## Abstrakte Klassen
//
// - Klassen, von denen keine direkte Instanz erzeugt werden kann
// - Haben `abstract` Schlüsselwort in Java
// - Erlauben die Verwendung des `abstract` Schlüsselworts vor Methoden, um abstrakte Methoden
//   zu definieren

// %% [markdown] lang="en" tags=["slide"]
// ## Abstract classes
//
// - Classes that cannot have direct instances
// - Have `abstract` keyword in Java
// - Allow use of the `abstract` keyword before methods to define abstract methods

// %% [markdown] lang="de" tags=["subslide"]
//
// ### Die abstrakte `Employee` Klasse

// %% [markdown] lang="en" tags=["subslide"]
//
// ### The abstract `Employee` class

// %%
abstract class Employee {
    abstract double salary();
}

// %%
// Employee e = new Employee();

// %% [markdown] lang="de" tags=["subslide"]
//
// ### Die `Manager` und `Worker` Klassen

// %% [markdown] lang="en" tags=["subslide"]
//
// ### The `Manager` and `Worker` classes

// %% tags=["start"]
class Manager extends Employee {
    
}

// %% tags=["alt"]
class Manager extends Employee {
    @Override
    double salary() {
        return 100_000.0;
    }
}

// %%
Manager m = new Manager();
System.out.println(m);

// %%
System.out.println(m.salary());


// %% tags=["slide","keep"]
class Worker extends Employee {
    @Override
    double salary() {
        return 50_000.0;
    }
}


// %%
Worker w = new Worker();
System.out.println(w);

// %%
System.out.println(w.salary());

// %% [markdown] lang="de" tags=["subslide"]
//
// ### Die `Company` Klasse
//
// - Wir definieren eine Klasse, die eine Liste von `Employee` Objekten verwaltet

// %% [markdown] lang="en" tags=["subslide"]
//
// ### The `Company` class
//
// - We define a class that manages a list of `Employee` objects

// %% tags=["start"]
class Company {
    private Employee[] employees;

    public Company(Employee[] employees) {
        this.employees = employees;
    }

    double monthlyExpenses() {
        //
    }
}

// %% tags=["alt"]
class Company {
    private Employee[] employees;

    public Company(Employee[] employees) {
        this.employees = employees;
    }

    double monthlyExpenses() {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.salary();
        }
        return total;
    }
}

// %%
Company c = new Company(new Employee[]{m, w});
c;

// %%
c.monthlyExpenses();

// %% [markdown] lang="de" tags=["subslide"]
// - Abstrakte Methoden können eine Implementierung haben
// - Klassen, die von einer abstrakten Klasse erben aber nicht alle abstrakten
//   Methoden überschreiben sind selber abstrakt.

// %% [markdown] lang="en" tags=["subslide"]
// - Abstract methods can provide an implementation
// - Classes that inherit from an abstract class but do not override all abstract
//   methods are themselves abstract.

// %% tags=["keep", "subslide"]
abstract class MyBase {
    void myMethod() {
        System.out.println("Hi!");
    }
}


// %%
abstract class MyClass extends MyBase {
    // Some code here
}


// %%
// MyClass mc = new MyClass();


// %% tags=["subslide"]
class YourClass extends MyBase {
    @Override
    void myMethod() {
        super.myMethod();
        System.out.println("Hello!");
    }
}


// %%
YourClass yc = new YourClass();
yc.myMethod();

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Workshop: Geometrische Formen
//
// In diesem Workshop implementieren Sie Klassen für geometrische Formen unter
// Verwendung von abstrakten Klassen.
//
// - Erstellen Sie eine Basisklasse `Shape` mit abstrakten Methoden für die
//   Berechnung von Fläche und Umfang.
// - Erstellen Sie konkrete Unterklassen für Rechtecke und Kreise, die von der
//   Klasse `Shape` erben und die abstrakten Methoden implementieren.
// - Testen Sie Ihre Implementierung mit verschiedenen Dimensionen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Workshop: Shapes
//
// In this workshop, you will implement geometric shape classes using abstract
// classes.
//
// - Create a base class called `Shape` with abstract
//   methods for calculating area and perimeter.
// - Create concrete subclasses for rectangles and circles that inherit from the
//  `Shape` class and implement the abstract methods.
// - Test your implementation with different dimensions.

// %% [markdown] lang="de" tags=["subslide"]
//
// ### Hinweise
//
// - Sie können das Modul `Math` für den Wert von π verwenden.
// - Die Fläche eines Rechtecks berechnet sich als `width * height`, der Umfang als
//   `2 * (width + height)`.
// - Die Fläche eines Kreises berechnet sich als `π * radius ^ 2`, der Umfang als
//   `2 * π * radius`.


// %% [markdown] lang="en" tags=["subslide"]
//
// ### Notes
//
// - You can use the `Math` class for the value of π.
// - The area of a rectangle is calculated as `width * height`, its perimeter is
//   `2 * (width + height)`.
// - The area of a circle is calculated as `π * radius ^ 2`, its perimeter is
//   `2 * π * radius`.

// %% tags=["subslide"]
// import java.lang.Math;

// %% tags=["alt"]
public abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

// %% tags=["alt"]
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle width=" + width + ", height=" + height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    double perimeter() {
        return 2 * (width + height);
    }
}

// %% tags=["alt"]
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle radius=" + radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// %% tags=["alt"]
Rectangle rectangle = new Rectangle(4, 5);

// %% tags=["alt"]
rectangle.area() == 20;

// %% tags=["alt"]
rectangle.perimeter() == 18;

// %% tags=["alt"]
Circle circle = new Circle(3);

// %% tags=["alt"]
circle.area();

// %% tags=["alt"]
circle.perimeter();

// %% [markdown] lang="de" tags=["subslide"]
//
// ### Bonusaufgaben:
//
// - Erweitern Sie den Workshop, indem Sie zusätzliche Klassen für geometrische
//   Formen wie `Triangle` erstellen, die von `Shape` erben und ihre jeweiligen
//   Methoden implementieren.
// - Erstellen Sie eine Klasse `Drawing`, die eine Liste von Formen speichert und
//   Methoden zur Berechnung der Gesamtfläche und des Gesamtumfangs aller Formen in
//   der Zeichnung implementiert (unter der Annahme, dass sie sich nicht
//   überschneiden).

// %% [markdown] lang="en" tags=["subslide"]
//
// ### Bonus Tasks:
//
// - Feel free to extend the workshop by creating additional shape classes like
//   `Triangle`, inheriting from `Shape` and implementing their respective
//   methods.
// - Create a class Drawing that stores a list of shapes and implements methods for
//   calculating the total area and perimeter of all shapes in the drawing (assuming
//   they don't overlap).


// %% tags=["subslide"]
public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c ) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getBase() {
        return a;
    }

    public double getHeight() {
        return 0.5 / a * Math.sqrt((a + b + c) * (a + b - c) * (a - b + c) * (-a + b + c));
    }

    public String toString() {
        return "Triangle(a=" + a + ", b=" + b + ", c=" + c + ")";
    }

    public double area() {
        return 0.5 * getBase() * getHeight();
    }

    public double perimeter() {
        return a + b + c;
    }
}

// %% tags=["alt"]
Triangle triangle = new Triangle(3, 4, 5);

// %% tags=["alt"]
triangle.area() == 6;

// %% tags=["alt"]
triangle.perimeter() == 12;


// %% tags=["alt"]
public class Drawing {
    private List<Shape> shapes;

    public Drawing(List<Shape> shapes) {
        this.shapes = new ArrayList<>(shapes);
    }

    public double getTotalArea() {
        return shapes.stream().mapToDouble(Shape::area).sum();
    }

    public double getTotalPerimeter() {
        return shapes.stream().mapToDouble(Shape::perimeter).sum();
    }
}

// %% tags=["alt"]
Drawing drawing = new Drawing(Arrays.asList(rectangle, circle, triangle));

// %% tags=["alt"]
Math.abs(drawing.getTotalArea() - rectangle.area() - circle.area() - triangle.area()) < 1e-4;;

// %% tags=["alt"]
Math.abs(drawing.getTotalPerimeter() - rectangle.perimeter() - circle.perimeter() - triangle.perimeter()) < 1e-4;
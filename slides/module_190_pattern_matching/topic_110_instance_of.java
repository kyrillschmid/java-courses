// j2 from 'macros.j2' import header
// {{ header("Pattern Matching - instanceof", "Pattern Matching - instanceof") }}

// %% [markdown] lang="de" tags=["slide"]
// Vor Java 14 musste man `instanceof` und Casts verwenden, um den Typ eines Objekts zu prüfen:

// %%
Object obj = "etwas";

// %%
if (obj instanceof String) {
    String s = (String) obj;
    System.out.printf("Arbeiten mit einem String der Länge %s.%n", s.length());
}

// %% [markdown] lang="de" tags=["slide"]
// ## Pattern Matching
//
// * Prüfe die Struktur von Daten, extrahiere Teile davon und treffe Entscheidungen basierend auf der Struktur
// * Funktionale Programmiersprachen wie Haskell und Scala haben Pattern Matching schon lange
// * Mit Java 14 wurde in `instanceof` Pattern-Matching aufgenommen:
//   * Wenn eine Test positiv ausgewertet wird.
//   * ... wird eine lokale Patternvariable belegt.


// %% [markdown] lang="de" tags=["slide"]
// ```java
// if (obj instanceof String s) {
// ```
//
// | Patternmatching-Test | Patternvariable
// | --- | --- |
// | `obj instanceof String` | `String s` |
//
// Somit lässt sich obiges Java Programm wie folgt vereinfachen:

// %% [markdown] lang="en" tags=["slide"]
// ## Pattern Matching
//
// With Java 14, the `instanceof` expression was extended to support pattern matching:
//   * If a test is positive.
//   * ... a local pattern variable is assigned.
//
// In
// ```java
// if (obj instanceof String s) {
// ```
//
// | Patternmatching-Test | Patternvariable
// | --- | --- |
// | `obj instanceof String` | `String s` |
//
// Thus, the Java program above can be simplified as follows:

// %%
if (obj instanceof String s) {
    System.out.printf("Arbeiten mit einem String der Länge %s.%n", s.length());
}

// %% [markdown] lang="de" tags=["slide"]
// ## Scoping
//
// Während dem Patternmatching führt der Compiler *flow scoping* durch:
//   * Dort wo der Code hinkommen könnte, wird die Patternvariable im Scope liegen

// %% tags=["start"]
void flowScoping_Beispiel1(Object a, Object b) {
    if (a instanceof String p) {
        // 
    }

    // 

    if (b instanceof String p) {
        // 
        // 
    }
}

// %%
void flowScoping_Beispiel1(Object a, Object b) {
    if (a instanceof String p) {
        // p liegt im scope. Der Compiler kann durch flow scoping sicherstellen kann, dass in diesem Block p belegt ist.
    }

    // p liegt nicht im scope. Der Compiler weiß durch flow scoping, dass hier p nicht in jedem Fall belegt ist.

    if (b instanceof String p) {
        // p liegt im scope. Der Compiler kann durch flow scoping sicherstellen kann, dass in diesem Block p belegt ist.
        // Dieses p ist allerdings ein anderes als im obigen if-Statement.
    }
}

// %% [markdown] lang="de" tags=["slide"]
// Die Patternvariable `s` wird außerhalb des if-Statements zur Verfügung stehen, solange wir nicht aus dem if-Zweig heraus returnen.

// %% [markdown] lang="en" tags=["slide"]
// The pattern variable `s` will be available outside of the if-statement as long as we do not return from the if branch

// %%
public void print(Object o){
    if(!(o instanceof String s)){
        return;
    }
    System.out.println(s.length());
}

// %%
print("Hello");

// %% [markdown] lang="de" tags=["slide"]
// ## *flow scoping* bei logischen Verknüpfungen.

// %% [markdown] lang="en" tags=["slide"]
// ## *flow scoping* with logical conjunctions.

// %% [markdown] lang="de" tags=["slide"]
// ### *flow scoping* bei AND.

// %% [markdown] lang="en" tags=["slide"]
// ### *flow scoping* with AND.

// %%
void flowScoping_and(Object a) {
    if (a instanceof String p && p.hashCode() > 0) {
        // p liegt im scope für das if-Statement. Der Compiler kann durch flow scoping sicherstellen kann, dass in diesem Block p belegt ist.
    }
}

// %% [markdown] lang="de" tags=["slide"]
// ### *flow scoping* bei OR.
//
// Nachfolgender Code liefert einen Compilerfehler
// - `||` muss beide Seiten des Ausdrucks auswerten.
// - Somit ist unklar, ob $p$ im Scope liegt.
//
// *Leider liefert JShell/Jupyter hier keinen Fehler.*

// %% [markdown] lang="en" tags=["slide"]
// ### *flow scoping* with OR.
//
// The following code produces a compiler error:
// - `||` needs to check both sides of the expression.
// - Thus, it is unclear whether $p$ is in scope.
//
// *Unfortunately, JShell/Jupyter does not produce an error here.*

// %%
void flowScoping_or(Object a) {
    if (a instanceof String p || p.hashCode() > 0) {}
    // Compilerfehler: Compiler kann nicht sicherstellen, das jeder flow die Patternvariable p belegen würde.
}

// %%
flowScoping_or("Hello");

// %% [markdown] lang="de" tags=["slide"]
// ## flow scoping
// 
// ### logisches AND
// 
//     a instanceof String p && p.hashCode() > 0
// 
// | a is `String`           |         | a is not `String`       |                       |
// |-------------------------|---------|-------------------------|-----------------------|
// | `a instanceof String p` | `true`  | `a instanceof String p` | `false`               |
// | `p.hashCode()`          | p known |                         | right side is skipped |
// 
// ### logisches OR
// 
//     a instanceof String p || p.hashCode() > 0
// 
// | a is `String`           |         | a is not `String`       |                            |
// |-------------------------|---------|-------------------------|----------------------------|
// | `a instanceof String p` | `true`  | `a instanceof String p` | `false`                    |
// | `p.hashCode()`          | p known | `p.hashCode()`          | p unknown - compiler error |

// %% [markdown] lang="en" tags=["slide"]
// ## flow scoping
//
// ### logical AND
//
//     a instanceof String p && p.hashCode() > 0
//
// | a is `String`           |         | a is not `String`       |                       |
// |-------------------------|---------|-------------------------|-----------------------|
// | `a instanceof String p` | `true`  | `a instanceof String p` | `false`               |
// | `p.hashCode()`          | p known |                         | right side is skipped |
//
// ### logical OR
//
//     a instanceof String p || p.hashCode() > 0
//
// | a is `String`           |         | a is not `String`       |                            |
// |-------------------------|---------|-------------------------|----------------------------|
// | `a instanceof String p` | `true`  | `a instanceof String p` | `false`                    |
// | `p.hashCode()`          | p known | `p.hashCode()`          | p unknown - compiler error |

// %% [markdown] lang="de" tags=["slide"]
// ## Anwendungsbeispiel in `equals`

// %% [markdown] lang="en" tags=["slide"]
// ## Example in `equals`

// %% tags=["start"]
class Point {
    int x;
    int y;
    
    Point(int x, int y) { this.x = x; this.y = y; }

    boolean equalsOhneInstanceofPatternMatching(Object o) {
        if (!(o instanceof Point))
            return false;
        Point other = (Point) o;
        return x == other.x && y == other.y;
    }
}

// %%
class Point {
    int x;
    int y;
    
    Point(int x, int y) { this.x = x; this.y = y; }

    boolean equalsOhneInstanceofPatternMatching(Object o) {
        if (!(o instanceof Point))
            return false;
        Point other = (Point) o;
        return x == other.x && y == other.y;
    }

    boolean equalsMitInstanceofPatternMatching(Object o) {
        return (o instanceof Point other)
                && x == other.x
                && y == other.y;
    }

    @Override
    public boolean equals(Object o) {
        return equalsMitInstanceofPatternMatching(o);
        // return equalsOhneInstanceofPatternMatching(o);
    }
}

// %% [markdown] lang="de" tags=["slide"]
// ### Nutzen:
// - Lesbarkeit: Ausdrucksstärker, leichter zu lesen
// - Sicherheit: Keine Casts notwendig, weniger Laufzeitfehler durch falsche Casts
// - Kürze: Weniger Code, weniger Boilerplate Code



// %% [markdown] lang="en" tags=["slide"]
// ## Mini-Workshop
// 
// Refactor the following code to use pattern matching with instance-of

// %% [markdown] lang="de" tags=["slide"]
// ## Mini-Workshop
//
// Refaktorisiere den folgenden Code, um Pattern Matching mit instanceof zu verwenden

// %%
public class Circle {    
    private int x;
    private int y;
    private int radius;
    
    public Circle(int x, int y){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}

// %%
public class Square {
    private int x;
    private int y;
    private int length;
    
    public Square(int x, int y, int length){
        this.x = x;
        this.y = y;
        this.length = length;
    }
}

// %%
public class Line {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

// %%
double computeArea(Object shape) {
    if (shape instanceof Circle) {
        Circle c = (Circle) shape;
        return Math.PI * c.radius() * c.radius();
    } else if (shape instanceof Square) {
        Rectangle s = (Square) shape;
        return s.length() * s.length();
    } else if (shape instanceof Line) {
        return 0;
    } else {
        throw new IllegalArgumentException();
    }
}

// %% [markdown] lang="en" tags=["slide"]
// - Which benefits do you see in the refactored code?
// - Can you identify any potential problems with the refactored code?

// %% [markdown] lang="de" tags=["slide"]
// - Welche Vorteile siehst du im refaktorisierten Code?
// - Kannst du potentielle Probleme mit dem refaktorisierten Code identifizieren?
// - Überlege Dir, welche Probleme bei Erweiterungen des Codes auftreten könnten

// %%
interface BaseFigure {
    double calcArea();
}

// %%
public class Circle implements BaseFigure {    
    private int x;
    private int y;
    private int radius;
    
    public Circle(int x, int y){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }
}
 
// %%
public class Square implements BaseFigure {
    private int x;
    private int y;
    private int length;
    
    public Square(int x, int y, int length){
        this.x = x;
        this.y = y;
        this.length = length;
    }
    
    @Override
    public double calcArea() {
        return length * length;
    }
}

// %%
public class Line implements BaseFigure {
    
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    @Override
    public double calcArea() {
        return 0;
    }
}

// %%
double computeArea(BaseFigure shape) {
    return shape.calcArea();
}

// %% [markdown] lang="de" tags=["slide"]
// - Wie wirkt sich eine Erweiterung um ein neues Shape auf den Code aus?

// %%
public class Rectangle implements BaseFigure {
    
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calcArea() {
        return width * height;
    }
}
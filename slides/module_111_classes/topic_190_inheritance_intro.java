// j2 from 'macros.j2' import header
// {{ header("Vererbung: Motivation", "Inheritance: Motivaton") }}

// %% [markdown] lang="de" tags=["slide"]
//
//  ## Motivation für Vererbung
//
// Wir haben folgende Klasse implementiert:

// %% [markdown] lang="en" tags=["slide"]
//
// ## Motivation for Inheritance
//
// We have implemented the following class:

// %% tags=["keep"]
import java.util.Random;

// %% tags=["keep"]
public class Point {
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

    public void randomize() {
        Random r = new Random();
        this.x = r.nextGaussian();
        this.y = r.nextGaussian();
    }

    public String toString() {
        return "Point: x = " + this.x + ", y = " + this.y;
    }
}

// %% tags=["subslide", "keep"]
Point p = new Point(2, 3);
p

// %% tags=["keep"]
p.move(2, 3);
p

// %% tags=["keep"]
p.randomize();
p

// %% tags=["keep"]
List<Point> buildRectangle(Point leftLower, Point rightUpper) {
    List<Point> rectangle = List.of(leftLower, rightUpper);
    return rectangle;
}

// %% tags=["keep"]
buildRectangle(new Point(0, 0), new Point(1, 1))

// %% [markdown] lang="de" tags=["slide"]
//
// Wie können wir farbige Punkte einführen?

// %% [markdown] lang="en" tags=["subslide"]
//
// How can we introduce colored points?


// %% tags=["start"]
public class Point {
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

    public void randomize() {
        Random r = new Random();
        this.x = r.nextGaussian();
        this.y = r.nextGaussian();
    }

    public String toString() {
        return "Point: x = " + this.x + ", y = " + this.y;
    }
}


// %% tags=["alt"]
public class ColorPoint {
    public double x;
    public double y;
    public String color;

    public ColorPoint(double x, double y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void randomize() {
        Random r = new Random();
        this.x = r.nextGaussian();
        this.y = r.nextGaussian();
    }

    public String toString() {
        return "ColorPoint: x = " + this.x + ", y = " + this.y + ", color = " + this.color;
    }
}

// %% tags=["subslide", "keep"]
ColorPoint cp = new ColorPoint(2, 3, "black");
cp

// %% tags=["keep"]
cp.color = "red"

// %% tags=["keep", "subslide"]
cp.move(2, 3);
cp

// %% tags=["keep"]
cp.randomize();
cp

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Probleme
//
// - Code-Duplizierung
// - Das Java Typsystem weiß nicht, dass `ColorPoint` ein `Point` ist:

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Problems
//
// - Code duplication
// - The Java type system does not know that `ColorPoint` is a `Point`:

// %% tags=["keep"]
Point point = new Point(0, 0);
if (point instanceof Point) {
    System.out.println("Point ist ein Point");
} else {
    System.out.println("Point ist kein Point");
}

// %% tags=["keep"]
// Compile error
/* ColorPoint point = new ColorPoint(0, 0, "red");
if (point instanceof Point) {
    System.out.println("Point ist ein Point");
} else {
    System.out.println("Point ist kein Point");
} */

// %% tags=["keep"]
buildRectangle(new ColorPoint(0, 0, "black"), new ColorPoint(1, 1, "black"))


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Welche Lösungen gibt es?
//
// - Vererbung: `ColorPoint` erbt von `Point`
// - Schnittstellen (Interfaces): `ColorPoint` und `Point` implementieren das gleiche Interface
//
// Ergebnis: Subtyp- bzw. Konsistenz-Beziehung

// %% [markdown] lang="en" tags=["subslide"]
//
// ## What solutions are there?
//
// - Inheritance: `ColorPoint` inherits from `Point`
// - Interfaces: `ColorPoint` and `Point` implement the same Interface
//
// Result: Subtype (or consistency) relationship

// j2 from 'macros.j2' import header
// {{ header("Vererbung", "Inheritance") }}

// %% [markdown] lang="de" tags=["slide"]
//
//  ## Vererbung
//
// Wir haben folgende Klasse implementiert:

// %% [markdown] lang="en" tags=["slide"]
//
// ## Inheritance
//
// We have implemented the following class:

// %% tags=["keep"]
import java.util.Random;


// %% tags=["keep"]
public class Point {
    double x;
    double y;
    
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    void randomize(){
        Random random = new Random();
        x = 2 + 0.5 * random.nextGaussian();
        y = 3 + 0.5 * random.nextGaussian();
    }
}


// %% tags=["subslide", "keep"]
Point p = new Point(1, 1);
p

// %% tags=["keep"]
p.move(2, 3);
p

// %% tags=["keep"]
p.randomize();
p


// %% [markdown] lang="de" tags=["slide"]
//
// Wie können wir farbige Punkte einführen, ohne die komplette Funktionalität
// von `Point` neu implementieren zu müssen?

// %% [markdown] lang="en" tags=["subslide"]
//
// How can we introduce colored points without having to re-implement the
// entire functionality of `Point`?


// %%
public class ColorPoint extends Point {
    String color;

    ColorPoint(double x, double y, String color) {
        super(x, y);
        this.color = color;
    }

    public String toString() {
        return "ColorPoint(" + x + ", " + y + ", " + color + ")";
    }

    void randomize() {
        super.randomize();
        String[] colors = {"black", "red", "green", "blue", "yellow", "white"};
        Random random = new Random();
        color = colors[ random.nextInt(colors.length)];
    }
}


// %% tags=["subslide", "keep"]
ColorPoint cp = new ColorPoint(2, 3, "black");
cp


// %% tags=["keep"]
System.out.println(cp.x == 2.0);
System.out.println(cp.y == 3.0);
System.out.println(cp.color.equals("black"));

// %% tags=["keep"]
cp.color = "red";

// %% tags=["keep"]
System.out.println(cp.x == 2.0);
System.out.println(cp.y == 3.0);
System.out.println(cp.color.equals("red"));

// %% tags=["keep", "subslide"]
cp.move(2, 3);
cp

// %% tags=["keep"]
System.out.println(cp.x == 4.0);
System.out.println(cp.y == 6.0);
System.out.println(cp.color.equals("black"));

// %% tags=["keep"]
cp.randomize();
cp

// j2 include "ws_192_inheritance.java"

// %% [markdown] lang="de" tags=["subslide"]
//
// Eine Visualisierung für `super()`-Aufrufe bei Vererbung mit Java Tutor
// ist [hier](shorturl.at/efDKW).

// %% [markdown] lang="en" tags=["subslide"]
//
// A visualization for `super()` calls in inheritance with Java Tutor is
// [here](shorturl.at/efDKW).


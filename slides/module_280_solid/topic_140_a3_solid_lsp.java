// j2 from 'macros.j2' import header
// {{ header("Liskov-Substitution-Principle", "Liskov-Substitution-Principle") }}

// %% [markdown] lang="de" tags=["slide"]
//
// ## SOLID: Liskov-Substitution-Principle
//
// Ein Objekt einer Unterklasse soll immer für ein Objekt der Oberklasse
// eingesetzt werden können.

// %% [markdown] lang="en" tags=["slide"]
//
// ## SOLID: Liskov-Substitution-Principle
//
// It should always be possible to substitute an object of a subclass for an
// object of its parent class.

// %% [markdown] lang="de" tags=["subslide"]
//
// ## LSP Verletzung

// %% [markdown] lang="en" tags=["subslide"]
//
// ## LSP Violation

// %% tags=["keep"]
public class Rectangle {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return this.length * this.width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    @Override
    public String toString() {
        return "Rectangle [length=" + length + ", width=" + width + "]";
    }

}


// %% tags=["keep"]
public class Square extends Rectangle {

    public Square(double length, double width) {
        super(length, length);
    }

    @Override
    public double getLength() {
        return super.getLength();
    }

    @Override
    public void setLength(double newLength) {
        super.setLength(newLength);
        super.setWidth(newLength);
    }

    @Override
    public double getWidth() {
        return super.getLength();
    }

    @Override
    public void setWidth(double newWidth) {
        super.setLength(newWidth);
        super.setWidth(newWidth);
    }
    
}

// %% tags=["keep"]
Rectangle rect = new Square(5, 5);
rect.setWidth(10);
System.out.println(rect); // Ausgabe: Square [length=10.0, width=10.0]


// %%
// Shape Interface
public interface Shape {
    double area();
    String toString();
}

// %%
// Rectangle Klasse, die das Shape Interface implementiert
public class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return this.length * this.width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle [length=" + length + ", width=" + width + "]";
    }
}


// %%
// Square Klasse, die das Shape Interface implementiert
public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Square [side=" + side + "]";
    }
}

// %%
Shape square = new Square(5.0);
System.out.println(square);
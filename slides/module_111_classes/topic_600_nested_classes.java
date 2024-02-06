// j2 from 'macros.j2' import header
// {{ header("Nested Classes", "Nested Classes") }}

// %% [markdown] lang="en" tags=["slide"]
// ## Introduction to Nested Classes
// - The Java programming language allows you to define a class within another class - a nested class.

// %%
class OuterClass {
    class NestedClass {
    }
}

// %% [markdown] lang="en" tags=["slide"]
// - Nested classes are divided into two categories: non-static and static. 
//      - Non-static nested classes are called inner classes. 
//      - Nested classes that are declared static are called static nested classes. 

// %% tags=["keep"]
class OuterClass {
    
    class InnerClass {
    
    }
    static class StaticNestedClass {

    }
}
// %% [markdown] lang="en" tags=["slide"]
// ## Properties of Nested Classes
// - A nested class is a member of its enclosing class. 
// - Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are declared private. 
// - Static nested classes do not have access to other members of the enclosing class. 

// %% [markdown] lang="en" tags=["slide"]
// ## Why Use Nested Classes?
// - It is a way of logically grouping classes that are only used in one place
//      -  If a class is useful to only one other class, then it is logical to embed it in that class and keep the two together.
//      - Nesting such "helper classes" makes their package more streamlined.
// - It increases encapsulation: Consider two top-level classes, A and B, where B needs access to members of A that would otherwise be declared private. 
//      - By hiding class B within class A, A's members can be declared private and B can access them. In addition, B itself can be hidden from the outside world.
// - It can lead to more readable and maintainable code: Nesting small classes within top-level classes places the code closer to where it is used.

// %% tags=["slide", "start"]
public class Computer {
    
    public Computer() {
        cpu = new CPU();
        graphicsCard = new GraphicsCard();
    }

    public void start() {
        cpu.processData();
        graphicsCard.renderGraphics();
    }
}

// %% tags=["alt"]
public class Computer {
    private CPU cpu;
    private GraphicsCard graphicsCard;

    public Computer() {
        cpu = new CPU();
        graphicsCard = new GraphicsCard();
    }

    public void start() {
        cpu.processData();
        graphicsCard.renderGraphics();
    }

    // Nested Inner Class for CPU
    private class CPU {
        void processData() {
            System.out.println("Processing data...");
        }
    }

    // Nested Inner Class for GraphicsCard
    private class GraphicsCard {
        void renderGraphics() {
            System.out.println("Rendering graphics...");
        }
    }
}


// %%     
Computer myComputer = new Computer();
myComputer.start();

// %% [markdown] lang="en" tags=["slide"]
// ## Inner Classes
// - An inner class is associated with an instance of its enclosing class and has direct access to that object's methods and fields. 
// - That is why it cannot define any static members itself.
// - Objects that are instances of an inner class exist within an instance of the outer class.
// - An instance of InnerClass can exist only within an instance of OuterClass and has direct access to the methods and fields of its enclosing instance.
// - To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:

// %%
// new Computer.CPU();

// %%
Computer computer = new Computer();
Computer.CPU cpu = computer.new CPU();
cpu.processData()

// %% [markdown] lang="en" tags=["slide"]
// ## Static Nested Classes
// - A static nested class is associated with its outer class. 
// - A static nested class cannot refer directly to instance variables or methods defined in its enclosing class (like static class methods).
// - A static nested class interacts with the instance members of its outer class (and other classes) just like any other top-level class. 
// - In effect, a static nested class is behaviorally a top-level class that has been nested in another top-level class for packaging convenience.


// %% tags=["slide","keep"]
public class Vehicle {

    // Static nested class
    public static class Wheel {
        private int size;

        public Wheel(int size) {
            this.size = size;
        }

        public void wheelInfo() {
            System.out.println("Wheel size: " + size + " inches.");
        }
    }

    private Wheel[] wheels;

    public Vehicle(int numberOfWheels, int wheelSize) {
        wheels = new Wheel[numberOfWheels];
        for (int i = 0; i < numberOfWheels; i++) {
            wheels[i] = new Wheel(wheelSize);
        }
    }

    public void vehicleInfo() {
        System.out.println("Vehicle with " + wheels.length + " wheels.");
        for (Wheel wheel : wheels) {
            wheel.wheelInfo();
        }
    }
}

// %% 
Vehicle car = new Vehicle(4, 15);
car.vehicleInfo();

// %% [markdown] lang="en" tags=["slide"]
// - You instantiate a static nested class the same way as a top-level class:

// %%
Vehicle.Wheel wheel = new Vehicle.Wheel(15);

// %% [markdown] lang="en" tags=["slide"]
// ## Inner Class and Nested Static Class Example
// - The following example demonstrates 
//      - access to class members of OuterClass from an inner class (InnerClass)
//      - a nested static class (StaticNestedClass)
//      - and a top-level class (TopLevelClass).

// %% tags=["keep"]
public class OuterClass {

    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
            // Cannot make a static reference to the non-static field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }
}

// %% 
OuterClass outerObject = new OuterClass();

// %% [markdown] lang="en" tags=["slide"]
// Inner class

// %%
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
innerObject.accessMembers();

// %% [markdown] lang="en" tags=["slide"]
// Static nested class

// %%
OuterClass.StaticNestedClass staticNestedObject = new OuterClass.StaticNestedClass();        
staticNestedObject.accessMembers(outerObject);

// %% tags=["keep"]
public class TopLevelClass {
    void accessMembers(OuterClass outer) {     
        // Cannot make a static reference to the non-static field OuterClass.outerField
        // System.out.println(OuterClass.outerField);
        System.out.println(outer.outerField);
        System.out.println(OuterClass.staticOuterField);
    }  
}

// %%
TopLevelClass topLevelObject = new TopLevelClass();        
topLevelObject.accessMembers(outerObject);                

// %% [markdown] lang="en" tags=["slide"]
// ## Shadowing
// - Shadowing occurs if a declaration of a type in a particular scope has the same name as another declaration in the enclosing scope.
// - You cannot refer to a shadowed declaration by its name alone. 
// - The example below demonstrates this:

// %% tags=["start"]
public class ShadowTest {

    public int x = 0;

    class FirstLevel {
        
    }
}

// %% tags=["alt"]
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }
}

// %%
ShadowTest st = new ShadowTest();
ShadowTest.FirstLevel fl = st.new FirstLevel();
fl.methodInFirstLevel(23);

// %% [markdown] lang="en" tags=["slide"]
// ## Serialization
// - Serialization of inner classes, including local and anonymous classes, is strongly discouraged.
// - When the Java compiler compiles certain constructs, such as inner classes, it creates synthetic constructs. 
//      - These are classes, methods, fields, and other constructs that do not have a corresponding construct in the source code. 
// - Synthetic constructs enable Java compilers to implement new Java language features without changes to the JVM. 
// - However, synthetic constructs can vary among different Java compiler implementations, which means that .class files can vary among different implementations as well. 
// - Consequently, you may have compatibility issues if you serialize an inner class and then deserialize it with a different JRE implementation.

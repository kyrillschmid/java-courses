// j2 from 'macros.j2' import header
// {{ header("Anonyme Klassen", "Anonymous Classes") }} 

// %% [markdown] lang="en" tags=["slide"]
// ## Anonymous classes
// - Enable you to declare and instantiate a class at the same time. 
// - They are like local classes except that they do not have a name.
// - Use them if you need to use a local class only once.

// %% [markdown] lang="en" tags=["slide"]
// ## This notebook covers the following topics:
// - Declaring Anonymous Classes
// - Syntax of Anonymous Classes
// - Accessing Local Variables of the Enclosing Scope, and Declaring and Accessing Members of the Anonymous Class
// - Examples of Anonymous Classes

// %% [markdown] lang="en" tags=["slide"]
// ## Declaring Anonymous Classes
// - While local classes are class declarations, anonymous classes are expressions, which means that you define the class in another expression.

// %% tags=["keep"]
interface HelloWorld {
    public void greet();
    public void greetSomeone(String someone);
}

// %% tags=["start"]
class EnglishGreeting implements HelloWorld {
}

// %% tags=["alt"]
class EnglishGreeting implements HelloWorld {
    String name = "world";
    public void greet() {
        greetSomeone("world");
    }
    public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Hello " + name);
    }
}

// %%
HelloWorld englishGreeting = new EnglishGreeting();
englishGreeting.greet();

// %% tags=["slide"]
HelloWorld frenchGreeting = new HelloWorld() {
    String name = "tout le monde";
    public void greet() {
        greetSomeone("tout le monde");
    }
    public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Salut " + name);
    }
};

// %% tags=["slide", "keep"]
HelloWorld spanishGreeting = new HelloWorld() {
    String name = "mundo";
    public void greet() {
        greetSomeone("mundo");
    }
    public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Hola, " + name);
    }
};

// %%
frenchGreeting.greetSomeone("Fred");

// %%
spanishGreeting.greet();

// %% [markdown] lang="en" tags=["slide"]
// - If you want to add custom methods that you can call from outside, you need to use `var` to declare the variable.

// %% tags=["slide"]
var frenchGreeting = new HelloWorld() {
    String name = "tout le monde";
    public void greet() {
        greetSomeone("tout le monde");
    }
    public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Salut " + name);
    }

    public void sayGoodbye() {
        System.out.println("Au revoir");
    }
};

// %% tags=["slide"]
frenchGreeting.sayGoodbye();


// %% [markdown] lang="en" tags=["slide"]
// ## Syntax of Anonymous Classes
// - As mentioned previously, an anonymous class is an expression. 
// - The syntax of an anonymous class expression is like the invocation of a constructor, except that there is a class definition contained in a block of code.

// %%
HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
};

// %% [markdown] lang="en" tags=["slide"]
// - The anonymous class expression consists of the following:
//     - The `new` operator
//     - The name of an interface to implement or a class to extend. In this example, the anonymous class is implementing the interface HelloWorld.
//     - Parentheses that contain the arguments to a constructor, just like a normal class instance creation expression (not needed with interfaces)
//     - A body, which is a class declaration body. More specifically, in the body, method declarations are allowed but statements are not. 


// %% [markdown] lang="en" tags=["slide"]
// ## Accessing Local Variables of the Enclosing Scope
// - Like local classes, anonymous classes can capture variables
// - They have the same access to local variables of the enclosing scope.

// %% [markdown] lang="en" tags=["slide"
// Anonymous classes in Java have the ability to access variables from their enclosing scope.
// - Local Variables: Anonymous classes can access final or effectively final local variables. A local variable is effectively final if its value is not changed after initialization.
// - Instance Variables: Anonymous classes can freely access instance variables of the enclosing class.


// %% tags=["keep"]
public class OuterClass {

    private int instanceVariable = 10; // Instance variable

    public void method() {
        int localVariable = 5; // Local variable (effectively final)

        // Anonymous class implementing Runnable interface
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Accessing instance variable
                System.out.println("Instance variable: " + instanceVariable);

                // Accessing local variable
                System.out.println("Local variable: " + localVariable);
            }
        };

        runnable.run();
    }
}

// %% 
OuterClass outer = new OuterClass();
outer.method();
    

// %% [markdown] lang="en" tags=["slide"]
// You can declare the following in anonymous classes:
// - Fields
// - Extra methods (even if they do not implement any methods of the supertype)
// - Instance initializers
// - Local classes
// - However, you cannot declare constructors in an anonymous class.


// %% [markdown] lang="en" tags=["slide"]
// ## Examples of Anonymous Classes
// - Anonymous classes are often used in graphical user interface (GUI) applications.

// %%
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}

// %% [markdown] lang="en" tags=["slide"]
//
// ## Mini-Workshop: Music Player
//
// In the following we will implement a functional music player using Anonymous Classes.
//
// - We would have an interface `MusicPlayer` with a method `play()`.
// - A local class `RockMusic` will implement the `MusicPlayer` interface.
// - We'll then use Anonymous Classes to implement other types of music: Classical and Jazz.
//
// Let's start implementing our music player!

// %% [markdown] lang="en" tags=["slide"]
// - First implement the `MusicPlayer` interface with a method `play()`.

// %% tags=["subslide"]
public interface MusicPlayer {
    public void play();
}

// %% [markdown] lang="en" tags=["slide"]
// - Now let's implement the interface with a local class for Rock music

// %% 
public class RockMusic implements MusicPlayer{
    public void play(){
        System.out.println("Playing Rock Music ..");
    }
}

// %% [markdown] lang="en" tags=["slide"]
// - Let's play some rock music by creating an instance of the `RockMusic` class and calling the `play()` method.

// %% 
MusicPlayer rock = new RockMusic();
rock.play();

// %% [markdown] lang="en" tags=["slide"]
// - Our rock music player is working perfectly. Now let's use anonymous classes to create players for other types of music.
// - Implement the `MusicPlayer` interface using an anonymous class for Classical music:

// %%
MusicPlayer classical = new MusicPlayer() {
    public void play() {
        System.out.println("Playing Classical Music ..");
    }
};
classical.play();

// %% [markdown]
// - Now let's create a Jazz music player using an anonymous class.

// %%
MusicPlayer jazz = new MusicPlayer() {
    public void play() {
        System.out.println("Playing Jazz Music ..");
    }
};
jazz.play();


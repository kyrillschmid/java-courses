// j2 from 'macros.j2' import header
// {{ header("Wie funktioniert Java ", "How does Java work?") }}

// %% [markdown] lang="de" tags=["slide"]
// # Einführung
// Wir beantworten folgende Fragen: 
// - Wie wird Java Code ausgeführt?
// - Welche Entwicklungsumgebungen gibt es?
// - Wie arbeitet man mit Notebooks?

// %% [markdown] lang="en" tags=["slide"]
// # Introduction
// We answer the following questions:
// - How is Java code executed?
// - What development environments are there?
// - How do you work with notebooks?

// %% [markdown] lang="de" tags=["slide"]
// # Wie funktioniert Java?

// %% [markdown] lang="en" tags=["slide"]
// # How does Java work?

// %% [markdown] tags=["subslide"]
// <img src="img/java_compilation.png" width="600">

// %% [markdown] lang="de" tags=["subslide"]
// # Erstes Java Programm 

// %% [markdown] lang="en" tags=["subslide"]
// # First Java Program

// %% tags=["keep"]
public class HelloJava{
    public static void main(String[] args){
        System.out.println("Hallo Welt!");
    } 
}

// %% [markdown] lang="de" tags=["subslide"]
// # Kompilieren mit javac
// ```bash
// - javac HelloJava.java
// ```

// %% [markdown] lang="en" tags=["subslide"]
// # Compiling with javac
// ```bash
// - javac HelloJava.java
// ```

// %% [markdown] lang="de" tags=["subslide"]
// # Ausführen mit java
// ```bash
// - java HelloJava
// ```

// %% [markdown] lang="en" tags=["subslide"]
// # Running with java
// ```bash
// - java HelloJava
// ```

// %% [markdown] lang="de" tags=["subslide"]
// # Entwicklungsumgebungen:
// - IntelliJ
// - Eclipse
// - Netbeans
// - Visual Studio Code

// %% [markdown] lang="en" tags=["subslide"]
// # Development environments:
// - IntelliJ
// - Eclipse
// - Netbeans
// - Visual Studio Code

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop: Java ausführen
//
// 1. Speichere den untenstehenden Code in die Datei ```Factorial.java``` in deinem lokalen Arbeitsverzeichnis.
// 1. Kompiliere und führe aus mit ```javac Factorial.java``` und ```java Factorial```.

// %% [markdown] lang="en" tags=["slide"]
// # Mini-Workshop: Running Java
//
// 1. Save the code below in the file ```Factorial.java``` in your local working directory.
// 1. Compile and run with ```javac Factorial.java``` and ```java Factorial```.

// %% tags=["keep"]
public class Factorial {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("ERR missing input");
            return;
        }

        final var n = Integer.parseInt(args[0]);
        final var fac = factorialUsingRecursion(n);
        System.out.println(fac);
    }

    static long factorialUsingRecursion(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorialUsingRecursion(n - 1);
    }
}

// %% 
Factorial.main(new String[]{"5"});


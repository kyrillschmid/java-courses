// j2 from 'macros.j2' import header
// {{ header("Ein-Datei Ausführung", "Single-File Execution") }}

// %% [markdown] lang="de" tags=["slide"]
// * Viele Sprachen haben eine große Verbreitung erreicht, weil sie direkt und einfach anwendbar sind.
// * Die Direktheit wird durch eine Ein-Dateien-Ausführung ohne Compilation unterstützt (Java 11, JEP 330).
//   * In der Unix Welt wird dieses Konzept mit *shebang* (`#!`) zusätzlich unterstützt.

// %% [markdown] lang="en" tags=["slide"]
// * Many languages have achieved wide distribution because they are direct and easy to use.
// * Directness is supported by a single-file execution without compilation (Java 11, JEP 330).
//   * In the Unix world, this concept is additionally supported by *shebang* (`#!`).

// %% [markdown] lang="de" tags=["slide"]
// ## shebang in Java
//
// * Der ```java``` Befehl wurde so erweitert, damit ein Ein-Dateien Java Programm ohne Umweg über ```javac``` ausgeführt werden kann.

// %% [markdown] lang="en" tags=["slide"]
// ## shebang in Java
//
// * The ```java``` command has been extended so that a single-file Java program can be executed without going through ```javac```.

// %% [markdown] lang="de" tags=["slide"]
// ## Vorteile
//
// * Harmonisierung der verwendeten Programmiersprachen in einem Produkt.
// * Es können die gleichen Bibliotheken genutzt werden, wie in dem Produkt.
// * Es können Funktionen des Produktes direkt verwendet werden - dies reduziert zeitaufwendige Überraschungen.

// %% [markdown] lang="en" tags=["slide"]
// ## Advantages
//
// * Harmonization of the programming languages used in a product.
// * The same libraries can be used as in the product.
// * Functions of the product can be used directly - this reduces time-consuming surprises.

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop: Launch Single-File Source-Code Programs
//
// 1. Speichere den untenstehenden Code in die Datei ```Factorial.java``` in deinem lokalen Arbeitsverzeichnis.
// 1. Führe ```java Factorial.java 5``` aus.

// %% [markdown] lang="en" tags=["slide"]
// # Mini-Workshop: Launch Single-File Source-Code Programs
//
// 1. Save the code below to the file ```Factorial.java``` in your local working directory.
// 1. Execute ```java Factorial.java 5```.

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

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop: Launch Single-File Source-Code Programs (shebang)
//
// 1. Speichere den nachfolgenden Code in die Datei ```PrimeFactors``` (keine Dateiendung) in deinem lokalen Arbeitsverzeichnis.
//   * Eventuell musst du den Pfad zu deinem ```java``` anpassen.
// 2. *In Mac und Linux*: Mache die Datei ausführbar mit `chmod +x PrimeFactors`.
// 3. Führe das Programm aus mit ```./PrimeFactors 120```.

// %% [markdown] lang="en" tags=["slide"]
// # Mini-Workshop: Launch Single-File Source-Code Programs (shebang)
//
// 1. Save the code below to the file ```PrimeFactors``` (no file extension) in your local working directory.
//   * You may need to adjust the path to your ```java```.
// 2. *In Mac and Linux*: Make the file executable with `chmod +x PrimeFactors`.
// 3. Execute the program with ```./PrimeFactors 120```.

// %% tags=["keep"]
#!/usr/bin/java --source 10
package com.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("ERR missing input");
            return;
        }

        final var n = Long.parseLong(args[0]);
        final var fac = primfaktoren(n);
        System.out.println(fac);
    }


    public static List<Long> primfaktoren(long n) {
        var f = new ArrayList<Long>();
        if (n == 1)
            return List.of();

        long t = 2;
        while (t * t <= n) {
            while (n % t == 0) {
                f.add(t);
                n /= t;
            }
            t++;
        }
        f.add(n);
        return f;
    }
}

// %% 
PrimeFactors.main(new String[]{"32"});
// j2 from 'macros.j2' import header
// {{ header("Test-Driven-Development", "Test-Driven-Development") }}


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Idee
//
// - Verwende Tests, um das Design und die Feature-Entwicklung des Programms
//   voranzutreiben
// - Jeder neue Test beschreibt ein Feature-Inkrement des Programms
// - (Gut testbarer Code entsteht dabei quasi als Nebenprodukt)

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Idea
//
// - Use tests to drive the design and feature development of the program
// - Each new test describes a feature increment of the program
// - (Good testable code is created as a by-product)

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Problem
//
// Wie können Tests das Design des Programms vorantreiben?

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Problem
//
// How can tests drive the design of the program?

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Mögliche Antworten
//
// - Tests verwenden die Funktionalität und zeigen komplizierte Interfaces auf
// - Tests ermöglichen Refactoring

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Possible answers
//
// - Tests use the functionality and therefore highlight clumsy interfaces
// - Tests enable refactoring

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Refactoring
//
// - Verbessern der Code-Struktur ohne Änderung des Verhaltens
// - Vorgehen in kleinen Schritten
//   - Nach jedem Schritt ist der Code wieder ausführbar
// - Ziele:
//   - Verbessern des Codes
//   - Verbesserung des Designs

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Refactoring
//
// - Improve the code structure without changing the behavior
//   - Proceed in small steps
//   - After each step, the code is executable again
// - Objectives:
//   - Improve the code
//   - Improve the design

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Refactoring und Tests
//
// - Durch Refactoring wird das Design des Programms in kleinen Schritten verbessert
// - Die Korrektheit dieser Schritte wird durch Tests abgesichert


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Refactoring and Tests
//
// - Refactoring improves the design of the program in small steps
// - The correctness of these steps is verified by tests

// %% [markdown] lang="de" tags=["subslide"]
//
// ## So what???
//
// <img src="img/dev-velocity.png"
//      style="display:block;margin:auto;width:70%"/>


// %% [markdown] lang="en" tags=["subslide"]
//
// ## So what???
//
// <img src="img/dev-velocity.png"
//      style="display:block;margin:auto;width:70%"/>

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Test-Driven Development
//
// - Ziel beim TDD ist nicht in erster Linie, eine hohe Testabdeckung zu erreichen
//   - Typischerweise schreibt man keine Tests für Methoden, von denen man überzeugt
//     ist, dass sie nicht fehlschlagen können
// - Ziel beim TDD ist es, durch Tests ein gutes Design zu entdecken
//   - Beim Schreiben der Tests versucht man, das Interface von Klassen und Funktionen
//     so zu gestalten, dass es leicht zu benutzen ist
//   - Dadurch, dass alle wesentlichen Teile des Programms durch Tests abgesichert
//     sind, kann man das Design durch Refactoring permanent an das aktuelle Feature-Set
//     anpassen


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Test-Driven Development
//
// - The goal of TDD is not primarily to achieve high test coverage
//   - Typically, one does not write tests for methods that one is convinced cannot fail
// - The goal of TDD is to discover a good design through testing
//   - When writing the tests, one tries to design the interfaces of classes and
//     functions in such a way that it is easy to use
//   - Because all essential parts of the program are protected by tests,
//     one can permanently adapt the design to the current feature set through
//     refactoring

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Der TDD-Zyklus
//
// - Schreibe einen (minimalen) Test
//   - Der Test testet nur ein einziges neues (Teil-)Feature: **Baby Steps**
//   - Dieser Test schlägt fehl
// - Implementiere die minimale Funktionalität, um den Test zum Laufen zu bringen
//   - Dabei muss man nicht auf sauberen Code oder gutes Design achten
//   - Aber: **Solve Simply**
// - Verbessere den Code
//   - Entferne die unsauberen Konstrukte, die im vorhergehenden Schritt eingefügt wurden
//   - Generalisiere die Implementierung, wenn zu viel Wiederholung entstanden ist
//   - **Dieser Schritt ist nicht optional!!!**


// %% [markdown] lang="en" tags=["subslide"]
//
// ## The TDD Cycle
// - Write a (minimal) test
//   - The test only tests one new (partial) feature: **Baby Steps**
//   - This test fails
// - Implement the minimal functionality to get the test to work
//   - You don't have to pay attention to clean code or good design
//   - But: **Solve Simply**
// - Improve the code
//   - Remove the dirty constructs introduced in the previous step
//   - Generalize the implementation if there is too much repetition
//   - **This step is not optional!!!**

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Der TDD-Zyklus
//
// - <span style="color: red"><b>Red (fehlschlagender Test)</b></span>
// - <span style="color: green"><b>Green (alle Tests sind wieder grün)</b></span>
// - <span style="color: blue"><b>Clean/Refactor (der Code ist wieder sauber)</b></span>

// %% [markdown] lang="en" tags=["subslide"]
//
// ## The TDD cycle
//
// - <span style="color: red"><b>Red (failing test)</b></span>
// - <span style="color: green"><b>Green (all tests are green again)</b></span>
// - <span style="color: blue"><b>Clean/Refactor (the code is clean again)</b></span>

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Baby-Steps
//
// - Das System ist nicht stunden- oder tagelang in einem Zustand, in dem es nicht
//   baubar, testbar oder ausführbar ist
// - Dadurch bekommt man bei jeder Änderung schnell Feedback vom Code
// - Häufiges Mergen und CI wird möglich

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Baby steps
//
// - The system does not spend hours or days in a state in which it is not buildable,
//   testable or executable
// - This allows you to quickly get feedback from the code with every change
// - Frequent merging and CI becomes possible

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Warum Solve Simply?
//
// - Eine flexible, generische Lösung erhöht oft die Komplexität des Systems
// - Das lohnt sich nur, wenn die Flexibilität auch benötigt wird
// - Entwickler können meist schlecht vorhersehen, an welchen Stellen
//   Flexibilität/Erweiterbarkeit benötigt wird
// - Eine flexible, generische Lösung ist oft sehr viel schwerer zu implementieren
//   als eine einfache Lösung für einen spezielleren Anwendungsfall
// - Die naheliegendste flexible, generische Lösung ist oft nicht der sauberste und
//   wartbare Code

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Why Solve Simply?
//
// - A flexible, generic solution often increases the complexity of the system
// - It is only worthwhile if the flexibility is actually needed
// - Developers usually have a hard time predicting where flexibility/extensibility is
//   needed
// - A flexible, generic solution is often much more difficult to implement than
//   a simple solution for a more specific use case
// - The most obvious flexible, generic solution is often not the cleanest and
//   most maintainable code

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Annahmen von Solve Simply
//
// - Es ist durch Refactoring möglich, Code in einen sauberen, wartbaren Zustand zu
//   bekommen, ohne dadurch die Funktionalität zu verändern
// - Es ist möglich, Code iterativ zu erweitern und flexibler zu machen,
//   wenn das erforderlich ist
// - Es ist einfacher, die Refactoring- und Iterations-Schritte durchzuführen, als
//   gleich die endgültige Lösung zu entwickeln
// - Diese Annahmen sind nur dann erfüllt, wenn hinreichend viele, gute
//   Unit-Tests vorliegen

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Assumptions of Solve Simply
// - It is possible to refactor code into a clean, maintainable state without changing
//   functionality
// - It is possible to extend code iteratively and make it more flexible when needed
// - It is easier to carry out the refactoring and iteration steps than to develop
//   the final solution right away
// - These assumptions are only fulfilled if a sufficient number of good unit tests
//   are available

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Noch besser: TDD + Vorbereitungsschritt
//
// - Refactore den Code, sodass die Änderung einfach wird
//   - Das ist oft nicht so einfach…
//   - Wenn beim Refactoring klar wird, dass Tests fehlen, so werden diese hinzugefügt
// - Führe die einfache Änderung mit dem TDD-Zyklus durch
// - Wiederhole diese Schritte immer wieder

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Even better: TDD + preparation step
//
// - Refactor the code so that the change becomes easy
//   - This is often not that easy...
//   - If during the refactoring it becomes clear that tests are missing, they are added
// - Do the easy change with the TDD cycle
// - Repeat these steps over and over again

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Geleitetes Kata: Primfaktorzerlegung
//
// - Eine Übung zu TDD, die zeigt, wie man durch Tests auf eine einfache
//   Implementierung eines Algorithmus geführt werden kann
// - Wichtig ist die Vorgehensweise: Tests sollen das Design treiben
// - Ziel: Lernen inkrementell und iterativ zu arbeiten!

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Guided Kata: Prime Factor Decomposition
//
// - An exercise in TDD that shows how tests can be used to lead to a simple
//   implementation of an algorithm
// - The important thing is the procedure: Tests should drive the design
// - Goal: Learn to work incrementally and iteratively!


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Geleitetes Kata: Primfaktorzerlegung
//
// Schreiben Sie eine Funktion
//
// ```python
// compute_prime_factors(n: int) -> list[int]
// ```
// die die Primfaktoren von n in aufsteigender Reihenfolge zurückgibt.
//
// Mehrfach vorkommende Primfaktoren sind in der Liste mehrmals enthalten.
//
// Sie können dazu das Programmgerüst `examples/PrimesStarterKit` hernehmen.

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Guided Kata: Prime factorization
//
// Write a function
//
// ```python
// compute_prime_factors(n: int) -> list[int]
// ```
//
// that returns the prime factors of n in ascending order.
//
// Prime factors that occur more than once appear in the list more than once.
//
// You can use the program framework `examplesPrimesStarterKit`.

// %% tags=["subslide", "keep"]
%maven org.junit.jupiter:junit-jupiter-api:5.8.2
import static org.junit.jupiter.api.Assertions.assertEquals;


// %% tags=["subslide", "alt"]
public List<Integer> computePrimeFactors(int n) {
    return new ArrayList<>();
}


// %% tags=["alt"]
assertEquals(computePrimeFactors(1), Arrays.asList()); // assert


// %% tags=["subslide", "alt"]
public List<Integer> computePrimeFactors(int n) {
    if (n == 2) {
        return Arrays.asList(2);
    }
    return new ArrayList<>();
}


// %% tags=["alt"]
assertEquals(computePrimeFactors(1), Arrays.asList());
assertEquals(computePrimeFactors(2), Arrays.asList(2));


// %% tags=["subslide", "alt"]
public List<Integer> computePrimeFactors(int n) {
    if (n == 2) {
        return Arrays.asList(2);
    }
    if (n == 3){
        return Arrays.asList(3);
    }
    return new ArrayList<>();
}


// %% tags=["alt"]
assertEquals(computePrimeFactors(1), Arrays.asList());
assertEquals(computePrimeFactors(2), Arrays.asList(2));
assertEquals(computePrimeFactors(3), Arrays.asList(3));


// %% tags=["subslide", "alt"]
// Refactor
public List<Integer> computePrimeFactors(int n) {
    List<Integer> result = new ArrayList<>();
    if (n == 2) {
        result.add(2);
    }
    if (n == 3){
        result.add(3);
    }
    return result;
}


// %% tags=["alt"]
assertEquals(computePrimeFactors(1), Arrays.asList());
assertEquals(computePrimeFactors(2), Arrays.asList(2));
assertEquals(computePrimeFactors(3), Arrays.asList(3));


// %% tags=["subslide", "alt"]
// Implement
public List<Integer> computePrimeFactors(int n) {
    List<Integer> result = new ArrayList<>();
    if (n == 2) {
        result.add(2);
    }
    if (n == 3){
        result.add(3);
    }
    if (n == 4){
        result.add(2);
        result.add(2);
    }
    return result;
}


// %% tags=["alt"]
// Run tests
assertEquals(computePrimeFactors(1), Arrays.asList());
assertEquals(computePrimeFactors(2), Arrays.asList(2));
assertEquals(computePrimeFactors(3), Arrays.asList(3));
assertEquals(computePrimeFactors(4), Arrays.asList(2, 2));


// %% tags=["subslide", "alt"]
// Generalization/refactoring 2
public List<Integer> computePrimeFactors(int n) {
    List<Integer> result = new ArrayList<>();
    if (n % 2 == 0) {
        result.add(2);
        if (n == 4) {
            result.add(2);
        }
    } if (n == 3) {
        result.add(3);
    }
    return result;
}


// %% tags=["alt"]
// Run tests
assertEquals(computePrimeFactors(1), Arrays.asList());
assertEquals(computePrimeFactors(2), Arrays.asList(2));
assertEquals(computePrimeFactors(3), Arrays.asList(3));
assertEquals(computePrimeFactors(4), Arrays.asList(2, 2));


// %% tags=["subslide", "alt"]
// Generalization/refactoring 2
public List<Integer> computePrimeFactors(int n) {
    List<Integer> result = new ArrayList<>();
    if (n % 2 == 0) {
        result.add(2);
        n /= 2;
        if (n % 2 == 0) {
            result.add(2);
        }
    } if (n == 3) {
        result.add(3);
    }
    return result;
}


// %% tags=["alt"]
// Run tests
assertEquals(computePrimeFactors(1), Arrays.asList());
assertEquals(computePrimeFactors(2), Arrays.asList(2));
assertEquals(computePrimeFactors(3), Arrays.asList(3));
assertEquals(computePrimeFactors(4), Arrays.asList(2, 2));


// %% tags=["subslide", "alt"]
// Generalization/refactoring 3
public List<Integer> computePrimeFactors(int n) {
    List<Integer> result = new ArrayList<>();
    while (n % 2 == 0) {
        result.add(2);
        n /= 2;
    }
    while (n % 3 == 0) {
        result.add(3);
        n /= 3;
    }
    return result;
}


// %% tags=["alt"]
// Run tests
assertEquals(computePrimeFactors(1), Arrays.asList());
assertEquals(computePrimeFactors(2), Arrays.asList(2));
assertEquals(computePrimeFactors(3), Arrays.asList(3));
assertEquals(computePrimeFactors(4), Arrays.asList(2, 2));


// %% tags=["subslide", "alt"]
public List<Integer> computePrimeFactors(int n) {
    List<Integer> result = new ArrayList<>();
    while (n % 2 == 0) {
        result.add(2);
        n /= 2;
    }
    while (n % 3 == 0) {
        result.add(3);
        n /= 3;
    }
    while (n % 5 == 0) {
        result.add(5);
        n /= 5;
    }
    return result;
}


// %% tags=["alt"]
// Run tests
assertEquals(computePrimeFactors(1), Arrays.asList());
assertEquals(computePrimeFactors(2), Arrays.asList(2));
assertEquals(computePrimeFactors(3), Arrays.asList(3));
assertEquals(computePrimeFactors(4), Arrays.asList(2, 2));
assertEquals(computePrimeFactors(5), Arrays.asList(5));


// %% tags=["subslide"]
// Final Cleanup
public List<Integer> computePrimeFactors(int n) {
    List<Integer> result = new ArrayList<>();
    for (int factor = 2; factor <= n; factor++) {
        while (n % factor == 0) {
            result.add(factor);
            n /= factor;
        }
    }
    return result;
}


// %%
// Run tests
assertEquals(computePrimeFactors(1), Arrays.asList());
assertEquals(computePrimeFactors(2), Arrays.asList(2));
assertEquals(computePrimeFactors(3), Arrays.asList(3));
assertEquals(computePrimeFactors(4), Arrays.asList(2, 2));
assertEquals(computePrimeFactors(5), Arrays.asList(5));


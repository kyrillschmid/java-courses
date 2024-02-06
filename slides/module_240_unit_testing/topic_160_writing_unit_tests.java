// j2 from 'macros.j2' import header
// {{ header("Schreiben von guten Unit-Tests", "Writing good Unit Tests") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Welche Form hat ein Unit Test?
// - Arrange
// - Act
// - Assert

// %% [markdown] lang="en" tags=["subslide"]
//
// ## What is the form of a unit test?
// - Arrange
// - Act
// - Assert

// %% tags=["subslide"]
%maven org.junit.jupiter:junit-jupiter-api:5.8.2
import static org.junit.jupiter.api.Assertions.assertEquals;

// %% tags=["subslide"]
public void testTheAddAllMethodOfArrayList() {
    List<Integer> x = new ArrayList<>(Arrays.asList(1, 2, 3)); // arrange
    List<Integer> y = Arrays.asList(10, 20);

    x.addAll(y); // act

    assertEquals(x, Arrays.asList(1, 2, 3, 10, 20)); // assert
}

// %% tags=["subslide"]
testTheAddAllMethodOfArrayList();

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Wie finden wir gute Tests?

// %% [markdown] lang="en" tags=["subslide"]
//
// ## How do we find good tests?


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Versuch: Erschöpfendes Testen
//
// - Wir schreiben erschöpfende Tests, d.h. Tests, die alle möglichen Eingaben eines
//   Programms abdecken

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Try: Exhaustive testing
//
// - We write exhaustive tests, i.e. tests that cover all possible inputs of a program


// %% [markdown] lang="de" tags=["subslide"]
//
// - Erschöpfendes Testen ist nicht möglich
// - Beispiel Passworteingabe:
//   - Angenommen, Passwörter mit maximal 20 Zeichen sind zulässig,
//     80 Eingabezeichen sind erlaubt (große und kleine Buchstaben, Sonderzeichen)
//   - Das ergibt $80^{20}$ = 115.292.150.460.684.697.600.000.000.000.000.000.000
//     mögliche Eingaben
//   - Bei 10ns für einen Test würde man ca. $10^{24}$ Jahre brauchen, um alle Eingaben
//     zu testen
//   - Das Universum ist ungefähr $1.4 \times 10^{10}$ Jahre alt

// %% [markdown] lang="en" tags=["subslide"]
//
// - Exhaustive testing is not possible
// - Example: password input:
//   - Suppose passwords with a maximum of 20 characters are allowed,
//     80 input characters are allowed (upper and lower case letters, special characters)
//   - This results in $80^{20}$ = 115,292,150,460,684,697,600,000,000,000,000,000,000
//     possible inputs
//   - At 10ns for a test, it would take about $10^{24}$ years to test all inputs
//   - The universe is about $1.4 \times 10^{10}$ years old

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Effektivität und Effizienz von Tests
//
// - Unit-Tests sollen effektiv und effizient sein
//   - Effektiv: Die Tests sollen so viele Fehler wie möglich finden
//   - Effizient: Wir wollen die größte Anzahl an Fehlern mit der geringsten Anzahl
//     an möglichst einfachen Tests finden
// - Effizienz ist wichtig, da Tests selbst Code sind, der gewartet werden muss und
//   Fehler enthalten kann

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Effectiveness and efficiency of tests
//
// - Unit tests should be effective and efficient
//   - Effective: The tests should find as many bugs as possible
//   - Efficient: We want to find the largest number of bugs with the fewest number of
//     tests that are as simple as possible
// - Efficiency is important because Tests themselves are code that requires
//   maintenance and may contain bugs

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Strategien zum Finden von (effektiven und effizienten) Tests
//
// - Analyse von Randwerten (Boundary Value Analysis, BVA)
// - Partitionierung
// - Zustandsbasiertes Testen
// - Kontrollflussbasiertes Testen
// - Richtlinien
// - Kenntnis häufiger Fehler in Software
// - (Kenntnis häufiger Probleme von Tests (Test Smells))


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Strategies for finding (effective and efficient) tests
//
// - Boundary value analysis (BVA)
// - Partitioning
// - State-based testing
// - Control flow-based testing
// - Guidelines
// - Knowledge of common errors
// - (Knowledge of common problems in tests (test smells))

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Faustregeln für Unit-Tests
//
// - Teste Funktionalität, nicht Implementierung
// - Verwende Test-Doubles dann (aber auch nur dann), wenn eine Abhängigkeit
//   "eine Rakete abfeuert"
// - Bevorzuge Tests von Werten gegenüber Tests von Zuständen
// - Bevorzuge Tests von Zuständen gegenüber Tests von Verhalten
// - Teste kleine Einheiten
// - (Diese Regeln setzen voraus, dass der Code solche Tests erlaubt)

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Rules of thumb for unit testing
//
// - Test functionality, not implementation
// - Use test doubles if (but only if) a dependency "launches a missile"
// - Prefer tests of values to tests of states
// - Prefer tests of states to tests of behavior
// - Test small units
// - (These rules assume that the code allows such tests)

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Teste Funktionalität, nicht Implementierung
//
// Abstrahiere so weit wie möglich von Implementierungsdetails
// - Auch auf Unit-Test Ebene
// - Oft testen sich verschiedene Methoden gegenseitig
// - Dies erfordert manchmal die Einführung von zusätzlichen Methoden
//     - Diese Methoden sind oft nicht nur für Tests sinnvoll
//     - Oft "abstrakter Zustand" von Objekten
//     - **Nicht:** konkreten Zustand öffentlich machen

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Test functionality, not implementation
//
// Abstract implementation details as much as possible
// - Also at unit test level
// - Often different methods test each other
//     - This sometimes requires the introduction of additional methods
//     - These methods are often not only useful for testing
//     - Often "abstract state" of objects
//     - **Do not** simply make the concrete state public.

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Teste Funktionalität, nicht Implementierung
//
// **Warum?**
// - Funktionalität ist leichter zu verstehen
// - Funktionalität ist stabiler als Implementierung
// - Funktionalität entspricht eher dem Kundennutzen

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Test functionality, not implementation
//
// **Why?**
// - Functionality is easier to understand
// - Functionality is more stable than implementation
// - Functionality is closer to customer benefit

// %% tags=["subslide", "keep"]
public class Stack {
    public List<Object> items;

    public Stack() {
        this.items = new ArrayList<>();
    }

    public void push(Object newItem) {
        items.add(newItem);
    }

    public Object pop() {
        if (items.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }
}


// %% tags=["keep"]
// arange
Stack myStack = new Stack();

// %% tags=["keep"]
// act
myStack.push(1);

// %% tags=["keep"]
// assert
assertEquals(myStack.items, Arrays.asList(1)); // Whats the problem here?


// %% tags=["subslide", "keep"]
public class Stack {
    private List<Object> items;

    public Stack() {
        this.items = new ArrayList<>();
    }

    public int size() {
        return items.size();
    }

    public void push(Object newItem) {
        items.add(newItem);
    }

    public Object pop() {
        if (items.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }
}


// %% tags=["keep"]
Stack myStack = new Stack();
myStack.push(5)

// %% tags=["keep"]
assertEquals(myStack.size(), 1);
assertEquals(myStack.pop(), 5);


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Test Doubles
//
// - Test Doubles: Stubs, Fakes, Spies, Mocks
// - Ersetzen eine Abhängigkeit im System durch eine vereinfachte Version
//   - z.B. Ersetzen einer Datenbankabfrage durch einen fixen Wert
// - Test Doubles sind wichtig zum Vereinfachen von Tests
// - Aber: zu viele oder komplexe Test Doubles machen Tests unübersichtlich
//   - Was wird von einem Test eigentlich getestet?


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Test Doubles
// - Test Doubles: Stubs, Fakes, Spies, Mocks
// - Replace a dependency in the system with a simplified version
//   - e.g. replace a database query with a fixed value
// - Test Doubles are important for simplifying tests
// - But: too many or complex test doubles make tests confusing
//   - What is actually being tested by a test?

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Typischer Einsatz von Test Doubles
//
// - Zugriff auf Datenbank, Dateisystem
// - Zeit, Zufallswerte
// - Nichtdeterminismus
// - Verborgener Zustand (`AdderSpy`)

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Typical use of test doubles:
//
// - database access, file system access
// - time, random values
// - non-determinism
// - hidden state (`AdderSpy`)

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Werte > Zustand > Verhalten
//
// - Verständlicher
// - Leichter zu testen
// - Oft stabiler gegenüber Refactorings
//
// Ausnahme: Testen von Protokollen


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Values > State > Behavior
//
// - More understandable
// - Easier to test
// - Often more stable compared to refactorings
//
// Exception: testing protocols

// %% [markdown] lang="de" tags=["subslide"]
//
// ##// Wert

// %% [markdown] lang="en" tags=["subslide"]
//
// ##// Value

// %%
public int add(int x, int y) {
    return x + y;
}


// %%
assertEquals(add(2, 3), 5);


// %% [markdown] lang="de" tags=["subslide"]
//
// ##// Zustand

// %% [markdown] lang="en" tags=["subslide"]
//
// ##// State

// %%
public class Adder {
    public int result;

    public Adder(int x, int y) {
        this.result = x + y;
    }
}


// %%
Adder myAdder = new Adder(2, 3);
assertEquals(myAdder.result, 5);


// %% [markdown] lang="de" tags=["subslide"]
//
// ##// Verhalten

// %% [markdown] lang="en" tags=["subslide"]
//
// ##// Behavior

// %%
import java.util.function.BiFunction;
public static String callAdd(BiFunction<Integer, Integer, Integer> add) {
        int hiddenResult = add.apply(2, 3);
        // Presumably do something with hiddenResult...
        return "How do you test that add was called?";
}


// %% tags=["subslide"]
public class AdderSpy implements BiFunction<Integer, Integer, Integer> {
    private boolean wasCalled;
    private int result;

    public AdderSpy() {
        this.wasCalled = false;
        this.result = 0;
    }

    @Override
    public Integer apply(Integer x, Integer y) {
        this.wasCalled = true;
        this.result = x + y;
        return this.result;
    }

    public boolean wasCalled() {
        return wasCalled;
    }

    public int getResult() {
        return result;
    }
}


// %%
AdderSpy spy = new AdderSpy();
assertEquals(!spy.wasCalled(), true);

// %%
assertEquals(spy.apply(2, 3), 5);

// %%
assertEquals(spy.wasCalled(), true);
assertEquals(spy.getResult(), 5);

// %% tags=["subslide"]
AdderSpy adderSpy = new AdderSpy();
callAdd(adderSpy);
assertEquals(adderSpy.wasCalled(), true);
assertEquals(adderSpy.getResult(), 5);

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Teste kleine Einheiten (bei Unit-Tests)
// - Test von kleinen Einheiten
//   - spezifizieren das Verhalten der getesteten Einheit besser
//   - erleichtern die Lokalisierung von Fehlern
//   - sind leichter zu pflegen
// - Tests größerer Einheiten oder des Gesamtsystems sind wichtig als
//   - Integrationstests
//   - Systemtests
//   - Akzeptanztests

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Test small units (in unit tests)
// - Tests of small units
//   - better specify the behavior of the tested unit
//   - make it easier to locate errors
//   - are easier to maintain
// - Tests of larger units or the whole system are important:
//   - Integration tests
//   - System tests
//   - Acceptance tests

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Wie schreibt man testbaren Code?
//
// - Keine globalen oder statischen Daten
// - Techniken aus der funktionalen Programmierung (Iterables, Higher-order Funktionen,
//   etc.)
// - Funktionale Datenstrukturen (Immutability)
// - Gutes objektorientiertes Design
//   - Hohe Kohärenz
//   - Geringe Kopplung, Management von Abhängigkeiten
// - Etc.
//
// Hilfsmittel: Test-Driven Development


// %% [markdown] lang="en" tags=["subslide"]
//
// ## How do you write testable code?
// - No global or static data
// - Techniques from functional programming (iterables, higher-order functions, etc.)
// - Functional data structures (immutability)
// - Good object-oriented design
//   - High coherence
//   - Low coupling, management of dependencies
// - Etc.
//
// Tool: Test-Driven Development


// %% [markdown] lang="de" tags=["slide"]
//
// ## Mini-Workshop: Tests für die Einkaufslisten-Implementierung
//
// Fügen Sie zur Implementierung einer Einkaufsliste in `examples/ShoppingListPytestSK`
// geeignete Unit-Tests hinzu.
//
// (Falls Sie die Einkaufsliste in einem vorherigen Workshop bereits implementiert haben,
// ist es besser, Sie verwenden stattdessen Ihre eigene Implementierung.)

// %% [markdown] lang="en" tags=["slide"]
//
// ## Mini-workshop:
//
// Add appropriate unit tests to the shopping-list implementation in
// `examples/ShoppingListPytestSK`.
//
// (If you have already implemented the shopping list in a previous workshop, it is
// better to use your own implementation instead).

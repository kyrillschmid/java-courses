// j2 from 'macros.j2' import header
// {{ header("Strategien zum Finden von Tests", "Strategies for Finding Tests") }}


// %% [markdown] lang="de" tags=["slide"]
//
// ## Strategien zum Finden von Tests
//
// - Strategien zum Finden von Tests
// - Analyse von Randwerten (Boundary Value Analysis, BVA)
// - Partitionierung
// - Zustandsbasiertes Testen
// - Kontrollflussbasiertes Testen
// - Richtlinien
// - Kenntnis häufiger Fehler
// - (Kenntnis häufiger Probleme von Tests (Test Smells))


// %% [markdown] lang="en" tags=["slide"]
//
// // Strategies for Finding Tests
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
// ## Boundary Value Analysis
//
// - Viele Fehler treten am "Rand" des Definitionsbereichs von Funktionen
//   oder Prozeduren auf
// - Eine gute Strategie zum effizienten Testen ist es daher, derartige
//   Randwerte zu betrachten
//   - Der/die letzten gültigen Werte
//   - Werte, die gerade außerhalb des Definitionsbereichs liegen
// - Ist z.B. eine Funktion für ganzzahlige Werte zwischen 0 und 5
//   definiert, so kann sie mit Eingaben -1, 0, 5, 6 getestet werden


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Boundary Value Analysis
//
// - Many errors occur at the "edge" of the definition range of functions
//   or procedures
// - A good strategy for efficient testing is therefore to consider such edge values
//   - The last valid value(s)
//   - Values that are just outside the definition range
// - For example, if a function is defined for integer values between
//   0 and 5, it can be tested with inputs -1, 0, 5, 6

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Boundary Value Analysis
//
// ##// Vorteil:
//
// - Man konzentriert sich auf empirisch häufige Fehlerquellen
//
// ##// Schwierigkeiten:
//
// - Bei vielen Bereichen ist nicht klar, was "Randwerte" sind
//   - (Allerdings lassen sich oft alternative Kriterien finden, z.B.
//     Länge von Collection-Argumenten)
// - Werte außerhalb des Definitionsbereichs können manchmal zu undefiniertem
//   Verhalten führen
// - Bei Funktionen mit vielen Parametern gibt es eine kombinatorische
//   Explosion von Randwerten

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Boundary Value Analysis

// ##// Advantage:
// - One concentrates on empirically frequent sources of error
//
// ##// Difficulties:
//
// - For many domains, it is not clear what "boundary values" are
//   - (However, alternative criteria can often be found, e.g., length of collection
//     arguments)
// - Values outside the definition domain can sometimes lead to undefined behavior
// - For functions with many parameters, there is a combinatorial explosion of boundary
//   values.

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Merkregel für (erweiterte) BVA: CORRECT
//
// - **Conformance:** Entspricht der Wert einem erwarteten Format?
// - **Ordering:** Sind die möglichen Werte geordnet oder ungeordnet?
// - **Range:** Hat der Wert einen minimalen und/oder maximalen Wert?
// - **Reference:** Hat der Code externe Referenzen, die nicht unter seiner Kontrolle
//   sind?
// - **Exist:** Existiert der Wert (ist er nicht null, in einer vorgegebenen Menge
//   enthalten, ...)
// - **Cardinality:** Sind genug Werte vorhanden? Sind zu viele Werte vorhanden?
// - **Time:** Sind die Werte zum benötigten Zeitpunkt verfügbar?
//   In der erwarteten Reihenfolge?

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Rule for (extended) BVA: CORRECT
//
// - **Conformance:** Does the value correspond to an expected format?
// - **Ordering:** Are the possible values ordered or unordered?
// - **Range:** Does the value have a minimum and/or maximum value?
// - **Reference:** Does the code have external references that are not under its
//   control?
// - **Exist:** Does the value exist (is it non-null, contained in a given set, ...)
// - **Cardinality:** Are there enough values? Are there too many values?
// - **Time:** Are the values available at the required time? In the expected order?

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Partitionierung
// - Argumente von Funktionen, Ein/Ausgabe des Programms und Zustände
//   von Klassen können oft in Äquivalenzklassen unterteilt werden, sodass…
//   - Das Verhalten für Elemente aus der gleichen Äquivalenzklasse ähnlich
//     ist (z.B. den gleichen Kontrollflusspfad nimmt)
//   - Elemente aus unterschiedlichen Klassen verschiedenes Verhalten zeigen
//   - Beispiel: Die Argumente der sqrt-Funktion können unterteilt werden in
//       - Positive Zahlen und 0
//       - Negative Zahlen
//   - Eine feinere Unterteilung wäre zusätzlich in Quadratzahlen und Nicht-Quadratzahlen
// - Eine derartige Äquivalenzklasse heißt Partition (oder Domäne)


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Partitioning
// - Arguments of functions, input/output of the program and states of classes
//   can often be partitioned into equivalence classes so that...
//   - The behavior for elements from the same equivalence class is similar
//     (e.g. takes the same control flow path)
//   - Elements from different classes show different behavior
//   - Example: The arguments of the sqrt function can be subdivided into
//       - Positive numbers and 0
//       - Negative numbers
//   - A finer subdivision would be additionally into square numbers and
//     non-quadrat numbers
// - Such an equivalence class is called partition (or domain)

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Partitionierung
//
// Finde Partitionen für das getestete Element und teste die folgenden Elemente:
//
// - Einen Wert aus der "Mitte" der Partition
// - Einen Wert auf oder nahe jeder Partitionsgrenze
//
// Häufig findet man Partitionen durch BVA.
//
// Beispiel: Um die Quadratwurzelfunktion zu testen, schreibe Tests für:
// - `sqrt(0.0)`
// - `sqrt(2.0)`
// - `sqrt(-2.0)`

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Partitioning
//
// Find partitions for the tested element and test the following elements:
//
// - A value from the "center" of the partition
// - A value on or near each partition boundary
//
// Often partitions are found by BVA.
//
// Example: To test the square root function, write tests for:
//
// - `sqrt(0.0)`
// - `sqrt(2.0)`
// - `sqrt(-2.0)`

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Zustandsbasiertes Testen
//
// Kann man das Verhalten eines Objekts durch ein Zustandsdiagramm beschreiben, so kann
// man sich beim Testen an den Zuständen und Transitionen orientieren
//
// - Ein zustandsbasierter Test wird durch eine Folge von Events beschrieben,
//   die die Zustandsmaschine steuern
// - Die erwarteten Ergebnisse sind
//   - die Zustände (falls beobachtbar) und
//   - die Aktivitäten bzw. Ausgaben, die durch die Eingabe-Events verursacht werden
// - Es gibt verschiedene Methoden, um fehlerhafte Aktivitäten bzw. Ausgaben und
//   falsche Zustandsübergänge zu finden (z.B. Transition Tour, Distinguishing Sequence)

// %% [markdown] lang="en" tags=["subslide"]
//
// ## State-based testing
//
// If the behavior of an object can be described by a state diagram, testing can be
// guided by the states and transitions
// - A state-based test is described by a sequence of events that control
//   the state machine
// - The expected results are
//   - the states (if observable) and
//   - the activities or outputs caused by the input events
// - There are different methods to find faulty activities or outputs
//   and incorrect state transitions
//   (e.g. Transition Tour, Distinguishing Sequence).

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Kontrollflussbasiertes Testen
//
// - Der Kontrollfluss-Graph (CFG) eines Programms ist ein gerichteter
//   Graph, der die Kontrollstruktur eines Programms repräsentiert
//   - Knoten sind Basic Blocks (lineare Folgen von Anweisungen)
//   - Kanten repräsentieren mögliche Programmabläufe
// - Fallunterscheidungen: Knoten mit mehreren Nachfolgern
// - Schleifen im Programm führen zu Schleifen im CFG


// %% [markdown] lang="en" tags=["subslide"]
//
// Control Flow Based Testing
// - The Control Flow Graph (CFG) of a program is a directed graph representing the
//   control structure of a program
//   - Nodes are Basic Blocks (linear sequences of statements)
//   - Edges represent possible program sequences
// - Case distinctions: Nodes with multiple successors
// - Loops in the program lead to loops in the CFG.


// %% tags=["subslide", "keep"]
public void controlFlow(int x) {
    if (x == 0) {
        System.out.println("x == 0");
        System.out.println("This is interesting.");
    } else {
        System.out.println("x !== 0");
        System.out.println("The boring case.");
    }
    System.out.println("Done.");
}


// %% [markdown] lang="de" tags=["subslide"]
//
// Mit dem CFG kann man verschiedene Maße für die "Testabdeckung" des Programms
// definieren:
//
// - Anweisungsüberdeckung (Statement Coverage): Der Prozentsatz and Programmanweisungen
//   (Knoten im CFG), der durch die Tests abgedeckt wird. Eine Test-Suite hat 100%
//   Anweisungsüberdeckung, wenn jede Programmanweisung durch mindestens einen Test
//   abgedeckt wird
// - Entscheidungsüberdeckung (Branch Coverage, Decision Coverage): Der Prozentsatz
//   an Kanten im CFG, der von Tests abgedeckt wird. Eine Test-Suite hat 100%
//   Entscheidungsüberdeckung, wenn jede mögliche Verzweigung im Programm von einem
//   Test abgedeckt wird, d.h., wenn jede Kante im CFG von einem Test durchlaufen wird
// - 100% Entscheidungsüberdeckung impliziert 100% Anweisungsüberdeckung,
//   aber nicht umgekehrt

// %% [markdown] lang="en" tags=["subslide"]
//
// The CFG allows you to define various measures of program "test coverage":
// - Statement Coverage: The percentage of program statements (nodes in the
//   CFG) that are covered by tests. A test suite has 100% statement
//   coverage if every program statement is covered by at least one test
// - Branch Coverage, Decision Coverage: The percentage of edges in the CFG
//   that are covered by tests. A test suite has 100% decision coverage if
//   every possible branch in the program is covered by a test, i.e., if every
//   edge in the CFG is traversed by a test
// - 100% decision coverage implies 100% instruction coverage, but not vice versa


// %% tags=["subslide", "keep"]
public void controlFlow2(int x) {
    if (x == 0) {
        System.out.println("x == 0");
        System.out.println("This is interesting.");
    }
    System.out.println("Done.");
}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Richtlinien
//
// - Repräsentieren projekt- oder domänenspezifisches Wissen
// - Können erweitert werden, wenn Defekte gefunden werden, die nicht von
//   den bisherigen Tests erfasst wurden

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Guidelines
// - Represent project or domain specific knowledge
// - Can be expanded if defects are found that were not captured by
//   previous testing

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beispiele für Richtlinien
//
// - Schreibe Unit-Tests, die jede mögliche Fehlermeldung triggern
// - Teste jede Funktion, die einen Buffer verwendet mit einer
//   Eingabe, die größer als die maximale Buffergröße ist
// - Teste gecachte Funktionen mehrmals mit der gleichen Eingabe
//   und stelle sicher, dass sich die Ausgabe nicht ändert
// - Teste jede Funktion mit Eingaben, die außerhalb des gültigen
//   Definitionsbereichs liegen
// - Teste jede Funktion, die eine Collection als Eingabeparameter
//   hat, mit der leeren Collection und mit einelementigen Collections
// - Verwende Collections verschiedener Größen in Tests
// - Stelle sicher, dass auf Elemente von Anfang, Mitte und Ende
//   einer Collection zugegriffen wird (falls möglich)


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Examples of guidelines
// - Write unit tests that trigger every possible error message
// - Test every function that uses a buffer with an input that
//   is larger than the maximum buffer size
// - Test cached functions multiple times with the same input and
//   make sure that the output does not change
// - Test every function with inputs, test any function that has a
//   collection as input parameter with the empty collection and with
//   one-element collections
// - Use collections of different sizes in tests
// - Make sure that elements from the beginning, middle and end of a
//   collection are accessed (if possible)

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Einige "Häufige Fehler”
//
// - Falsche Boole’sche Bedingungen
//   - Betrachte Partitionen, die durch Bedingungen generiert werden
//   - Betrachte die Randwerte von Bedingungen
// - Nichtterminierende Berechnungen
//   - Vergessene/unvollständige Basisfälle in rekursiven Funktionen
//     (z.B. Test auf = 0 statt <= 0)
//   - Unvorhergesehenes Inkrement/Dekrement des Zählers in for- oder while-Schleifen
// - Falsche Vorbedingungen für Code
//   - Schreibe Assertions im Code, die Vorbedingungen überprüfen
//   - Schreibe Tests, die diese Assertions triggern
// - Falsche Invarianten
//   - Schreibe Funktionen, die Invarianten testen, sofern diese auf nicht-zugreifbarem
//     Zustand beruhen
//   - Schreibe Tests, die diese Funktionen verwenden


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Some "Common Errors"
// - Incorrect Boolean conditions
//   - Consider partitions generated by conditions
//   - Consider boundary values of conditions
// - Non-terminating computations
//   - Forgotten/incomplete base cases in recursive functions (ex. Test for = 0 instead
//     of <= 0)
//   - Unforeseen increment/decrement of counter in for or while loops
// - Incorrect preconditions for code
//   - Write assertions in code that check preconditions
//   - Write tests that trigger these assertions
// - Incorrect invariants
//   - Write functions that test invariants if they rely on non-accessible state
//   - Write tests that use these functions.

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Einige "Häufige Fehler”
//
// - Nullpointer, nicht-initialisierter Speicher
//   - Im Allgemeinen schwer durch Tests zu finden; verwende Tools wie Valgrind
//     und schalte Compilerwarnungen ein, falls verfügbar
//   - Versuche Partitionen zu finden, die Werte uninitialisiert lassen
// - Ungewöhnliche Bereiche
//   - Leere oder einelementige Collections
//   - Sehr kleine Werte (z.B. 1.0e-300)
//   - Sehr große Werte oder Collections
// - Off-by-One, Zaunpfahl-Fehler (Fencepost Errors)
//   - Teste, dass Schleifen nicht zu oft oder zu selten durchlaufen werden
//   - Verwende for-in (falls möglich)


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Some "Common Errors"
// - Null pointers, uninitialized memory
//   - Generally hard to find by testing; use tools like Valgrind and
//     turn on compiler warnings if available
//   - Try to find partitions that leave values uninitialized
// - Unusual ranges
//   - Empty or one-element collections
//   - Very small values (e.g. 1.0e-300)
//   - Very large values or collections.e.g. 1.0e-300)
// - Off-by-one, fencepost errors
//   - Test that loops are not traversed too often or too rarely
//   - Use for-in (if possible)

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Einige "Häufige Fehler”
//
// - Falsche Operatorpräzedenz
//   - Überprüfe, dass Formeln auch die erwartete Bedeutung haben
//   - Versuche Partitionen zu finden, die das sicherstellen
// - Ungeeignete Algorithmen
//   - Schlechte Laufzeiteigenschaften
//   - Über-/Unterlauf für bestimmte Eingaben
// - Ungeeignete Repräsentation von Daten
//   - Gleitkommazahlen für Geldbeträge
//   - Darstellung von Werten, die nur aus Ziffern bestehen können
//     (z.B. Bankleitzahlen, Kontonummern, ISBN-Nummern) durch int-Werte
//     (führende Nullen, Länge der Repräsentation)
// - Zu wenige Werte für produktiven Einsatz, z.B. 8-bit User-ID


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Some "Common Errors"
// - Wrong operator precedence
//   - Check that formulas have the expected meaning
//   - Try to find partitions that ensure this
// - Unsuitable algorithms
//   - Bad runtime properties
//   - Over/underflow for certain inputs
// - Unsuitable representation of data
//   - Floating point numbers for monetary amounts
//   - Representation of values that can only consist of digits (e.g. bank codes,
//     account numbers, ISBN-numbers) by int values (leading zeros,
//     length of representation)
// - Too few values for productive use, e.g. 8-bit User-ID

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Einige "Häufige Fehler” bei numerischen Berechnungen
//
// - Verwendung inexakter Repräsentationen, wo eine exakte Repräsentation nötig wäre
//   - z.B. Gleitkommazahlen für Brüche
// - Verwendung von Gleitkommazahlen mit zu geringer Präzision
// - Verwendung numerisch instabiler Algorithmen
// - Durchführung numerischer Berechnungen ohne Rücksicht auf Ordnung der Operationen
//   - Kann numerischen Fehler drastisch vergrößern

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Some "Common Errors" in Numerical Calculations
// - Using inexact representations where an exact representation would be necessary
//   - e.g., floating point numbers for fractions
// - Using floating point numbers with too little precision
// - Using numerically unstable algorithms
// - Performing numerical calculations without regard to order of operations
//   - Can drastically increase numerical error.

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Umfang der Unit-Tests
//
// Unit-Tests sollen die getestete Einheit möglichst komplett abdecken
//
// - Funktionen/Methoden
//   - Aufruf mit Parametern aus jeder (white-Box) Input-Partition
// - Klassen/Objekte
//   - Test aller relevanten Operationen
//   - Mindestens ein Test für jede Zustandspartition
//   - Tests für alle möglichen Zustandstransitionen
//   - Tests, die sicherstellen, dass geerbte Attribute und Operationen wie gewünscht
//     funktionieren


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Scope of unit tests
//
// Unit tests should cover the tested unit as completely as possible
// - Functions/methods
//   - Call with parameters from each (white-box) input partition
// - Classes/objects
//   - Test of all relevant operations
//   - At least one test for each state partition
//   - Tests for all possible state transitions
//   - Tests to ensure that inherited attributes and operations work as desired

// %% [markdown] lang="de" tags=["subslide"]
//
// - Beispiel: Wächter in einem Spiel
// - Zustände:
//   - Patrolling
//   - Searching
//   - Fighting
//   - Dead
// - Zustandsübergänge
//   - Patrolling ↔ Searching
//   - Patrolling ↔ Fighting ("→" nur, wenn er angegriffen wird)
//   - Searching → Fighting
//   - (Any) → Dead

// %% [markdown] lang="en" tags=["subslide"]
//
// - Example: Guard in a game
// - States:
//   - Patrolling
//   - Searching
//   - Fighting
//   - Dead
// - State transitions
//   - Patrolling ↔ Searching
//   - Patrolling ↔ Fighting ("→" only when attacked)
//   - Searching → Fighting
//   - (Any) → Dead

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Qualitätskriterien für Unit Tests: FIRST
// - **Fast:**
//   - Jeder Test benötigt höchstens einige Millisekunden Laufzeit
// - **Isolated:**
//   - Jeder Test testet eine geringe Menge an Code und ist vom Rest des Systems isoliert
//   - Tests sind voneinander isoliert, Reihenfolge der Ausführung spielt keine Rolle
// - **Repeatable:**
//   - Das Ergebnis eines Tests sollte immer identisch sein
//   - Häufige Probleme: Zeit, Datum, Threads, Random
// - **Self-Validating:**
//   - Es sollte keine externe Verifikation nötig sein (z.B. manuelle
//     Inspektion der Testausgabe)
// - **Timely:**
//   - Unit Tests sollten zusammen mit dem Code, den sie testen, erstellt werden


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Quality criteria for unit tests: FIRST
// - **Fast:**
//   - Each test requires at most a few milliseconds of runtime
// - **Isolated:**
//   - Each test tests a small amount of code and is isolated from the rest of the system
//   - Tests are isolated from each other, order of execution does not matter
// - **Repeatable:**
// -  The result of a test should always be identical
// -  Common issues: Time, Date, Threads, Random
// - **Self-Validating:**
//   - No external verification should be required (e.g., manual inspection of test
//     output)
// - **Timely:**
//   - Unit tests should be created along with the code they test

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Right-BICEP: Was bzw. wie soll getestet werden?
//
// - **Right**: Sind die Ergebnisse/Ausgaben des Programms korrekt?
//   - "Happy-Path Tests"
//   - Validierungstesten
// - **Boundary Conditions:** Werden Randwerte korrekt behandelt?
// - **Inverse Relationships:** Ist es sinnvoll, die inverse Beziehung zu
//   testen? (Beispiel: Quadratwurzel)
// - **Cross-Checking:** Können Ergebnisse durch "Gegenprobe" verifiziert werden?
//   (Beispiel: langsamer aber einfacher Algorithmus)
// - **Forcing Error Conditions:** Können Fehlerbedingungen erzwungen werden?
//   - "Unhappy-Path Tests"
//   – Defekttesten
// - **Performance Characteristics:** Ist die Performance der Implementierung ausreichend?
//   Skaliert die Implementierung?


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Right-BICEP: What or how should be tested?
// - **Right:** Are the results/outputs of the program correct?
//   - "Happy-Path Tests"
//   - Validation Testing
// - **Boundary Conditions:** Are boundary values handled correctly?
// - **Inverse Relationships:** Does it make sense to test the inverse relationship?
//   (Example: square root)
// - **Cross-checking:** Can results be verified by "cross-checking"? (Example: slow but
//   simple algorithm)
// - **Forcing Error Conditions:** Can error conditions be forced?
//   - Unhappy-Path Tests"
//   - Defect Testing
// - **Performance Characteristics:** Is the performance of the implementation
//   sufficient?  Does the implementation scale?

// j2 from 'macros.j2' import header
// {{ header("Typ-Inferenz - var", "Type-Inference - var") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Das Schlüsselwort `var`
// * Java ist eine statisch streng typisierte Sprache
// * Viele andere Sprachen (dynamisch und statisch) typisierte bieten automatische Typinferenz an
// * Mit Java 10 wurde das Schlüsselwort `var` eingeführt, das automatische Typinferenz ermöglicht
//
// Zur Motivation:

// %% [markdown] lang="en" tags=["slide"]
// * Java is a statically strongly typed language.
// * Many other languages (dynamically and statically typed) offer automatic type inference.
// * The new keyword `var` offers developers automatic type inference.
//
// For motivation:

// %% tags=["keep"]
double zahlPi = 3.141592653589793;

// %% tags=["keep"]
Map.Entry<String, List<Integer>> eintrag = Map.entry("eintrag", List.of(1, 2, 3));

// %% [markdown] lang="de" tags=["slide"]
// ## Vorteile der Nutzung der Typinferenz durch den Compiler beim Schreiben von Code
//
// * Der Compiler weiß zu jedem Zeitpunkt den Typ jeder Variable.
// * Somit ist `int` für den Compiler im Beispiel unten eine reduntante Information.
// ```java
// int zahl = 42;
// ```
// * Falls es sich um *echte* reduntante Information handelt, kann mit der Neuerung die Zeile wie folgt geschrieben werden.
// ```java
// var zahl = 42;
// ```
// * Der Compiler weiß, dass `42` eine Ganzzahl ist. Nach Konvention werden Ganzzahl - wenn nicht explizite anders ausgezeichnet - als `Integer` ausgewertet.

// %% [markdown] lang="en" tags=["slide"]
// ## Advantages of using type inference by the compiler when writing code
//
// * The compiler knows the type of each variable at any time.
// * Thus, `int` is redundant information for the compiler in the example below.
// ```java
// int zahl = 42;
// ```
// * If it is *real* redundant information, the line can be written as follows with the new feature.
// ```java
// var zahl = 42;
// ```
// * The compiler knows that `42` is an integer. According to convention, integers are evaluated as `Integer` if not explicitly marked otherwise.

// %%
var zahlPi = 3.141592653589793;

// %%
var eintrag = Map.entry("eintrag", List.of(1, 2, 3));

// %% [markdown] lang="de" tags=["slide"]
// ## Method Chaining
// * Method Chaining ist mit der Stream API beliebt geworden.
//   * Eine weitere beliebte Anwendung von Method Chaining ist das Builder Pattern.
// * Was früher als starker Hinweis auf ein Refactoring galt (zu viele Methodenaufrufe in einer Zeile, "law of demeter"), ist zumindest bei der ubiquitär Stream API guter Ton.
//   * Hier sind die Typen der Zwischenmethodenergebnisse nicht von Interesse.

// %% [markdown] lang="en" tags=["slide"]
// ## Method chaining
// * *method chaining* has become popular with the Stream API.
//   * Another popular application of method chaining is the builder pattern.
// * What used to be a strong hint for refactoring (too many method calls in one line, "law of demeter") is at least good style with the ubiquitous Stream API.
//   * Here the types of the intermediate method results are not of interest.

// %% tags=["keep"]
import java.util.stream.Stream;

// %% 
ArrayList<String> strings = new ArrayList<>();
Stream<String> stream = strings.stream();
Optional<String> any = stream.findAny();

// %%
var strings = new ArrayList<String>();
var stream = strings.stream();
var any = stream.findAny();

// %%
var any = strings.stream().findAny();

// %% tags=["keep"]
final int BLUE = 1;

// %% tags=["keep"]
class Block {
    final int farbe;
    final int gewicht;
    public Block(int farbe, int gewicht) {
        this.farbe = farbe;
        this.gewicht = gewicht;
    }
    int getFarbe() { return farbe; }
    int getGewicht() { return gewicht; }
}

// %% tags=["keep"]
var blocks = List.of(new Block(0, 10), new Block(BLUE, 10), new Block(BLUE, 13));

// %%
var maximalesGewicht = blocks.stream() // List<Block>
        .filter(b -> b.getFarbe() == BLUE) // Stream<Block>
        .mapToInt(Block::getGewicht)      // IntStream
        .max();                          // OptionalInt
"Maximales Gewicht %s ist vom Type %s.".formatted(maximalesGewicht, maximalesGewicht.getClass());

// %% [markdown] tags=["notes"]
// * `Block` hätte auch als record umgesetzt werden können, records kommen allerdings erst später.
// * `List.of` ist auch neu, wird später genauer erklärt.

// %% [markdown] lang="de" tags=["slide"]
// # Einschränkungen bei der Verwendung von `var`
//
// * `var` funktioniert nicht mit `null`-Typen.
// * Wenn Zieltype `void` ist.

// %%
var x = null;

// %%
var x = System.out.println("x");

// %% [markdown] lang="de" tags=["slide"]
// * Wenn kein Zieltyp ableitbar ist
// * Wenn kein Initialisierer vorliegt.

// %% [markdown] lang="en" tags=["slide"]
// # If no target type can be derived
// * If no initializer is available.

// %%
var x;

// %% [markdown] lang="de" tags=["slide"]
// * Wenn kein expliziter Zieltyp genannt ist. 

// %% [markdown] lang="en" tags=["slide"]
// * If no explicit target type is given.

// %%
var f = () -> {};

// %% [markdown] lang="de" tags=["notes"]
// Error: lambda expression () -> {} does not provide enough context for the compiler to infer a target type. 
// Lambda expression is a functional interface type, but Java's type inference system needs more information to determine which functional interface it should use

// %%
var f = (Runnable)( () -> {System.out.println("Hi");} );

// %% [markdown] lang="de" tags=["slide"]
// This line will compile and work because the lambda expression is explicitly cast to the Runnable interface, 
// which is a functional interface with a single method that takes no arguments and returns void (run() method). 
// The cast provides the necessary type information for the compiler to infer the type of f as Runnable

// %% 
f.run();

// %% [markdown] lang="de" tags=["slide"]
// * Wenn kein Zieltyp ableitbar ist.
// * Methodenreferenz braucht expliziten Typ. 

// %% [markdown] lang="en" tags=["slide"]
// * If no target type can be derived.
// * Method reference needs explicit type.

// %%
int hiddenValue() {
    return 42;
}

// %%
var m = this::hiddenValue;

// %% [markdown] lang="de" tags=["notes"]
// Error: In Java, method references are syntactic sugar for lambda expressions

// %%
import java.util.function.IntSupplier;

// %% [markdown] tags=["notes"]
// * do this in an IDE
// Example: intellij-examples/e02_var_method_reference
// - var m = (IntSupplier)(MethodReference::hiddenValue);
// - System.out.println(m.getAsInt()); }

// %% [markdown] lang="de" tags=["slide"]
// * Arrayinitialisierung erforder expliziten Typ.

// %% [markdown] lang="en" tags=["slide"]
// * Array initialization requires explicit type.

// %%
var k = { 1 , 2 };

// %% 
var k = new int[]{ 1 , 2 };


// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop
//
// * **Vorbereitung**
//   1. Lege eine Klasse `final class Zahlen` an.
//   1. In dieser Klasse lege die Methode ```int intZahl() { return 1; }``` an.
//   1. In dieser Klasse lege die Methode ```double zahlMitTyp(){ return 42; }``` an.
//   1. Belege die Variable `zahlen` mit einer Instanz der Klasse `Zahlen`.
//   1. Belege die Variable `zahl1` mit dem Ergebnis von `zahlen.intZahl()`.
//   1. Belege die Variable `zahl2` mit dem Ergebnis von `zahlen.zahlMitTyp()`.
//   1. Gebe die Variablbelegungen aus mit z.B. ```"Zahl1: %s, Zahl2: %s".formatted(zahl1, zahl2)```.
//
// * **Übung**
//   1. Was muss alles geändert werden, wenn der Rückgabetyp von ```zahlMitTyp()``` auf ```double``` oder ```long``` oder ```Integer``` geändert wird?
//   1. Führe diese Änderung durch.
//   1. Diskutiere, was dies für Refactorings bedeutet.
//   1. Beobachte deine IDE, ob die dir Typinformationen bereitstellt.

// %% [markdown] lang="en" tags=["slide"]
// # Mini-Workshop
//
// * **Preparation**
//   1. Create a class `final class Numbers`.
//   1. In this class create the method ```int intNumber() { return 1; }```.
//   1. In this class create the method ```double numberWithType(){ return 42; }```.
//   1. Assign the variable `numbers` with an instance of the class `Numbers`.
//   1. Assign the variable `number1` with the result of `numbers.intNumber()`. 
//   1. Assign the variable `number2` with the result of `numbers.numberWithType()`.
//   1. Print the variable assignments with e.g. ```"Number1: %s, Number2: %s".formatted(number1, number2)```.
//
// * **Exercise**
//   1. What needs to be changed if the return type of ```numberWithType()``` is changed to ```double``` or ```long``` or ```Integer```?
//   1. Make this change.
//   1. Discuss what this means for refactorings.
//   1. Observe your IDE to see if it provides you with type information.

// %% tags=["notes"]
final class Zahlen {
    int intZahl() { return 1; }
    int zahlMitTyp(){ return 42; }
}
var zahlen = new Zahlen();
var zahl1 = zahlen.intZahl();
var zahl2 = zahlen.zahlMitTyp();
"Zahl1: %s, Zahl2: %s".formatted(zahl1, zahl2)
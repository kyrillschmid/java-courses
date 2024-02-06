// j2 from 'macros.j2' import header
// {{ header("JShell", "JShell") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Kontext bevor `jshell`

// %% [markdown] lang="en" tags=["slide"]
// ## Context before `jshell`

// %% [markdown] lang="de" tags=["slide"]
// * Java ist eine objekt-orientierte, statisch typisierte und strikt-typisierte Programmiersprache.
// * Einige Sprachen auf der JVM haben dynamische Konzepte eingebracht.
// * Alle JVM-Sprachen basierten auf dem Konzept
//   1. Code schreiben
//   1. Compilieren mit `javac`
//   1. Ausführen mit `java`
//
// ![Javac process](img/classic-javac-process.png "javac Prozess")

// %% [markdown] lang="en" tags=["slide"]
// * Java is an object-oriented, statically typed and strictly typed programming language.
// * Some languages on the JVM have introduced dynamic concepts.
// * All JVM languages are based on the concept
//   1. Write code.
//   1. Compile with `javac`.
//   1. Run with `java`.
//
// ![Javac process](img/classic-javac-process.png "javac Prozess")

// %% [markdown] lang="de" tags=["notes"]
// * Dies ist eine kleine Verkürzung, im wesentlichen allerdings korrekt.

// %% [markdown] lang="de" tags=["slide"]
// ## Dynamik führt zu `jshell` (JDK 9)
// 
// * Die Unterstützung für dynamische Elemente in der JVM führt zu
//   * einer REPL (Read-Evaluate-Print Loop) (dt. Lesen-Auswerten-Ausgeben Schleife)
// * REPL sind in vielen anderen Programmiersprache mittlerweile üblich
// * Der Java Kernel von `jupyter` nutzt `jshell` intensiv
//
// ![jshell process](img/jshell-process.png "JShell Prozess")

// %% [markdown] lang="en" tags=["slide"]
// ## Dynamics lead to `jshell`
//
// * The support for dynamic elements in the JVM leads to
//   * a REPL (Read-Evaluate-Print Loop)
// * REPLs are now common in many other programming languages.
// * The Java kernel of `jupyter` uses `jshell` intensively.

// %% tags=["keep"]
var ersterWert = "eins";
var zweiterWert = "zwei";
var ergebnis = ersterWert + " " + zweiterWert;
ergebnis

// %% [markdown] lang="de" tags=["slide"]
// ## `jshell` nutzen
//
// * In der jshell muss keine Klasse erstellt werden.
// * Die letzte Expression in einer REPL Zeile wird ausgegeben.

// %% [markdown] lang="en" tags=["slide"]
// ## Using `jshell`
//
// * In the jshell no class has to be created.
// * The last expression in a REPL line is output.

// %% tags=["keep"]
var ersterWert = "eins";
var zweiterWert = "zwei";
var ergebnis = ersterWert + " " + zweiterWert;
System.out.println(ergebnis);
ergebnis

// %% tags=["keep"]
public class Abc {
    public Abc() {
        System.out.println("Hi");
    }
}
new Abc();

// %% [markdown] lang="de" tags=["slide"]
// ## `jshell` Besonderheiten
// * Angabe von Semikolon am Ende einer Zeile ist (teilweise) optional
// * Kein Kümmern um Exceptions notwendig

// %% [markdown] lang="en" tags=["slide"]
// ## `jshell` features
// * Semicolon at the end of a line is (partly) optional.
// * No need to care about exceptions.

// %% [markdown] lang="de" tags=["notes"]
// `jshell> Thread.sleep(500)` -> InterruptedException muss nicht behandelt werden
// Bei Definition von Methoden oder Klassen ist Exception Handling notwendig (und Semikolon)

// %% [markdown] lang="de" tags=["slide"]
// ## Nützliche `jshell` Befehle
// * `/vars` - zeigt alle Variablen
// * `/methods` - zeigt alle Methoden
// * `/!` - zeigt alle vorherigen Befehle

// %% [markdown] lang="en" tags=["slide"]
// ## Useful `jshell` commands
// * `/vars` - shows all variables
// * `/methods` - shows all methods
// * `/!` - shows all previous commands

// %% [markdown] tags=["notes"]
// # `jshell` Konsole
//
// 1. open jshell in console
// 2. enter some expressions
// 3. use cells in jupyter
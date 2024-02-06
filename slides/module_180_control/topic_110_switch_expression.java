// j2 from 'macros.j2' import header
// {{ header("Switch Expression", "Switch Expression") }}

// %% [markdown] lang="de" tags=["slide"]
// Java-Entwickler kennen seit langem die `switch` Anweisung
// * Ermöglicht, verschiedene Codeblöcke auszuführen, je nach Wert einer Variablen
// * Die `switch` Anweisung wird oft verwendet, um eine Sequenz von `if-else` Anweisungen zu ersetzen

// %% tags = ["keep"]
import java.time.DayOfWeek;

// %%  tags=["keep"]
DayOfWeek day = DayOfWeek.MONDAY;

// %% tags=["slide"]
int numberOfLetters;

// %%  tags=["keep"]
switch (day) {
    case MONDAY:
        numberOfLetters = 6;
        break;
    case TUESDAY:
        numberOfLetters = 7;
        break;
    case WEDNESDAY:
        numberOfLetters = 9;
        break;
    case THURSDAY:
        numberOfLetters = 8;
        break;
    case FRIDAY:
        numberOfLetters = 6;
        break;
    case SATURDAY:
        numberOfLetters = 8;
        break;
    case SUNDAY:
        numberOfLetters = 6;
        break;
    default:
        throw new IllegalStateException("Unexpected value: " + day);
}

// %% 
numberOfLetters

// %% [markdown] lang="de" tags=["slide"]
// Nachteile von `switch`:
// - Lange Schreibweise
// - Es ist fehleranfällig (Vergessen der `break` Anweisung)
// - `default` ist obligatorisch (Variable wurde möglicherweise nicht initialisiert)

// %% [markdown] lang="de" tags=["slide"]
// ## Switch Expressions
// Java 12 führte eine neue Syntax für `switch` ein:

// %%
numberOfLetters = switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY                -> 7;
    case WEDNESDAY, SATURDAY    -> 9;
    case THURSDAY               -> 8;
};

// %% 
numberOfLetters

// %% [markdown] lang="de" tags=["slide"]
// Die neue Syntax hat einige Vorteile:
// - Wir können mehrere Fälle in derselben Zeile definieren -> kompaktere Schreibweise
// - Wir müssen die `break` Anweisung nicht verwenden -> weniger fehleranfällig
// - Switch kann einen Wert zurückgeben, daher ist es nicht erforderlich, eine Variable außerhalb der switch-Anweisung zu deklarieren

// %% [markdown] lang="de" tags=["slide"]
// ## `null`
// Wenn ein Null an den switch-Ausdruck übergeben wird, wird eine `NullPointerException` ausgelöst
// * Dies wird in Java 17 als Vorschau-Funktion behandelt

// %%
DayOfWeek day1 = null;

// %% tags = ["keep"]
int numberOfLetters1 = switch (day1) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY                -> 7;
    case WEDNESDAY, SATURDAY    -> 9;
    case THURSDAY               -> 8;
};

// %% [markdown] lang="de" tags=["slide"]
// ## Vollständigkeit
// Mit der alten `switch` Anweisung konnte der Standardfall weggelassen werden
// * Das wurde vom Compiler nicht direkt bemerkt
// * Nur wenn eine Variable nicht initialisiert wurde, beschwert sich der Compiler

// %% 
int numberOfLetters2;
DayOfWeek day2 = DayOfWeek.SATURDAY;

// %%
switch (day2) {
    case MONDAY:
        numberOfLetters2 = 6;
        break;
    case SUNDAY:
        numberOfLetters2 = 6;
        break;
}

// %% 
// Here the compiler complains
numberOfLetters2

// %% [markdown] lang="de" tags=["slide"]
// Dieses Verhalten wurde mit dem neuen switch-Ausdruck verbessert
// * Da der Switch jetzt einen Wert zurückgibt, kann der Compiler überprüfen, ob alle möglichen Werte abgedeckt sind
// * Der Compiler beschwert sich, wenn der switch-Ausdruck nicht vollständig ist
// * Die Abdeckung aller Enum-Werte wird überprüft

// %% tags=["keep"]
DayOfWeek day3 = DayOfWeek.SATURDAY;

// %% 
int numberOfLetters = switch (day3) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case THURSDAY               -> 8;
};

// %% tags=["keep"]
int numberOfLetters = 3;

// %% tags=["keep"]
String result = switch (numberOfLetters) {
    case 6 -> "Six";
    case 7 -> "Seven";
    case 8 -> "Eight";
    // default -> "Unknown";
};

// %% [markdown] lang="de" tags=["slide"]
// Der Compiler beschwert sich nicht, wenn der switch-Ausdruck vollständig ist

// %%
enum PositiveNegative {
    POSITIVE, NEGATIVE
}

// %%
var multiplikator = switch (PositiveNegative.POSITIVE) {
    case POSITIVE -> 1;
    case NEGATIVE -> -1;
};

// %% tags=["keep"]
"Der Multiplikator für %s ist %s.".formatted(PositiveNegative.POSITIVE, multiplikator);

// %% [markdown] lang="de" tags=["slide"]
// ## Ergebnistyp
// * Der Ergebnistyp eines switch Expression wird vom Compiler automatisch ermittelt
// * Dies kann dazu führen, dass nach Auswertung des switch-Expression unterschiedliche Typen im Scope sind

// %% tags=["keep"]
void switchExpressionTypeInference(DayOfWeek tag) {
    var numLetters = switch (tag) {
        case MONDAY, FRIDAY, SUNDAY, TUESDAY -> 6;
        case THURSDAY, SATURDAY, WEDNESDAY   -> "eight";
        default                              -> throw new IllegalStateException("Unerwarteter Wert: " + tag);
    };
    System.out.println(numLetters + " -> " + numLetters.getClass());
}

// %% [markdown] lang="de" tags=["slide"]
// Bei Zuweisung zu Variable ist das nur mit `var` möglich

// %% tags=["keep"]
int value = 22;

// %%
var result = switch(value){
        case 22 -> "Twenty-two";
        default -> 42;  
    };

// %% 
switchExpressionTypeInference(DayOfWeek.MONDAY);

// %%
switchExpressionTypeInference(DayOfWeek.WEDNESDAY);

// %% [markdown] lang="de" tags=["slide"]
// ## Yield
// - Nach dem Pfeil `->` kann nicht nur ein einzelner Ausdruck verwendet werden, sondern auch ein Codeblock
// - In diesem Fall wird die `yield` Anweisung verwendet, um einen Wert aus dem Codeblock zurückzugeben

// %% tags=["keep"]
var day = DayOfWeek.SATURDAY;

// %% tags=["start"]
int numberOfLetters = switch (day) 
{
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY                -> 7;
    case WEDNESDAY -> 9;
    case THURSDAY, SATURDAY    -> 8;
};

// %%
int numberOfLetters = switch (day) 
{
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY                -> 7;
    case WEDNESDAY -> 9;
    case THURSDAY, SATURDAY    -> {
        if(day == DayOfWeek.SATURDAY){
            System.out.println("Weekend!");
            yield 8;
        } else {
            yield 8;
        }
    }
}

// %% 
System.out.println(numberOfLetters);

// %% [markdown] lang="de" tags=["slide"]
// ## Mini-Workshop : Switch Expressions

// %% tags=["keep"]
import java.time.Month;

// %% [markdown] lang="de" tags=["slide"]
// Gegeben ist folgende Funktion, die einen `Month` in einen `String` umwandelt:

// %% tags=["keep"]
String monthToString(Month month){
    String monthAsString;
    switch(month){
        case JANUARY:
            monthAsString = "January";
            break;
        case FEBRUARY:
            monthAsString = "February";
            break;
        case MARCH:
            monthAsString = "March";
        default :
            monthAsString = "Unknown";
    }
    return monthAsString;
}

// %% [markdown] lang="de" tags=["slide"]
// * Betrachten Sie das Ergebnis für folgende Eingaben: `FEBRUARY`, `MARCH`
// * Was ist das Problem?

// %%

// %% [markdown] lang="de" tags=["slide"]
// Schreiben Sie die Funktion `monthToString` als switch Expression um.

// %%
String monthToString(Month month){
    return switch(month){
        case JANUARY -> "January";
        default -> "Unkwnown"; // no fall through here
        case FEBRUARY -> "February";
        case MARCH -> "March";  
    };
}

// %% [markdown] lang="de" tags=["slide"]
// Überprüfen Sie die Ergebnisse für `FEBRUARY`, `MARCH` erneut.

// %%

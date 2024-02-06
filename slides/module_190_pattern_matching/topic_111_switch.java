// j2 from 'macros.j2' import header
// {{ header("Pattern Matching - switch", "Pattern Matching - switch") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Pattern Matching für Switch-Expressions
// - Preview seit Java 17
// - Pattern Matching für Switch-Statements oder Expressions erlaubt es, ein Target auf mehrere Patterns gleichzeitig zu matchen
// - Bisher sind die Patterns nur Typ-Patterns (wie bei instanceof)

// %%
Object o = "A string"

// %%
String formatted = null;
if(o instanceof Integer i){
    formatted = String.format("int %d", i);
} else if(o instanceof Long l){
    formatted = String.format("long %d", l);
} else if(o instanceof Double d){
    formatted = String.format("double %f", d);
} else if(o instanceof String s){
    formatted = String.format("String %s", s);
} else {
    formatted = "unknown";
}

// %% [markdown] lang="de" tags=["slide"]
// - Mit Pattern Matching für Switch-Expressions können wir das kürzer schreiben:

// %%
String formatted = switch(o){
    case Integer i -> String.format("int %d", i);
    case Long l -> String.format("long %d", l);
    case Double d -> String.format("double %f", d);
    case String s -> String.format("String %s", s);
    default -> "unknown";
}

// %% [markdown] tags=["notes"]
// java --enable-preview -cp target/classes e04_pattern_matching.PatternMatchingSwitch

// %% [markdown] lang="de" tags=["slide"]
// ## Guards
// - Ein Code-Muster dass sich in Switch Expressions häufig ergibt ist folgendes:

// %% tags=["start"]
String formatted = switch(o){
    case String s -> {
        if(s.isEmpty()) -> "A String";
    };
    case Integer i -> "An Integer";
}

// %% tags=["alt"]
String formatted = switch(o){
    case String s -> {
        if(s.isEmpty()){
            yield String.format("Empty string %s", s);
        }
    };
    case Integer i -> {
        if(i < 0){
            yield String.format("Negative integer %d", i);
        }
    };
}

// %% [markdown] lang="de" tags=["slide"]
// - Diese Prüfungen können über sogenannte "Guard Patterns" in das Pattern selbst integriert werden:

// %% 
String formatted = switch(o){
    case String s && s.isEmpty() -> String.format("Empty string %s", s);
    case Integer i && i < 0 -> String.format("Negative integer %d", i);
}

// %% [markdown] lang="de" tags=["slide"]
// ## `null`
// - Es ist auch möglich, null-Werte zu prüfen

// %%
String typeBasedOutputPattern(Object o){
    return switch(o){
        case null -> "Null value";
        case List things -> "A list of things with size: " + things.size();
        case Map map -> "A map containing these keys: " + map.keySet();
        case String s && !s.isEmpty() -> String.format("Non-empty string %s", s);
        default -> "This is something else";
    };
}

// %% [markdown] lang="de" tags=["slide"]
// ## Dominanz
// - Die Reihenfolge der case-Statements ist wichtig
// - Erscheint der Basistyp zuerst, dominiert er alle anderen Patterns

// %% tags=["keep"]
sealed interface Base {}
record Derived() implements Base {}

// %% tags=["keep"]
String test(Base base) {
    return switch(base) {
      case Base b -> "B";
      case Derived d -> "Derived";
    };
}

// %% [markdown] tags=["notes"]
// - The compiler will warn you: this case label is dominated by a preceding case label

// %% [markdown] lang="de" tags=["slide"]
// - Probleme mit dominierten Patterns können auch im Zusammenhang mit Guards auftreten
// - Der Compiler kann nicht immer feststellen, ob ein Guard Pattern dominiert wird oder nicht
// - IDEs erkennen unerreicharen Code eventuell

// %% tags=["keep"]
record Person(String name, int age) {}

// %% tags=["keep"]
public class People {
  static String categorize(Person person) {
    return switch(person) {
      case Person p && p.age() > 40          // [1]
        -> p + " is middle aged";
      case Person p &&
        (p.name().contains("D") || p.age() == 14)
        -> p + " D or 14";
      case Person p && (p.age() >= 100)     // [2]
        -> p + " is not a centenarian";
      case Person p -> p + " Everyone else";
    };
  }

  // %% tags=["keep"]
  List.of(
      new Person("Dorothy", 15),
      new Person("John Bigboote", 42),
      new Person("Morty", 14),
      new Person("Morty Jr.", 1),
      new Person("Jose", 39),
      new Person("Kane", 118)
    ).forEach(
      p -> System.out.println(categorize(p))
    );

// %% [markdown] tags=["notes"]
// Ohne den letzten case-Block würde der Compiler eine Warnung ausgeben: the switch expression does not cover all possible input values.
// With that case, a default is still not required, so the most general case becomes the default. Because the argument to the switch is a Person, all cases are covered (except for null).

// %% [markdown] lang="de" tags=["slide"]
// ## Pattern Matching und `sealed`
// Pattern Matching und `sealed` führen zu einer natürlichen Kombination
// `sealed` sorgt dafür, dass alle möglichen Typen abgedeckt werden und der Compiler dies überprüfen kann

// %% tags=["keep"]
sealed interface Transport {};
record Bicycle(String id) implements Transport {};
record Glider(int size) implements Transport {};
record Surfboard(double weight) implements Transport {};
// If you uncomment this:
// record Skis(int length) implements Transport {};
// You get an error: "the switch expression
// does not cover all possible input values"

public class SealedPatternMatch {
  static String exhaustive(Transport t) {
    return switch(t) {
      case Bicycle b -> "Bicycle " + b.id();
      case Glider g -> "Glider " + g.size();
      case Surfboard s -> "Surfboard " + s.weight();
    };
  }
  public static void main(String[] args) {
    List.of(
      new Bicycle("Bob"),
      new Glider(65),
      new Surfboard(6.4)
    ).forEach(
      t -> System.out.println(exhaustive(t))
    );
    try {
      exhaustive(null); // Always possible!  // [1]
    } catch(NullPointerException e) {
      System.out.println("Not exhaustive: " + e);
    }
  }
}

// %% [markdown] lang="de" tags=["slide"]
// # Ausblick:
// - Java 20 führt Deconstruction Patterns ein: 
// - Pattern Matching ermöglicht es Objekte zu dekonstruieren und die einzelnen Teile in Pattern-Variablen zu binden

// %% 
public record Point(int x, int y) {}

// %%
Point p = new Point(3, 4);

// %% [markdown] lang="de" tags=["slide"]
// Erstelle zwei Pattern-Variablen

// %%
if (p instanceof Point(int x, int y)) {
    System.out.println(x);
}

// %% [markdown] lang="de" tags=["slide"]
// Binde an das Point-Objekt selbst

// %%
if (p instanceof Point(int x, int y) p) {
    System.out.println(p.x());
}

// %% [markdown] tags=["notes"]
// But line [1] shows that there’s still one case that the compiler doesn’t insist you cover: null.
// If you remember to explicitly add a case null, you’ll prevent the exception. But the compiler doesn’t help you here, possibly because that would affect too much existing switch code.

// %% [markdown] lang="de" tags=["slide"]
// ## Mini-Workshop
//
// Refaktoriere den folgenden Code, um Pattern Matching mit einer Switch-Expression zu verwenden:
// - Beachte auch Probleme mit dominierten Patterns

// %% tags=["keep"]
String getFormatted(Object o){
    String formatted = null;
    if(o instanceof Integer i){
        if (i < 0) {
            formatted = String.format("negative int %d", i);
        } else if (i < -10) {
            formatted = String.format("positive int %d", i);
        }
        formatted = String.format("int %d", i);
    } else if(o instanceof Long l){
        formatted = String.format("long %d", l);
    } else if (if instanceof Object o){
        formatted = String.format("Object %s", o);
    } else if(o instanceof Double d){
        formatted = String.format("double %f", d);
    } else if(o instanceof String s){
        formatted = String.format("String %s", s);
    } else {
        formatted = "unknown";
    }
    return formatted;
}



// j2 from 'macros.j2' import header
// {{ header("String-Interpolation", "String-Interpolation") }}


// %% [markdown] lang="de" tags=["subslide"]
// # Motivation
// 
// - Viele Sprachen bieten einen Mechanismus um Werte in Strings einzufügen.
// - Java hat keine native Funktion für diese Aufgabe.
// - Aber es gibt Methoden um dieses Verhalten zu realisieren. 

// %% [markdown] lang="en" tags=["subslide"]
// # Motivation
//
// - Many languages offer a mechanism to insert values into strings.
// - Java does not have a native function for this task.
// - But there are methods to achieve this behavior.

// %% [markdown] lang="en" tags=["subslide"]
// # The `+`-Operator

// %% [markdown] lang="de" tags=["subslide"]
// # Der `+`-Operator

// %%
int value = 42;
String result = "The value is " + value;
result;

// %% [markdown] lang="en" tags=["subslide"]
// # `String.format` 

// %% [markdown] lang="de" tags=["subslide"]
// # `String.format`

// %%
int zahl = 42;
String output = String.format("Die Zahl ist %d.", zahl);
output;

// %% [markdown] lang="en" tags=["subslide"]
// - We can reference specific argumments if we want to avoid repetition:

// %% [markdown] lang="de" tags=["subslide"]
// - Wir kannnen bestimmte Argumente referenzieren, wenn wir diese nicht wiederholen möchten:

// %% tags=["start"]
int ersteZahl = 42;
int zweiteZahl = 24;
String output = String.format("The first %1$s and the second %2$s", ersteZahl, zweiteZahl);
output;

// %% tags=["alt"]
int ersteZahl = 42;
int zweiteZahl = 24;
String output = String.format("The first %1$s and the second %2$s and the sum is %1$s + %2$s = %3$s", ersteZahl, zweiteZahl, ersteZahl + zweiteZahl);
output;

// %% [markdown] lang="en" tags=["subslide"]
// # StringBuilder
// - We can use `StringBuilder` to build strings:

// %% [markdown] lang="de" tags=["subslide"]
// # StringBuilder
// - StringBuilder kann verwendet werden, um Strings zu erstellen:

// %% tags=["keep"]
StringBuilder sb = new StringBuilder();
sb.append("Hallo ")
    .append("Hans")
    .append("!")
    .append("Die Zahl ist ")
    .append(42)
    .append(".");
String output = sb.toString();
output;

// %% [markdown] tags=["subslide"]
// # MessageFormat

// %% tags=["start"]
String first = "Hans";
int second = 12;

// %% tags=["alt"]
String first = "Hans";
int second = 12;
String result = java.text.MessageFormat.format("Hallo {0}, die Zahl ist {1}.", first, second);
result;


// %% [markdown] lang="en" tags=["subslide"]
// # `printf`
// - To print formatted strings we use `printf`:

// %% [markdown] lang="de" tags=["subslide"]
// # `printf`
// - Um formatierte Strings auszugeben, nutzen wir `printf`:

// %%
System.out.printf("Hallo, Hans, die Zahl ist %d.", 42);

// %% [markdown] lang="en"]
// ## Mini workshop: Greeting
//
// Write a function `printGreeting(name)` that prints a personalized
// greeting, e.g..
// ```
// Hello John!
// Nice to welcome you again today.
// We wish you a lot of fun, John.
// ```
// Use string interpolation to achieve this.

// %% lang="en" tags=["subslide"]
public static void printGreeting(String name) {
    System.out.printf(
        "Hello %s!\n"
        + "Nice to welcome you again today.\n"
        + "We wish you a lot of fun, %s.\n"
        , name, name
    );
}

// %%
printGreeting("John");


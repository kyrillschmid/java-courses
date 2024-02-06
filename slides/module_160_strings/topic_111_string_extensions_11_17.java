// j2 from 'macros.j2' import header
// {{ header("String-Erweiterungen 11 - 17", "String-Extensions 11 - 17") }}

// %% [markdown] lang="en" tags=["slide"]
// The String class is part of the JDK since Java 1.0
// With Java 11 the following methods were added: 

// %% [markdown] lang="de" tags=["slide"]
// Die Klasse String ist Teil des JDK seit Java 1.0
// Mit Java 11 wurden folgende Methoden hinzugefügt:

// %% [markdown] lang="en" tags=["slide"]
// ## `isBlank()`

// %% [markdown] lang="de" tags=["slide"]
// ## `isBlank()`

// %% 
String s = "   ";

// %%
s.isBlank()

// %% [markdown] lang="en" tags=["slide"]
// ## `lines()`
// With `lines()` we can create a stream of Strings from a String

// %% [markdown] lang="de" tags=["slide"]
// ## `lines()`
// Mit `lines()` können wir einen Stream von Strings aus einem String erzeugen

// %%
String s = "This is a string with \n" +
           "multiple lines \n" +
           "separated by line breaks";


// %%
s.lines().forEach(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// ## Stripping
// `strip() , stripLeading() , stripTrailing()`

// %% [markdown] lang="de" tags=["slide"]
// ## Stripping
// `strip() , stripLeading() , stripTrailing()`

// %%
String s = "   This is a string with leading and trailing spaces   ";

// %%
s.strip()

// %% [markdown] lang="en" tags=["slide"]
// Difference to `trim()`:
// - `trim()` considers each character with unicode value < U+0020 as whitespace 
// - As a consequence whitespace characters with unicode value >= U+0020 are not removed by `trim()`
// - `strip()` uses Character.isWhitespace() to determine if a character is a whitespace character (so all unicode whitespace characters are removed)

// %% [markdown] lang="de" tags=["slide"]
// Unterschied zu `trim()`:
// - `trim()` entfernt alle Whitespace-Zeichen vom Anfang und Ende eines Strings
// - `trim()` betrachtet jedes Zeichen mit Unicode-Wert < U+0020 als Whitespace
// - Als Konsequenz werden Whitespace-Zeichen mit Unicode-Wert >= U+0020 nicht von `trim()` entfernt
// - `strip()` verwendet Character.isWhitespace(), um zu bestimmen, ob ein Zeichen ein Whitespace-Zeichen ist (so werden alle Unicode-Whitespace-Zeichen entfernt)

// %% tags=["keep"]
String s = "   This is a string with leading and trailing spaces     \u2002  ";

// %%

// %%

// %% [markdown] lang="en" tags=["slide"]
// ## `repeat()`
// With `repeat()` we can repeat a String n times

// %% [markdown] lang="de" tags=["slide"]
// ## `repeat()`
// Mit `repeat()` können wir einen String n-mal wiederholen

// %%
String s = "Java ";

// %%
s.repeat(3)

// %% [markdown] lang="en" tags=["slide"]
// With Java 12 the following methods were added:
// ## `indent()`
// With `indent()` we can indent a String

// %% [markdown] lang="de" tags=["slide"]
// Mit Java 12 wurden folgende Methoden hinzugefügt:
// ## `indent()`
// Mit `indent()` können wir einen String einrücken

// %%
String name = "Maximilian";

// %%
name.indent(4)

// %% [markdown] lang="en" tags=["slide"]
// Note: calling `indent()` adds a line break at the end of the String

// %% [markdown] lang="de" tags=["slide"]
// Hinweis: Der Aufruf von `indent()` fügt einen Zeilenumbruch am Ende des Strings hinzu

// %% [markdown] lang="en" tags=["slide"]
// ## `transform()`
// - Strings in Java are immutable so modifying a String always creates a new String or usage of a StringBuilder
// - `tranform()` is similar to `map()` on a Stream

// %% [markdown] lang="de" tags=["slide"]
// ## `transform()`
// - Strings in Java sind unveränderlich, daher erzeugt die Modifikation eines Strings immer einen neuen String oder die Verwendung eines StringBuilder
// - `tranform()` ist ähnlich wie `map()` auf einem Stream

// %% [markdown] lang="en" tags=["slide"]
// Lets assume we want to convert a String to uppercas then remove all E's and finally split the String into words:
// - Until now we would have to create a new String for each step

// %% [markdown] lang="de" tags=["slide"]
// Angenommen, wir möchten einen String in Großbuchstaben konvertieren, dann alle E's entfernen und schließlich den String in Wörter aufteilen:
// - Bisher müssten wir für jeden Schritt einen neuen String erstellen

// %%
var text = "When I find myself in times of trouble Mother Mary comes to me Speaking words of wisdom, let it be.";

// %%
var upper = text.toUpperCase();

// %%
var noEs = upper.replace("E", "");

// %%
var words = noEs.split(" ");

// %%
Arrays.toString(words)

// %% [markdown] lang="en" tags=["slide"]
// With `transform()` we can do this in a more functional way:

// %% [markdown] lang="de" tags=["slide"]
// Mit `transform()` können wir dies auf eine funktionalere Weise tun:

// %%
var result = text.transform(String::toUpperCase)
                 .transform(s -> s.replaceAll("E", ""))
                 .transform(s -> s.split(" "));

// %%
Arrays.toString(result)

// %% [markdown] lang="de" tags=["slide"]
// ## Java 15
// Mit Java 15 wurden folgende Methoden hinzugefügt:
// - `formatted()`
// Vor Java 15 mussten wir `String.format()` verwenden, um einen String zu formatieren

// %% 
String s = String.format("Hello %s, how are you?", "Max");

// %% [markdown] lang="en" tags=["slide"]
// With Java 15 we can use `formatted()` instead of `String.format()`
// - often the `formatted()` method is more readable:

// %% [markdown] lang="de" tags=["slide"]
// Mit Java 15 können wir anstelle von `String.format()` `formatted()` verwenden
// - oft ist die `formatted()`-Methode lesbarer:

// %% 
String s = "Hello %s, how are you?".formatted("Max");


// %% [markdown] lang="en" tags=["slide"]
// ## Mini-Workshop : Indent
// 
// Refactor the following code to use `indent()` only once:

// %% [markdown] lang="de" tags=["slide"]
// ## Mini-Workshop : Indent
//
// Refaktorieren Sie den folgenden Code, um `indent()` nur einmal zu verwenden:

// %% tags=["keep"]
String s = "This is a string with\n".indent(4) +
           "multiple lines\n".indent(4) +    
           "separated by line breaks".indent(4);

// %%
String s = """
           This is a string with
           multiple lines
           separated by line breaks
           """.indent(4);


// j2 from 'macros.j2' import header
// {{ header("Grundlegende Datentypen", "Basic Data Types") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Woraus besteht ein Programm?
//
// Wir wollen ein Programm schreiben, das
//
// ```
// Hello, world!
// ```
//
// auf dem Bildschirm ausgibt.
//
// Was benötigen wir dazu?

// %% [markdown] lang="en" tags=["slide"]
// ## Parts of a program
//
// We want to write a program that outputs
//
// ```
// Hello world!
// ```
//
// on the screen.
//
// What do we need for this?

// %% [markdown] lang="de" tags=["subslide"]
// Was benötigen wir dazu?
//
// - Daten
//     - den Text `Hello, world!`
// - Anweisungen
//     - *Gib den folgenden Text auf dem Bildschirm aus*
// - Kommentare
//     - Hinweise für den Programmierer, werden von Java ignoriert

// %% [markdown] lang="en" tags=["subslide"]
// What do we need for this?
//
// - Data
//     - the text `Hello, world!`
// - Instructions
//     - *Output the following text on the screen*
// - Comments
//     - Notes for the programmer, are ignored by Java

// %% [markdown] lang="de" tags=["subslide"]
// ## Kommentare
//
// - `//` gefolgt von beliebigem Text
// - bis zum Ende der Zeile

// %% [markdown] lang="en" tags=["subslide"]
// ## Comments
//
// - `//` followed by any text
// - to the end of the line

// %% tags=["keep"] lang="de"
// Das ist ein Kommentar.
// Alle Zeilen in dieser Zelle werden
// von Java ignoriert.

// %% tags=["keep"] lang="en"
// This is a comment.
// All lines in this cell will be
// ignored by Java.

// %% [markdown] lang="de" tags=["subslide"]
// ## Daten
//
// - Zahlen: `123`, `3.141592`
// - Text (Strings): `"Hello, world!"`

// %% [markdown] lang="en" tags=["subslide"]
// ## Data
//
// - Numbers: `123`, `3.141592`
// - Text (strings): `"Hello, world!"`

// %% tags=["subslide"]
123

// %%
1 + 2

// %%
3.141592

// %%
2.1 + 3.8

// %% tags=["subslide"]
3,141592

// %%
"Hello, world!"

// %%  tags=["subslide"]
"1"

// %%
"1" + "2"

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Anzeige von Werten mit der `System.out.println()` Funktion
//
// Um Werte anzuzeigen kann man die `System.out.println()` Funktion verwenden:
//
// `System.out.println(...)` gibt den in Klammern eingeschlossenen Text auf dem Bildschirm
// aus.

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Displaying values with the `System.out.println()` function
//
// To display values you can use the `System.out.println()` function:
//
// `System.out.println(...)` prints the text enclosed in parentheses on the screen.

// %%
System.out.println("Hello, world!")

// %% [markdown] lang="de" tags=["subslide"]
// ## Primitive Datentypen
// - Java liefert für verschiedene Datenmodalitäten grundlegende Datentypen (sog. primitive Datentypen)
// - Folgende Datentypen sind in Java vordefiniert:
//      - byte, short, int, long, float, double, char, boolean

<table style="width:50%">
<tr>
<th>Datentyp</th>
<th>Speicher</th>
<th>Bereich</th>
</tr>
<tr>
<td>byte (Ganzzahl)</td>
 <td>8 bits</td>
 <td>-128 bis 127</td>
 </tr>
<tr>
<td>short (Ganzzahl)</td>
<td>16 bits</td>
<td>-32.768 bis 32.767</td>
</tr>
<tr>
<td>int (Ganzzahl)</td>
<td>32 bits</td>
<td>-2.147.483.648 bis 2.147.483.647</td>
</tr>
<tr>
<td>long (Ganzzahl)</td>
<td>64 bits</td>
<td>-2^63 bis 2^63-1</td>
</tr>
<tr>
<td>float (Gleitkomma)</td>
<td>32 bits</td>
<td>Genauigkeit ca. 7 Kommastellen</td>
</tr>
<tr>
<td>double (Gleitkomma)</td>
<td>64 bits</td>
<td>Genauigkeit ca. 15 Kommastellen</td>
</tr>
<tr>
<td>char (Zeichen)</td>
<td>16 bits</td>
<td>0 – 65.535 (Unicode-Zeichen)</td>
</tr>
<tr>
<td>boolean (Wahrheitswert)</td>
<td>1 bit</td>
<td>true oder false</td>
</tr>
</table>

// %% [markdown] lang="de" tags=["slide"]
// ## Primitive Datentypen
//  - Ganzzahlen: *byte, short, int, long*

// %% [markdown] lang="en" tags=["slide"]
// ## Primitive data types
//  - Integers: *byte, short, int, long*

// %% tags=["keep"]
 byte  kreditLaufZeitInMonate = 127;              // 8 bit
 short mitarbeiterAnzahl      = 32767;            // 16 bit
 int deutschlandEinwohner     = 83_190_556;       // 32 bit 
 long weltweitBewohner        = 7_888_000_000L;   // 64 bit 

// %% [markdown] lang="de" tags=["slide"]
// - Gleitkommazahlen: *float, double*

// %% [markdown] lang="en" tags=["slide"]
// - Floating point numbers: *float, double*

// %% tags=["keep"]
float  a = 3.1415f;                    // 32 bit
double d = 3.1415926536;               // 64 bit 

// %% [markdown] lang="de" tags=["slide"]
//  - Einzelzeichen: *char*

// %% [markdown] lang="en" tags=["slide"]
//  - Single characters: *char*

// %% tags=["keep"]
char zeichen = 'a';                    // 16 bit

// %% [markdown] lang="de" tags=["slide"]
//  - Boolean:  *true, false*

// %% [markdown] lang="en" tags=["slide"]
//  - Boolean:  *true, false*

// %% tags=["keep"]
boolean isConnected = false;             // 1 bit   
boolean isJavaCool = true;               // 1 bit

// %% [markdown] lang="de" tags=["subslide"]
// ## Referenz-Datentypen 
// - Alle anderen Datentypen sind sogengante Referenz-Datentypen
// - Beispiel String

// %% [markdown] lang="en" tags=["subslide"]
// ## Reference data types
// - All other data types are so-called reference data types
// - Example String

// %%
 String a = "Hallo Welt";

// %% [markdown] tags=["slide"]
// - Arrays

// %%
 int[] a = {1, 2, 3, 4, 5};

// %% [markdown] lang="de" tags=["slide"]
// - Listen

// %% [markdown] lang="en" tags=["slide"]
// - Lists

// %%
List<String> a = new ArrayList<>();

// %% [markdown] lang="de" tags=["slide"]
// - Eigene definierte Java Klassen sind ebenfalls Referenz-Datentypen

// %% [markdown] lang="en" tags=["slide"]
// - User defined Java classes are also reference data types

// %%
public class Student { }

// %% [markdown] lang="de" tags=["subslide"]
// Wir schauen uns den Unterschied zwischen primitiven und Referenz-Datentypen an:
// [Python Tutor](https://pythontutor.com/visualize.html#code=public%20class%20Main%20%7B%0A%0A%20%20public%20static%20void%20main%28String%5B%5D%20args%29%7B%0A%20%20%0A%20%20%20%20int%20a%20%3D%201%3B%0A%20%20%20%20double%20b%20%3D%202.0%3B%0A%20%20%20%20char%20c%20%3D%20'c'%3B%0A%20%20%20%20String%20s%20%3D%20%22Hello,%20world%22%3B%0A%20%20%20%20%0A%20%20%7D%0A%7D&cumulative=false&heapPrimitives=true&mode=edit&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false)

// %% [markdown] lang="en" tags=["subslide"]
// Let's look at the difference between primitive and reference data types:
// [Python Tutor](https://pythontutor.com/visualize.html#code=public%20class%20Main%20%7B%0A%0A%20%20public%20static%20void%20main%28String%5B%5D%20args%29%7B%0A%20%20%0A%20%20%20%20int%20a%20%3D%201%3B%0A%20%20%20%20double%20b%20%3D%202.0%3B%0A%20%20%20%20char%20c%20%3D%20'c'%3B%0A%20%20%20%20String%20s%20%3D%20%22Hello,%20world%22%3B%0A%20%20%20%20%0A%20%20%7D%0A%7D&cumulative=false&heapPrimitives=true&mode=edit&origin=opt-frontend.js&py=java&rawInputLstJSON=%5B%5D&textReferences=false)


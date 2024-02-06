// j2 from 'macros.j2' import header
// {{ header("Text-Blöcke", "Text Blocks") }}

// %% [markdown] lang="de" tags=["slide"]
// * Java unterstützt viele Zeichensätze mittels UTF Encoding
// * Mehrzeilige Strings sind nicht-intuitiv und aufwändiger zu codieren
// * Das Text-Block-Feature bringt hier mehrere Vereinfachungen

// %% [markdown] lang="en" tags=["slide"]
// * Java supports many character sets using UTF encoding.
// * Multiline strings are not intuitive and more difficult to code.
// * The text block feature brings several simplifications here.

// %% [markdown] lang="de" tags=["slide"]
// Bisher:

// %% [markdown] lang="en" tags=["slide"]
// Motivation: What did it look like before text block?

// %% tags=["keep"]
var stringMitPunkt = "Das ist ein Punkt \u2022.";
stringMitPunkt += "\nUnd hier die zweite Zeile";

// %% [markdown] lang="en" tags=["slide"]
// ## Text Blocks
// - Text blocks are a means to easily write multiline strings
// - No need for cumbersome concatenation and escaping of special characters

// %% [markdown] lang="de" tags=["slide"]
// ## Text Blöcke
// - Text Blöcke sind eine Möglichkeit, mehrzeilige Strings einfach zu schreiben
// - Keine Notwendigkeit für umständliche Konkatenation und Escapen von Sonderzeichen 

// %%
"""
- This is a text block.
- It can contain multiple lines.
- It is delimited by three double quotes.
""" 

// %% [markdown] lang="en" tags=["slide"]
// ## Indentation
// - The closing three double quotes define the indentation of the text block
// - If no indentation is desired, the closing three double quotes should be on the same line as the opening three double quotes:

// %%  [markdown] lang="de" tags=["slide"]
// ## Einrückung
// Die schließenden drei doppelten Anführungszeichen definieren die Einrückung des Textblocks:

// %% tags=["keep"]
var block = """
          | This is a text block.
          |   The lines are indented...
          |     according to the indentation of the closing three double quotes.
          """;
block

// %% [markdown] lang="de" tags=["slide"]
// Wenn keine Einrückung gewünscht ist, sollten die schließenden drei doppelten Anführungszeichen in der gleichen Zeile wie die öffnenden drei doppelten Anführungszeichen stehen:

// %% tags=["keep"]
"""
    - This is a text block.
    - It can contain multiple lines.
    - It is delimited by three double quotes.""" 

// %% [markdown] lang="de" tags=["slide"]
// ## Beispiel 1: JavaScript

// %% [markdown] lang="en" tags=["slide"]
// Before Text Blocks were introduced, we had to write:

// %% [markdown] lang="de" tags=["slide"]
// Vor der Einführung von Text-Blöcken war es Code-Schnipsel wie diesen zu schreiben:

// %% tags=["keep"]
String code = "function helloWorld{} \n" +
              "  print(\"Hello World!\"); \n" +
              "}\n" + 
              "helloWorld();";

// %% 
code

// %% [markdown] lang="en" tags=["slide"]
// Now, we can write:

// %% [markdown] lang="de" tags=["slide"]
// Jetzt können wir schreiben:

// %%
String code = """
              function helloWorld{} 
                print("Hello World!"); 
              }
              helloWorld();""";

// %%
code

// %% [markdown] lang="de" tags=["slide"]
// ## Beispiel 2: HTML

// %% tags=["keep"]
var helloWorldOld = "<html>\n" +
                    "  <body>\n" +
                    "    <h1>Hello World!</h1>\n" +
                    "  </body>\n" +
                    "</html>";

// %% tags=["keep"]
var helloWorldNew = """
                    <html>
                      <body>
                        <h1>Hello World!</h1>
                      </body>
                    </html>""";


// %% [markdown] lang="de" tags=["slide"]
// ## Besonderheiten

// %% [markdown] lang="de" tags=["slide"] 
// Doppelte Anführungszeichen können innerhalb eines Textblocks ohne Escapen verwendet werden:
// * Das ist z.B. bei SQL-Abfragen sehr praktisch:

// %%
String sql = """
             SELECT * FROM users
             WHERE name = "John"
             """;

// %% [markdown] lang="de" tags=["slide"]
// Hinter den öffnenden drei Anführungszeichen dürfen nur noch Leerzeichen stehen (werden aber ignoriert)

// %% tags=["keep"]
"""This will result in an error 
because there is a character after the opening three double quotes"""


// %% [markdown] lang="de" tags=["slide"]
// Wenn der Block drei doppelte Anführungszeichen enthält, müssen sie escaped werden mit `\"""`

// %%
""" 
Text-Blocks can contain triple quotes: """

// %% [markdown] lang="de" tags=["slide"]
// ## Zeilenumbrüche
// Manchmal möchten wir Strings über mehrere Zeilen aufteilen, ohne einen Zeilenumbruch in der resultierenden Zeichenkette zu haben
// * Bessere Lesbarkeit in IDEs:

// %%
String text = "This is a very long text that is split " +
              "over multiple lines " +
              " to improve readability.";

// %%

// %% [markdown] lang="de" tags=["slide"]
// Wenn wir dies in einen Textblock konvertieren, würden wir einen Zeilenumbruch in der resultierenden Zeichenkette erhalten:

// %%
String text = """
              This is a very long text that is split 
              over multiple lines 
              to improve readability.
              """;

// %%

// %% [markdown] lang="de" tags=["slide"]
// Wenn wir dies vermeiden möchten, können wir den Zeilenumbruch mit einem Backslash escapen, um eine einzelne Zeile zu erhalten:

// %%
String text = """
              This is a very long text that is split \
              over multiple lines \
              to improve readability.
              """;

// %%

// %% [markdown] lang="de" tags=["slide"]
// ## Whitespaces (\s)
// Das Standardverhalten eines Textblocks entfernt alle Leerzeichen am Ende einer Zeile:

// %%
"""
    Whitespace at the end of a line is removed.     """
// %% [markdown] lang="de" tags=["slide"]
// Wollen wir Leerzeichen am Ende einer Zeile behalten, können wir diese mit `\s` escapen:
//   - Das kann nützlich sein, wenn alle Zeilen eines Textblocks die gleiche Länge haben sollen:

// %%
String text = """
              Max    \s
              Mustermann
              """;

// %%

// %% [markdown] lang="de" tags=["slide"]
// Beachten Sie, dass \s auch in ein Leerzeichen in der resultierenden Zeichenkette umgewandelt wird:

// %% tags=["keep"]
"""
    Maximilian\s
    Paul      \s
    Mary      \s
    """

// %% [markdown] lang="de" tags=["slide"]
// Daher \s für die längste Zeile auslassen, um ein Leerzeichen am Ende zu vermeiden:

// %%
"""
    Maximilian
    Paul     \s
    Mary     \s
    """

// %% [markdown] lang="de" tags=["slide"]
// ## Formatierte Ausgabe
// Textblöcke können verwendet werden, um die Ausgabe zu formatieren
//    - Wir können eine Vorlage mit Platzhaltern definieren und später Werte einfügen

// %%
String template = """
                  Hello %s,
                  How are you today?
                  """;

// %%
String name = "Max";
String greeting = String.format(template, name);

// %%
greeting

// %% [markdown] lang="de" tags=["slide"]
// Mit Textblöcken können wir das auf lesbarere Weise schreiben:

// %%
String template = """
                  Hello %s,
                  How are you today?
                  """.formatted(name);
template

// %% [markdown] lang="de" tags=["slide"]
// ## Definition von JSON
// Java unterstützt JSON nicht nativ, aber wir können Textblöcke verwenden, um JSON-Zeichenketten zu definieren:

// %%
String json = """
              {
                "name": "Max",
                "age": 30
              }
              """;
json 

// %% [markdown] lang="de" tags=["slide"]
// Hinweis: Für komplexe JSONs sollten externe Bibliotheken wie Jackson verwendet werden.

// %% [markdown] lang="de" tags=["slide"]
// ## Harmonisierung von Zeilenenden
// Zeilenumrbüche in Text-Dateien werden plattformabhängig gespeichert:
// * Windows: CR+LF (Carriage Return + Line Feed) typischerweise als \r\n
// * Unix: LF (Line Feed) typischerweise als \n 
// * Mac früher: CR (Carriage Return) typischerweise als \r

// %% [markdown] lang="de" tags=["slide"]
// In Text-Blöcken werden die Zeilenenden einheitlich zu newline (LF) konvertiert
// * Sollte der Editor CR oder CRLF an das Ende einer Zeile im Text-Block setzen, so macht der Compiler ein LF daraus
//   * Vorteile:
//     * Weniger Überraschungen bei plattformübergreifenden Projekten
// * Explizit einfügte andere Zeilenenden bleiben erhalten

// %% tags=["keep"]
long zähleSubstringVorkommnisse(String text, String substring) {
    int idx = 0;
    long counter = 0;
    while ((idx = text.indexOf(substring, idx + substring.length())) > 0) {
        counter++;
    }
    return counter;
}

// %%
zähleSubstringVorkommnisse("Dann sagt er, dann sagt sie, dann sagen wir alle.", "sag")

// %% tags=["keep"]
var zitat = """
Von Johann Wolfgang von Goethe:
"Wichtige Dinge dürfen nie den unwichtigen untergeordnet werden".
""";

// %% tags=["keep"]
System.out.println("--\n" + zitat + "--");

// %% tags=["keep"]
"Das Zitat enthält %s Line Feeds (erwartet 2)".formatted(zähleSubstringVorkommnisse(zitat, "\n"));


// %% tags=["keep"]
"Das Zitat enthält %s Carriage Returns (erwartet 0)".formatted(zähleSubstringVorkommnisse(zitat, "\r"));


// %% tags=["keep"]
"Das Zitat enthält %s Carriage Return + Line Feed (erwartet 0)".formatted(zähleSubstringVorkommnisse(zitat, "\r\n"));


// %% [markdown] lang="de" tags=["slide"]
// ## Mini-Workshop - HTML-Code
//
// - Refaktorisiere den folgenden Code so, dass er mit Textblöcken geschrieben werden kann:

// %%
String html = "<html>\n" +
              "  <body>\n" +
              "    <h1>Hello, World!</h1>\n" +
              "  </body>\n" +
              "</html>";

// %%
html

// %% [markdown] lang="en" tags=["slide"]
// Remove indentation and make sure all lines have the same length in the following text-block:

// %%
String html = """
                There are many variations of passages of Lorem Ipsum available,
                but the majority have suffered alteration in some form, by injected humour,
                or randomised words which don't look even slightly believable.
              """;

// %% [markdown] lang="de" tags=["slide"]
// ## Mini-Workshop: Führende Leerzeichen
//
// * Schreibe eine Methode `umrandeInhalt`, die einen String nimmt und jede Zeile mit `|` umrandet
// * `umrandeInhalt("Hallo Welt.")` sollte folgenden String zurückgeben:
//     ```
//     |Hallo Welt.|
//     ```

// %%
String umrandeInhalt(String str){
    return Arrays.stream(str.split("\n")).map(zeile -> "|" + zeile + "|").reduce("", (a, b) -> a + "\n" + b);
}

// %% tags=["keep"]
umrandeInhalt("Hallo Welt.");

// %% tags=["keep"]
umrandeInhalt("""
          Hallo Welt.
          Mit einer zweiten Zeile."""
);

// %% [markdown] lang="de" tags=["slide"]
// ### Ermittle welchen Effekt die Position der abschließenden `"""` hat

// %%
umrandeInhalt("""
   Hallo
      Welt.
""");

// %%
umrandeInhalt("""
   Hallo
      Welt.
         """);

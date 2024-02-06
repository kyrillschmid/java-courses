// %% [markdown] lang="de" tags=["subslide"]
//
// ## Mini-Workshop: Verkürzte Ausgabe


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Mini-Workshop: Shortened output


// %% [markdown] lang="de" tags=["subslide"]
//
// Schreiben Sie eine Funktion `fitsInLine(String text, int lineLength)`,
// die `true` oder `false` zurückgibt, je nachdem ob der String `text`
// in einer Zeile der Länge `line_length` ausgegeben werden kann oder nicht:
// ```java
// >>> fitsInLine("Hallo", 72)
// true
// >>> fitsInLine("Hallo", 3)
// false
// ```
//
// *Hinweis:* Sie können die Länge eines Strings mit der Funktion `length()` bestimmen:
// ```java
// >>> "abcd".length()
// 4
// ```

// %% [markdown] lang="en" tags=["subslide"]
//
// Write a function `fitsInLine(String text, int lineLength)`,
// that returns `true` or `false` depending on whether the string `text`
// can be printed in a line of length `line_length`:
// ```java
// >>> fitsInLine("Hello", 72)
// true
// >>> fitsInLine("Hello", 3)
// false
// ```
//
// *Hint:* You can determine the length of a string with the function `length()`:
// ```java
// >>> "abcd".length()
// 4
// ```

// %% tags=["subslide"]
boolean fitsInLine(String text, int lineLength){
    return text.length() <= lineLength;
}

// %%
fitsInLine("Hallo", 72)

// %%
fitsInLine("Hallo", 3)


// %% [markdown] lang="de" tags=["subslide"]
//
// Schreiben Sie eine Funktion `printLine(String text, int lineLength)`,
// die
// * `text` auf dem Bildschirm ausgibt, falls das in einer Zeile der Länge
//   `lineLength` möglich ist
// * `...` ausgibt, falls das nicht möglich ist.
//
// ```java
// >>> printLine("Hallo", 72)
// Hallo
// >>> printLine("Hallo", 3)
// ...
// >>>
// ```

// %% [markdown] lang="en" tags=["subslide"]
//
// Write a function `printLine(String text, int lineLength)`,
// that
// * prints `text` on the screen, if that is possible in a line of length
//   `lineLength`
// * prints `...` if that is not possible.
//
// ```java
// >>> printLine("Hello", 72)
// Hello
// >>> printLine("Hello", 3)
// ...
// >>>
// ```

// %% tags=["subslide"]
void printLine(String text, int lineLength){
    if (fitsInLine(text, lineLength)){
        System.out.println(text);
    } else {
        System.out.println("...");
    }
}

// %%
printLine("Hallo", 72)

// %%
printLine("Hallo", 3)

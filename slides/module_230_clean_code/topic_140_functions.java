// j2 from 'macros.j2' import header
// {{ header("Clean Code: Funktionen", "Clean Code: Functions") }}

// %% [markdown] lang="de" tags=["slide"]
//
// // Clean Code: Funktionen
//
// Verpacke Sinnvolle Operationen als sorgfältig benannte Funktionen
//
// - Besser lesbar
// - Einfacher zu testen
// - Wird eher wiederverwendet
// - Fehler sind weniger wahrscheinlich

// %% [markdown] lang="en" tags=["slide"]
//
// // Clean Code: Functions
//
// Package meaningful operations as carefully named functions
//
// - More readable
// - Easier to test
// - More likely to be reused
// - Less likely to contain errors

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Die 1. Clean Code Regel für Funktionen
//
// - Funktionen sollten kurz sein
// - Kürzer als man meint!
// - Maximal 4 Zeilen!

// %% [markdown] lang="en" tags=["subslide"]
//
// ## The first rule about functions
//
// - Functions should be small
// - Even smaller than that!
// - No more than 4 lines!

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Weniger strikte Regeln
//
// (Aus den C++ Core Guidelines)
//
// - Funktionen sollten auf einen Bildschirm passen
// - Große Funktionen sollten in kleinere, zusammenhängende und benannte
//   Funktionen aufgeteilt werden
// - Funktionen mit einer bis fünf Zeilen sollten als normal angesehen werden

// %% [markdown] lang="en" tags=["subslide"]
//
// ## More relaxed rules
//
// (From the C++ Core Guidelines)
//
// - Functions should fit on a screen
// - Break large functions up into smaller cohesive and named functions
// - One-to-five-lines functions should be considered normal


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Konzentration auf eine Aufgabe
//
// - Funktionen sollten eine Aufgabe erfüllen ("do one thing")
// - Sie sollten diese Aufgabe gut erfüllen
// - Sie sollten nur diese Aufgabe erfüllen

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Do one thing
//
// - Functions should do one thing
// - They should do it well
// - They should do it only

// %% tags=["keep"]
public int computeSaveAndPrintResults(int a, int b, List<Integer> results) {
        int newResult = a + b;  // Complex computation...
        results.add(newResult);
        for (int result : results) {
            System.out.println(result);
        }
        return newResult;
}

// %% tags=["keep"]
List myResults = new ArrayList<Integer>(Arrays.asList(12, 43));
int newResult = computeSaveAndPrintResults(2, 4, myResults);
System.out.println(myResults);


// %% tags=["subslide", "keep"]
public int computeResult(int a, int b) {
    return a + b;
}


// %% tags=["keep"]
public void saveResult(int newResult, List<Integer> results) {
    results.add(newResult);
}


// %% tags=["keep"]
public void printResults(List<Integer> results) {
    for (int result : results) {
        System.out.println(result);
    }
}


// %% tags=["subslide", "keep"]
// Better but still sketchy (see later for further refinement):
public void processNewSensorData(int a, int b, List<Integer> results) {
    int newResult = computeResult(a, b);
    saveResult(newResult, results);
    printResults(results);
}

// %% tags=["keep"]
List<Integer> yourResults = new ArrayList<>(Arrays.asList(12, 43));
processNewSensorData(2, 4, yourResults);
System.out.println(yourResults);

// %% [markdown] lang="de" tags=["slide"]
//
// ## Abstraktionsebenen
//
// Alles, was die Funktion in ihrem Rumpf tut, sollte eine (und nur eine)
// Abstraktionsebene unterhalb der Funktion selbst sein.

// %% [markdown] lang="en" tags=["slide"]
//
// ## Abstraction levels
//
// Everything the function does in its body should be one (and only one) level of
// abstraction below the function itself.

// %% [markdown] lang="de" tags=["subslide"]
//
// ## "Um zu"-Absätze: Kontrolle der Abstraktionsebenen
//
// Um `render_page_with_setups_and_teardowns()` durchzuführen
//
// prüfen wir, ob die Seite eine Testseite ist und
//
// wenn ja, binden wir Setup- und Teardown-Elemente ein.
//
// In jedem Fall rendern wir die Seite in HTML.

// %% [markdown] lang="en" tags=["subslide"]
//
// ## "To" paragraphs: Checking levels of abstraction
//
// To `render_page_with_setups_and_teardowns()`
//
// We check to see whether the page is a test page and
//
// if so, we include the setups and teardowns.
//
// In either case we render the page in HTML


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Die Step-Down-Regel
//
// - Wir wollen, dass sich der Code wie eine Erzählung von oben nach unten liest
// - Auf jede Funktion sollten die Funktionen eine Abstraktionsebene darunter
//   folgen

// %% [markdown] lang="en" tags=["subslide"]
//
// ## The Step-Down Rule
//
// - We want code to read like a top-down narrative
// - Every function should be followed by those one level of abstraction below it


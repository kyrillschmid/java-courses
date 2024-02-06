// j2 from 'macros.j2' import header
// {{ header("Ändern der Funktionsdeklaration", "Change Function Declaration") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Das Muster "Ändern der Funktionsdeklaration" besteht darin, die Deklaration einer Funktion (wie Name, Parameter oder Rückgabetyp) zu ändern, um die Verständlichkeit und Wartbarkeit des Codes zu verbessern. Dies kann das Umbenennen einer Funktion, das Hinzufügen oder Entfernen von Parametern oder das Ändern des Rückgabetyps umfassen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The "Change function declaration" pattern consists of changing the declaration of a function (such as name, parameters, or return type) to improve the understandability and maintainability of the code. This can include renaming a function, adding or removing parameters, or changing the return type.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Funktionen sind die Hauptbausteine eines Programms. Die Deklarationen von Funktionen repräsentieren die Verbindungen zwischen den Teilen eines Softwaresystems. Eine gute Benennung und geeignete Parameter verbessern das Verständnis des Codes und erleichtern das Hinzufügen neuer Funktionen. Daher ist es wichtig, die Funktionsdeklarationen im Laufe der Zeit anzupassen, um die beste Struktur für den Code zu finden.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Motivation
//
// Functions are the main building blocks of a program. The declarations of functions represent the connections between the parts of a software system. Good naming and appropriate parameters improve understanding of the code and make it easier to add new functions. Therefore, it is important to adjust function declarations over time to find the best structure for the code.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Einfaches Vorgehen
// - Wenn Sie einen Parameter entfernen, stellen Sie sicher, dass er im Funktionskörper nicht referenziert wird.
// - Ändern Sie die Funktionsdeklaration in die gewünschte Deklaration.
// - Suchen und aktualisieren Sie alle Referenzen auf die alte Funktionsdeklaration.
// - Testen Sie den Code.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Simple Procedure
// - If removing a parameter, ensure it is not referenced in the function body.
// - Change the function declaration to the desired declaration.
// - Find and update all references to the old function declaration.
// - Test the code.


// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
public String formatFullName(String firstName, String lastName) {
    return firstName + " " + lastName;
}

// %% tags=["subslide"]
public String formatPersonName(String firstName, String middleName, String lastName) {
    return firstName + " " + middleName + " " + lastName;
}

// %% [markdown] lang="de" tags=["subslide"]
// ## Beachten
// - Nicht eindeutige Namen (Andere Funktion hat gleichen Namen) - Caller nicht ändern
// - Je mehr Aufrufe der Funktion und anderer Funktionen mit gleichem Namen desto schwieriger
// - In diesem Fall stufenweise Mechanik anwenden

// %% [markdown] lang="en" tags=["subslide"]
// ## Considerations
// - Non-unique names (other function has the same name) - do not change the caller
// - The more calls to the function and other functions with the same name, the more difficult
// - In this case, apply the mechanic step by step.


// %% [markdown] lang="de" tags=["subslide"]
// ## Stufenweises Vorgehen

// %% [markdown] lang="en" tags=["subslide"]
// ## Stepwise Procedure

// %% tags=["subslide"]
public void doStuff(){
    System.out.println("Hello, world!");
}

// %% [markdown] lang="de" tags=["subslide"]
// ## Anwendung von Extract Function

// %% [markdown] lang="en" tags=["subslide"]
// ## Apply Extract Function

// %% tags=["subslide"]
public void sayHello(){
    System.out.println("Hello, world!");
}

// %% tags=["subslide"]
public void doStuff(){
    sayHello();
}

// %% [markdown] lang="de" tags=["subslide"]
// - Schrittweises ersetzen aller Aufrufe von `doStuff()` mit `sayHello()`
// - Testen nach jeder Änderung

// %% [markdown] lang="en" tags=["subslide"]
// - Replace all calls to `doStuff()` with `sayHello()` step by step
// - Test after each change.

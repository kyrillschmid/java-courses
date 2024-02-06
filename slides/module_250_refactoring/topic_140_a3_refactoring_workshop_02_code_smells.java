// j2 from 'macros.j2' import header
// {{ header("Workshop Refactoring: Teil 2 - Code Smells", "Workshop Refactoring: Part 1 -  Code Smells") }}

// %% [markdown] lang="de" tags=["slide"]
//
// ## Welche Code Smells gibt es?
// - Lange Methode (Long Method)
// - Code Duplikate (Duplicated Code)

// %% [markdown] lang="en" tags=["slide"]
//
// ## Which code smells are there?
// - Long Method
// - Duplicated Code

// %% [markdown] lang="de" tags=["slide"]
// ## Lange Methode
// - Eine Methode ist zu lang
// - Sie sollte in kleinere Methoden aufgeteilt werden
// - Die kleineren Methoden sollten sinnvoll benannt werden
// - Die kleineren Methoden müssen in der richtigen Reihenfolge aufgerufen werden
// - Die kleineren Methoden sollten in der richtigen Klasse sein

// %% [markdown] lang="en" tags=["slide"]
// // Long Method
// - A method is too long
// - It should be split into smaller methods
// - The smaller methods should be named appropriately
// - The smaller methods must be called in the correct order
// - The smaller methods should be in the correct class


// %% [markdown] lang="de" tags=["slide"]
//
// ## Lange Funktion eliminieren
// - Funktion testableHTML ist lang und unübersichtlich
// - Um sie zu verbessern, wollen wir sie in eine Klasse umwandeln
// - Die Klasse soll die eigentlich Funktionalität Kapseln
// - Die lokalen Variablen werden zu Instanzvariablen

// %% [markdown] lang="en" tags=["slide"]
//
// ## Eliminate long function
// - Function testableHTML is long and confusing
// - To improve it, we want to convert it to a class
// - The class should encapsulate the actual functionality
// - The local variables become instance variables

// %% [markdown] lang="de" tags=["slide"]
//
// ## Das "Replace with Command Pattern"
// - Manchmal bietet es sich an eine Funktion in einem eigenen Objekt zu kapseln (Command-Objekt)
// - Vorteil, wenn Funktion viele lokale Variablen hat
// - Vorgehen: 
//   - Command-Klasse erstellen
//   - Command-Klasse mit den lokalen Variablen initialisieren
//   - Move Method: Code der Funktion in die Command-Klasse verschieben
//   - Instanzvariablen für Argumente der Funktion erstellen






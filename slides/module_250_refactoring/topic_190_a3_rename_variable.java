// j2 from 'macros.j2' import header
// {{ header("Variable Umbenennen", "Rename Variable") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Das Muster "Variable umbenennen" wird verwendet, um die Klarheit des Codes zu verbessern, indem Variablen sinnvolle und beschreibende Namen gegeben werden. Dies hilft dabei, den Zweck und die Funktion der Variablen im Code zu kommunizieren und macht ihn leichter verständlich


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The "Rename Variable" pattern is used to improve the clarity of the code by giving variables meaningful and descriptive names. This helps to communicate the purpose and function of the variable in the code and makes it easier to understand


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Die richtige Benennung von Variablen ist für eine klare Programmierung unerlässlich, da sie hilft, den Zweck des Codes zu erklären. Es kann jedoch sein, dass Variablennamen im Laufe der Zeit geändert werden müssen, wenn sich das Verständnis des Programmierers für das Problem verbessert oder wenn sich der Zweck des Programms aufgrund der Anforderungen der Benutzer ändert. Die Bedeutung eines Variablennamens hängt von seinem Umfang und seiner Verwendung ab; dauerhafte Felder oder Variablen, die in mehreren Funktionen verwendet werden, erfordern eine sorgfältigere Namensgebung.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Motivation
//
// Naming variables well is essential for clear programming, as it helps explain the purpose of the code. However, variable names may need to be changed over time as the programmer's understanding of the problem improves, or as the program's purpose changes due to users' needs. The importance of a variable's name depends on its scope and usage; persistent fields or variables used across multiple functions require more careful naming.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vorgehen
// - Wenn die Variable weit verbreitet verwendet wird, ziehen Sie in Erwägung, das Encapsulate-Variable-Muster zu verwenden.
// - Finden Sie alle Verweise auf die Variable und ändern Sie jeden einzelnen.
// - Wenn es Verweise aus einer anderen Codebasis gibt, die Variable eine veröffentlichte Variable ist und Sie diese Refaktorisierung nicht durchführen können.
// - Wenn sich die Variable nicht ändert, können Sie sie in eine mit dem neuen Namen kopieren und dann schrittweise ändern, wobei Sie nach jeder Änderung testen.
// - Testen Sie den Code.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Procedure
// - If the variable is used widely, consider using the Encapsulate Variable pattern.
// - Find all references to the variable and change every one.
// - If there are references from another code base, the variable is a published variable, and you cannot perform this refactoring.
// - If the variable does not change, you can copy it to one with the new name, then change gradually, testing after each change.
// - Test the code.


// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
public class Employee {
    private int employeeId;
    private String fullName;
}

// %% tags=["subslide"]
public class Employee {
    private int employeeId;
    private String fullName;
}



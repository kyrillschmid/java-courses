// j2 from 'macros.j2' import header
// {{ header("Variable Extrahieren", "Extract Variable") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Das Extract Variable-Muster besteht darin, komplexe Ausdrücke in lokale Variablen aufzuteilen, um den Code leichter verständlich und lesbar zu gestalten. Diese Variablen ermöglichen es, Teile einer komplexeren Logik zu benennen und das Debugging zu erleichtern.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The Extract Variable pattern consists of splitting complex expressions into local variables to make the code easier to understand and read. These variables allow you to name parts of more complex logic and make debugging easier.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Die Motivation für die Verwendung von Extract Variable besteht darin, komplexe Ausdrücke durch lokale Variablen lesbarer und verständlicher zu gestalten. Diese Variablen können das Verständnis des Codes verbessern, indem sie Teile einer komplexeren Logik benennen, und sind auch praktisch für das Debugging.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The motivation for using Extract Variable is to make complex expressions more readable and understandable by using local variables. These variables can improve understanding of the code by naming parts of more complex logic, and are also handy for debugging.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vorgehen
// - Stellen Sie sicher, dass der Ausdruck, den Sie extrahieren möchten, keine Nebeneffekte hat.
// - Deklarieren Sie eine unveränderliche Variable und weisen Sie ihr eine Kopie des Ausdrucks zu, den Sie benennen möchten.
// - Ersetzen Sie den ursprünglichen Ausdruck durch die neue Variable.
// - Testen Sie den Code.
// - Wenn der Ausdruck mehr als einmal vorkommt, ersetzen Sie jedes Vorkommen durch die Variable und testen Sie nach jeder Ersetzung.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Procedure
// - Ensure that the expression you want to extract has no side effects.
// - Declare an immutable variable and assign it a copy of the expression you want to name.
// - Replace the original expression with the new variable.
// - Test the code.
// - If the expression occurs more than once, replace each occurrence with the variable and test after each replacement.


// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
public class ExtractVariableExample {
    public static void main(String[] args) {
        double price = 100;
        int quantity = 5;
        double discount = 0.1;
        double tax = 0.05;

        double total = price * quantity * (1 - discount);
        double taxedTotal = total * (1 + tax);
        System.out.println("Total price: " + taxedTotal);
    }
}

// %% tags=["subslide"]
public class ExtractVariableExample {
    public static void main(String[] args) {
        double price = 100;
        int quantity = 5;
        double discount = 0.1;
        double tax = 0.05;

        double discountMultiplier = 1 - discount;
        double taxMultiplier = 1 + tax;

        double total = price * quantity * discountMultiplier;
        double taxedTotal = total * taxMultiplier;
        System.out.println("Total price: " + taxedTotal);
    }
}
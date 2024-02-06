// j2 from 'macros.j2' import header
// {{ header("Funktion Extrahieren", "Extract Function") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Das Extract Function-Muster ist eine häufige Refactoring-Technik, bei der ein Codefragment in eine separate Funktion (oder Methode in objektorientierten Sprachen) extrahiert wird. Diese neue Funktion sollte nach ihrem Zweck benannt werden. Das Hauptziel besteht darin, die Absicht des Codes klarer zu machen und die Trennung zwischen Absicht und Implementierung zu verbessern.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The Extract Function pattern is a common refactoring technique where a code fragment is extracted into a separate function (or method in object-oriented languages). This new function should be named after its purpose. The main goal is to make the intent of the code clearer and improve the separation between intent and implementation.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Die Motivation für die Verwendung des Extract Function-Musters besteht darin, die Lesbarkeit des Codes zu verbessern, indem Codefragmente in separate Funktionen extrahiert werden. Dabei sollte die Funktion nach ihrer Absicht und nicht nach ihrer Implementierung benannt werden. Dies erleichtert das Verständnis des Codes und ermöglicht es, die Funktion ohne Kenntnis der genauen Implementierung zu verwenden.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The motivation for using the Extract Function pattern is to improve code readability by extracting code fragments into separate functions. In doing so, the function should be named according to its intent rather than its implementation. This makes the code easier to understand and allows the function to be used without knowing its exact implementation.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vorgehen
// - Erstellen Sie eine neue Funktion und benennen Sie sie nach der Absicht der Funktion.
// - Kopieren Sie den extrahierten Code aus der Quellfunktion in die neue Ziel-Funktion.
// - Suchen Sie im extrahierten Code nach Verweisen auf lokale Variablen und passen Sie diese als Parameter an.
// - Falls nötig, verschieben Sie Deklarationen von Variablen, die nur im extrahierten Code verwendet werden, in den extrahierten Code.
// - Kompilieren Sie den Code, um sicherzustellen, dass alle Variablen ordnungsgemäß behandelt wurden.
// - Ersetzen Sie den extrahierten Code in der Quellfunktion durch einen Aufruf der Ziel-Funktion.
// - Führen Sie Tests durch, um sicherzustellen, dass keine Funktionalität verloren gegangen ist.
// - Suchen Sie nach weiterem Code, der dem gerade extrahierten Code ähnelt, und erwägen Sie, diesen ebenfalls durch Aufrufe der neuen Funktion zu ersetzen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Procedure
// - Create a new function and name it according to the function's intent.
// - Copy the extracted code from the source function into the new target function.
// - In the extracted code, look for references to local variables and adjust them as parameters.
// - If necessary, move declarations of variables that are only used in the extracted code into the extracted code.
// - Compile the code to ensure that all variables have been properly handled.
// - Replace the extracted code in the source function with a call to the target function.
// - Perform tests to ensure that no functionality has been lost.
// - Look for additional code that is similar to the code that was just extracted and consider replacing it with calls to the new function as well.


// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
public class ExtractFunctionExample {
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
public class ExtractFunctionExample {
    public static void main(String[] args) {
        double price = 100;
        int quantity = 5;
        double discount = 0.1;
        double tax = 0.05;

        double total = calculateTotal(price, quantity, discount);
        double taxedTotal = applyTax(total, tax);
        System.out.println("Total price: " + taxedTotal);
    }

    private static double calculateTotal(double price, int quantity, double discount) {
        return price * quantity * (1 - discount);
    }

    private static double applyTax(double total, double tax) {
        return total * (1 + tax);
    }
}
// j2 from 'macros.j2' import header
// {{ header("Parameter Objekt Einführen", "Introduce Parameter Object") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Das Muster "Parameterobjekt einführen" fasst Daten, die häufig gemeinsam in verschiedenen Funktionen auftreten, in einer einzigen Datenstruktur zusammen. Dadurch werden Parameterlisten reduziert und tiefere Änderungen am Code ermöglicht, indem neue Abstraktionen geschaffen werden, die das Verständnis des Anwendungsbereichs vereinfachen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The "Introduce Parameter Object" pattern combines data that often occurs together in different functions into a single data structure. This reduces parameter lists and enables deeper changes to the code by creating new abstractions that simplify understanding of the application domain.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Wenn mehrere Datenelemente häufig gemeinsam in Funktionen auftreten, bilden sie einen Datenklumpen. Das Ersetzen dieses Datenklumpens durch eine einzelne Datenstruktur macht die Beziehung zwischen den Datenelementen explizit, reduziert die Größe von Parameterlisten und verbessert die Konsistenz. Das Einführen eines Parameterobjekts kann dazu führen, dass das Verhalten des Programms neu strukturiert wird, um die neue Struktur zu nutzen, Funktionen zu erstellen, die gemeinsames Verhalten erfassen, und möglicherweise neue Abstraktionen zu bilden, die das Verständnis des Anwendungsbereichs vereinfachen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Motivation
//
// When multiple data elements frequently occur together in functions, they form a data lump. Replacing this data clump with a single data structure makes the relationship between data elements explicit, reduces the size of parameter lists, and improves consistency. Introducing a parameter object can result in restructuring the behavior of the program to take advantage of the new structure, creating functions that capture common behavior, and possibly forming new abstractions that simplify understanding of the application domain.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vorgehen
// - Wenn es noch keine geeignete Struktur gibt, erstelle eine. Verwende vorzugsweise eine Klasse, um das spätere Gruppieren von Verhalten zu erleichtern. Stelle sicher, dass diese Strukturen Wertobjekte sind.
// - Teste den Code.
// - Verwende das Muster "Funktionsdeklaration ändern", um einen Parameter für die neue Struktur hinzuzufügen.
// - Teste den Code.
// - Passe jeden Aufrufer an, um die korrekte Instanz der neuen Struktur zu übergeben. Teste nach jeder Änderung.
// - Ersetze für jedes Element der neuen Struktur die Verwendung des ursprünglichen Parameters durch das Element der Struktur. Entferne den Parameter. Teste den Code.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Procedure
// - If there is no suitable structure yet, create one. Preferably use a class to facilitate grouping of behavior later on. Make sure these structures are value objects.
// - Test the code.
// - Use the "change function declaration" pattern to add a parameter for the new structure.
// - Test the code.
// - Adjust each caller to pass the correct instance of the new structure. Test after each change.
// - For each element of the new structure, replace the use of the original parameter with the element of the structure. Remove the parameter. Test the code.



// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
public class Order {
    public double calculateShippingCost(String destinationCountry, String destinationCity, double weight) {
        // Calculate shipping cost
        return 0.0;
    }
}

// %% tags=["subslide"]
public class ShippingInfo {
    private String destinationCountry;
    private String destinationCity;
    private double weight;

}

public class Order {
    public double calculateShippingCost(ShippingInfo shippingInfo) {
        // Calculate shipping cost
        return 0.0;
    }
}

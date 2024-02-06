// j2 from 'macros.j2' import header
// {{ header("Split Phase", "Split Phase") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Das Muster "Split Phase" besteht darin, Code, der sich mit zwei verschiedenen Dingen befasst, in separate Module aufzuteilen. Die Aufteilung in zwei sequenzielle Phasen ermöglicht es, die beiden Themen getrennt voneinander zu behandeln und Änderungen leichter vorzunehmen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The Split Phase pattern consists of splitting code that deals with two different things into separate modules. Splitting into two sequential phases makes it possible to deal with the two topics separately and make changes more easily.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Das Hauptziel dieses Musters ist es, die Komplexität von Code zu reduzieren und die Wartbarkeit zu verbessern, indem unterschiedliche Aufgaben in separate Module aufgeteilt werden. Dies macht die Unterschiede im Code explizit und erleichtert das Verständnis der verschiedenen Aspekte.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Motivation
//
// The main goal of this pattern is to reduce code complexity and improve maintainability by splitting different tasks into separate modules. This makes the differences in the code explicit and makes it easier to understand the different aspects.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vorgehen
// - Den Code der zweiten Phase in eine eigene Funktion extrahieren.
// - Testen.
// - Eine Zwischendatenstruktur als zusätzliches Argument für die extrahierte Funktion einführen.
// - Testen.
// - Jeden Parameter der extrahierten zweiten Phase untersuchen. Wenn er von der ersten Phase verwendet wird, in die Zwischendatenstruktur verschieben. Nach jedem Verschieben testen.
// - Manchmal sollte ein Parameter nicht von der zweiten Phase verwendet werden. In diesem Fall die Ergebnisse jeder Verwendung des Parameters in ein Feld der Zwischendatenstruktur extrahieren und Move Statements to Callers auf die Zeile anwenden, die es füllt.
// - Extract Function auf den Code der ersten Phase anwenden und die Zwischendatenstruktur zurückgeben.
// - Es ist auch sinnvoll, die erste Phase in ein Transformer-Objekt zu extrahieren.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Procedure
// - Extract the code of the second phase into its own function.
// - Test.
// - Introduce an intermediate data structure as an additional argument for the extracted function.
// - Test.
// - Examine each parameter of the extracted second phase. If it is used by the first phase, move it to the intermediate data structure. Test after each move.
// - Sometimes, a parameter should not be used by the second phase. In this case, extract the results of each use of the parameter into a field of the intermediate data structure, and apply Move Statements to Callers to the line that fills it.
// - Apply Extract Function to the code of the first phase and return the intermediate data structure.
// - It also makes sense to extract the first phase into a transformer object.



// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
public class Order {

}

// %%
public class Item {

}

// %%
void processOrder(Order order, List<Item> items) {
    double totalPrice = 0;
    for (Item item : items) {
        totalPrice += item.getPrice();
    }
    order.setTotalPrice(totalPrice);

    // Weitere Verarbeitung
    order.setStatus(OrderStatus.PROCESSED);
}

// %% tags=["subslide"]
class OrderProcessingData {
    double totalPrice;
}

OrderProcessingData calculateTotalPrice(List<Item> items) {
    double totalPrice = 0;
    for (Item item : items) {
        totalPrice += item.getPrice();
    }
    return new OrderProcessingData(totalPrice);
}

void processOrder(Order order, List<Item> items) {
    OrderProcessingData processingData = calculateTotalPrice(items);
    order.setTotalPrice(processingData.totalPrice);

    // Weitere Verarbeitung
    order.setStatus(OrderStatus.PROCESSED);
}



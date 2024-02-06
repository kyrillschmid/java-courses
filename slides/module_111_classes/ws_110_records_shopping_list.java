// %% [markdown] lang="en" tags=["slide"]
// # Mini-Workshop : ShoppingList Management
// Develop a simple system to manage shopping lists, allowing users to add items, fetch their individual prices, and compute the total price of items in the list.

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop : ShoppingList Management
// Entwickle ein einfaches System zur Verwaltung von Einkaufslisten, das es Benutzern ermöglicht, Artikel hinzuzufügen, ihre einzelnen Preise abzurufen und den Gesamtpreis der Artikel in der Liste zu berechnen.

// %% [markdown] lang="en" tags=["slide"]
// Define a record `LineItem` with the following properties: `name`, `price`, `quantity`.

// %% [markdown] lang="de" tags=["slide"]
// Definiere einen Datensatz `LineItem` mit den folgenden Eigenschaften: `name`, `price`, `quantity`.

// %%
record LineItem(String name, double price, int quantity) { }

// %% [markdown] lang="en" tags=["slide"]
// Define a class `ShoppingList` with the following properties: `items`, `add(item)`, `getTotalPrice()`.

// %% [markdown] lang="de" tags=["slide"]
// Definiere eine Klasse `ShoppingList` mit den folgenden Eigenschaften: `items`, `add(item)`, `getTotalPrice()`.

// %% 
public class ShoppingList {
    private final List<LineItem> items;

    public ShoppingList() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(LineItem item) {
        this.items.add(item);
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(LineItem::price)
                .sum();
    }
}

// %% [markdown] lang="en" tags=["slide"]
// Create a new `ShoppingList` and add some items to it.

// %% [markdown] lang="de" tags=["slide"]
// Erstelle eine neue `ShoppingList` und füge einige Artikel hinzu

// %%
var list = new ShoppingList();
list.addItem(new LineItem("Milk", 1.5, 2));
list.addItem(new LineItem("Bread", 1.0, 3));
list.addItem(new LineItem("Butter", 2.0, 1));

// %% [markdown] lang="en" tags=["slide"]
// Compute the total price of the items in the list.

// %% [markdown] lang="de" tags=["slide"]
// Berechne den Gesamtpreis der Artikel in der Liste

// %%
list.getTotalPrice();



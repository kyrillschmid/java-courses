// j2 from 'macros.j2' import header
// {{ header("For-loops", "For-loops") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Iteration in Java
// 
// In Java kann man mit einer `for`-Schleife iterieren.

// %% [markdown] lang="en" tags=["slide"]
// ## Iteration in Java
//
// In Java, you can iterate with a `for` loop.

// %%
for(int i = 0; i < 5; i++) {
    System.out.println("Number is: " + i);
}

// %% [markdown] lang="de" tags=["subslide"]
// ## Syntax der `for`-Schleife
//
// ```java
// for (<element-var> = <start>; <element-var> < <end>; <element-var>++) {
//     <body>   
// }
// ```

// %% [markdown] lang="en" tags=["subslide"]
// ## Syntax of `for` loops
//
// ```java
// for (<element-var> = <start>; <element-var> < <end>; <element-var>++) {
//     <body>
// }
// ```

// %% [markdown] lang="de" tags=["slide"]
// ## Iteration über Listen
//
// In Java kann man mit der `for-each`-Schleife über Listen iterieren.

// %% [markdown] lang="en" tags=["slide"]
// ## Iteration over lists
//
// In Java, you can iterate over lists using the `for-each` loop.

// %% tags=["subslide", "keep"]
ArrayList<Integer> numberList = new ArrayList<>();
Collections.addAll(numberList, 0, 1, 2, 3, 4);
numberList

// %%
for (Integer number : numberList) {
    System.out.println("Number is: " + number);
}

// %% [markdown] lang="de" tags=["subslide"]
// ## Syntax der `for-each`-Schleife
//
// ```java
// for (<element-var> : <list>) {
//     <body>
// }
// ```

// %% [markdown] lang="en" tags=["subslide"]
// ## Syntax of `for-each` loops
//
// ```java
// for (<element-var> : <list>) {
//     <body>
// }
// ```

// %% [markdown] lang="de" tags=["subslide"]
// ### Mini-Workshop
//
// Schreiben Sie eine Methode `printAll(ArrayList<Integer> items)`, die die Elemente der
// Liste `items` auf dem Bildschirm ausgibt, jeweils ein Element pro Zeile.

// %% [markdown] lang="en"]
// ### Mini workshop
//
// Write a method `printAll(ArrayList<Integer> items)` that prints the elements of a
// list `items` to the screen, one item per line.

// %% tags=["subslide"]
class Printer {
    public static void printAll(ArrayList<Integer> items) {
        for (Integer item : items) {
            System.out.println(item);
        }
    }
}

new Printer().printAll(numberList);

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Workshop: Einkaufsliste
//
// Definieren Sie Variablen
// - `meineEinkaufsliste`, die eine Liste mit den Strings `Tee` und `Kaffee`
//   enthält,
// - `eineAndereEinkaufsliste`, die ebenfalls eine Liste mit den Strings
//   `Tee` und `Kaffee` enthält.

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Workshop: Shopping List
//
// Define variables
// - `myShoppingList`, holding a list of the strings `Tea` and `Coffee`,
// - `anotherShoppingList` also holding a list of the strings `Tea` and `Coffee`.

// %% lang="en"
ArrayList<String> myShoppingList = new ArrayList<>();
Collections.addAll(myShoppingList, "Tea", "Coffee");
ArrayList<String> anotherShoppingList = new ArrayList<>();
Collections.addAll(anotherShoppingList, "Tea", "Coffee");


// %% [markdown] lang="de" tags=["subslide"]
//
// Definieren Sie eine Methode `printShoppingList(ArrayList<String> shoppingList)`, 
// die die als Argument übergebene Einkaufsliste ausdruckt:
//
// ```
// Einkaufsliste:
//   Tee
//   Kaffee
// ```

// %% [markdown] lang="en" tags=["subslide"]
//
// Define a method `printShoppingList(ArrayList<String> shoppingList)`
// that prints the shopping list passed as an argument:
//
// ```
// Shopping List:
//   Tea
//   Coffee
// ```

// %% lang="en"]
class Shopper {
    public static void printShoppingList(ArrayList<String> shoppingList) {
        System.out.println("Shopping List:");
        for (String item : shoppingList) {
            System.out.println("  " + item);
        }
    }
}

new Shopper().printShoppingList(myShoppingList);

// %% [markdown] lang="en" tags=["subslide"]
// Test the method `printShoppingList(ArrayList<String> shoppingList)` with both
// shopping lists.

new Shopper().printShoppingList(anotherShoppingList);

// %% [markdown] lang="en" tags=["subslide"]
//
// Define a method `buy(String product, ArrayList<String> shoppingList)`, that adds `product` to
// `shoppingList`.

// %% lang="en"
class Buyer {
    public static void buy(String product, ArrayList<String> shoppingList) {
        shoppingList.add(product);
    }
}

new Buyer().buy("Butter", myShoppingList);
new Buyer().buy("Bread", myShoppingList);

// %% [markdown] lang="en" tags=["subslide"]
// Print out both shopping lists again.

// %%
new Shopper().printShoppingList(myShoppingList);
new Shopper().printShoppingList(anotherShoppingList);

// %% [markdown] lang="en" tags=["subslide"]
//
// What happens when you add `Butter` and `Bread` to the shopping list
// again?

// %%
new Buyer().buy("Butter", myShoppingList);
new Buyer().buy("Bread", myShoppingList);
new Shopper().printShoppingList(myShoppingList);



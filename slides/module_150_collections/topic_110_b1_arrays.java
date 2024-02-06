// j2 from 'macros.j2' import header
// {{ header("Arrays", "Arrays") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
//
// - Wir können mittlerweile Programme schreiben, die viele Arten von Berechnungen ausführen, 
//   aber wir haben noch keine Möglichkeit, mehrere Objekte zusammenzufassen.
// - Wenn wir beispielsweise eine Einkaufsliste erstellen wollen, müssen wir uns im Moment 
//   mit folgender Lösung behelfen:

// %% lang="de" tags=["keep"]
String produkt1 = "Haferflocken";
String produkt2 = "Kaffeebohnen";
String produkt3 = "Orangenmarmelade";

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Motivation
//
// - We can now write programs that perform many kinds of calculations, 
//   but we don't yet have a way to combine multiple objects.
// - If we want to create a shopping list, for example, 
//   we currently have to use the following solution:

// %% lang="en" tags=["keep"]
String product1 = "oatmeal";
String product2 = "coffee beans";
String product3 = "orange marmalade";

// %% [markdown] lang="de" tags=["subslide"]
//
// Diese Vorgehensweise hat viele Probleme:
//
// - Wir müssen genau wissen, wie viele Produkte wir kaufen wollen
// - Es gibt keine Möglichkeit Operationen auf allen Produkten auszuführen,
//   z.B. alle Produkte auszudrucken
// - Java weiß nicht, dass die Produkte zusammengehören
// - ...

// %% [markdown] lang="en" tags=["subslide"]
//
// This approach has many problems:
//
// - We need to know exactly how many products we want to buy
// - There is no way to perform operations on all products, e.g. print all products
// - Java does not know that the products belong together
// - ...

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Die Lösung: Arrays

// %% [markdown] lang="en" tags=["subslide"]
//
// ## The solution: Arrays

// %% [markdown] lang="de" tags=["subslide"]
// ## Erzeugen von Arrays
// - Deklaration und Erzeugen mit new: 
//  ```java
//  Datentyp[] name = new Datentyp[Anzahl];
//  ```

// %% [markdown] lang="en" tags=["subslide"]
// ## Creating Arrays
// - Declaration and creation with new:
//  ```java
//  Datentyp[] name = new Datentyp[Anzahl];
//  ```

// %% lang="de"
String[] einkaufsliste = new String[3];

// %% lang="en"
String[] shoppingList = new String[3];

// %% [markdown] lang="de" tags=["subslide"]
// ## Schreiben und Lesen von Arrays
// - Schreiben mit `[]`:
//  ```java
// // Schreiben
//  name[Position] = Wert;
// // Lesen
//  Wert = name[Position];
//  ```

// %% [markdown] lang="en" tags=["subslide"]
// ## Writing and reading from Arrays
// - Access with `[]`:
//  ```java
//  // Writing
//  name[Position] = Wert;
//
//  // Reading
//  Wert = name[Position];
//  ```

// %% lang="de"
einkaufsliste[0] = "Haferflocken";

// %% lang="en"
shoppingList[0] = "oatmeal";

// %% lang="de"
einkaufsliste[0];

// %% lang="en"
shoppingList[0];

// %% [markdown] lang="de" tags=["subslide"]
// Möchte man die Werte eines Arrays direkt bei der Initialisierung angeben,
// kann mit geschweiften Klammern angegeben werden:

// %% [markdown] lang="en" tags=["subslide"]
// If you want to specify the values directly at the time of initialization,
// you can specify them with curly brackets:

// %% lang="de"
String[] einkaufsliste = {"Haferflocken", "Kaffeebohnen", "Orangenmarmelade"};

// %% lang="en"
String[] shoppingList = {"oatmeal", "coffee beans", "orange marmalade"};

// %% lang="de"
einkaufsliste[0];

// %% lang="en"
shoppingList[0];

// %% [markdown] lang="de" tags=["subslide"]
// Die Anzahl der Elemente eines Arrays sind nach dessen Definition nicht mehr veränderbar!
//  - Statische Datenstruktur mit fester Länge!

// %% [markdown] lang="en" tags=["subslide"]
// The number of elements in an array is not changeable!
//  - Static data structure with fixed length!

// %% lang="de"
einkaufsliste[3] = "Milch"; // Fehler!

// %% lang="en"
shoppingList[3] = "milk"; // Error!

// %% [markdown] lang="de" tags=["subslide"]
// ## Array-Elemente ausgeben
//
// Wie können alle Elemente eines Arrays ausgegeben werden, 
// ohne den erlaubten Bereich zu verlassen?

// %% [markdown] lang="en" tags=["subslide"]
// ## Outputting array elements
//
// How can we output all elements of an array without leaving the allowed range?

// %% [markdown] lang="de" tags=["subslide"]
// Jedes Array besitzt festes Attribut .length

// %% [markdown] lang="en" tags=["subslide"]
// Each array has a .length attribute

// %%  lang="de"
einkaufsliste.length;

// %%  lang="en"
shoppingList.length;

// %% [markdown] lang="de" tags=["subslide"]
// Damit können Schleifen programmiert werden, die den Bereich nicht verlassen

// %% [markdown] lang="en" tags=["subslide"]
// We can use the `.length`-attribute to prevent loops from leaving the allowed range

// %% lang="de"
for (int i = 0; i < einkaufsliste.length; i++) {
    System.out.println(einkaufsliste[i]);
}

// %% lang="en"
for (int i = 0; i < shoppingList.length; i++) {
    System.out.println(shoppingList[i]);
}

// %% [markdown] lang="de" tags=["subslide"]
// ## For-Each-Schleife
// Java bietet zusätzlich eine For-Each-Schleife:

// %% [markdown] lang="en" tags=["subslide"]
// ## For-Each Loop
// Java additionally provides a For-Each Loop:

// %% lang="de"
for (String produkt : einkaufsliste) {
    System.out.println(produkt);
}

// %% lang="en"
for (String product : shoppingList) {
    System.out.println(product);
}

// %% [markdown] lang="de" tags=["subslide"]
// ## Mehrdimensionale Arrays
// - Die Elemente eines Arrays können ebenfalls wieder Arrays sein

// %% [markdown] lang="en" tags=["subslide"]
// ## Multidimensional Arrays
// - The elements of an array can also be arrays

// %% [markdown] lang="de" tags=["subslide"]
// Beispiel: 2-Dimensionales Array:

// %% [markdown] lang="en" tags=["subslide"]
// Example: 2-Dimensional array:

// %% tags=["keep"]
int[][] matrix = {
    {1, 2, 3}, // Row 0
    {4, 5, 6}, // Row 1
    {7, 8, 9}  // Row 2
};

// %% 
matrix[0][0]

// %% 
matrix[1][1]

// %% [markdown] lang="de" tags=["subslide"]
// Das entspricht einer Matrix mit 3 Zeilen und 3 Spalten:
// Visualisiert:
| Array Index | Column 0 | Column 1 | Column 2 |
|-------------|----------|----------|----------|
| Row 0       | 1        | 2        | 3        |
| Row 1       | 4        | 5        | 6        |
| Row 2       | 7        | 8        | 9        |

// %% [markdown] lang="en" tags=["subslide"]
// It corresponds to a matrix with 3 rows and 3 columns:
// Visualized:
| Array Index | Column 0 | Column 1 | Column 2 |
|-------------|----------|----------|----------|
| Row 0       | 1        | 2        | 3        |
| Row 1       | 4        | 5        | 6        |
| Row 2       | 7        | 8        | 9        |

// %% [markdown] lang="de" tags=["subslide"]
// Beispiel: 3-Dimensionales Array:

// %% [markdown] lang="en" tags=["subslide"]
// Example: 3-Dimensional array:

// %% tags=["keep"]
int[][][] image = {
    {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    },
    {
        {10, 11, 12},
        {13, 14, 15},
        {16, 17, 18}
    },
    {
        {19, 20, 21},
        {22, 23, 24},
        {25, 26, 27}
    }
};

// %% [markdown] lang="de" tags=["subslide"]
// Zugriff auf ein Element:

// %% [markdown] lang="en" tags=["subslide"]
// Accessing an element:

// %%
image[1][2][1];

// %% [markdown] lang="de" tags=["subslide"]
// Die innere Länge der Arrays kann variieren:

// %% [markdown] lang="en" tags=["subslide"]
// The inner lengths of the arrays can vary:

// %% tags=["keep"]
int[][] myArray = new int[3][];
myArray[0] = new int[]{1};
myArray[1] = new int[]{1, 2};
myArray[2] = new int[]{1, 2, 3};

// %% tags=["keep"]
System.out.println(myArray[0].length);
System.out.println(myArray[1].length);
System.out.println(myArray[2].length);

// %% [markdown] lang="de" tags=["subslide"]
// Das entspricht einer Matrix mit 3 Zeilen:
// - Die erste Zeile 1 Element besitzt
// - Die zweite Zeile 2 Elemente besitzt
// - Die dritte Zeile 3 Elemente besitzt
| Array Index | Column 0 | Column 1 | Column 2 |
|-------------|----------|----------|----------|
| Row 0       | 1        | -        | -        |
| Row 1       | 1        | 2        | -        |
| Row 2       | 1        | 2        | 3        |

// %% [markdown] lang="en" tags=["subslide"]
// It corresponds to a matrix with 3 rows:
// - The first row has 1 element
// - The second row has 2 elements
// - The third row has 3 elements
| Array Index | Column 0 | Column 1 | Column 2 |
|-------------|----------|----------|----------|
| Row 0       | 1        | -        | -        |
| Row 1       | 1        | 2        | -        |
| Row 2       | 1        | 2        | 3        |



// %% [markdown] lang="de" tags=["subslide"]
// Die Länge des äußeren Arrays muss angebenen werden:

// %% [markdown] lang="en" tags=["subslide"]
// The length of the outer array must be specified:

// %%
int[][] a = new int[10][];

// %% [markdown] lang="de" tags=["subslide"]
// ## Iteration mehrdimensionaler Arrays

// %% [markdown] lang="en" tags=["subslide"]
// ## Iteration of multidimensional arrays

// %% tags=["keep"]
// for-loop
for (int x = 0; x < matrix.length; x++) {
    for(int y = 0; y < matrix[x].length; y++) {
        System.out.println("Array-Element: " + matrix[x][y]);
    }
}

// %% tags=["keep"]
// foreach
for (int[] row : matrix) {
    for (int element : row) {
        System.out.println("Array-Element: " + element);
    }
} 

// %% [markdown] lang="de" tags=["subslide"]
// ## Mini-Workshop: Arrays
// 
// - Schreiben Sie eine Funktion `getMittelwert(double[] temperaturen)`, die den Mittelwert eines als Argument 
//  uebergebenen Arrays berechnet.

// %% [markdown] lang="en" tags=["subslide"]
// ## Mini-Workshop: Arrays
//
// - Write a function `getMean(double[] temperatures)` that calculates the average of an array passed as a argument.


// %% tags=["keep"]
getMean(new double[] { 1.0, 2.0, 3.0 });

// %%
public double getMean(double[] temperatures) {

    if (temperatures.length == 0) {
        return 0.0; 
    }
    double sum = 0; 
    for (int i = 0; i < temperatures.length; i++) {
        sum = sum + temperatures[i]; 
    }
    return sum / temperatures.length;
}

// %%
getMean(new double[] { 1.0, 2.0, 3.0 });



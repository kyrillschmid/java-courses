// j2 from 'macros.j2' import header
// {{ header("Funktionen in Transformation kombinieren", "Combine Functions into Transform") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Das Muster "Combine Functions into Transform" besteht darin, mehrere Funktionen, die abgeleitete Informationen aus gemeinsamen Daten berechnen, in eine einzige Transformationsfunktion zu integrieren. Diese Funktion nimmt die Ausgangsdaten als Eingabe und berechnet alle abgeleiteten Werte, die dann in den Ausgangsdaten gespeichert werden.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The Combine Functions into Transform pattern consists of integrating multiple functions that compute derived information from common data into a single transform function. This function takes the output data as input and calculates all derived values, which are then stored in the output data.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Das Hauptziel dieses Musters ist es, Duplikationen in der Logik zur Berechnung abgeleiteter Daten zu vermeiden und einen konsistenten Ort für die Verwaltung dieser Funktionen zu schaffen. Die Verwendung einer Transformationsfunktion erleichtert das Auffinden und Aktualisieren der Berechnungen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Motivation
//
// The main goal of this pattern is to avoid duplications in the logic for calculating derived data and to provide a consistent place for managing these functions. The use of a transformation function makes it easier to find and update the calculations.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vorgehen
// - Eine Transformationsfunktion erstellen, die den zu transformierenden Datensatz entgegennimmt und die gleichen Werte zurückgibt.
// - In der Regel wird eine tiefe Kopie des Datensatzes benötigt. Es ist oft sinnvoll, einen Test zu schreiben, um sicherzustellen, dass die Transformation das Original nicht verändert.
// - Eine Logik auswählen und ihren Körper in die Transformationsfunktion verschieben, um ein neues Feld im Datensatz zu erstellen. Den Client-Code ändern, um auf das neue Feld zuzugreifen.
// - Bei komplexer Logik zuerst Extract Function verwenden.
// - Testen.
// - Wiederholen Sie den Vorgang für die anderen relevanten Funktionen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Procedure
// - Create a transformation function that takes in the dataset to be transformed and returns the same values.
// - Typically, a deep copy of the dataset is needed. It is often useful to write a test to ensure that the transformation does not modify the original.
// - Choose a logic and move its body into the transformation function to create a new field in the dataset. Change the client code to access the new field.
// - For complex logic, use Extract Function first.
// - Test.
// - Repeat the process for the other relevant functions.


// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
class UserData {
    String name;
    int age;
}

int calculateYearsToRetirement(UserData user) {
    int retirementAge = 65;
    return retirementAge - user.age;
}

String createGreeting(UserData user) {
    return "Hello, " + user.name + "! You have " + calculateYearsToRetirement(user) + " years until retirement.";
}

// %% tags=["subslide"]
class UserData {
    String name;
    int age;
    int yearsToRetirement;
    String greeting;

    UserData(String name, int age) {
        this.name = name;
        this.age = age;
        this.yearsToRetirement = calculateYearsToRetirement();
        this.greeting = createGreeting();
    }

    int calculateYearsToRetirement() {
        int retirementAge = 65;
        return retirementAge - this.age;
    }

    String createGreeting() {
        return "Hello, " + this.name + "! You have " + this.yearsToRetirement + " years until retirement.";
    }
}



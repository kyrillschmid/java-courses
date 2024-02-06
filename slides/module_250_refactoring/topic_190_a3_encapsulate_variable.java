// j2 from 'macros.j2' import header
// {{ header("Variable Kapseln", "Encapsulate Variable") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Das Muster "Kapseln von Variablen" besteht darin, den Zugriff und die Aktualisierung einer Variable über Funktionen zu steuern, um die Wartbarkeit und Flexibilität des Codes zu verbessern. Dies ermöglicht es, Änderungen an der Variable besser zu überwachen und Validierung oder zusätzliche Logik bei Aktualisierungen hinzuzufügen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The "encapsulating variables" pattern consists of controlling access and updating of a variable via functions to improve maintainability and flexibility of the code. This makes it possible to better monitor changes to the variable and add validation or additional logic to updates.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Daten sind schwerer zu manipulieren als Funktionen, besonders wenn der Zugriff auf die Daten breit gestreut ist. Durch das Kapseln von Variablen können Änderungen an Daten auf die einfachere Aufgabe der Umorganisation von Funktionen reduziert werden. Das Kapseln von Daten ist auch wertvoll für das Hinzufügen von Validierung oder Logik bei Aktualisierungen und das Reduzieren der Kopplung von weit verbreiteten Daten. Bei Objektorientierung liegt der Schwerpunkt auf der Privatsphäre der Daten eines Objekts, weshalb das Kapseln von Variablen eine wichtige Praktik ist.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Motivation
//
// Data is harder to manipulate than functions, especially when access to the data is widely distributed. Encapsulating variables can reduce changes to data to the simpler task of reorganizing functions. Encapsulating data is also valuable for adding validation or logic to updates and reducing coupling of widely distributed data. With object orientation, the focus is on the privacy of an object's data, so encapsulating variables is an important practice.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vorgehen
// - Erstellen Sie kapselnde Funktionen, um auf die Variable zuzugreifen und sie zu aktualisieren.
// - Führen Sie statische Überprüfungen durch.
// - Ersetzen Sie für jede Referenz auf die Variable den Zugriff durch einen Aufruf der entsprechenden kapselnden Funktion. Testen Sie nach jeder Ersetzung.
// - Beschränken Sie die Sichtbarkeit der Variable.
// - Manchmal ist es nicht möglich, den Zugriff auf die Variable zu verhindern. In diesem Fall kann es nützlich sein, verbleibende Referenzen durch Umbenennen der Variable und Testen zu erkennen.
// - Testen Sie den Code.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Procedure
// - Create encapsulating functions to access and update the variable.
// - Perform static checks.
// - For each reference to the variable, replace the access with a call to the corresponding encapsulating function. Test after each replacement.
// - Limit the visibility of the variable.
// - Sometimes it is not possible to prevent access to the variable. In this case, it may be useful to detect remaining references by renaming the variable and testing.
// - Test the code.



// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
public class Person {
    public String name;
}

// %% tags=["subslide"]
Person somePerson = new Person();
// Zugriff auf die Variable
String personName = somePerson.name;

// %% tags=["subslide"]
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// %% tags=["subslide"]
Person somePerson = new Person();
// Zugriff auf die Variable über kapselnde Funktionen
String personName = somePerson.getName();
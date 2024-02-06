// j2 from 'macros.j2' import header
// {{ header("Funktionen in Klasse kombinieren", "Combine Functions into Class") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Das Muster "Combine Functions into Class" besteht darin, eine Gruppe von Funktionen, die eng zusammenarbeiten und gemeinsame Daten verwenden, in eine Klasse zu integrieren. Dies verbessert die Übersichtlichkeit, reduziert die Anzahl der benötigten Argumente in Funktionsaufrufen und ermöglicht das einfache Weitergeben des Objekts an andere Systemteile.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The Combine Functions into Class pattern consists of integrating a group of functions that work closely together and share common data into a class. This improves clarity, reduces the number of arguments required in function calls, and allows the object to be easily passed to other parts of the system.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Das Hauptziel dieses Musters ist es, die Organisation und Zusammenarbeit von Funktionen, die eng miteinander in Bezug auf gemeinsame Daten arbeiten, zu verbessern. Durch die Verwendung einer Klasse wird die gemeinsame Umgebung, die diese Funktionen teilen, expliziter und einfacher zu verwalten.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Motivation
//
// The main goal of this pattern is to improve the organization and collaboration of functions that work closely together on shared data. By using a class, the common environment that these functions share becomes more explicit and easier to manage.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vorgehen
// - Encapsulate Record auf das gemeinsame Datenrecord anwenden.
// - Falls die gemeinsamen Daten noch nicht in einer Recordstruktur gruppiert sind, Introduce Parameter Object verwenden, um sie zu gruppieren.
// - Jede Funktion, die das gemeinsame Record verwendet, mit Move Function in die neue Klasse verschieben.
// - Argumente aus der Argumentliste entfernen, die bereits Mitglieder der Klasse sind.
// - Logikabschnitte, die die Daten bearbeiten, mit Extract Function extrahieren und in die neue Klasse verschieben.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Vorgehen
// - Apply Encapsulate Record to the shared data record.
// - If the shared data is not yet grouped into a record structure, use Introduce Parameter Object to group them.
// - Move each function that uses the shared record to the new class with Move Function.
// - Remove arguments from the argument list that are already members of the class.
// - Extract logic sections that manipulate the data with Extract Function and move them to the new class.



// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
class User {
    String name;
    int age;
}

void updateUserAge(User user, int age) {
    user.age = age;
}

void printUserDetails(User user) {
    System.out.println("Name: " + user.name + ", Age: " + user.age);
}

// %% tags=["subslide"]
class User {
    String name;
    int age;

    void updateAge(int age) {
        this.age = age;
    }

    void printDetails() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
}



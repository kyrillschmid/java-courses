// j2 from 'macros.j2' import header
// {{ header("Einführung in objektorientierte Programmierung ", "Introdcution to object oriented programming") }}

// %% [markdown] lang="de" tags=["slide"]
// # Objektorientierte Programmiersprachen
// * Eigenschaften (Daten) und Verhalten (Funktionen / Methoden) werden in Objekten gekapselt
// * Im Gegensatz zu prozeduralen Sprachen (Daten und Funktionen sind separiert) 

// %% [markdown] lang="de" tags=["subslide"]
// # Was ist eine Klasse?
// - Eine Klasse ist eine Blaupause für die Erzeugung von Objekten dieser Klasse
// - Sie definiert die Eigenschaften und das Verhalten ihrer Objekte
// - Jedes Objekt hat die Eigenschaften und das Verhalten seiner Klasse

// %% [markdown] lang="de" tags=["subslide"]
// # Klasse Student
// - Die Klasse Student beschreibt Studenten
// - **Eigenschaften:** Name, Studiengang, Matrikelnummer, ...
// - **Verhalten:** Prüfung anmelden, abmelden, ...

// %% [markdown] lang="de" tags=["subslide"]
// # Klasse Student: Java Code

// %% tags=["keep"]
public class Student {
    String name;         // String speichert Zeichenketten z.B. Namen, Texte, Beschreibung, ...
    String studiengang;  
    int matrikelnummer;  // int speichert ganze Zahlen
}


// %% [markdown] lang="de" tags=["subslide"]
// # Mini-Workshop : Klasse Auto
// - Implementieren Sie eine Klasse `Auto` analog zur Klasse Student mit folgenden Eingeschaften:
// - Markenname (String)
// - Modell(String)
// - Farbe(String)
// - PS(int)
// %% tags=["start"]
public class Auto {
}

// %% tags=["alt"]
public class Auto {
    String marke;
    String modell;
    String farbe;
    int ps;
}

// %% [markdown] lang="de" tags=["subslide"]
// # Mini-Workshop: Klasse Buch
// - Analog zu der Klasse Student: Programmieren Sie die Klasse Buch
// - **Eigenschaften:** Titel(String), Autor(String), Seitenzahl(int), ...

// %% tags=["start"]
public class Buch {
   
}

// %% tags=["alt"]
public class Buch {
    String titel;
    String autor;
    int seitenzahl;
}
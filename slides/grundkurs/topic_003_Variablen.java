// j2 from 'macros.j2' import header
// {{ header("Variablen", "Variables") }}

// %% [markdown] lang="de" tags=["slide"]
// # Variablen
//
// Wir wollen einen Zaun um unser neues Grundstück bauen.
//
// <img src="img/fence.svg" style="display:block;margin:auto;width:40%"/>

// %% [markdown] lang="en" tags=["slide"]
// # Variables
//
// We want to build a fence around our new property.
//
// <img src="img/fence.svg" style="display:block;margin:auto;width:40%"/>

// %% [markdown] lang="de" tags=["subslide"]
// <img src="img/fence.svg"
//  style="vertical-align:top;overflow:auto;float:right;width:30%"/>
//
// Die gemessenen Längen sind:
// - Birkenweg: 20m
// - Fichtengasse: 30m
//
// Wie lange muss unser Zaun sein?

// %% [markdown] lang="en"
// <img src="img/fence.svg"
//   style="vertical-align:top;overflow:auto;float:right;width:35%"/>
//
// The measured lengths are:
// - Birkenweg: 20m
// - Fichtengasse: 30m
//
// How long does our fence have to be?

// %%
20 + 30 + Math.sqrt((20*20 + 30*30));

// %% [markdown] lang="de" tags=["slide"]
// # Variablen

// %% [markdown] lang="en" tags=["slide"]
// # Variables

// %%
float laengeBirkenweg = 20;
float laengeFichtengasse = 30; 

// %%
float laengeHauptstrasse = (int) Math.sqrt(laengeBirkenweg * laengeBirkenweg + laengeFichtengasse * laengeFichtengasse);
float laengeGesamt = laengeBirkenweg + laengeFichtengasse + laengeHauptstrasse;
float ergebnis = laengeGesamt;

// %% [markdown] lang="de" tags=["subslide"]
// # Eigenschaften von Variablen
// - Variable hat einen **Typ** und einen **Namen** 
//      - Gespeicherter Wert muss zum Typ der Variable passen
//      - Man sagt Java ist statisch typisiert

// %% [markdown] lang="en" tags=["subslide"]
// # Properties of variables
// - Variable has a **type** and a **name**
//      - Stored value must match the type of the variable
//      - Java is said to be statically typed

// %% tags=["keep"]
int laengeBirkenweg = 20;

// %%
laengeBirkenweg = "20"; // Compilerfehler

// %% [markdown] lang="de" tags=["subslide"]
// Variablen Können primitive Datentypen und komplexe Objekte referenzieren
// - Werte von primitiven Datentypen werden direkt in der Variable gespeichert
// - Werte von komplexen Objekten werden in einem anderen Speicherbereich gespeichert und die Variable referenziert diesen Speicherbereich

// %% [markdown] lang="en" tags=["subslide"]
// Variables can reference primitive data types and complex objects
// - Values of primitive data types are stored directly in the variable
// - Values of complex objects are stored in a different memory area and the variable references this memory area

// %%
int laengeBirkenweg = 20;

// %%
String strasse = "Birkenweg";

// %% [markdown] lang="de" tags=["subslide"]
// # Variablenname Regeln
// - Name darf nicht mit einer Zahl beginnen
// - Darf keine Leerzeichen enthalten
// - Darf keine Sonderzeichen enthalten außer _ und $
// - Darf nicht mit einem Java Schlüsselwort übereinstimmen

// %% [markdown] lang="en" tags=["subslide"]
// # Variable name rules
// - Name must not start with a number
// - Must not contain spaces
// - Must not contain special characters except _ and $
// - Must not match a Java keyword

// %%
int 7orangenSaftGlas = 100;

// %% [markdown] lang="de" tags=["subslide"]
// # Java-(Clean Code)-Konventionen

// %% [markdown] lang="en" tags=["subslide"]
// # Java (Clean Code) Conventions

// %% [markdown] lang="de" tags=["subslide"]
// Camel Case

// %% [markdown] lang="en" tags=["subslide"]
// Camel Case

// %%
int orangenSaftGlas = 100;    // Java Style: Camel Case

// %% [markdown] lang="de" tags=["subslide"]
// Aussagekräftige Namen wählen

// %% [markdown] lang="en" tags=["subslide"]
// Choose meaningful names

// %% tags=["keep"]
// Elapsed time in days
int d = 0;

// %%
// better
int elapsedTimeInDays = 0;

// j2 include "ws_130_pirates.java"
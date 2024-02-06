// %% [markdown] lang="de" tags=["slide"]
// ## Mini-Workshop: Piraten
//
// Der Legende nach wurde die Beute bei Piratenbanden gerecht durch alle Piraten
// geteilt. Falls sich die Beute sich nicht gerecht aufteilen ließ erhielt der
// Kapitän den überschüssigen Anteil.
//
// Wie viele Golddublonen erhält jeder Pirat einer 8-köpfigen Bande
// (7 Piraten + 1 Kapitän), wenn ein Schatz mit 1000 Golddublonen erbeutet wurde?
//
// (Verwenden Sie Variablen um die Berechnung klarer zu machen.)

// %% [markdown] lang="en" tags=["slide"]
// ## Mini-Workshop: Pirates
//
// According to legend, the booty in pirate gangs was divided fairly amongst all
// pirates. If the booty could not be shared fairly, the captain received the excess
// share.
//
// How many gold doubloons does each pirate in a gang of 8 (7 pirates + 1 captain) get
// when looting a treasure with 1000 gold doubloons?
//
// (Use variables to make the calculation clearer.)

// %% lang="de" tags=["subslide"]
int anzahlPiraten = 8;
int beuteGesamt = 1000;
int beuteProPirat = beuteGesamt / anzahlPiraten;
beuteProPirat

// %% lang="en" tags=["subslide"]
int numberOfPirates = 8;
int totalBooty = 1000;
int bootyPerPirate = totalBooty / numberOfPirates;
bootyPerPirate

// %% [markdown] lang="de"
// Wie viele Golddublonen erhält der Kapitän extra?

// %% [markdown] lang="en"
// How many extra gold doubloons does the captain get?

// %% lang="de"
int beuteKapitän = beuteGesamt % anzahlPiraten;
beuteKapitän

// %% lang="en"
int captainBooty = totalBooty % numberOfPirates;
captainBooty

// %% [markdown] lang="de"
// Die Piratenbande nimmt 3 neue Piraten-Lehrlinge auf.
//
// Wie verändert sich die Aufteilung der Beute?
//
// (Verwenden Sie Zuweisungen an die existierenden Variablen um das Problem zu
// lösen.)

// %% [markdown] lang="en"
// The pirate gang takes on 3 new pirate apprentices.
//
// How does the distribution of the loot change?
//
// (Use assignments to the existing variables to solve the problem.)

// %% lang="de"
int anzahlPiraten = 11;  // besser, falls die Zelle evtl. mehrmals ausgewertet wird
beuteProPirat = beuteGesamt / anzahlPiraten;
beuteProPirat

// %% lang="en"
int numberOfPirates = 11;  // better, if the cell is evaluated multiple times
bootyPerPirate = totalBooty / numberOfPirates;
bootyPerPirate

// %% [markdown] lang="de"
// Wie viele Golddublonen erhält der Kapitän in diesem Fall zusätzlich?

// %% [markdown] lang="en"
// In this case, how many additional gold doubloons does the captain receive?

// %% lang="de"
beuteKapitän = beuteGesamt % anzahlPiraten;
beuteKapitän

// %% lang="en"
captainBooty = totalBooty % numberOfPirates;
captainBooty


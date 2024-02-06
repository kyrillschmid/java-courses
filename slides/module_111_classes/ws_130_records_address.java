// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop : Nutzer-Eingaben verarbeiten
//
// Records können gut genutzt werden, um komplexe Objekterzeugungsprozesse zu kapseln.
// - Wir wollen eine Adresse aus Kundeneingaben erzeugen
// - Zunächst sind die Eingaben nicht validiert und u.U. unvollständig
// - Records können hier helfen, die Validierung zu kapseln und die Erzeugung von Zwischenzuständen zu modellieren
// - Dadurch haben wir später weniger Fehler bei der Verwendung einer Adresse

// %% [markdown] lang="de" tags=["slide"]
// - Modelliere zunächst die Kunden-Eingabe als Record `NichtValidierteAdresse` mit folgenden Feldern:
// - `strasse`, `hausnummer`, `plz`, `stadt`, `etage`

// %% 
record NichtValidierteAdresse(String strasse, String hausnummer, String plz, String stadt, String etage) {}

// %% [markdown] lang="de" tags=["slide"]
// - Erstelle ebenfalls eine Adresse, die bereits validiert wurde als Record `Adresse` mit folgenden Feldern:
// - `strasse`, `hausnummer`, `plz`, `stadt`, `etage`

// %%
record Adresse(String strasse, String hausnummer, String plz, String stadt, String etage) {}

// %% [markdown] lang="de" tags=["slide"]
// - Modelliere einen Empfänger als Record `Empfänger` mit folgenden Feldern:
// - `name`, `adresse`, `bevorzugteZustelldienste` (Liste von Strings)

// %%
record Empfänger(String name, Adresse adresse, List<String> bevorzugteZustelldienste) {}

// %% [markdown] lang="de" tags=["slide"]
// - Modelliere die Validierung einer NichtValidiertenAdresse als Klasse `AdresseService`
// - Mit folgenden Methoden:
//   - `Adresse validiere(NichtValidierteAdresse adresse)` zum Validieren einer Adresse
//      * hier können verschiedene Prüfungen durchgeführt werden, z.B. ob die PLZ korrekt ist
// - `Empfänger anreichern(String name, Adresse adresse)` zum Erzeugen eines Empfängers aus einem Namen und einer Adresse

// %%
final class AdresseService {
    Adresse validiere(NichtValidierteAdresse adresse) {
        if (new Random().nextBoolean()) {
            return new Adresse(adresse.strasse(), adresse.hausnummer(), adresse.plz(), adresse.stadt(), adresse.etage());
        } else {
            return new Adresse("x" + adresse.strasse(), "x" + adresse.hausnummer(), adresse.plz(), "x" + adresse.stadt(), adresse.etage());
        }
    }
    Empfänger anreichern(String name, Adresse adresse) {
        if (adresse.stadt().length() > 5) {
            return new Empfänger(name, adresse, List.of("Postauto GmbH", "Fahrradkurier Service GmbH"));
        } else {
            return new Empfänger(name, adresse, List.of("Postkutsche GmbH"));
        }
    }
}

// %% [markdown] lang="de" tags=["slide"]
// Angeommen wir haben folgende Kunden-Eingaben:

// %% tags=["keep"]
var kundenEingabeName = "Lieschen Müller";
var kundenEingabeAdresse = new NichtValidierteAdresse("str", "1a", "12345", "stadt", "");

// %% [markdown] lang="de" tags=["slide"]
// Durchlaufe Sie alle oben modellierten Schritte, um einen Empfänger zu erzeugen.

// %%
var adressService = new AdresseService();

// %%
var validierteAdresse = adressService.validiere(kundenEingabeAdresse);        

// %%
var empfänger = adressService.anreichern(kundenEingabeName, validierteAdresse);

// %%
empfänger

// %% [markdown] lang="de" tags=["slide"]
// Zusammenfassung:
// * Im Code ist durch die verwendeten Klassen klar, ob Objekte validiert bzw. für weitere Verwendung bereit sind oder nicht.
// * Es wird verhindert ```AdresseService.anreichern``` mit einer nicht-validierten Adresse (```NichtValidierteAdresse```) aufzurufen.
//   * Wenn der Aufruf von ```AdresseService.anreichern``` mit Kosten verbunden wäre, könnten hierdurch bereits kosten eingespart werden.
//   * *Das Klassendesign ermöglicht auch fachfremden Programmieren eine korrekte Nutzung des Systems*.
//   * Automatisch genierte Dokumentation aus Code ([javadoc](https://en.wikipedia.org/wiki/Javadoc), [doxygen](https://en.wikipedia.org/wiki/Doxygen)) zeigt korrekte Verwendung. Keine zustätzliche Dokumentation zur korrekten Verwendung notwendig.
//   * Klassendesign erleichtert zusammenarbeit über teamgrenzen hinweg.
//   * Stichworte: Featureteam, Cross-Functional-Teams, Whole-Product-Focus



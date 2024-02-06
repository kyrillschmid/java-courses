// j2 from 'macros.j2' import header
// {{ header("Einführung", "Introduction") }}

// %% [markdown] lang="de" tags=["slide"]
// # Der Java Entwicklungsprozess
// * Die Programmiersprache Java wird kontinuierlich durch den Java Community Process (JCP) weiterentwickelt
// * Durch die Weiterentwicklung gelingt es Java weiterhin unter den beliebtesten Sprachen zu bleiben
// * Viele große und komplexe System sind in Java geschrieben
// * Durch kontinuierliches Refactoring und Redesign kann von den Neuerungen profitiert werden
//
// <p align="center">
//   <img src="img/statistic__beliebteste-programmiersprachen-weltweit-laut-pypl-index-im-august-2023--snipp.png" alt="PYPL: Beliebteste Programmiersprachen der Welt - August 2023">
// </p>
// <p align="center">PYPL: Beliebteste Programmiersprachen der Welt - August 2023</p>


// %% [markdown] lang="en" tags=["slide"]
// * The Java programming language is continuously developed through the JCP process.
// * Through this development, Java continues to remain among the most popular languages.
// * Many large and complex systems are written in Java.
// * Continuous refactoring and redesign can benefit from the new features.
//
// ![PYPL: Most popular programming languages in the world - August 2023](img/statistic__beliebteste-programmiersprachen-weltweit-laut-pypl-index-im-august-2023--snipp.png "PYPL: Most popular programming languages in the world - August 2023")
//
// PYPL: Most popular programming languages in the world - August 2023

// %% [markdown] lang="de" tags=["slide"]
// # Releasezyklus
// * Vor Java 9 gab es keinen festen Takt oder Release-Zyklus
// * Stattdessen war die Veröffentlichung von Java-Versionen an die Fertigstellung von Features gebunden
// * Um bessere Planbarkeit zu erreichen wurde der Java-Entwicklungsprozess auf einen festen Rhythmus umgestellt.

// %% [markdown] lang="de" tags=["notes"]
// * Durch das Warten auf Features verzögerte sich die Veröffentlichung von Java-Versionen oftmals
// * Nicht finalisierte Features werden nicht aufgenommen (Preview-Features, Incubator-Features)

// %% [markdown] lang="de" tags=["slide"]
// ## Preview-Features
// - Preview-Features: vollständig spezifiziert & implementiert
// - Werden als Vorschau zum Sammeln von Feedback ins JDK integriert
// - Können mit `--enable-preview` aktiviert werden (sowohl Compiler als auch Runtime)

// %% [markdown] lang="de" tags=["slide"]
// ## Beispiel: Pattern-Matching for Switch (JEP 406)
// * examples/terminal-examples/01-enable-preview
// * Wir können Preview-Features mit dem Flag `--enable-preview` aktivieren: 
//      * javac --enable-preview --release 17 Main.java 
//      * java --enable-preview Main

// %% [markdown] lang="de" tags=["slide"]
// ## Incubator-Features
// - Incubator-Features: Ebenfalls zum Sammeln von Feedback ins JDK integriert 
// - Allerdings in Form vorläufiger Umsetzungen
// - Hier kann es sein, dass sich Dinge noch Grundlegend ändern bzw. entfernt werden
// - Aufnahme mit `--add-modules` (nur Runtime)

// %% [markdown] lang="de" tags=["slide"]
// ## LTS-Versionen
// * Alle drei Jahre soll eine neue LTS-Version erscheinen 
// * Mittlerweile auf zwei Jahre verkürzt
// * Im Enterprise-Umfeld kommen häufig nur LTS-Version in Betracht (Support, Security, ...)
// * Für private Entwickler bietet halbjährlicher Release-Zyklus aber Möglichkeiten, neue Features schneller zu nutzen

// %% [markdown] lang="de" tags=["slide"]
// # Lizenzpolitik 
// - Mit Java 11 änderte sich die Lizenzpolitik für das Oracle JDK
// - Beim Download erschien der Hinweis, dass die Nutzung von Java nur noch für private Zwecke kostenlos ist
// - Neben dem OpenJDK haben zahlreiche andere Anbieter angefangen freie Java-Distributionen bereitzustellen:
// - Mit Java 17 änderte Oracle die Lizenzpolitik erneut und steht auch für kommerzielle Nutzung wieder freu zur Verfügung

// %% [markdown] lang="de" tags=["slide"]
// ## 194 Neuerungen zwischen Java 9 und Java 17
//
// * Zwischen Java 9 (21.09.2017) und Java 17 (14.09.2021) wurden 194 Verbesserungen (JEP) in Java integriert.
//   * Anpassungen an neue Entwicklungen (Datengetrieben, Cloud, ...): Records, Sealed Classes, Pattern Matching, ...
//   * technisch und weniger sichtbar
//   * Sprachpflege
//
// ![](img/jep-per-version.png)

// %% [markdown] lang="en" tags=["slide"]
// ## 194 improvements between Java 9 and Java 17
//
// * Between Java 9 (21.09.2017) and Java 17 (14.09.2021) 194 improvements (JEP) were integrated into Java.
//   * technical and less visible,
//   * language maintenance,
//   * new capabilities in the language.
//
// ![](img/jep-per-version.png)

// %% [markdown] lang="de" tags=["slide"]
// ## Neuerungen in Java 9-17
//
// * Wir ignorieren die zeitliche Abfloge der Einführung der Neuerungen
//   * Falls ihr nicht mit Java 17 oder später arbeitet, schaut die beigelegte [Excel](../additional-files/Java-Versions.xlsx) an um zu bestimmen, welche Features für euch bereits verfügbar sind.
// * Manch "ältere" Neuerungen wurden wieder entfernt.
// * Manche Neuerungen wurden eingeführt und vor Java 17 wieder entfernt.
// * Manche Neuerungen werden als "Preview" oder "Incubator" eingeführt und sind nicht ohne explizite Aktivierung nutzbar.

// %% [markdown] lang="en" tags=["slide"]
// ## Improvements in Java 9-17
//
// * We ignore the chronological order of the introduction of the improvements
//   * If you are not working with Java 17 or later, look at the attached [Excel](../additional-files/Java-Versions.xlsx) to determine which features are already available to you.
// * Some "older" improvements have been removed again.
// * Some improvements were introduced and removed again before Java 17.
// * Some improvements are introduced as "Preview" or "Incubator" and are not usable without explicit activation.
//   * We ignore these improvements.

// %% [markdown] lang="de" tags=["notes"]
// * Entfernt: Rhino (intro J7?, del J??)
// * Eingeführt und vor Java 17 wieder entfernt: ...
// * Preview: records
// * Incubator: FFI

// %% [markdown] lang="en" tags=["notes"]
// * Removed: Rhino (intro J7?, del J??)
// * Introduced and removed again before Java 17: ...
// * Preview: records
// * Incubator: FFI

// j2 from 'macros.j2' import header
{{ header("Pragmatischer Einstieg", "Pragmatic Entry") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Einfaches Modul
//
// * Module nutzen `module-info.java` zur Steuerung und Definition.
// * Dadurch indirekt jedes Modul -> eigenes Verzeichnisse.

// %% [markdown] lang="de" tags=["slide"]
// ### Verzeichnisstruktur
//
// * Jedes Modul hat ein eigenes Verzeichnis.
//   * Die Struktur innerhalb dieses Verzeichnisses ist durch das Buildsystem geprägt.
//     * Mit maven befindet sich jeweils eine `pom.xml` in dem Verzeichnis.
//     * Mit gradle befindet sich je nach gewählter Sprache eine `build.gradle.kts` oder `build.gradle` im Verzeichnis.
//   * Jedes Module kann auch eigenen nativen Code kappseln.

// %% [markdown] lang="de" tags=["notes"]
// * Module und nativer Code können zusätzlich JDL-Release spezifisch sein.

// %% [markdown] lang="de" tags=["slide"]
// ## Module-1
//
// 1. Entpacke [../additional-files/module-1.zip](../additional-files/module-1.zip).
// 1. Schau dir die Verzeichnisstruktur an.
// 1. Schau dir den Inhalte der `module-info.java` an.
// 1. Schau dir den Inhalt aller drei `pom.xml` an.

// %% [markdown] lang="de" tags=["slide"]
// ### maven-multi-module != Java Modul
// * Ein maven multi-modul Projekt bezieht sich (überwiegend) auf Build Zusammenhänge innerhalb von maven.
//   * maven multi-modul existiere vor Java Modul.
//
// | maven multi-modul                  | java modul                      |
// | ---------------------------------- | ------------------------------- |
// | Orchestration während eines Builds | Entkoppelung von Code           |
// | Keine Unterstützung in der JVM     | Breite Unterstützung in der JVM |
//
// * Java Modules können auch ohne maven multi-modules (und parent `pom.xml`s gebaut werden).

// %% [markdown] lang="de" tags=["slide"]
// ### Module-1 -- renderer
//
// Die Datei `./renderer/src/main/java/module-info.java`:
// ```java
// module renderer {
//     exports org.example.renderengine;
// }
// ```
// * Es wird **exakt** ein package nach außen bereitgestellt.

// %% [markdown] lang="de" tags=["slide"]
// ### Module-1 -- web
//
// Die Datei `./web/src/main/java/module-info.java`:
// ```java
// module web {
//     requires renderer;
// }
// ```
// * Es wird **exakt** ein Modul angefordert.
//
// Zusätzlich:
// * Eine Abhängigkeit in der `pom.xml` auf die Typen, welcher im renderer Modul exportiert werden.

// %% [markdown] lang="de" tags=["slide"]
// # Übung
//
// 1. Lösche die `requires renderer;` Zeile aus der `./web/src/main/java/module-info.java`.
//    * Kann das Projekt übersetzt werden (`mvn clean compile`)?
//    * Stelle den Ausgangszustand wieder her.
// 1. Lösche die `exports org.example.renderengine;` Zeile aus der `./renderer/src/main/java/module-info.java`.
//    * Kann das Projekt übersetzt werden?
//    * Stelle den Ausgangszustand wieder her.
// 1. Lösche `./renderer/src/main/java/module-info.java` und `./web/src/main/java/module-info.java`.
//    * Kann das Projekt übersetzt werden?
//    * Stelle den Ausgangszustand wieder her.
// 1. Lösche in `./web/pom.xml` die `<dependency>` auf `org.example.renderengine`.
//    * Kann das Projekt übersetzt werden?
//    * Stelle den Ausgangszustand wieder her.
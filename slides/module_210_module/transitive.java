// j2 from 'macros.j2' import header
{{ header("Transitive", "Transitive") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Module-2
// `jdeps -dotoutput module-dependencies --module-path mymods web renderer mathlib commondefinitions`
//
// ![Module in JavaSE](img/module-graph.png)

// %% [markdown] lang="de" tags=["slide"]
// ## Module-2 bauen
//
// 1. Entpacke [../additional-files/module-2.zip](../additional-files/module-2.zip)
// 1. Baue das Projekt mit `mvn clean package`.
// 1. Inspiziere alle vier `modules-info.java`.

// %% [markdown] lang="de" tags=["slide"]
// ## `transitive` in `module-info.java`
// * Wenn viele Module von anderen Modulen indirekt abhängen, kann mit `transitive` markiert werden, welche Abhängigkeiten transitive im Modulsystem sind.
//   * Folge: Als `transitive` marktierte Module müssen *downstream* nicht angegeben werden.
//
// 1. Öffne `renderer/src/main/java/module-info.java`, kommentiere die Sektion `#1` und entferne die Kommentare von Sektion `#2`.
// 1. Öffne `web/src/main/java/module-info.java`, kommentiere die Sektion `#1` und entferne die Kommentare von Sektion `#2`.
// 1. Baue das Projekt mit `mvn clean package`.
// 1. Überlege, warum das funktioniert und was dieses `transitive` für große Projekte bedeutet.

// %% [markdown] lang="de" tags=["slide"]
// ## Sichtbarkeit über Module einschränken
// * Mit Java Modules ist es möglich `public` auf explizit genannte Module zu begrenzen.
//
// 1. Öffne `commondefinitions/src/main/java/module-info.java`.
// 1. Ersetzte `exports org.example.common;` durch `exports org.example.common to renderer;`.
// 1. Versuche das Projekt neu zu bauen mit `mvn clean package`.
// 1. Mach die Änderung wieder rückgängig.
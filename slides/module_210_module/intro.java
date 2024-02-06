// j2 from 'macros.j2' import header
{{ header("Java Module", "Java Module") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Welche Probleme bestehen und sollen gelöst werden?
// <!-- https://www.oracle.com/corporate/features/understanding-java-9-modules.html -->
// * Effektive Kapselung der Interna eines Modules.
// * Aufbrechen großer Bibliotheksstrukturen (u.a. Monolithen).
// * Entkoppelung von Service-Anbieter und Service-Nutzer.

// %% [markdown] lang="de" tags=["slide"]
// ## OSGi - der Vorgänger
//
// * OSGi hat ähnliche Probleme mithilfe einer *kreativer* Verwendung des classloader aufgegriffen.
//   * hatte auf Spracherweiterungen verzichtet.
//   * hatte einige der Herausforderungen allerdings nicht lösen können.
//   * ist nicht über einen engen Anwendungsbereich hinausgekommen.

// %% [markdown] lang="de" tags=["slide"]
// ## Problem der classloader Lösung
// * Mittels [ClassLoader](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html) geladene Klassen liegen im classpath.
// * Alles was im classpath liegt, kann mittels [Reflection](https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/index.html) inspeziert werden.
//   * Korollar: Keine effektive Unterbindung von Abhängigkeiten
// * Es sind zyklische Abhängigkeiten möglich.

// %% [markdown] lang="de" tags=["slide"]
// ## jigsaw - das neue Modulsystem
//
// * Wird gesteuert über die `module-info.java`.
// * Integriert sich mit anderen neuen Feature, wie `sealed` classes.
// * Bietet ein "plugin"-System über [ServiceLoader](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ServiceLoader.html).
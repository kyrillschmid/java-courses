// j2 from 'macros.j2' import header
{{ header("Einstieg - Erklärungen", "Entry Level - Explainations") }}

// %% [markdown] lang="de" tags=["slide"]
// ## `module-info.java` oder nicht
// * Java Module können auch als einfache classpath jar genutzt werden. *noch*
//   * u.a. um Migration von classpath zu Module zu erleichtern.
//   * u.a. um Entscheidung Module/classpath in die Hände der nutzenden Entwickler zu legen.
//
// * Allerdings:
//   * Falls eine Migration von classpath zu Module schwierigkeiten bereitet -> Hinweis auf Probleme in der Architektur.

// ## `module-info.java` oder nicht /2
// * Es gibt nun neben `-cp`/`-classpath`/`--class-path` auch `-p`/`--module-path`.
//
// **Das Java Module System liegt orthogonal über dem classpath System**
// 1. Baue [../additional-files/module-1.zip](../additional-files/module-1.zip) mit `mvn clean package`.
// 1. Führe aus: `java -classpath web\target\web-1.0-SNAPSHOT.jar;renderer\target\renderer-1.0-SNAPSHOT.jar org.example.web.MainWeb` 
// 1. Versuche auszuführen: `java --module-path web\target\web-1.0-SNAPSHOT.jar;renderer\target\renderer-1.0-SNAPSHOT.jar org.example.web.MainWeb`
// 1. Führe aus: `java --module-path web\target\web-1.0-SNAPSHOT.jar;renderer\target\renderer-1.0-SNAPSHOT.jar --module web/org.example.web.MainWeb`

// %% [markdown] lang="de" tags=["slide"]
// ## Mehr Möglichkeiten Sichtbarkeiten zu definieren
//
// | JDK 1-8     | JDK 9+                        |
// | ---------   | ---------------------------   |
// | `public`    | `public` to everyone          |
// |             | `public` to friend module     |
// |             | `public` only within a module |
// | `package`   | `package`                     |
// | `protected` | `protected`                   |
// | `private`   | `private`                     |

// %% [markdown] lang="de" tags=["slide"]
// Diese Sichbarkeiten sind effektiv und können mittels Reflection *nicht* umgangen werden.

// %% [markdown] lang="de" tags=["slide"]
// ## Andere "Modul"-Systeme
// * Anders als andere Bibliotheken, werden Module **außerhalb des Codes** definiert.
// * Anders als andere Bibliotheken, werden Module von `java`, `javac`, `jar`, ... und [JVM](https://en.wikipedia.org/wiki/Java_virtual_machine) verstanden, respektiert und unterstützt.
//
// > (Java) Modules Shape Architecture

// %% [markdown] lang="de" tags=["slide"]
// ## Umsetzung von Modulen in Java
// * JavaSE ist vollständig modularisiert worden.
// * Viele Bibliotheken sind bereits auf module umgestellt worden.

// %%
"hi".getClass().getModule()

// %%
new java.sql.Timestamp(0).getClass().getModule()

// %% [markdown] lang="de" tags=["slide"]
// ![Module in JavaSE](img/jdk-modules.jpg)

// %% [markdown] lang="de" tags=["slide"]
// * Inspiziere die Ausgabe von `jdeps --summary .\renderer\target\renderer-1.0-SNAPSHOT.jar`
// * Inspiziere unsere Abhänigkeiten:
//   * Führe aus `jdeps -dotoutput deps-dot .\renderer\target\renderer-1.0-SNAPSHOT.jar .\web\target\web-1.0-SNAPSHOT.jar`
//   * Öffene `.\deps-dot\summary.dot` und kopiere den Inhalt in [GraphViz Online](https://dreampuf.github.io/GraphvizOnline/).

// %% [markdown] lang="de" tags=["slide"]
// ## Automatic Modules
// * Basierend auf dem Dateinamen einer JAR Datei wird ein Modulname abgeleitet.
//   * Alle packages werden exportiert. Somit das gleiche Verhalten wie auf dem classpath.
// * Somit ist es bereits möglich die Vorteilen der Modularisierung zu nutzen, während noch nicht alle Bibliotheken modularisiert worden sind.

// %% [markdown] lang="de" tags=["slide"]
// # Übung
// 1. Entpacke [../additional-files/module-1.zip](../additional-files/module-1.zip).
// 1. Lösche alle `module-info.java`.
// 1. Baue das Projekt mit `mvn clean package`.
// 1. Führe aus: `java --module-path web\target\web-1.0-SNAPSHOT.jar;renderer\target\renderer-1.0-SNAPSHOT.jar --module web/org.example.web.MainWeb`
// 1. Diskutiere warum die das Projekt als Modul ausführen kannst, obwohl keine `module-info.java` vorliegen.
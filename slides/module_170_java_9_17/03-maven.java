// j2 from 'macros.j2' import header
// {{ header("Maven", "Maven") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Build Automation mit `maven` und neuen Java Versionen
//
// * `maven` ist das am weitesten verbreitete Build Automation Tool.
// * Mit `maven` lassen sich unterschiedliche Projekte in unterschiedlichen in Java Versionen bauen.
// * Die Unterstützung für `maven` ist bei den meisten IDEs gegeben.
// * Die Beispiele nutzten `maven`.

// %% [markdown] lang="en" tags=["slide"]
// ## Build Automation with `maven` and new Java versions
//
// * `maven` is the most widely used build automation tool.
// * With `maven` it is possible to build different projects in different Java versions.
// * Support for `maven` is available in most IDEs.
// * The examples use `maven`.

// %% [markdown] lang="de" tags=["slide"]
// ## `maven` und Java 17
//
// Die Version von Java auf 17 im [compile](https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-release.html) Plugin in der `pom.xml` setzten:
// ```
// <project>
//   [...]
//   <build>
//     [...]
//     <plugins>
//       <plugin>
//         <groupId>org.apache.maven.plugins</groupId>
//         <artifactId>maven-compiler-plugin</artifactId>
//         <version>3.11.0</version>
//         <configuration>
//           <source>17</source>
//           <target>17</target>
//         </configuration>
//       </plugin>
//     </plugins>
//     [...]
//   </build>
//   [...]
// </project>
// ```

// %% [markdown] lang="en" tags=["slide"]
// ## `maven` and Java 17
//
// Set the version of Java to 17 in the [compile](https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-release.html) plugin in the `pom.xml`:
// ```
// <project>
//   [...]
//   <build>
//     [...]
//     <plugins>
//       <plugin>
//         <groupId>org.apache.maven.plugins</groupId>
//         <artifactId>maven-compiler-plugin</artifactId>
//         <version>3.11.0</version>
//         <configuration>
//           <source>17</source>
//           <target>17</target>
//         </configuration>
//       </plugin>
//     </plugins>
//     [...]
//   </build>
//   [...]
// </project>
// ```

// %% [markdown] lang="de" tags=["slide"]
// ## Leeres Java 17 Projekt mit maven
//
// * Siehe [examples/maven-java17-plain].
// * Bauen mit `mvn clean package`
// * Tests ausführen mit `mvn test`
// * Ausführen mit `java -cp target\plain-java17-1.0-SNAPSHOT.jar com.example.Main`

// %% [markdown] lang="en" tags=["slide"]
// ## Empty Java 17 project with maven
//
// * See [examples/maven-java17-plain].
// * Build with `mvn clean package`
// * Run tests with `mvn test`
// * Run with `java -cp target\plain-java17-1.0-SNAPSHOT.jar com.example.Main`

// %% [markdown] lang="en" tags=["slide"]
// ## The maven-compiler-plugin
// 
// The `maven-compiler-plugin` is used to compile the sources of your project.
// It does not manage Java versions on your system.
// Three configuration parameters are available:

// %% [markdown] lang="de" tags=["slide"]
// ## Das maven-compiler-plugin
//
// Das `maven-compiler-plugin` wird verwendet, um die Quellen Ihres Projekts zu kompilieren.
// * Es verwaltet keine Java-Versionen auf Ihrem System.
// * Drei Konfigurationsparameter sind verfügbar: `source`, `target` und `release`.

// %% [markdown] lang="en" tags=["slide"]
// ## `source`: 
// - Specifies the version of Java source code compatibility.
// - Purpose : This tells the Java compiler which version of Java source code to expect.
// - For instance, if you set <source>8</source>, the compiler would accept code constructs introduced up to Java 8. 
// - Implication: If you attempt to use Java features introduced after Java 8, the compilation will fail

// %% [markdown] lang="de" tags=["slide"]
// ## `source`:
// - Gibt die Version der Java-Quellcodekompatibilität an.
// - Zweck: Dies sagt dem Java-Compiler, mit welcher Version des Java-Quellcodes zu rechnen ist.
// - Wenn Sie beispielsweise <source>8</source> festlegen, akzeptiert der Compiler Codekonstrukte, die bis zu Java 8 eingeführt wurden.
// - Implikation: Wenn Sie versuchen, Java-Funktionen zu verwenden, die nach Java 8 eingeführt wurden, schlägt die Kompilierung fehl.

// %% [markdown] lang="en" tags=["slide"]
// ## `target`:
// - Indicated the version of Java bytecode to be generated.
// - Purpose: It ensures that the compiled bytecode is compatible with a specific version of the JVM. 
// - For instance, if you set <target>8</target>, the resulting bytecode will run on a JVM version 8 and later (assuming no newer APIs are used).
// - Implication: This doesn't restrict the Java language features you can use (that's the job of source). 
// - If source is set to a newer version than target, it could lead to issues because newer language features might not translate correctly to older bytecode versions. Thus, typically, source and target are set to the same version or source is set to an older version than target.

// %% [markdown] lang="de" tags=["slide"]
// ## `target`:
// - Gibt die Version des zu generierenden Java-Bytecodes an.
// - Zweck: Es stellt sicher, dass der kompilierte Bytecode mit einer bestimmten Version der JVM kompatibel ist.
// - Wenn Sie beispielsweise <target>8</target> festlegen, wird davon ausgegangen, dass der resultierende Bytecode auf einer JVM-Version 8 oder höher ausgeführt (sofern keine neueren APIs verwendet werden).

// %% [markdown] lang="de" tags=["notes"]
// - Implikation: Dies beschränkt nicht die Java-Sprachfunktionen, die Sie verwenden können (das ist die Aufgabe von `source`).
// - Wenn `source` auf eine neuere Version als das Ziel gesetzt ist, kann dies zu Problemen führen, da neuere Sprachfunktionen möglicherweise nicht korrekt in ältere Bytecode-Versionen übersetzt werden. Daher werden Quelle und Ziel normalerweise auf dieselbe Version gesetzt oder Quelle wird auf eine ältere Version als Ziel gesetzt.

// %% [markdown] lang="en" tags=["slide"]
// ## `release`:
// - Introduced in Java 9 as a way to combine both source and target into a single parameter.
// - Purpose: It ensures that both the source code and the bytecode produced are compatible with the specified Java version. Setting <release>11</release> is equivalent to setting <source>11</source> and <target>11</target>.
// - Implication: This is a more convenient way to ensure that both your code and the resulting bytecode align with a specific Java version. It's recommended to use this for Java 9 and later projects to avoid any mismatches between source and target.
// - Bonus: release also ensures that you're not accidentally using any APIs from versions newer than the specified release. This is an added safety measure compared to just using source and target.

// %% [markdown] lang="de" tags=["slide"]
// ## `release`:
// - In Java 9 als Möglichkeit eingeführt, sowohl `source` als auch `target` in einem einzelnen Parameter zu kombinieren.
// - Zweck: Es stellt sicher, dass sowohl der Quellcode als auch der erzeugte Bytecode mit der angegebenen Java-Version kompatibel sind. 
// - Das Festlegen von `<release>11</release>` entspricht dem Festlegen von `<source>11</source>` und `<target>11</target>`.

// %% [markdown] lang="de" tags=["notes"]
// - Implikation: Dies ist eine bequemere Möglichkeit, sicherzustellen, dass sowohl Ihr Code als auch der resultierende Bytecode mit einer bestimmten Java-Version übereinstimmen. Es wird empfohlen, dies für Java 9 und spätere Projekte zu verwenden, um Abweichungen zwischen Quelle und Ziel zu vermeiden.
// - Bonus: release stellt auch sicher, dass Sie keine APIs aus Versionen verwenden, die neuer als die angegebene Version sind. Dies ist eine zusätzliche Sicherheitsmaßnahme im Vergleich zur Verwendung von `source` und `target`.

// %% [markdown] lang="en" tags=["slide"]
// ## Example 1:
// - `<source>8</source>` and `<target>11</target>`: "My code uses Java 8 language features, but I want it to run on a Java 11 JVM." 
// - This could be problematic, as Java 8 language features might not translate correctly or optimally to Java 11 bytecode.

// %% [markdown] lang="de" tags=["slide"]
// ## Beispiel 1:
// - `<source>8</source>` und `<target>11</target>`: "Mein Code verwendet Java 8-Sprachfunktionen, aber ich möchte, dass er auf einer Java 11-JVM ausgeführt wird."
// - Dies könnte problematisch sein, da Java 8-Sprachfunktionen möglicherweise nicht korrekt oder optimal in Java 11-Bytecode übersetzt werden.

// %% [markdown] lang="en" tags=["slide"]
// ## Example 2:
// `<release>11</release>`, you're essentially setting both the source and target to Java 11!
// - This ensures that the code uses Java 11 language features and produces bytecode optimized for Java 11 JVMs.

// %% [markdown] lang="de" tags=["slide"]
// ## Beispiel 2:
// `<release>11</release>`, Sie setzen im Grunde sowohl die Quelle als auch das Ziel auf Java 11!
// - Dies stellt sicher, dass der Code Java 11-Sprachfunktionen verwendet und Bytecode erzeugt, der für Java 11 JVMs optimiert ist.

// %% [markdown] lang="en" tags=["slide"]
// ## Best Practice:
// In general we can install a relatively recent JDK and use it to compile our code.
// - Potential problem: API compatibility issues.
// - For example: compiling with JDK 17 for a bytecode targe of JDK 8 and using API introduced in JDK 9+.
// - No compile error however when application runs on a JDK 8 environment it will fail with a `NoSuchMethodError
// - Using the `release` parameter will prevent this.

// %% [markdown] lang="de" tags=["slide"]
// ## Best Practice:
// - Im Allgemeinen können wir ein relativ aktuelles JDK installieren und es zum Kompilieren unseres Codes verwenden.
// - Potenzielles Problem: API-Kompatibilitätsprobleme.
// - Zum Beispiel: Kompilieren mit JDK 17 für ein Bytecode-Ziel von JDK 8 und Verwenden von APIs, die in JDK 9+ eingeführt wurden.
// - Kein Kompilierfehler, wenn die Anwendung jedoch in einer JDK 8-Umgebung ausgeführt wird, schlägt sie mit einem `NoSuchMethodError` fehl.
// - Die Verwendung des `release`-Parameters verhindert dies.







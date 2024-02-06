// j2 from 'macros.j2' import header
// {{ header("Gradle", "Gradle") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Build Automation mit `gradle` und neuen Java Versionen
//
// * `gradle` ist ein neueres Build Automation Tool.
// * Fokus liegt auf schnelle Compile und re-Compile Zeiten.
// * Mit `gradle` lassen sich unterschiedliche Projekte in unterschiedlichen Java Versionen bauen.

// %% [markdown] lang="en" tags=["slide"]
// ## Build Automation with `gradle` and new Java versions
//
// * `gradle` is a newer build automation tool.
// * Focus is on fast compile and re-compile times.
// * With `gradle` you can build different projects in different Java versions.

// %% [markdown] lang="de" tags=["slide"]
// ## `gradle` in Java 17 und Kotlin
//
// Setze die [`compileJava.options.release`](https://docs.gradle.org/current/userguide/building_java_projects.html#sec:compiling_with_release) in `build.gradle.kts` auf die entsprechende Release Version:
// ```
// tasks.compileJava {
//     options.release.set(17)
// }
// ```

// %% [markdown] lang="en" tags=["slide"]
// ## `gradle` in Java 17 and Kotlin
//
// Set the [`compileJava.options.release`](https://docs.gradle.org/current/userguide/building_java_projects.html#sec:compiling_with_release) in `build.gradle.kts` to the appropriate release version:
// ```
// tasks.compileJava {
//     options.release.set(17)
// }
// ```

// %% [markdown] lang="de" tags=["slide"]
// ## `gradle` in Java 17 und Groovy
//
// Setze die [`compileJava.options.release`](https://docs.gradle.org/current/userguide/building_java_projects.html#sec:compiling_with_release) in `build.gradle` auf die entsprechende Release Version:
// ```
// compileJava {
//     options.release = 17
// }
// ```

// %% [markdown] lang="en" tags=["slide"]
// ## `gradle` in Java 17 and Groovy
//
// Set the [`compileJava.options.release`](https://docs.gradle.org/current/userguide/building_java_projects.html#sec:compiling_with_release) in `build.gradle` to the appropriate release version:
// ```
// compileJava {
//     options.release = 17
// }
// ```

// %% [markdown] lang="de" tags=["slide"]
// ## Leeres Java 17 Projekt mit gradle
//
// * Siehe examples/gradle-java17-plain.
// * Bauen mit `gradlew.bat jar`
// * Tests ausführen mit `gradlew.bat test`
// * Ausführen mit `java -cp build\libs\gradle-java17-plain-1.0-SNAPSHOT.jar com.example.Main`

// %% [markdown] lang="en" tags=["slide"]
// ## Empty Java 17 project with gradle
//
// * See examples/gradle-java17-plain.
// * Build with `gradlew.bat jar`
// * Run tests with `gradlew.bat test`


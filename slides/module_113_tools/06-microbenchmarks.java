// j2 from 'macros.j2' import header
// {{ header("Microbenchmarks", "Microbenchmarks") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Microbenchmarks
// * Mitunter ist es notwendig, die Laufzeit von Code zu messen.
// * Software ist evtl. nicht so performant wie gewünscht.
// * Gründliches Messen ist wichtig, um die Ursache zu finden.
// * Vorschnelle Optimierungen sind oft nicht zielführend.
// * Wichtig: Finden der für die Performance relevanten Stellen.


// %% [markdown] lang="de" tags=["slide"]
// ## Microbenchmark Suite
// * [JMH](https://openjdk.java.net/projects/code-tools/jmh/)
// * Die Microbenchmark Suite wurde mit Java 12 in das JDK aufgenommen.
// * Hilft bei der Erstellung von Microbenchmarks.


// %% [markdown] lang="de" tags=["slide"]
// ## Eigene Microbenchmarks
// * Nachfolgend schauen wir uns die Optimierung von einzenlnen bzw. wenigen Anweisungen an.
// * Dazu nutzen wir Microbenchmarks.
// * Hinweis: Die Optimierung von einzelnen Anweisungen ist in der Regel nicht zielführend 
//      - (eher Architektur, Algorithmen, Datenstrukturen, ...).

// %% [markdown] lang="de" tags=["slide"]
// ## Performance vergleichen
// * Vergleich verschiedener Implementierungen nicht trivial
// * Messungen sollten unter gleichen Bedingungen erfolgen (CPU-Last, Speicher, ...)


// %% [markdown] lang="de" tags=["slide"]
// ## Start-Stopp-Messungen
// * Im einfachsten Fall wird die Zeit zwischen Start und Stopp gemessen.
// * Hinweis: System.currentTimeMillis() liefert ggf. zu grobgranulare Werte.

// %% tags=["keep"]
void myFun() { 
    int counter = 0;
    for (int i = 0; i < 1_000_000; i++) {
        counter++; // Vorsicht: Compiler könnte diese Anweisung optimieren
    }
}

// %%
final long startTimeMs = System.currentTimeMillis(); // Achtung: Nicht geeignet für Messungen im Nanosekundenbereich
myFun();
final long endTimeMs = System.currentTimeMillis();
final long durationMs = endTimeMs - startTimeMs;

// %% 
System.out.println("Dauer: " + durationMs + " ms");

// %% [markdown] lang="de" tags=["slide"]
// ## Wiederholte Messungen
// * Messungen werden durch unterschiedliche Faktoren beeinflusst (CPU-Last, Speicher, ...).
// * Deshalb sollten Messungen wiederholt werden.
// * Durchschnittswerte sind aussagekräftiger, Minima und Maxima können ebenfalls interessant sein.

// %%
final long startTimeNs = java.lang.System.nanoTime(); // besser

for (int i = 0; i < 1000; i++) {
    myFun();
}

final long endTimeNs = java.lang.System.nanoTime();

final long avgDurationNs = (endTimeNs - startTimeNs) / 1000;

// %% 
System.out.println("Dauer: " + avgDurationNs + " ns");

// %% [markdown] lang="de" tags=["slide"]
// ## Wiederholte Messungen mit Warmup
// * Häufig treten bei den ersten Messungen noch Ausreißer auf. (Einschwing-Effekte)
// * Caches werden gefüllt, Hotspot-Compiler wird aktiviert, ...
// * Warmup-Phase vor den eigentlichen Messungen (wie im Sport).

// %% tags=["keep"]
final int WARM_UP_ITERATIONS = 1000;
final int MEASUREMENT_ITERATIONS = 1000;

// %% tags=["keep"]
// Warmup
for(int i = 0; i < WARM_UP_ITERATIONS; i++) {
    myFun();
}

// Messungen
final long startTimeNs = java.lang.System.nanoTime();

for (int i = 0; i < MEASUREMENT_ITERATIONS; i++) {
    myFun();
}
final long endTimeNs = java.lang.System.nanoTime();

// %%
final long avgDurationNs = (endTimeNs - startTimeNs) / MEASUREMENT_ITERATIONS;

// %%
System.out.println("Dauer: " + avgDurationNs + " ns");

// %% [markdown] lang="de" tags=["slide"]
// ## Exkurs: Hotspot-Optimierer
// * Java-Programm liegt zunächst als Bytecode vor.
// * In JVM ist Hotspot-Optimierer inklusive JIT-Compiler enthalten.
// * Beide sorgen dafür, dass häufig genutzter Code on the fly in Maschinen-Code übersetzt wird.
// * Naive Messungen ermitteln evtl. nicht die optimierte Version.
// - Mit `-XX:+PrintCompilation` kann man die Komplilierungsvorgänge beobachten.
// - Mit `-XX:CompileThreshold` kann man die Anzahl der Aufrufe einstellen, ab der Komplilierung erfolgt. (default: 10.000)

// %% [markdown] lang="de" tags=["slide"]
// ## Microbenchmarks mit JMH
// * Seit Java 12 ist JMH (Java Microbenchmark Harness) in das JDK integriert.
// * Adressiert die oben genannten Probleme bei Performance-Messungen.
// * Zur Unterstützung definiert JMH Annotationen, die zur Erstellung von Benchmarks genutzt werden können.

// %% [markdown] lang="de" tags=["slide"]
// ## JMH-Annotationen
// * Wir erzeugen uns ein maven Projekt mit JMH-Unterstützung.

// %% tags=["keep"]
mvn archetype:generate \
  -DinteractiveMode=false \
  -DarchetypeGroupId=org.openjdk.jmh \
  -DarchetypeArtifactId=jmh-java-benchmark-archetype \
  -DgroupId=org.sample \
  -DartifactId=jmh-test \
  -Dversion=1.0-SNAPSHOT


// %% [markdown] lang="de" tags=["slide"]
// * Wir passen den Compiler an, damit wir Java 17 nutzen können:
// `<javac.target>17</javac.target>`

// %% [markdown] lang="de" tags=["slide"]
// * Es wird eine Klasse MyBenchmark erzeugt, die wir anpassen können: 

// %% tags=["keep"]
import org.openjdk.jmh.annotations.Benchmark;

public class MyBenchmark {

    @Benchmark
    public void testMethod() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
    }

}

// %% [markdown] lang="de" tags=["slide"]
// * Zum Ausführen der Benchmarks nutzen wir das maven-Plugin:
// - `mvn package`
// * Dadurch entsteht eine ausführbare JAR-Datei, die wir mit `java -jar` ausführen können:
// - `java -jar target/benchmarks.jar`

// %% [markdown] lang="de" tags=["slide"]
// ## Erster Benchmark
// * Bisher ist der Benchmark noch leer.
// * Wir fügen eine Klasse `FirstIntegerBenchmark` 
// * Wir wollen die Performance der Methoden `toHexString` und `toBinaryString` messen.

// %% tags=["keep"]
package org.sample;

import org.openjdk.jmh.annotations.Benchmark;

public class FirstIntegerBenchmark {

    @Benchmark
    public String numberAsHexString() {
        final int number = 1_234_567;
        return Integer.toHexString(number);
    }

    @Benchmark
    public String numberAsBinaryString() {
        final int number = 1_234_567;
        return Integer.toBinaryString(number);
    }
}

// %% [markdown] lang="de" tags=["slide"]
// ## Ergebnis:
// - Das Erzeugen von Binär-Strings ist deutlich schneller als das Erzeugen von Hex-Strings (Faktor 11):
// - Das spielt bei 294 Millionen Aufrufen pro Sekunde bzw. 92 Millionen Aufrufen allerdings keine große Rolle.

// %% tags=["keep"]
// Benchmark                                    Mode  Cnt          Score         Error  Units
// FirstIntegerBenchmark.numberAsBinaryString  thrpt   25   92456732,920 ± 2859986,594  ops/s
// FirstIntegerBenchmark.numberAsHexString     thrpt   25  294959605,095 ± 7523646,431  ops/s


// %% [markdown] lang="de" tags=["slide"]
// ## Feintuning
// - `Warmup`und `Measurement` definieren die Anzahl der Warmup- und Messungsiterationen
// - `Fork` definiert die Anzahl der Durchläufe.

// %% tags=["keep"]
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

@Measurement(iterations=3, time=1000)
@Warmup(iterations = 6, time = 1000)
@Fork(4)
public class FirstIntegerBenchmark {
    // ...
}

// %% [markdown] lang="de" tags=["slide"]
// # Weitere JMH-Annotationen:
// * `@State` spezifiziert, wie der Zustand zwischen Messungen und Threads geteilt wird.
// - Gibt es einen globalen Zustand so lässt sich die Benchmark-Klasse mit `@State(Scope.Benchmark)` annotieren
// - Es lassen sich auch innere Klassen annotieren, die dann als Zustand dienen.
// - Über den Scope lässt sich die Lebensdauer des Zustands steuern (im Thread-Scope wird für jeden Thread ein Zustand erzeugt).

// %% [markdown] lang="de" tags=["slide"]
// # `@BenchmarkMode`
// * Zur Beurteilung der Performance oftmals interessant:
// - Operationen pro Zeiteinheit
// - Durchschnittliche Zeit pro Operation)

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop: MathBenchmark
// * Erzeugen Sie sich ein neues Projekt mit JMH-Unterstützung.
// * Erstellen Sie eine Klasse `MathBenchmark` mit folgenden Methoden:
    //    - mult()
//    - div()
//    - pow()
// - Setzen Sie den Scope der Klasse auf `Scope.Benchmark`.
// - Legen Sie zwei Integer-Variablen an, die Sie in den Methoden verwenden.
// - Messen Sie für `mult()` sowohl Throughput als auch AverageTime mit `@BenchmarkMode`.
// - Verwenden Sie `@OutputTimeUnit` um die Einheit der Zeit in Nanosekunden anzugeben.

// %%
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class MathBenchmark {
    private int a = 123;
    private int b = 456;

    @Benchmark
    @BenchmarkMode(Mode.Throughput, Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int mult() {
        return a * b;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int div() {
        return a / b;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public int pow() {
        return (int) Math.pow(a, b);
    }
}

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop: StringBenchmark
// 
// Wir wollen ermitteln, ob man besser mit indexOf(String), indexOf(char) oder contains(String) arbeiten sollte.
// - Erzeugen Sie eine Klasse `StringBenchmark`
// - Legen sie eine Klasse `SearchState` an, die ein Attribut `text` vom Typ `String` enthält und annotieren Sie diese Klasse mit `@State`Scope.Thread`.
// - Implementieren Sie die drei Methoden `testIndexOf`, `testIndexOfString` und `testContains`.
// - Messen Sie die Performance der Methoden mit `@Benchmark`.

// %%
package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class StringBenchmark {

    @State (Scope.Thread)
    public static class SearchState {
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_" + 
                      "abcdefghijklmnopqrstuvwxyz";
    }

    @Benchmark
    public int testIndexOf(SearchState state) {
        var result = state.text.indexOf('M');
        return result;
    }

    @Benchmark
    public boolean testContains(SearchState state) {
        var result = state.text.contains("M");
        return result;
    }

    @Benchmark
    public int testIndexOfString(SearchState state) {
        var result = state.text.indexOf("M");
        return result;
    }
}

// %% [markdown] lang="de" tags=["slide"]
// - `Blackhole`-Objekt: Verhindert, dass der Compiler die Ergebnisse der Methodenaufrufe wegoptimiert.
// - Übergeben sie das `Blackhole`-Objekt als Parameter an die Methoden und konsumieren Sie das Ergebnis mit `blackhole.consume(result)`.
// - Verändern sich dadurch die Ergebnisse?

// %% 
package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class StringBenchmark {

    @State (Scope.Thread)
    public static class SearchState {
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_" +
                "abcdefghijklmnopqrstuvwxyz";
    }

    @Benchmark
    public int testIndexOf(SearchState state, Blackhole blackhole) {
        var result = state.text.indexOf('M');
        blackhole.consume(result);
        return result;
    }

    @Benchmark
    public boolean testContains(SearchState state, Blackhole blackhole) {
        var result = state.text.contains("M");
        blackhole.consume(result);
        return result;
    }

    @Benchmark
    public int testIndexOfString(SearchState state, Blackhole blackhole) {
        var result = state.text.indexOf("M");
        blackhole.consume(result);
        return result;
    }
}

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop: Stringkonkatenation
// 
// Vergleichen Sie in einem geeigneten Benchmark die drei Varianten der Stringkonkatenation:
// - `+` bzw. `+=`
// - `StringBuilder.append()`
// - `String.concat()`

// %% 
package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class StringConcatBenchmark {

    private String from = "Sender";
    private String to = "Empfänger";
    private String subject = "Betreff";

    @Benchmark
    public String testPlus(Blackhole blackhole) {
        var result = "Mail von " + from + " an " + to + " mit Betreff " + subject;
        blackhole.consume(result);
        return result;
    }

    @Benchmark
    public String testStringBuilder(Blackhole blackhole) {
        var builder = new StringBuilder();
        builder.append("Mail von ");
        builder.append(from);
        builder.append(" an ");
        builder.append(to);
        builder.append(" mit Betreff ");
        builder.append(subject);
        var result = builder.toString();
        blackhole.consume(result);
        return result;
    }

    @Benchmark
    public String testConcat(Blackhole blackhole) {
        var result = "Mail von ".concat(from).concat(" an ").concat(to).concat(" mit Betreff ").concat(subject);
        blackhole.consume(result);
        return result;
    }

}

// %% [markdown] lang="de" tags=["slide"]
// # Fazit
// * Neben einem Profiler sind Microbenchmarks ein wichtiges Werkzeug zur Performance-Analyse.
// * Damit lässt sich die Performance einzelner Methoden oder Anweisungen messen.
// * JMH ist ein Framework, das die Erstellung von Microbenchmarks vereinfacht.

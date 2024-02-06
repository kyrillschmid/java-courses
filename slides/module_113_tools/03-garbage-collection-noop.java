// j2 from 'macros.j2' import header
// {{ header("No-Op Garabage Collector", "No-Op Garabage Collector") }}

// %% [markdown] lang="en" tags=["slide"]
// ## Java Memory Management
// * Java automatically manages memory using a Garbage Collector.
// * The main role of the Garbage Collector is to free memory of objects that are no longer needed.
// * The standard Java runtime has several built in Garbage Collectors (each with different characteristics).

// %% [markdown] lang="de" tags=["slide"]
// ## Java Memory Management
// * Java verwaltet den Speicher automatisch mit einem Garbage Collector.
// * Die Hauptaufgabe des Garbage Collectors ist es, den Speicher von Objekten freizugeben, die nicht mehr benötigt werden.
// * Die Standard-Java-Laufzeitumgebung verfügt über mehrere integrierte Garbage Collector (jeder mit unterschiedlichen Eigenschaften).

// %% [markdown] lang="en" tags=["slide"]
// ## No-Op Garabage Collector
// * The No-op GC doesn't actually reclaim memory even if the memory is no longer needed.
// * What is it good for?

// %% [markdown] lang="de" tags=["slide"]
// ## No-Op Garabage Collector
// * Der No-op GC gibt den Speicher tatsächlich nicht frei, auch wenn der Speicher nicht mehr benötigt wird.
// * Wofür ist es gut?

// %% [markdown] lang="en" tags=["slide"]
// ## No-Op Garabage Collector
// * Performance testing: testing without the overhead of the Garbage Collector.
// * Short lived jobs: jobs that run for a very short time and don't need to reclaim memory.
// * Memory profiling: testing the application's memory footprint without GC interference.

// %% [markdown] lang="de" tags=["slide"]
// ## No-Op Garabage Collector
// * Leistungstests: Tests ohne den Overhead des Garbage Collectors.
// * Kurzlebige Jobs: Jobs, die sehr kurz laufen und keinen Speicher freigeben müssen.
// * Memory Profiling: Testen des Speicher-Footprints der Anwendung ohne GC-Interferenz.

// %% [markdown] lang="en" tags=["slide"]
// ## No-Op Garabage Collector
//  Activate with ```-XX:+UseEpsilonGC```.

// %% [markdown] lang="de" tags=["slide"]
// ## No-Op Garabage Collector
//  Aktivieren mit ```-XX:+UseEpsilonGC```.

// %% [markdown] lang="de" tags=["slide"]
// ## Mini-Workshop
//
// 1. Übertragen den Code unten in deine IDE und mache ihn ausführbar.
// 2. Erzeuge eine JAR Datei mit ```mvn package -DskipTests```.
// 3. Führe das Programm mit ```java -Xmx128m -cp target/plain-java17-1.0-SNAPSHOT.jar com.example.FlightRecorderMain```.
// 4. Führe das Programm mit ```java -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -Xmx128m -cp target/plain-java17-1.0-SNAPSHOT.jar com.example.FlightRecorderMain```.
// 5. Führe das Programm mit ```java -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC   -Xmx1g -cp target/plain-java17-1.0-SNAPSHOT.jar com.example.FlightRecorderMain```.
// 6. Beobachte wie sich das Programm verhält.

// %% [markdown] lang="en" tags=["slide"]
// ## Mini-Workshop
//
// 1. Transfer the code below into your IDE and make it executable.
// 2. Create a JAR file with ```mvn package -DskipTests```.
// 3. Run the program with ```java -Xmx128m -cp target/plain-java17-1.0-SNAPSHOT.jar com.example.FlightRecorderMain```.
// 4. Run the program with ```java -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -Xmx128m -cp target/plain-java17-1.0-SNAPSHOT.jar com.example.FlightRecorderMain```.
// 5. Run the program with ```java -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC   -Xmx1g -cp target/plain-java17-1.0-SNAPSHOT.jar com.example.FlightRecorderMain```.
// 6. Observe how the program behaves.


// %% tags=["keep"]
package com.example;

import jdk.jfr.consumer.RecordingStream;

import java.time.Duration;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class FlightRecorderMain {
    public static void main(String[] args) throws InterruptedException {
        var main = new FlightRecorderMain();
        main.startMonitoring();
        main.run();
    }

    void run() throws InterruptedException {
        System.out.println("Begin ...");
        final long max = 10_000_000;
        var list = new ArrayList<String>();
        for (long i = 0; i < max; i++) {
            var sb = new StringBuilder();
            IntStream.range(0, 1_000).forEach(is -> sb.append('.'));
            if (i % 10_000 == 0) {
                System.out.printf("Progress %.2f%%.%n", ((double) i / max * 100));
                list.add("- " + sb.toString().length());
                Thread.sleep(1);
            }
        }
        System.out.println("Count: " + list.size());
    }

    private void startMonitoring() {
        // jdk.jfr.FlightRecorder.getFlightRecorder().getEventTypes().forEach(e -> System.out.println(e.getName()));
        var t = new Thread(this::monitor);
        t.setDaemon(true);
        t.start();
    }

    void monitor() {
        try (var rs = new RecordingStream()) {
            subscribeAndReport("jdk.CPULoad", Duration.ofSeconds(1), rs);
            subscribeAndReport("jdk.GCHeapSummary", Duration.ofSeconds(1), rs);
            rs.start();
        }
    }

    private static void subscribeAndReport(String name, Duration duration, RecordingStream rs) {
        rs.enable(name).withPeriod(duration);
        rs.onEvent(name, event -> System.out.println(name + ": " + event));
}

    }
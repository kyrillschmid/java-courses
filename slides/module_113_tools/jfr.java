// j2 from 'macros.j2' import header
// {{ header("Java Flight Recorder - Event Streaming", "Java Flight Recorder - Event Streaming") }}

// %% [markdown] lang="de" tags=["slide"]
// <!-- https://openjdk.org/jeps/349 -->
// <!-- https://www.morling.dev/blog/rest-api-monitoring-with-custom-jdk-flight-recorder-events/ -->
// <!-- MicroProfile https://github.com/eclipse/microprofile-metrics -->
// * JFR wurde zum Java Standard hinzugefügt.
//   * Damit ist es einfacher möglich diese low-overhead low-level profiling und troubleshooting Werkzeug zu nutzen.
//   * Eigene Events zu erzeugen ist ebenfalls möglich.
// * Mit der Event Streaming API ist es möglich während dem laufenden Programm JFR Daten zu beziehen und ggf. zu reagieren.

// %% [markdown] lang="en" tags=["slide"]
// <!-- https://openjdk.java.net/jeps/349 -->
// <!-- https://www.morling.dev/blog/rest-api-monitoring-with-custom-jdk-flight-recorder-events/ -->
// * JFR was added to the Java standard.
//   * This makes it easier to use this low-overhead low-level profiling and troubleshooting tool.
//   * It is also possible to create your own events.
// * With the Event Streaming API it is possible to get JFR data during the running program and to react if necessary.

// %% [markdown] lang="de" tags=["slide"]
// Liste der aktuell verfügbaren Events

// %% [markdown] lang="en" tags=["slide"]
// List of currently available events

// %% tags=["keep"]
import jdk.jfr.EventType;
var firstEvents = jdk.jfr.FlightRecorder.getFlightRecorder()
        .getEventTypes()
        .stream()
        .map(EventType::getName)
        .sorted()
        .limit(5)
        .reduce("", (b, a) -> a + ", " + b);
"Liste der ersten 5 Events (alphabetisch): %s...".formatted(firstEvents)

// %% [markdown] lang="de" tags=["slide"]
// Ein einfacher Monitor, welcher die CPU Auslastung kontiniuerlich ausliest.

// %% [markdown] lang="en" tags=["slide"]
// A simple monitor that continuously reads the CPU load.

// %% tags=["keep"]
class StreamingMonitor implements Runnable {
    @Override
    public void run() {
        try (var rs = new RecordingStream()) {
            rs.enable("jdk.CPULoad").withPeriod(Duration.ofSeconds(1));
            rs.onEvent("jdk.CPULoad", event -> System.out.println("jdk.CPULoad: " + event.getFloat("machineTotal")));
            rs.start();
        }
    }
}

// %%
var monitorThread = new Thread(new StreamingMonitor());
monitorThread.start();

Thread.sleep(5000);
System.out.println("stopping ...");
monitorThread.interrupt();
System.out.println("bye");

// %% [markdown] lang="de" tags=["slide"]
// Selbstdefiniertes Event
//
// * Ein selbstdefiniertes Event muss von ```jdk.jfr.Event``` erben.
// * Mit Annotationen kommuniziert die Klasse wie das Event in [JDK Mission Control](https://openjdk.java.net/projects/jmc/) angezeigt werden soll.

// %% [markdown] lang="en" tags=["slide"]
// Self-defined event
//
// * A self-defined event must inherit from ```jdk.jfr.Event```.
// * With annotations, the class communicates how the event should be displayed in [JDK Mission Control](https://openjdk.java.net/projects/jmc/).

// %% tags=["keep"]
@Name(RandomEventSource.NAME)
@Label("Random Event Source")
@Category("data")
@Description("Some randomness exposed")
@StackTrace(false)
class RandomEventSource extends Event {
    static final String NAME = "dev.example.randomeventsource";

    @Label("Random Name")
    String randomName;

    @Label("Random Integer")
    int randomInt;

    @Label("Random Flip")
    boolean randomFlip;
}

// %% tags=["keep"]
class StreamingMonitor implements Runnable {
    @Override
    public void run() {
        try (var rs = new RecordingStream()) {
            rs.enable(RandomEventSource.NAME);
            rs.onEvent(RandomEventSource.NAME, System.out::println);
            rs.start();
        }
    }
}

// %% tags=["keep"]
class FillRandomness implements Runnable{
    @Override
    public void run() {
        var rnd = new Random();
        for (int i = 0; i < 1_000; i++) {
            var event = new RandomEventSource();
            //if (!event.isEnabled()) break;

            event.begin();
            threadSleep(100 + rnd.nextInt(0, 500));
            event.end();

            if (event.shouldCommit()) {
                event.randomName = rnd.nextBoolean() ? "Buzz Lightyear" : "Woody";
                event.randomInt = rnd.nextInt();
                event.randomFlip = rnd.nextBoolean();
                event.commit();
            }
        }
    }
}

static void threadSleep(long millis) {
    try { Thread.sleep(millis); } catch (InterruptedException e) { throw new RuntimeException(e); }
}

var monitorThread = new Thread(new StreamingMonitor());
monitorThread.start();

var producer = new Thread(new FillRandomness());
producer.start();

Thread.sleep(5000);
System.out.println("stopping ...");
monitorThread.interrupt();
System.out.println("bye");

// %% [markdown] lang="de" tags=["slide"]
// ## Zusammenarbeit mit anderen Werkzeugen
//
// * [JDK Mission Control](https://openjdk.java.net/projects/jmc/)
// * [Prometheus](https://prometheus.io/)
// * [Grafana](https://grafana.com/) zur Visualisierung

// %% [markdown] lang="en" tags=["slide"]
// ## Collaboration with other tools
//
// * [JDK Mission Control](https://openjdk.java.net/projects/jmc/)
// * [Prometheus](https://prometheus.io/)
// * [Grafana](https://grafana.com/) for visualization

// %% [markdown] lang="de" tags=["slide"]
// ## Metrics in Web-Applicationen
//
// * JFR ist low-level und sehr detailliert.
// * In "einfachen" Web-Applicationen sind solch tiefe Details nicht immer nötig.
//   * [Spring Metrics](https://spring.io/guides/tutorials/metrics-and-tracing/) und [MircoProfile Metrics](https://github.com/eclipse/microprofile-metrics) sind einfache APIs, um Metricinformationen bereitzustellen.

// %% [markdown] lang="en" tags=["slide"]
// ## Metrics in web applications
//
// * JFR is low-level and very detailed.
// * In "simple" web applications, such deep details are not always necessary.
//   * [Spring Metrics](https://spring.io/guides/tutorials/metrics-and-tracing/) and [MircoProfile Metrics](
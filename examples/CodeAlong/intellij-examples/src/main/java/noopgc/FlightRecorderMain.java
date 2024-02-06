package noopgc;

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

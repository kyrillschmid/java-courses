package org.sample;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
public class ParallelStreamBenchmark {

    public static int[] numbers;
    private static final int MAX_VALUE = 10000;
    private static final int LARGE_THRESHOLD = 8000;
    private static final int NUMBER_OF_NUMBERS = 50000000;

    @Setup
    public void setUp() {
        numbers = new int[NUMBER_OF_NUMBERS];
        for (int i = 0; i < NUMBER_OF_NUMBERS; i++) {
            numbers[i] = (int) (Math.random() * MAX_VALUE);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public long countLargeNumbersLoop() {
        long result = 0;
        for (int n : numbers) {
            if (n >= LARGE_THRESHOLD) {
                result++;
            }
        }
        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public long countLargeNumbersStream() {
        final IntStream stream = Arrays.stream(numbers);
        return stream.filter(n -> n >= LARGE_THRESHOLD).count();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public long countLargeNumbersParallelStream() {
        final IntStream stream = Arrays.stream(numbers).parallel();
        return stream.filter(n -> n >= LARGE_THRESHOLD).count();
    }

}

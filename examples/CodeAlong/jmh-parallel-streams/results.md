NUMBER_OF_NUMBERS = 50000000

Benchmark                                                Mode  Cnt  Score           Error       Units
ParallelStreamBenchmark.countLargeNumbersLoop            avgt   10  30535859,266 ±  157910,758  ns/op
ParallelStreamBenchmark.countLargeNumbersParallelStream  avgt   10  12980301,128 ± 1009115,760  ns/op
ParallelStreamBenchmark.countLargeNumbersStream          avgt   10  67118851,209 ±  564125,676  ns/op


--------------------
NUMBER_OF_NUMBERS = 5000000

Benchmark                                                Mode  Cnt   Score         Error         Units
ParallelStreamBenchmark.countLargeNumbersLoop            avgt   10   3220591,143   ± 349493,463  ns/op
ParallelStreamBenchmark.countLargeNumbersParallelStream  avgt   10   1280348,773   ±  51949,702  ns/op
ParallelStreamBenchmark.countLargeNumbersStream          avgt   10   7232248,550   ± 978863,643  ns/op



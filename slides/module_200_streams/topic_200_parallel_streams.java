// j2 from 'macros.j2' import header
// {{ header("Parallel Streams", "Parallel Streams") }}


// %% [markdown] lang="en" tags=["slide"]
// ## Java Streams
// - Java Streams represent a modern, functional programming feature introduced in Java 8 
//      - Perform bulk operations on collections, arrays, I/O channels, etc.
//      - Filtering, mapping, or duplicate removal

// %% tags = ["keep"]
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// %%
numbers.stream().filter(n -> n % 2 == 0).toList();

// %% [markdown] lang="en" tags=["slide"]
// ## Creating Streams
// - From Collections: `collection.stream()` or `collection.parallelStream()`.
// - From Arrays: `Arrays.stream(array)`.
// - From Static Factory Methods: `Stream.of()`, `IntStream.range()`.
// - From I/O Channels: Like `Files.lines(Path path)` for reading lines from a file.

// %% tags=["keep"]
int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}

// %% tags=["start"]
Arrays.stream(numbers)

// %% tags=["alt"]
Arrays.stream(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    .filter(n -> n % 2 == 0)
    .forEach(p -> System.out.println(p));

// %% tags=["keep"]
import java.util.stream.IntStream;
import java.util.stream.Collectors;

// %%
List<Integer> evenNumbers = IntStream.range(1, 11)
                                     .filter(n -> n % 2 == 0)
                                     .boxed()  // This converts IntStream to Stream<Integer>
                                     .collect(Collectors.toList());
evenNumbers;


// %% [markdown] lang="en" tags=["slide"]
// ## Stream Operations
// Intermediate Operations: These operations transform a stream into another stream. 
//      - E.g., filter, map, flatMap, sorted.
//      - Lazy: don't get executed until a terminal operation is invoked.


// %% tags=["keep"]
List<String> myList = Arrays.asList("apple", "banana", "cherry");

// %% tags=["keep"]
Stream myStream = myList.stream()
    .filter(s -> s.startsWith("a"))
    .map(String::toUpperCase)
    

// %% [markdown] lang="en" tags=["slide"]
// - Terminal Operations: These operations produce a result or a side-effect. 
//      - Once a terminal operation is performed, the stream pipeline is considered consumed.
//      - E.g.include forEach, collect, reduce, findFirst.

// %%
myStream.forEach(System.out::println);

// %%
int sum = Arrays.stream(numbers)
        .sum();
sum;

// %% [markdown] lang="en" tags=["slide"]
// ## Notes
// - Streams cannot be reused once a terminal operation is invoked on a stream
// - Streams do not have a storage. They are not a data structure to store elements
// - Streams cannot change the source data.
//      - No side effects on the data source - modifications do not affect the original data source.


// %% [markdown] lang="en" tags=["slide"]
// ## Parallel Streams
// - You can execute streams in serial or parallel
// - Parallel streams are partioned into multiple sub-streams from the Java runtime and processed in parallel
// - Aggregate operations iterate over and process these sub-streams in parallel and then combine the results.

// %% [markdown] lang="en" tags=["slide"]
// ## Applications
// - Parallel streams are suited for operations that are CPU intensive and can be performed independently on each data element. 
// - For example, calculations on large numeric datasets.

// %% [markdown] lang="en" tags=["slide"]
// ## Executing Streams in Parallel
// - When you create a stream it is always a serial stream by default
// - To create a parallel stream invoke the `parallelStream()` method on the collection
// - Alternatively, invoke the operation `BaseStream.parallel()`

// %% tags=["keep"]
public class Person {
    private int age;
    private String name;
    private String gender;

    public Person(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Person{" +
               "age=" + age +
               ", name='" + name + '\'' +
               ", gender='" + gender + '\'' +
               '}';
    }
}

// %% tags=["slide", "keep"]
List<Person> people = Arrays.asList(
            new Person(30, "Alice", "Female"),
            new Person(35, "Bob", "Male"),
            new Person(28, "Carol", "Female"),
            new Person(40, "David", "Male")
        );

// %% 
double average = people
    .parallelStream()
    .filter(p -> p.getGender() == "Male")
    .mapToInt(Person::getAge)
    .average()
    .getAsDouble();

// %% [markdown] lang="en" tags=["slide"]
// ## Concurrent Reduction
// - Let's assume we wan to group members by gender
// - We could use a Map `Map<String, List<Person>>`

// %% tags=["start"]
Map<String, List<Person>> peopleByGender = people
    .parallelStream()
    .collect();

// %% tags=["alt"]
Map<String, List<Person>> peopleByGender = people
    .parallelStream()
    .collect(Collectors.groupingByConcurrent(Person::getGender));

// print the groups
for(List<Person> group : peopleByGender.values()) {
    System.out.println(group);
}

// %% [markdown] lang="en" tags=["slide"]
// - The Java runtime performs a concurrent reduction on the stream if the following conditions are met:
//      - The stream is parallel
//      - The stream is unordered or the collector has the `Collector.Characteristics.UNORDERED` characteristic
//      - The collector has the `Collector.Characteristics.CONCURRENT` characteristic

// %% [markdown] lang="en" tags=["slide"]
// ## Ordering
// - The order in which a pipeline prcesses the elements of a stream depends on 
//      - whether the stream is executed in serial or parallel
//      - the source of the stream
//      - the intermediate operations
// - Consider the following example that prints the elements of an instance of ArrayList with the forEach operation several times

// %% tags=["keep"]
Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
List<Integer> listOfIntegers =
    new ArrayList<>(Arrays.asList(intArray));

// %% tags=["keep"]
System.out.println("listOfIntegers:");
listOfIntegers
    .stream()
    .forEach(e -> System.out.print(e + " "));

// %% tags=["keep"]
System.out.println("listOfIntegers sorted in reverse order:");
Comparator<Integer> normal = Integer::compare;
Comparator<Integer> reversed = normal.reversed(); 
Collections.sort(listOfIntegers, reversed);  
listOfIntegers
    .stream()
    .forEach(e -> System.out.print(e + " "));

// %% tags=["keep"]     
System.out.println("Parallel stream");
listOfIntegers
    .parallelStream()
    .forEach(e -> System.out.print(e + " "));

// %% tags=["keep"]    
System.out.println("Another parallel stream:");
listOfIntegers
    .parallelStream()
    .forEach(e -> System.out.print(e + " "));
     
// %% tags=["keep"]
System.out.println("With forEachOrdered:");
listOfIntegers
    .parallelStream()
    .forEachOrdered(e -> System.out.print(e + " "));

// %%
// * The third and fourth pipelines print the elements of the list in an apparently random order. 
// Remember that stream operations use internal iteration when processing elements of a stream. Consequently, when you execute a stream in parallel, the Java compiler and runtime determine the order in which to process the stream's elements to maximize the benefits of parallel computing unless otherwise specified by the stream operation.
// The fifth pipeline uses the method forEachOrdered, which processes the elements of the stream in the order specified by its source, 
// regardless of whether you executed the stream in serial or parallel. 
// Note that you may lose the benefits of parallelism if you use operations like forEachOrdered with parallel streams.

// %% [markdown] lang="en" tags=["slide"]
// ## Side Effects
// - A method or an expression has a side effect if in addition to returning a value, it also modifies the state of the computer.
// - Example: System.out.println() has a side effect because it modifies the state of the computer by printing a string on the console.
// - Take care for example when using `forEach`: the Java runtime may invoke the lambda expression concurrently from multiple threads, which may lead to unpredictable results.

// %% [markdown] lang="en" tags=["slide"]
// ## Interference
// - Lambda expressions in stream operations should not interfere
// - Interference occurs when the source of a stream is modified while a pipeline processes the stream

// %% tags=["start"]
List<String> listOfStrings = new ArrayList<>(Arrays.asList("one", "two"));
         
String concatenatedString = listOfStrings
    .stream()    
    .reduce((a, b) -> a + " " + b)
    .get();
                 
System.out.println("Concatenated string: " + concatenatedString);
         

// %% tags=["alt"]
try {
    List<String> listOfStrings =
        new ArrayList<>(Arrays.asList("one", "two"));
         
    // This will fail as the peek operation will attempt to add the
    // string "three" to the source after the terminal operation has
    // commenced. 
    String concatenatedString = listOfStrings
        .stream()
        // Don't do this! Interference occurs here.
        .peek(s -> listOfStrings.add("three"))
        .reduce((a, b) -> a + " " + b)
        .get();
    System.out.println("Concatenated string: " + concatenatedString);
} catch (Exception e) {
    System.out.println("Exception caught: " + e.toString());
}

// This example concatenates the strings contained in listOfStrings into an Optional<String> value with the reduce operation, 
// which is a terminal operation. However, the pipeline here invokes the intermediate operation peek, which attempts to add a new 
// element to listOfStrings. Remember, all intermediate operations are lazy. This means that the pipeline in this example begins 
// execution when the operation get is invoked, and ends execution when the get operation completes. 
// The argument of the peek operation attempts to modify the stream source during the execution of the pipeline, which causes the 
// Java runtime to throw a ConcurrentModificationException.

// %% [markdown] lang="en" tags=["slide"]
// ## Stateful Lambda Expressions
// - Avoid using stateful lambda expressions as parameters in stream operations
// - A stateful lambda expression is one whose result depends on any state that might change during the execution of a pipeline

// %% tags=["keep"]
Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

// %% tags=["keep"]
List<Integer> serialStorage = new ArrayList<>();

// %% tags=["keep"]     
System.out.println("Serial stream:");
listOfIntegers
    .stream()
    .map(e -> { serialStorage.add(e); return e; })
    .forEachOrdered(e -> System.out.print(e + " "));

// %% tags=["keep"]
serialStorage
    .stream()
    .forEachOrdered(e -> System.out.print(e + " "));

// %% tags=["keep"]
System.out.println("Parallel stream:");
List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());

listOfIntegers
    .parallelStream()
    // Don't do this! It uses a stateful lambda expression.
    .map(e -> { parallelStorage.add(e); return e; })
    .forEachOrdered(e -> System.out.print(e + " "));
     
// %% tags=["keep"]
parallelStorage
    .stream()
    .forEachOrdered(e -> System.out.print(e + " "));

// %%
// The order in which the lambda expression e -> { parallelStorage.add(e); return e; } adds elements to the List parallelStorage can vary every time the code is run.
// For deterministic and predictable results, ensure that lambda expression parameters in stream operations are not stateful.

// %% [markdown] lang="en" tags=["slide"]
// - The lambda expression e -> { parallelStorage.add(e); return e; } is a stateful lambda expression. 
// - Its result can vary every time the code is run

// %% [markdown] lang="en" tags=["slide"]
// ## Notes
// - The code above invokes the method `syncrhonizedList` to create a synchronized List object, which is thread-safe.
// - Remember that collections are not thread-safe by default (multiple threads should not access them concurrently)
// - Suppose we did not use a synchronized List object in the code above.


// %% tags=["keep"]
List<Integer> parallelStorage = new ArrayList<>();

System.out.println("Parallel stream:");
listOfIntegers
    .parallelStream()
    // Don't do this! It uses a stateful lambda expression.
    .map(e -> { parallelStorage.add(e); return e; })
    .forEachOrdered(e -> System.out.print(e + " "));
    System.out.println("");
parallelStorage
    .stream()
    .forEachOrdered(e -> System.out.print(e + " "));

// %% [markdown] lang="en" tags=["slide"]
// - The result could look like this:
// ```java 
// Parallel stream:
// 8 7 6 5 4 3 2 1
// null 3 5 4 7 8 1 2
// ```




// %% tags=["keep"]
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// %%
int sum = numbers.parallelStream()
                 .mapToInt(i -> i * 2)
                 .sum();
sum;

// %% [markdown] lang="en" tags=["slide"]
// ## Exercise on Parallel Streams
// - Create an ArrayList of 100 random integers. 
// - Use a parallelStream to process the integers and calculate the sum of squares of all the integers.

// %%
import java.util.stream.IntStream;

// %% 
List<Integer> list = new ArrayList<>();
Random rand = new Random();

// %%
// Generating 100 Random Integers and adding them to list
IntStream.range(0,100).forEach(i -> list.add(rand.nextInt()));

// Using parallelStream() to calculate sum of squares of integers
int sum = list.parallelStream().mapToInt(i -> i * i).sum();

System.out.println("The sum of squares is : " + sum);

// %% [markdown] lang="en" tags=["slide"]
// ## Workshop : Performance of Parallel Streams
// - Parallel streams might not be beneficial for small data sets as thread management overhead might surpass performance gain.
// - In this workshop we will evaluate the performance of a for loop, a sequential stream, and a parallel stream.

// %% tags=["keep"]
public static int[] numbers;
private static final int MAX_VALUE = 10000;
private static final int LARGE_THRESHOLD = 8000;
private static final int NUMBER_OF_NUMBERS = 50000000;

// %%
public static long countLargeNumbersLoop() {
    long result = 0;
    for (int n : numbers) {
        if (n >= LARGE_THRESHOLD) {
            result++;
        }
    }
    return result;
}

// %% 
public static long countLargeNumbersStream() {
    final IntStream stream = Arrays.stream(numbers);
    return stream.filter(n -> n >= LARGE_THRESHOLD).count();
}

// %% 
public static long countLargeNumbersParallelStream() {
    final IntStream stream = Arrays.stream(numbers).parallel();
    return stream.filter(n -> n >= LARGE_THRESHOLD).count();
}

// %% tags=["keep"]
public static String formatResult(String type, long result, long time, double ratio) {
    return String.format("%-16s %8d, %8d (%.0f%%)", type + ":", result, time / 1000, ratio * 100);
}

// %% tags=["keep"]
public static void printResult(String type, long result, long time, double ratio) {
    System.out.println(formatResult(type, result, time, ratio));
}
    

// %% tags=["keep"]
numbers = new int[NUMBER_OF_NUMBERS];
Random rand = new Random();
for (int i = 0; i < numbers.length; i++) {
    numbers[i] = rand.nextInt(MAX_VALUE);
}

// %% tags=["keep"]
public void evaluate(){
    long startTime = System.nanoTime();
    long largeNumbersLoop = countLargeNumbersLoop();
    long largeNumbersLoopTime = System.nanoTime() - startTime;

    startTime = System.nanoTime();
    long largeNumbersStream = countLargeNumbersStream();
    long largeNumbersStreamTime = System.nanoTime() - startTime;
    double largeNumbersStreamRatio = (double) largeNumbersStreamTime / largeNumbersLoopTime;

    startTime = System.nanoTime();
    long largeNumbersParallelStream = countLargeNumbersParallelStream();
    long largeNumbersParallelStreamTime = System.nanoTime() - startTime;
    double largeNumbersParallelStreamRatio = (double) largeNumbersParallelStreamTime / largeNumbersLoopTime;

    System.out.println("Comparison:    " + NUMBER_OF_NUMBERS + " elements");
    printResult("Loop", largeNumbersLoop, largeNumbersLoopTime, 1.0);
    printResult("Stream", largeNumbersStream, largeNumbersStreamTime, largeNumbersStreamRatio);
    printResult("Parallel Stream", largeNumbersParallelStream, largeNumbersParallelStreamTime, largeNumbersParallelStreamRatio);
}

// %% tags=["keep"]
evaluate();


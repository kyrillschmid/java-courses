// j2 from 'macros.j2' import header
// {{ header("Einführung in Streams", "Introdution to Streams") }}

// %% [markdown] lang="en" tags=["slide"]
// ## What do you use collections for?
// - You don't simply store objects in a collection and leave them there
// - In most cases, you use collections to retrieve items stored in them

// %% [markdown] lang="en" tags=["slide"]
// ## Consider a scenario
// - Suppose that you are creating a social networking application
// - You want to create a feature that enables an administrator to perform any kind of action, such as sending a message, on members that satisfy certain criteria
// - Suppose that members of this social networking application are represented by the following Person class:

// %% tags=["slide", "keep"]
public class Person {

    private int age;
    private String name;
    private Sex gender;

    public enum Sex {
        MALE, FEMALE, OTHER
    }

    public Person(int age, String name, Sex gender) {
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

    public Sex getGender(){
        return gender;
    }

    public String toString() {
    return "Person{" +
            "age=" + age +
            ", name='" + name + '\'' +
            ", gender='" + gender + '\'' +            
            '}';
    }
}

// %% tags=["slide", "keep" ]
public List<Person> createPeopleList() {
    return Arrays.asList(
        new Person(35, "Eve", Person.Sex.FEMALE),
        new Person(33, "Alice", Person.Sex.FEMALE),
        new Person(23, "Charlie", Person.Sex.MALE),
        new Person(28, "Diana", Person.Sex.FEMALE),
        new Person(38, "Bob", Person.Sex.MALE)
    );   
}

// %%
List<Person> people = createPeopleList();


// %% [markdown] lang="en" tags=["slide"]
// - The following example prints the name of all members contained in the collection 'people' with a for-each loop:

// %%
for (Person p : people) {
     System.out.println(p.getName());
}

// %% [markdown] lang="en" tags=["slide"]
// ## Aggregate operations
// - The following example prints all members contained in the collection 'people' but with the aggregate operation 'forEach'

// %%
people
    .stream()
    .forEach(e -> System.out.println(e.getName()));

// %% [markdown] lang="en" tags=["slide"]
// ## Pipelines and Streams
// A pipeline is a sequence of aggregate operations
// ```java
// source.stream().aggregateOperation1().aggregateOperation2().aggregateOperation3()...
// ```

// %% [markdown] lang="en" tags=["slide"]
// - We can use pipelines to process collections of data
// - For example we can print the male members contained in the collection 'people'
// - We need a filter and a forEach aggregate operation

// %%
people
     .stream()
     .filter(e -> e.getGender() == Person.Sex.MALE)
     .forEach(e -> System.out.println(e.getName()));


// %% [markdown] lang="en" tags=["slide"]
// - Lets compare this with the for-each loop:

// %%
for (Person p : people) {
    if (p.getGender() == Person.Sex.MALE) {
        System.out.println(p.getName());
    }
}

// %% [markdown] lang="en" tags=["slide"]
// ## Streams
// - A stream is a sequence of elements
// - Unlike a collection, it is not a data structure that stores elements
// - Instead, a stream carries values from a source through a pipeline
// - This example creates a stream from the collection people by invoking the method stream

// %% [markdown] lang="en" tags=["slide"]
// - Consider the following pipeline:
//
// ```java
// people
//    .stream()
//     .filter(e -> e.getGender() == Person.Sex.MALE)
//     .forEach(e -> System.out.println(e.getName()));
// ```
//
// It contains the following components:
// - A source: This could be a collection, an array, a generator function, or an I/O channel
// - Zero or more intermediate operations: An intermediate operation, such as 'filter', produces a new stream
// - A terminal operation: A terminal operation, such as 'forEach'
//     - produces a non-stream result, such as a primitive value, a collection, or no value at all

// %% [markdown] lang="en" tags=["slide"]
// ## Example: Calculate average age
// The following example calculates the average age of all male members contained in the collection 'people' with a pipeline that consists of the aggregate operations 'filter', 'mapToInt', and 'average':

// %%
double average = people
     .stream()
     .filter(p -> p.getGender() == Person.Sex.MALE)
     .mapToInt(Person::getAge)
     .average()
     .getAsDouble();

// %% [markdown] lang="en" tags=["slide"]
// ## Differences Between Aggregate Operations and Iterators
// Aggregate operations, like 'forEach', appear to be like iterators. However, they have several fundamental differences:
// - They use internal iteration: Aggregate operations do not contain a method like 'next' to instruct them to process the next element of the collection
//      - Internal iteration: Only specify what to iterate over not how (parallelization is possible)
//      - External iteration: Specify both what and how to iterate over (sequential)
// - They process elements from a stream: Aggregate operations process elements from a stream, not directly from a collection (also called stream operations)
// - They support behavior as parameters: You can specify lambda expressions as parameters for most aggregate operations

// %% [markdown] lang="en" tags=["slide"]
// ## Mini-Workshop
// 
// 1. Write the following enhanced for statement as a pipeline with lambda expressions
// Hint: Use the filter intermediate operation and the forEach terminal operation

// %% tags=["keep"]
for (Person p : people) {
    if (p.getGender() == Person.Sex.MALE) {
        System.out.println(p.getName());
    }
}

// %% 
people
    .stream()
    .filter(e -> e.getGender() == Person.Sex.MALE)
    .forEach(e -> System.out.println(e.getName());

// %% [markdown] lang="en" tags=["slide"]
// 2. Convert the following code into a new implementation that uses lambda expressions and aggregate operations instead of nested for loops
// Hint: Make a pipeline that invokes the filter, sorted, and collect operations, in that order.

// %% tags=["keep"]
List<Album> favs = new ArrayList<>();
for (Album a : albums) {
    boolean hasFavorite = false;
    for (Track t : a.tracks) {
        if (t.rating >= 4) {
            hasFavorite = true;
            break;
        }
    }
    if (hasFavorite)
        favs.add(a);
}

// %% tags=["keep"]
Collections.sort(favs, new Comparator<Album>() {
                           public int compare(Album a1, Album a2) {
                               return a1.name.compareTo(a2.name);
                           }});

// %%
List<Album> sortedFavs =
  albums.stream()
        .filter(a -> a.tracks.anyMatch(t -> (t.rating >= 4)))
        .sorted(Comparator.comparing(a -> a.name))
        .collect(Collectors.toList());

// %% [markdown] lang="en" tags=["notes"]
// Here we have used the stream operations to simplify each of the three major steps -- identification of whether any track in an album has a rating of at least 4 (anyMatch), the sorting, and the collection of albums matching our criteria into a List. The Comparator.comparing() method takes a function that extracts a Comparable sort key, and returns a Comparator that compares on that key.


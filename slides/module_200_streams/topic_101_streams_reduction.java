// j2 from 'macros.j2' import header
// {{ header("Streams - Reduction", "Streams - Reduction") }}

// %% [markdown] lang="en" tags=["slide"]
// ## Introduction
// - The JDK contains many terminal operations like `average`, `sum`, `min`, `max`, and `count` 
// - These methods return one value by combining the contents of a stream (called reduction operations)
// - The JDK also provides more general-purpose reduction operations `reduce` and `collect` which we will explore in this notebook

// %% tags=["keep"]
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

// %% tags=["slide", "keep"]
public List<Person> createPeopleList() {
    return Arrays.asList(
        new Person(35, "Eve", Person.Sex.FEMALE),
        new Person(33, "Alice", Person.Sex.FEMALE),
        new Person(23, "Charlie", Person.Sex.MALE),
        new Person(28, "Diana", Person.Sex.FEMALE),
        new Person(38, "Bob", Person.Sex.MALE)
    );   
}

// %% tags=["keep"]
List<Person> people = createPeopleList();


// %% [markdown] lang="en" tags=["slide"]
// - In the last notebook we used a pipeline to calculate the average age from the people list:

// %% tags=["keep"]
people
     .stream()
     .filter(p -> p.getGender() == Person.Sex.MALE)
     .mapToInt(Person::getAge)
     .average()
     .getAsDouble();

// %% [markdown] lang="en" tags=["slide"]
// - The JDK contains many specific terminal operations that return one value by combining the contents of a stream
//      - For example: `average`, `sum`, `min`, `max`, `count` (called reduction operations)
// - The JDK also contains reduction operations that return a collection instead of a single value
// - Many reduction operations perform a specific task, such as finding the average of values or grouping elements into categories
// - `reduce` and `collect` are more general-purpose reduction operations that you can use to perform arbitrary operations on the contents of a stream

// %% [markdown] lang="en" tags=["slide"]
// ## The Stream.reduce Method
// - The `Stream.reduce` method is a general-purpose reduction operation
// - Consider the following pipeline, which calculates the sum of the male members' ages in the collection `people`

// %%
people
     .stream()
     .mapToInt(Person::getAge)
     .sum();

// %% [markdown] lang="en" tags=["slide"]
// - Compare this with the following pipeline, which uses the `Stream.reduce` operation to calculate the same value:

// %%
people
   .stream()
   .map(Person::getAge)
   .reduce(
       0,
       (a, b) -> a + b)

// %% [markdown] lang="en" tags=["slide"]
// The `reduce` method takes two parameters:
// - **Identity**: The identity element is both the initial value of the reduction and the default result 
// - **Accumulator**: The accumulator function takes two parameters: a partial result of the reduction and the next element of the stream
// ```java
// (a, b) -> a + b
// ```

// %% [markdown] lang="en" tags=["slide"]
// - The `reduce` method always returns a new value
// - However, the accumulator function also returns a new value every time it processes an element of a stream
// - If the reduce operation involves adding elements to a collection, then every time the accumulator function processes an element, it creates a new collection that includes the element
// - It would be more efficient to update an existing collection instead


// %% [markdown] lang="en" tags=["slide"]
// ## The Stream.collect Method
// - Unlike the `reduce` method, which always creates a new value when it processes an element, the `collect` method modifies, or mutates, an existing value
// - The collect method also returns only one value
// - To calculate the average we therefore could create a new data type that holds the total and the count of elements:

// %%
import java.util.function.IntConsumer;

class Averager implements IntConsumer
{
     private int total = 0;
     private int count = 0;
         
     public double average() {
         return count > 0 ? ((double) total)/count : 0;
     }
         
     public void accept(int i) { total += i; count++; }
     public void combine(Averager other) {
         total += other.total;
         count += other.count;
     }
 }

// %% [markdown] lang="en" tags=["slide"]
// - The following pipeline uses the Averager class and the collect method to calculate the average age of all male members:

// %% tags=["start"]
Averager averageCollect = people.stream()
    .filter(p -> p.getGender() == Person.Sex.MALE)
    .map(Person::getAge)
    .collect(...);

// %% tags=["alt"]
Averager averageCollect = people.stream()
    .filter(p -> p.getGender() == Person.Sex.MALE)
    .map(Person::getAge)
    .collect(Averager::new, Averager::accept, Averager::combine);
                
 // %%
 averageCollect.average();

// %% [markdown] lang="en" tags=["slide"]
// The collect operation in this example takes three arguments:
// - **Supplier**: The supplier is a factory function; it constructs new instances
//      - For the collect operation, it creates instances of the result container
//      - In this example, it is a new instance of the Averager class
// - **Accumulator**: The accumulator function incorporates a stream element into a result container
//      -  In this example, it modifies the Averager result container by incrementing the count variable by one and adding to the total member variable the value of the stream element
// - **Combiner**: The combiner function takes two result containers and merges their contents
//      - It modifies an `Averager` result container by incrementing the count variable by the count member variable of the other `Averager` instance 
//      - It adds to the total member variable the value of the other Averager instance's total member variable

// %% [markdown] lang="en" tags=["slide"]
// ## More Reduction Examples
// - The `collect` operation is best suited for collections
// - In the following example we put the names of the female members in a collection into a list
// - This version of the `collect` operation takes one parameter of type `Collector`

// %%
import java.util.stream.Collectors;

// %%
List<String> namesOfMaleMembersCollect = people
     .stream()
     .filter(p -> p.getGender() == Person.Sex.FEMALE)
     .map(p -> p.getName())
     .collect(Collectors.toList());

// %% 
namesOfMaleMembersCollect

// %% [markdown] lang="en" tags=["slide"]
// - The `Collectors` class provides many useful reduction operations
//      - Accumulating elements into collections 
//      - Summarizing elements according to various criteria
// - These reduction operations return instances of the class `Collector` so it can be passed to the `collect` method

// %% [markdown] lang="en" tags=["slide"]
// - The following example groups members of the collection by gender

// %%
Map<Person.Sex, List<Person>> byGender =
     people
         .stream()
         .collect(
             Collectors.groupingBy(Person::getGender));

// %% 
byGender

// %% [markdown] lang="en" tags=["slide"]
// - The `groupingBy` operation returns a map whose keys are the values that result from applying the lambda expression specified as its parameter 
// - In this example, the returned map contains two keys, `Person.Sex.MALE` and `Person.Sex.FEMALE`
// - The keys' corresponding values are instances of List that contain the stream elements that, when processed by the classification function, correspond to the key value

// %% [markdown] lang="en" tags=["slide"]
// - The following example retrieves the names of each member in the collection `people` and groups them by gender

// %% tags=["start"]
Map<Person.Sex, List<String>> namesByGender =
    people
        .stream()
        .collect(
            Collectors.groupingBy(...);

// %% tags=["alt"]
Map<Person.Sex, List<String>> namesByGender =
    people
        .stream()
        .collect(
            Collectors.groupingBy(
                Person::getGender,                      
                Collectors.mapping(
                    Person::getName,
                    Collectors.toList())));

// %%
namesByGender

// %% [markdown] lang="en" tags=["slide"
// - The `groupingBy` operation in this example takes two parameters:
//      - The first parameter is the classification function, which specifies how the elements are classified
//      - The seconnd parameter is a `Collector` and is called a downstream collector. 
//      - This is a collector that the Java runtime applies to the results of another collector.
//      - Consequently, this `groupingBy` operation enables you to apply a `collect` method to the List values created by the groupingBy operator


// %% [markdown] lang="en" tags=["slide"]
// - The following example retrieves the total age of the member of each gender

// %% tags=["start"]
Map<Person.Sex, Integer> totalAgeByGender =
    people
        .stream()
        .collect(
            Collectors.groupingBy(...);

// %% tags=["alt"]
Map<Person.Sex, Integer> totalAgeByGender =
    people
        .stream()
        .collect(
            Collectors.groupingBy(
                Person::getGender,                      
                Collectors.reducing(
                    0,
                    Person::getAge,
                    Integer::sum)));

// %% [markdown] lang="en" tags=["slide"]
// The reducing operation takes three parameters:
// - **Identity**: Like the `Stream.reduce` operation, the identity element is both the initial value of the reduction and the default result if there are no elements in the stream
//      - In this example, the identity element is 0; this is the initial value of the sum of ages and the default value if no members exist
// - **Mapper**: The reducing operation applies this mapper function to all stream elements
//      -  In this example, the mapper retrieves the age of each member
// - **Operation**: The operation function is used to reduce the mapped values
//      - In this example, the operation function adds Integer values.        

// %% [markdown] lang="en" tags=["slide"] 
// ## Mini-Workshop
// - Build a pipeline to retrieve the average age of members of each gender
// - Use the `groupingBy` and `averagingInt` operations from the `Collectors` class

// %%
Map<Person.Sex, Double> averageAgeByGender = people
     .stream()
     .collect(
         Collectors.groupingBy(
             Person::getGender,                      
             Collectors.averagingInt(Person::getAge)));
// j2 from 'macros.j2' import header
// {{ header("Lambda Expressions 2", "Lambda Expressions 2") }} 

// %% [markdown] lang="en" tags=["slide"]
// - In the last notebook we saw how we can use lambda expressions to pass code as data.
// - What if we just want to use lambdas without defining a new interface?

// %% [markdown] lang="en" tags=["slide"]
// ## Further Improvements
// - Use standard functional interfaces with lambda expressions
// - The Java Development Kit(JDK) defines several standard functional interfaces, which you can find in the package `java.util.function`.

// %% tags=["keep", "slide" ]
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

    public void printPerson() {
        System.out.println(this.toString());
    }
}

// %% tags=["keep"]
List<Person> people = Arrays.asList(
            new Person(30, "Alice", "Female"),
            new Person(35, "Bob", "Male"),
            new Person(28, "Carol", "Female"),
            new Person(40, "David", "Male"),
            new Person(21, "Joe", "Male"));


// %% [markdown] lang="en" tags=["slide"]
// ## Functional Interfaces
// - Let's revisit the `CheckPerson` interface from the previous notebook
// - It's a functional interface because it contains only one abstract method. 
// - This method takes one parameter and returns a boolean value. 
// - The method is so simple that it might not be worth it to define one in your application.

// %%
interface CheckPerson {
    boolean test(Person p);
}

// %% [markdown] lang="en" tags=["slide"]
// - Consequently, the JDK defines several standard functional interfaces, which you can find in the package java.util.function.
// - For example, you can use the Predicate<T> interface in place of CheckPerson. 
// - The Predicate<T> interface contains the method boolean `test(T t)`:


// %% 
interface Predicate<T> {
    boolean test(T t);
}


// %%
public static void printPersonsWithPredicate(
    List<Person> people, Predicate<Person> tester) {
    for (Person p : people) {
        if (tester.test(p)) {
            p.printPerson();
        }
    }
}

// %% 
printPersonsWithPredicate(
    people,
    p -> p.getGender().equals("Male")
        && p.getAge() >= 18
        && p.getAge() <= 25
);


// %% [markdown] lang="en" tags=["slide"]
// - The interface Predicate<T> is an example of a generic interface. 
// - Generic types (such as generic interfaces) specify one or more type parameters within angle brackets (<>). 
// - This interface contains only one type parameter, T. When you declare or instantiate a generic type with actual type arguments, you have a parameterized type. 


// %% [markdown] lang="en" tags=["slide"]
// ## Use Lambda Expressions Throughout Your Application
// - Reconsider the method printPersonsWithPredicate to see where else you could use lambda expressions
// - Instead of invoking the method printPerson, you can specify a different action to perform on those Person instances that satisfy the criteria specified by tester
// - We could use the `Consumer<T>` interface which contains the method `void accept(T t)`

// %% tags=["start"]
public static void printPersonsWithPredicate(
    List<Person> people, Predicate<Person> tester) {
    for (Person p : people) {
        if (tester.test(p)) {
            p.printPerson();
        }
    }
}

// %% tags=["alt"]
public static void processPersons(
    List<Person> people,
    Predicate<Person> tester,
    Consumer<Person> block) {
        for (Person p : people) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
}

// %% [markdown] lang="en" tags=["slide"]
// - As a result, the following method invocation is the same as when you invoked printPersons in Approach 3:

// %% 
processPersons(
    people,
    p -> p.getGender().equals("Male")
        && p.getAge() >= 18
        && p.getAge() <= 25,
    p -> p.printPerson()
);

// %% [markdown] lang="en" tags=["slide"]
// - What if you want to do more? 
// - Validate members' profiles, retrieve contact information?
// - You can use the `Function<T, R>` interface which contains the method `R apply(T t)` to return a value of type R

// %% tags=["start"]
public static void processPersons(
    List<Person> people,
    Predicate<Person> tester,
    Consumer<Person> block) {
        for (Person p : people) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
}

// %% tags=["alt"]
public static void processPersonsWithFunction(
    List<Person> people,
    Predicate<Person> tester,
    Function<Person, String> mapper,
    Consumer<String> block) {
    for (Person p : people) {
        if (tester.test(p)) {
            String data = mapper.apply(p);
            block.accept(data);
        }
    }
}

// %% [markdown] lang="en" tags=["slide"]
// - So this would yield us the following:


// %% tags=["start"]
processPersons(
    people,
    p -> p.getGender().equals("Male")
        && p.getAge() >= 18
        && p.getAge() <= 25,
    p -> p.printPerson()
);

// %% tags=["alt"]
processPersonsWithFunction(
    people,
    p -> p.getGender() == Person.Sex.MALE
        && p.getAge() >= 18
        && p.getAge() <= 25,
    p -> p.getEmailAddress(),
    email -> System.out.println(email)
);


// %% [markdown] lang="en" tags=["slide"]
// ## Use Generics More Extensively
// - Reconsider the method `processPersonsWithFunction`. The following is a generic version of it that accepts, as a parameter, a collection that contains elements of any data type

// %%
public static <X, Y> void processElements(
    Iterable<X> source,
    Predicate<X> tester,
    Function <X, Y> mapper,
    Consumer<Y> block) {
    for (X p : source) {
        if (tester.test(p)) {
            Y data = mapper.apply(p);
            block.accept(data);
        }
    }
}

// %% [markdown] lang="en" tags=["slide"]
// - To print the email addresses of members who satisfy the search criteria, you can invoke the following method:

// %%
processElements(
    people,
    p -> p.getGender().equals("Male")
        && p.getAge() >= 18
        && p.getAge() <= 25,
    p -> p.getEmailAddress(),
    email -> System.out.println(email)
);


// %% [markdown] lang="en" tags=["slide"]
//
// ## Workshop: Lambda Expressions
// Below we have a simple lambda expression which takes in an integer and returns the value multiplied by 2:
// ```
// (int x) -> x * 2;
// ```
// - Create a lambda expression which takes in a string and return its length.
// - Use the `Function` functional interface in the package `java.util.function` to create a lambda expression which takes in a string and return its length.

// %%
import java.util.function.Function;

// %% 
Function<String, Integer> lengthFunction = (String str) -> str.length();

// %%
lengthFunction.apply("Hello");

// %% [markdown] tags=["subslide"]
// ### The Comparator Functional Interface
// As a more complex example, lambda expressions can be used in the context of functional interfaces which are interfaces that specify exactly one abstract method, like `Runnable` or `Comparator<T>`.
//
// Here is an example with `Runnable`:
// ```
// Runnable run = () -> System.out.println("Lambda expression as a Runnable");
// run.run();
// ```
// Create a `Comparator<Integer>` using a lambda expression that will sort numbers in decreasing order.

// %%
Comparator<Integer> comp = (Integer a, Integer b) -> b - a;

// %%
List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
System.out.println("Original list: " + numbers);

// %%
Collections.sort(numbers, comp);
System.out.println("Sorted list in descending order: " + numbers);

// %% [markdown] tags=["subslide"]
// ### The Predicate Functional Interface
//
// Predicate is a functional interface that represents a boolean-valued-function of an input. It is often used in all kinds of filtering operations.
//
// Let's create a `Predicate<Integer>` that will check if an integer is greater than 5.

// %%
import java.util.function.Predicate;

// %%
Predicate<Integer> isGreaterThanFive = x -> x > 5;

// %%
isGreaterThanFive.test(6)


// %% [markdown] tags=["subslide"]
// ### The Function Functional Interface
//
// `Function<T, R>` is a functional interface that represents a function that accepts an argument and produces a result. The argument and result can be of different types. 
//
// Create a `Function<String, Integer>`, that will return the length of a string.

// %%
Function<String, Integer> lengthFunc = str -> str.length();

// %%
lengthFunc.apply("Lambda expression");


// j2 from 'macros.j2' import header
// {{ header("Lambda Expressions", "Lambda Expressions") }} 

// %% [markdown] lang="en" tags=["slide"]
// ## Overview 
// - One issue with anonymous classes is that if the implementation of your anonymous class is very simple, such as an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear. 

// %% 
interface MathOperation {
    int operation(int a, int b);
}

// %% 
MathOperation addition = new MathOperation() {
    @Override
    public int operation(int a, int b) {
        return a + b;
    }
};

// %% [markdown] lang="en" tags=["slide"]
// - Lambda expressions enable you to treat functionality as method argument, or code as data.
// - This section covers the following topics:
//     - Ideal Use Case for Lambda Expressions
//     - Syntax of Lambda Expressions
// - This notebook will cover these topics with examples and provide a thorough understanding of how to use Lambda Expressions in Java programming.

// %% [markdown] lang="en" tags=["slide"]
// ## Ideal Use Case for Lambda Expressions
// - Suppose that you are creating a social networking application. 
//      - You want to create a feature that enables an administrator to perform any kind of action
//      - E.g. sending a message, on members of the social networking application that satisfy certain criteria.

// %%
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

// %% 
List<Person> people = Arrays.asList(
            new Person(30, "Alice", "Female"),
            new Person(35, "Bob", "Male"),
            new Person(28, "Carol", "Female"),
            new Person(40, "David", "Male"),
            new Person(21, "Joe", "Male"));


// %% [markdown] lang="en" tags=["slide"]
// ## First Approach
// - Create methods that search for members that match one characteristic
// - One simplistic approach is to create several methods; each method searches for members that match one characteristic, such as gender or age.

// %%
public static void printPersonsOlderThan(List<Person> people, int age) {
    for (Person p : people) {
        if (p.getAge() >= age) {
            p.printPerson();
        }
    }
}

// %% 
printPersonsOlderThan(people, 30);

// %% [markdown] lang="en" tags=["slide"]
// - This approch works but might make your application a little brittle
//      - What if the Person class changes? 
//      - What if you want to print members younger than a certain age, or members within a certain range of ages?

// %% [markdown] lang="en" tags=["slide"]
// ## Second Approach
// - Idea: Create more generalized search methods
// - The following method is more generic than `printPersonsOlderThan`; it prints members within a specified range of ages:

// %%
public static void printPersonsWithinAgeRange(
    List<Person> people, int low, int high) {
    for (Person p : people) {
        if (low <= p.getAge() && p.getAge() < high) {
            p.printPerson();
        }
    }
}

// %%
printPersonsWithinAgeRange(people, 30, 40);

// %% [markdown] lang="en" tags=["slide"
// - This method is more generic than printPersonsOlderThan, but it is still limited.
//      - What if you want to print members of a specified sex, or a combination of a specified gender and age range? 
//      - What if you decide to change the Person class and add other attributes such as relationship status or geographical location? 
// - Although this method is more generic than printPersonsOlderThan, trying to create a separate method for each possible search query can still lead to brittle code. 

// %% [markdown] lang="en" tags=["slide"]
// ## Third Approach
// - Idea: Separate the code that specifies the criteria for which you want to search in a different class.

// %%
interface CheckPerson {
    boolean test(Person p);
}

// %% [markdown] lang="en" tags=["slide"]
// - The following method prints members that match search criteria that you specify:

// %%
public static void printPersons(
    List<Person> people, CheckPerson tester) {
    for (Person p : people) {
        if (tester.test(p)) {
            p.printPerson();
        }
    }
}

// %% [markdown] lang="en" tags=["slide"]
// - To specify the search criteria, you implement the interface CheckPerson, which contains the method test.
// - The following method checks whether a Person is eligible for Selective Service:

// %%
class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.getGender().equals("Male") &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}

// %% [markdown] lang="en" tags=["slide"]
// - To use this class you create a new instance of it and invoke the method printPersons:

// %% 
printPersons(people, new CheckPersonEligibleForSelectiveService());

// %% [markdown] lang="en" tags=["slide"]
// - This approach is less brittle (you don't have to rewrite methods if you change the structure of the Person)
// - Downside: more code (a new interface and a local class for each search you plan to perform in your application)

// %% [markdown] lang="en" tags=["slide"]
// ## Fourth Approach
// - Idea: Specify search criteria code in an anonymous class
// - One of the arguments of the following invocation of the method `printPersons` is an anonymous class that filters members that are eligible for Selective Service in the United States: those who are male and between the ages of 18 and 25:

// %%
printPersons(
    people,
    new CheckPerson() {
        public boolean test(Person p) {
            return p.getGender().equals("Male")
                && p.getAge() >= 18
                && p.getAge() <= 25;
        }
    }
);

// %% [markdown] lang="en" tags=["slide"]
 // -  The syntax of an anonymous classes is bulky considering that the CheckPerson interface contains only one method. 

// %% [markdown] lang="en" tags=["slide"]
// ## Fifth Approach
// - Idea: directly pass the needed functionality code to the method
// - This is where lambda expressions come into play.

// %%
printPersons(
    people,
    (Person p) -> p.getGender().equals("Male")
        && p.getAge() >= 18
        && p.getAge() <= 25
);

// %% [markdown] lang="en" tags=["slide"]
// ## Lambda Expressions
// - The `CheckPerson` interface is a **functional interface**. 
//      - A functional interface is any interface that contains only one abstract method.
// - Because a functional interface contains only one abstract method, you can omit the name of that method when you implement it. 

// %% [markdown] lang="en" tags=["slide"]
// ## Syntax of Lambda Expressions
// ```java 
// (arg1, arg2, ...) -> { body }
// ```


// %% [markdown] lang="en" tags=["slide"]
//
// ## Workshop: Lambda Expressions
//
// - Let's assume we want to design a simple calculator that can perform basic operations on two numbers.
// - We want to be able to pass the operation as a parameter to the calculator.

// %% [markdown] lang="en" tags=["slide"]
// - Define an interface that contains a method that takes two integers and returns an integer.

// %%
interface MathOperation {
    int operation(int a, int b);
}

// %% [markdown] lang="en" tags=["slide"]
// - Use this functional interface to create instances of the following operations with lambda expressions:
//     - Addition
//     - Subtraction
//     - Multiplication
//     - Division

// %%
MathOperation addition = (a, b) -> a + b;
addition.operation(1, 2);

// %%
MathOperation subtraction = (a, b) -> a - b;
subtraction.operation(1, 2);

// %%
MathOperation multiplication = (a, b) -> a * b;
multiplication.operation(1, 2);

// %%
MathOperation division = (a, b) -> a / b;
division.operation(1, 2);

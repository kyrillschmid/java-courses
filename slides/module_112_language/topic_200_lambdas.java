// j2 from 'macros.j2' import header
// {{ header("Lambdas", "Lambdas") }}

// %% [markdown] lang="en" tags=["slide"]
// ## Motivation on Lambdas
// - Lambdas, also known as anonymous functions, are a key concept in functional programming and immensely powerful within such context. In Java, the Lambda, introduced in Java 8, provides a simple and concise way to represent one method interface using an expression.
// - Lambdas are a tool to reduce the boilerplate code and simplify your Java programs, especially when dealing with Collection API's methods.
// - They are excellent when we want to run a piece of code quickly without defining a whole new method elsewhere, hence making code more readable and efficient.

// %%
// Define a simple Lambda
Runnable r = () -> System.out.println("Hello, World!");

// Run the Lambda
r.run();

// %% [markdown] lang="en" tags=["slide"]
// ## Application of Lambdas
// - Lambdas, also known as 'anonymous functions' or 'lambda expressions', are a Java feature that is highly useful in functional programming.
// - They provide a compact and expressive way to represent single method interfaces (functional interfaces) using an expression.
// - They are extensively used in streams API and collections in Java to iterate, filter and extract data.
// - Lambdas can be used to simplify the syntax of other functional interfaces, such as Predicate, Function, and Supplier, making code shorter and clearer.
// - Beyond enhancing code readability, lambdas in Java also provide efficiency for parallel processing, which is especially beneficial in big data environments.


// %%
// Lambda Expression
Runnable r = () -> System.out.println("Hello, I'm a Java Lambda Function!");

// Run the lambda
r.run();

// %% [markdown] lang="en" tags=["slide"]
// ## Limitations of Lambdas
// - Lambdas in Java can only implement functional interfaces, which must contain only one abstract method.
// - They cannot contain instance variables or mutable local variables. They need effectively final or final local variables.
// - They do not have 'this' reference and cannot call default methods of an interface directly.
// - Handling checked exceptions within a lambda expression can be messy and verbose.

// %% [markdown] lang="en" tags=["slide"]
// ## Exercise: Lambdas in Java
// - Lambdas, also known as anonymous functions, can greatly increase the efficiency of your code. They are often used in functional programming within Java 8 onwards.
// - In this exercise, your task is to use a lambda to perform a specific operation. You have a list of integers. 
// - Task: Write a lambda expression that squares each integer in the list and filters out the numbers lesser than 10.
// - The list is: `[1,2,3,4,5,6,7,8,9,10]`

// %% [markdown] lang="en" tags=["slide"]
// ## Solution: Lambdas in Java 
// Here is an example solution using Java:
// ```java
// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Collectors;
//
// public class Main {
//     public static void main(String[] args) {
//     
//         List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//         
//         List<Integer> squaredNumbers = numbers.stream()
//                                      .map(n -> n * n)
//                                      .filter(n -> n > 10)
//                                      .collect(Collectors.toList());
//         
//         System.out.println(squaredNumbers);
//     }
// }
// ```
// This code will output `[16, 25, 36, 49, 64, 81, 100]`, which are the squared values of the numbers from 4 to 10, the numbers from the original list that, when squared, result in values greater than 10.



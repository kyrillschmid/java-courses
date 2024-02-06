// j2 from 'macros.j2' import header
// {{ header("Instanceof", "Instanceof") }}

// %% [markdown] lang="en" tags=["slide"]
// - The instanceof operator in Java cannot be used to determine if a type is a supertype of a given class
// - Instead, instanceof is used to check whether an object is an instance of a specified class or any of its subclasses

// %% [markdown] lang="en" tags=["slide"]
// - Using instanceof: This operator checks if an object is an instance of a specific class or an instance of any class that is a child (subclass) of that specific class
// - For example, if you have class Animal and class Dog extends Animal, and you create Dog myDog = new Dog(), then myDog instanceof Animal will return true because Dog is a subclass of Animal

// %%
class Animal {}

// %%
class Dog extends Animal {}

// %% [markdown] lang="en" tags=["slide"]
// - Checking for Supertypes: If you want to check if a certain class is a supertype of another class, you cannot use instanceof
// _ Java's reflection API can be used for this purpose
// - You can use methods like isAssignableFrom from the Class class. For example, Animal.class.isAssignableFrom(Dog.class) will return true, indicating that Animal is a supertype of Dog.

// %% 
Dog myDog = new Dog();

// %%
boolean result = myDog instanceof Animal;
result

// %%
// Checking if Animal is a supertype of Dog
boolean isSuperType = Animal.class.isAssignableFrom(Dog.class);
isSuperType
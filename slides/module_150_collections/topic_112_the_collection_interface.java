// j2 from 'macros.j2' import header
// {{ header("Das Collection-Interface", "The Collection Interface") }} 

// %% [markdown] lang="en" tags=["slide"]
// ## Introduction
// - A Collection represents a group of objects known as its elements
// - For example, you have a Collection<String> c, which may be a List, a Set, or another kind of Collection

// %%
Collection<String> c = new HashSet<>(Arrays.asList("one", "two", "three", "four"));

// %% [markdown] lang="en" tags=["slide"]
// - The Collection interface is used to pass around collections of objects where maximum generality is desired
// - This idiom creates a new ArrayList (an implementation of the List interface), initially containing all the elements in c.

// %%
List<String> list = new ArrayList<String>(c);

// %%
list

// %% [markdown] lang="en" tags=["slide"]
// Or — if you are using JDK 7 or later — you can use the diamond operator:

// %%
List<String> list = new ArrayList<>(c);

// %%
list

// %%% [markdown] lang="en" tags=["slide"]
// ## The Collection Interface Methods
// - The Collection interface contains methods that perform basic operations, such as 
//      - `int size()`, `boolean isEmpty()`, `boolean contains(Object element)`
//      - `boolean add(E element)`, `boolean remove(Object element)`
// - It also contains methods that operate on entire collections
// - Additional methods for array operations (such as `Object[] toArray()` and `<T> T[] toArray(T[] a)`) exist as well
// - In JDK 8 and later, the Collection interface also exposes methods `Stream<E> stream()` and `Stream<E> parallelStream()`

// %% [markdown] lang="en" tags=["slide"]
// ## Traversing Collections
// There are three ways to traverse collections:
// - Using aggregate operations 
// - With the for-each construct 
// - By using Iterators 

// %% [markdown] lang="en" tags=["slide"]
// ## Aggregate Operations
// - In JDK 8 and later, the preferred method of iterating over a collection is to obtain a stream 
// - Aggregate operations are often used in conjunction with lambda expressions 

// %%
list.stream()
.filter(s -> s.contains("o"))
.forEach(e -> System.out.println(e));

// %% [markdown] lang="en" tags=["slide"]
// -  You could easily request a parallel stream, which might make sense if the collection is large enough and your computer has enough cores

// %%
list.parallelStream()
.filter(s -> s.contains("o"))
.forEach(e -> System.out.println(e));

// %% [markdown] lang="en" tags=["slide"
// - We will learn more about streams in the lesson on aggregate operations

// %% [markdown] lang="en" tags=["slide"]
// ## for-each Construct
// - The for-each construct allows you to concisely traverse a collection or array using a for loop
// ```java
// for (Object o : collection)
//    System.out.println(o);
// ```

// %% 
list.forEach(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// ## Iterators
// - An Iterator is an object that enables you to traverse through a collection and to remove elements from the collection selectively, if desired

// %%
public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove(); //optional
}

// %% [markdown] lang="en" tags=["slide"]
// - The following method shows you how to use an Iterator to filter an arbitrary Collection 
// - Here, we traverse the collection and remove specific elements
// - Its polymorphic (works for any Collection regardless of implementation)
// ```java
// static void filter(Collection<?> c) {
//    for (Iterator<?> it = c.iterator(); it.hasNext(); )
//        if (!cond(it.next()))
//            it.remove();
//}
// ```

// %%
static void filter(Collection<?> c) {
    for (Iterator<?> it = c.iterator(); it.hasNext(); )
        if (!it.next().toString().contains("o"))
            it.remove();
}

// %%
filter(list);

// %%
list

// %% [markdown] lang="en" tags=["slide"]
// ## Bulk Operations
// Bulk operations perform an operation on an entire collection:
// - `containsAll` — returns true if the target Collection contains all of the elements in the specified Collection
// - `addAll` — adds all of the elements in the specified Collection to the target Collection
// - `removeAll` — removes from the target Collection all of its elements that are also contained in the specified Collection
// - `retainAll` — removes from the target Collection all its elements that are not also contained in the specified Collection
// - `clear` — removes all elements from the Collection

// %% [markdown] lang="en" tags=["slide"]
// - Consider the following idiom to remove all instances of a specified element, e, from a Collection, c
// - This idiom uses Collections.singleton, which is a static factory method that returns an immutable Set containing only the specified element:

// %% 
List<String> c = new ArrayList<>(Arrays.asList("a", "b", "c", "d", null, "a", "b", "c", "d", null));


// %% 
c.removeAll(Collections.singleton("a"));

// %% 
c.forEach(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// - Suppose you want to remove all of the null elements from a Collection:

// %% 
c.removeAll(Collections.singleton(null));

// %%
c.forEach(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// ## Collection Interface Array Operations
// - The `toArray` methods are provided as a bridge between collections and older APIs that expect arrays on input
// - The array operations allow the contents of a Collection to be translated into an array

// %%
Object[] a = c.toArray();

// %% [markdown] lang="en" tags=["slide"]
// - Suppose that c is known to contain only strings
// - The reason for passing `new String[0]` is to inform the toArray method about the desired type of the output array

// %%
String[] a = c.toArray(new String[0]);
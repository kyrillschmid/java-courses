// j2 from 'macros.j2' import header
// {{ header("Die Collection API", "The Collection API") }} 

// %% [markdown] lang="en" tags=["slide"]
// ## Core collection interfaces
// - The core collection interfaces encapsulate different types of collections
// - These interfaces allow collections to be manipulated independently of the details of their representation
// - Core collection interfaces are the foundation of the Java Collections Framework
// - The core collection interfaces form a hierarchy:

// %% [markdown] lang="en" tags=["subslide"]
//
// <img src="img/collection_interfaces.png"
//      style="display:block;margin:auto;width:75%"/>

// %% [markdown] lang="en" tags=["slide"]
// ## Generic Collection Interfaces
// - All the core collection interfaces are generic
// - For example, this is the declaration of the Collection interface:
// ```java
// public interface Collection<E> ...
// ```

// %% [markdown] lang="en" tags=["slide"]
// - The `<E>` syntax tells you that the interface is generic
// - When you declare a Collection instance you can and should specify the type of object contained in the collection
// - Specifying the type allows the compiler to verify (at compile-time) that the type of object you put into the collection is correct
// ```java
// Collection<String> c = new ...
// ```

// %% [markdown] lang="en" tags=["slide"]
// - The Java platform doesn't provide separate interfaces for each variant of each collection type to keep the number of interfaces manageable
//       - Such as immutable, fixed-size, and append-only
// - Instead, the modification operations in each interface are designated optional 
//      — A given implementation may elect not to support all operations
//      - If an unsupported operation is invoked, a collection throws an UnsupportedOperationException 
//      - Implementations are responsible for documenting which of the optional operations they support

// %% [markdown] lang="en" tags=["slide"]
// ## Collection
// - The root of the collection hierarchy
// - A collection represents a group of objects known as its elements
// - The Collection interface is the least common denominator

// %% 
Collection<String> c = new ArrayList<String>();

// %% [markdown] lang="en" tags=["slide"]
// ## List
// - An ordered collection (sometimes called a sequence)
// - Lists can contain duplicate elements
// - Access with zero-based index

// %%
List<String> list = new ArrayList<>();

// %%
list.add("Apple");
list.add("Banana");
list.add("Cherry");
list.add("Date");
list;

// %%
String firstItem = list.get(0);
firstItem;

// %%
list.set(1, "Blueberry");
list;

// %%
list.remove("Date"); // removing by object
list.remove(2);     // removing by index
list;

// %%
for (String item : list) {
    System.out.println(item);
}

// %% [markdown] lang="en" tags=["slide"]
// ## Set
// - A collection that cannot contain duplicate elements
// - Models the mathematical set abstraction

// %%
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Cherry");
set.add("Date");
set

// %% [markdown] lang="en" tags=["slide"]
// Attempting to add duplicate elements

// %%
set.add("Apple");
set.add("Banana");
set;

// %% 
if (set.contains("Cherry")) {
    System.out.println("Cherry is in the set.");
}
    
// %% [markdown] lang="en" tags=["slide"]
// ## Queue and Deque
// - Queue — a collection used to hold multiple elements prior to processing
//      - Order elements typically on a FIFO (first-in, first-out) basis
// - Deque (double ended queue) a collection used to hold multiple elements prior to processing
//      - Deques can be used both as FIFO (first-in, first-out) and LIFO (last-in, first-out)
//      - In a deque all new elements can be inserted, retrieved and removed at both ends

// %% 
Deque<String> deque = new ArrayDeque<>();

// %% 
deque.addLast("Tail Element 1");
deque.addLast("Tail Element 2");

// %%
deque.addFirst("Head Element 1");
deque.addFirst("Head Element 2");

// %%
deque;

// %%
String headElement = deque.removeFirst();
String tailElement = deque.removeLast();

// %%
headElement;
tailElement;
deque;

// %% [markdown] lang="en" tags=["slide"]
// ## Map
// - Map — an object that maps keys to values
// - A HashMap is an example of a Map implementation

// %%
Map<String, Integer> map = new HashMap<>();

// %%
map.put("Apple", 50);
map.put("Banana", 30);
map.put("Cherry", 20);
map.put("Date", 40);
map

// %%
int applePrice = map.get("Apple");
applePrice;

// %%
if (map.containsKey("Banana")) {
    System.out.println("Banana is available.");
}

// %%
map.put("Cherry", 25);
map.get("Cherry");

// %%
map.remove("Date");
map;

// %% [markdown] lang="en" tags=["slide"]
// ## SortedSet, SortedMap
// - SortedSet — a Set that maintains its elements in ascending order
// - SortedMap — a Map that maintains its mappings in ascending key order


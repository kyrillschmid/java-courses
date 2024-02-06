// j2 from 'macros.j2' import header
// {{ header("Collection-Factories", "Collection-Factories") }}

// %% [markdown] lang="de" tags=["slide"]
// # Bequemlichkeitsfunktionen für Collections
//
// * Sammlungen (Collections) sind wichtige Element in jeder Programiersprache.
// * Collections werden sehr häufig verwendet.
// * Jeder Verbesserungen bei der Nutzung von Collections wirken sich schnell und positiv auf Entwickler aus.

// %% [markdown] lang="en" tags=["slide"]
// # Convenience Factory Methods for Collections
//
// * Collections are important elements in any programming language.
// * Collections are used very frequently.
// * Any improvements in the use of collections have a quick and positive effect on developers.

// %% [markdown] lang="de" tags=["slide"]
// Zur Motivation:

// %% [markdown] lang="en" tags=["slide"]
// Motivation:

// %% tags=["keep"]
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("c");

// %% [markdown] lang="de" tags=["slide"]
// |            | of              | copyOf              | ofEntries              |
// | ---------- | --------------- | ------------------- | ---------------------- |
// | ```List``` | ```List.of()``` | ```List.copyOf()``` | ```List.ofEntries()``` |
// | ```Set```  | ```Set.of()```  | ```Set.copyOf()```  | ```Set.ofEntries()```  |
// | ```Map```  | ```Map.of()```  | ```Map.copyOf()```  | ```Map.ofEntries()```  |

// %% [markdown] lang="en" tags=["slide"]
// |            | of              | copyOf              | ofEntries              |
// | ---------- | --------------- | ------------------- | ---------------------- |
// | ```List``` | ```List.of()``` | ```List.copyOf()``` | ```List.ofEntries()``` |
// | ```Set```  | ```Set.of()```  | ```Set.copyOf()```  | ```Set.ofEntries()```  |

// %% [markdown] lang="de" tags=["slide"]
// Mit `Set.of`

// %% [markdown] lang="en" tags=["slide"]
// With `Set.of`

// %%
var set = Set.of("a", "b", "c");
set

// %% [markdown] lang="de" tags=["slide"]
// Diese `List.*of*`, `Set.*of*` und `Map.*of*` liefern unveränderliche [Collections](https://docs.oracle.com/en/java/javase/11/core/creating-immutable-lists-sets-and-maps.html).

// %% [markdown] lang="en" tags=["slide"]
// These `List.*of*`, `Set.*of*` and `Map.*of*` return immutable [Collections](https://docs.oracle.com/en/java/javase/11/core/creating-immutable-lists-sets-and-maps.html).

// %% [markdown] lang="de" tags=["slide"]
// Vor Java 11 wurde aus einer modifizierbaren Liste durch den Befehl `Collections.unmodifiableList` eine nicht-modifizierbare List.

// %% [markdown] lang="en" tags=["slide"]
// Before Java 11, a modifiable list was converted to an unmodifiable list by the `Collections.unmodifiableList` command.

// %%
List<String> list = new ArrayList<>();
list.add("one");
list.add("two");
list.add("three");
list = Collections.unmodifiableList(list);
list

// %% [markdown] lang="de" tags=["slide"]
// Mit `List.of`

// %% [markdown] lang="en" tags=["slide"]
// With `List.of`

// %%
var list = List.of("one", "two", "three");
list

// %% [markdown] lang="de" tags=["slide"]
// Das Ergebnis von `List.of` ist eine nicht-modifizierbare Liste.

// %% [markdown] lang="en" tags=["slide"]
// The result of `List.of` is an unmodifiable list.

// %%
var list = List.of("one", "two", "three");
list.add("four");  // runtime error - ImmutableCollections

// %% [markdown] lang="de" tags=["slide"]
// Erstellen einer Map vor Java 11.

// %% [markdown] lang="en" tags=["slide"]
// Creating a map before Java 11.

// %%
Map<String, Integer> map = new HashMap<>();
map.put("one", 1);
map.put("two", 2);
map.put("three", 3);

// %% [markdown] lang="de" tags=["slide"]
// Mit `Map.of`

// %% [markdown] lang="en" tags=["slide"]
// With `Map.of`

// %%
var map = Map.of("eins", 1, "zwei", 2);
map

// %% [markdown] lang="de" tags=["slide"]
// Das Ergebnis von `Map.of` ist eine unveränderliche Zuordnungstabelle.

// %% [markdown] lang="en" tags=["slide"]
// The result of `Map.of` is an immutable mapping table.

// %%
var map = Map.of("eins", 1, "zwei", 2);
map.put("drei", 3); // Laufzeitfehler - ImmutableCollections

// %% [markdown] lang="de" tags=["slide"]
// Mit `Map.ofEntries` lassen sich beliebig viele Einträge erstellen.

// %% [markdown] lang="en" tags=["slide"]
// With `Map.ofEntries` any number of entries can be created.

// %%
var map = Map.ofEntries(
        Map.entry("eins", 1),
        Map.entry("zwei", 2),
        Map.entry("drei", 3)
);
map

// %% [markdown] lang="de" tags=["slide"]
// Das ist besonders hilfreich wenn mehr als 10 Einträge erstellt werden sollen z.B. durch Stream:

// %% 
List<String> words = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

// %% tags=["start"]
import static java.util.Map.entry;
Map<String, Integer> map = Map.ofEntries();

// %% tags=["alt"]
Map<String, Integer> map = Map.ofEntries(
        words.stream()
        .map(word -> entry(word, word.length()))
        .toArray(Map.Entry[]::new) // Convert the stream to an array of Map.Entry objects
);
map


// %% [markdown] lang="de" tags=["slide"]
// Erstellen eines Set vor Java 11.

// %% [markdown] lang="en" tags=["slide"]
// Creating a set before Java 11.

// %%
Set<String> set = new HashSet<>();
set.add("one");
set.add("two");
set.add("three");

// %% [markdown] lang="de" tags=["slide"]
// Mit `Set.of`

// %% [markdown] lang="en" tags=["slide"]
// With `Set.of`

// %%
var set = Set.of("one", "two", "three");
set

// %% [markdown] lang="de" tags=["slide"]
// Das Ergebnis von `Set.of` ist eine nicht-modifizierbare Liste.

// %% [markdown] lang="en" tags=["slide"]
// The result of `Set.of` is an unmodifiable list.

// %%
var set = Set.of("one", "two", "three");
set.add("vier");  // runtime error - ImmutableCollections

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop
//
// 1. Erzeuge eine List mit ```ArrayList```.
// 2. Fülle diese List mit mindestens zwei Werten (nutze ```.add()```).
// 3. Mache eine Kopie der list mit ```List.copyOf```.
// 4. Prüfe bei beiden Listen
//    1. Inhalt
//    2. ```hashCode```
//    3. ```getClass```
// 5. (optional) Zu welcher Liste kannst du Werte hinzufügen?

// %% [markdown] lang="en" tags=["slide"]
// # Mini-Workshop
//
// 1. Create a list with ```ArrayList```.
// 2. Fill this list with at least two values (use ```.add()```).
// 3. Make a copy of this list with ```List.copyOf```.
// 4. Check both lists
//    1. content
//    2. ```hashCode```
//    3. ```getClass```
// 5. (optional) To which list can you add values?

// %% tags=["keep"]

// %% tags=["notes"]
// solution
var l1 = new ArrayList<>();
l1.add(1);
l1.add(4);
var l2 = List.copyOf(l1);

System.out.println(l1);
System.out.println(l1.hashCode());
System.out.println(l1.getClass());

System.out.println(l2);
System.out.println(l2.hashCode());
System.out.println(l2.getClass());

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop
//
// 1. Verstehe den gegeben Code.
// 2. Erzeuge einen ```IntStream``` welcher Zahlen in einer ```range``` von ```0``` bis ```kk.size()``` liefert.
// 3. Führe die Einträge von ```kk``` und ```vv``` parallel (zum gleichen Index) zusammen. Nutze hierfür ```forEach``` des `IntStream` Streams.
// 4. Benutze ```Map.copyOf``` um eine unveränderliche Zuordnungstabelle zu erzeugen. Benennen diese ```fixedMap```.
// 5. Inspeziere den Inhalt und ```getClass()``` von ```fixedMap```.

// %% [markdown] lang="en" tags=["slide"]
// # Mini-Workshop
//
// 1. Understand the given code.
// 2. Create an ```IntStream``` which delivers numbers in a ```range``` from ```0``` to ```kk.size()```.
// 3. Combine the entries of ```kk``` and ```vv``` in parallel (to the same index). Use ```forEach``` of the `IntStream` stream.
// 4. Use ```Map.copyOf``` to create an immutable mapping table. Name it ```fixedMap```.
// 5. Inspect the content and ```getClass()``` of ```fixedMap```.

// %% tags=["keep"]
var kk = List.of("eins", "zwei", "drei");
var vv = List.of(1, 2, 3);
var map = new HashMap<>();
// ...

// %% tags=["notes"]
// solution
var kk = List.of("eins", "zwei", "drei");
var vv = List.of(1, 2, 3);
var map = new HashMap<>();
// continue here
java.util.stream.IntStream
        .range(0, kk.size())
        .forEach(i -> map.put(kk.get(i), vv.get(i)));
var fixedMap = Map.copyOf(map);
System.out.println(fixedMap);
System.out.println(fixedMap.getClass());
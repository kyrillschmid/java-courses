// j2 from 'macros.j2' import header
// {{ header("Workshop Streams", "Workshop Streams") }}

// %% tags=["keep"]
public class Animal {

     private String name;
     private String species;
     private boolean vegetarian;
     private double weight;

    public enum Gender {
     MALE, FEMALE
    }
 
    public Animal(String name, String species, boolean vegetarian, double weight) {
        this.name = name;
        this.species = species;
        this.vegetarian = vegetarian;
        this.weight = weight;
    }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
 
 public boolean getVegetarian() {
    return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
    this.vegetarian = vegetarian;
    }

    @Override
    public String toString() {
    return "Animal [name=" + name + ", species=" + species + ", vegetarian=" + vegetarian + ", weight=" + weight + "]";
    }
}

// %% tags=["keep"]
List<Animal> animals = Arrays.asList(
        new Animal("Alex", "Lion", false, 200.0),
        new Animal("Gloria", "Hippo", true, 1600.0),
        new Animal("Melman", "Giraffe", true, 1100.0),
        new Animal("Marty", "Zebra", true, 300.0),
        new Animal("Skipper", "Penguin", false, 5.0),
        new Animal("Private", "Penguin", false, 4.0),
        new Animal("Kowalski", "Penguin", false, 6.0),
        new Animal("Rico", "Penguin", false, 7.0),
        new Animal("Maurice", "Lemur", true, 3.0),
        new Animal("Julien", "Lemur", true, 4.5)
    );

// %% tags=["keep"]
import java.util.stream.Stream;

// %% [markdown] lang="en" tags=["slide"]
// ## Warm-up
// - Create a stream with the numbers 1 to 3 in four different ways:
// - 1. via `Collection.stream()`
     
// %% 
Stream streamFromList = Arrays.asList(1, 2, 3)
                                   .stream();

// %% [markdown] lang="en" tags=["slide"]
// - 2. via `Arrays.stream(...)`

// %%
IntStream streamFromArray = Arrays.stream(new int[] { 1, 2, 3 });

// %% [markdown] lang="en" tags=["slide"]
// - 3. via `Stream.of(...)`
     
// %%
Stream streamOf = Stream.of(1, 2, 3);

// %% [markdown] lang="en" tags=["slide"]
// 4. Via `IntStreams`

// %% 
IntStream intStream = IntStream.range(1, 4);

// %% [markdown] lang="en" tags=["slide"]
// ## Animal Stream
// - Print all animals by using System.out.println

// %%
animals.stream()
                      .forEach(s -> System.out.println(s));

// %% [markdown] lang="en" tags=["slide"]
// - Print all animals by using a method reference */

// %%
animals.stream()
                      .forEach(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// - Print all animals names by using System.out.println */

// %%
animals.stream()
                      .forEach(s -> System.out.println(s.getName()));

// %% [markdown] lang="en" tags=["slide"]
// - Print all animals by using map and method references */

// %%
 animals.stream()
                      .map(Animal::getName)
                      .forEach(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// - Print the animals names which are non vegetarian */

// %%
animals.stream()
                      .filter(s -> s.getVegetarian())
                      .map(Animal::getName)
                      .forEach(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// - Print the count animals who are heavier than 150 kg */

// %%
System.out.println(animals.stream()
                                         .filter(s -> s.getWeight() > 150)
                                         .count());

// %% [markdown] lang="en" tags=["slide"]
// - Print the (distinct) species */

// %%
animals.stream()
                      .map(Animal::getSpecies)
                      .distinct()
                      .forEach(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// - Print the average weight for the species Penguin */

// %%
animals.stream()
                      .filter(s -> s.getSpecies()
                                    .equals("Penguin"))
                      .mapToDouble(Animal::getWeight)
                      .average()
                      .ifPresent(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// - Print the animals from the species "Penguin" ordered ascending by weight (lightest first)

// %%
animals.stream()
                      .filter(s -> s.getSpecies()
                                    .equals("Penguin"))
                      .sorted(Comparator.comparing(Animal::getWeight).reversed())
                      .map(Animal::getName)
                      .forEach(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// - Print the three heaviest animals */

// %%
animals.stream()
                      .sorted(Comparator.comparing(Animal::getWeight).reversed())
                      .limit(3)
                      .map(Animal::getName)
                      .forEach(System.out::println);

// %% [markdown] lang="en" tags=["slide"]
// - Save the previous result to a "List" and print a ranked list of the top heaviest animals as follows:
//      - 1. Animal1 2. Animal2 3. Animal3
// - Hint: use `import java.util.stream.Collectors;`

// %%
import java.util.stream.Collectors;

List<String> heaviestAnimals = animals.stream()
                                                  .sorted(Comparator.comparing(Animal::getWeight))
                                                  .limit(3)
                                                  .map(Animal::getName)
                                                  .collect(Collectors.toList());

// %%
IntStream.range(1, heaviestAnimals.size() + 1)
               .forEach(i -> System.out.println(i + ". " + heaviestAnimals.get(i - 1)));


// %% [markdown] lang="en" tags=["slide"]
// - And finally, what does the following stream do?
// ```java 
//Stream.iterate(new int[] { 0, 1 }, n -> new int[] { n[1], n[0] + n[1] })
//    .map(n -> n[1])
//    .limit(10) // important, otherwise the stream would not terminate
//    .forEach(System.out::println);
//```

     
 

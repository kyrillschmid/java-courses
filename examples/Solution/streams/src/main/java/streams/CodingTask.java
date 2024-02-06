package streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CodingTask {

  public static void main(String[] args) {

      /** Create a stream with the numbers 1 to 3 in four different ways */

      /** via Collection.stream() */
      Stream streamFromList = Arrays.asList(1, 2, 3)
                                    .stream();

      /** via Arrays.stream(...) */
      IntStream streamFromArray = Arrays.stream(new int[] { 1, 2, 3 });

      /** via Stream.of(...) */
      Stream streamOf = Stream.of(1, 2, 3);

      /** via IntStreams */
      IntStream intStream = IntStream.range(1, 4);

      /** Print all animals by using System.out.println */
      Animal.animals.stream()
                      .forEach(s -> System.out.println(s));

      /** Print all animals by using a method reference */
      Animal.animals.stream()
                      .forEach(System.out::println);

      /** Print all animals names by using System.out.println */
      Animal.animals.stream()
                      .forEach(s -> System.out.println(s.getName()));

      /** Print all animals by using map and method references */
      Animal.animals.stream()
                      .map(Animal::getName)
                      .forEach(System.out::println);

      /** Print the animals names which are non vegetarian */
      Animal.animals.stream()
                      .filter(s -> s.getVegetarian())
                      .map(Animal::getName)
                      .forEach(System.out::println);

      /** Print the count animals who are heavier than 150 kg */
      System.out.println(Animal.animals.stream()
                                         .filter(s -> s.getWeight() > 150)
                                         .count());

      /** Print the (distinct) species */
      Animal.animals.stream()
                      .map(Animal::getSpecies)
                      .distinct()
                      .forEach(System.out::println);

      /** Print the average weight for the species Penguin */
      Animal.animals.stream()
                      .filter(s -> s.getSpecies()
                                    .equals("Penguin"))
                      .mapToDouble(Animal::getWeight)
                      .average()
                      .ifPresent(System.out::println);

      /**
       * Print the animals from the species "Penguin" ordered ascending by weight (lightest first)
       */
      Animal.animals.stream()
                      .filter(s -> s.getSpecies()
                                    .equals("Penguin"))
                      .sorted(Comparator.comparing(Animal::getWeight).reversed())
                      .map(Animal::getName)
                      .forEach(System.out::println);

      /** Print the three heaviest animals */
      Animal.animals.stream()
                      .sorted(Comparator.comparing(Animal::getWeight).reversed())
                      .limit(3)
                      .map(Animal::getName)
                      .forEach(System.out::println);

      System.out.println("---");
      /**
       * Save the previous result to a "List" and print a ranked list of the top heaviest animals as follows: 1.
       * Animal1 2. Animal2 3. Animal3
       */
      List<String> heaviestAnimals = Animal.animals.stream()
                                                  .sorted(Comparator.comparing(Animal::getWeight))
                                                  .limit(3)
                                                  .map(Animal::getName)
                                                  .collect(Collectors.toList());

      IntStream.range(1, heaviestAnimals.size() + 1)
               .forEach(i -> System.out.println(i + ". " + heaviestAnimals.get(i - 1)));

      /**
       * And finally, what does the following stream do?
       */
      Stream.iterate(new int[] { 0, 1 }, n -> new int[] { n[1], n[0] + n[1] })
            .map(n -> n[1])
            .limit(10) // important, otherwise the stream would not terminate
            .forEach(System.out::println);

      // 1 1 2 3 5 8 13 21 34 55 ... = the Fibonacci sequence f(n) = f(n-1) + f(n-2)
  }
}

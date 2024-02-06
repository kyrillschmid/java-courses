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


     /** Print all animals by using a method reference */


     /** Print all animals names by using System.out.println */


     /** Print all animals by using map and method references */


     /** Print the animals names which are non vegetarian */


     /** Print the count animals who are heavier than 150 kg */


     /** Print the (distinct) species */


     /** Print the average weight for the species Penguin */


     /**
      * Print the animals from the species "Penguin" ordered ascending by weight (lightest first)
      */


     /** Print the three heaviest animals */

     System.out.println("---");
     /**
      * Save the previous result to a "List" and print a ranked list of the top heaviest animals as follows: 1.
      * Animal1 2. Animal2 3. Animal3
      */


     /**
      * And finally, what does the following stream do?
      */
     Stream.iterate(new int[] { 0, 1 }, n -> new int[] { n[1], n[0] + n[1] })
           .map(n -> n[1])
           .limit(10) // important, otherwise the stream would not terminate
           .forEach(System.out::println);

     
 }
}

package e06_pattern_matching;

import java.util.List;

/*
sealed interface Transport {};
record Bicycle(String id) implements Transport {};
record Glider(int size) implements Transport {};
record Surfboard(double weight) implements Transport {};
*/


// If you uncomment this:
// record Skis(int length) implements Transport {};
// You get an error: "the switch expression
// does not cover all possible input values"

public class SealedPatternMatch {

/*    static String exhaustive(Transport t) {
        return switch(t) {
            case Bicycle b -> "Bicycle " + b.id();
            case Glider g -> "Glider " + g.size();
            case Surfboard s -> "Surfboard " + s.weight();
            // case null -> "Null"; -> könnten wir aufnehmen um Exception zu vermeiden
        };
    }
    public static void main(String[] args) {
        List.of(
                new Bicycle("Bob"),
                new Glider(65),
                new Surfboard(6.4)
        ).forEach(
                t -> System.out.println(exhaustive(t))
        );
        try {
            exhaustive(null); // immer möglich
        } catch(NullPointerException e) {
            System.out.println("Not exhaustive: " + e);
        }
    }*/
}

package e06_pattern_matching;

import java.util.List;
import java.util.Map;

public class PatternMatchingSwitch {

/*    static String typeBasedOutputPattern(Object o){
        return switch(o){
            case null -> "Null value";
            case List things -> "A list of things with size: " + things.size();
            case Map map -> "A map containing these keys: " + map.keySet();
            case String s && !s.isEmpty() -> String.format("Non-empty string %s", s);
            default -> "This is something else";
        };
    }

    public static void main(String[] args){
        Object o = "A String";
        String formatted = switch(o){
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> "unknown";
        };
        System.out.println(formatted);

        System.out.println(PatternMatchingSwitch.typeBasedOutputPattern(null));

    }*/

}

// j2 from 'macros.j2' import header
// {{ header("Switch Case", "Switch Case") }}

// %% [markdown] lang="en" tags=["slide"]
// ## Motivation
// - The Java switch case is a multiway branch statement that provides an easy way to dispatch execution to different parts of code based on the value of the expression. 

// %%
int day = 2;
String dayString;

// %% 
switch (day) {
    case 1: dayString = "Monday";
            break;
    case 2: dayString = "Tuesday";
            break;
    default: dayString = "Invalid day";
    break;
}
System.out.println(dayString);

// %% [markdown] lang="en" tags=["slide"]
// - Switch case statements are a substitute for long if statements that compare a variable to several "integral" values ("integral" values are simply values that can be expressed as an integer, such as the value of a char). 
// - It can be used with byte, short, int, and char primitive data types.
// - It also works with enumerated types, String class, and a few special classes that wrap certain primitive types: Character, Byte, Short, and Integer.


// %% [markdown] lang="en" tags=["slide"]
// Usage of switch case statement with Enum

// %% tags=["keep"]
enum Day {
    MON, TUE, WED, THU, FRI, SAT, SUN;
}

// %% tags=["keep"]
Day day = Day.MON; 
switch (day) {
    case MON:
        System.out.println("It is Monday");
        break;
    case TUE:
        System.out.println("It is Tuesday");
        break;
    case WED:
        System.out.println("It is Wednesday");
        break;
    default:
        System.out.println("It is a day other than Monday, Tuesday or Wednesday");
        break;
}

// %% [markdown] lang="en" tags=["slide"]
// ## `break` statement
// - Each break statement terminates the enclosing switch statement.
// - The break statements are necessary because without them, statements in switch blocks fall through: All statements after the matching case label are executed in sequence, regardless of the expression of subsequent case labels, until a break statement is encountered.

// %% tags=["start"]
// Example with fall through
int day = 2;
String dayString;
switch (day) {
    case 1: dayString = "Monday";
    case 2: dayString = "Tuesday";
    case 3: dayString = "Wednesday";
    default: dayString = "Invalid day";
}

// %% tags=["alt"]
int day = 2;
String dayString;
switch (day) {
    case 1: dayString = "Monday";
            break;
    case 2: dayString = "Tuesday";
            break;
    case 3: dayString = "Wednesday";
            break;
    default: dayString = "Invalid day";
            break;
}

// %% 
dayString;


// %% [markdown] lang="en" tags=["slide"]
// - All statements after the matching case label are executed in sequence, regardless of the expression of subsequent case labels, until a break statement is encountered.

// %% [markdown] lang="en" tags=["slide"]
// ## `default` statement and multiple case labels
// - The default section handles all values that are not explicitly handled by one of the case sections.
// - A block can have multiple case labels that have the same body.

// %% tags=["start"]
Day monday = Day.MON;
switch (monday) {
    case MON:
    case TUE:
    case WED:
    case THU:
    case FRI:
        System.out.println("It is a weekday");
        break;
    case SAT:
    case SUN:
        System.out.println("It is a weekend");
        break;
}

// %% tags=["alt"]
Day monday = Day.MON;
switch (monday) {
    case MON:
    case TUE:
    case WED:
    case THU:
    case FRI:
        System.out.println("It is a weekday");
        break;
    case SAT:
    case SUN:
        System.out.println("It is a weekend");
        break;
    default:
        System.out.println("Invalid day");
        break;
}

// %% [markdown] lang="en" tags=["slide"]
// ## Notes
// - Default case is optional: danger of silently skipping important checks
// - No complex checks like in if statements
// - Constant case values: no variables, no ranges, no relational operators

// %% [markdown] lang="en" tags=["slide"]
// ## Mini-Workshop: Switch Case

// %% tags=["keep"]
import java.time.Month;

// %% [markdown] lang="de" tags=["slide"]
// Gegeben ist folgende Funktion, die einen `Month` in einen `String` umwandelt:

// %% [markdown] lang="en" tags=["slide"]
// Given is the following function that converts a `Month` to a `String`:

// %% tags=["keep"]
String monthToString(Month month){
    String monthAsString;
    switch(month){
        case JANUARY:
            monthAsString = "January";
            break;
        case FEBRUARY:
            monthAsString = "February";
            break;
        case MARCH:
            monthAsString = "March";
        default :
            monthAsString = "Unknown";
    }
    return monthAsString;
}

// %% [markdown] lang="de" tags=["slide"]
// * Betrachten Sie das Ergebnis für folgende Eingaben: `FEBRUARY`, `MARCH`
// * Was ist das Problem?

// %% [markdown] lang="en" tags=["slide"]
// * Consider the result for the following inputs: `FEBRUARY`, `MARCH`
// * What is the problem?

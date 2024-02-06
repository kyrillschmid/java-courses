// j2 from 'macros.j2' import header
// {{ header("Enums", "Enums") }}

// %% [markdown] lang="en" tags=["slide"]
//
// ## Motivation
//
// - Enums in Java are crucial tools to define and manage a set of predefined constants. 
// - They contribute to code safety by ensuring type safety. 
// - Without enums, you could achieve this by using final class variables:

// %% tags=["keep"]
final class PlanetClass {
    public final static String MARS = "Mars";
    public final static String EARTH = "Earth";
    public final static String JUPITER = "Jupiter";
    public final static String SATURN = "Saturn";
    public final static String URANUS = "Uranus";
    public final static String NEPTUNE = "Neptune";
}

// %% [markdown] lang="en" tags=["slide"]
// ## Limitations of using final class variables over enums:
// - Type Safety: Final class variables do not provide type safety. 
// - There is no compile-time check to prevent the use of an incorrect string (like "Venus")

// %% tags=["keep"]
public static void printPlanetString(String planetName) {
    if (planetName.equals(PlanetClass.MARS)) {
        System.out.println("Mars is the fourth planet from the Sun.");
    } else if (planetName.equals(PlanetClass.EARTH)) {
        System.out.println("Earth is the third planet from the Sun.");
    } else if (planetName.equals(PlanetClass.JUPITER)) {
        System.out.println("Jupiter is the largest planet in the Solar System.");
    } else {
        System.out.println("Unknown planet.");
    }
}

// %% 
printPlanetInfo("Mars");

// %%
printPlanetInfo("Venus");

// %% [markdown] lang="en" tags=["slide"]
// 2. Functionality: Enums can be more powerful than class variables as they can have methods, variables, constructors etc.

// %%
// PlanetClass.MARS.length(); // no associated methods or data

// %% [markdown] lang="en" tags=["slide"]
//
// ## Enums (Enumerations)
//
// - Enums or Enumerations in Java are a special type of class that always contains a fixed set of constants.
// - They are the best way to define a collection of related things because they provide compile-time type safety.
// Enums in Java are declared using the keyword "enum". They can contain methods, variables and constructors.
// ```java
// public enum EnumName {
//    CONSTANT1, CONSTANT2, ... 
// }
// ```

// %% [markdown] lang="en" tags=["slide"]
// We can use enums to define the planets in our solar system:

// %%
public enum Planets {
    MERCURY, VENUS, EARTH, MARS, JUPITER, SATURN, URANUS, NEPTUNE;
}

// %% 
Planets.MARS;

// %% 
Planets.VENUS;

// %% tags=["slide", "keep"]
public static void printPlanet(Planets planet) {
    if (planet == Planets.MARS) {
        System.out.println("Mars is the fourth planet from the Sun.");
    } else if (planet == Planets.EARTH) {
        System.out.println("Earth is the third planet from the Sun.");
    } else if (planet == Planets.JUPITER) {
        System.out.println("Jupiter is the largest planet in the Solar System.");
    } else {
        System.out.println("Unknown planet.");
    }
}

// %% 
printPlanet(Planets.MARS);

// %% 
printPlanet("Venus");


// %% [markdown] lang="en" tags=["slide"]
//
// ## Methods
//
// - Enums can have methods, allowing you to add behavior relevant to the planets. 
// - For example, you might add a method to calculate the gravitational force or to return descriptive information about the planet.


// %% tags=["start"]
public enum Planet {
    MARS("Mars", 6.39E23),
    EARTH("Earth", 5.97E24),
    JUPITER("Jupiter", 1.90E27);

    private String name;
    private double mass; // in kilograms

    Planet(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }
}

// %% tags=["alt"]
public enum Planet {
    
    MARS("Mars", 6.39E23),
    EARTH("Earth", 5.97E24),
    JUPITER("Jupiter", 1.90E27);

    private String name;
    private double mass; // in kilograms

    Planet(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }
}

// %%
Planet.MARS.getName();

// %%
Planet.MARS.getMass();


// %% [markdown] lang="en" tags=["slide"]
// ## Limitations of Enums
// - Enums types have no instances other than those defined by its enum constants.
// - Enum types cannot be instantiated.
// - Enum types cannot be subclassed.

// %% 
Planet("Mars", 6.39E23);

// %% [markdown] lang="en" tags=["slide"]
// ## Type Safety vs Flexibility Trade-Off: 
// - While enums provide strong type safety, this comes at the cost of flexibility. 
// - For example, if you use enums to represent a set of values that might change (like menu items in an application), any change requires recompiling the enum class.

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Mini-Workshop: Implementing an Enum
//
// Create an enum for a deck of cards. The enum should contain all four suits: HEARTS, DIAMONDS, CLUBS, and SPADES.

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Mini-Workshop: Implementierung eines Enum
//
// Erstellen Sie ein Enum für ein Kartenspiel. Das Enum sollte alle vier Farben enthalten: HERZ, KARO, KREUZ und PIK.

// %%
public enum CardSuit {
    
}

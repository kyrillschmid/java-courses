// j2 from 'macros.j2' import header
// {{ header("Open-Closed-Principle", "Open-Closed-Principle") }}


// %% [markdown] lang="de" tags=["slide"]
//
// ## SOLID: Open-Closed-Principle
//
// Klassen sollen
//
// - Offen für Erweiterung
// - Geschlossen für Modifikation
//
// sein.

// %% [markdown] lang="en" tags=["slide"]
//
// ## SOLID: Open-Closed-Principle
//
// Classes should be
//
// - Open for extension
// - Closed for Modification


// %% tags=["slide", "keep"]
public enum MovieKindV0 {
    REGULAR,
    CHILDREN;
}


// %% tags=["keep"]
public class MovieV0 {
    private String title;
    private MovieKindV0 kind;

    public MovieV0(String title, MovieKindV0 kind) {
        this.title = title;
        this.kind = kind != null ? kind : MovieKindV0.REGULAR;
    }

    public MovieV0(String title) {
        this(title, MovieKindV0.REGULAR);
    }

    public double computePrice() {
        if (kind == MovieKindV0.REGULAR) {
            return 4.99;
        } else if (kind == MovieKindV0.CHILDREN) {
            return 5.99;
        }
        return 0;
    }

    public void printInfo() {
        System.out.printf("%s costs %.2f%n", title, computePrice());
    }
}



// %% tags=["keep"]
MovieV0 m1 = new MovieV0("Casablanca");
MovieV0 m2 = new MovieV0("Shrek", MovieKindV0.CHILDREN);

// %% tags=["keep"]
m1.printInfo();
m2.printInfo();


// %% tags=["keep"]
public enum MovieKindV1 {
    REGULAR,
    CHILDREN,
    NEW_RELEASE;
}



// %% tags=["keep"]
public class MovieV1 {
    private String title;
    private MovieKindV1 kind;

    public MovieV1(String title) {
        this.title = title;
        this.kind = MovieKindV1.REGULAR;
    }

    public MovieV1(String title, MovieKindV1 kind) {
        this.title = title;
        this.kind = kind;
    }

    public double computePrice() {
        if (this.kind == MovieKindV1.REGULAR) {
            return 4.99;
        } else if (this.kind == MovieKindV1.CHILDREN) {
            return 5.99;
        } else if (this.kind == MovieKindV1.NEW_RELEASE) {
            return 6.99;
        }
        throw new IllegalArgumentException("Invalid movie kind");
    }

    public void printInfo() {
        System.out.println(this.title + " costs " + this.computePrice());
    }
}



// %% tags=["keep"]
MovieV1 m1 = new MovieV1("Casablanca");
MovieV1 m2 = new MovieV1("Shrek", MovieKindV1.CHILDREN);
MovieV1 m3 = new MovieV1("Brand New", MovieKindV1.NEW_RELEASE);


// %% tags=["keep"]
m1.printInfo();
m2.printInfo();
m3.printInfo();


// %%
public abstract class Movie {
    protected String title;
    protected MovieKindV1 kind;

    public Movie(String title) {
        this(title, MovieKindV1.REGULAR);
    }

    public Movie(String title, MovieKindV1 kind) {
        this.title = title;
        this.kind = kind;
    }

    public abstract double computePrice();

    public void printInfo() {
        System.out.printf("%s costs %.2f%n", title, computePrice());
    }
}



// %%
public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    public RegularMovie(String title, MovieKindV1 kind) {
        super(title, kind);
    }

    @Override
    public double computePrice() {
        return 4.99;
    }
}


// %%
public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title, MovieKindV1.CHILDREN);
    }

    @Override
    public double computePrice() {
        return 5.99;
    }
}



// %%
public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, MovieKindV1.NEW_RELEASE);
    }

    @Override
    public double computePrice() {
        return 6.99;
    }
}



// %%
RegularMovie m1 = new RegularMovie("Casablanca");
ChildrenMovie m2 = new ChildrenMovie("Shrek");
NewReleaseMovie m3 = new NewReleaseMovie("Brand New");


// %%
m1.printInfo();
m2.printInfo();
m3.printInfo();

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Workshop: Employee OCP
//
// Beim SRP haben wir die `Employee`-Klasse refactored um die SRP-Verletzungen zu
// beseitigen. Verbessern Sie das Beispiel weiter, indem Sie auch die
// OCP-Verletzungen beseitigen. Starten Sie von der Klasse `EmployeeV1`
// ausgehend:

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Workshop: Employee OCP
//
// When discussing the  SRP, we refactored the `Employee` class to remove the SRP
// violations. Improve the example further by also removing the OCP violations as
// well. Start with the class `EmployeeV1`:


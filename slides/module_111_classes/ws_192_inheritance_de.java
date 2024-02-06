// %% tags=["subslide"]
import lombok.*;

// %%
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
class Mitarbeiter {
    private String name;
    private String persNr;
    private float grundgehalt;
  
    float gehalt() {
        return 13f / 12f * grundgehalt;
    }
}

// %%
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
class Arbeiter extends Mitarbeiter {
    private float ueberstunden = 0.0f;
    private float stundensatz = 0.0f;

    float gehalt() {
        return super.gehalt() + ueberstunden * stundensatz;
    }
}

// %%
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
class Manager extends Mitarbeiter {
    private float bonus;

    float gehalt() {
        return super.gehalt() + bonus;
    }
}

// %% [markdown]
//
// Create a worker named Hans with employee number 123, a
// basic salary of EUR 36,000.0 Euro, who has worked 3.5 hours of overtime at 
// 40.0 Euro each. Print out the salary.

// %%
Arbeiter a = new Arbeiter("Hans", "123", 36_000f, 3.5f, 40.0f);
System.out.println(a.gehalt());
// Print out instance
System.out.println(a.toString());

// %% [markdown]
//
// Write assertions that test the functionality of the 'Arbeiter' class.

// %%
// This assertion is unnecessary!
assert a.getName().equals("Hans");
assert a.getPersNr().equals("123");
assert a.getGrundgehalt() == 36_000f;
assert a.getUeberstunden() == 3.5f;
assert a.getStundensatz() == 40.0f;

// This assertion should be present
assert Math.abs(a.gehalt() - 39_140f) < 0.0001f;

// %% [markdown]
//
// Create a manager named Sepp, employee number 843, who has a
// basic salary of 60,000.0 Euro and a bonus of 30,000.0 Euro. Print out the
// salary.

// %%
Manager m = new Manager("Sepp", "843", 60_000.0f, 30_000.0f);
System.out.println(m.gehalt());
// Print out instance
System.out.println(m.toString());

// %% [markdown] lang="de"
// Test the functionality of the 'Manager' class.

// %%
assert Math.abs(m.gehalt() - 95_000.0f) < 0.0001f;


// %% [markdown] tags=["alt"]
// ## Solution without Dataclasses:

// %% tags=["alt"]
// We stick to the previous solution as there is no exact equivalent to Python's @dataclass decorator in Java. 
// However, we have used Lombok annotations which is a good fit for our scenario.
// See the classes `Mitarbeiter`, `Arbeiter`, and `Manager` above.

// %% tags=["alt"]
// ... remaining code same as above ...


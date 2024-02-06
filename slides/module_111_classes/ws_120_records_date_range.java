// %% [markdown] lang="en" tags=["slide"]
// # Mini-Workshop : Date Range

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop : Date Range

// %% [markdown] lang="en" tags=["slide"]
// - Define a record `DateRange` with the following properties: `start`, `end`.
// - Make sure that `start` is before `end`.

// %% [markdown] lang="de" tags=["slide"]
// - Definiere einen Datensatz `DateRange` mit den folgenden Eigenschaften: `start`, `end`.
// - Stelle sicher, dass `start` vor `end` liegt.

// %%
import java.time.LocalDate;

// %%
record DateRange(LocalDate start, LocalDate end) 
{
    public DateRange {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("start must be before end");
        }
    }
}

// %% [markdown] lang="en" tags=["slide"]
// What would be the problem, if we used Date instead of LocalDate?

// %% [markdown] lang="de" tags=["slide"]
// Was wäre das Problem, wenn wir Date anstelle von LocalDate verwenden würden?

// %% 
record DateRange(Date start, Date end) 
{
    public DateRange {
        if (start.after(end)) {
            throw new IllegalArgumentException("start must be before end");
        }
    }
}

// %% [markdown] lang="en" tags=["slide"]
// We  could change the start date after the constructor was called.

// %% [markdown] lang="de" tags=["slide"]
// Wir könnten das Startdatum nach dem Aufruf des Konstruktors ändern.

// %%
var range = new DateRange(new Date(95, 1, 1), new Date(96, 1, 31));
range.start().setTime(new Date(97, 1, 1).getTime());
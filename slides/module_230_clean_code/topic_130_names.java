// j2 from 'macros.j2' import header
// {{ header("Clean Code: Namen", "Clean Code: Names") }}

// %% [markdown] lang="de" tags=["slide"]
//
// ## Clean Code: Namen
//
// Unterschätze niemals die Macht von Namen!

// %% [markdown] lang="en" tags=["slide"]
//
// ## Clean Code: Names
//
// Never underestimate the power of names!

// %% [markdown] lang="de" tags=["subslide"]
//
// Namen sind ein mächtiges Kommunikationsmittel.
// - Sie sind überall im Programm zu finden
// - Sie verbinden den Code mit Domänen-Konzepten.


// %% [markdown] lang="en" tags=["subslide"]
//
// Names are a powerful tool for communication
// - They are everywhere in the program
// - They tie code to domain concepts

// %% tags=["keep"]
public double foo(double a, double b){
    if(b > 40){
        throw new IllegalArgumentException("Not allowed");
        }
    return 40.0 * a + 60.0 * b;
}
// %%
foo(40.0, 3.5);

// %% tags=["subslide"]
public static final double REGULAR_PAY_PER_HOUR = 40.0;
public static final double OVERTIME_PAY_PER_HOUR = 60.0;
public static final double MAX_ALLOWED_OVERTIME = 40.0;

// %% tags=["subslide"]
public double computeTotalSalary(double regularHoursWorked, double overTimeHoursWorked){
    if(overTimeHoursWorked > MAX_ALLOWED_OVERTIME){
        throw new IllegalArgumentException("Not allowed to work " + overTimeHoursWorked
            + " hours overtime");
    }
    double regularPay = regularHoursWorked * REGULAR_PAY_PER_HOUR;
    double overtimePay = overTimeHoursWorked * OVERTIME_PAY_PER_HOUR;
    return regularPay + overtimePay;
}

// %%
computeTotalSalary(40.0, 3.5);

// %%
// computeTotalSalary(40.0, 50.0);

// %% tags=["keep", "subslide"]
public class BadNames {
    private List<Integer> theList = new ArrayList<>();

    public List<Integer> getThem() {
        List<Integer> list1 = new ArrayList<>();
        for (Integer x : theList) {
            if (x == 1) {
                list1.add(x);
            }
        }
        return list1;
    }
}

// %% [markdown] lang="de" tags=["notes"]
//
// Zusätzlich zur Verwendung guter Variablennamen gibt es mehrere Möglichkeiten
// Namen ins Programm einzuführen:
// - Erklärende Variablen
// - Enumerations
// - Benannte Tupel
// - Klassen
// - ...

// %% [markdown] lang="en" tags=["notes"]
//
// In addition to the use of good variable names, there are several ways to
// introduce names into the program:
// - Explanatory variables
// - Enumerations
// - Named tuples
// - Classes
// - ...


// %% tags=["keep", "subslide"]
enum Status {
    FLAGGED,
    UNFLAGGED,
}


// %% tags=["keep", "subslide"]
public class Cell {
    private int index;
    public Status status = Status.UNFLAGGED;
    private int bombCount = 0;
}


// %% tags=["keep", "subslide"]
public ArrayList<Cell> makeBoard(int size){

    ArrayList<Cell> board = new ArrayList<Cell>();

    for(int i = 0; i < size; i++){
        board.add(new Cell(i));
    }
    return board;
}


// %% tags=["keep", "subslide"]
public class MineSweeper {
    private ArrayList<Cell> board = makeBoard(64);

    private ArrayList<Cell> getFlaggedCells(){

        ArrayList<Cell> flaggedCells = new ArrayList<Cell>();

        for(Cell cell : board){
            if (cell.status == Status.FLAGGED){
                flaggedCells.add(cell());
            }
        }
        return flaggedCells;
    }
}
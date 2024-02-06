// j2 from 'macros.j2' import header
// {{ header("Records - Motivation", "Records - Motivation") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Motivation
// * Interaktion in und zwischen Komponenten ist ein wichtiger Bestandteile jedes Programms
//   * Üblicherweise sind die Daten dieser Kommunikation - während der Kommunikation - unveränderlich
// * In Java konnte man diese *Qualität* nur durch einiges an Codezeilen *indirekt* andeuten
//   * Durch diese Indirektheit war es bisher nicht möglich effektive Compiler und IDE-Unterstüzung anzubieten

// %% [markdown] lang="de" tags=["slide"]
// - Wir wollen eine unveränderliche Klasse implementieren, die einen Punkt in einem 2D Koordinatensystem repräsentiert
// - Instanzen sollen in Datenstrukturen wie `Set` oder `Map` verwendet werden können und als Schlüssel in einer `Map` dienen
// - Instanzen sollen in einer lesbaren Form ausgegeben werden können

// %% tags=["start"]
class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x; this.y = y;
    }
}

// %% tags=["alt"]
class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x; this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() { return "Point(" + x + ", " + y + ")"; }

    public int x() { return x; }
    public int y() { return y; }
}

// %%
var p1 = new Point(3, 4);

// %%
p1

// %% [markdown] lang="de" tags=["slide"]
// - Das ist eine Menge Boilerplate Code.
// - Es ist leicht Fehler zu machen.

// %% [markdown] lang="de" tags=["slide"]
// ## Records
// - Jetzt implementieren wir die gleiche Klasse als Record.

// %%
record Point(int x, int y) { }

// %% [markdown] lang="de" tags=["slide"]
// - Wir können den generierten Code mit `javap` inspizieren.

// %% [markdown] lang="en" tags=["notes"]
// - Create class Point and compile it. Then use javap to inspect the generated code.




// j2 from 'macros.j2' import header
// {{ header("Records - Data Zentrierte Klassen", "Records - Data Centric Classes") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Records
// - Neue Art von Typdeklaration in Java
//   * Eingeführt in Java 14 als Vorschau (JEP 359) und finalisiert in Java 16 (JEP 395)    
//   * Datenzentriert: eine spezielle Art von Klasse, die verwendet werden kann, um Daten zu modellieren 
//   * Helfen, Boilerplate-Code zu reduzieren und die Lesbarkeit zu erhöhen

// %% 
record Point(int x, int y) { }

// %% [markdown] lang="de" tags=["slide"]
// ## Transparenz

// %% [markdown] lang="de" tags=["slide"]
// Transparenz:
// * Die Signatur einer Record-Klasse gibt alle Felder an, die sie besitzt
// * Die Felder können über über Zugriffsmethoden abgerufen werden:

// %%
var p = new Point(3, 4);
p.x();

// %% 
p.y();

// %% [markdown] lang="de" tags=["slide"]
// # Unveränderlich:
// * Sobald ein Record erstellt wurde, kann sein Zustand nicht mehr geändert werden
// * Vorteil für Multi-Thread Umgebungen und funktionale Programmierung

// %%
p.x = 5; // error

// %% [markdown] lang="de" tags=["slide"]
// Zustandsänderungen werden durch Erzeugung eines neuen Records erreicht:

// %%
p = new Point(p.x() + 1, p.y() + 2);

// %% [markdown] lang="de" tags=["slide"]
// Wenn Felder veränderlich sind, kann der Record-Zustand geändert werden:

// %% tags=["keep"]
record Person(String name, List<String> favoriteBooks) { }

// %% tags=["keep"]
List<String> books = new ArrayList<>();
books.add("The Hobbit");

// %% tags=["keep"]
Person frodo = new Person("Frodo", books);
frodo.favoriteBooks()

// %%
frodo.favoriteBooks().add("The Lord of the Rings");

// %% 
frodo.favoriteBooks()

// %% [markdown] lang="de" tags=["slide"]
// Wollen wir das vermeiden, können wir z.B. List.of() verwenden:

// %%
Person frodo = new Person("Frodo", List.of("The Hobbit"));

// %%
// frodo.favoriteBooks().add("The Lord of the Rings"); // error

// %% [markdown] lang="de" tags=["slide"]
// ## Finalität
// Records werden automatisch als final deklariert:
// * Wir können sie also nicht erweitern
// * Garantiert Konsistenz
// * Vereinfacht Gleichheit

// %% [markdown] lang="de" tags=["slide"]
// ## Reduzierter Boilerplate-Code:
// - Keine Notwendigkeit, Konstruktoren, Zugriffsmethoden, equals(), hashCode(), toString() zu schreiben

// %%
record Point(int x, int y) { }

// %%
var p1 = new Point(3, 4);
var p2 = new Point(1, 1);

// %%
p1.equals(p1);

// %%
p1.equals(p2);

// %%
p1.hashCode();

// %%
p2.hashCode();

// %%
p1.toString();

// %%
p2.toString();

// %% [markdown] lang="de" tags=["slide"]
// |         | **Klasse** | **Record** |
// |---------|---------|---------|
// | **Finalität**  | abstrakt, final, nicht final  | automatisch final (kein abstrakt) |
// | **Felder**  | public, private, protected, ...  | final und private |
// | **Vererbung**  | kann andere Klassen erweitern  | kann andere Klassen nicht erweitern  |

// %% [markdown] lang="de" tags=["slide"]
// ## Einschränkungen mit Referenzfeldern
//
// * Im Beispiel unten bezeichnet ```WerbungEinwurf einwurf```:
//   * Ein Feld mit dem Names ```einwurf```
//   * ```einwurf``` ist eine Referenz auf eine Instanz vom Typ ```WerbungEinwurf``` im Heap
//   * Die Unveränderlichkeit von record sichert zu, dass die Referenz in ```einwurf``` auf das Objekt im Heap nicht verändert wird
//   * Es sichert allerdings nicht zu, dass das Objekt im Heap unveränderlich ist. Deswegen funktioniert das Beispiel unten

// %% tags=["keep"]
public class WerbungEinwurf {
    public String zustimmung;

    @Override
    public String toString() { return "WerbungEinwurf{zustimmung='" + zustimmung + "'}"; }
}

// %% tags=["keep"]
public record Person(String firstName, String secondName, String familyName, WerbungEinwurf einwurf) {}

// %% 
var lieschen = new Person("Lieschen", "", "Musterfrau", new WerbungEinwurf());
lieschen.einwurf().zustimmung = "nein";
System.out.println(lieschen.einwurf());
lieschen.einwurf().zustimmung = "ja";
System.out.println(lieschen.einwurf());

// %% [markdown] lang="de" tags=["slide"]
// ## Benutzerdefinierte Methoden in Records
// - Records können benutzerdefinierte Methoden (Instanz und statisch) haben
// - Records können benutzerdefinierte Konstruktoren haben

// %% tags=["start"]
record Point(int x, int y) {}

// %% tags=["alt"]
record Point(int x, int y) {
    public double distance() {
        return Math.sqrt(x * x + y * y);
    }
}

// %%
var p = new Point(3, 4);
p.distance();

// %% [markdown] lang="de" tags=["slide"]
// Records haben automatisch einen kanonischen Konstruktor, der die Felder initialisiert.
// - Es ist möglich, benutzerdefinierte Konstruktoren hinzuzufügen.
// - Normalerweise würden Sie den kanonischen Konstruktor mit `this()` aufrufen.

// %% tags=["start"]
record Point(int x, int y) {}

// %% tags=["alt"]
record Point(int x, int y) {
    public Point(int x) {
        this(x, 0);
    }
}

// %% [markdown] lang="de" tags=["slide"]
// Der Konstruktor kann gut für Validierungen verwendet werden:

// %% tags=["start"]
record Person(String name, int age) {
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// %% tags=["alt"]
record Person(String name, int age) {
    public Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        this.name = name;
        this.age = age;
    }
}

// %% [markdown] lang="de" tags=["slide"]
// Records erlauben ebenfalls vereinfachte Konstruktordefinitionen:

// %% tags=["start"]
record Person(String name, int age) {}

// %% tags=["alt"]
record Person(String name, int age) {
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
    }
}

// %% [markdown] lang="de" tags=["slide"]
// ## Vererbung
// Während Records keine Klassen erweitern können, können sie Schnittstellen implementieren:

// %% tags=["keep"]
interface StockItem {
    String name();
    String description();
    int price();
}

// %% tags=["start"]
record Book(String name, String description, int price) {}

// %% tags=["alt"]
record Book(String name, String description, int price) implements StockItem {}

// %% tags=["start"]
record Movie(String name, String description, int price) {}

// %% tags=["alt"]
record Movie(String name, String description, int price) implements StockItem {}

// %% 
List<StockItem> stock = List.of(
    new Book("The Hobbit", "A book about a hobbit", 10),
    new Movie("The Lord of the Rings", "A movie about a hobbit", 20)
);

// %% 
stock.forEach(item -> System.out.println(item.name()));

// %% [markdown] lang="de" tags=["slide"]
// ## Datenstrukturen
// Die Verwendung von Records in Kombination mit verschiedenen Datenstrukturen kann zu unterschiedlichem Verhalten führen

// %% 
record Player(String name, int age, double strength){}

// %%
Set<Player> team = new HashSet<>();

// %% tags=["keep"]
team.add(new Player("Ronaldo", 36, 0.9));
team.add(new Player("Messi", 34, 0.9));
team.add(new Player("Haaland", 21, 0.9));
team.add(new Player("Haaland", 21, 0.9));
System.out.println(team);

// %% [markdown] lang="de" tags=["slide"]
// Der doppelte Eintrag wird nicht zum Set hinzugefügt.
// Was ist, wenn wir eine andere Datenstruktur verwenden?

// %%
Set<Player> team = new TreeSet<>();

// %% tags=["keep"]
team.add(new Player("Ronaldo", 36, 0.9));
team.add(new Player("Messi", 34, 0.9));
team.add(new Player("Haaland", 21, 0.9));
team.add(new Player("Haaland", 21, 0.9));

// %% [markdown] lang="de" tags=["slide"]
// Wir erhalten eine ClassCastException
// - Der Grund ist, dass der TreeSet die `compareTo()`-Methode verwendet, um die Reihenfolge der Elemente zu bestimmen
// - Die compareTo-Methode ist nicht konsistent mit der `equals()`-Methode (Law of the Big Three)
// - Damit der TreeSet korrekt funktioniert, müssen wir die compareTo-Methode implementieren

// %% tags=["start"]
record Player(String name, int age, double strength) {}

// %% tags=["alt"]
record Player(String name, int age, double strength) implements Comparable<Player> {
    public int compareTo(Player other) {
        return name.compareTo(other.name);
    }
}

// %% [markdown] lang="de" tags=["slide"]
// Das TreeSet kann jetzt ohne Ausnahmen verwendet werden und auch der doppelte Eintrag wird nicht zum Set hinzugefügt

// %%
Set<Player> team = new TreeSet<>();

// %% tags=["keep"]
team.add(new Player("Ronaldo", 36, 0.9));
team.add(new Player("Messi", 34, 0.9));
team.add(new Player("Haaland", 21, 0.9));
team.add(new Player("Haaland", 21, 0.9));
System.out.println(team);

// %% [markdown] lang="de" tags=["slide"]
// Es gibt immer noch ein Problem mit dieser Implementierung

// %% tags=["keep"]
Set<Player> team = new TreeSet<>();
team.add(new Player("Ronaldo", 36, 0.9));
team.add(new Player("Messi", 34, 0.9));
team.add(new Player("Ronaldo", 45, 0.99));
System.out.println(team);

// %% [markdown] lang="de" tags=["slide"]
// - Die Einträge mit dem gleichen Namen werden nicht zum Set hinzugefügt
// - Das liegt daran, dass die compareTo-Methode nicht konsistent mit der equals-Methode ist
// - Seit Java 8 hat das Comparator-Interface eine statische Methode `comparing()`

// %% tags=["start"]
record Player(String name, int age, double strength) implements Comparable<Player> {
    public int compareTo(Player other) {
        return 0;
    }
}

// %% tags=["alt"]
record Player(String name, int age, double strength) implements Comparable<Player> {
    public int compareTo(Player other) {
        return byAllAttributes().compare(this, other);
    }

    public static Comparator<Player> byAllAttributes() {
        return Comparator.comparing(Player::name)
                .thenComparing(Player::age)
                .thenComparing(Player::strength);
    }
}


// %%
Set<Player> team = new TreeSet<>();

// %% tags=["keep"]
team.add(new Player("Ronaldo", 36, 0.9));
team.add(new Player("Messi", 34, 0.9));
team.add(new Player("Haaland", 21, 0.9));
team.add(new Player("Haaland", 21, 0.9));
team.add(new Player("Ronaldo", 43, 0.99));
System.out.println(team);

// %% [markdown] lang="de" tags=["slide"]
// ## Objekterzeugung
// * Records können verwendet werden, um APIs im Builder-Pattern-Stil zu implementieren:

// %% tags=["start"]
record Car(String model, boolean airConditioning, boolean automaticTransmission, int horsePower) {
    Car(String model){
        this(model, false, false, 0);
    }
}

// %% tags=["alt"]
record Car(String model, boolean airConditioning, boolean automaticTransmission, int horsePower) {
    Car(String model){
        this(model, false, false, 0);
    }
    Car withAirConditioning(boolean airConditioning){
        return new Car(model, airConditioning, automaticTransmission, horsePower);
    }
    Car withAutomaticTransmission(boolean automaticTransmission){
        return new Car(model, airConditioning, automaticTransmission, horsePower);
    }
    Car withHorsePower(int horsePower){
        return new Car(model, airConditioning, automaticTransmission, horsePower);
    }
}

// %%
Car car = new Car("BMW")
    .withAirConditioning(true)
    .withAutomaticTransmission(true)
    .withHorsePower(200);

// %% 
car

// j2 include "ws_110_records_shopping_list.java"

// j2 include "ws_120_records_date_range.java"
// j2 from 'macros.j2' import header
// {{ header("Records - Einsatz", "Records - Applications") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Gute Softwareentwicklungspraktiken
//
// ![](img/check_input_DE.png)

// %% [markdown] lang="de" tags=["slide"]
// ## Eingabeüberprüfung
//
// [Detail](https://de.wikipedia.org/wiki/Fahrzeug-Identifizierungsnummer#Aufbau)

// %% tags=["start"]
public record Vin(String vin) {
    private static final String VALID_CHARS = "1234567890ABCDEFGHJKLMNPRSTUVWXYZ";
}

// %% tags=["alt"]
public record Vin(String vin) {
    private static final String VALID_CHARS = "1234567890ABCDEFGHJKLMNPRSTUVWXYZ";
    public Vin {
        if (vin == null)
            throw new IllegalArgumentException("VIN erforderlich");
        if (vin.length() != 17)
            throw new IllegalArgumentException("Nicht erlaubte Zeichenlänge " + vin.length());
        for (final char c : vin.toCharArray()) {
            boolean vinCharIsValid = false;
            for (final char allowedChar : VALID_CHARS.toCharArray()) {
                if (c == allowedChar) {
                    vinCharIsValid = true;
                    break;
                }
            }
            if (!vinCharIsValid)
                throw new IllegalArgumentException("Unerlaubtes Zeichen '" + c + "'");
        }
    }
    String wmi() { return vin.substring(0, 3); }
    String vds() { return vin.substring(3, 9); }
    String vis() { return vin.substring(9, 17); }
}

// %% tags=["keep"]
var vin = new Vin("SB164ABN1PE082986");
"VIN %s besteht aus: WMI %s, VDS %s und VIS %s".formatted(vin, vin.wmi(), vin.vds(), vin.vis())

// %% [markdown] lang="de" tags=["slide"]
// ## Data Transfer Objects
// - Mit Records können wir leicht unveränderliche Data Transfer Objects (DTOs) realisieren
// - DTOs werden oft als Datencontainer zwischen den Schichten / Schnittstellen einer Anwendung verwendet
// - Beispiel: Ein DTO für die Übertragung von Nutzerdaten

// %%
public record UserDTO(String username, String email, int age) {}

// %% [markdown] lang="de" tags=["slide"]
// * Angenommen wir haben einen Service Layer und einen Datenbank Layer

// %% tags=["start"]
// Service Layer
public class UserService {
    public UserDTO getUserData() {
    }
}

// %% tags=["alt"]
public class UserService {

    public UserDTO getUserData() {
        // In a real application, this data might come from an API request.
        String username = "JavaGuru";
        String email = "javaguru@example.com";
        int age = 30;

        return new UserDTO(username, email, age);
    }
}

// %% tags=["start"]
// Datenbank Layer
public class UserDatabase {
    public void saveUser(UserDTO user) {
        // Here, you would have database logic to save the user.
    }
}

// %% tags=["alt"]
// Datenbank Layer
public class UserDatabase {

    public void saveUser(UserDTO user) {
        // Here, you would have database logic to save the user.
        System.out.println("Saving user: " + user);
    }
}

// %% tags=["keep"]
UserService userService = new UserService();
UserDatabase userDatabase = new UserDatabase();

// %%
UserDTO user = userService.getUserData();

// %%
userDatabase.saveUser(user);

// %% [markdown] lang="de" tags=["slide"]
// ## Parameter Values Objects
// - Parameter Values Objects (PVOs) können dabei helfen Parameter-Listen lesbarer zu machen
// - Angenommen wir wollen ein Rechteck modellieren

// %% 
record Rectangle(int x, int y, int width, int height) { }

// %% [markdown] lang="de" tags=["slide"]
// - Wir können die Erzeugung von Rechtecken vereinfachen indem wir zwei PVOs definieren

// %% 
record Point(int x, int y) { }

// %% 
record Dimension(int width, int height) { }

// %% [markdown] lang="de" tags=["slide"]
// - `Rectangle` können wir nun mit `Point` und `Dimension` modellieren

// %%
record Rectangle(Point origin, Dimension size) { }

// %%
var r = new Rectangle(new Point(3, 4), new Dimension(5, 6));

// %% [markdown] lang="de" tags=["slide"]
// ## Zusammengesetzte Schlüssel (Compound Keys)
// - Compound Key: Aggregation mehrerer Werte zu einem einzelnen Schlüssel (z.B. für Maps)
// - Records bieten sich dafür an
// - Unveränderlichkeit stellt sicher, dass sich der Schlüssel nicht ändert
// - `equals()` und `hashCode()` sind bereits implementiert
// - Beispiel: Bibliothek mit Büchern

// %%
public record BookKey(String isbn, String librarySection) {}

// %%
var bookInventory = new HashMap<>();

// %%
bookInventory.put(new BookKey("ISBN12345", "Fiction"), 5);
bookInventory.put(new BookKey("ISBN67890", "Non-Fiction"), 3);

// %% [markdown] lang="de" tags=["slide"]
// - Wir können nun einfach nach Büchern suchen:

// %% tags=["keep"]
BookKey key = new BookKey("ISBN12345", "Fiction");
if (bookInventory.containsKey(key)) {
    System.out.println("Number of copies: " + bookInventory.get(key));
} else {
    System.out.println("Book not found in inventory.");
}

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop: Records als Parameter Values Objects
// - Gegeben ist die folgende Person-Klasse:

// %% tags = ["keep"]
record Person(
    String firstName, String lastName, LocalDate birthday,
    String street, String houseNumber, int zipCode, String city,
    String phone, String mobile, String email, String iban, String bic
) { }

// %% [markdown] lang="de" tags=["slide"]
// - Vereinfache diese Klasse mit Records als Parameter Values Objects (PVOs)
// - Definiere dazu geeignete Records als PVOs

// %% 
record Address(String street, String houseNumber, int zipCode, String city) { }

// %%
record Contact(String phone, String mobile, String email) { }

// %%
record BankAccount(String iban, String bic) { }

// %%
record Person(
    String firstName, String lastName, LocalDate birthday,
    Address address, Contact contact, BankAccount bankAccount
) { }

// j2 include "ws_130_records_address.java"

// j2 include "ws_140_records_thread.java"


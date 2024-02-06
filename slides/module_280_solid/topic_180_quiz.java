// j2 from 'macros.j2' import header
// {{ header("SOLID Quiz", "SOLID Quiz") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Frage 1:
// Welches SOLID-Prinzip wird in folgendem Code verletzt?:

// %% [markdown] lang="en" tags=["slide"]
// ## Question 1:
// Which SOLID principle is violated in the following code?

// %% tags=["keep"]
interface Bird {
    void sing();
    void fly();
}

class Sparrow implements Bird {
    public void sing() {
        // Sing behaviour
    }
    public void fly() {
        // Fly behaviour
    }
}

class Ostrich implements Bird {
    public void sing() {
        throw new UnsupportedOperationException();
    }
    public void fly() {
        throw new UnsupportedOperationException();
    }
}

// %% 
// Der Code verletzt das Interface Segregation Principle (ISP). 
// Das Interface "Bird" definiert eine "fly()" Methode, aber nicht alle Vögel können fliegen (wie der Strauß im Beispiel). 
// Daher sollte das Interface in kleinere, spezifischere Interfaces aufgeteilt werden, um sicherzustellen, 
// dass die implementierenden Klassen nur die Methoden implementieren, die sie tatsächlich benötigen.

// %% [markdown] lang="de" tags=["slide"]
// ## Frage 2:
// Welches SOLID-Prinzip wird in folgendem Code verletzt?:

// %% [markdown] lang="en" tags=["slide"]
// ## Question 2:
// Which SOLID principle is violated in the following code?

// %% tags=["keep"]
class Email {
    void sendEmail(String address, String subject, String content) {
        // Send an email
    }
}

class Notification {
    private Email email;

    void notifyUser(String user, String message) {
        email.sendEmail(user, "Notification", message);
    }
}

// %%
// Der Code verletzt das Dependency Inversion Principle (DIP).
// Die Klasse "Notification" hängt von der Implementierung der Klasse "Email" ab,
// anstatt von einem Interface abzuhängen.

// %% [markdown] lang="de" tags=["slide"]
// ## Frage 3:
// Welches SOLID-Prinzip wird in folgendem Code verletzt?:

// %% [markdown] lang="en" tags=["slide"]
// ## Question 3:
// Which SOLID principle is violated in the following code?

// %% tags=["keep"]
class DiscountCalculator {
    void calculateDiscount(Product product) {
        if (product.getType() == ProductType.SALE) {
            // Calculate sale discount
        } else if (product.getType() == ProductType.REGULAR) {
            // Calculate regular discount
        }
    }
}

// %%
// Der Code verletzt das Open-Closed Principle (OCP).
// Die Klasse "DiscountCalculator" muss geändert werden, wenn ein neuer Produkttyp hinzugefügt wird.
// Besser wäre es, die Klasse "Product" zu erweitern, um neue Produkttypen zu unterstützen.

// %% [markdown] lang="de" tags=["slide"]
// ## Frage 4:
// Welches SOLID-Prinzip wird in folgendem Code verletzt?:

// %% [markdown] lang="en" tags=["slide"]
// ## Question 4:
// Which SOLID principle is violated in the following code?

// %% tags=["keep"]
public class Employee {
    private String name;
    private int age;
    private String address;

    public void saveEmployee() {
        // Code to save employee in database
    }
    
    public void generateEmployeeReport() {
        // Code to generate report
    }
}


// %%
// Der Code verletzt das Single Responsibility Principle (SRP).
// Die Klasse "Employee" hat zwei Verantwortlichkeiten:
// - Speichern eines Mitarbeiters in der Datenbank
// - Generieren eines Mitarbeiterberichts

// j2 from 'macros.j2' import header
// {{ header("Sealed Types", "Sealed Types") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Vererbung in Java
// * Eines der Sprachdesignprinzipien von Java ist Objekt-Orientierung
//   * Zu diesem Prinzip gehört Beziehung zwischen Objekten und Klassen zu beschreiben
//   * Vererbung zwischen Klassen stellt eine dieser Beziehungen dar
// * Vererbung war in Java bisher beliebig möglich

// %% [markdown] lang="de" tags=["slide"]
// ## Probleme mit beliebiger Beerbbarkeit
// * Das sorgfältige designen von komplexen Systemen (Bibliotheken, ...) ist aufwändig
// * Bestandteile des Design sind u.a.:
//   * Welche Typen (Klassen, Schnittstellen, ...) werden nach außen zur Verwendung bereitgestellt
//   * Wie wird auf Typen konsistent und sinnvoll reagiert

// %% [markdown] lang="de" tags=["slide"]
// * Subtypen werden von Basis-Typen werden an vielen Stellen in der Bibliothek akzeptiert
// * Akzeptierte Instanzen eines Typs müssen innerhalb einer Bibliothek sinnvoll und konsistent verarbeitet werden
//   * Falls der Bibliotheksverwender einen eigenen Subtyp erstellt, so wird dieser von der Bibliothek akzeptiert
//   * Der neue Subtyp kann sich allerdings nicht-konform Verhalten und somit die Konsistenz der Bibliothek etc. gefährden
//   * Es kann unerwünscht sein, das weitere Subtypen außerhalb der Bibliothek erstellt werden können

// %% [markdown] lang="de" tags=["slide"]
// ![](img/simple-type-hierarchy-DE.svg "Einfache Typhierarchie mit Nutzeranpassungen")
// <!--
// @startuml
// package "Bibliothek" {
//   Basistyp <|-- Aufbau
// }
// 
// package "Bibliotheksverwender" {
//   Basistyp <|-- Erweiterung
//   Aufbau <|-- Anpassung
// }
// @enduml
// -->

// %% [markdown] lang="de" tags=["slide"]
// ## Bisherige work-arounds
// * `enum`
// * `final`
// * package private

// %% [markdown] lang="de" tags=["slide"]
// ## work-around: `enum`
// * Ausprägungen von `enum` sind Singletons
//   * Sobald ein Design Instanzen benötigt (unterscheidbar individuelle ausgeprägte Objekte), scheidet `enum` aus
// * Keine Vererbung mit `enum`

// %% [markdown] lang="de" tags=["slide"]
// ## work-around: `final`
// * Das Schlüsselwort `final` verhindert nur das beerben eines Typs
// * Damit eine Typhierarchie entstehen kann, muss der Basistyp mindestens für eine begrenzte Anzahl an Subtypen beerbbar sein
// * `final` unterstützt keine Einschränkung der Vererbung in dieser Granularität
//
// ![](img/type-hierarchy-with-final-DE.svg "Typhierarchie mit final Schlüsselwort")
// <!--
// @startuml
// package "Bibliothek" {
//   class Aufbau << final >>
//   Basistyp <|-- Aufbau
// }
// 
// package "Bibliotheksverwender" {
//   Basistyp <|-- Erweiterung
// }
// @enduml
// -->

// %% [markdown] lang="de" tags=["slide"]
// ## work-around: Kombination `final` und `package`
// * Sichtbarkeit des Basistyps auf das package begrenzen
// * Subtypen `public` und `final` machen
// Einige der Nachteile:
// * Ausprägungen können nur in diesem package erfolgen
// * Die Bibliotheksverwender können nur mit den Subtypen arbeiten und können keinen Basistyp für Gemeinsamkeiten verwenden
//   * Dies erschwert das Arbeiten mit der Bibliothek
// * Der Compiler erhält nur einen schwachen Hinweis auf die Abgeschlossenheit der Typhierarchie

// %% tags=["notes"]
// StringBuffer, StringBuilder und AbstractStringBuilder -- davor waren StringBuffer, StringBuilder lose Klassen mit der gleichen Idee

// %% [markdown] lang="de" tags=["slide"]
// ## Beispiel:

// %% tags=["slide", "keep"] 
public abstract class Message 
    permits TextMessage, ImageMessage {

    private String sender;
    private long timestamp;

    public abstract void process();
}

// %% [markdown] lang="de" tags=["slide"]
// Wir wollen die Menge der Subtypen, die `Message` erweitern oder implementieren können, einschränken.

// %% 
public class TextMessage extends Message {

    private String text;

    @Override
    public void process() {
        System.out.println("Processing text message");
        // logic to process a text message
    }
}

// %% 
public class ImageMessage extends Message {
    private byte[] imageData;

    @Override
    public void process() {
        System.out.println("Processing image");
        // logic to process an image message
    }
}

// %% [markdown] lang="de" tags=["slide"]
// Verwandte Tricks:
// * Essentielle Bestandteile des Basistyps package-private machen
//   * z.B. den Konstruktur
//
// Alle diese Tricks kommunizieren nur indirekt und nicht eindeutig die Intention der Typdesigner
// * Damit ist die Intention nicht (im Code) nutzbar für z.B. 
//    * Patternmatching
//    * Compilerprüfungen
//    * Compilerwarnungen
//    * IDE-Unterstüzung

// %% [markdown] lang="de" tags=["slide"]
// ## Zusammenfassende Motivation für `sealed`
// * Entwickler einer Typhierarchie soll eindeutig die Intention kommunizieren können
// * Ein Basistyp (Klasse, Schnittstelle, ...) soll eindeutig kommunizieren, welche Spezialisierungen erlaubt sind
// * Dabei soll der Basistyp
//   * Frei zugreifbar sein
//   * Nicht bzw. gesteuert erweiterbar sein
//   * Keine komplexen Einschränkungen an die Subtypen stellen

// %% [markdown] lang="de" tags=["slide"]
// ## Das `sealed` Schlüsselwort
// * `sealed` ist ein Feature in Java, welches in 17 finalisiert wurde
// * Schlüsselwort `sealed` ist anwendbar auf Typendefinitionen (Klassen, Schnittstellen, ...)
// * Ein sealed Typ gibt mit dem Schlüsselwort `permits` explizit an, welche Spezialisierungen es gibt
//   * Die Spezialisierungen können auch in anderen package ausgeprägt werden.
//
// *Der folgende Code ist korrekt. Die Klassen müssen in die jeweils korrekt benannten Dateien eingefügt werden. Dies ist leider in JShell/Jupyter nicht möglich.*

// %% tags=["slide","keep"]
public sealed class Shape
        permits ASquare, ACircle, ABox {}

public non-sealed class ASquare extends Shape {
    public ASquare() {}
}
public final class ACircle extends Shape {
    public ACircle() {}
}
public sealed class ABox extends Shape {
    public ABox() {}
}

// %% [markdown] lang="de" tags=["slide"]
// ## Einschränkungen an die Subtypen
//
// * Subtypen können keine anonyme Typen sein
// * Der sealed Typ und seine Subtypen müssen im gleichen Modul definiert sein
//   * Falls das Modul unbenannt ist, müssen die Subtypen im gleichen package sein
// * Jeder Subtyp muss direkt von dem sealed Typ abgeleitet sein
// * Jeder Subtyp muss konform zu einen der folgenden Modifikatoren implementiert sein:
//   * `final` kein weiteres Ableiten möglich
//   * `sealed` um Typdesignern eine intentionelle Verfeinerung der Typhierarchie zu ermöglichen
//   * `non-sealed` um Typverwendern eine Verfeinerung der Typhierarchie explizit zu erlauben

// %% [markdown] lang="de" tags=["slide"]
// ## Der non-sealed Kniff
//
// * Den Entwicklern der Bibliothek oder Typhierarchie ist es durch ```non-sealed``` möglich explizite und bekannte Erweiterungspunkte anzubieten
// * Weil diese Punkte explizit und bekannt sind,
//   * ist eine gesteuert Weiterentwicklung der Bibliothek möglich
//   * können Nutzer auf ihre Spezifika eingehen ohne die Bibliothek zu forken und umzuschreiben
//   * können die Entwickler besondere Vorsicht bei der Verwendung der entsprechenden Instanz anwenden

// %% [markdown] lang="de" tags=["slide"]
// ## Auslassen von `permits`
//
// * Bei wenigen und einfachen Spezialisierungen, können diese auch im Body des sealed Typen definiert werden.
//   * Die explizite Angabe von permits ist dann nicht nötig

// %% tags=["keep"]
abstract sealed class Root { 
    final class A extends Root { }
    final class B extends Root { }
    final class C extends Root { }
}

// %% [markdown] lang="de" tags=["slide"]
// Mit Schnittstellen

// %% tags=["keep"]
sealed interface Expr {
    final class ConstantExpr implements Expr {}
    final class PlusExpr     implements Expr {}
    final class TimesExpr    implements Expr {}
    final class NegExpr      implements Expr {}
}

// %% [markdown] lang="de" tags=["slide"]
// Mit records

// %% [markdown] lang="en" tags=["slide"]
// With records

// %% tags=["keep"]
sealed interface ExprWithRecords {
    record ConstantExprWithRecords<T>(T a)      implements ExprWithRecords {}
    record PlusExprWithRecords<T, U>(T a, U b)  implements ExprWithRecords {}
    record TimesExprWithRecords<T, U>(T a, U b) implements ExprWithRecords {}
    record NegExprWithRecords<T>(T a)           implements ExprWithRecords {}
}

// %% [markdown] lang="de" tags=["slide"]
// * `record` ist implizit `final`
//   * und muss somit hier nicht angegeben werden.
//   * und kann somit nicht mit `sealed` oder `non-sealed` kombiniert werden.

// %% [markdown] lang="de" tags=["slide"]
// ## instanceof mit Subtypen von sealed
//
// * Java nimmt üblicherweise Erweiterbarkeit an
// * Deswegen funktionieriert folgender Code:
//   * Bedenke: Zukünftige Entwicklungen könnte $C$ um die Schnittstelle $I$ erweitern.

// %% tags=["keep"]
interface I {}
class C {}   // implementiert I nicht, aber möglichweise in Zukunft

// %%
void test (C c) {
    if (c instanceof I) 
        System.out.println("It's an I");
}
test(new C()) // keine Ausgabe

// %% [markdown] lang="de" tags=["slide"]
// * Der Compiler weiß bei `sealed` und `final` Typen, dass eine Erweiterung von außerhalb des Moduls bzw. package unmöglich ist
// * Deswegen kann der Compiler auswerten, ob ein `instanceof` überhaupt möglich ist

// %% tags=["keep"]
interface I {}
sealed class C {
    final class D extends C {}
}

// %%
void test (C c) {
    if (c instanceof I)     // Compile-time error!
        System.out.println("It's an I");
}

// %% [markdown] lang="de"
// * Hier weiß der Compiler, dass alle (!) Ableitungen von $C$ das Interface $I$ niemals implementieren werden.
//   * Deswegen kann der Compiler und die IDE einen Fehler melden

// %% tags=["keep", "slide"] 
interface I {}
sealed class C {
    non-sealed class D extends C {}
    final      class E extends C {}
}

// %%
void test (C c) {
    if (c instanceof I)
        System.out.println("It's an I");
}

// %% [markdown] lang="de"
// * Hier weiß der Compiler, dass es mindestens einen Vererbungspfad geben könnte, welcher eine Ausprägung von $C$ mit $I$ erlauben würde.
//   * Der Vererbungspfad über die `non-sealed` Klasse $D$.


// %% [markdown] lang="de" tags=["slide"]
// ## Java-seitige Nutzung von sealed
//
// * In kommenden Java Versionen ist geplant das benannten Einschränkungen von sealed (durch explizite Aufzählung der Subtypen mittels `permits`) zu nutzen.
//   * Kein default in switch
//   * Patternmatching in switch
//   * Compiler-seitige Optimierungen
//   * Neue Typinferenzlogik im Falle nur einer einzigen erlaubten Spezialisierungen eines sealed Typs

// %% [markdown] lang="de" tags=["slide"]
// Die Reflection API wurde erweitert um sealed Typen zu unterstützen

// %% [markdown] lang="en" tags=["slide"]
// The reflection API has been updated to support sealed types

// %% tags=["keep"]
public sealed class TextMessage {
    public final class SMS extends TextMessage {}
    public final class EMail extends TextMessage {}
}

// %%
Class<?> clazz = TextMessage.class;
System.out.println(clazz.isSealed());
System.out.println(clazz.getPermittedSubclasses());


// %% [markdown] lang="de" tags=["slide"]
// ## Mini-Workshop: Taschenrechner
//
// - Wir wollen einen Taschenrechner entwerfen, der auf die vier Grundrechenarten beschränkt ist
// - Implementieren Sie die Klassen aus folgendem Klassendiagramm
//
// <img src="img/calculator.png"
//      style="display:block;margin:auto"/>

// %% [markdown] lang="de" tags=["slide"]
// - **Hinweis**: Nutzen Sie für diesen Workshop eine IDE
// - Definieren Sie einen sealed Typ `MathOp` der eine abstrakte Methode `eval(int a, int b)` definiert
// - Erlauben Sie den Klassen `Add` und `Sub` den Typ `MathOp` zu erweitern sowie die nicht-sealed Klasse `BaseOp`
// - Definieren Sie die beiden Grundrechenarten `Add` und `Sub`
// Für die Division und Multiplikation wollen wir eine weitere Ebene der Vererbung hinzufügen
// - Definieren Sie einen nicht-sealed Typ `BaseOp` der `MathOp` erweitert und eine Default-Implementierung von `eval` bereitstellt
// - Definieren Sie die Klassen `Div` und `Mul`

// %% [markdown] lang="en" tags=["slide"]
// ## Mini-Workshop: Calculator 
// 
// - We want to design a calculator restricted to the four basic operations
// - Implement the classes from the following class diagram
//
// <img src="img/calculator.png"
//      style="display:block;margin:auto"/>

// %% [markdown] lang="en" tags=["slide"]
// - **Hint**: Use a IDE for that Workshop
// - Define a sealed type `MathOp` which defines an abstract method `eval(int a, int b)`
// - Permit the classes `Add` and `Sub` to extend `MathOp` as well as the non-sealed class `BaseOp`
// - Define the two basic operations `Add` and `Sub`
// For the division and multiplication we want to add another level of hierarchy
// - Define a non-sealed type `BaseOp` which extends `MathOp` and provides a default implementation of `eval`
// - Define the classes `Div` and `Mul` which extend `BaseOp`

// %% 
sealed interface MathOp permits Add, Sub, BaseOp {
    int eval(int a, int b);
}

// %% 
final class Add implements MathOp {
    @Override
    public int eval(int a, int b) {
        return a + b;
    }
}

// %%
final class Sub implements {
    @Override
    public int eval(int a, int b) {
        return a - b;
    }
}

// %%
non-sealed class BaseOp implements MathOp {
    @Override
    public int eval(int a, int b) {
        return 0;
    }
}

// %% 
final class Mult extends BaseOp {
    @Override
    public int eval(int a, int b) {
        return a * b;
    }
}

// %% 
final class Div extends BaseOp {
    @Override
    public int eval(int a, int b) {
        return a / b;
    }
}


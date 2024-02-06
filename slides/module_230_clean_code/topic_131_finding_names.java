// j2 from 'macros.j2' import header
// {{ header("Wie findet man gute Namen?", "How to find good names?") }}

// %% [markdown] lang="de" tags=["slide"]
//
// ## Wie findet man gute Namen?
//
// - Wähle nach Aussagekraft, nicht nach Bequemlichkeit
// - Verwende Namen, die sagen, was sie bedeuten, und bedeuten, was sie sagen
// - Sonst wird die Wartung viel schwieriger...
// - ... und der größte Teil der Kosten für Software entsteht durch Wartung

// %% [markdown] lang="en" tags=["slide"]
//
// ## How to find good names?
//
// - Select for expressivity, not convenience
// - Use names that say what they mean and mean what they say
//   - Otherwise, maintenance becomes much harder...
//   - ... and most of the costs of software come from maintenance


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Was ist ein guter Name?
//
// - Beantwortet
//   - Warum gibt es diese Funktion (Klasse, Modul, Objekt...)?
//   - Was macht sie?
//   - Wie wird sie verwendet?
// - Kommuniziert die Intention (ist "intention revealing")
// - (Ist im Allgemeinen nicht leicht zu finden)


// %% [markdown] lang="en" tags=["subslide"]
//
// ## What is a good name?
//
// - Answers
//   - Why does this exist?
//   - What does it do?
//   - How is it used?
// - Is intention-revealing (communicates)
// - (Is generally not easy to find)

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Was ist ein schlechter Name?
//
// - Braucht einen Kommentar
// - Kann nur verstanden werden, wenn man sich den Code ansieht
// - Verbreitet Desinformation
// - Entspricht nicht den Namensregeln

// %% [markdown] lang="en" tags=["subslide"]
//
// ## What is a bad name?
//
// - Needs a comment
// - Can only be understood by looking at the code
// - Provides disinformation
// - Does not conform to naming rules

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Clean Code Namensregeln
//
// Gute Namen
//
// - sind selbsterklärend
// - offenbaren die Intention
// - sind aussprechbar und durchsuchbar
// - beschreiben das Problem, nicht die Implementierung
// - vermeiden Desinformation und benennen eine sinnvolle Unterscheidung
// - vermeiden Kodierungen (ungarische Notation)
// - verwenden die richtige Wortart (lexikalische Kategorie)
// - verwenden die Regeln für Umfang und Länge (Scope-Length Rules)


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Clean Code naming rules
//
// Good names
//
// - are self-explanatory
// - are intention-revealing
// - are pronounceable and searchable
// - describe problem, not implementation
// - avoid disinformation and make meaningful distinction
// - avoid encodings (Hungarian notation)
// - use the correct part of speech
// - use scope-length rules


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Selbsterklärende Namen

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Self-explanatory names

// %% tags=["keep"]
// Elapsed time in days
int d = 0;

// %%
int elapsedTimeInDays = 0;

// %% [markdown] lang="de" tags=["slide"]
//
// ## Namen, die die Intention offenbaren
//
// Reflektieren Absicht, Verhalten, Existenzberechtigung

// %% [markdown] lang="en" tags=["slide"]
//
// ## Intention-revealing names
//
// Reflect intention, behavior, reason for existence

// %% tags=["keep"]
ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(
                            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));

// %% tags=["keep"]
ArrayList<Integer> dpmLst = new ArrayList<>(Arrays.asList(
                            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));


// %% tags=["alt"]
ArrayList<Integer> daysPerMonth = new ArrayList<>(Arrays.asList(
                            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31));

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Namen sind aussprechbar und durchsuchbar


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Pronounceable and searchable names

// %% tags=["keep"]
ArrayList<Integer> hwCrsrPxy = new ArrayList<>(Arrays.asList(0, 0));

// %%
ArrayList<Integer> hardwareCursorPosition = new ArrayList<>(Arrays.asList(0, 0));


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Namen beschreiben das Problem, nicht die Implementierung
//
// Vermeide Namen, die sich auf Implementierungsdetails beziehen:
// - Sie verraten nicht, warum der Code so geschrieben wurde, wie er geschrieben ist
// - Aber die Vermittlung der Intention hinter dem Code hat höchste Priorität!

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Describe problem, not implementation
//
// Avoid names that refer to implementation details:
// - They don’t reveal why the code was written the way it is written
// - But communicating intentions is your highest priority!


// %% tags=["keep", "subslide"]
public int calculateFactorialRecursive(int number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * calculateFactorialRecursive(number - 1);
        }
}


// %% tags=["keep"]
calculateFactorialRecursive(10);



// %%
public int factorial(int number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * calculateFactorialRecursive(number - 1);
        }
}

// %%
factorial(10);

// %% [markdown] lang="de" tags=["slide"]
//
// ## Desinformation und sinnvolle Unterscheidungen
//
// - Namen bedeuten etwas
// - Desinformation:
//   - Die Bedeutung des Namens impliziert etwas anderes als der Programmcode:


// %% [markdown] lang="en" tags=["slide"]
//
// ## Avoiding disinformation and making meaningful distinctions
//
// - Names mean something
// - Disinformation:
//   - The name's meaning implies something different than its program code:



// %% tags=["keep"]
public class Pair {
    public int first;
    public int second;
    public int third;
}


// %%
public class Triple {
    public int first;
    public int second;
    public int third;

}


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Regeln zur Vermeidung von Desinformation
//
// - Vermeide Plattformnamen wie `sco`, `aix`, `nt`
//   - Oft sind Merkmalsprüfungen besser
// - Nimm keinen Typ in einen Variablennamen auf, wenn die Variable nicht von
//   diesem Typ ist
//   - Meistens: Gib überhaupt keinen Typ in einem Variablennamen an

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Rules to avoid disinformation
//
// - Avoid platform names sco, aix, nt
//   - Often feature checks are better
// - Don't include a type in a variable name if the variable is not of that type
//   - Mostly: Don't include a type in a variable name at all


// %% tags=["keep"]
int vectorOfCards = 0;

// %%
int numCards = 0;

// %%
ArrayList<Object> list = new ArrayList<Object>();

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Regeln zur Vermeidung von Desinformation
//
// - Sei vorsichtig mit Namen, die sich nur geringfügig unterscheiden

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Rules to avoid disinformation
//
// - Be careful with names that differ only slightly


// %% tags=["keep"]
boolean isMeleeDefenceAvailable = true;
boolean isMeleeDefenseAvailable = false;

// %% tags=["keep"]
System.out.println(isMeleeDefenceAvailable == isMeleeDefenseAvailable);

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Regeln zur Vermeidung von Desinformation
//
// - Benutze Namen, die etwas bedeuten

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Rules to avoid disinformation
//
// - Use names that mean something

// %% tags=["keep"]
int fooBar = 0;
int bar = 1;

// %%
int numberOfVisitors = 0;
int daysTillRelease = 1;

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Regeln zur Vermeidung von Desinformation
//
// - Sei bei der Namensgebung konsistent

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Rules to avoid disinformation
//
// - Be consistent when naming

// %% tags=["keep"]
int numberOfObjects = 10;
int numBuyers = 12;
int nTransactions = 2;

// %%
int numObjects = 10;
int numBuyers = 12;
int numTransactions = 2;

// %%
int nObjects = 10;
int nBuyers = 12;
int nTransactions = 2;

// %% [markdown] lang="de" tags=["slide"]
//
// ## Sinnvolle Unterscheidungen
//
// - Verwende Namen, die die Bedeutung der Konzepte so klar wie möglich ausdrücken


// %% [markdown] lang="en" tags=["slide"]
//
// ## Meaningful distinctions
//
// - Use names that express the meaning of concepts as clearly as possible

// %% tags=["keep"]
String a1 = "Fluffy";
String a2 = "Garfield";

// %%
String myDog = "Fluffy";
String JohnsCat = "Garfield";

// %% tags=["keep", "subslide"]
int INCLUDE_NONE = 0;
int INCLUDE_ONE = 1;
int INClUDE_SECOND = 2;
int INCLUDE_BOTH = 3;

// %% tags=["keep"]
int INCLUDE_NO_DATE = 0;
int INCLUDE_START_DATE = 1;
int INCLUDE_END_DATE = 2;
int INCLUDE_START_AND_END_DATE = 3;


// %%
enum DatesToInclude {
    NONE,
    START,
    END,
    START_AND_END
}


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Sinnvolle Unterscheidungen
//
// - Verwende denselben Namen für dasselbe Konzept


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Meaningful distinctions
//
// - Use the same name for the same concept

// %% tags=["keep", "subslide"]
import java.nio.file.Path;
import java.nio.file.Paths;

// %% tags=["keep"]
Path myPath = Paths.get(System.getProperty("user.home"));
Path yourDir = Paths.get(System.getProperty("user.home"));
Path fileLoc = Paths.get(System.getProperty("user.home"));

// %% tags=["keep"]
Path myPath = Paths.get(System.getProperty("user.home"));
Path yourPath = Paths.get(System.getProperty("user.home"));
Path filePath = Paths.get(System.getProperty("user.home"));



// %% [markdown] lang="de" tags=["subslide"]
//
// ## Sinnvolle Unterscheidungen
//
// - Verwende deutlich unterschiedliche Namen für verschiedene Konzepte


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Meaningful distinctions
//
// - Use clearly different names for different concepts

// %% tags=["keep"]
Object MY_EFFICIENT_STRING_PROCESSING_HANDLE; // a handle is a reference to a resource
Object MY_EFFICIENT_STRING_PROCESSING_HANDLER; // a handler is a block of code that handles an event or error condition


// %% [markdown] lang="de" tags=["slide"]
//
// ## Vermeide Kodierungen
//
// Verwende keine ungarische Notation:


// %% [markdown] lang="en" tags=["slide"]
//
// ## Avoid encodings
//
// Avoid Hungarian notation:

// %% tags=["keep"]
int iDays = 12;
int iMonth = 3;


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vermeide Kodierungen
//
// Verwende keine Präfixe für Attribute:

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Avoid encodings
//
// Avoid member prefixes:


// %% tags=["keep"]
public class MyClass {
    int mDays;
    int mMonth;
}


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vermeide Kodierungen
//
// Vermeiden Sie Präfixe wie C/I: CClass, IInterface

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Avoid encodings
//
// Avoid C/I prefixes: CClass, IInterface


// %% tags=["keep"]
public class CMyClass {
    int days;
    int months;
}


// %% [markdown] lang="de" tags=["slide"]
//
// ## Verwende die richtige lexikalische Kategorie
//
// - Klassen und Variablen: Substantive oder Substantivphrasen
// - Funktionen: Verben oder Verbphrasen
// - Enums: oft Adjektive
// - Boolesche Variablen und Funktionen: oft Prädikate: `ist_...`, `hat_...`

// %% [markdown] lang="en" tags=["slide"]
//
// ## Use the correct part of speech
//
// - Classes and variables: nouns or noun phrases
// - Functions: verb or verb phrases
// - Enums: often adjectives
// - Boolean variables and functions: often predicates: `is_...`, `has_...`



// %% [markdown] lang="de" tags=["subslide"]
//
// ## Möglicherweise
//
// Vermeide Wörter, die keine Bedeutung haben, wie Manager, Prozessor, Daten,
// Info

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Possibly
//
// Avoid noisy words, such as Manager, Processor, Data, Info

// %% tags=["keep"]
public class ObjectManager{

}


// %% tags=["keep"]
public class ObjectController{

}


// %% tags=["keep"]
public class DataController {

}



// %% [markdown] lang="de" tags=["slide"]
//
// ## Regeln für Umfang und Länge (Scope-Length Rules)
//
// - Variablen:
// - Langer Geltungsbereich = langer Name
// - Kurzer Geltungsbereich = kurzer Name
// - Klassen und Methoden
// - Langer Geltungsbereich = kurzer Name
// - Kurzer Geltungsbereich = langer Name
//
// **Oder:** Verwende lange Namen für lange Geltungsbereiche


// %% [markdown] lang="en" tags=["slide"]
//
// ## Scope-length rules
//
// - Variables:
//   - Long scope = long name
//   - Short scope = short name
// - Classes and Methods
//   - Long scope = short name
//   - Short scope = long name
//
// **Or:** Use long names for long scopes


// %% tags=["subslide", "keep"]
public class FixedSizeOrderedCollectionIndexedByInts {

}


// %%
public class Array {

}

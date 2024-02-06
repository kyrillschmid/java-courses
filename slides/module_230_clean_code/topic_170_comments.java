// j2 from 'macros.j2' import header
// {{ header("Clean Code: Kommentare und Dokumentation", "Clean Code: Comments and Documentation") }}


// %% [markdown] lang="en" tags=["slide"]
//
// // Clean Code: Comments and Documentation

// %% [markdown] lang="de" tags=["subslide"]
//
// ## JavaDoc
//
// Java bietet eine Möglichkeit, Ihren Code mit JavaDoc-Kommentaren zu dokumentieren. JavaDoc-Kommentare sind ähnlich wie docstrings in Python, aber sie stehen über der Entität, die sie dokumentieren, und sind in /** und */ eingeschlossen. 


// %% [markdown] lang="en" tags=["subslide"]
//
// ## JavaDoc
//
// Java bietet eine Möglichkeit, Ihren Code mit JavaDoc-Kommentaren zu dokumentieren. JavaDoc-Kommentare sind ähnlich wie docstrings in Python, aber sie stehen über der Entität, die sie dokumentieren, und sind in /** und */ eingeschlossen. 


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Kommentare
//
// - Kommentare kompensieren unser Unvermögen, uns in Code auszudrücken.
// - Wenn möglich, drücke dich in Code aus, nicht in Kommentaren!
//   - Wann immer du einen Kommentar schreiben willst, prüfe, ob du es nicht im
//     Code tun kannst.
//   - Verwende erklärende Variablen

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Comments
//
// - Comments compensate for our failure to express ourselves in code
// - If possible, express yourself in code, not comments!
//   - Whenever you want to write a comment, check that you cannot do it in code
//   - Use explanatory variables

// %% tags=["keep", "subslide"] 
/**
 * This method adds two numbers and returns the result.
 * 
 * @param a The first number to add.
 * @param b The second number to add.
 * @return The result of adding `a` and `b`.
 */
 public int add(int a, int b) {
    return a + b;
 }


// %% tags=["keep", "subslide"]
int daysOfWork = 4

// %% tags=["keep"]
// Multiply the seconds in a day times the days of work.
int durationInSeconds = 60 * 60 * 24 * daysOfWork

// %% tags=["keep"]
int SECONDS_PER_DAY = 60 * 60 * 24;
int durationInSeconds = SECONDS_PER_DAY * daysOfWork;


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Wie Kommentare scheitern
//
// - Kommentare sind schwer zu pflegen
// - Deshalb lügen sie oft
// - Sie werden nicht geändert, wenn der Code aktualisiert wird
// - Sie werden nicht verschoben, wenn der Code verschoben wird

// %% [markdown] lang="en" tags=["subslide"]
//
// ## How comments fail
//
// - Comments are difficult to maintain
// - Therefore, they often lie
// - They don’t get changed when code gets updated
// - They don’t get moved when code gets moved

// %%
// Check to see if the employee is eligible for full benefits
// if ((employee.flags & HOURLY_FLAG) != 0 && employee.age > 65) {
//  ...
// }
//
// versus...
//
//
// if (employee.isEligibleForFullBenefits()){
// ...
// }

// %% [markdown] lang="de" tags=["subslide"]
//
// ## PEP-8 Regeln für Kommentare
//
// Befolge die [PEP-8](https://peps.python.org/pep-0008///comments) Richtlinien
// für Kommentare:
//
// - Halte die Kommentare aktuell, wenn sich der Code ändert.
// - Kommentare sollten aus vollständigen Sätzen bestehen.
//   - Das erste Wort wird großgeschrieben, es sei denn, es ist ein Bezeichner.
//   - Bezeichner sollten niemals geändert werden
//   - Verwenden Sie in mehrsätzigen Kommentaren zwei Leerzeichen nach einem
//     satzabschließenden Punkt.
// - Die Kommentare müssen klar und leicht verständlich sein.
// - Python-Coder aus nicht englischsprachigen Ländern: Bitte schreiben Sie Ihre
//   Kommentare auf Englisch, es sei denn, Sie sind 120% sicher, dass der Code
//   niemals von Leuten gelesen wird, die Ihre Sprache nicht sprechen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## PEP-8 Guidelines for Comments
//
// Follow [PEP-8](https://peps.python.org/pep-0008///comments) guidelines for
// comments:
//
// - Keep comments up-to-date when the code changes
// - Comments should be complete sentences.
//   - First word is capitalized, unless it is an identifier
//   - Identifiers should never be altered
//   - Use two spaces after a sentence-ending period in multi-sentence comments
// - Ensure that comments are clear and easily understandable
// - Python coders from non-English speaking countries: please write your
//   comments in English, unless you are 120% sure that the code will never be
//   read by people who don’t speak your language.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Gute Kommentare
//
// Kommentare sind gut, wenn sie
//
// - aus juristischen Gründen notwendig sind
// - Konzepte erklären, die nicht im Code ausgedrückt werden können
// - den Zweck des Codes erklären
// - Code erklären, den man nicht bereinigen kann (z.B. eine veröffentlichte
//   Schnittstelle)
// - veröffentlichte Schnittstellen dokumentieren (z.B. mit Doxygen)
// - `TODO`-Kommentare sind (wenn sie sparsam verwendet werden)
// - wichtige Aspekte betonen ("Dies ist sehr wichtig, weil...")

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Good Comments
//
// Comments are good if they
//
// - are legally required
// - explain concepts that cannot be expressed in code
// - explain the intent of the code
// - explain code that you cannot clean up (e.g., a published interface)
// - document published interfaces (e.g., doxygen)
// - are `TODO`` comments (if used sparingly)
// - are used for amplification ("This is very important, because...")

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Schlechte Kommentare
//
// - Unklare Kommentare (Nuscheln)
//
// Angenommen, der folgende Kommentar ist tatsächlich richtig. Was sagt er uns?

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Bad Comments
//
// - Unclear comments (mumbling)
//
// Suppose that the following comment is in fact correct. What does it tell us?

// %% tags=["keep"]
try {
    FileReader fileReader = new FileReader("my-app.cfg");
} catch (FileNotFoundException e) {
    // Somebody else has already loaded the defaults.
}


// %% [markdown] lang="de" tags=["subslide"]
//
// - Redundante Kommentare (dauern länger als der Code zu lesen, ohne klarer zu
//   sein)

// %% [markdown] lang="en" tags=["subslide"]
//
// - Redundant comments (takes longer to read than the code without being clearer)

// %% tags=["keep"]
void readAndApplyConfiguration(BufferedReader file) {
}


// %% tags=["keep"]
// Read the configuration from file `my-app.cfg`. The file has to be readable and
// in UTF-8 encoding. If the file cannot be found we simply ignore the attempt.
// If the file is indeed found, we read it and apply the configuration to the
// system.
try {
    // Read the configuration from file `my-app.cfg`. The file has to be readable and
    // in UTF-8 encoding. 
    FileReader fileReader = new FileReader("my-app.cfg");
    BufferedReader reader = new BufferedReader(fileReader);
    
    // If the file is indeed found, we read it and apply the configuration to the system.
    readAndApplyConfiguration(reader);
    reader.close();
} catch (FileNotFoundException e) {
    // If the file cannot be found we simply ignore the attempt.
} catch (IOException e) {
    // Handle the exception.
}


// %% [markdown] lang="de" tags=["subslide"]
//
// - Irreführende Kommentare

// %% [markdown] lang="en" tags=["subslide"]
//
// - Misleading comments

// %% [markdown] lang="de" tags=["subslide"]
//
// - Vorgeschriebene Kommentare (durch Style-Guides, nicht durch Gesetze)
// - Journal-Kommentare (Geschichte der Datei)

// %% [markdown] lang="en" tags=["subslide"]
//
// - Mandated comments (by coding guidelines, not law)
// - Journal comments (history of the file)


// %% tags=["keep"]
// file: widget.java
//
// Changes made to the file:
//
// 2022-08-10: Added a frobnicator as proposed by Jane
// 2022-08-11: Twiddled the frobnicator's parameters
// 2022-08-12: Further tweaks to the frobnicator settings
// 2022-08-13: Added flux compensation to the frobnicator
// 2022-08-14: Improved flux compensation
// 2022-09-03: Revisited flux compensation after discussion with Joe
//
public class Frobnicator {
    
}

// %% [markdown] lang="de" tags=["subslide"]
// -  HTML Kommentare

// %% tags=["keep"]
/**
* <p><strong>Important:</strong></p>
* <ul>
*   <li>
*     Don&//39;t use <code>frobnicator_1</code> to tweak
*     <code>flux_compensator_2</code> because they are not
*     coherent!
*   </li>
*   <li>
*     Make sure that <code>fuzzbox_2</code> is turned to
*     at least 11 before plugging in the guitar.
*   </li>
* </ul>
*/


// %% [markdown] lang="de" tags=["subslide"]
//
// - Inhaltsfreie Kommentare (Noise comments)

// %% [markdown] lang="en" tags=["subslide"]
//
// - Noise comments

// %% tags=["keep"]
class FluxCompensator {
    // The constructor of the flux compensator.
    public FluxCompensator() {
        // Implementation goes here
    }
}

// %% tags=["keep"]
// Hourly wage in US$
final double HOURLY_WAGE_IN_USD = 80;


// %% [markdown] lang="de" tags=["subslide"]
//
// - Positions-Markierungen

// %% [markdown] lang="en" tags=["subslide"]
//
// - Position Markers


// %% tags=["keep"]
class MyVeryLargeClass {
    ##############///
    // Initialization Methods
    ##############///
    void init() {
    }
    
    void initInAnotherWay() {
    }
    
    ##############///
    // Computations
    ##############///
    void computeThis() {
    }

    void computeThat() {
    }
    
    ##############///
    // State Updates
    ##############///
    void setSomeState(int x) {
    }
}


// %% [markdown] lang="de" tags=["subslide"]
//
// - Zuschreibungen und Namensnennungen

// %% [markdown] lang="en" tags=["subslide"]
//
// - Attributions and bylines

// %% tags=["keep"]
// Added by Jack <jack@example.org> on 2018-03-12
int someFunction(int x, int y) {
    return x + y;
}


// %% [markdown] lang="de" tags=["subslide"]
//
// - Auskommentierter Code
//   - Neigt dazu, nie gelöscht zu werden
//   - Unklar, warum er da ist: sollte er gelöscht oder wieder einkommentiert
//     werden?
//   - Sollte lieber gelöscht und bei Bedarf aus dem Versionskontrollsystem
//     wiederhergestellt werden

// %% [markdown] lang="en" tags=["subslide"]
//
// - Commented-out code
//   - Has a tendency to never get deleted
//   - Unclear why it is there: was it meant to be deleted or commented back in?
//   - Rely on the source control system and delete the code

// %% tags=["keep"]
// int someFunction(int x, int y) {
//    return x + y;
//}

// %% tags=["keep"]
int someOtherFunction(int x, int y) {
    // int z = x + y;
    // return z;
    return 123;
}


// %% [markdown] lang="de" tags=["subslide"]
//
// - Nichtlokale Information

// %% [markdown] lang="en" tags=["subslide"]
//
// - Non-local information

// %% tags=["keep"]
// This is set to its correct value by `frobFoo()` in file `frobnicator.java`.
int foo = 123;

// %% [markdown] lang="de" tags=["subslide"]
//
// - Zu viel Information

// %% [markdown] lang="en" tags=["subslide"]
//
// - Too much information

// %% tags=["keep"]

/* Implement protocol handling according to ABC Standard 212-3.

 This was first proposed by Steve in a meeting in 2013, but at the time we had
 no compatible implementation of the support libraries available. We therefore
 shelved the discussion until Tina brought the topic up in the famous all-hands
 meeting of October 2019. There were some initial problems, but we finally
 succeeded in getting a running implementation working in 2021. This contains a
 bug that is still present in the current code base that causes the system to
 crash when talking to a client that implements variant /4 of the protocol.
 Finally, in early 2022 we also adapted this implementation for the XYZ device
 series.
 */

// %% [markdown] lang="de" tags=["subslide"]
//
// - Unklarer Bezug zum Code

// %% [markdown] lang="en" tags=["subslide"]
//
// - Unobvious connection to the code

// %% tags=["keep"]
// Adjust for target endianness and buffer size
int foo = Math.max((foo + 7) * 2, 256)

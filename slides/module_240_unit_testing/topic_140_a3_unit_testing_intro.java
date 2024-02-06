// j2 from 'macros.j2' import header
// {{ header("Einführung ins Unit Testing", "Introduction to Unit Testing") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Was ist ein Unit Test?
//
// - Test einer (Teil-)Funktionalität
// - Genauer: Test eines Szenarios für die Ausführung einer Teilfunktionalität

// %% [markdown] lang="en" tags=["subslide"]
//
// ## What is a unit test?
//
// - Test of a (partial) functionality
// - More precisely: test of a scenario for the execution of a partial functionality

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Was können Unit Tests testen?
//
// - Funktionen
// - Methoden
// - (Klassen)
// - (Einfache Komponenten)

// %% [markdown] lang="en" tags=["subslide"]
//
// - Functions
// - Methods
// - (Classes)
// - (Simple Components)

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Eigenschaften von Unit-Tests (V1)
//
// - Feingranular
//   - z.B. Test eines Methodenaufrufs mit gewissen Parametern
// - Keine Interaktion zwischen Tests
//   - Isolierte Testfälle
// - Keine Interaktion zwischen getesteter Einheit und dem Rest des Systems
//   - Externe Subsysteme werden oft durch einfache Simulationen ersetzt (Mocks)

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Properties of unit tests (V1)
//
// - Fine-grained
//   - e.g. testing a method call with certain parameters
// - No interaction between tests
//   - Isolated test cases
// - No interaction between the tested unit and the rest of the system
//   - External subsystems are often replaced by simple simulations (mocks)


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Gründe für das Unit-Testen
//
// - Frühes Finden von Fehlern
// - Einfachere Lokalisierung von Fehlern
// - "Sicherheitsnetz" für Programmierer
//   - Fungieren auch als Regressionstests
//   - Fehler werden (hoffentlich) gefunden, bevor sie das Gesamtsystem beeinflussen
// - Unterstützen Wartbarkeit und Erweiterbarkeit von Code
// - Erleichtern Refactoring, da viele dabei auftretende Fehler durch Unit-Tests
//   gefunden werden
// - Stellen sicher, dass Erweiterungen die existierende Funktionalität nicht
//   beeinträchtigen
// - Dienen als zusätzliche Dokumentation
// - Können aber Architekturdiagramme etc. nicht ersetzen

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Reasons for unit testing
// - Finding bugs early
// - Easier to locate bugs
// - "Safety net" for programmers
//   - Also act as regression tests
//   - Bugs are (hopefully) found before they affect the overall system
// - Support maintainability and extensibility of code
// - Facilitate refactoring, since many errors are found by unit testing
// - Ensure that extensions do not affect existing functionality
// - Serve as additional documentation
// - Cannot replace architecture diagrams etc

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Eigenschaften von guten Unit-Tests (V2)
//
// Unit-Tests sollen
// - automatisiert sein
// - selbsttestend sein
// - einzelne Programmelemente isoliert testen
// - zu jedem Zeitpunkt erfolgreich ausführbar sein
// - nicht viel Zeit zur Ausführung benötigen
// - für alle Systembestandteile geschrieben werden
// - alle wichtigen Zustände jedes getesteten Elements abdecken
//
// Später: detailliertere Richtlinien - FIRST, Right-BICEP, CORRECT

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Eigenschaften von guten Unit-Tests (V2)
//
// Unit tests should
// - be automated
// - be self-testing
// - test individual program elements in isolation
// - be executable successfully at any time
// - not require much time to run
// - be written for all system components
// - cover all important states of each tested element
//
// Später: detailliertere Richtlinien - FIRST, Right-BICEP, CORRECT

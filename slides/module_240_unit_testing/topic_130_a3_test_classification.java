// j2 from 'macros.j2' import header
// {{ header("Klassifizierung von Tests", "Classification of Tests") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Nach Größe des Systems under Test (SuT)
// - Unit Tests:
//   - Testen einzelne Methoden oder Klassen,
//   - Typischerweise isoliert vom Rest des Systems
// - Komponententests:
//   - Testen einzelne Komponenten in Isolation
// - Integrations-/Systemtests:
//   - Testen das komplette System.


// %% [markdown] lang="en" tags=["subslide"]
//
// ##// By size of the system under test (SuT)
//
// - Unit tests:
//   - Test individual methods or classes,
//   - Typically isolated from the rest of the system
// - Component tests:
//   - Test individual components in isolation
// - Integration/system tests:
//   - Test the complete system.

// %% [markdown] lang="de" tags=["subslide"]
//
// ##// Nach Zielen
// - Validierungstesten ( „validation testing“):
//   versucht sicherzustellen, dass das System seine intendierte Funktion korrekt erfüllt
// - Defekttesten ( „defect testing“):
//   versucht Fehler (eigentlich Fehlerzustände) zu finden
//   - selten betrachtete Ausführungspfade oder Use Cases
//   - Randbedingungen
// - Die Übergänge zwischen den beiden Klassen sind fließend

// %% [markdown] lang="en" tags=["subslide"]
//
// ##// By objectives
// - Validation testing:
//   tries to ensure that the system fulfills its intended function correctly
// - Defect testing: tries to find errors (actually error states)
//   - rarely considered execution paths or use cases
//   - boundary conditions
// - The transitions between the two classes are fluid

// %% [markdown] lang="de" tags=["subslide"]
//
// ##// Nach Zeitpunkt
// - Entwicklungstests:
//   - Das System wird während der Entwicklungsphase getestet
//   - Werden i.A. von den Entwicklern selber ausgeführt
// - Release Tests:
//   - Eine vollständige Version des Systems wird getestet bevor es an
//     Kunden übergeben wird
//   - Werden oft von einem speziellen Test-Team ausgeführt
// - Endbenutzertests:
//   - Benutzer oder potenzielle Benutzer testen das System, oft in ihrer eigenen
//     Systemumgebung
//   - Akzeptanztests sind eine Form der Endbenutzertests

// %% [markdown] lang="en" tags=["subslide"]
//
// ##// By time
//
// - Development tests:
//   - The system is tested during the development phase
//   - Are generally carried out by the developers themselves
// - Release tests:
//   - A complete version of the system is tested before it is handed over to customers
//   - Often performed by a dedicated testing team
// - End-user testing:
//   - Users or potential users test the system, often in their own system environment.
//   - Acceptance testing is a form of end-user testing


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Andere Bezeichnungen/Testarten
//
// - Regressionstests:
//   - Tests, die bereits behobene Fehler testen.
//   - Sollen sicherstellen, dass diese Fehler nicht erneut ins System gelangen können.
//   - Regressionstests können Unit-, Komponenten- oder Integrations/Systemtests sein
// - Performanztests:
//   - Tests, die das Verhalten des Systems unter Belastung überprüfen
//     (Lasttests, Stresstests, Spike-Tests, ...)
// - Benutzbarkeitstests (Usability Tests):
//   - Tests, die überprüfen, wie gut Benutzer mit dem System zurechtkommen

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Related topics
//
// - Regression tests:
//   - Tests for bugs that have already been fixed.
//   - Should ensure that these errors cannot re-enter the system.
//   - Regression tests can be unit, component or integration system tests
// - Performance tests:
//   - Tests that check the behavior of the system under load
//     (load tests, stress tests, spike tests, ...)
// - Usability tests (usability tests):
//   - Tests that check , how well users get along with the system

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Teststrategien
// - White Box vs. Black Box
// - Top Down vs. Bottom Up

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Test strategies
// - White Box vs. Black Box
// - Top Down vs. Bottom Up

// %% [markdown] lang="de" tags=["subslide"]
//
// ## White-Box Tests
//
// - Auch Glass-Box oder strukturelles Testen genannt
// - Tester haben Zugriff auf Design und Implementierung des Systems und können
//   - die Design-Dokumente lesen
//   - den Code inspizieren
//   um potentielle Fehler zu finden
// - Wenn Programmierer Tests für ihren eigenen Code schreiben handelt es sich
//   immer um White-Box Tests

// %% [markdown] lang="en" tags=["subslide"]
//
// ## White-Box Tests
//
// - Also called glass box or structural testing
// - Testers have access to the design and implementation of the system and can
//   - Read the design docs
//   - Inspect the code
//   to find potential bugs
// - When programmers write tests for their own code, they are always White -Box tests

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Black-Box Tests
// - Tester können das Systemverhalten (z.B. Ausgaben) für von ihnen gewählte Eingaben
//   überprüfen
// - Tester haben keinen Zugriff auf Systeminterna
// - (Klassisches) Fuzzing ist eine automatisierte Form des Black-Box Testens
// - Haben Tester Zugriff auf die Design-Dokumente aber nicht den Programmcode
//   spricht man manchmal von Gray-Box-Testing


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Black-Box Tests
// - Testers can check the system behavior (e.g. outputs) for inputs they choose
// - Testers have no access to system internals
// - (Classic) fuzzing is an automated form of black-box testing
// - Testers have access to the design documents but not the program code is sometimes
//   called gray box testing

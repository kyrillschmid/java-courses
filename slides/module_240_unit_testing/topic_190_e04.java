// j2 from 'macros.j2' import header
// {{ header("Junit5 Assumptions", "Junit5 Assumptions") }}

// %% [markdown] lang="de" tags=["slide"]
//
// Manchmal würde ein Test fehlschlagen aufgrund externer Umstände außerhalb unserer Kontrolle
// - Abhängig von Zeit-/Datum
// - Plattform auf der der Test ausgeführt wird
// Plattform auf der der Test ausgeführt wird 
// In solchen Fällen, wollen wir verhindern, dass unsere Tests ausgeführt werden und fehlschlagen
// ## Junit5 Assumptions:
// - Prüfe Vorbedingungen, die erfüllt sein müssen, wenn wir Test ausführen
// - Test für den Bedingungen nicht erfüllt sind, wird nicht ausgeführt


// %% [markdown] lang="en" tags=["slide"]
//
// // Sometimes a test would fail due to external circumstances beyond our control
// - Depending on time/date
// - Platform on which the test is being executed
// In such cases, we want to prevent our tests from being executed and failing
// ## JUnit 5 Assumptions:
// - Check preconditions that must be met when we run a test
// - Test that do not meet the conditions are not executed


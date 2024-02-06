// j2 from 'macros.j2' import header
// {{ header("Workshop Refactoring: Teil 4 - Finale Schritte", "Workshop Refactoring: Part 4 - Final Steps") }}

// %% [markdown] lang="de" tags=["slide"]
//
// // Workshop: htmlgen
// ## Teil 4: Finale Schritte
// - Eliminierung von geschachtelten `if`-Statements
// - StringBuilder Code entfernen

// %% [markdown] lang="en" tags=["slide"]
//
// // Workshop: htmlgen
// ## Part 4: Final Steps
// - Eliminate nested `if` statements
// - Remove StringBuilder code


// %% [markdown] lang="de" tags=["slide"]
//
// ## Eliminierung von geschachtelten `if`-Statements
// - Wir wollen nun das erste `if`-Statement eliminieren

// %% [markdown] lang="en" tags=["slide"]
//
// ## Eliminate nested `if` statements
// - We now want to eliminate the first `if` statement

// %% 
if(includeSuiteSetup)
    includeIfInherited("setup", SuiteResponder.SUITE_SETUP_NAME);
includeIfInherited("setup", "SetUp");


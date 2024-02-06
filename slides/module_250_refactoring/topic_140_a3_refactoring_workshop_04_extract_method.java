// j2 from 'macros.j2' import header
// {{ header("Workshop Refactoring: Teil 3b - Extract Method", "Workshop Refactoring: Part 3b -  Extract Method") }}

// %% [markdown] lang="de" tags=["slide"]
//
// // Workshop: htmlgen
// ## Teil 3: Extract Method
// - Im letzten Teil haben Sie gesehen, wie man eine Methode extrahiert
// - Wir haben die Methode `includePage` extrahiert
// - Dazu wurde der String parametrisiert mit dem Parameter `mode`

// %% [markdown] lang="en" tags=["slide"]
//
// // Workshop: htmlgen
// ## Part 3: Extract Method
// - In the last part you saw how to extract a method
// - We extracted the method `includePage`
// - For this the string was parameterized with the parameter `mode`


// %% [markdown] lang="de" tags=["slide"]
// - Es gibt noch einen weiteren Block, der sich wiederholt

// %% [markdown] lang="en" tags=["slide"]
// - There is another block that is repeated

// %% 
WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(SuiteResponder.SUITE_SETUP_NAME, wikiPage);
if (suiteSetup != null) {
    includePage(suiteSetup, "-setup");


// %% [markdown] lang="de"
// - Eliminieren Sie die Unterschiede nach dem gleichen Schema wie zuvor
// - Erzeugen Sie eine Variable für den SetupName
// - Extrahieren Sie eine Methode `includeIfInherited`


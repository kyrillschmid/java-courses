// j2 from 'macros.j2' import header
// {{ header("Workshop Refactoring: Teil 3a - Extract Method", "Workshop Refactoring: Part 3a -  Extract Method") }}

// %% [markdown] lang="de" tags=["slide"]
//
// ## Refactoring Pattern Extract Method
// - Die Funktion `invoke` ist immer noch zu lang
// - Wir wollen sie in kleinere Methoden aufteilen
// - Wir erkennen, dass sich einige Blöcke wiederholen

// %% [markdown] lang="en" tags=["slide"]
//
// ## Refactoring Pattern Extract Method
// - The function `invoke` is still too long
// - We want to split it into smaller methods
// - We recognize that some blocks are repeated

// %% [markdown] lang="de" tags=["slide"]
// - Folgender Block kommt in vier leicht unterschiedlichen Varianten vor:

// %% [markdown] lang="en" tags=["slide"]
// - The following block occurs in four slightly different variants:

// %% 
WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteSetup);
String pagePathName = PathParser.render(pagePath);
buffer.append("!include -setup . ").append(pagePathName).append("\n");

// %% 
WikiPagePath tearDownPath = wikiPage.getPageCrawler().getFullPath(teardown);
String tearDownPathName = PathParser.render(tearDownPath);
buffer.append("!include -teardown . ").append(tearDownPathName).append("\n");


// %% [markdown] lang="de" tags=["slide"]
// - Um daraus eine Methode zu extrahieren, müssen wir die Unterschiede eliminieren
// - Wir können die Unterschiede eliminieren, indem wir den String parametrisieren
// - Wir ersetzen "setup" und "teardown" durch den Parameter `mode`

// %% [markdown] lang="en" tags=["slide"]
// - To extract a method from this, we have to eliminate the differences
// - We can eliminate the differences by parameterizing the string
// - We replace "setup" and "teardown" with the parameter `mode`


// %% [markdown] lang="de" tags=["slide"]
// - Anschließend können wir die Methode extrahieren
// - Wir nennen sie `includePage`
// - IntelliJ IDEA: Refactor -> Extract -> Method
// - Eclipse: Refactor -> Extract Method
// - Die IDE fragt uns ob wir alle Vorkommen ersetzen wollen

// %% [markdown] lang="en" tags=["slide"]
// - Then we can extract the method
// - We call it `includePage`
// - IntelliJ IDEA: Refactor -> Extract -> Method
// - Eclipse: Refactor -> Extract Method
// - The IDE asks us if we want to replace all occurrences

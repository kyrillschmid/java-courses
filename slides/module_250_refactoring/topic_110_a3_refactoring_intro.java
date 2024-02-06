// j2 from 'macros.j2' import header
// {{ header("Einführung ins Refactoring", "Introduction to Refactoring") }}

// %% [markdown] lang="de" tags=["slide"]
//
// // Einführung ins Refactoring

// %% [markdown] lang="en" tags=["slide"]
//
// //
// Refactoring
//- "Behavior-preserving transformation" (Joshua Kerievsky)
//- "A change made to the internal structure of software to make it easier to understand and cheaper to modify without changing its observable behavior" (Martin Fowler)

// %% [markdown] lang="de" tags=["subslide"]
// ## Refactoring-Prozess besteht aus:
//- Eliminierung von duplizierten Code
//- Vereinfachung komplexer Logik
//- Verbesserung des Designs

// %% [markdown] lang="de" tags=["subslide"]
// Um sicher Refactoren zu können müssen wir:
//- Tests laufen lassen
//- kleine Schritte machen (auch große Refactorings erfolgen in kleinen Schritten)
//- kontinuierliches Refactoring

// %% [markdown] lang="de" tags=["subslide"]
##// Refactoring Pattern
// *Every pattern describes a problem which occurs over and over again in our environment, and then describes the core of the solution to that problem, in such a way that you can use this solution a million times over, without ever doing it the same way twice.*
// -- <cite>Alexander, Christopher. A Pattern Language.</cite>
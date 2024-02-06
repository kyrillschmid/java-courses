// j2 from 'macros.j2' import header
// {{ header("Junit5 Dynamische Tests", "Junit5 Dynamic Tests") }}

// %% [markdown] lang="de" tags=["slide"]
//
// Junit5 ermöglicht es dynamisch Tests zu erstellen
// Hilfreich wenn 
// - Test-Fälle datengetrieben erzeugt werden sollen 
// - Konditionale Tests bei denen die Bedingungen zur Compile-Zeit noch nicht bekannt sind
// - Dynamische Tests werden mit der @TestFactory-Annotation erzeugt
// - Methode gibt Stream zurück (auch möglich Collection, Iterable oder Iterator)
// - Stream enthält DynamicNode-Instanzen, die ausgeführt werden


// %% [markdown] lang="en" tags=["slide"]
//
// JUnit 5 allows creating tests dynamically
// Useful when 
// - Test cases should be generated in a data-driven way
// - Conditional tests where the conditions are not known at compile time
// - Dynamic tests are created with the @TestFactory annotation
// - Method returns a Stream (also possible Collection, Iterable, or Iterator)
// - Stream contains DynamicNode instances that are executed



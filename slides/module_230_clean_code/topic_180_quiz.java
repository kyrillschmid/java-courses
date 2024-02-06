// j2 from 'macros.j2' import header
// {{ header("Clean Code: Quiz", "Clean Code: Quiz") }}

// %% [markdown] lang="de" tags=["slide"]
// Frage 1: Welche Aussage trifft auf die Verwendung von Variablennamen wie "hp", "aix" und "sco" zu?
// - A: Sie sind gute Variablennamen, da sie gut abgekürzt sind.
// - B: Sie sind akzeptable Variablennamen, solange der Kontext klar ist.
// - C: Sie sind schlechte Variablennamen, da sie irreführend sein können
// - D: Sie sind gute Variablennamen, da sie sich auf Unix-Plattformen beziehen.

// %%
// Mögliche Antwort: C
// Erklärung: Die Verwendung von Variablennamen wie "hp", "aix" und "sco" wird nicht empfohlen,
//  da sie die Bedeutung des Codes verschleiern können. Obwohl "hp" möglicherweise eine scheinbar
//  gute Abkürzung für "Hypotenuse" ist, könnte sie irreführend sein, da sie auch ein gebräuchlicher
//  Name für eine Unix-Plattform ist. Es ist wichtig, Variablennamen zu wählen, die klar und 
// aussagekräftig sind, um die Lesbarkeit und Verständlichkeit des Codes zu verbessern.

// %% [markdown] lang="de" tags=["slide"]
// Frage 2: Warum wird empfohlen, aussprechbare Namen für Variablen zu verwenden?
// - A: Aussprechbare Namen erleichtern das Debugging von Code.
// - B: Aussprechbare Namen verbessern die Lesbarkeit und Verständlichkeit des Codes.
// - C: Aussprechbare Namen sind kürzer und sparen Speicherplatz.
// - D: Aussprechbare Namen verhindern Missverständnisse bei der Teamkommunikation.

// %% 
// Richtige Antworten: B und D (möglicherweise A)
// Erklärung: Es wird empfohlen, aussprechbare Namen für Variablen zu verwenden,
// da sie die Lesbarkeit und Verständlichkeit des Codes verbessern. Menschen sind 
// darin geübt, Wörter auszusprechen und zu verstehen, da ein großer Teil unseres 
// Gehirns auf die Verarbeitung von gesprochener Sprache spezialisiert ist. 
// Wenn ein Variablenname nicht ausgesprochen werden kann, wird es schwierig, 
// darüber zu diskutieren und ihn zu erklären. Durch die Verwendung aussprechbarer 
// Namen wird die soziale Interaktion beim Programmieren erleichtert und Missverständnisse werden reduziert. 
// Es ist wichtig zu bedenken, dass Programmieren eine soziale Aktivität ist, 
// bei der eine klare und verständliche Kommunikation von großer Bedeutung ist.

// %% [markdown] lang="de" tags=["slide"]
// Frage 3: Was ist das Problem mit Single-Letter Namen und numerischen Konstanten?
// - A: Kurze Namen sind schwieriger zu finden und können zu Bugs führen.
// - B: Eindeutige Namen erleichtern das Auffinden von Variablen im Code.
// - C: Numerische Konstanten sind schwer zu finden, wenn sie Teil anderer Ausdrücke sind.
// - D: Der Buchstabe "e" sollte vermieden werden, da er in vielen englischen Wörtern vorkommt.

// %% 
// Richtige Antworten: A, B, C, D
// Erklärung: Es wird empfohlen, suchbare Namen für Variablen zu verwenden, 
// da eindeutige Namen das Auffinden von Variablen im Code erleichtern.
// Einzelbuchstaben-Namen und numerische Konstanten sind schwierig zu lokalisieren, 
// insbesondere wenn sie Teil anderer Ausdrücke sind. Bei der Suche nach einem bestimmten
//  Wert können die Ergebnisse ungenau sein und möglicherweise andere Vorkommen des 
// Werts übersehen werden. Wenn ein Variablenname beispielsweise "e" ist, ist dies 
// problematisch, da "e" der häufigste Buchstabe in der englischen Sprache ist und in 
// edem Textabschnitt in jedem Programm vorkommen kann. In diesem Zusammenhang sind 
// längere und eindeutige Namen besser als kurze Namen, und ein suchbarer Name ist 
// einer numerischen Konstante im Code vorzuziehen.

// %% [markdown] lang="de" tags=["slide"]
// Frage 4: Warum wird empfohlen, Encodings in Variablennamen zu vermeiden?
//
// - A: Encodings machen den Code unlesbar und schwer zu verstehen.
// - B: Encodings erfordern zusätzlichen Aufwand bei der Entschlüsselung der Namen.
// - C: Encodings führen zu unnötiger mentaler Belastung beim Problemlösen.
// - D: Encodings sind schwierig auszusprechen und können leicht falsch eingegeben werden.

// %% 
// Richtige Antworten: A, B (evtl C und D)
// Erklärung: Es wird empfohlen, Encodings in Variablennamen zu vermeiden,
//  da sie zusätzlichen Aufwand bei der Entschlüsselung der Namen erfordern. 
// Das Einbetten von Informationen über den Typ oder den Anwendungsbereich in
// Namen führt zu einer erhöhten Komplexität und Erschwernis beim Lesen und Verstehen des Codes. 
// Es wäre nicht vernünftig, von jedem neuen Mitarbeiter zu verlangen, dass er neben dem 
// Erlernen des (in der Regel umfangreichen) Codebestands noch eine weitere "Codierungssprache" erlernt.
//  Encodings sind selten aussprechbar und leicht fehleranfällig bei der Eingabe. 
// In der Vergangenheit wurden Encodings in Programmiersprachen wie Fortran und frühen Versionen von
//  BASIC aus Platzgründen verwendet, jedoch wird heutzutage empfohlen, auf Encodings zu verzichten und 
// stattdessen aussagekräftige und verständliche Namen zu verwenden.



// %% [markdown] lang="de" tags=["slide"]
// Frage 5: Warum wird empfohlen, Lösungsbereichsnamen (Computer-Science-Terms) in Variablennamen zu verwenden?

// - A: Lösungsbereichsnamen erleichtern die Zusammenarbeit mit Kunden und verbessern die Kommunikation.
// - B: Lösungsbereichsnamen machen den Code für Programmierer verständlicher und vermeiden Missverständnisse.
// - C: Lösungsbereichsnamen verhindern Namenskonflikte und erhöhen die Lesbarkeit des Codes.
// - D: Lösungsbereichsnamen verbessern die Performance des Codes und die Effizienz der Algorithmen.



// %% 
// Richtige Antwort: B
// Erklärung: Es wird empfohlen, Lösungsbereichsnamen in Variablennamen zu verwenden, da sie den Code für Programmierer 
// verständlicher machen und Missverständnisse vermeiden. Programmierer, die den Code lesen, sind mit Fachbegriffen der 
// Informatik, Algorithmusnamen, Musternamen, mathematischen Begriffen usw. vertraut. 
// Daher ist es sinnvoll, solche technischen Begriffe in den Variablennamen zu verwenden. 
// Wenn wir ausschließlich Namen aus dem Problemumfeld verwenden, müssten unsere Kollegen ständig zum 
// Kunden rennen und nachfragen, was jeder Name bedeutet, obwohl sie das Konzept bereits 
// unter einem anderen Namen kennen. Die Verwendung von Lösungsbereichsnamen erleichtert 
// die Kommunikation und das Verständnis des Codes zwischen den Programmierern.
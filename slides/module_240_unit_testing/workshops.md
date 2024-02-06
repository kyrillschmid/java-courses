## Workshops

### Workshop 1 (Calculator)
1. Fügen Sie der Klasse Calculator zwei weitere Methoden zum Dividieren und Multiplizieren zweier Zahlen (double) hinzu. 
2. Ergänzen Sie die Test-Methoden in der Test Klasse und lassen Sie alle Tests laufen!
    
### Workshop 2 (Calculator)
1. Ändern Sie den Anzeige-Namen der divide-Methode und lassen Sie sich das Ergebnis anzeigen, indem Sie die Tests ausführen!
2. Setzen Sie den Test für die Methode divide mit einer geeignete Annotation aus. 

### Bonus-Workshop (Temp-Dir Test)
1. Sie wollen eine Testklasse erstellen, die einmal ein Temp-Directory anlegt, das dann für alle Test-Methoden in der Klasse verwendet werden kann. Achten Sie darauf, das Temp-Directory nach allen Tests wieder zu löschen.

### Workshop 3 (StringFormatter)
1. Fügen Sie der Klasse StringFormatter eine Methode **reverse** hinzu, die einen gegebenen String umdreht (package assertions).
2. Implementieren Sie eine Test-Methode für reverse und lassen Sie alle Tests laufen.

### Workshop 4 (DiceGame)
1. Ergänzen Sie in der Klasse DiceGameTest (package assumptions) zwei Testmethoden, die testen, ob der Wechsel der Spieler fehlerfrei funktioniert. Verändern Sie die Implementierung der Klasse DiceGame nicht.
2. Ergänzen Sie in der Klasse DiceGameTest eine weitere Testmethode, die testet, ob die Variable **currentPlayer** nach Beendigung eines Spiels korrekt gesetzt ist (sollte gleich der Variable **winner** sein). Verändern Sie die Implementierung der Klasse DiceGame nicht.
3. Ändern Sie nun die Klasse DiceGame folgendermaßen um, so dass überall dort wo ein Random-Number-Generator benötigt wird, ein Objekt vom Typ Random übergeben werden kann (Konstruktor und Methoden). Setzen Sie nun in den Test-Methoden einen expliziten Seed, so dass die Assumptions nicht mehr benötigt werden.

### Workshop 5 (Calculator-Parameterized)
1. Ergänzen Sie einen parametrisierten Test für die divide-Methode, der als Input-Source eine Methode bekommt (@MethodSource) genau wie in der Test-Methode für die square-Methode.

### Bonus-Workshop (Cipher)
1. Ergänzen Sie eine parametrisierte Test-Methode für die decode-Methode in der Klasse Cipher (package strings). 

### Bonus-Workshop (JSON)
1. Es soll eine Liste an User-Objekten aus einem JSON-File eingelesen werden. Aus jedem User-Objekt soll ein String erstellt werden (siehe Klasse User). Ergänzen Sie in der Jlasse UserParameterizedTestJson eine statische Methode, die das JSON ausliest und die User sowie den erwarteten User-String an die Methode testToString übergibt.

### Workshop 6 (Dynamic Tests)
1. Ergänzen Sie in der Klasse Calculator eine Methode zum Quadrierern einer Zahl!
2. Fügen Sie in der Klasse TestCalculatorDynamic (package dynamictests) eine weitere Methode hinzu, die dynamisch Tests erstellt zum Testen der Methode square mit fünf Werten. Orientierien Sie sich an der testAddDynamicMethode Methode, die gegeben ist.

// j2 from 'macros.j2' import header
// {{ header("Inline Variable", "Inline Variable") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Das Inline Variable-Muster besteht darin, eine lokale Variable zu entfernen und ihren Wert direkt in den entsprechenden Ausdrücken zu verwenden. Dies ist hilfreich, wenn der Variablenname keine zusätzliche Klarheit bietet oder die Variable eine Refaktorisierung des umgebenden Codes behindert.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The inline variable pattern consists of removing a local variable and using its value directly in the corresponding expressions. This is useful when the variable name does not provide additional clarity or the variable interferes with refactoring the surrounding code.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Variablen bieten Namen für Ausdrücke innerhalb einer Funktion und sind normalerweise nützlich. Manchmal kommuniziert der Name jedoch nicht mehr als der Ausdruck selbst. In anderen Fällen kann eine Variable die Refaktorisierung des benachbarten Codes behindern. In diesen Fällen kann es nützlich sein, die Variable in den Ausdruck zu integrieren.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// Variables provide names for expressions within a function and are usually useful. However, sometimes the name communicates no more than the expression itself. In other cases, a variable may interfere with the refactoring of the adjacent code. In these cases, it may be useful to include the variable in the expression.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vorgehen
// - Überprüfen Sie, ob die rechte Seite der Zuweisung frei von Nebeneffekten ist.
// - Wenn die Variable noch nicht als unveränderlich deklariert ist, tun Sie dies und testen Sie. Dies stellt sicher, dass sie nur einmal zugewiesen wird.
// - Suchen Sie die erste Referenz auf die Variable und ersetzen Sie sie durch die rechte Seite der Zuweisung.
// - Testen Sie den Code.
// - Wiederholen Sie das Ersetzen von Referenzen auf die Variable, bis Sie alle ersetzt haben.
// - Entfernen Sie die Deklaration und Zuweisung der Variable.
// - Testen Sie den Code.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Vorgehen
// - Verify that the right-hand side of the assignment is free of side effects.
// - If the variable has not been declared as immutable yet, do so and test. This ensures that it is only assigned once.
// - Find the first reference to the variable and replace it with the right-hand side of the assignment.
// - Test the code.
// - Repeat the replacement of references to the variable until you have replaced them all.
// - Remove the declaration and assignment of the variable.
// - Test the code.




// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
public int calculateTriangleArea(int base, int height) {
    int area = base * height;
    return area;
}

// %% tags=["subslide"]
public int calculateTriangleArea(int base, int height) {
    return base * height;
}
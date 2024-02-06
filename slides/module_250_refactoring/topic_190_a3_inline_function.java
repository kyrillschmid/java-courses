// j2 from 'macros.j2' import header
// {{ header("Inline Funktion", "Inline Function") }}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Beschreibung
// Inline Function ist ein Refactoring-Muster, das dazu verwendet wird, den Code zu vereinfachen, indem ein Funktionsaufruf durch den eigentlichen Funktionskörper ersetzt wird. Dieses Muster wird angewendet, wenn der Funktionskörper genauso klar ist wie der Funktionsname, wenn es zu viel Umleitung gibt oder wenn der Code schlecht strukturiert ist. Das Inlining kann dazu beitragen, unnötige Umleitungen zu beseitigen und die Lesbarkeit des Codes zu verbessern.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// Inline Function is a refactoring pattern used to simplify code by replacing a function call with the actual function body. This pattern is used when the function body is as clear as the function name, when there is too much redirection, or when the code is poorly structured. Inlining can help eliminate unnecessary redirects and improve the readability of the code.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Motivation
// Die Motivation für die Verwendung des Inline Function-Musters besteht darin, unnötige Umleitungen zu beseitigen, den Code zu vereinfachen und die Lesbarkeit zu verbessern. Dieses Muster wird angewendet, wenn der Funktionskörper genauso klar ist wie der Funktionsname, wenn es zu viel Delegation gibt oder wenn der Code schlecht strukturiert ist. Durch das Inlining kann der Entwickler nützliche Umleitungen identifizieren und den Rest beseitigen.


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Description
//
// The motivation for using the Inline Function pattern is to eliminate unnecessary redirections, simplify the code, and improve readability. This pattern is used when the function body is as clear as the function name, when there is too much delegation, or when the code is poorly structured. Inlining allows the developer to identify useful redirects and eliminate the rest.


// %% [markdown] lang="de" tags=["subslide"]
// ## Beispiel

// %% [markdown] lang="en" tags=["subslide"]
// ## Example

// %% tags=["subslide"]
public class InlineFunctionExample {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        int sum = add(a, b);
        System.out.println("Sum: " + sum);
    }

    private static int add(int a, int b) {
        return a + b;
    }
}

// %% tags=["subslide"]
public class InlineFunctionExample {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        int sum = a + b; // Inlined function add(a, b)
        System.out.println("Sum: " + sum);
    }
}
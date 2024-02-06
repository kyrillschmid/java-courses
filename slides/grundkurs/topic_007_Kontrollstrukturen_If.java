// j2 from 'macros.j2' import header
// {{ header("Kontrollstrukturen", "Control Structures") }}

// %% [markdown] lang="de" tags=["slide"]
// ## `if`-Anweisungen
//
// - Wir wollen ein Programm schreiben, das bestimmt ob eine Zahl eine Glückszahl
//   ist oder nicht:
//     - 7 ist eine Glückszahl
//     - Alle anderen Zahlen sind es nicht.
// - Wir benötigen dazu die `if`-Anweisung:

// %% [markdown] lang="en" tags=["slide"]
// ## `if` statements
//
// - We want to write a program that determines if a number is a lucky number or not:
//     - 7 is a lucky number
//     - all other numbers are not.
// - We need the `if` statement for this:

// %% tags=["subslide"] lang="de"
void istGlückszahl(int zahl){ 
    if (zahl == 7){
        System.out.println("Glückszahl");
    } else {
        System.out.println("Keine Glückszahl");
    }
}

// %% tags=["subslide"] lang="en"
void isLuckyNumber(int number){ 
    if (number == 7){
        System.out.println("lucky number");
    } else {
        System.out.println("not a lucky number");
    }
}

// %% lang="de"
istGlückszahl(1)

// %% lang="en"
isLuckyNumber(1)

// %% lang="de"
istGlückszahl(7)

// %% lang="en"
isLuckyNumber(7)


// %% lang="de" tags=["subslide", "keep"]
void istGlückszahl(int zahl){
    System.out.println("Ist " + zahl + " eine Glückszahl?");

    if (zahl == 7){
        System.out.println("Ja!");
    } else {
        System.out.println("Leider nein.");
    }

    System.out.println("Wir wünschen Ihnen alles Gute.");
}

// %% lang="en" tags=["subslide", "keep"]
void isLuckyNumber(int number){
    System.out.println("Is " + number + " a lucky number?");

    if (number == 7){
        System.out.println("Yes!");
    } else {
        System.out.println("Unfortunately no.");
    }

    System.out.println("We wish you all the best.");
}

// %% lang="de" tags=["keep"]
istGlückszahl(1)

// %% lang="en" tags=["keep"]
isLuckyNumber(1)

// %% lang="de" tags=["keep"]
istGlückszahl(7)

// %% lang="en" tags=["keep"]
isLuckyNumber(7)


// %% lang="de" tags=["subslide", "keep"]
void istGlückszahl2(int zahl){
    if (zahl == 7){
        System.out.println(zahl + " ist eine Glückszahl!");
        System.out.println("Sie haben sicher einen super Tag!");
    } else {
        System.out.println(zahl + " ist leider keine Glückszahl.");
        System.out.println("Vielleicht sollten Sie heute lieber im Bett bleiben.");
        System.out.println("Wir wünschen Ihnen trotzdem alles Gute.");
    }
}

// %% lang="en" tags=["subslide", "keep"]
void isLuckyNumber2(int number){
    if (number == 7){
        System.out.println(number + " is a lucky number!");
        System.out.println("You must be having a great day!");
    } else {
        System.out.println(number + " is unfortunately not a lucky number.");
        System.out.println("Maybe you should stay in bed today.");
        System.out.println("We wish you all the best anyway.");
    }
}

// %% lang="de" tags=["keep"]
istGlückszahl2(1)

// %% lang="en" tags=["keep"]
isLuckyNumber2(1)

// %% lang="de" tags=["keep"]
istGlückszahl2(7)

// %% lang="en" tags=["keep"]
isLuckyNumber2(7)

// %% [markdown] lang="de" tags=["slide"]
// ## Struktur einer `if`-Anweisung (unvollständig):
//
// ```java
// if (<Bedingung>){
//     Rumpf, der ausgeführt wird, wenn <Bedingung> wahr ist
// } else {
//     Rumpf, der ausgeführt wird, wenn <Bedingung> falsch ist
// }
// ```
// - Nur das `if` und der erste Rumpf sind notwendig
// - Falls ein `else` vorhanden ist, so darf der entsprechende Rumpf nicht leer sein

// %% [markdown] lang="en" tags=["slide"]
// ## Structure of an `if` statement (incomplete):
// ```java
// if (<condition>){
//     body that is executed if <condition> is true
// } else {
//     body that is executed if <condition> is false
// }
// ```
// - Only the `if` and the first body are necessary

// j2 include "ws_120_adult.java"

// j2 include "ws_120_is_even.java"

// j2 include "ws_120_shortened_output.java"
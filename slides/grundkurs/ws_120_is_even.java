// %% [markdown] lang="de" tags=["subslide"]
//
// ## Mini-Workshop: Gerade Zahl


// %% [markdown] lang="en" tags=["subslide"]
//
// ## Mini-Workshop: Even number

// %% [markdown] lang="de"
//
// Schreiben Sie eine Funktion `istGerade(int zahl)`, die `true` zurückgibt,
// falls `zahl` gerade ist und `false`, falls `zahl` ungerade ist.

// %% lang="de"
boolean istGerade(int zahl){
    return zahl % 2 == 0;
}

// %% [markdown] lang="en"
//
// Write a function `isEven(int number)` that returns `true`,
// if `number` is even and `false` if `number` is odd.

// %% lang="en"
boolean isEven(int number){
    return number % 2 == 0;
}

// %% tags=["keep"]
%maven org.junit.jupiter:junit-jupiter-api:5.8.2
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

// %% [markdown] lang="de" tags=["subslide"]
//
// Schreiben Sie Assertions, die testen ob `ist_gerade()` für die Argumente 0, 1
// und 8 das korrekte Ergebnis liefert.

// %% lang="de"
assertTrue(istGerade(0));
assertFalse(istGerade(1));
assertTrue(istGerade(8));

// %% [markdown] lang="en" tags=["subslide"]
//
// Write assertions that check that `is_even()` returns the correct result
// for arguments 0, 1 and 8.

// %% lang="en"
assertTrue(isEven(0));
assertFalse(isEven(1));
assertTrue(isEven(8));


// %% [markdown] lang="de" tags=["subslide"]
// Schreiben Sie eine Funktion `druckeIstGerade(int zahl)`, die
//
// - `{zahl} ist gerade.` auf dem Bildschirm ausgibt, falls `zahl` gerade ist und
// - `{zahl} ist ungerade.` auf dem Bildschirm ausgibt, falls `zahl` nicht
//   gerade ist.
//
// Verwenden Sie dabei dei Funktion `ist_gerade()` um zu überprüfen, ob `zahl`
// gerade ist.

// %% lang="de"
void druckeIstGerade(int zahl){
    if (istGerade(zahl)){
        System.out.println(zahl + " ist gerade.");
    } else {
        System.out.println(zahl + " ist ungerade.");
    }
}

// %% [markdown] lang="en" tags=["subslide"]
// Write a function `printIsEven(int number)` that
//
// - prints `{number} is even.` on the screen if `number` is even and
// - Prints `{number} is odd.` to the screen if `number` is not
//   is straight.
//
// Use the `isEven()` function to check if `number` is even.

// %% lang="en"
void printIsEven(int number){
    if (isEven(number)){
        System.out.println(number + " is even.");
    } else {
        System.out.println(number + " is odd.");
    }
}

// %% [markdown] lang="de" tags=["subslide"]
// Testen Sie `druckeIstGerade(int zahl)` mit den Werten 0, 1 und 8.

// %% lang="de"
druckeIstGerade(0);
druckeIstGerade(1);
druckeIstGerade(8);

// %% [markdown] lang="en" tags=["subslide"]
// Test `printIsEven(int number)` with the values 0, 1 and 8.

// %% lang="en"
printIsEven(0);
printIsEven(1);
printIsEven(8);

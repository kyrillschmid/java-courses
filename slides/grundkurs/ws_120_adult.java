// %% [markdown] lang="de" tags=["subslide"]
//
// ## Mini-Workshop: Volljährig

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Mini workshop: Adult

// %% [markdown] lang="de"
//
// Schreiben Sie eine Funktion `druckeVolljährig(int alter)`, die `Volljährig`
// auf dem Bildschirm ausgibt, wenn `alter >= 18` ist und `Minderjährig` sonst.

// %% [markdown] lang="en"
//
// Write a function `printOfAge(int age)` that prints `of age` on the screen if
// `age >= 18` and `minor` otherwise.

// %% lang="de"
void druckeVolljährig(int alter){
    if (alter >= 18){
        System.out.println("Volljährig");
    } else {
        System.out.println("Minderjährig");
    }
}

// %% lang="en"
void printOfAge(int age){
    if (age >= 18){
        System.out.println("of age");
    } else {
        System.out.println("minor");
    }
}

// %% [markdown] lang="de" tags=["subslide"]
// Testen Sie `druckeVolljährig(int alter)` mit den Werten 17 und 18.

// %% [markdown] lang="en" tags=["subslide"]
// Test `printOfAge(int age)` with the values 17 and 18.

// %% lang="de"
druckeVolljährig(17);
druckeVolljährig(18);

// %% lang="en"
print_of_age(17);
print_of_age(18);

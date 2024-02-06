// j2 from 'macros.j2' import header
// {{ header("While-Schleifen", "While-loops") }}


// %% [markdown] lang="de" tags=["slide"]
//
//  ## While-Schleifen
//
//  Manchmal wollen wir einen Teil eines Programms immer wieder ausführen:
//
//  - Zahlenraten bis die richtige Zahl gefunden wurde
//  - Physik-Simulation bis das Ergebnis genau genug ist
//  - Verarbeitung von Benutzereingaben in interaktiven Programmen
//
//  Wenn wir die Anzahl der Wiederholungen nicht von vornherein wissen,
//  verwenden wir dafür in der Regel eine While-Schleife.

// %% [markdown] lang="en" tags=["slide"]
// ## While loops
//
//  Sometimes we want to run a part of a program over and over again:
//
//  - Number of guesses until the right number is found
//  - Physics simulation until the result is accurate enough
//  - Processing of user input in interactive programs
//
//  When we don't know the number of iterations upfront, we typically
//  use a while loop to do that.

// %% tags=["subslide"]
void rocketLaunch(int countdown) {
    System.out.println("Welcome to the Rocket Launch Countdown Simulator!");
    while (countdown > 0) {
        System.out.printf("Rocket launches in %d seconds...%n", countdown);
        countdown -= 1;
    }
    System.out.println("Liftoff! 🚀");
}

// %% tags=["subslide"]
rocketLaunch(10)

// %% [markdown] lang="de" tags=["slide"]
//
//  ## Beenden von Schleifen
//
// Manchmal ist es leichter, die Abbruchbedingung einer Schleife im Rumpf zu
// bestimmen, statt am Anfang. Mit der Anweisung `break` kann man eine
// Schleife vorzeitig beenden:

// %% [markdown] lang="en" tags=["slide"]
// ## Terminating loops
//
// Sometimes it's easier to determine whether to terminate a loop inside the body
// rather than in the loop condition. With the `break` statement you can
// exit a loop early:

// %%
int i = 1;
while (i < 10) {
    System.out.println(i);
    if (i % 3 == 0) {
        break;
    }
    i += 1;
}
System.out.printf("After the loop: %d%n", i);

// %%
import java.util.Scanner; 
Scanner s = new Scanner(System.in);

// %%
void annoyUser() {
    while (true) {
        System.out.print("Say hi: "); 
        String text = s.next(); 
        if (text.toLowerCase().equals("hi")) {
            break;
        } else {
            System.out.printf("You chose %s%n", text);
        }
    }
}

// %%
// annoyUser()

// j2 include "ws_210_guess_number.java"

// j2 include "ws_210_run_experiment.java"
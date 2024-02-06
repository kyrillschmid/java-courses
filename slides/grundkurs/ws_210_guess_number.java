// %% [markdown] lang="de" tags=["subslide"]
//
// ## Mini-Workshop: Zahlenraten
//
// - Schreiben Sie ein Programm, das eine Zufallszahl zwischen 1 und 100 erzeugt
// und den Benutzer solange raten lässt, bis er die Zahl erraten hat.
// - Nach jedem Versuch soll dem Benutzer angezeigt werden, ob die geratene Zahl
// zu groß oder zu klein war.

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Mini-Workshop: Guess the number
//
// - Write a program that generates a random number between 1 and 100
// - and lets the user guess until they have guessed the number.
// - After each attempt, the user should be shown whether the guessed number
//   was too big or too small.
// - Add a limit to the number of attempts in your program.
//   If the user guesses the number in less than 6 attempts, the message
//   `Well guessed!` should be output, otherwise `Badly guessed!`.


// %%
import java.util.Random;
import java.util.Scanner; 
Scanner s = new Scanner(System.in);

void guessNumber() {
    Random random = new Random();
    int solution = random.nextInt(100) + 1;
    System.out.println("Welcome to the number guessing game!");
    System.out.println("I have thought of a number between 1 and 100. Try to guess it!");
    while (true) {
        System.out.print("Please enter a number: "); 
        String text = s.next(); 
        int guess = Integer.parseInt(text);
        if (guess < solution) {
            System.out.println("Too low!");
        } else if (guess > solution) {
            System.out.println("Too high!");
        } else {
            System.out.println("Congratulations! You guessed the number!");
            break;
        }
    }
}

// %%
guessNumber()

// %% [markdown] lang="de" tags=["subslide"]
// 
// - Fügen Sie Ihrem Programm eine Begrenzung der Rate-Versuche hinzu.   
//   Wenn der Benutzer die Zahl in weniger als 6 Versuchen errät, soll die Meldung
//   `Gut geraten!` ausgegeben werden, ansonsten `Schlecht geraten!`.
// - Erweitern Sie das Programm, sodass nach dem Ende des Spiels die Anzahl der
//   benötigten Versuche ausgegeben wird.

// %% [markdown] lang="en"
//
// - Add a limit to the number of attempts in your program.
//   If the user guesses the number in less than 6 attempts, the message
//   `Well guessed!` should be output, otherwise `Badly guessed!`.
// - Extend the program so that after the end of the game the number of
//   attempts required is output.


// %%
void guessNumber() {
    Random random = new Random();
    int solution = random.nextInt(100) + 1;
    System.out.println("Welcome to the number guessing game!");
    System.out.println("I have thought of a number between 1 and 100. Try to guess it!");
    int tries = 0;
    while (tries < 6) {
        System.out.print("Please enter a number: ");
        String text = s.next();
        int guess = Integer.parseInt(text);
        if (guess < solution) {
            System.out.println("Too low!");
        } else if (guess > solution) {
            System.out.println("Too high!");
        } else {
            System.out.println("Congratulations! You guessed the number!");
            break;
        }
        tries += 1;
    }
    if (tries < 6) {
        System.out.println("Well guessed!");
    } else {
        System.out.println("Badly guessed!");
    }
}

// %%
guessNumber()

// %% [markdown] lang="de" tags=["subslide"]
// 
// - Erweitern Sie das Programm, sodass der Benutzer entscheiden kann, ob er
//   erneut spielen möchte.

// %% [markdown] lang="en"
// 
// - Extend the program so that the user can decide whether they want to play again.

// %%
void guessNumber() {
    Random random = new Random();
    int solution = random.nextInt(100) + 1;
    System.out.println("Welcome to the number guessing game!");
    System.out.println("I have thought of a number between 1 and 100. Try to guess it!");
    while (true) {
        int tries = 0;
        while (tries < 6) {
            System.out.print("Please enter a number: ");
            String text = s.next();
            int guess = Integer.parseInt(text);
            if (guess < solution) {
                System.out.println("Too low!");
            } else if (guess > solution) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number!");
                break;
            }
            tries += 1;
        }
        if (tries < 6) {
            System.out.println("Well guessed!");
        } else {
            System.out.println("Badly guessed!");
        }
        System.out.print("Do you want to play again? (y/n) ");
        String again = s.next();
        if (!again.equals("y")) {
            break;
        }
    }
}


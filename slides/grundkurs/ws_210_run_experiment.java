// %% [markdown] lang="de" tags=["subslide"]
//
// ## Mini-Workshop: Run an experiment
//
// - Schreiben Sie ein Programm, das ein Experiment ausführt
// - Das Experiment besteht darin, eine Zufallszahl zu erzeugen und zu prüfen,
//   ob diese größer als 0.8 ist.
// - Wenn das Experiment erfolgreich war, soll `Erfolg!` ausgegeben werden,
//   andernfalls `Fehlschlag.`.
// - Führen Sie das Experiment solange aus, bis es erfolgreich war.
// - Geben Sie die Anzahl der benötigten Versuche aus.
//

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Mini-Workshop: Run an experiment
//
// - Write a program that runs an experiment
// - The experiment consists of generating a random number and checking
//   whether it is greater than 0.8.
// - If the experiment was successful, `Success!` should be output,
//   otherwise `Failure.`.
// - Run the experiment until it was successful.
// - Output the number of attempts required.
//

// %% tags=["slide"]
import java.util.Random;

// %% 
void runExperiment() {
    Random random = new Random();
    int attempts = 0;
    while (true) {
        attempts++;
        double number = random.nextDouble();
        System.out.print("Attempt " + attempts + ": ");
        if (number > 0.8) {
            System.out.println("Success!");
            break;
        } else {
            System.out.println("Failure.");
        }
    }
}

// %%
runExperiment()
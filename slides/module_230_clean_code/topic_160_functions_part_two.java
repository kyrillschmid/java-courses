// j2 from 'macros.j2' import header
// {{ header("Clean Code Funktionen (Teil 2)", "Clean Code Functions (Part 2)") }}


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Weitere Regeln für Funktionen
//
// - Verwende beschreibende Namen
// - Verwende wenige (oder keine) Argumente
// - Verwende keine booleschen Argumente (Flag-Argumente)
// - Vermeide versteckte Seiteneffekte

// %% [markdown] lang="en" tags=["subslide"]
//
// ## More rules for functions
//
// - Use descriptive names
// - Use few (or no) arguments
// - Don’t use Boolean arguments (flag arguments)
// - Avoid hidden side effects


// %% [markdown] lang="de" tags=["subslide"]
//
// ## Versteckte Seiteneffekte

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Hidden Side-Effects

// %% [markdown]
//
// ```java
// public boolean checkPassword(String userName, String password) {
//    Optional<User> userOptional = UserGateway.findByName(userName);
//    if (userOptional.isPresent()) {
//        User user = userOptional.get();
//        String codedPhrase = user.getPhraseEncodedByPassword();
//        String phrase = cryptographer.decrypt(codedPhrase, password);
//        if ("Valid Password".equals(phrase)) {
//            session.initialize();
//            return true;
//        }
//    }
//    return false;
//}
// ```

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Vermeide "Ausgabeargumente"

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Avoid output arguments
//


// %% tags=["keep"]
public class HitResultV1 {
    boolean collisionOccurred = false;
}

public class Obstacle {
    
}


// %% tags=["keep"]
public class PlayerV1 {
    
    public void checkCollision(List<Obstacle> obstacles, HitResultV1 hitResult) {
        // Complicated computation...
        hitResult.collisionOccurred = true;
    }
}


// %% tags=["keep"]
PlayerV1 player = new PlayerV1();
HitResultV1 hitResult = new HitResultV1();
player.checkCollision(Collections.emptyList(), hitResult);
if (hitResult.collisionOccurred) {
    System.out.println("Detected collision!");
}

// %%  tags=["subslide"]
public class HitResult {
    boolean collisionOccurred = false;
    
    public HitResult(boolean collisionOccured){
        this.collisionOccurred = collisionOccured;
    }
}

// %%
public class Player{
    public HitResult checkCollision(List<Obstacle> obstacles){
        // Complicated computation...
        return new HitResult(true);
    }
}


// %% tags=["keep"]
Player player = new Player();
HitResult hitResult = player.checkCollision(new ArrayList<Obstacle>());
if(hitResult.collisionOccurred){
    System.out.println("Collision detected!");
}

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Command-Query Separation

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Command-Query Separation

// %% tags=["keep"]
int defaultValue = -1;


// %% tags=["keep"]
private boolean badHasDefaultValue() {
    if (defaultValue >= 0) {
        return true;
    } else {
        defaultValue = 123;
        return false;
    }
}


// %%
System.out.println(defaultValue);
System.out.println(badHasDefaultValue());
System.out.println(defaultValue);

// %% 
int defaultValue = -1;

// %% tags=["subslide"]
public boolean hasDefaultValue() {
    return defaultValue >= 0;
}


// %%
public void setDefaultValue() {
    defaultValue = 123;
}


// %%
System.out.println(defaultValue);
System.out.println(hasDefaultValue());
System.out.println(defaultValue);
setDefaultValue();
System.out.println(defaultValue);

// %% [markdown] lang="de" tags=["subslide"]
//
// ## Fehlerbehandlung
//
// Verwende Ausnahmen zur Fehlerbehandlung.

// %% [markdown] lang="en" tags=["subslide"]
//
// ## Error Reporting
//
// Use exceptions for error reporting.


// %% [markdown] lang="de" tags=["subslide"]
//
// ## DRY: Don't Repeat Yourself
//
// - Versuche, duplizierten Code zu eliminieren.
//   - Wiederholung bläht den Code auf
//   - Wiederholung von Code erfordert mehrere Modifikationen für jede Änderung
// - Aber: oft ist duplizierter Code mit anderem Code durchsetzt
// - Berücksichtige den Bereich, in dem Sie den Code DRY halten!

// %% [markdown] lang="en" tags=["subslide"]
//
// ## DRY: Don't Repeat Yourself
//
// - Try to eliminate duplicated code
//   - It bloats the code
//   - It requires multiple modifications for every change
// - But: often duplicated code is interspersed with other code
// - Take into account the scope in which you keep code DRY!

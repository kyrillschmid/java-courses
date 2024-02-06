// j2 from 'macros.j2' import header
// {{ header("Typ-Inferenz - Lambda", "Type-Inference - Lambda") }}

// %% [markdown] lang="de" tags=["slide"]
// * Bei Lambdas werden häufig Typen nicht angegeben (*type inference*).
//   * Typangaben sind optional.
// * Typannotationen können auf diese Weise allerdings nicht angebracht werden.
//   * Der workaround führte bisher über die explizite Typisierung des Lambda.
//
// Mit der Neuerung ist es möglich Typannotation an ```var``` für Lambdas anzubringen und damit eine explizite Angabe von Typen zu vermeiden.

// %% [markdown] lang="en" tags=["slide"]
// * Lambdas often do not specify types (*type inference*).
//   * Type annotations are optional.
// * Type annotations cannot be attached in this way.
//   * The workaround previously involved explicitly typing the lambda.

// %% [markdown] lang="de" tags=["slide"]
// Zur Motivation:

// %% [markdown] lang="en" tags=["slide"]
// Motivation:

// %% tags=["keep"]
import java.util.function.Consumer;

// %% tags=["keep"]
var lambda1 = (Consumer<String>)(one) -> {
    System.out.println(one);
};

// %%
lambda1.accept("Ohne Typangabe");

// %% tags=["keep"]
public @interface Nonnull{}
public @interface Nullable{}

// %% tags=["start"]
var lambda1 = (Consumer<String>)(one) -> {
    System.out.println(one);
};

// %% tags=["alt"]
var lambda1 = (Consumer<String>)(@Nonnull String one) -> {
    System.out.println(one);
};

// %%
lambda1.accept("work-around");

// %% [markdown] lang="de" tags=["slide"]
// Mit der Einführung von `var` als Typplatzhalter bei Lambda.

// %% [markdown] lang="en" tags=["slide"]
// With the introduction of `var` as a type placeholder for lambda.

// %%
var lambda1 = (Consumer<String>)(@Nonnull var one) -> {
    System.out.println(one);
};

// %%
lambda1.accept("work-around");

// %% [markdown] lang="de" tags=["slide"]
// Ein weiteres Beispiel.

// %% [markdown] lang="en" tags=["slide"]
// Another example.

// %% tags=["keep"]
import java.util.function.BiConsumer;

// %% tags=["keep"]
interface IProcess { void process(String input); }

// %% 
var f1 = (BiConsumer<IProcess, String>) (x, y) -> x.process(y);  // implizit typisierte lambda Expression

// %%
var f2 = (BiConsumer<IProcess, String>) (var x, var y) -> x.process(y);  // explizite Typinferenz in lambda Expression

// %%
var f3 = (BiConsumer<IProcess, String>) (@Nonnull var x, @Nullable var y) -> x.process(y);  // explizite Typinferenz in lambda Expression mit Typinferenzannotationen

// %% [markdown] lang="de" tags=["slide"]
// ## Einschränkungen

// %% [markdown] lang="en" tags=["slide"]
// ## Restrictions

// %% tags=["keep"]
var f = (BiConsumer<IProcess, String>) (var x, y) -> x.process(y);  // Compilerfehler

// %% tags=["keep"]
var f = (BiConsumer<IProcess, String>) (var x, String y) -> x.process(y);  // Compilerfehler

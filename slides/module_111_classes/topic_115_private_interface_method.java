// j2 from 'macros.j2' import header
// {{ header("Private Methoden in Interfaces", "Private Methoden in Interfaces") }}

// %% [markdown] lang="de" tags=["slide"]
// * Gelegentlich erfordert ein gutes Typdesign komplexe Interfaces.
// * Zur Vereinfachung der Interface Weiterentwicklung wurden `default` und weitere Erleichterungen eingebaut

// %% [markdown] lang="en" tags=["slide"]
// * Occasionally, good type design requires complex interfaces.
// * To simplify interface evolution, `default` and other simplifications have been built in.

// %% tags=["start"]
public interface ICanDoIt {
}

// %% tags=["alt"]
public interface ICanDoIt {
    String yes();

    default String no() {
        return NO;
    }

    String NO = "no";
}

// %%
System.out.println(ICanDoIt.NO);

// %% [markdown] lang="de" tags=["slide"]
// * Gelegentlich beherbergen die Interfaces komplexe Logik *eigentlich ein Anti-Pattern
//   * Die Komplexität spielt sich dann im nicht-öffentlich Teil des Interfaces ab

// %% [markdown] lang="en" tags=["slide"]
// * Occasionally, the interfaces host complex logic *actually an anti-pattern*.
//   * The complexity then takes place in the non-public part of the interface.

// %% tags=["start"]
public interface ICanDoIt {
    String yes();

    default String no() {
        return NO;
    }

    String NO = "no";
}

// %% tags=["alt"]
public interface ICanDoIt {
    String yes();

    default String no() {
        return NO;
    }

    String NO = "no";

    default boolean maybe() {
        return complexDecision();
    }

    private boolean complexDecision() {
        System.out.println("private-static method of interface");
        return new java.util.Random().nextBoolean();
    }
}

// %%
var x = (ICanDoIt)null;
//x.yes();              // compiles
//x.no();               // compiles
//x.maybe();            // compiles
//x.complexDecision();  // compiler-error: cannot access private method

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop
//
// 1. Erstelle ein Interface `IOrder`
//     1. Erstelle `void order();` im Interface
//     1. Erstelle `default void checkBeforeOrdering()` im Interface
//         1. Diese default Methode soll die beiden Methoden `assertValidForm()` und `assertValidTransitiveOrders` aufrufen.
//     1. Lege diese beiden Methoden im Interface mit `private void assertValidForm()` und `private void assertValidTransitiveOrders()` an.
// 1. Erstelle eine Implementierung `class DoOrder implements IOrder`, welche
//     1. `order()` überschreibt und `checkBeforeOrdering()` im Methodenbody aufruft.
// 1. Erstelle eine Implementierung `class DoOtherOrder implements IOrder`, welche
//     1. `checkBeforeOrdering()` überschreibt und
//     1. `order()` überschreibt und `checkBeforeOrdering()` im Methodenbody aufruft.
//
// Nutze nun diese Implementierungen und teste, wie sich der Code verhält,
// * wenn eine neue Methode im Interface steht.
// * wenn eine neue Methode mit `default` im Interface steht.
// * wenn die default Logik komplexer und die Methoden aufteilen musst.

// %% [markdown] lang="en" tags=["slide"]
// # Mini-Workshop
//
// 1. Create an interface `IOrder`
//     1. Create `void order();` in the interface
//     1. Create `default void checkBeforeOrdering()` in the interface
//         1. This default method should call the two methods `assertValidForm()` and `assertValidTransitiveOrders`.
//     1. Create these two methods in the interface with `private void assertValidForm()` and `private void assertValidTransitiveOrders()`.
// 1. Create an implementation `class DoOrder implements IOrder`, which
//     1. overrides `order()` and calls `checkBeforeOrdering()` in the method body.
// 1. Create an implementation `class DoOtherOrder implements IOrder`, which
//     1. overrides `checkBeforeOrdering()` and
//     1. overrides `order()` and calls `checkBeforeOrdering()` in the method body.
//
// Now use these implementations and test how the code behaves,
// * if a new method is in the interface.
// * if a new method with `default` is in the interface.
// * if the default logic is more complex and you have to split the methods.

// %%
public interface IOrder {
    default void checkBeforeOrdering() {
        assertValidForm();
        assertValidTransitiveOrders();
    }

    void order();

    private static void assertValidForm() {
        System.out.println("  assertValidForm");
    }

    private void assertValidTransitiveOrders() {
        System.out.println("  assertValidTransitiveOrders");
    }
}

// %%
class DoOrder implements IOrder {
    @Override
    public void order() {
        System.out.println("1");
        checkBeforeOrdering();
        System.out.println("2");
    }
}

// %%
new DoOrder().order();

// %%
class DoOtherOrder implements IOrder {
    @Override
    public void checkBeforeOrdering() {
        System.out.println("  simplified");
    }

    @Override
    public void order() {
        System.out.println("1");
        checkBeforeOrdering();
        System.out.println("2");
    }
}

// %%
new DoOtherOrder().order();
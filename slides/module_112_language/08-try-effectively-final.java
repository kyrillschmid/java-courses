// j2 from 'macros.j2' import header
// {{ header("try-resource", "try-resource ") }}

// %% [markdown] lang="de" tags=["slide"]
// * Die korrekte Behandlung von *sensiblen* Ressourcen ist schwierig
//   * reguläre Methodenausstiege
//   * irreguläre Methodenausstiege (Exceptions, Exceptions in Exception-Handler, ...)

// %% [markdown] lang="de" tags=["slide"]
// # Autmatisches Resource-Management
// * Für solche Situationen wurde *try-resource* und `Closeable` eingeführt

// %% 
try (ResourceType resourceName = new ResourceType()) {
    // Use the resource
}

// %% [markdown] lang="de" tags=["notes"]
// * ResourceType muss `Closeable` implementieren
// * The resource is implicitly final and gets closed at the end of the block

// %% [markdown] lang="de" tags=["slide"]
// * Vor Java 9 konnte try-resource nur für neu belegte Variablen im try-resource Statement genutzt werden
// * Java 9 erlaubt die Nutzung von bereits deklarierten Variablen

// %% tags=["start"]
ResourceType resource = new ResourceType();

// %% tags=["alt"]
ResourceType resource = new ResourceType();
try (resource) {
}

// %% [markdown] lang="de" tags=["slide"]
// * Zu beachten:
//  * Die Variable muss *effectively final* sein
//    * Wert wird effektiv nicht verändert nach der Initialisierung

// %% [markdown] lang="de" tags=["slide"]
// ## Beispiel: 
// * e07_try-resource (V1, V2)

// %% tags=["slide", "start"]
class SensitiveResourceV3 {
    void beforeCloseCriticalSection() {
        System.out.println("SensitiveResourceV3.beforeCloseCriticalSection");
    }
    private void sensitive() {
        System.out.println("SensitiveResourceV3.sensitive");
    }   
}

// %% tags=["alt"]
class SensitiveResourceV3 {
    void beforeCloseCriticalSection() {
        System.out.println("SensitiveResourceV3.beforeCloseCriticalSection");
    }
    private void sensitive() {
        System.out.println("SensitiveResourceV3.sensitive");
    }
    Closeable criticalSection() {
        return new CriticalSectionHandler(this);
    }
    class CriticalSectionHandler implements Closeable {
        private final SensitiveResourceV3 sensitiveResource;
        public CriticalSectionHandler(SensitiveResourceV3 sensitiveResource) {
            this.sensitiveResource = sensitiveResource;
        }
        void resourceCriticalActivity() {
            System.out.println("SensitiveResourceV3.criticalSection.resourceCriticalActivity");
            sensitiveResource.sensitive();
        }
        @Override
        public void close() throws IOException {
            System.out.println("SensitiveResourceV3.criticalSection.close");
        }
    }
}

// %%
var a = new SensitiveResourceV3();
a.beforeCloseCriticalSection();
try (var criticalSection = (SensitiveResourceV3.CriticalSectionHandler) a.criticalSection()) {
    criticalSection.resourceCriticalActivity();
}


// %% [markdown] tags=["notes"]
// - Wenn wir die SensitiveRessource bereits vor dem try-resource Block nutzen wollen, müssen wir den kritischen Abschnitt z.b. in private Klasse kapseln

// %% [markdown] lang="de" tags=["slide"]
// ## try-resource mit effectively-final
//
// * Seit Java 9 können Variablen genutzt werden, welche sich im try-resource Block wie final genutzt werden

// %% [markdown] lang="en" tags=["slide"]
// ## try-resource with effectively final
//
// * Now variables can be used which are used in the try-resource block as final.

// %%
// Code is correct, but is not processed correctly in Jupyter and JShell -> please use your IDE.
class SensitiveResourceV4 implements Closeable {
    void beforeResourceLock() {
        System.out.println("SensitiveResourceV4.beforeResourceLock()");
    }

    void inResourceLock() {
        System.out.println("SensitiveResourceV4.inResourceLock()");
    }

    @Override
    public void close() throws IOException {
        System.out.println("SensitiveResourceV4.close()");
    }
}

System.out.println("1");
var unit = new SensitiveResourceV4();
unit.beforeResourceLock();
try (unit) {
    unit.inResourceLock();
    System.out.println("2");
}
System.out.println(3);
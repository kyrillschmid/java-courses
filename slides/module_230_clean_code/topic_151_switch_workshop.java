// j2 from 'macros.j2' import header
// {{ header("Workshop Switch-Case", "Workshop Switch-Case") }}

// %% [markdown] lang="de" tags=["slide"]
//
// ## Mini-Workshop: Ersetzen von Switch-Anweisungen
//
// Strukturieren Sie den folgenden Code so um, dass nur noch bei der Erzeugung
// der Objekte eine "switch-Anweisung" verwendet wird:

// %% [markdown] lang="en" tags=["slide"]
//
// ## Mini workshop: Replacing switch statements
//
// Restructure the following code so that a "switch statement" is used only when
// creating of the objects:



// %% tags=["keep"]
public enum ComputerType {
    COMPUTER_TYPE_PC,
    COMPUTER_TYPE_MAC,
    COMPUTER_TYPE_CHROMEBOOK
}


// %% tags=["keep"]
public class ComputerV1 {
    private final ComputerType computerType;
    
    public ComputerV1(ComputerType computerType){
        this.computerType = computerType;
    }
    
    public ComputerType getComputerType(){
        return this.computerType;
    }
}


// %% tags=["keep", "subslide"]
public void compileCode(ComputerV1 computer) {
    switch (computer.getComputerType()) {
        case COMPUTER_TYPE_PC:
            System.out.println("Compiling code for PC.");
            break;
        case COMPUTER_TYPE_MAC:
            System.out.println("Compiling code for Mac.");
            break;
        case COMPUTER_TYPE_CHROMEBOOK:
            System.out.println("Compiling code for Chromebook.");
            break;
        default:
            throw new IllegalArgumentException(
                String.format("Don't know how to compile code for %s.", computer)
            );
    }
}


// %% tags = ["keep"]
ComputerV1 myPc = new ComputerV1(ComputerType.COMPUTER_TYPE_PC);
ComputerV1 myMac = new ComputerV1(ComputerType.COMPUTER_TYPE_MAC);
ComputerV1 myChromebook = new ComputerV1(ComputerType.COMPUTER_TYPE_CHROMEBOOK);

// %% tags=["keep"]
compileCode(myPc);
compileCode(myMac);
compileCode(myChromebook);


// %% tags=["subslide"]
public abstract class Computer {
    public abstract void compileCode();
}


// %%
public class PC extends Computer {
    @Override
    public void compileCode() {
        System.out.println("Compiling code for PC.");
    }
    
    @Override
    public String toString(){
        return "I'm a Computer";
    }
}


// %%
public class Mac extends Computer {
    @Override
    public void compileCode() {
        System.out.println("Compiling code for Mac.");
    }
    
    @Override
    public String toString(){
        return "I'm a Mac";
    }
}


// %%
public class Chromebook extends Computer {
    @Override
    public void compileCode() {
        System.out.println("Compiling code for Chromebook.");
    }
    
    @Override
    public String toString(){
        return "I'm a ChromeBook";
    }
}


// %% tags=["subslide"]
public Computer createComputer(ComputerType type) {
    switch (type) {
        case COMPUTER_TYPE_PC:
            return new PC();
        case COMPUTER_TYPE_MAC:
            return new Mac();
        case COMPUTER_TYPE_CHROMEBOOK:
            return new Chromebook();
        default:
            throw new IllegalArgumentException("Don't know how to create computer of type " + type + ".");
    }
}

// %%
Computer myPc = createComputer(ComputerType.COMPUTER_TYPE_PC);
Computer myMac = createComputer(ComputerType.COMPUTER_TYPE_MAC);
Computer myChromebook = createComputer(ComputerType.COMPUTER_TYPE_CHROMEBOOK);
System.out.println(List.of(myPc.toString(), myMac, myChromebook));

// %%
myPc.compileCode();
myMac.compileCode();
myChromebook.compileCode();
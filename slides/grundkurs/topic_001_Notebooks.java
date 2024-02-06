// j2 from 'macros.j2' import header
// {{ header("Arbeiten mit Jupyter Notebooks ", "Working with Jupyter Notebooks") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Arbeiten mit Java in Notebooks
//
// - Jupyter Notebooks kommen ursprünglich aus der Python-Welt
// - Es gibt aber auch Unterstützung für andere Sprachen, z.B. Java

// %% [markdown] lang="en" tags=["slide"]
// ## Working with Java in notebooks
//
// - Jupyter notebooks originate from the Python world
// - But there is also support for other languages, e.g. Java

// %% [markdown] lang="de" tags=["slide"]
// ## Installation
//
// Dazu sind folgende Schritte notwendig:
// 1. Voraussetzung: Java Development Kit (JDK) 9 oder höher & Python 3.6 oder höher installiert
// 2. Installation von `Jupyter Notebook` in Terminal oder Eingabeaufforderung:
//```bash
//pip install notebook
//```
// 3. Installation von `IJava`:
//    - 1. Laden Sie die neueste IJava-Version von [IJava](https://github.com/SpencerPark/IJava)
//    - 2. Entpacken Sie die heruntergeladene ZIP-Datei in einen Ordner Ihrer Wahl
//    - 3. In Terminal (Unix/Linux/macOS) oder Eingabeaufforderung (Windows), in extrahierten Ordner folgenden Befehl:
//```bash
// python3 install.py --sys-prefix
//```
// Dies installiert den IJava-Kernel für Jupyter Notebook.
// ## Überprüfen der Installation
// 1. Starten Sie Jupyter Notebook, indem Sie den folgenden Befehl ausführen:
//```bash
//jupyter notebook
//```

// %% [markdown] lang="en" tags=["slide"]
// ## Installation
//
// The following steps are necessary for this:
// 1. Prerequisite: Java Development Kit (JDK) 9 or higher & Python 3.6 or higher installed
// 2. Installation of `Jupyter Notebook` in terminal or command prompt:
//```bash
//pip install notebook
//```
// 3. Installation of `IJava`:
//    - 1. Download the latest IJava version from [IJava](https://github.com/SpencerPark/IJava)
//    - 2. Unzip the downloaded ZIP file into a folder of your choice
//    - 3. In terminal (Unix/Linux/macOS) or command prompt (Windows), in extracted folder run the following command:
//```bash
// python3 install.py --sys-prefix
//```
// This installs the IJava kernel for Jupyter Notebook.

// %% [markdown] lang="en" tags=["slide"]
// ## Checking the installation
// 1. Start Jupyter Notebook by running the following command:
//```bash
//jupyter notebook
//```

// %% [markdown] lang="de" tags=["slide"]
// ## Arbeiten mit Notebooks
//
// - Notebooks sind in Zellen aufgeteilt
// - Zellen können entweder Text oder Java Code enthalten.
// - Es gibt zwei Modi: Kommando- und Edit-Modus (`Esc` / `Enter`)
// - Einige Tastaturkürzel: `Strg`-`Enter`, `Shift`-`Enter`, `Tab`, `Shift-Tab`

// %% [markdown] lang="en" tags=["slide"]
// ## Working with notebooks
//
// - Notebooks are divided into cells
// - Cells can contain either text or Python code.
// - Command and edit mode (`Esc` / `Enter`)
// - Some keyboard shortcuts: `Ctrl`-`Enter`, `Shift`-`Enter`, `Tab`, `Shift-Tab`

// %% tags=["keep"]
void sayHello(String name){
    System.out.println("Hello, " + name);
}

// %% tags=["keep"]
sayHello("World")

// %% [markdown] lang="de" tags=["notes"]
// ## Anzeige von Werten
//
// - Jupyter Notebooks geben den letzten Wert jeder Zelle auf dem Bildschirm aus
// - Das passiert in "normalen" Java-Programmen nicht!
// - Jedenfalls, wenn sie als Programme ausgeführt werden
// - Die `jshell` verhält sich ähnlich wie Notebooks

// %% [markdown] lang="en" tags=["notes"]
// ## Displaying values
//
// - Jupyter notebooks print the last value of each cell on the screen
// - That doesn't happen in "normal" Python programs!
// - At least when they are executed as programs
// - The interactive interpreter behaves similar to notebooks

// %% tags=["subslide"]
123

// %%
17 + 4

// %%
int answer = 42;
answer
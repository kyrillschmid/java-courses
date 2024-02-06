// j2 from 'macros.j2' import header
// {{ header("Kursdateien", "Course files") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Entpacken der Kursdateien
//
// * Es ist wichtig, dass Sie das Zip-Archiv entpacken, bevor Sie mit den Dateien arbeiten.
// * Möglicherweise kann Ihr Browser Dateien im Zip-Archiv öffnen, aber Sie können damit nicht arbeiten!
// * Merken Sie sich den Ort, an dem Sie Ihre entpackten Dateien gespeichert haben.
// * Sie brauchen diesen Ort, um im nächsten Schritt die Jupyter Notebooks zu öffnen.

// %% [markdown] lang="en" tags=["slide"]
// ## Unpacking the course files
//
// * It is important that you unpack the zip archive before working with the files.
// * Your browser may be able to open files in the zip archive, but you cannot work with them!
// * Remember the location where you saved your unpacked files.
// * You need this location to open the Jupyter Notebooks in the next step.

// %% [markdown] lang="de" tags=["slide"]
// ## Struktur des Kurses
// 
// * README.md im Wurzelverzeichnis.
// * Notebooks (Verzeichnis)
//   * **Folien**  (Verzeichnis)
//     * Dies ist der Hauptordner dieses Kurses. Dateien mit der `.ipynb`-Endung sind die Folien. Hier sind die "Musterlösungen" zu den CodeAlong enthalten.
//   * **CodeAlong** (Verzeichnis)
//     * Dies ist die Hauptansicht im Kurs und in den Videos. Hier werden die Inhalte erklärt, entwickelt und im live-coding gezeigt.
// * Java (Verzeichnis)
//   * Folien (Verzeichnis)
//   * CodeAlong (Verzeichnis)

// %% [markdown] lang="en" tags=["slide"]
// ## Course structure
//
// * README.md in the root directory.
// * Notebooks (directory)
//   * **Slides** (directory)
//     * This is the main folder of this course. Files with the `.ipynb` extension are the slides. Here are the "sample solutions" to the CodeAlong.
//   * **CodeAlong** (directory)
//     * This is the main view in the course and in the videos. Here the contents are explained, developed and shown in live-coding.
// * Java (directory)
//   * Slides (directory)
//   * CodeAlong (directory)

// %% [markdown] lang="de" tags=["slide"]
// ## Mit den Folien arbeiten
//
// * Wir nutzen [jupyter](https://jupyter.org/) für Folien und live-coding.
// * Voraussetzung:
//   * JDK in einer Version 17 oder später ist installiert.
//   * python 3 ist installiert.
//
// Installation:
// * Installieren Sie sich jupyter.
//
//   ```sh
//   pip install jupyterlab
//   ```
//
// * Installieren Sie sich [IJava](https://github.com/SpencerPark/IJava#install-pre-built-binary).
//   1. Das letzte [Release](https://github.com/SpencerPark/IJava/releases) herunterladen.
//   1. Das Archiv entpacken.
//   1. IJava installieren und jupyter bekannt machen:
//      ```sh
//      python3 install.py --sys-prefix
//      ```

// %% [markdown] lang="en" tags=["slide"]
// ## Working with the slides
//
// * We use [jupyter](https://jupyter.org/) for slides and live-coding.
// * Prerequisite:
//   * JDK in a version 17 or later is installed.
//   * python 3 is installed.
//
// Installation:
// * Install jupyter.
//
//   ```sh
//   pip install jupyterlab
//   ```
//
// * Install [IJava](https://github.com/SpencerPark/IJava#install-pre-built-binary).
//   1. Download the latest release
//   1. Unpack the archive.
//   1. Install IJava and make jupyter known:
//      ```sh
//      python3 install.py --sys-prefix
//      ```

// %% [markdown] lang="de" tags=["slide"]
// ## Folien öffnen
// ```sh
// jupyter lab java-9-17/
// ```

// %% [markdown] lang="en" tags=["slide"]
// ## Open slides
// ```sh
// jupyter lab java-9-17/
// ```

// %% [markdown] lang="de" tags=["slide"]
// ## Übungen
//
// * Die meisten Übungen können Sie direkt im jupyter notebook bearbeiten.
// * Einige Übungen sind allerdings komplexer und erfordern eine vollwertige IDE.
//   * In den `examples` sind Projekte mit maven und gradle vorbereitet.

// %% [markdown] lang="en" tags=["slide"]
// ## Exercises
//
// * Most exercises can be edited directly in the jupyter notebook.
// * However, some exercises are more complex and require a full-fledged IDE.
//   * In the `examples` projects with maven and gradle are prepared.

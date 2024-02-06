// j2 from 'macros.j2' import header
// {{ header("javac", "javac") }}

// %% [markdown] lang="de" tags=["slide"]
// ## `javac mit expliziter Version (--release)`
//
// * Es ist nun möglich mit einer installierten Version von `javac` unterschiedliche Versionen zu bauen.
// * Früher mussten hierfür mehrere Versionen der JDK installiert werden.
// * Dies hat eine fehlerfreie und korrekte Verwendung deutlich erschwert.
//   * Setzen, löschen und neu-setzen von Umgebungsvariablen war eine Herrausforderung für sich.

// %% [markdown] lang="en" tags=["slide"]
// ## `javac with explicit version (--release)`
//
// * It is now possible to build with different versions of `javac` with a single installation.
// * Previously, multiple versions of the JDK had to be installed for this.
// * This made it much more difficult to use correctly.
//   * Setting, deleting and re-setting environment variables was a challenge in itself.

// %% [markdown] lang="de" tags=["slide"]
// # Mini-Workshop
//
// * Übernehme den folgenden Code in die Datei `Ab.java`

// %% [markdown] lang="de" tags=["slide"]
// ```java
// record AbRecord(int age) {}
// 
// public class Ab {
//     public static void main(String[] args) {
//         System.out.println("Hi AB");
//     }
// }
// ```

// %% [markdown] lang="en" tags=["slide"]
// # Mini Workshop
//
// * Take over the following code into the file `Ab.java`

// %% [markdown] lang="en" tags=["slide"]
// ```java
// record AbRecord(int age) {}
//
// public class Ab {
//     public static void main(String[] args) {
//         System.out.println("Hi AB");
//     }
// }

// %% [markdown] lang="de" tags=["slide"]
// 1. Versuche den Code zu bauen mit `javac Ab.java --release 9`
// 2. Versuche den Code zu bauen mit `javac Ab.java --release 17`

// %% [markdown] lang="en" tags=["slide"]
// 1. Try to build the code with `javac Ab.java --release 9`
// 2. Try to build the code with `javac Ab.java --release 17`

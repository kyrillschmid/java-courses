// j2 from 'macros.j2' import header
// {{ header("Dependency-Inversion-Principle", "Dependency-Inversion-Principle") }}

// %% [markdown] lang="de" tags=["slide"]
//
// ## SOLID: Dependency-Inversion-Principle
//
// - Die Kernfunktionalität eines Systems hängt nicht von seiner Umgebung ab
//   - **Konkrete Artefakte hängen von Abstraktionen ab** (nicht umgekehrt)
//   - **Instabile Artefakte hängen von stabilen Artefakten ab** (nicht umgekehrt)
//   - **Äußere Schichten** der Architektur **abhängig von inneren Schichten**
//     (nicht umgekehrt)
//   - Klassen/Module hängen von Abstraktionen (z. B. Schnittstellen) ab,
//     nicht von anderen Klassen/Modulen
// - Abhängigkeitsinversion erreicht dies durch die Einführung von Schnittstellen,
//   die "die Abhängigkeiten umkehren"

// %% [markdown] lang="en" tags=["slide"]
//
// ## SOLID: Dependency Inversion Principle
//
// - The core functionality of a system does not depend on its environment
//   - **Concrete artifacts depend on abstractions** (not vice versa)
//   - **Unstable artifacts depend on stable artifacts** (not vice versa)
//   - **Outer layers** of the architecture **depend on inner layers** (not vice
//     versa)
//   - Classes/Modules depend on abstractions (e.g., interfaces) not on other
//     classes/modules
// - Dependency inversion achieves this by introducing interfaces that “reverse
//   the dependencies”

// %% [markdown] tags=["subslide"]
//
// <img src="img/dip-01.png"
//      style="display:block;margin:auto;width:95%"/>

// %% [markdown] tags=["subslide"]
//
// <img src="img/dip-02.png"
//      style="display:block;margin:auto;width:95%"/>

// %% [markdown] tags=["subslide"]
//
// <img src="img/dip-03.png"
//      style="display:block;margin:auto;width:95%"/>


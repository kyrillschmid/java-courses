// %% [markdown] lang="de" tags=["slide"]
//
// ## Workshop: Mitarbeiter
//
// Im Folgenden soll eine Klassen-Hierarchie für Mitarbeiter einer Firma erstellt
// werden:
//
// - Mitarbeiter können entweder Arbeiter oder Manager sein
// - Jeder Mitarbeiter der Firma hat einen Namen, eine Personalnummer und ein
//   Grundgehalt
// - Für jeden Arbeiter werden die angefallenen Überstunden und der Stundenlohn
//   gespeichert.
// - Das Gehalt eines Arbeiters berechnet sich als das 13/12-fache des
//   Grundgehalts plus der Bezahlung für die Überstunden
// - Jeder Manager hat einen individuellen Bonus
// - Das Gehalt eines Managers berechnet sich als das 13/12-fache des
//   Grundgehalts plus Bonus
//
// Implementieren Sie Java Klassen `Mitarbeiter`, `Arbeiter` und `Manager` mit
// geeigneten Attributen und einer Methode `gehalt()`, die das Gehalt berechnet.
//

// %% [markdown] lang="en" tags=["slide"]
//
// ## Workshop: Employees
//
// In the following we will implement a class hierarchy for employees of a company:
//
// - Employees can be either workers or managers
// - Each employee of the company has a name, a personnel number and a
//   base salary
// - For each worker, the accumulated overtime and the hourly wage
//   are stored in attributes.
// - A worker's salary is calculated as 13/12 times the
//   base salary plus overtime pay
// - Each manager has an individual bonus
// - A manager's salary is calculated as 13/12 times the
//   base salary plus bonus
//
// Implement Java classes `Employee`, `Worker` and `Manager` with
// appropriate attributes and a method `salary()` that calculates the salary.

// j2 if lang == "de"
// j2 include "ws_192_inheritance_de.java"
// j2 else
// j2 include "ws_192_inheritance_en.java"
// j2 endif



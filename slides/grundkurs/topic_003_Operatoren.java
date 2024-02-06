// j2 from 'macros.j2' import header
// {{ header("Operatoren", "Operators") }}

// %% [markdown] lang="de" tags=["subslide"]
// # Arithmetische Operationen I
// - Java unterstützt die folgenden arithmetischen Operationen

<table style="width:100%">
<tr>
<th>Operation</th>
<th>Syntax</th>
<th>Beispiel</th>
<th>Bedeutung</th>
<th>Datentyp</th>
</tr>

<tr>
<td>Addition</td>
<td>x+y</td>
<td>20 + 7 = 27</td>
<td>addiert zwei Zahlen</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Subtraktion</td>
 <td>x-y</td>
 <td>20 - 7 = 13</td>
 <td>Subtrahiert zwei Zahlen</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Mulitplikation</td>
 <td>x * y</td>
 <td>20 * 7 = 140</td>
 <td>multipliziert zwei Zahlen</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Division</td>
 <td>x / y</td>
 <td>20 / 7 = 2</td>
 <td>Dividiert zwei Zahlen</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Modulo</td>
<td>x % y</td>
<td>20 % 7 = 6</td>
<td>Liefert den Rest einer Integer Devision</td>
<td>Integer, Fließkommezahlen</td>
</tr>
</table>


// %% [markdown] lang="de" tags=["subslide"]
// # Arithmetische Operationen: Postfix und Präfix 
// - Java unterstützt die folgenden arithmetischen Operationen

<table style="width:100%">
<tr>
<th>Operation</th>
<th>Syntax</th>
<th>Beispiel</th>
<th>Bedeutung</th>
<th>Datentyp</th>
</tr>

<tr>
<td>Postfix-Inkrementierung</td>
<td>x++</td>
<td>System.out.println(x++)</td>
<td>x wird ausgewertet, dann inkrementiert</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Postfix-Dekrementierung</td>
<td>x--</td>
<td>System.out.println(x--)</td>
<td>x wird ausgewertet, dann dekrementiert</td>
<td>Integer, Fließkommezahlen</td>
</tr> 

<tr>
<td>Präfix-Inkrementierung</td>
<td>++x</td>
<td>System.out.println(++x)</td>
<td>x wird inkrement, dann ausgewertet</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Präfix-Dekrementierung</td>
<td>--x</td>
<td>System.out.println(--x)</td>
<td>x wird dekrementiert, dann ausgewertet</td>
<td>Integer, Fließkommezahlen</td>
</tr> 

</table>


// %% [markdown] lang="de" tags=["subslide"]
// # Vergleichoperationen
// - Java unterstützt die folgenden Vergleichoperationen

<table style="width:100%">
<tr>
<th>Operation</th>
<th>Syntax</th>
<th>Beispiel</th>
<th>Ergebnis</th>
<th>Bedeutung</th>
<th>Datentyp</th>
</tr>

<tr>
<td>Gleichheit</td>
<td>x == y</td>
<td>20 == 7</td>
<td>false</td>
<td>Liefert true, wenn x gleich y ist, sonst false</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Ungleichheit</td>
<td>x != y</td>
<td>20 != 7</td>
<td>true</td>
<td>Liefert true, wenn x ungleich y ist, sonst false</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Großer als</td>
<td>x > y</td>
<td>20 > 7</td>
<td>true</td>
<td>Liefert true, wenn x großer als y ist, sonst false</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Großer gleich als</td>
<td>x >= y</td>
<td>20 >= 20</td>
<td>true</td>
<td>Liefert true, wenn x großer oder gleich y ist, sonst false</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Kleiner als</td>
<td>x < y</td>
<td>20 < 7</td>
<td>false</td>
<td>Liefert true, wenn x kleiner als y ist, sonst false</td>
<td>Integer, Fließkommezahlen</td>
</tr>

<tr>
<td>Kleiner gleich als</td>
<td>x <= y</td>
<td>20 <= 20</td>
<td>true</td>
<td>Liefert true, wenn x kleiner oder gleich y, sonst false</td>
<td>Integer, Fließkommezahlen</td>
</tr>

</table>


// %% [markdown] lang="de" tags=["subslide"]
// # Logikoperationen
// - Java unterstützt die folgenden Logikoperationen

<table style="width:100%">
<tr>
<th>Operation</th>
<th>Syntax</th>
<th>Beispiel</th>
<th>Ergebnis</th>
<th>Bedeutung</th>
<th>Datentyp</th>
</tr>

<tr>
<td>Logische Und</td>
<td>x & y</td>
<td> (20>27) & (20<30) </td>
<td>false</td>
<td>Liefert true, wenn x und y true ist, sonst false</td>
<td>boolean</td>
</tr>

<tr>
<td>Doppelt Logische Und</td>
<td>x && y</td>
<td> (20>27) && (20<30) </td>
<td>false</td>
<td>Wie & aber liefert direkt false, falls x false ist</td>
<td>boolean</td>
</tr>

<tr>
<td>Logische Oder</td>
<td>x | y</td>
<td> (20>3) | (20<5) </td>
<td>true</td>
<td>Liefert true, wenn x oder y true ist, sonst false</td>
<td>boolean</td>
</tr>

<tr>
<td>Doppelt Logische Oder</td>
<td>x || y</td>
<td> (20>3) && (205) </td>
<td>false</td>
<td>Wie | aber liefert direkt true, falls x true ist</td>
<td>boolean</td>
</tr>

<tr>
<td>Logische Not</td>
<td> !x</td>
<td>! (20 > 50)</td>
<td>true</td>
<td>Liefert true, wenn x false ist, sonder false</td>
<td>boolean</td>
</tr>
</table>

// %% [markdown] lang="de" tags=["subslide"]
// # Bitweise Operationen
// - Java unterstützt die folgenden Bitweise Operationen

<table style="width:100%">
<tr>
<th>Operation</th>
<th>Syntax</th>
<th>Beispiel</th>
<th>Ergebnis</th>
<th>Bedeutung</th>
<th>Datentyp</th>
</tr>

<tr>
<td>Bitweise Und</td>
<td>x & y</td>
<td> 1 & 0 </td>
<td>0</td>
<td>Liefert 1 wenn das bit x und das bit y gleich 1 ist sonst 0</td>
<td>Integer, boolean</td>
</tr>

<tr>
<td>Bitweise Oder</td>
<td>x | y</td>
<td> 1 | 0 </td>
<td>1</td>
<td>Liefert 1 wenn das bit x oder das bit y gleich 1 ist sonst 0</td>
<td>Integer, boolean</td>
</tr>

<tr>
<td>Bitweise XOR</td>
<td>x ^ y</td>
<td> 1 ^ 0 </td>
<td>1</td>
<td>Liefert 1 wenn das bit x und das bit y untrschiedlich sind, sonst 0</td>
<td>Integer, boolean</td>
</tr>


<tr>
<td>Bitweise Not</td>
<td>~x</td>
<td> ~0 </td>
<td>1</td>
<td>Liefert 1 wenn das bit x 0 ist, sonst 0</td>
<td>Integer, boolean</td>
</tr>

</table>


// %% [markdown] lang="de" tags=["subslide"]
// # Exkurs: Binär-System
// - Das Binär-System ist ein Zahlensystem mit der Basis 2

<table style="width:100%">
<tr>
<th>2<sup>7</sup></th>
<th>2<sup>6</sup></th>
<th>2<sup>5</sup></th>
<th>2<sup>4</sup></th>
<th>2<sup>3</sup></th>
<th>2<sup>2</sup></th>
<th>2<sup>1</sup></th>
<th>2<sup>0</sup></th>
</tr>

<tr>
<td>128</td>
<td>64</td>
<td>32</td>
<td>16</td>
<td>8</td>
<td>4</td>
<td>2</td>
<td>1</td>
</tr>

<tr>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
</tr>
</table>

// %% tags=["keep"]
int x = 97; // 0110 0001

// %% [markdown] lang="de"
// - Beispiel: 97 = 64 + 32 + 1  = 0110 0001

<table style="width:100%">
<tr>
<th>2<sup>7</sup></th>
<th>2<sup>6</sup></th>
<th>2<sup>5</sup></th>
<th>2<sup>4</sup></th>
<th>2<sup>3</sup></th>
<th>2<sup>2</sup></th>
<th>2<sup>1</sup></th>
<th>2<sup>0</sup></th>
</tr>

<tr>
<td>128</td>
<td>64</td>
<td>32</td>
<td>16</td>
<td>8</td>
<td>4</td>
<td>2</td>
<td>1</td>
</tr>

<tr>
<td>0</td>
<td>1</td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>1</td>
</tr>
</table>


// %% [markdown] lang="de" tags=["subslide"]
// # Exkurs: Binär-System
// - Das Binär-System ist ein Zahlensystem mit der Basis 2

<table style="width:100%">
<tr>
<th>2<sup>7</sup></th>
<th>2<sup>6</sup></th>
<th>2<sup>5</sup></th>
<th>2<sup>4</sup></th>
<th>2<sup>3</sup></th>
<th>2<sup>2</sup></th>
<th>2<sup>1</sup></th>
<th>2<sup>0</sup></th>
</tr>

<tr>
<td>128</td>
<td>64</td>
<td>32</td>
<td>16</td>
<td>8</td>
<td>4</td>
<td>2</td>
<td>1</td>
</tr>

<tr>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
</tr>
</table>

// %% tags=["keep"]
int x = 79; // 0100 1111

// %% [markdown] lang="de"
// - Beispiel: 79 = 64 + 8 + 4 + 2 + 1 = 0100 1111

<table style="width:100%">
<tr>
<th>2<sup>7</sup></th>
<th>2<sup>6</sup></th>
<th>2<sup>5</sup></th>
<th>2<sup>4</sup></th>
<th>2<sup>3</sup></th>
<th>2<sup>2</sup></th>
<th>2<sup>1</sup></th>
<th>2<sup>0</sup></th>
</tr>

<tr>
<td>128</td>
<td>64</td>
<td>32</td>
<td>16</td>
<td>8</td>
<td>4</td>
<td>2</td>
<td>1</td>
</tr>

<tr>
<td>0</td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
</tr>
</table>

// %% [markdown] lang="de" tags=["subslide"]
// # Prioritätsliste der Operationen
// - Mit () können Sie die Priorität der Operationen ändern

<table style="width:100%">
<tr>
<th>Priorität</th>
<th>Operator</th>
<th>Syntax</th>
<th>Beispiel</th>
<th>Assoziation</th>
</tr>

<tr>
<td>1</td>
<td>Methodenaufruf</td>
<td>obj.method(pars)</td>
<td>person.getName()</td>
<td>links zu rechts</td>
</tr>

<tr>
<td>2</td>
<td>Unary Operator</td>
<td>!, ~, ++, --</td>
<td>x++</td>
<td>rechts zu links</td>
</tr>

<tr>
<td>3</td>
<td>Mult,Div, Mod</td>
<td>*, /, %</td>
<td>x*y</td>
<td>links zu rechts</td>
</tr>

<tr>
<td>4</td>
<td>Add, Sub</td>
<td>+,-</td>
<td>x+y</td>
<td>links zu rechts</td>
</tr>

<tr>
<td>5</td>
<td>Shift</td>
<td><<, >>, >>> </td>
<td>x>>2</td>
<td>links zu rechts</td>
</tr>

<tr>
<td>6</td>
<td>Gleichheit</td>
<td> ==, != </td>
<td> x == y</td>
<td>links zu rechts</td>
</tr>

<tr>
<td>7</td>
<td>AND</td>
<td> & </td>
<td> x & y</td>
<td>links zu rechts</td>
</tr>

<tr>
<td>8</td>
<td>XOR</td>
<td> ^ </td>
<td> x ^ y</td>
<td>links zu rechts</td>
</tr>

<tr>
<td>9</td>
<td>OR</td>
<td>| </td>
<td> x | y</td>
<td>links zu rechts</td>
</tr>

<tr>
<td>10</td>
<td>Doppel AND</td>
<td> && </td>
<td> x && y</td>
<td>links zu rechts</td>
</tr>

<tr>
<td>11</td>
<td>Doppel OR</td>
<td>|| </td>
<td> x || y</td>
<td>links zu rechts</td>
</tr>

</table>


// %% [markdown] lang="de" tags=["subslide"]
// # Sonderzeichen und Escape-Sequenz
// - Java unterstützt die folgenden Escape-Seqenz

<table style="width:100%">
<tr>
<th>Escape Sequenz</th>
<th>Name</th>
<th>Unicode Wert</th>
</tr>

<tr>
<td>\b</td>
<td>Backspace</td>
<td>\u008</td>
</tr>

<tr>
<td>\t</td>
<td>Tabulator (Tap)</td>
<td>\u009</td>
</tr>

<tr>
<td>\n</td>
<td>Zeilenvorschub (Linefeed)</td>
<td>\u000a</td>
</tr>

<tr>
<td>\r</td>
<td>Zeilenumschaltung (Carriage return)</td>
<td>\u000d</td>
</tr>

<tr>
<td>\"</td>
<td>Anfürhungszeichen (Double quote)</td>
<td>\u0022</td>
</tr>

<tr>
<td>\'</td>
<td>Einfache Anfürhungszeichen (Single quote)</td>
<td>\u0027</td>
</tr>
</table>
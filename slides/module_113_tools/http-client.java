// j2 from 'macros.j2' import header
// {{ header("HTTP-Client", "HTTP-Client") }}

// %% [markdown] lang="de" tags=["slide"]
// * Kommunikation über HTTP ist in den letzten Jahren immer wichtiger geworden.
// * Java hatte Netzwerkkommunikation von Anfang an unterstützt.
//   * Allerdings war es teilweile mühsam korrekte HTTP Kommunikation mit low-level Mitteln in Java umzusetzen.
// * Viele unterschiedliche Bibliotheken haben diese Lücke gefüllt.
// * Java führt nun einen gut nutzbaren standardisierten HTTP-Client ein.

// %% lang="de" tags=["keep"]
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;
import java.util.function.Function;

var ellipsize = (Function<String, String>) s -> s.substring(0, 100) + "...";
var ellipsizePrint = (Consumer<String>) s -> System.out.println(ellipsize.apply(s));

// %%
var zeilenSpeicher = new ArrayList<String>();

var request = HttpRequest.newBuilder()
        .uri(URI.create("https://openjdk.org/"))
        .build();

var client = HttpClient.newHttpClient();

client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(HttpResponse::body)
        .thenAccept(zeilenSpeicher::add)
        .join();

"Die ersten 100 Zeichen: %s.".formatted(ellipsize.apply(zeilenSpeicher.get(0)));

// %% [markdown] lang="de" tags=["slide"]
// ## Einstellungen im Client
//
// * Bevorzugte Protokollversion: HTTP/1.1 or HTTP/2.
// * Soll einem redirect automatisch gefolgt werden?
// * Proxyeinstellungen
// * Angaben zu authenticator
// * ...

// %% lang="de" tags=["keep"]
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.http.HttpClient;

var clientMitOptionen = HttpClient.newBuilder()
      .version(HttpClient.Version.HTTP_2)
      .followRedirects(HttpClient.Redirect.NORMAL)
      .proxy(ProxySelector.of(new InetSocketAddress("www-proxy.com", 8080)))
      //.authenticator(Authenticator.getDefault())
      .build();
clientMitOptionen

// %% [markdown] lang="de" tags=["slide"]
// ## Einstellungen im Request
//
// * Welche URI aufgerufen werden soll.
// * Welche HTTP Methode (GET, PUT, POST, ...) verwendet werden soll.
// * Ob ein Body mitgeschickt werden soll, und falls ja mit welchem Inhalt.
// * Ein timeout für die Anfrage.
// * Request headers
// * ...

// %% lang="de" tags=["keep"]
import java.time.Duration;
import java.nio.file.Paths;

var postRequestMitTimeout = HttpRequest.newBuilder()
      .uri(URI.create("http://openjdk.org/"))
      .timeout(Duration.ofMinutes(1))
      .header("Content-Type", "application/json")
      //.POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file.json")))
      .build();
postRequestMitTimeout

// %% [markdown] lang="de" tags=["slide"]
// ## Synchron vs. Asynchron
// ![](img/sync.svg "Synchron")
// ![](img/async.svg "Asynchron")
//
// <!--
// @startuml
// activate client
// 
// client -> server : request
// activate client
// activate server
// 
// hnote over client: waiting for response
// hnote over server: processing request
// 
// client <- server : response
// deactivate server
// deactivate client
// 
// client -> client
// deactivate client
// 
// @enduml
// 
// @startuml
// activate client
// 
// client - -> server : sending request
// activate server
// 
// hnote over client: continue working\n(without response)
// hnote over server: processing request
// 
// client <- - server : response
// deactivate server
// 
// hnote over client: response received
// 
// client -> client
// deactivate client
// 
// @enduml
// -->

// %% [markdown] lang="de" tags=["slide"]
// ## Synchron

// %%
import java.net.http.HttpResponse;

var response = client.send(request, HttpResponse.BodyHandlers.ofString());
"Statuscode: %s, Body (erste 100 Zeichen): %s".formatted(
    response.statusCode(),
    ellipsize.apply(response.body()))

// %% [markdown] lang="de" tags=["slide"]
// ## Asynchron

// %%
var client = HttpClient.newHttpClient();

var x = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(response -> {
            System.out.println("statusCode: " + response.statusCode());
            return response;
        })
        .thenApply(HttpResponse::body)
        .thenAccept(ellipsizePrint);

// Asynchronen Prozess anstoßen und warten -- blocking call
x.join();

// %% [markdown] lang="de" tags=["slide"]
// # Übung
//
// 1. Schaue dir die Zeit-API auf https://www.timeapi.io/swagger/index.html an.
// 1. Speziell: Wie kannst du die aktuelle Uhrzeit für eine gegebene IP Addresse abfragen.
// 1. Setzt den Aufruf mit HTTP-Client um.
//    * Denke an ```.header("accept", "application/json")```.

// %% [markdown] tags=["notes"]
// ```
// curl -X 'GET' \
//   'https://www.timeapi.io/api/Time/current/ip?ipAddress=237.71.232.203' \
//   -H 'accept: application/json'
// ```

// %% tags=["notes"]
var req = HttpRequest.newBuilder()
        .uri(URI.create("https://www.timeapi.io/api/Time/current/ip?ipAddress=237.71.232.203"))
        .header("accept", "application/json")
        .build();
var client = HttpClient.newHttpClient();
var resp = client.send(req, HttpResponse.BodyHandlers.ofString());

System.out.println(resp.statusCode());
System.out.println(resp.body());
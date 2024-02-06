// j2 from 'macros.j2' import header
{{ header("Java Module - Services", "Java Module - Services") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Entkoppelung von Verwender und Bereitsteller


consumer -> uses PrintServiceLookup;
produer ->  provives PrintServiceLookup with com.....FastPrint;

consumer works even if producer is not known at compile-time

-> consumer-code: var psls = ServiceLoader.load(PrintServiceLookup.class);
ServiceLoader (JDK 6)

cycle
  http.client
  logging.API
  logging.impl
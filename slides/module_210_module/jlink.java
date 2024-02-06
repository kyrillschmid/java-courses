// j2 from 'macros.j2' import header
{{ header("Java Module - jlink", "Java Module - jlink") }}

// %% [markdown] lang="de" tags=["slide"]
// ## Vollständige und minimale Bereitstellungseinheiten

jlink --module-path lib:$J/jmods --output hjre --add-modules org.openjdk.hello
 ... --strip-debug --compress 2 --launcher hello=org.openjdk.hello

--> stuff this then into an alpine docker image

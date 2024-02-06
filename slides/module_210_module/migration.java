// j2 from 'macros.j2' import header
{{ header("Gedanken zur Migration", "Thinking About Migration") }}

automatic modules -- treat "sane" jar files as modules
jdeps --jdk-internals ...jar
jdeps -s ...jar
jdeps -s -classpath ... .jar <- also dependencies not yet declared in the modules-info

opens -> other then "export" means: not intended as API, but still open for deep refelction (= data-binding)
  also as opens ... to ...; (qualified open)
 
java --show-modules-resultion

jdeps --generate-module-info ...jar <- draft modules-info.java

provides for service -- breaking up cycles

requires transative -- convinies

no versioning of modules

moduels actively prevents cycles, on classpath still possible


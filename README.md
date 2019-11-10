## Clojure in Nutshell

- Simple and succinct programming language designed to leverage easily
  both legacy code and modern multicore processors
  
- Dynamic typed and functional language

- Clojure simplifies multithreaded programming by using immutable data structures 
and providing powerful concurrency constructs

- Clojure is a dialect of Lisp, and shares with Lisp the code-as-data philosophy and a powerful macro system

- Hosted on JVM/ .NET platform

- Provides java inter-opts 

- Clojure provides easy access to the Java frameworks, with optional type hints and type inference, to ensure that calls to Java can avoid reflection

- [Read closure rationale](https://clojure.org/about/rationale)

---

##### Object Orientation is overrated

- Born of simulation, now used for everything, even when inappropriate. 
Encouraged by Java/C# in all situations, due to their lack of (idiomatic) support for anything else

- Mutable stateful objects are the new spaghetti code

- Hard to understand, test, reason about

- Concurrency disaster

- Inheritance is not the only way to do polymorphism

>It is better to have 100 functions operate on one data structure than to
>have 10 functions operate on 10 data structures." - Alan J. Perlis

- Clojure models its data structures as immutable objects represented by interfaces, and otherwise does not offer its own class system.

- Many functions defined on few primary data structures (seq, map, vector, set).

- Write Java in Java, consume and extend Java from Clojure.

---




  
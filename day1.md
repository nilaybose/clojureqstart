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

### Object Orientation is overrated

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

- Write code in Java, consume and extend Java from Clojure.

---

#### Lets embrace parenthesis

Parentheses serve two purposes

- Calling functions
- Constructing lists
- Contain functions (or
  special things that act like functions) and their arguments. 
- containers for all expressions in the language

![alt text](https://github.com/nilaybose/clojureqstart/blob/master/resources/parenthesis.png "nested parenthesis")

---

#### Lets write the first code

```clojure
(defn -main                                                 ; main method (-) static
  "function documentation"
  []                                                        ; arguments
  (println "Hello, World!")
  (println (str "hello" " " "data management!"))            ; str is used for string concatenation

  (def total 5)
  (println "sum ( 5 + 2 ) = " (+ total 2))                  ; 7

  (def n "Open text")
  (println (reverse n))                                  ; (t x e t   n e p O)
  )
```
>output
```console
Hello, World!
hello data management!
sum ( 5 + 2 ) =  7
(t x e t   n e p O)
```
---

#### Host inter-operation: A JVM crash course

- In many cases Clojure uses Java types and the standard library directly - strings in Clojure are Java String objects and literal numerals are Java Long objects
- Clojure’s collections implement the same collection interfaces implemented by Java
  collections
- Java code can
  use Clojure types (such as its immutable data structures) seamlessly
- Clojure wraps Java library features with functions of its own, like many
  of the functions in Clojure’s clojure.string namespace that delegate to methods in
  Java’s String class
- Clojure doesn’t implement regular functions for
  mathematical methods,therefore need to be invoked via the Java interop (java.lang.Math)
- How does Clojure differentiate between regular Clojure code and code that does Java interop? 
  **The first part of this answer is the dot operator.**

> Java Class

```java
public class Demointerop {
    public static int TOTAL = 100 ;

    public int itotal = -100 ;

    public void callDemo(){
        System.out.println("Calling demo");
    }
}
```

```clojure
(defn -main                                                 ; main method (-) static
  "function documentation"
  []                                                        ; arguments
  (println (. Math PI))                                     ; 3.141592653589793, static field invocation
  (println Math/PI)                                         ; 3.141592653589793, static field invocation
  (println (. System currentTimeMillis))                    ; static method invocation, observer space between . and Class (System)
  (println (System/currentTimeMillis))                      ; static method

  ;; custom java objects
  (println "Demointerop class variable: " (Demointerop/TOTAL))  ; custom java object static field

  ;; custom instance creation and method invocation
  (def demo (new Demointerop))
  (. demo callDemo)
  (println "Object hash : " (.hashCode demo))

  ;; custom instance creation and method invocation, alternative approach
  (def demo (Demointerop.))
  (.callDemo demo)
  (println "Object hash : " (.hashCode demo))

  ;;instance method field invocation
  (println "Demo instance field: " (.-itotal demo))
  )
```
> Output

```console
3.141592653589793
1573387901052
1573387901054
Demointerop class variable:  100
Calling demo
Object hash :  841262455
Calling demo
Object hash :  775081157
Demo instance field:  -100
```

##### Java Interop - function calls with multiple parameters

```clojure
(defn -main                                                 ; main method (-) static
  "function documentation"
  []                                                        ; arguments
  (println (.toUpperCase "hello world"))                    ; HELLO WORLD, preferred way
  (println (. "hello world" toUpperCase ))                  ; HELLO WORLD

  (println (. "hello world" substring 0 5 ))                ; hello
  (println (.substring "hello world" 0 5))                  ; hello

  ;; Chaining
  (println (.toString (.reverse (StringBuilder. "Data Management")))) ; tnemeganaM ataD
  (println (.. (StringBuilder. "Data management") reverse toString toUpperCase)) ;TNEMEGANAM ATAD
  (println (.. (StringBuilder. "Data management") reverse toString toUpperCase (substring 0 10))) ;TNEMEGANAM 
  )
```
> Output
```console
HELLO WORLD
HELLO WORLD
hello
hello
tnemeganaM ataD
TNEMEGANAM ATAD
TNEMEGANAM
```
---
  
##### Demo of immutability

- Clojure data structures are immutable 
- Using Java data structure as inter-op will not be immutable

```clojure
(defn -main                                                 ; main method (-) static
  "function documentation"
  []                                                        ; arguments
  ;; Test if Java Inter-op is immutable
  (def alist (doto (ArrayList.) (.add "hello")))
  ; add operation
  (doto alist (.add "data") (.add "management"))
  (println "Java values : " (.toString alist))

  ;; Clojure equivalent
  (def avector [ 1 2 3 4 5])
  (def bvector (conj avector 10))
  (println "Clojure -> avector: " avector ", bvector: " bvector)
  )
```
>output
```console
Java values :  [hello, data, management]
Clojure -> avector:  [1 2 3 4 5] , bvector:  [1 2 3 4 5 10]
```
---
#### Import clojure namespace from another clojure namespace

> Given clojure utilities

```clojure
(ns day1.utilities)

(defn factorial [n]
  (reduce * (range 1 (inc n))))
```
> Clojure call

```clojure
(ns day1.clojureimport
  (:require [day1.utilities :as util]))

(defn -main                                                 ; main method (-) static
  "function documentation"
  []
  (println (util/factorial 7)))
```
---
#### Invoke clojure namespace from java

The public Java API for Clojure consists of the following classes and interfaces:

- clojure.java.api.Clojure

- clojure.lang.IFn

> Given clojure utilities

```clojure
(ns day1.utilities)

(defn factorial [n]
  (reduce * (range 1 (inc n))))
```
> Java invocation
```java
public static void main(String[] args) {
    IFn require = Clojure.var("clojure.core", "require");
    // Load the clojure name space
    require.invoke(Clojure.read("day1.utilities"));
    // Invoke the method
    IFn factorial = Clojure.var("day1.utilities", "factorial");
    System.out.println("Factorial of 7 : " + factorial.invoke(7));
}
```

---


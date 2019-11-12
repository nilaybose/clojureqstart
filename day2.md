#### Clojure method with multi-arity
- Clojure functions can support multiple arguments as overloaded functions

```clojure
(defn echo
  ([]
   "No arguments passed"
   )
  ([x]
   (str "input x = " x)
   )
  ([x y]
   (str "input x = " x ", y = " y)
   )
  ([x y & args]
   (str "input x = " x ", y = " y ", args = " args)
   )
  )

;private function
(defn- echop[]
  (println "private function invoked"))

(defn -main[]
  (println (echo))
  (println (echo 10))
  (println (echo 10 20))
  (println (echo 10 20 30 40 50)) ;
  (echop)
  )
```
> output
```console
No arguments passed
input x = 10
input x = 10, y = 20
input x = 10, y = 20, args = (30 40 50)
private function invoked
``` 
---

#### Data types with java arrays

- we can access java arrays from clojure
- using arrays will make code mutable, tread with caution

```clojure
(ns day2.datatypes
  (:import (java.util Arrays ArrayList)))

(defn -main
  "Object and numeric definitions"
  []
  (def x 2)
  (def y 10.4)
  (def z (Integer. 8))
  (def isSuccess? true)
  (def value nil)                                           ; nil is analogous to null in java

  (println "x : " x ", class - " (.getClass x))
  (println "y : " y ", class - " (.getClass y))
  (println "z : " z ", class - " (.getClass z))
  (println "z : " isSuccess? ", class - " (.getClass isSuccess?))

  ;define integer array in closure
  (println "----------------------------------- Primitive ARRAY ---------------------------------------")
  (def arr (int-array 5))                                   ; set an int array of size 5
  (aset arr 0 10)                                           ; set 0th index of array
  (aset arr 1 20)                                           ; set 1st index of array
  (println "Array class - " (.getClass arr))
  (println "arr[0] : " (aget arr 0))
  (println "arr[1] : " (aget arr 1))
  (println "arr[1] : " (nth arr 1))
  (println "arr    : " (Arrays/toString arr))               ; array of size 5 and 2,3,4th index not set

  ;define integer array in closure
  (println "----------------------------------- Object ARRAY ---------------------------------------")
  (def arr (object-array ["Hello", "Data", (new ArrayList), "Management"])) ; creates an object array
  (println "Array class - " (.getClass arr))
  (println "arr[0] : " (aget arr 0))
  (println "arr[1] : " (aget arr 1))
  (println "arr[2] : " (nth arr 2))
  (println "arr[3] : " (nth arr 3))
  (println "arr    : " (Arrays/toString arr))               ; array of size 5 and 2,3,4th index not set

  ;Access index exceeding array size will result in exception
  (try
    (aget arr 20)
    (catch Exception e (println "Accessing index of array of 20th - " (.getClass e))))
  )
```
> Output
```console
x :  2 , class -  java.lang.Long
y :  10.4 , class -  java.lang.Double
z :  8 , class -  java.lang.Integer
z :  true , class -  java.lang.Boolean
----------------------------------- Primitive ARRAY ---------------------------------------
Array class -  [I
arr[0] :  10
arr[1] :  20
arr[1] :  20
arr    :  [10, 20, 0, 0, 0]
----------------------------------- Object ARRAY ---------------------------------------
Array class -  [Ljava.lang.Object;
arr[0] :  Hello
arr[1] :  Data
arr[2] :  #object[java.util.ArrayList 0x2c4d1ac []]
arr[3] :  Management
arr    :  [Hello, Data, [], Management]
Accessing index of array of 20th -  java.lang.ArrayIndexOutOfBoundsException
```
---
#### Clojure - Atoms

- Atoms are a data type in Clojure that provide a way to manage shared, synchronous, independent state
- with validation support

|Operations|Description|
|-------|---|
|reset!|Sets the value of atom to a new value without regard for the current value|
|compare-and-set!|Atomically sets the value of atom to the new value if and only if the current value of the atom is identical to the old value held by the atom. Returns true if set happens, else it returns false.
|swap!|Atomically swaps the value of the atom with a new one based on a particular function.|

```clojure
(ns day2.demoatom
  (:require [day1.utilities :as util]))

(defn -main
  []
  (def myatom (atom 1))

  ; access atom
  (println "value of myatom - " @myatom)

  ; (compare-and-set! atom-name oldvalue newvalue)
  (compare-and-set! myatom 0 3)
  (println "value not changed to 3 as initial value is not 0, myatom - " @myatom)
  (compare-and-set! myatom 1 3)
  (println "value changed as initial value was 1, myatom - " @myatom)

  ;reset (don't care of values)
  (reset! myatom 20)
  (println "value of myatom after reset - " @myatom)

  ;swap the value of atom with a function
  (swap! myatom inc)
  (println "value of myatom after swap with inc - " @myatom)
  (swap! myatom (fn [n] (* n 2)))                           ; function which multiplies by 2
  (println "value of myatom after swap with function - " @myatom)

  ; example of atom of a string
  (def str1 (atom "hello data management"))
  (swap! str1 (fn [n] (.toUpperCase n)))
  (println "New value of str : " @str1)

  ;Set atom to its factorial
  (def num1 (atom 7))
  (swap! num1 util/factorial)
  (println "New value of num : " @num1)

  ; validator with atom
  (def num2 (atom 2 :validator even?))
  (try
     (reset! num2 3)
     (catch Exception e (println "even validation failed, while setting odd num to atom - " (.toString e))))

  (def str2 (atom "We love clojure" :validator (fn [n] (.startsWith n "We"))))
  (try
    (reset! str2 "abc")
    (catch Exception e (println "String validation failed, while setting str2 - " (.toString e))))
  )
```
>Output
```console
value of myatom -  1
value not changed to 3 as initial value is not 0, myatom -  1
value changed as initial value was 1, myatom -  3
value of myatom after reset -  20
value of myatom after swap with inc -  21
value of myatom after swap with function -  42
New value of str :  HELLO DATA MANAGEMENT
New value of num :  5040
even validation failed, while setting odd num to atom -  java.lang.IllegalStateException: Invalid reference state
String validation failed, while setting str2 -  java.lang.IllegalStateException: Invalid reference state
```

#### Loop

- while loop

```clojure
(while(expression)
   (do
      codeblock))
```

```clojure
(defn sum 
  "Return sum of numbers up to n"
  [n]
  (def index (atom 1))
  (def res (atom 0))
  (while ( <= @index n)
    (do
      (swap! res (fn [res] (+ res @index)))
      (swap! index inc)
      ))
    @res
  )

(defn -main
  []
  (println "sum of numbers up to 100 : " (sum 100)) ;5050
  (println "sum of numbers up to 10 : " (sum 10))   ;55
  )
```

- The **‘doseq’** statement is similar to the ‘for each’ statement which is found in many other programming languages. The doseq statement is basically used to iterate over a sequence.

```clojure
(doseq (sequence)
   statement#1)
```

```clojure
(defn seqloop []
  (def arr (object-array ["Hello", "Data", "Management"])) ; creates an object array
  (doseq [n arr]
    (println "Seq loop iterating array -> " n)))
```

- **dotimes**  is used to execute a statement ‘x’ number of times.

```clojure
(defn dotimesloop [n]
  (dotimes [x n]
    (println "in do times loop -> " x)))
```

- Loop statement - not exact a for loop but sets the recursion point

```clojure
loop [binding]
(condition
   (statement)
   (recur (binding)))
```

```clojure
(defn loopsum
  "Return sum of numbers up to n"
  [n]
  (def res (atom 0))
  (loop [index 1]
    (if (<= index n)
      (do (swap! res (fn [res] (+ res index)))
          (recur (inc index))))
    )
  @res
  )
```
---

#### Conditional statements

- if, if/do, case, when, cond

```clojure
(defn -main []
  ;; if
  (if (even? 5)
    (println "5 is even")                                   ; for if success
    (println "5 is odd")                                    ; for if failure
    )

  ; if/do
  (if (and (even? 10) (even? 12))
    (do (println "10 && 12 are even")
        (println "I told 10 && 12 are  even"))              ; for if success
    (do (println "10 is odd"))                              ; for if failure
    )

  ;condition
  (def x 11)
  (cond
    (= x 5) (do (println "x is 5") (println "see x is 5"))
    (= x 10) (do (println "x is 10") (println "see x is 10"))
    :else (do (println "x is not 5") (println "x is not 10"))
    )

  ;when
  (when (even? 20)
    (println "20 is even"))

  ;case
  (def x 10)
  (case x 5 (do(println "x is 5"))
          10 (do (println "x is 10") (println "x is 10, i told you"))
          (println "x is neither 5 nor 10"))

  )

```
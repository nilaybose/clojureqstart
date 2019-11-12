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

(ns day2.multiairty)

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

; Return function
(defn fret []
  (fn[x y] (+ x y)))

; Return function with operator (operator in clojure is actual function)
(defn fretops [ops]
  (fn[x y] (ops x y)))

(defn -main[]
  (println (echo))
  (println (echo 10))
  (println (echo 10 20))
  (println (echo 10 20 30 40 50))
  (echop)

  ; anonymous function
  (def funn (fn [x y] (+ x y)))
  (println "anonymous function 1 - " (funn 3 4))
  (println "anonymous return function 2 - " ((fret) 5 6 ))
  (println "anonymous return function with ops(+ 5 6) - " ((fretops +) 5 6 ))
  (println "anonymous return function with ops(rem 20 19) - " ((fretops rem) 20  17 ))


  ; writing function using reader macro
  (def func1 #(%1 %2 %3))
  (println "anonymous function using reader macro - " (func1 - 4 7))
  )





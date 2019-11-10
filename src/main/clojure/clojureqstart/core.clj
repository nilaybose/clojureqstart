(ns clojureqstart.core)

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


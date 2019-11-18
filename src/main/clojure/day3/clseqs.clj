(ns day3.clseqs)

(defn -main
"Clojure Immutable Data Structures"
[]
  (println (first (list 1 2 3)))                            ; 1
  (println (last (list 1 2 3)))                             ; 3
  (println (rest (list 1 2 3)))                             ; ( 2 3 )

  (println (map inc [ 1 2 3 4 5]))                          ; (2 3 4 5 6)

  (println (map inc (list 1 2 3 4 5)))                      ; (2 3 4 5 6)

  (println (reduce + (list 1 2 3 4 5)))                     ; 10
  )
(ns day3.clvectors)

(defn -main
"Clojure Immutable Data Structures"
[]
  (def v [ 1 2 3 4 5 6])                                    ; vector
  (println v)

  (println (assoc v 0 10))                                  ; replace 0th index with 10, [10 2 3 4 5 6]

  (println (conj v 20))                                     ; [1 2 3 4 5 6 20]

  (println (get v 0))                                       ; 10

  (println (get v 100))                                     ; nil, no exception

  (println (nth v 0))                                       ; 10

  (try(println (nth v 100)) (catch Exception e (println (class e))))    ; nil, java.lang.IndexOutOfBoundsException
 )
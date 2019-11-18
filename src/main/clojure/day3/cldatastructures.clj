(ns day3.cldatastructures)

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

  ;; MAPS

  (def map1 {:a 5 :b 6 :c 7})

  (println map1)                                            ;{:a 5, :b 6, :c 7}

  (println (assoc map1 :d 10))                              ;{:a 5, :b 6, :c 7, :d 10}

  (println (assoc map1 :a 10))                              ;{:a 10, :b 6, :c 7}

  (println (update map1 :a inc))                            ;{:a 6, :b 6, :c 7}

  (println (update map1 :a #(+ 2 %)))                       ;{:a 7, :b 6, :c 7}

  (println (keys map1))                                     ;(:a :b :c)

  (println (class (keys map1)))                             ;clojure.lang.APersistentMap$KeySeq

  (println (vals map1))                                     ;(5 6 7)

  ;key of a map can be used as function

  (println (:a map1))                                       ; 5
  (println (map1 :a))                                       ; 5
  (println (get map1 :a))                                   ; 5

  ;; Nested MAPS
  (def user {:name "John" :salary 1000 :address { :city "Bangalore" :state "KA"}})

  ; How to get salary
  (println (:city (:address user)))                         ; Bangalore



  )
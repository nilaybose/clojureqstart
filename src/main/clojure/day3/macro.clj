(ns day3.macro)

(defn -main
"Object and numeric definitions"
[]
  (println (-> 2 (- 3)))                                      ; -1
  (println (- 2 3))                                           ; -1
  (println (-> 2 (- 3) (- 4) (- 5)))                          ; -10
  (println (-(- (- 2 3) 4) 5))                                ; -10

  (println (->> 2 (- 3)))                                     ; 1
  (println (- 3 2))                                           ; 1
  (println (->> 2 (- 3) (- 4) (- 5)))                         ; 2
  (println (- 5 (- 4 (- 3 2))) )                              ; 2

  (println (reduce * (range 1 (inc 6))))                      ; factorial 6 (720)
  (println (->> (inc 6) (range 1) (reduce *)))                ; factorial 6 (720)
  )

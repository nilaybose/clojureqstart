(ns day2.loops)

(defn sum [n]
  (def index (atom 1))
  (def res (atom 0))
  (while ( <= @index n)
    (do
      (swap! res (fn [res] (+ res @index)))
      (swap! index inc)
      ))
    @res
  )

(defn seqloop []
  (def arr (object-array ["Hello", "Data", "Management"])) ; creates an object array
  (doseq [n arr]
    (println "Seq loop iterating array -> " n)))

(defn dotimesloop [n]
  (dotimes [x n]
    (println "in do times loop -> " x)))


(defn -main
  []
  (println "while loop -> sum of numbers up to 100 : " (sum 100))
  (println "while loop -> sum of numbers up to 10 : " (sum 10))
  (seqloop)
  (dotimesloop 5)
  )

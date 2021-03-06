(ns day2.loops)

(defn whileloopsum [n]
  (def index (atom 1))
  (def res (atom 0))
  (while (<= @index n)
    (do
      (swap! res (fn [res] (+ res @index)))
      (swap! index inc)
      ))
  @res
  )

(defn whileloopsumiop [n]
  (def index (int-array [1]))
  (def res (int-array [0]))
  (while (<= (aget index 0) n)
    (do
        (aset res 0 (+ (aget res 0) (aget index 0)))
        (aset index 0 (+ (aget index 0) 1))
      ))
  (aget res 0)
  )

(defn smartsum [n]
  (reduce + (range 1 (inc n))))

(defn seqloop []
  (def arr (object-array ["Hello", "Data", "Management"]))  ; creates an object array
  (doseq [n arr]
    (println "Seq loop iterating array -> " n)))

(defn dotimesloop [n]
  (dotimes [x n]
    (println "in do times loop -> " x)))

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

(defn example []
  (def x 5)
  (cond
    (= x 5) (do (println "x is 5")(println "x is 5"))
    (= x 10)(println "x is 10")
    :else (println "x is not defined")))


(defn -main
  []
  (println "while loop -> sum of numbers up to 100 : " (whileloopsum 100))
  (println "while loop -> sum of numbers up to 10 : " (whileloopsum 10))
  (println "while loop -> sum of numbers up to 10 with java inter-op: " (whileloopsumiop 10))
  (println "Smart way -> sum of numbers up to 10: " (smartsum 10))
  (seqloop)
  (dotimesloop 5)
  (println "loop -> sum of numbers up to 100 : " (loopsum 100))
  (println "loop -> sum of numbers up to 10 : " (loopsum 10))
  )

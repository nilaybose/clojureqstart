(ns day4.defrecords)

(defrecord DataPointWithImpl [x, y]
  Object
  (toString [this] (str "DataPointWithImpl - [x: " x ", y: " y "]"))
  Comparable
  (compareTo [this object]
    (- (+ x y) (+ (.x object) (.y object)))))

(defn -main []
  (def data1 (->DataPointWithImpl 5 10))
  (def data2 (DataPointWithImpl. 15 10))
  (def data3 (DataPointWithImpl. 109 10))

  (println "---------------- Sorting ----------------------")

  (def result ( sort [data2 data1 data3]))
  (doseq [data result]
    (println (.toString data)))

  (println (:x data1))                                      ;5
  (println (.x data1))                                      ;5
  (println (get data1 :x))                                  ;5
  (println (get-in  data1 [:x]))                            ;5


  (println (vals (assoc data1 :z 20)))                                    ;5, 10, 20
)

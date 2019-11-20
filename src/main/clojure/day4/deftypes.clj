(ns day4.deftypes)

(deftype DataPoint [x, y])

(deftype DataPointWithImpl [x, y]
  Object
  (toString [this] (str "DataPointWithImpl - [x: " x ", y: " y "]"))
  Comparable
  (compareTo [this object]
    (- (+ x y) (+ (.x object) (.y object)))))

(defn -main []
  (def data1 (->DataPoint 5 10))
  (def data2 (DataPoint. 5 10))

  (println "Data 1 - [x: " (.x data1) ", y: " (.y data1) "]")
  (println "Data 2 - [x: " (.x data1) ", y: " (.y data1) "]")


  (def data1 (->DataPointWithImpl 5 10))
  (def data2 (DataPointWithImpl. 15 10))
  (def data3 (DataPointWithImpl. 109 10))

  (println (.toString data1))                               ;DataPointWithImpl - [x: 5, y: 10]

  (println "---------------- Sorting ----------------------")

  (def result ( sort [data2 data1 data3]))
  (doseq [data result]
    (println (.toString data)))
)

#### Define Protocols

- Protocol is defined by the 'defprotocol' macro and defines the method templates
- reify is used to create anonymous data types implementing multiple protocols or java interfaces

```clojure
(ns day4.protocol
  (:gen-class)
  (:import (day4 JVehicle)))

(defprotocol Vehicle
  (move [this])
  (make [this])
  (vname [this]))

(defprotocol Fleet
  (show [this]))

(defn -main []
  (def anon (reify
              Vehicle
              (move [this] "Drive")
              (vname [this] "Honda")
              (make [this] "2019")
              JVehicle
              (jDrive [this] "Java Vehicle")
              Fleet
              (show [this] (str "Fleet: " (.vname this)
                                ", make - "  (.make this) ", move - " (.move this) ", type - " (.jDrive this)) )

              ))

  (println  (.show anon))                                   ;Fleet: Honda, make - 2019, move - Drive
```

#### Extend Protocol
- Extend a protocol makes the data type participating in the protocol

```clojure
(ns day4.extprotocol
  (:import (day4 DemoExtProtocol)))

(defprotocol Vehicle
  (move [this]))

(defprotocol Display
  (show [this]))

(extend-type DemoExtProtocol
  Vehicle
  (move [this] "Moving with extend type"))

(extend-protocol Display
  DemoExtProtocol
  (show [this] "Showing with extend type"))

(defn -main []
  (def demo (DemoExtProtocol.))
  (println (move demo)) ;Moving with extend type
  (println (show demo)) ;Showing with extend type
  )
```

#### Def Types

- Java bare metal class
- Implement interfaces

```clojure
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
```

> Output

```console
Data 1 - [x:  5 , y:  10 ]
Data 2 - [x:  5 , y:  10 ]
DataPointWithImpl - [x: 5, y: 10]
---------------- Sorting ----------------------
DataPointWithImpl - [x: 5, y: 10]
DataPointWithImpl - [x: 15, y: 10]
DataPointWithImpl - [x: 109, y: 10]
```

#### Def Records
- Data structure backed by map

```clojure
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

```




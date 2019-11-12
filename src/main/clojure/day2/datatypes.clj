(ns day2.datatypes
  (:import (java.util Arrays ArrayList)))

(defn -main
  "Object and numeric definitions"
  []
  (def x 2)
  (def y 10.4)
  (def z (Integer. 8))
  (def isSuccess? true)
  (def value nil)                                           ; nil is analogous to null in java

  (println "x : " x ", class - " (.getClass x))
  (println "y : " y ", class - " (.getClass y))
  (println "z : " z ", class - " (.getClass z))
  (println "z : " isSuccess? ", class - " (.getClass isSuccess?))

  ;define integer array in closure
  (println "----------------------------------- Primitive ARRAY ---------------------------------------")
  (def arr (int-array 5))                                   ; set an int array of size 5
  (aset arr 0 10)                                           ; set 0th index of array
  (aset arr 1 20)                                           ; set 1st index of array
  (println "Array class - " (.getClass arr))
  (println "arr[0] : " (aget arr 0))
  (println "arr[1] : " (aget arr 1))
  (println "arr[1] : " (nth arr 1))
  (println "arr    : " (Arrays/toString arr))               ; array of size 5 and 2,3,4th index not set

  ;define integer array in closure
  (println "----------------------------------- Object ARRAY ---------------------------------------")
  (def arr (object-array ["Hello", "Data", (new ArrayList), "Management"])) ; creates an object array
  (println "Array class - " (.getClass arr))
  (println "arr[0] : " (aget arr 0))
  (println "arr[1] : " (aget arr 1))
  (println "arr[2] : " (nth arr 2))
  (println "arr[3] : " (nth arr 3))
  (println "arr    : " (Arrays/toString arr))               ; array of size 5 and 2,3,4th index not set

  ;Access index exceeding array size will result in exception
  (try
    (aget arr 20)
    (catch Exception e (println "Accessing index of array of 20th - " (.getClass e))))
  )
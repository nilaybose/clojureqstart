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
)

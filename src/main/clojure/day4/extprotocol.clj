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
  (println (move demo))
  (println (show demo))
  )

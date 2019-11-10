(ns clojureqstart.utilities)

(defn factorial [n]
  (reduce * (range 1 (inc n))))

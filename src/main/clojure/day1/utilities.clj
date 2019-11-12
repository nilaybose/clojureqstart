(ns day1.utilities)

(defn factorial [n]
  (reduce * (range 1 (inc n))))

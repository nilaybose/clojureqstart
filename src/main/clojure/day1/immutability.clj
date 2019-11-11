(ns day1.immutability
  (:import (java.util ArrayList Arrays)))

(defn -main                                                 ; main method (-) static
  "function documentation"
  []                                                        ; arguments
  ;; Test if Java Inter-op is immutable
  (def alist (doto (ArrayList.) (.add "hello")))
  ; add operation
  (doto alist (.add "data") (.add "management"))
  (println "Java values : " (.toString alist))

  ;; Clojure equivalent
  (def avector [ 1 2 3 4 5])
  (def bvector (conj avector 10))
  (println "Clojure -> avector: " avector ", bvector: " bvector)
  )

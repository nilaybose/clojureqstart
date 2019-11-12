(ns day2.multiairty)

(defn echo
  ([]
   "No arguments passed"
   )
  ([x]
   (str "input x = " x)
   )
  ([x y]
   (str "input x = " x ", y = " y)
   )
  )

(defn -main[]
  (println (echo))
  (println (echo 10))
  (println (echo 10 20))
  )





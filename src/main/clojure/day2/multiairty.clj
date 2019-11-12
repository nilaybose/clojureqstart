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
  ([x y & args]
   (str "input x = " x ", y = " y ", args = " args)
   )
  )

;private function
(defn- echop[]
  (println "private function invoked"))

(defn -main[]
  (println (echo))
  (println (echo 10))
  (println (echo 10 20))
  (println (echo 10 20 30 40 50))
  (echop)
  )





(ns day2.exceptionhandling)

(defn -main []
  (try
      (/ 1 0)
      (catch RuntimeException e
        (println "Runtime Exception handled " (class e))
        )
     (catch Exception e
       (println "Exception handled " (class e))
       )
      (finally (println "out of errors"))
     )
  )
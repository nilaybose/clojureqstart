(ns day2.democond)

(defn -main []
  ;; if
  (if (even? 5)
    (println "5 is even")                                   ; for if success
    (println "5 is odd")                                    ; for if failure
    )

  ; if/do
  (if (and (even? 10) (even? 12))
    (do (println "10 && 12 are even")
        (println "I told 10 && 12 are  even"))              ; for if success
    (do (println "10 is odd"))                              ; for if failure
    )

  ;condition
  (def x 11)
  (cond
    (= x 5) (do (println "x is 5") (println "see x is 5"))
    (= x 10) (do (println "x is 10") (println "see x is 10"))
    :else (do (println "x is not 5") (println "x is not 10"))
    )

  ;when
  (when (even? 20)
    (println "20 is even"))

  ;case
  (def x 10)
  (case x 5 (do(println "x is 5"))
          10 (do (println "x is 10") (println "x is 10, i told you"))
          (println "x is neither 5 nor 10"))

  )

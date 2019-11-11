(ns day1.multiparamfunc)

(defn -main                                                 ; main method (-) static
  "function documentation"
  []                                                        ; arguments
  (println (.toUpperCase "hello world"))                    ; HELLO WORLD, preferred way
  (println (. "hello world" toUpperCase ))                  ; HELLO WORLD

  (println (. "hello world" substring 0 5 ))                ; hello
  (println (.substring "hello world" 0 5))                  ; hello

  ;; Chaining
  (println (.toString (.reverse (StringBuilder. "Data Management")))) ; tnemeganaM ataD
  (println (.. (StringBuilder. "Data management") reverse toString toUpperCase)) ;TNEMEGANAM ATAD
  (println (.. (StringBuilder. "Data management") reverse toString toUpperCase (substring 0 10))) ;TNEMEGANAM
  )

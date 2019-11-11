(ns day1.javainterop
  (:import (javaiopt Demointerop)))

(defn -main                                                 ; main method (-) static
  "function documentation"
  []                                                        ; arguments
  (println (. Math PI))                                     ; 3.141592653589793, static field invocation
  (println Math/PI)                                         ; 3.141592653589793, static field invocation
  (println (. System currentTimeMillis))                    ; static method
  (println (System/currentTimeMillis))                      ; static method

  ;; custom java objects
  (println "Demointerop class variable: " (Demointerop/TOTAL))  ; custom java object static field

  ;; custom instance creation and method invocation
  (def demo (new Demointerop))
  (. demo callDemo)
  (println "Object hash : " (.hashCode demo))

  ;; custom instance creation and method invocation, alternative approach
  (def demo (Demointerop.))
  (.callDemo demo)
  (println "Object hash : " (.hashCode demo))

  ;;instance method field invocation
  (println "Demo instance field: " (.-itotal demo))
)



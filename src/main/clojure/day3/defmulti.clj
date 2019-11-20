(ns day3.defmulti)

(defmulti userinfo :state :default "*")

(defmethod userinfo "KA" [user]
  (println "State KA"))

(defmethod userinfo "WB" [user]
  (println "State WB"))

(defmethod userinfo "*" [user]
  (println "State Others"))

;;Class type test
(defmulti classtest class :default "*")
(defmethod classtest Long [data]
  (println "Long"))
(defmethod classtest Double [data]
  (println "Double"))

;; multi method selection based on multiple attributes
(defmulti userselection (fn [user] [(:state user) (:lang user)]) :default "*")

(defmethod userselection ["KA" "French"] [user]
  (println "State KA, French speaker"))

(defmethod userselection ["WB" "English"] [user]
  (println "State WB, English speaker"))

(defmethod userselection "*" [user]
  (println "State/ user Others"))


(defn -main []
  (userinfo {:name "user1" :state "WB"})                    ;State WB
  (userinfo {:name "user2" :state "KA" })                   ;State KA
  (userinfo {:name "user3" :state "TN"})                    ;State Others

  (classtest 1)                                             ;Long
  (classtest 1.1)                                           ;Double

  (userselection {:name "user1" :state "WB" :lang "English"})
  (userselection {:name "user1" :state "KA" :lang "French"})
)

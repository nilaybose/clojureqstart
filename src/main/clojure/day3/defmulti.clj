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

(defn -main []
  (userinfo {:name "user1" :state "WB"})                    ;State WB
  (userinfo {:name "user1" :state "KA"})                    ;State KA
  (userinfo {:name "user1" :state "TN"})                    ;State Others

  (classtest 1)                                             ;Long
  (classtest 1.1)                                           ;Double
)

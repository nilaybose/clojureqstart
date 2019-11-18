#### Threading macros

- What the thread-first (->) macro does is take the first argument supplied and place it in
  the second position of the next expression.

- The thread-last macro (named ->>) -  Instead of
  taking the first expression and moving it into the second position of the next expression,
  it moves it into the last place.
  
```clojure
  (println (-> 2 (- 3)))                                      ; -1
  (println (- 2 3))                                           ; -1
  (println (-> 2 (- 3) (- 4) (- 5)))                          ; -10
  (println (-(- (- 2 3) 4) 5))                                ; -10

  (println (->> 2 (- 3)))                                     ; 1
  (println (- 3 2))                                           ; 1
  (println (->> 2 (- 3) (- 4) (- 5)))                         ; 2
  (println (- 5 (- 4 (- 3 2))) )                              ; 2

  (println (reduce * (range 1 (inc 6))))                      ; factorial 6 (720)
  (println (->> (inc 6) (range 1) (reduce *)))                ; factorial 6 (720)
```

#### Data Structures

- vectors

```clojure
  (def v [ 1 2 3 4 5 6])                                    ; vector
  (println v)

  (println (assoc v 0 10))                                  ; replace 0th index with 10, [10 2 3 4 5 6]

  (println (conj v 20))                                     ; [1 2 3 4 5 6 20]

  (println (get v 0))                                       ; 10

  (println (get v 100))                                     ; nil, no exception

  (println (nth v 0))                                       ; 10

  (println (nth v 100))                                     ; nil, java.lang.IndexOutOfBoundsException
```

[Read vector, list conj and cons](https://medium.com/@greg_63957/conj-cons-concat-oh-my-1398a2981eab)

- Maps

```clojure
  (def map1 {:a 5 :b 6 :c 7})

  (println map1)                                            ;{:a 5, :b 6, :c 7}

  (println (assoc map1 :d 10))                              ;{:a 5, :b 6, :c 7, :d 10}

  (println (assoc map1 :a 10))                              ;{:a 10, :b 6, :c 7}

  (println (update map1 :a inc))                            ;{:a 6, :b 6, :c 7}

  (println (update map1 :a #(+ 2 %)))                       ;{:a 7, :b 6, :c 7}

  (println (keys map1))                                     ;(:a :b :c)

  (println (class (keys map1)))                             ;clojure.lang.APersistentMap$KeySeq

  (println (vals map1))                                     ;(5 6 7)

  ;key of a map can be used as function

  (println (:a map1))                                       ; 5
  (println (map1 :a))                                       ; 5
  (println (get map1 :a))                                   ; 5

  ;; Nested MAPS
  (def user {:name "John" :salary 1000 :address { :city "Bangalore" :state "KA"}})
  ; How to get salary
  (println (:city (:address user)))                         ; Bangalore
  (println (get-in user [:address :city]))                  ; Bangalore

  (println (assoc-in user [:address :city] "Mysore"))       ;{:name John, :salary 1000, :address {:city Mysore, :state KA}}

  (println (update-in user [:address :city] #(.toUpperCase %))) ;    {:name John, :salary 1000, :address {:city BANGALORE, :state KA}}
```  
##### Sequences
- Sequences - A sequence isn’t a collection type. Rather, a sequence is an interface (called ISeq) that
exposes a “one thing followed by more things” abstraction.

- The ISeq interface provides three functions: first, rest, and cons.

```clojure
  (println (first (list 1 2 3)))                            ; 1
  (println (last (list 1 2 3)))                             ; 3
  (println (rest (list 1 2 3)))                             ; ( 2 3 )

  (println (map inc [ 1 2 3 4 5]))                          ; (2 3 4 5 6)

  (println (map inc (list 1 2 3 4 5)))                      ; (2 3 4 5 6)

  (println (reduce + (list 1 2 3 4 5)))                     ; 10
```

##### Multi method

```clojure
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

```
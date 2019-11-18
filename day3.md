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

  
  
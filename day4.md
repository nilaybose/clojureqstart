#### Define Protocols

- Protocol is defined by the 'defprotocol' macro and defines the method templates
- reify is used to create anonymous data types implementing multiple protocols or java interfaces

```clojure
(defprotocol Vehicle
  (move [this])
  (make [this])
  (vname [this]))

(defprotocol Fleet
  (show [this]))

(defn -main []
  (def anon (reify
              Vehicle
              (move [this] "Drive")
              (vname [this] "Honda")
              (make [this] "2019")
              Fleet
              (show [this] (str "Fleet: " (.vname this) ", make - " (.make this) ", move - " (.move this)))
              ))

  (println  (.show anon)) ;;Fleet: Honda, make - 2019, move - Drive
```
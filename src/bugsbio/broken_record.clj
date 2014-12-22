(ns bugsbio.broken-record
  (:refer-clojure :exclude [defrecord])
  (:require [camel-snake-kebab.core :refer [kebab-case]]))

(defmacro defrecord
  "A slightly enhanced version of Clojure's defrecord, which also
  provides a constructor `new-record-name` which takes zero or more
  key value pairs."
  [record-name fields & body]
  (let [constructor (symbol (str "new-"  (kebab-case (name record-name))))
        map->record (symbol (str "map->" (name record-name)))]
    `(do
       (clojure.core/defrecord ~record-name ~fields ~@body)
       (defn ~constructor [& kvs#]
         (~map->record (apply hash-map kvs#))))))

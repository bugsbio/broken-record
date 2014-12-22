(ns bugsbio.broken-record-test
  (:require [bugsbio.broken-record :as r]
            [expectations          :refer :all]))

(r/defrecord CantaloupeAntelope [name melon-or-mammal?])

;; r/defrecord creates a normal defrecord, but with an extra varargs constructor
(expect record?
        (CantaloupeAntelope. "Terry" :melon))

(expect (CantaloupeAntelope. "Jerry" :mammal)
        (new-cantaloupe-antelope :name "Jerry" :melon-or-mammal? :mammal))

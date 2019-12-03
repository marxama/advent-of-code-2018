(ns advent-of-code-2018.day01
  (:require [clojure.string :as string]))

(defn parse-input []
  (->> "resources/day01_input"
       slurp
       string/split-lines
       (map read-string)))

(defn solve-part-1 []
  (reduce + (parse-input)))

(defn solve-part-2 []
  (->> (parse-input)
       cycle
       (reductions +)
       (reduce (fn [r frequency]
                 (if (r frequency)
                   (reduced frequency)
                   (conj r frequency)))
               #{})))

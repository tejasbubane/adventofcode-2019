(ns adventofcode-2019.day4
  (:gen-class))

;; Part 1
(defn pairs [digits]
  (partition 2 1 digits))

(defn digits [number]
  (map #(Character/digit % 10) (str number)))

(defn has-same-adjacent [digits]
  (some (fn [[a b]] (= a b)) digits))

(defn non-decreasing [digits]
  (every? (fn [[a b]] (<= a b)) digits))

(defn possible-passwords [start end]
  (filter (fn [num]
            (let [ds (pairs (digits num))]
              (and (non-decreasing ds) (has-same-adjacent ds))))
          (range start (inc end))))

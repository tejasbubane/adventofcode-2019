(ns adventofcode-2019.day4
  (:gen-class))

;; Part 1
(defn digits [number]
  (map #(Character/digit % 10) (str number)))

(defn has-same-adjacent [digits]
  (and (>= (count digits) 2)
       (or (= (first digits) (first (rest digits)))
           (has-same-adjacent (rest digits)))))

(defn non-decreasing [digits]
  (or (empty? digits)
      (= (count digits) 1)
      (and (<= (first digits) (first (rest digits)))
           (non-decreasing (rest digits)))))

(defn possible-passwords [start end]
  (filter (fn [num]
            (let [ds (digits num)]
              (and (non-decreasing ds) (has-same-adjacent ds))))
          (range start (inc end))))

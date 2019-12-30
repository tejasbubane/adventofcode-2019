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

(defn- all-pairs [digits]
  (filter (fn [[a b]] (= a b)) digits))

(defn- not-part-of-larger-group [digits]
  (some (fn [[d c]] (= c 1)) (seq (frequencies (all-pairs digits)))))

(defn possible-passwords-2 [start end]
  (filter (fn [num]
            (let [ds (pairs (digits num))]
              (and (non-decreasing ds)
                   (not-part-of-larger-group ds))))
          (range start (inc end))))

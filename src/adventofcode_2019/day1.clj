(ns adventofcode-2019.day1
  (:gen-class))

(defn fuel [mass]
  (- (quot mass 3) 2))

(defn total-fuel [& masses]
  (apply + (map fuel masses)))

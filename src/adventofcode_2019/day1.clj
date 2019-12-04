(ns adventofcode-2019.day1
  (:gen-class))

;; part 1
(defn fuel [mass]
  (- (quot mass 3) 2))

(defn total-fuel [& masses]
  (apply + (map fuel masses)))

;; part 2
(defn fuel-of-fuel [mass]
  (apply + (drop 1 (take-while pos? (iterate fuel mass)))))

(defn total-fuel-of-fuel [& masses]
  (apply + (map fuel-of-fuel masses)))

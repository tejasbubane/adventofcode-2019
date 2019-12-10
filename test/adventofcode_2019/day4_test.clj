(ns adventofcode-2019.day4-test
  (:require [clojure.test :refer :all]
            [adventofcode-2019.day4 :refer :all]))

;; Part 1
(deftest test-has-same-adjacent
  (testing "1 2 1" (is (not (has-same-adjacent '(1 2 1)))))
  (testing "2 2" (is (has-same-adjacent '(2 2))))
  (testing "1 3 3 1 2" (is (has-same-adjacent '(1 3 3 1 2))))
  (testing "1 3 4 5 6 4" (is (not (has-same-adjacent '(1 3 4 5 6 4))))))

(deftest test-non-decreasing
  (testing "1 2 1" (is (not (non-decreasing '(1 2 1)))))
  (testing "2 2" (is (non-decreasing '(2 2))))
  (testing "1 3 8 9" (is (non-decreasing '(1 3 8 9)))))

(deftest test-puzzle-input
  (testing "with puzzle input"
    (is (= (count (possible-passwords 134564 585159)) 1929))))

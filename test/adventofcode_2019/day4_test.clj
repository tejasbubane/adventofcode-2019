(ns adventofcode-2019.day4-test
  (:require [clojure.test :refer :all]
            [adventofcode-2019.day4 :refer :all]))

;; Part 1
(deftest test-has-same-adjacent
  (testing "1 2 1" (is (not (has-same-adjacent (pairs '(1 2 1))))))
  (testing "2 2" (is (has-same-adjacent (pairs '(2 2)))))
  (testing "1 3 3 1 2" (is (has-same-adjacent (pairs '(1 3 3 1 2)))))
  (testing "1 3 4 5 6 4" (is (not (has-same-adjacent (pairs '(1 3 4 5 6 4)))))))

(deftest test-non-decreasing
  (testing "1 2 1" (is (not (non-decreasing (pairs '(1 2 1))))))
  (testing "2 2" (is (non-decreasing (pairs '(2 2)))))
  (testing "1 3 8 9" (is (non-decreasing (pairs '(1 3 8 9))))))

(deftest test-puzzle-input
  (print "Part 1: ")
  (time (testing "with puzzle input - part 1"
          (is (= (count (possible-passwords 134564 585159)) 1929)))))

(deftest test-puzzle-input
  (print "Part 2: ")
  (time (testing "with puzzle input - part 2"
          (is (= (count (possible-passwords-2 134564 585159)) 1306)))))

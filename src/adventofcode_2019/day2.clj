(ns adventofcode-2019.day2
  (:gen-class))

(defn run-instruction [opcode pos1 pos2 pos3 state]
  (let [x (get state pos1)
        y (get state pos2)
        result (case opcode
                   1 (+ x y)
                   2 (* x y))]
    (assoc state pos3 result)))

(defn process [start-index state]
  (let [opcode (get state start-index)
        pos1 (get state (+ start-index 1))
        pos2 (get state (+ start-index 2))
        pos3 (get state (+ start-index 3))]
    (if (= opcode 99)
      (get state 0)
      (process (+ start-index 4)
               (run-instruction opcode pos1 pos2 pos3 state)))))

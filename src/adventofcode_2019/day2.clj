(ns adventofcode-2019.day2
  (:gen-class))

;; Part 1
(defn- run-instruction [opcode pos1 pos2 pos3 state]
  (let [x (get state pos1)
        y (get state pos2)
        result (case opcode
                   1 (+ x y)
                   2 (* x y))]
    (assoc state pos3 result)))

(defn- process [state start-index]
  (let [opcode (get state start-index)
        pos1 (get state (+ start-index 1))
        pos2 (get state (+ start-index 2))
        pos3 (get state (+ start-index 3))]
    (if (= opcode 99)
      (get state 0)
      (process (run-instruction opcode pos1 pos2 pos3 state)
               (+ start-index 4)))))

(defn execute [state input-1 input-2]
  (process (assoc (assoc state 1 input-1) 2 input-2) 0))

;; Part 2
(def moon-figure 19690720)

(defn- moonshot? [state tuple]
  (= moon-figure (execute state (first tuple) (last tuple))))

(defn find-pair [state]
  (let [pairs (for [x (range 0 100)
                    y (range 0 100)]
                [x y])
        result (first (drop-while
                       #(not (moonshot? state %1))
                       pairs))]
    (+ (* 100 (first result)) (second result))))

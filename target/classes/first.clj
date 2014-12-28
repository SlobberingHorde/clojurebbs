(ns first)

(defn basic-item-total [price quantity]
  "Calculates the price times the quantity"
  (* price quantity))

(defn with-line-item-conditions [f price quantity]
  {:pre [(> price 0) (> quantity 0)]
   :post [(> % 1)]}
    "Validates price and quatity values are greater than 0 and that the return value is greater than 1"
  (apply f price quantity))

(defn total-cost 
  "Multimethod for handling costs for arities of one and two"
  ([item-cost number-of-items]
    (* item-cost number-of-items))
  ([item-cost]
    (* item-cost 1)))

(defn total-all-numbers [ & numbers]
  "Variadic function taking varying number of arguments"
  (apply + numbers))

(defn count-down [n]
 "Recursive function that can easily blow the stack when the number is too big"
 (if-not (zero? n)
   (do
     (if (= 0 (rem n 100))
       (println "count down" n))
     (count-down (dec n)))))

(defn count-downr [n]
  "Recursive style function that won't blow the stack"
  (if-not (zero? n)
    (do
      (if (= 0 (rem n 100))
        (println "count downr" n))
      (recur (dec n)))))

(def bools [true true true false false])
(every? true? bools)
;; this returns false since not every element in bools is true

(some true? bools)
;; this returns true because some of the bools are true

(defn above-threshold? [threshold number]
  (> number threshold))

(filter (fn [x] (above-threshold? 5 x)) [1 2 3 4 5 6 7])
;; returns 6 7 becuase the filter function removes the 1 - 5

(filter (partial above-threshold? 5) [1 2 3 4 5 6 7])
;; returns 6 7 using a partial instead. the partial binds the 5 into the function.


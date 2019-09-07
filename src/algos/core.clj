(ns algos.core
  (:gen-class))
(require '[clojure.string :as string])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (first args)))

(defn convert-decimal
  [symbols radix decimal]
  (if (> decimal 0)
    (loop [elems [] conv decimal]
      (if (> conv 0)
        (recur (conj elems (get symbols (mod conv radix))) (int (/ conv radix)))
        (string/join (reverse elems))))
    (first symbols)))

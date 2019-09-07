(ns algos.core
  (:gen-class))
(require '[clojure.string :as string])

(defn convert-decimal
  [symbols radix decimal]
  (if (> decimal 0)
    (loop [elems [] conv decimal]
      (if (> conv 0)
        (recur (conj elems (get symbols (mod conv radix))) (int (/ conv radix)))
        (string/join (reverse elems))))
    (first symbols)))

(defn -main
  [& args]
  (let [[symbols radix decimal] args]
    (println (convert-decimal symbols (Integer/parseInt radix) (Integer/parseInt decimal)))))

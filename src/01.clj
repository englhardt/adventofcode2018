(defn file-lines [path]
    (clojure.string/split (slurp path) #"\n"))

(defn parse-number [s] (Integer/parseInt (re-find #"\A[\d ()+-]+" s)))

(def input (map parse-number (file-lines "input/01.txt")))

(defn part-1 [] (reduce + input))

(defn part-2 []
  (loop [xs (cycle input)
         seen #{}
         total 0]
    (if (contains? seen total)
      total
      (recur (rest xs)
             (conj seen total)
             (+ total (first xs))))))

(println (part-1))
(println (part-2))


(defn file-lines [path]
    (clojure.string/split (slurp path) #"\n"))

(def input (file-lines "input/02.txt"))

(defn check-n? [w n]
  (some #(= n %) (vals (frequencies w))))

(defn part-1 []
  (* (count (filter #(check-n? % 2) input))
     (count (filter #(check-n? % 3) input))))

(defn one-diff? [[a b]]
  (->> (map vector a b)
       (filter #(not= (first %) (second %)))
       (#(= 1 (count %)))))

(defn overlap [[a b]]
  (->> (map vector a b)
       (filter #(= (first %) (second %)))
       ((fn [x] (apply str (map first x))))))

(defn part-2 []
    (->> (for [x input y input] (vector x y))
         (filter one-diff?)
         (#(overlap (first %)))))

(println (part-1))
(println (part-2))


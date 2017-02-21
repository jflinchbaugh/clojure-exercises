(defn index [coll]
    (cond
        (map? coll) (seq coll)
        (set? coll) (map vector coll coll)
        :else (map vector (iterate inc 0) coll)
    )
)

(index [:a 1 :b 2 :c 3 :d 4])

(index { :a 1 :b 2 :c 3 :d 4})

(index #{:a 1 :b 2 :c 3 :d 4})

(defn pos [e coll]
    (for [[i v]
        (index coll)
        :when (= e v)] i
    )
)

(pos 3 [:a 1 :b 2 :c 3 :d 4])

(pos 3 {:a 1 :b 2 :c 3 :d 4})


(defn pos [pred coll]
    (for [[i v]
        (index coll)
        :when (pred v)] i
    )
)

(pos #{3 4} {:a 1 :b 2 :c 3 :d 4})

(pos even? [1 2 3 4])

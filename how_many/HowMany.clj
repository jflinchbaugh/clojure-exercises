(use '[clojure.test :as t])

(ns howmany)

(defn solve
    {:test
        (fn []
            (is
                (= (solve) [1 7 3 2 1 1 1 2 1 1])
            )
        )
    }
    []
    [-1 -1 -1 -1 -1 -1 -1 -1 -1 -1]
)

(t/deftest eg-tests (is (= 1 1)))

(t/run-tests)

(def generator (iterate (partial + 1) 1))
(map (partial rmod 10) (take 50 generator))

(rmod 10 12)

(defn rmod [div val]
    (mod val div)
)

(defn countOccurences [i counts]
    (+
        1
        (count
            (filter
                (fn [x]
                    (= x i)
                )
                counts
            )
        )
    )
)

(countOccurences 1 [2 1 1 1 1])

;2 [-1 1 2])


(reduce + [1 2 3])
(reduce + [2 30])

(or true false)


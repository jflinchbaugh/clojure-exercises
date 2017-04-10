(comment
    I always have trouble explaining the scoring,
    so this should make it easier.

    Everyone gets the count

    https://boardgamegeekstore.com/products/tmg-micro-game-this-town-aint-big-enough
)

(use '[clojure.test :as t])
(ns this-town)

(defn sort-map [scores] (reverse (sort-by val scores)))

(defn score
    [counts]
    (let [ordered (sort-map counts)]
        ; each player gets the next count that's less their own
        (zipmap
            (keys ordered)
            (distinct (rest (vals ordered)))
        )
    )
)

(score {:red 12, :blue 1, :yellow 1, :green 4})

(t/deftest score-tests
    (is
        (=
            (score {:red 12, :blue 1, :yellow 1, :green 4})
            {:red 4, :green 1}
        )
    )
)

(t/run-tests)

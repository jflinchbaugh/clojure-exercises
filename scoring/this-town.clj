(comment
    I always have trouble explaining the scoring,
    so this should make it easier. ;)

    https://boardgamegeekstore.com/products/tmg-micro-game-this-town-aint-big-enough
)

(use '[clojure.test :as t])
(ns this-town)

(defn map-scores
    "given a list of counts,  produce a map of scores for each count"
    [counts]
    (let
        [
            ordered (-> counts distinct sort reverse)
            next-scores (conj (-> ordered rest vec) 0)
        ]
        (zipmap ordered next-scores)
    )
)

(map-scores [1 2 2 3 4])

(defn score
    "given a map of counts, return a map of the scores"
    [counts]
    (let
        [
            score-map (map-scores (vals counts))
            players (keys counts)
        ]
        ; each player gets the next count that's less their own
        (zipmap
            players
            (map score-map (vals counts))
        )
    )
)

(score {:red 12, :blue 1, :yellow 1, :green 4})

(t/deftest map-scores-tests
    (is
        (=
            (map-scores [1 2 3 3 4])
            {4 3, 3 2, 2 1, 1 0}
        )
    )
)

(t/deftest score-tests
    (is
        (=
            (score {:red 12, :blue 1, :yellow 1, :green 4})
            {:red 4, :green 1, :blue 0, :yellow 0}
        )
    )
    (is
        (=
            (score {:red 12, :orange, 12, :blue 1, :yellow 1, :green 4})
            {:red 4, :orange, 4, :green 1, :blue 0, :yellow 0}
        )
    )
)

(t/run-tests)

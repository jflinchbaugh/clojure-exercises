(defn print-down-from [x]
    (when (pos? x)
        (println x)
        (recur (dec x))
    )
)
(print-down-from 10)

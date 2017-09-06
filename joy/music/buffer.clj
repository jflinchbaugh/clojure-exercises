(require '[cljs.compiler :as comp]
         '[cljs.analyzer :as ana]
         '[clojure.walk :refer [prewalk]]
         '[clojure.pprint :refer [pprint]])

(def code-string "(defn hello [x] (js/alert (pr-str 'greetings x)))")

(def code-data (read-string code-string))

(prn  code-data)
(seq code-string)
(seq code-data)

(def ast (ana/analyze (ana/empty-env) code-data))

(keys ast)

(print ast)
(prn ast)

(defn print-ast [ast]
  (pprint
    (prewalk
      (fn [x]
        (if (map? x)
          (select-keys x [:children :name :form :op]) x))
      ast)))

(print-ast ast)

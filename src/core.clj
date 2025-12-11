(ns core
  (:require [py-init]
            [libpython-clj2.python :as py]
            [libpython-clj2.require :refer [require-python]]))

;; Import Python libraries
(require-python '[numpy :as np])
(require-python '[pandas :as pd])
(require-python '[matplotlib :as mpl])
(require-python '[matplotlib.pyplot :as plt])

;; Set backend to non-interactive (IMPORTANT for macOS)
#_(mpl/use "Agg")

(defn basic-line-plot []
  (println "Creating a basic line plot...")

  ;; Create data
  (let [x (np/linspace 0 10 100)
        y (np/sin x)]

    ;; Create the plot
    (plt/figure :figsize [10 6])
    (plt/plot x y :label "sin(x)" :color "blue" :linewidth 2)

    ;; Add labels and title
    (plt/xlabel "X axis")
    (plt/ylabel "Y axis")
    (plt/title "Basic Sine Wave Plot")
    (plt/legend)
    (plt/grid true)

    (comment (plt/show))
    (comment (do (plt/savefig "sine_plot.png" :dpi 300 :bbox_inches "tight")
                 (plt/close)
                 (println "✓ Plot saved to sine_plot.png")))))


(basic-line-plot)

(defn example-usage []
  ;; Use numpy
  (let [arr (np/array [1 2 3 4 5])]
    (println "NumPy array:" arr)
    (println "Mean:" (np/mean arr)))

  ;; Use pandas
  (let [df (pd/DataFrame {"A" [1 2 3]
                          "B" [4 5 6]})]
    (println "DataFrame:" df)
    (println "Column A:" (py/get-attr df "A"))))

(example-usage)

(defn -main [& args]
  (println "Starting Clojure + Python project...")
  (println "Done!"))

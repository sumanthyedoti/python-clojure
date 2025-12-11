(ns notebook
  (:require [py-init]
            [nextjournal.clerk :as clerk]
            [libpython-clj2.python :as py]
            [libpython-clj2.require :refer [require-python]]))

;; Wrap all Python code in a do block or function
(do
  ;; Import Python libraries
  (require-python '[numpy :as np])
  (require-python '[matplotlib :as mpl])
  (require-python '[matplotlib.pyplot :as plt])
  (require-python '[io :as pyio])
  (require-python '[base64 :as b64])

;; Define helper functions
(defn plot->base64 []
  (let [buf (pyio/BytesIO)]
    (plt/savefig buf :format "png" :bbox_inches "tight" :dpi 150)
    (py/call-attr buf "seek" 0)
    (let [img-bytes (py/call-attr buf "read")
          b64-str (py/call-attr (b64/b64encode img-bytes) "decode" "utf-8")]
      (plt/close)
      (str "data:image/png;base64," b64-str))))

(defn show-plot []
  (clerk/html [:img {:src (plot->base64)}]))

;; # Basic Plot Example

;; Simple line plot
^{::clerk/visibility {:result :show}}
(let [x [0 1 2 3 4 5]
      y [0 1 4 9 16 25]]
  (plt/plot x y)
  (plt/title "Basic Plot")
  (plt/xlabel "X")
  (plt/ylabel "Y")
  (show-plot))

(clerk/serve!
  {:watch-paths ["src"]  ;; Only watch src directory
   :browse true})

(ns hello
  (:require [libpython-clj2.python :as py]
            [libpython-clj2.require :refer [require-python]]))

;; Initialize ONCE at the top level
(py/initialize!
  :python-executable (str (System/getProperty "user.dir") "/.venv/bin/python"))


(defn -main [& args]
  ;; Don't call py/initialize! here - already done above
  (py/run-simple-string "print('Hello from Python!')"))

(ns hello
  (:require [libpython-clj2.python :as py]))

;; When you use conda, it should look like this.
(py/initialize! :python-executable "/opt/anaconda3/envs/my_env/bin/python3.7"
                :library-path "/opt/anaconda3/envs/my_env/lib/libpython3.7m.dylib")

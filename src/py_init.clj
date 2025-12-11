(ns py-init
  (:require [libpython-clj2.python :as py]))

(py/initialize!
 :python-executable (str (System/getProperty "user.dir") "/.venv/bin/python")
  :library-path (str (System/getProperty "user.dir") ".venv/lib/python3.13"))

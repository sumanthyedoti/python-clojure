My playground for [libpython-clj](https://github.com/clj-python/libpython-clj) and Python libraries, with Clojure

## Setup Python

``` sh
python3 -m venv .venv
source .venv/bin/activate[.fish]
pip install -r requirements.txt
```

## Run project 

```sh
clj -M -m core
```

## Run Clerk

``` sh
clj -X:clerk
```


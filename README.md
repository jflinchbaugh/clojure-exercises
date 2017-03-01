Running scripts from lein repl:
```(load-file "sum-down.clj")```

Running the scripts from within fireplace:

1. ```lein repl :headless```
2. In vim:
    a. Confirm that ```ln -s ~/.lein/repl-port ~/.nrepl-port```
    b. ```cpp``` execute immediately
    c. ```cqq``` take to a command line and execute
    d. ```:help fireplace```

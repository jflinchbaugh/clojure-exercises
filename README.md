Running scripts from lein repl:
```(load-file "sum-down.clj")```

Running the scripts from within fireplace:

1. ```lein repl :headless``` or maybe ```boot repl```
2. If using lein, confirm that ```ln -s ~/.lein/repl-port ~/.nrepl-port```
3. In vim:
    b. ```cpp``` execute immediately
    c. ```cqq``` take to a command line and execute
    d. ```:help fireplace```

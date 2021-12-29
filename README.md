# Advent of Code 2021
My solutions for Advent of Code 2021 in Scala.

## Running
You can either run a specific solution by running sbt with the day and solution numbers directly
```bash
$ sbt run 2 1 # runs the first solution of day 2
```

Or you can just let sbt run in CLI mode, and then run the solutions, which can be helpful when you want to run multiple solutions.

```bash
$ sbt

...

sbt> run 1 2 # runs the 2nd solution of day 1
```

## Testing
Some solutions have unit tests, so you can either run all tests `test` sbt command
```bash
sbt> test
```

Or a specific one using the `testOnly` command with the full class name
```bash
sbt> testOnly com.yalingunayer.aoc2021.Day02Test
```


## License
MIT

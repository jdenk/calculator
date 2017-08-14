# Calculator app

Application for performing binary operations.
Supported operations are:
* add
* subtract
* divide
* multiply

## Example input
```
add 2
multiply 3
apply 4
```

## Running tests
* ```./gradlew test```

## Bundling the app
* ```./gradlew build```
* ```java -jar build/libs/calculator-1.0-SNAPSHOT.jar  -f (--file) input_file_path```
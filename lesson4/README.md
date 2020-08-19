# Lesson 4


## Intro
Basic Maven use

## Topics
- maven 
    - lifecycle
        - test
        - outputs code and jar to `target`
    - folder structure 
        - `src/main/java/<package.name.with.forward.slashes>/<Class With Main Method>.java`
    - junit
        - `test/path/to/class/to/test/ClassToTest.java`
    
## Dependencies
- maven
    - https://maven.apache.org/install.html
    - https://www.baeldung.com/install-maven-on-windows-linux-mac

## Run Program

### Start

```
<lesson 4 root>/runApp.sh
```

### Output

`Hello World`

## Shell Script

- Compile program
    - command: `mvn install`
        - installs dependencies
        - compiles to jar file in `target/lesson4-1.0-SNAPSHOT.jar`
- Run program
    - Runs jar `target/lesson4-1.0-SNAPSHOT.jar`
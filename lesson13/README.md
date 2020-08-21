# Lesson 13

## Topics
- Maven
- Spring Boot
- React app as part of Spring Boot project
- Maven Executing Command Line
- Custom Bash Script 
    - Builds React App Using Yarn
    - 

## Dependencies
- Java 14
- Maven
- Node 14
- Yarn 1.22.4
- Bash 5.0.18

## Run

### Start

```
<lesson 13 root directory>/runApp.sh
```

or

```
<lesson 13 root directory>/runApp.sh --port <some port>
```

### Output
Will mention which port the app is running on 

### Tests
- `mvn test` goal runs Junit as well as Frontend Unit tests

## Interactive with Web App

Go to `http://localhost:<port decided on>`

Default port is `8080`

## Code Explained

This project has both Java backend and React app frontend

### Frontend
- located at `<root>/src/frontend`
- `mvn compile` builds frontend directory at `<roo>/src/frontend/hello-world/build` and copies it to `<root>/src/main/resources/public`
- `mvn test` runs `yarn test` which then runs `react-scripts test --watchAll=false`    
    

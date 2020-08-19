# Lesson 10

## Topics
- config
    - `src/config/config.txt`
    - config file values are injected where there are corresponding annotations. 
- maven
- junit testing
- custom annotations
- Java reflection
- Java HTTPServer
    - handler
    - context
        - set up endpoint path paired with Http Handler
            - `com.sun.net.httpserver.HttpHandler`  
- bare bones controller
    - controller has annotations on it
    
HTTPServer Created with Mostly Core Java API

## Config

For this example there are two config parameters
- port
    - any integer from 1024 to 49151, inclusive (1024 and 49151 are allowed)
- language
    - options
        - english
        - spanish

## Run

### Start Server
```
<lesson 10 root dir>/runApp.js
```


### Side effect
Starts server

### Output
`Listening on port 7000`

## See Webpage in Browser

Go to either
- [home page](http://127.0.0.1:7000)
- [canary](http://127.0.0.1:7000/canary)
    
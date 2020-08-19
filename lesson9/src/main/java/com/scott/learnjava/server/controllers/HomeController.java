package com.scott.learnjava.server.controllers;

import com.scott.learnjava.server.annotations.RestController;
import com.scott.learnjava.server.annotations.RestRequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@RestController(path = "/")
public class HomeController {

    private String indexHtmlTemplate;

    public HomeController() throws FileNotFoundException {
        initIndexHtmlTemplate();
    }

    private void initIndexHtmlTemplate() throws FileNotFoundException {
        String path = "./src/main/java/com/scott/learnjava/server/templates/index.html";
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(new File(path));

        while(scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine() + '\n');
        }

       indexHtmlTemplate = stringBuilder.toString();
    }

    @RestRequest(path = "/")
    public String index() {
        return indexHtmlTemplate;
    }

    @RestRequest(path = "/canary")
    public String canaryRequest() {
        return "This is the canary page. The server is up and running";
    }
}

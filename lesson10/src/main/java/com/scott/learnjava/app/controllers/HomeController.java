package com.scott.learnjava.app.controllers;

import com.scott.learnjava.customFramework.annotations.RestController;
import com.scott.learnjava.customFramework.annotations.RestRequest;
import com.scott.learnjava.customFramework.annotations.UseTemplate;

@RestController(path = "/")
public class HomeController {
    @UseTemplate
    @RestRequest(path = "/")
    public String index() {
        return "index.html";
    }

    @RestRequest(path = "/canary")
    public String canaryRequest() {
        return "server is up and running";
    }
}

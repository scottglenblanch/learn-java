package com.scott.learnjava.app.controllers;

import com.scott.learnjava.customFramework.annotations.RestController;
import com.scott.learnjava.customFramework.annotations.RestRequest;
import com.scott.learnjava.customFramework.annotations.UseTemplate;

@RestController(path = "/aboutme")
public class AboutMeController {

    @UseTemplate
    @RestRequest(path = "/")
    public String index() {
        return "aboutme.html";
    }

}

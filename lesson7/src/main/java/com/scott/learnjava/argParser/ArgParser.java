package com.scott.learnjava.argParser;

public class ArgParser {

    private String[] args;

    public ArgParser(String[] args) {
        this.args = args;
    }

    public boolean hasNoArgs() {
       return args.length <= 0 || args[0].length() <= 0;
    }

    public String getLanguage() {
        String defaultLanguage = "english";

        return hasNoArgs() ? defaultLanguage : args[0].toLowerCase();
    }
}

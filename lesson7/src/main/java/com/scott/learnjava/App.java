package com.scott.learnjava;

import com.scott.learnjava.argParser.ArgParser;
import com.scott.learnjava.messageCreator.MessageCreator;
import com.scott.learnjava.messageCreator.MessageCreatorFactory;

public class App {
    public static void main( String[] args ) {
       App app = new App(args);
       app.logOutMessage();
    }

    private ArgParser argParser;
    private MessageCreator messageCreator;

    public App(String[] args) {
        initArgParser(args);
        initMessageCreator();
    }

    public void logOutMessage() {
        String message = messageCreator.getMessage();

        System.out.println(message);
    }

    private void initArgParser(String[] args) {
        this.argParser = new ArgParser(args);
    }

    private void initMessageCreator() {
        String language = argParser.getLanguage();
        this.messageCreator = MessageCreatorFactory.getMessageLogger(language);
    }

}

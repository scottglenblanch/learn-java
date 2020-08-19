package com.scott.learnjava.messageCreator;

import com.scott.learnjava.annotations.PhraseAnnotation;

public class MessageCreator {

    @PhraseAnnotation(phraseKey = "language")
    String language;

    @PhraseAnnotation(phraseKey = "greeting")
    String greeting;

    @PhraseAnnotation(phraseKey = "salutation")
    String salutation;

    private String messageTemplate;

    public MessageCreator() {
        initMessageTemplate();
    }

    public String getMessage() {
        return String.format(messageTemplate, language, greeting, salutation);
    }

    private void initMessageTemplate() {
        messageTemplate = "Language: %s\n" +
            "Greeting: %s\n" +
            "Salutation: %s\n";
    }

}

package com.scott.learnjava.annotationConnector;

import com.scott.learnjava.annotations.PhraseAnnotation;
import com.scott.learnjava.phraseHandler.PhraseHandler;
import com.scott.learnjava.messageCreator.MessageCreator;

import java.lang.reflect.Field;

public class AnnotationConnector {
    private final MessageCreator messageLogger;
    private final PhraseHandler phraseHandler;

    public AnnotationConnector(MessageCreator messageLogger, String language) {
        this.messageLogger = messageLogger;
        this.phraseHandler = new PhraseHandler(language);
    }

    public MessageCreator getConnectedMessageLogger() {
        injectMessageStringIntoMessageLogger();

        return messageLogger;
    }

    private void injectMessageStringIntoMessageLogger() {
        for(Field field: messageLogger.getClass().getDeclaredFields()) {
            if (hasPhraseAnnotationOnField(field)) {
                injectValueIntoField(field);
            }
        }
    }

    private boolean hasPhraseAnnotationOnField(Field field) {
        PhraseAnnotation annotation = field.getDeclaredAnnotation(PhraseAnnotation.class);
        return annotation != null;
    }

    private void injectValueIntoField (Field field) {
        PhraseAnnotation annotation = field.getDeclaredAnnotation(PhraseAnnotation.class);
        String phraseKey = annotation.phraseKey();
        String phraseValue = phraseHandler.getPhraseValue(phraseKey);

        field.setAccessible(true);
        try {
            field.set(messageLogger, phraseValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            field.setAccessible(false);
        }
    }
}

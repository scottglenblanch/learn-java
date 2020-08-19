package com.scott.learnjava.annotationConnector;

import com.scott.learnjava.annotations.RandomAnnotation;
import com.scott.learnjava.messageLogger.MessageLogger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationConnector {
    private MessageLogger messageLogger;

    public AnnotationConnector(MessageLogger messageLogger) {
        this.messageLogger = messageLogger;
    }

    public void injectMessageStringIntoMessageLogger() {
        Field messageToLogField = getMessageToLogField();
        messageToLogField.setAccessible(true);
        try {
            messageToLogField.set(messageLogger, getRandomAnnotationValue());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            messageToLogField.setAccessible(false);
        }
    }

    public Field getMessageToLogField() {
        try {
            return messageLogger.getClass().getDeclaredField("messageToLog");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getRandomAnnotationValue() {
        Field field = getMessageToLogField();
        for(Annotation annotation: field.getDeclaredAnnotations()){
            RandomAnnotation ra = (RandomAnnotation) annotation;
            return ra.value();
        }
        return "";
    }
}

package com.scott.learnjava.messageCreator;

import com.scott.learnjava.annotationConnector.AnnotationConnector;

public class MessageCreatorFactory {
    public static MessageCreator getMessageLogger(String language) {
        AnnotationConnector connector = new AnnotationConnector(
            new MessageCreator(),
            language
        );
        MessageCreator connectedMessageLogger = connector.getConnectedMessageLogger();

        return connectedMessageLogger;
    }
}
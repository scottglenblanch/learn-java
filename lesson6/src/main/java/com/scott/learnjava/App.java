package com.scott.learnjava;

import com.scott.learnjava.annotationConnector.AnnotationConnector;
import com.scott.learnjava.messageLogger.MessageLogger;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MessageLogger messageLogger = new MessageLogger();
        AnnotationConnector connector = new AnnotationConnector(messageLogger);
        connector.injectMessageStringIntoMessageLogger();

        messageLogger.logToTerminal();
    }


}

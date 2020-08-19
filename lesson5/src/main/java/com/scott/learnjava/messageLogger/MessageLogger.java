package com.scott.learnjava.messageLogger;

import com.scott.learnjava.annotations.RandomAnnotation;

public class MessageLogger {

    @RandomAnnotation
    String messageToLog;

    public void logToTerminal() {
        System.out.println(messageToLog);
    }

}

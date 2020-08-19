package com.scott.learnjava.messageLogger;

import com.scott.learnjava.annotations.RandomAnnotation;

public class MessageLogger {

    @RandomAnnotation(value = "phrase that comes from RandomAnnotation")
    String messageToLog;

    public void logToTerminal() {
        System.out.println(messageToLog);
    }

}

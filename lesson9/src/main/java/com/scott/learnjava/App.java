package com.scott.learnjava;

import com.scott.learnjava.server.ServerImpl;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        new ServerImpl().start();

    }
}

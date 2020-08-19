package com.scott.learnjava.customFramework.configPropertyFetcher;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigPropertyFetcherTest {

    @Test
    public void getConfigProperty_testPort() {
        String portAsString = ConfigPropertyFetcher.getConfigProperty("port");

        assertEquals( "7000", portAsString);
    }

    @Test
    public void getConfigProperty_testLanguage() {
        String language = ConfigPropertyFetcher.getConfigProperty("language");

        assertEquals( "english", language);
    }
}
package com.scott.learnjava.configFetchers.personListFetcher;

import com.scott.learnjava.models.exceptions.PersonBuildException;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PersonImplListFetcherImplTest {

    private PersonListFetcher fetcher = null;

    @Before
    public void setup() {
        this.fetcher = new PersonListFetcherImpl();
    }

    @Test
    public void testGetPersonList() throws ParserConfigurationException, PersonBuildException, SAXException, IOException {
        fetcher.getPersonListFromXMLConfig();
    }


}
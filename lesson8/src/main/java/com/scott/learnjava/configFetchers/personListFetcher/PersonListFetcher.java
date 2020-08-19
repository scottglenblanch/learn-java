package com.scott.learnjava.configFetchers.personListFetcher;

import com.scott.learnjava.models.data.Person;
import com.scott.learnjava.models.exceptions.PersonBuildException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface PersonListFetcher {
    static List<Person> getPersonList() throws ParserConfigurationException, PersonBuildException, SAXException, IOException {
        return new PersonListFetcherImpl().getPersonListFromXMLConfig();
    }

    List<Person> getPersonListFromXMLConfig() throws ParserConfigurationException, SAXException, IOException, PersonBuildException;
}

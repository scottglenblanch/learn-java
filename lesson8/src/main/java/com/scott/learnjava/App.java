package com.scott.learnjava;

import com.scott.learnjava.configFetchers.personListFetcher.PersonListFetcher;
import com.scott.learnjava.models.data.Person;
import com.scott.learnjava.models.exceptions.PersonBuildException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class App {
    public static void main( String[] args ) throws ParserConfigurationException, PersonBuildException, SAXException, IOException {
        for(Person person: PersonListFetcher.getPersonList()) {
            logOutPerson(person);
        }
    }

    public static void logOutPerson(Person person) {
        System.out.println(person);
    }
}

package com.scott.learnjava.configFetchers.personListFetcher;

import com.scott.learnjava.models.data.Person;
import com.scott.learnjava.models.exceptions.PersonBuildException;
import com.scott.learnjava.models.factories.PersonBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonListFetcherImpl implements PersonListFetcher {

    @Override
    public List<Person> getPersonListFromXMLConfig() throws ParserConfigurationException, SAXException, IOException, PersonBuildException {
        List<Person> personList = new ArrayList<>();

        NodeList nodeList = getDocumentRoot().getElementsByTagName("person");

        for(int i =0; i < nodeList.getLength(); i++) {
            Node personNode = nodeList.item(i);
            personList.add(getPersonFromNode(personNode));
        }

        return personList;
    }

    private Element getDocumentRoot() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File( "./config/personList.xml" ));

        return document.getDocumentElement();
    }

    private Person getPersonFromNode(Node personNode) throws PersonBuildException {
        return PersonBuilder.getInstance()
            .addAlias(
                getPersonFieldValueFromNode(personNode, "alias")
            )
            .addFirstName(
                getPersonFieldValueFromNode(personNode, "firstname")
            )
            .addLastName(
                getPersonFieldValueFromNode(personNode, "lastname")
            )
            .addOccupation(
                getPersonFieldValueFromNode(personNode, "occupation")
            )
            .getPersonInstance();

    }

    private String getPersonFieldValueFromNode(Node personNode, String elementName) {
        Node childNode =  getChildNodeWithElementName(personNode, elementName);
        return childNode.getTextContent().trim();
    }

    private Node getChildNodeWithElementName(Node personNode, String elementName) {
        NodeList children = personNode.getChildNodes();

        for(int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            boolean isMatch = elementName.equals(child.getNodeName());

            if (isMatch) {
               return child;
            }
        }

        return null;
    }
}

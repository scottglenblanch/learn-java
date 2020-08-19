package com.scott.learnjava.models.factories;

import com.scott.learnjava.models.data.Person;
import com.scott.learnjava.models.exceptions.PersonBuildException;
import junit.framework.TestCase;
import org.junit.Test;

public class PersonBuilderImplTest extends TestCase {

    @Test
    public void testGetInstance() {
        assert(PersonBuilder.getInstance() != null);
    }

    @Test
    public void testAddFirstName() {
        PersonBuilder.getInstance().addFirstName("testFirstName");
    }

    @Test
    public void testAddLastName() {
        PersonBuilder.getInstance().addLastName("testLastName");
    }

    @Test
    public void testAddAlias() {
        PersonBuilder.getInstance().addAlias("testAlias");
    }

    @Test
    public void testAddOccupation() {
        PersonBuilder.getInstance().addOccupation("testLastName");
    }

    @Test
    public void testGetPersonInstance() throws PersonBuildException {
        String alias = "testAlias";
        String firstName = "testFirstName";
        String lastName = "testLastName";
        String occupation = "testOccupation";

        Person person = PersonBuilder
            .getInstance()
            .addAlias(alias)
            .addFirstName(firstName)
            .addLastName(lastName)
            .addOccupation(occupation)
            .getPersonInstance();

        assertEquals(person.getAlias(), alias);
        assertEquals(person.getFirstName(), firstName);
        assertEquals(person.getLastName(), lastName);
        assertEquals(person.getOccupation(), occupation);
    }


}
package com.scott.learnjava.models.factories;

import com.scott.learnjava.models.data.Person;
import com.scott.learnjava.models.data.PersonImpl;
import com.scott.learnjava.models.exceptions.PersonBuildException;

import java.util.Arrays;
import java.util.Objects;

public class PersonBuilderImpl implements PersonBuilder {

    private String firstName;
    private String lastName;
    private String alias;
    private String occupation;

    private static PersonBuilder instance = null;

    public static PersonBuilder getInstance() {
        if (instance == null) {
            instance = new PersonBuilderImpl();
        }

        return instance;
    }

    @Override
    public PersonBuilder addFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


    @Override
    public PersonBuilder addLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    @Override
    public PersonBuilder addAlias(String alias) {
        this.alias = alias;
        return this;
    }


    @Override
    public PersonBuilder addOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    @Override
    public Person getPersonInstance() throws PersonBuildException {
        if (isAbleToBuild()) {
            return getPersonInstanceWhenValid();
        } else {
            throw new PersonBuildException();
        }

    }

    private Person getPersonInstanceWhenValid() {
        PersonImpl person = new PersonImpl();

        person.setAlias(alias);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setOccupation(occupation);

        return person;
    }

    private boolean isAbleToBuild () {
        return Arrays.asList(alias, firstName, lastName, occupation)
            .stream()
            .allMatch(Objects::nonNull);
    }
}

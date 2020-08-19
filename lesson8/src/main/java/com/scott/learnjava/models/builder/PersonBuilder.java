package com.scott.learnjava.models.factories;

import com.scott.learnjava.models.data.Person;
import com.scott.learnjava.models.exceptions.PersonBuildException;

public interface PersonBuilder {
    public static PersonBuilder getInstance() {
        return PersonBuilderImpl.getInstance();
    }

    PersonBuilder addFirstName(String firstName);

    PersonBuilder addLastName(String lastName);

    PersonBuilder addAlias(String alias);

    PersonBuilder addOccupation(String occupation);

    Person getPersonInstance() throws PersonBuildException;
}

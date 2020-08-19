package com.scott.learnjava.models.data;

import java.util.Objects;

public class PersonImpl implements Person {

    private String alias;
    private String firstName;
    private String lastName;
    private String occupation;

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getOccupation() {
        return occupation;
    }

    @Override
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonImpl person = (PersonImpl) o;
        return alias.equals(person.alias) &&
                firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                occupation.equals(person.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alias, firstName, lastName, occupation);
    }

    @Override
    public String toString() {
        String template = "firstName: %s\nlastName: %s\nalias: %s\noccupation: %s\n";

        return String.format(template, firstName, lastName, alias, occupation);
    }
}

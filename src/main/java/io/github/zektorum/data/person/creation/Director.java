package io.github.zektorum.data.person.creation;

import io.github.zektorum.data.person.Person;

public class Director {
    private PersonBuilder personBuilder;

    public Director(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
        if (this.personBuilder == null) {
            throw new IllegalArgumentException("Director не может работать с PersonBuilder!");
        }
    }

    public Person createPerson() {
        return this.personBuilder
                .withName()
                .withHeight()
                .withLocation()
                .withCoordinates()
                .withEyeColor()
                .withHairColor()
                .withNationality()
                .build();
    }
}

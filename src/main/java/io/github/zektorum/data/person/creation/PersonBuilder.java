package io.github.zektorum.data.person.creation;

import io.github.zektorum.data.person.Person;

public interface PersonBuilder {
    PersonBuilder withName();
    PersonBuilder withCoordinates();
    PersonBuilder withHeight();
    PersonBuilder withEyeColor();
    PersonBuilder withHairColor();
    PersonBuilder withNationality();
    PersonBuilder withLocation();
    Person build();
}

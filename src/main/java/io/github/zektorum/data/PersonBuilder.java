package io.github.zektorum.data;

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

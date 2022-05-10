package io.github.zektorum.data;

import java.util.Scanner;

public class PersonCreator {
    private final String name;
    private final double height;

    public PersonCreator(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public Person create() {
        PersonFieldsReader fieldsReader = new PersonFieldsReader();
        CoordinatesReader coordinatesReader = new CoordinatesReader();
        LocationReader locationReader = new LocationReader();
        return new Person(
                this.name.substring(0, 1).toUpperCase() + this.name.substring(1), // capitalize
                this.height, locationReader.read(), coordinatesReader.read(),
                fieldsReader.readEyeColor(), fieldsReader.readHairColor(), fieldsReader.readNationality()
        );
    }

    public Person create(Scanner input) {
        PersonFieldsReaderFromFile fieldsReader = new PersonFieldsReaderFromFile(input);
        CoordinatesReader coordinatesReader = new CoordinatesReader();
        LocationReader locationReader = new LocationReader();

        return new Person(
                this.name.substring(0, 1).toUpperCase() + this.name.substring(1), // capitalize
                this.height, locationReader.readFromFile(input), coordinatesReader.readFromFile(input),
                fieldsReader.readEyeColor(), fieldsReader.readHairColor(), fieldsReader.readNationality()
        );
    }
}

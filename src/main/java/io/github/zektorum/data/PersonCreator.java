package io.github.zektorum.data;

public class PersonCreator {
    private final String name;
    private final double height;

    public PersonCreator(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public Person create() {
        PersonFieldsReader fr = new PersonFieldsReader();
        CoordinatesReader coordinatesReader = new CoordinatesReader();
        LocationReader locationReader = new LocationReader();
        return new Person(
                this.name.substring(0, 1).toUpperCase() + this.name.substring(1), // capitalize
                this.height, locationReader.read(), coordinatesReader.read(),
                fr.readEyeColor(), fr.readHairColor(), fr.readNationality()
        );
    }
}

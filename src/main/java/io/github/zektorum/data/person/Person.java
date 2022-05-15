package io.github.zektorum.data.person;

import com.google.gson.annotations.Expose;
import io.github.zektorum.data.person.fields.Color;
import io.github.zektorum.data.person.fields.Coordinates;
import io.github.zektorum.data.person.fields.Country;
import io.github.zektorum.data.person.fields.Location;

import java.time.ZonedDateTime;

public class Person implements Comparable<Person> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    @Expose
    private String name; //Поле не может быть null, Строка не может быть пустой

    @Expose
    private Coordinates coordinates; //Поле не может быть null

    @Expose
    private double height; //Значение поля должно быть больше 0

    @Expose
    private Color.EyeColor eyeColor; //Поле не может быть null

    @Expose
    private Color.HairColor hairColor; //Поле может быть null

    @Expose
    private Country nationality; //Поле не может быть null

    @Expose
    private Location location; //Поле может быть null

    @Expose
    private ZonedDateTime creationDate;

    public Person(
            String name, double height, Location location, Coordinates coordinates,
            Color.EyeColor eyeColor, Color.HairColor hairColor, Country nationality
    ) {
        this.name = name;
        this.height = height;
        this.location = location;
        this.coordinates = coordinates;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.creationDate = ZonedDateTime.now();
    }

    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }

    public ZonedDateTime getCreationDate() {
        return this.creationDate;
    }

    public String getName() {
        return this.name;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public Color.EyeColor getEyeColor() {
        return this.eyeColor;
    }

    public Color.HairColor getHairColor() {
        return this.hairColor;
    }

    public double getHeight() {
        return this.height;
    }

    public Country getNationality() {
        return this.nationality;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setEyeColor(Color.EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairColor(Color.HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
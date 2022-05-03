package io.github.zektorum.data;

import com.google.gson.annotations.Expose;

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
    }

    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }

    public double getHeight() {
        return this.height;
    }

    public Location getLocation() {
        return this.location;
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

    public Country getNationality() {
        return this.nationality;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
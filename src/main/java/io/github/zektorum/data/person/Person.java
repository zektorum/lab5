package io.github.zektorum.data.person;

import com.google.gson.annotations.Expose;
import io.github.zektorum.data.person.fields.Color;
import io.github.zektorum.data.person.fields.Coordinates;
import io.github.zektorum.data.person.fields.Country;
import io.github.zektorum.data.person.fields.Location;

import java.time.ZonedDateTime;

/**
 * Класс, определяющий сущность "человек".
 */
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

    /**
     * Создаёт объект на основе переданных параметров. Дата создания генерируется автоматически.
     *
     * @param name        имя человека
     * @param height      рост человека
     * @param location    локация человека
     * @param coordinates координаты человека
     * @param eyeColor    цвет глаз человека
     * @param hairColor   цвет волос человека
     * @param nationality национальность человека
     */
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

    /**
     * @return дата создания объекта
     */
    public ZonedDateTime getCreationDate() {
        return this.creationDate;
    }

    /**
     * @return имя человека
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return рост человека
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return локация человека
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * @return координаты человека
     */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    /**
     * @return цвет глаз человека
     */
    public Color.EyeColor getEyeColor() {
        return this.eyeColor;
    }

    /**
     * @return цвет волос человека
     */
    public Color.HairColor getHairColor() {
        return this.hairColor;
    }

    /**
     * @return национальность человека
     */
    public Country getNationality() {
        return this.nationality;
    }


    /**
     * @return идентификатор объекта
     */
    public int getId() {
        return this.id;
    }

    /**
     * Устанавливает объекту id.
     *
     * @param id идентификатор объекта
     */
    public void setId(int id) {
        this.id = id;
    }
}
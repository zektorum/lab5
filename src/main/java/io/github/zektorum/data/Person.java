package io.github.zektorum.data;

public class Person {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private double height; //Значение поля должно быть больше 0
    private Location location; //Поле может быть null

    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public Person(String name, double height, Location location) {
        this(name, height);
        this.location = location;
    }

    public double getHeight() {
        return this.height;
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
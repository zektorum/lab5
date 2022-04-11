package io.github.zektorum.data;

public class Location {
    private double x;
    private Float y; //Поле не может быть null
    private Double z; //Поле не может быть null

    public Location(double x, float y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

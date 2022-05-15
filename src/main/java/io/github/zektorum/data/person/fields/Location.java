package io.github.zektorum.data.person.fields;

import com.google.gson.annotations.Expose;

public class Location {
    @Expose
    private double x;

    @Expose
    private Float y; //Поле не может быть null

    @Expose
    private Double z; //Поле не может быть null

    public Location(double x, float y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public Float getY() {
        return this.y;
    }

    public Double getZ() {
        return this.z;
    }
}

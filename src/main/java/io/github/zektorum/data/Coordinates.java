package io.github.zektorum.data;

public class Coordinates {
    private double x; //Значение поля должно быть больше -183
    private Integer y; //Максимальное значение поля: 750, Поле не может быть null

    public Coordinates(double x, int y) {
        if (y > 750 || x < -183) {
            // TODO: throw exception
        }
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }
}

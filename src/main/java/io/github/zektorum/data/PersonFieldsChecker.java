package io.github.zektorum.data;

public class PersonFieldsChecker {
    public static boolean isFieldNotNull(Float value) {
        return !(value == null);
    }

    public static boolean isFieldNotNull(Double value) {
        return !(value == null);
    }

    public static boolean isMoreThanValue(double value, double limit) {
        double eps = 0.0001;
        return Math.abs(value - limit) > eps && value < limit;
    }

    public static boolean isLessThanValue(Integer value, Integer limit) {
        return value <= limit;
    }
}

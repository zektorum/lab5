package io.github.zektorum.data.person;

import io.github.zektorum.data.person.fields.Color;
import io.github.zektorum.data.person.fields.Coordinates;
import io.github.zektorum.data.person.fields.Country;
import io.github.zektorum.data.person.fields.Location;

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
        if (value == null || limit == null)
            return false;
        return value <= limit;
    }

    public static boolean isValidName(String name) {
        if (name == null)
            return false;
        return !name.equals("");
    }

    public static boolean isValidLocation(Location location) {
        if (location == null)
            return true;
        return location.getY() != null && location.getZ() != null;
    }

    public static boolean isValidCoordinates(Coordinates coordinates) {
        if (coordinates == null)
            return false;
        return PersonFieldsChecker.isLessThanValue(coordinates.getY(), 750);
    }

    public static boolean isValidEnums(Color.EyeColor eyeColor, Color.HairColor hairColor, Country nationality) {
        try {
            Color.EyeColor.valueOf(eyeColor.toString());
            Color.HairColor.valueOf(hairColor.toString());
            Country.valueOf(nationality.toString());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }
    public static boolean isValidPerson(Person person) {
        int validFields = 0;

        if (PersonFieldsChecker.isValidName(person.getName()))
            ++validFields;

        if (person.getHeight() > 0)
            ++validFields;

        if (PersonFieldsChecker.isValidLocation(person.getLocation()))
            ++validFields;

        if (PersonFieldsChecker.isValidCoordinates(person.getCoordinates()))
            ++validFields;

        if (PersonFieldsChecker.isValidEnums(person.getEyeColor(), person.getHairColor(), person.getNationality()))
            ++validFields;

        return validFields == 5;
    }
}

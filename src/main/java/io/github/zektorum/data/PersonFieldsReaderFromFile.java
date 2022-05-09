package io.github.zektorum.data;

import java.util.Scanner;

public class PersonFieldsReaderFromFile {
    private final Scanner input;

    public PersonFieldsReaderFromFile(Scanner input) {
        this.input = input;
    }

    public Color.EyeColor readEyeColor() {
        String eyeColor = this.input.next().toUpperCase();
        try {
            return Color.EyeColor.valueOf(eyeColor);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public Color.HairColor readHairColor() {
        String hairColor = this.input.next().toUpperCase();
        try {
            return Color.HairColor.valueOf(hairColor);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public Country readNationality() {
        String nationality = this.input.next().toUpperCase();
        try {
            return Country.valueOf(nationality);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}

package io.github.zektorum.data;

import java.util.Scanner;

public class PersonFieldsReader {
    public Color.EyeColor readEyeColor() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите цвет глаз.\nДоступные варианты: RED, BLACK, BLUE, ORANGE, BROWN");
        String eyeColor = userInput.next().toUpperCase();
        while (true) {
            try {
                return Color.EyeColor.valueOf(eyeColor);
            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Некорректный ввод! Повторите попытку\nДоступные варианты: RED, BLACK, BLUE, ORANGE, BROWN"
                );
                userInput.nextLine();
                eyeColor = userInput.next().toUpperCase();
            }
        }

    }

    public Color.HairColor readHairColor() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Введите цвет волос.\nДоступные варианты: GREEN, BLUE, WHITE\n");
        String hairColor = userInput.next().toUpperCase();
        while (true) {
            try {
                return Color.HairColor.valueOf(hairColor);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод! Повторите попытку\nДоступные варианты: GREEN, BLUE, WHITE");
                userInput.nextLine();
                hairColor = userInput.next().toUpperCase();
            }
        }
    }

    public Country readNationality() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите национальность.\nДоступные варианты: UNITED_KINGDOM, USA, ITALY, SOUTH_KOREA, JAPAN");
        String nationality = userInput.next().toUpperCase();
        while (true) {
            try {
                return Country.valueOf(nationality);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод! Повторите попытку");
                System.out.println("Доступные варианты: UNITED_KINGDOM, USA, ITALY, SOUTH_KOREA, JAPAN");
                userInput.nextLine();
                nationality = userInput.next().toUpperCase();
            }
        }
    }
}

package io.github.zektorum.data;

import java.util.Locale;
import java.util.Scanner;

public class PersonCreator {
    private String name;
    private double height;

    public PersonCreator(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public Person create() {
        return new Person(
                this.name.substring(0, 1).toUpperCase() + this.name.substring(1), // capitalize
                this.height, readLocation(), readCoordinates(),
                readEyeColor(), readHairColor(), readNationality()
        );
    }

    private Location readLocation() {
        Scanner doubleScanner = new Scanner(System.in);
        Scanner floatScanner = new Scanner(System.in);
        System.out.printf(
                "Введите локацию.\nДиапазон значений: %s <= x <= %s; %s <= y <= %s;\n%s <= z <= %s; y != null; z != null\n",
                "−1.7976931348623157*10^308", "1.7976931348623157*10^308",
                " −3.40282347*10^38", "3.40282347*10^38",
                "−1.7976931348623157*10^308", "1.7976931348623157*10^308"
        );
        System.out.print("x: ");
        double x = doubleScanner.nextDouble();

        System.out.print("y: ");
        Float y = floatScanner.nextFloat();

        System.out.print("z: ");
        Double z = doubleScanner.nextDouble();

        return new Location(x, y, z);
    }

    private Coordinates readCoordinates() {
        Scanner doubleScanner = new Scanner(System.in).useLocale(Locale.US);
        Scanner intScanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.printf(
                "Введите координаты.\nДиапазон значений: 183 < x <= %s; %d <= y < 750; y != null\n",
                "1.7976931348623157*10^308",
                -2147483648
        );
        System.out.print("x: ");
        double x = doubleScanner.nextDouble();

        System.out.print("y: ");
        Integer y = intScanner.nextInt();

        return new Coordinates(x, y);
    }

    private Color.EyeColor readEyeColor() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Введите цвет глаз.\nДоступные варианты: RED, BLACK, BLUE, ORANGE, BROWN\n");
        String eyeColor = userInput.next();
        return Color.EyeColor.valueOf(eyeColor);
    }

    private Color.HairColor readHairColor() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Введите цвет волос.\nДоступные варианты: GREEN, BLUE, WHITE\n");
        String hairColor = userInput.next();
        return Color.HairColor.valueOf(hairColor);
    }

    private Country readNationality() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Введите национальность.\nДоступные варианты: UNITED_KINGDOM, USA, ITALY, SOUTH_KOREA, JAPAN");
        String nationality = userInput.next();
        System.out.println();
        return Country.valueOf(nationality);
    }
}

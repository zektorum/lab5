package io.github.zektorum.data.person.fields;

import io.github.zektorum.data.person.PersonFieldsChecker;
import io.github.zektorum.data.person.fields.Location;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LocationReader {
    public Location read() {
        System.out.println("Введите локацию");
        double x = this.readLocationX();
        Float y = this.readLocationY();
        Double z = this.readLocationZ();

        return new Location(x, y, z);
    }

    public Location readFromFile(Scanner input) {
        double x = this.readLocationXFromFile(input);
        Float y = this.readLocationYFromFile(input);
        Double z = this.readLocationZFromFile(input);

        return new Location(x, y, z);
    }

    public double readLocationX() {
        String x_MIN = "-1.7976931348623157*10^308";
        String x_MAX = "1.7976931348623157*10^308";
        System.out.printf("Диапазон значений: x ∈ [%s, %s]\n", x_MIN, x_MAX);
        System.out.print("x: ");

        Scanner doubleScanner = new Scanner(System.in);
        try {
            return doubleScanner.nextDouble();
        } catch (InputMismatchException e) {
            doubleScanner.nextLine();
        }
        while (true) {
            try {
                System.out.println("Введённое значение не входит в диапазон!");
                System.out.printf("x ∈ [%s, %s]\n", x_MIN, x_MAX);
                System.out.print("x: ");
                return doubleScanner.nextDouble();
            } catch (InputMismatchException e) {
                doubleScanner.nextLine();
            }
        }

    }

    public Float readLocationY() {
        String y_MAX = "3.40282347*10^38";
        String y_MIN = "−3.40282347*10^38";
        System.out.printf("Диапазон значений: y ∈ [%s, %s]; y != null\n", y_MIN, y_MAX);
        System.out.print("y: ");

        Scanner floatScanner = new Scanner(System.in);
        Float y = null;
        try {
            y = floatScanner.nextFloat();
        } catch (InputMismatchException e) {
            floatScanner.nextLine();
        }
        while (!PersonFieldsChecker.isFieldNotNull(y)) {
            System.out.println("Введённое значение не входит в диапазон!");
            System.out.printf("y ∈ [%s, %s]\n", y_MIN, y_MAX);
            System.out.print("Повторите попытку: ");
            try {
                y = floatScanner.nextFloat();
            } catch (InputMismatchException e) {
                floatScanner.nextLine();
            }

        }
        return y;
    }

    public Double readLocationZ() {
        String z_MAX = "1.7976931348623157*10^308";
        String z_MIN = "−1.7976931348623157*10^308";
        System.out.printf("Диапазон значений: z ∈ [%s, %s]; z != null\n", z_MIN, z_MAX);
        System.out.print("z: ");

        Scanner doubleScanner = new Scanner(System.in);
        Double z = null;
        try {
            z = doubleScanner.nextDouble();
        } catch (InputMismatchException e) {
            doubleScanner.nextLine();
        }
        while (!PersonFieldsChecker.isFieldNotNull(z)) {
            System.out.println("Введённое значение не входит в диапазон!");
            System.out.printf("z ∈ [%s, %s]\n", z_MIN, z_MAX);
            System.out.print("Повторите попытку: ");
            try {
                z = doubleScanner.nextDouble();
            } catch (InputMismatchException e) {
                doubleScanner.nextLine();
            }
        }
        return z;
    }

    public double readLocationXFromFile(Scanner input) {
        try {
            return input.nextDouble();
        } catch (InputMismatchException e) {
            return .0;
        }
    }

    public Float readLocationYFromFile(Scanner input) {
        try {
            return input.nextFloat();
        } catch (InputMismatchException e) {
            return .0f;
        }
    }

    public Double readLocationZFromFile(Scanner input) {
        try {
            return input.nextDouble();
        } catch (InputMismatchException e) {
            return .0;
        }
    }
}
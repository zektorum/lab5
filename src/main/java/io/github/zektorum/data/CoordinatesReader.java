package io.github.zektorum.data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoordinatesReader {
    public Coordinates read() {
        System.out.println("Введите координаты");
        double x = this.readCoordinateX();
        Integer y = this.readCoordinateY();
        return new Coordinates(x, y);
    }

    public Coordinates readFromFile(Scanner input) {
        double x = this.readCoordinateXFromFile(input);
        Integer y = this.readCoordinateYFromFile(input);
        return new Coordinates(x, y);
    }

    private double readCoordinateX() {
        String x_MAX = "1.7976931348623157*10^308";
        System.out.printf("Диапазон значений: x ∈ (-183, %s]\n", x_MAX);
        System.out.print("x: ");

        Scanner doubleScanner = new Scanner(System.in);
        double x = -200.;
        try {
            x = doubleScanner.nextDouble();
        } catch (InputMismatchException e) {
            doubleScanner.nextLine();
        }
        while (PersonFieldsChecker.isMoreThanValue(x, -183)) {
            System.out.println("Введённое значение не входит в диапазон!");
            System.out.printf("x ∈ (-183, %s]\n", x_MAX);
            System.out.print("Повторите попытку: ");
            try {
                x = doubleScanner.nextDouble();
            } catch (InputMismatchException e) {
                doubleScanner.nextLine();
            }
        }
        return x;
    }

    private Integer readCoordinateY() {
        String y_MIN = "-2147483648";
        System.out.printf("Диапазон значений: y ∈ [%s, 750); y != null\n", y_MIN);
        System.out.print("y: ");

        Scanner intScanner = new Scanner(System.in);
        Integer y = 1000;
        try {
            y = intScanner.nextInt();
        } catch (InputMismatchException e) {
            intScanner.nextLine();
        }
        while (!PersonFieldsChecker.isLessThanValue(y, 750)) {
            System.out.println("Введённое значение не входит в диапазон!");
            System.out.printf("y ∈ [%s, 750)\n", y_MIN);
            System.out.print("Повторите попытку: ");
            try {
                y = intScanner.nextInt();
            } catch (InputMismatchException e) {
                intScanner.nextLine();
            }
        }
        return y;
    }

    private double readCoordinateXFromFile(Scanner input) {
        try {
            return input.nextDouble();
        } catch (InputMismatchException e) {
            return -183.;        }
    }

    private Integer readCoordinateYFromFile(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            return 750;
        }
    }
}

package io.github.zektorum.command;

import io.github.zektorum.data.Color;
import io.github.zektorum.data.Coordinates;
import io.github.zektorum.data.Location;
import io.github.zektorum.data.PeopleCollection;
import io.github.zektorum.data.Person;

import java.util.Scanner;

public class InsertCommand implements CommandWithTwoArgs {
    public void execute(PeopleCollection peopleCollection, Object ... args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = userInput.nextLine();

        double height = -1.;
        while (height < 0) {
            System.out.print("Введите рост: ");
            height = userInput.nextDouble();
        }

        System.out.println("Введите локацию:");
        System.out.print("x: ");
        double x = userInput.nextDouble();
        System.out.print("y: ");
        Float y = userInput.nextFloat();
        System.out.print("z: ");
        Double z = userInput.nextDouble();

        System.out.println("Введите координаты: ");
        System.out.print("x: ");
        double x2 = userInput.nextDouble();
        System.out.print("y: ");
        Integer y2 = userInput.nextInt();
        System.out.println();

        System.out.print("Введите цвет глаз: ");
        String eyeColor = userInput.nextLine();
        System.out.print("Введите цвет волос: ");
        String hairColor = userInput.nextLine();

        peopleCollection.insertElement(
                new Person(
                        name, height, new Location(x, y, z), new Coordinates(x2, y2),
                        Color.EyeColor.valueOf(eyeColor), Color.HairColor.valueOf(hairColor)
                )
        );
    }
}

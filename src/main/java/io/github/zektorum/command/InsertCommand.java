package io.github.zektorum.command;

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
        System.out.println();
        peopleCollection.insertElement(new Person(name, height, new Location(x, y, z)));
    }
}

package io.github.zektorum.command;

import io.github.zektorum.data.collection.PeopleCollection;
import io.github.zektorum.data.person.Person;
import io.github.zektorum.data.person.fields.Location;

import java.util.*;

/**
 * Реализация команды print_field_ascending_location.
 */
public class PrintFieldAscendingLocationCommand extends BaseCommand {
    public PrintFieldAscendingLocationCommand() {
        super(
                "print_field_ascending_location",
                "print_field_ascending_location",
                "вывести значения поля location всех элементов в порядке возрастания"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        if (!(arg1.equals("") && arg2.equals("") && arg3.equals(""))) {
            System.out.println("Некорректные аргументы!");
            return;
        }
        List<Location> locations = new ArrayList<>();
        Location location;
        for (Map.Entry element: peopleCollection.getPeopleCollection().entrySet()) {
            locations.add(((Person)element.getValue()).getLocation());
        }

        Collections.sort(locations);
        for (Location element : locations) {
            System.out.printf("(%.2f, %.2f, %.2f)\n", element.getX(), element.getY(), element.getZ());
        }
        System.out.println();
    }
}

package io.github.zektorum.command;

import io.github.zektorum.data.collection.PeopleCollection;
import io.github.zektorum.data.person.Person;
import io.github.zektorum.data.person.fields.Location;

import java.util.Map;
import java.util.TreeMap;

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
        TreeMap<Integer, Person> locations = new TreeMap<>();
        Location location;
        for (Map.Entry element: peopleCollection.getPeopleCollection().entrySet()) {
            location = ((Person)element.getValue()).getLocation();
            locations.put(
                    (int)Math.sqrt(Math.pow(location.getX(), 2) +
                            Math.pow((double)(location.getY()), 2) + Math.pow(location.getZ(), 2)),
                    (Person)element.getValue()
            );
        }

        for (Map.Entry element : locations.entrySet()) {
            location = ((Person)element.getValue()).getLocation();
            System.out.printf("(%.2f, %.2f, %.2f)\n", location.getX(), location.getY(), location.getZ());
        }
        System.out.println();
    }
}

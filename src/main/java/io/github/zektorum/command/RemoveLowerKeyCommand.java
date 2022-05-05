package io.github.zektorum.command;

import io.github.zektorum.data.Person;
import io.github.zektorum.data.PeopleCollection;

import java.util.Map;
import java.util.SortedMap;
import java.util.Set;
import java.util.TreeMap;

public class RemoveLowerKeyCommand extends ParentCommand implements Command {
    public RemoveLowerKeyCommand() {
        super(
                "remove_lower_key",
                "remove_lower_key null",
                "удалить из коллекции все элементы, ключ которых меньше, чем заданный"
        );
    }

    public void execute(PeopleCollection people, String arg1, String arg2) {
        try {
            Integer.parseInt(arg1);
        } catch (NumberFormatException e) {
            System.out.println("Некорректно введён аргумент!\n");
            return;
        }
        if (!arg2.equals("")) {
            System.out.println("Некорректно введён аргумент!\n");
            return;
        }
        SortedMap<Integer,Person> lowerElements = new TreeMap<>(
                people.getPeopleCollection().headMap(Integer.parseInt(arg1))
        );

        for (Map.Entry<Integer, Person> element : lowerElements.entrySet()) {
            people.removeElementById(element.getKey());
        }
        System.out.println();
    }
}

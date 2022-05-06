package io.github.zektorum.command;

import io.github.zektorum.data.Person;
import io.github.zektorum.data.PeopleCollection;
import io.github.zektorum.data.PersonCreator;

import java.util.TreeMap;
import java.util.Map;

public class RemoveLowerCommand extends ParentCommand {
    public RemoveLowerCommand() {
        super(
                "remove_lower",
                "remove_lower {element}",
                "удалить из коллекции все элементы, меньшие, чем заданный"
        );
    }

    @Override
    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        try {
            Integer.parseInt(arg2);
        } catch (NumberFormatException e) {
            System.out.println("Некорректные аргументы!\n");
            return;
        }
        PersonCreator pc = new PersonCreator(arg1, Integer.parseInt(arg2));
        Person person = pc.create();
        TreeMap<Person, Integer> myMap = new TreeMap<>();
        for (Map.Entry element : peopleCollection.getPeopleCollection().entrySet()) {
            myMap.put((Person)element.getValue(), (Integer)element.getKey());
        }

        for (Map.Entry element : myMap.headMap(person).entrySet()) {
            peopleCollection.getPeopleCollection().remove(element.getValue());
        }
    }
}

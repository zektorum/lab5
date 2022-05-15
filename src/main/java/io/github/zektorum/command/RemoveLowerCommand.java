package io.github.zektorum.command;

import io.github.zektorum.data.person.Person;
import io.github.zektorum.data.collection.PeopleCollection;
import io.github.zektorum.data.person.creation.Director;
import io.github.zektorum.data.person.creation.PersonBuilderFromUserInput;

import java.util.TreeMap;
import java.util.Map;

public class RemoveLowerCommand extends BaseCommand {
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
        Director director = new Director(new PersonBuilderFromUserInput());
        Person person = director.createPerson();
        TreeMap<Person, Integer> myMap = new TreeMap<>();
        for (Map.Entry element : peopleCollection.getPeopleCollection().entrySet()) {
            myMap.put((Person)element.getValue(), (Integer)element.getKey());
        }

        for (Map.Entry element : myMap.headMap(person).entrySet()) {
            peopleCollection.getPeopleCollection().remove(element.getValue());
        }
    }
}

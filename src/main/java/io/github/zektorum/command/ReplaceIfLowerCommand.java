package io.github.zektorum.command;

import io.github.zektorum.data.Person;
import io.github.zektorum.data.PeopleCollection;
import io.github.zektorum.data.PersonCreator;

public class ReplaceIfLowerCommand extends BaseCommand {
    public ReplaceIfLowerCommand() {
        super(
                "replace_if_lower",
                "replace_if_lower key {element}",
                "заменить значение по ключу, если новое значение меньше старого"
        );
    }

    public void execute(PeopleCollection people, String arg1, String arg2, String arg3) {
        try {
            Integer.parseInt(arg1);
            Integer.parseInt(arg3);
        } catch (NumberFormatException e) {
            System.out.println("Некорректные аргументы!\n");
            return;
        }

        PersonCreator pc = new PersonCreator(arg2, Integer.parseInt(arg3));
        Person person = pc.create();
        if (person.compareTo(people.getPeopleCollection().get(Integer.parseInt(arg1))) < 0) {
            people.getPeopleCollection().put(Integer.parseInt(arg1), person);
        }
    }
}

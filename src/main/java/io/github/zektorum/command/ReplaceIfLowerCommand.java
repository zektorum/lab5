package io.github.zektorum.command;

import io.github.zektorum.core.Interpreter;
import io.github.zektorum.data.person.Person;
import io.github.zektorum.data.collection.PeopleCollection;
import io.github.zektorum.data.person.creation.Director;
import io.github.zektorum.data.person.creation.PersonBuilder;
import io.github.zektorum.data.person.creation.PersonBuilderFromFile;
import io.github.zektorum.data.person.creation.PersonBuilderFromUserInput;

/**
 * Реализация команды replace_if_lower.
 */
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
        } catch (NumberFormatException e) {
            System.out.println("Некорректные аргументы!\n");
            return;
        }
        Person person;
        PersonBuilder personBuilder;
        if (!Interpreter.scriptsStack.get(Interpreter.scriptsStack.size() - 1).equals("Main")) {
            personBuilder = new PersonBuilderFromFile(Interpreter.input);
        } else {
            personBuilder = new PersonBuilderFromUserInput();
        }
        Director director = new Director(personBuilder);
        person = director.createPerson();

        try {
            if (person.compareTo(people.getPeopleCollection().get(Integer.parseInt(arg1))) < 0) {
                people.getPeopleCollection().put(Integer.parseInt(arg1), person);
            }
        } catch (NullPointerException e) {
            System.out.println("Элемент с таким ключём не существует!");
        }

    }
}

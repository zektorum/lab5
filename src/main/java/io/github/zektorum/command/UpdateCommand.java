package io.github.zektorum.command;

import io.github.zektorum.core.Interpreter;
import io.github.zektorum.data.collection.PeopleCollection;
import io.github.zektorum.data.person.Person;
import io.github.zektorum.data.person.creation.Director;
import io.github.zektorum.data.person.creation.PersonBuilder;
import io.github.zektorum.data.person.creation.PersonBuilderFromFile;
import io.github.zektorum.data.person.creation.PersonBuilderFromUserInput;

/**
 * Реализация команды update.
 */
public class UpdateCommand extends BaseCommand {
    public UpdateCommand() {
        super(
                "update",
                "update id {element}",
                "обновить значение элемента коллекции, id которого равен заданному"
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
        people.getPeopleCollection().put(Integer.parseInt(arg1), person);
    }
}

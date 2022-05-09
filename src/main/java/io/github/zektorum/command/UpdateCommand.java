package io.github.zektorum.command;

import io.github.zektorum.core.Interpreter;
import io.github.zektorum.data.PeopleCollection;
import io.github.zektorum.data.Person;
import io.github.zektorum.data.PersonCreator;

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
            Integer.parseInt(arg3);
        } catch (NumberFormatException e) {
            System.out.println("Некорректные аргументы!\n");
            return;
        }
        PersonCreator pc = new PersonCreator(arg2, Double.parseDouble(arg3));
        Person person;
        if (!Interpreter.scriptsStack.get(Interpreter.scriptsStack.size() - 1).equals("Main")) {
            person = pc.create(Interpreter.input);
        } else {
            person = pc.create();
        }
        int id = Integer.parseInt(arg1);
        person.setId(id);
        people.getPeopleCollection().put(id, person);
    }
}

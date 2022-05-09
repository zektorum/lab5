package io.github.zektorum.command;

import io.github.zektorum.core.Interpreter;
import io.github.zektorum.data.*;

public class InsertCommand extends BaseCommand {
    public InsertCommand() {
        super(
                "insert",
                "insert key {element}",
                "добавить новый элемент с заданным ключом"
        );
    }

    public void execute(PeopleCollection peopleCollection,
                        String arg1, String arg2, String arg3) throws NumberFormatException {
        try {
            Integer.parseInt(arg1);
            Integer.parseInt(arg3);
        } catch (NumberFormatException e) {
            System.out.println("Некорректные аргументы!\n");
            return;
        }

        PersonCreator pc = new PersonCreator(arg2, Integer.parseInt(arg3));
        if (!Interpreter.scriptsStack.get(Interpreter.scriptsStack.size() - 1).equals("Main")) {
            peopleCollection.getPeopleCollection().put(Integer.parseInt(arg1), pc.create(Interpreter.input));
        } else {
            peopleCollection.getPeopleCollection().put(Integer.parseInt(arg1), pc.create());
        }
    }
}

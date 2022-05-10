package io.github.zektorum.command;

import io.github.zektorum.core.Interpreter;
import io.github.zektorum.data.PeopleCollection;
import io.github.zektorum.data.PersonCreator;

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
        peopleCollection.insert(Integer.parseInt(arg1), arg2, Integer.parseInt(arg3));
    }
}

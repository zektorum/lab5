package io.github.zektorum.command;

import io.github.zektorum.data.*;

public class InsertCommand extends ParentCommand {
    public InsertCommand() {
        super(
                "insert",
                "insert key",
                "добавить новый элемент с заданным ключом"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) throws NumberFormatException {
        PersonCreator pc = new PersonCreator(arg1, Integer.parseInt(arg2));
        peopleCollection.insertElement(pc.create());
    }
}

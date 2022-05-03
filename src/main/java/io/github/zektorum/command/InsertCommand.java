package io.github.zektorum.command;

import io.github.zektorum.data.*;

import java.util.Scanner;

public class InsertCommand extends ParentCommand implements Command {
    public InsertCommand() {
        super(
                "insert",
                "insert key",
                "добавить новый элемент с заданным ключом"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2) throws NumberFormatException {
        PersonCreator pc = new PersonCreator(arg1, Integer.parseInt(arg2));
        peopleCollection.insertElement(pc.create());
    }
}

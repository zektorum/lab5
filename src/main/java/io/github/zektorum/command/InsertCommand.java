package io.github.zektorum.command;

import io.github.zektorum.data.*;

public class InsertCommand extends ParentCommand {
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
        peopleCollection.getPeopleCollection().put(Integer.parseInt(arg1), pc.create());
    }
}

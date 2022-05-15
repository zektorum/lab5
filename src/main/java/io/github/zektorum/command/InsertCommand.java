package io.github.zektorum.command;

import io.github.zektorum.data.collection.PeopleCollection;

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
        } catch (NumberFormatException e) {
            System.out.println("Некорректные аргументы!\n");
            return;
        }
        peopleCollection.insert(Integer.parseInt(arg1));
    }
}

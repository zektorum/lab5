package io.github.zektorum.command;

import io.github.zektorum.data.collection.PeopleCollection;

public class ClearCommand extends BaseCommand {
    public ClearCommand() {
        super(
                "clear",
                "clear",
                "очистить коллекцию "
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        if (!(arg1.equals("") && arg2.equals("") && arg3.equals(""))) {
            System.out.println("Некорректные аргументы!");
            return;
        }
        peopleCollection.clearCollection();
        System.out.println();
    }
}

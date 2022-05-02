package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public class ClearCommand extends ParentCommand implements Command {
    public ClearCommand() {
        super(
                "clear",
                "clear",
                "очистить коллекцию "
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg) {
        peopleCollection.clearCollection();
        System.out.println();
    }
}

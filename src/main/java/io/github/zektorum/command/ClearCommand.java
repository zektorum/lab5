package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public class ClearCommand extends ParentCommand {
    public ClearCommand() {
        super(
                "clear",
                "clear",
                "очистить коллекцию "
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        peopleCollection.clearCollection();
        System.out.println();
    }
}

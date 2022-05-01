package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public class ClearCommand implements Command {
    public void execute(PeopleCollection peopleCollection, String arg) {
        peopleCollection.clearCollection();
        System.out.println();
    }
}

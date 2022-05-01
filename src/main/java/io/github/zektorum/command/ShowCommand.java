package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public class ShowCommand implements Command {
    public void execute(PeopleCollection peopleCollection, String arg) {
        peopleCollection.showAll();
    }
}

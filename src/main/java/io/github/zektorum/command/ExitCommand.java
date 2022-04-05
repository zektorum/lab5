package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public class ExitCommand implements Command {
    public void execute(PeopleCollection peopleCollection, Object ... args) {
        System.exit(5);
    }
}

package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public interface CommandWithOneArg extends Command {
    void execute(PeopleCollection peopleCollection, String arg);
}

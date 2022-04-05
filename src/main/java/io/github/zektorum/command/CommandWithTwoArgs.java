package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public interface CommandWithTwoArgs extends Command {
    void execute(PeopleCollection peopleCollection, Object ... args);
}

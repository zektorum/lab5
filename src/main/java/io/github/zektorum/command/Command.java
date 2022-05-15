package io.github.zektorum.command;

import io.github.zektorum.data.collection.PeopleCollection;

public interface Command{
    void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3);
}

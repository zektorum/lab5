package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public class ExitCommand extends ParentCommand implements Command {
    public ExitCommand() {
        super(
                "exit",
                "exit",
                "завершить программу (без сохранения в файл)"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2) {
        System.exit(5);
    }
}

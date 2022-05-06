package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public class ExitCommand extends BaseCommand {
    public ExitCommand() {
        super(
                "exit",
                "exit",
                "завершить программу (без сохранения в файл)"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        System.exit(5);
    }
}

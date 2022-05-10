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
        if (!(arg1.equals("") && arg2.equals("") && arg3.equals(""))) {
            System.out.println("Некорректные аргументы!");
            return;
        }
        System.out.println("Завершение работы без сохранения...");
        System.exit(0);
    }
}

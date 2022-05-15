package io.github.zektorum.command;

import io.github.zektorum.data.collection.PeopleCollection;

/**
 * Реализация команды info.
 */
public class InfoCommand extends BaseCommand {
    public InfoCommand() {
        super(
                "info",
                "info",
                "вывести в стандартный поток вывода информацию о" +
                        " коллекции (тип, дата инициализации, количество элементов и т.д.)"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        if (!(arg1.equals("") && arg2.equals("") && arg3.equals(""))) {
            System.out.println("Некорректные аргументы!");
            return;
        }
        peopleCollection.info();
    }
}

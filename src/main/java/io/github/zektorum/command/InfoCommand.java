package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public class InfoCommand extends ParentCommand {
    public InfoCommand() {
        super(
                "info",
                "info",
                "вывести в стандартный поток вывода информацию о" +
                        " коллекции (тип, дата инициализации, количество элементов и т.д.)"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        peopleCollection.info();
    }
}

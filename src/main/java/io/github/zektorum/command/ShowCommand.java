package io.github.zektorum.command;

import io.github.zektorum.data.collection.PeopleCollection;

/**
 * Реализация команды show.
 */
public class ShowCommand extends BaseCommand {
    public ShowCommand() {
        super(
                "show",
                "show",
                "вывести в стандартный поток вывода все элементы коллекции в строковом представлении"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        if (!(arg1.equals("") && arg2.equals("") && arg3.equals(""))) {
            System.out.println("Некорректные аргументы!");
            return;
        }
        peopleCollection.showAll();
    }
}

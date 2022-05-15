package io.github.zektorum.command;

import io.github.zektorum.data.collection.PeopleCollection;

import java.io.IOException;

/**
 * Реализация команды save.
 */
public class SaveCommand extends BaseCommand {
    public SaveCommand() {
        super(
                "save",
                "save",
                "сохранить коллекцию в файл"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        if (!(arg1.equals("") && arg2.equals("") && arg3.equals(""))) {
            System.out.println("Некорректные аргументы!");
            return;
        }
        try {
            System.out.println();
            peopleCollection.saveAsFile();
        } catch (IOException e) {
            // FIXME: Обработать исключение
        }

    }
}

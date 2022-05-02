package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

import java.io.IOException;

public class SaveCommand extends ParentCommand implements Command {
    public SaveCommand() {
        super(
                "save",
                "save",
                "сохранить коллекцию в файл"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2) {
        try {
            System.out.println();
            peopleCollection.saveAsFile();
        } catch (IOException e) {
            // FIXME: Обработать исключение
        }

    }
}

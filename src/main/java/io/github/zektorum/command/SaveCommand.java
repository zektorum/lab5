package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

import java.io.IOException;

public class SaveCommand implements Command {
    public void execute(PeopleCollection peopleCollection, String arg) {
        try {
            System.out.println();
            peopleCollection.saveAsFile();
        } catch (IOException e) {
            // FIXME: Обработать исключение
        }

    }
}

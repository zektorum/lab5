package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public class AverageOfHeightCommand implements Command {
    public void execute(PeopleCollection peopleCollection, String arg) {
        System.out.printf("%.4f\n\n", peopleCollection.averageOfHeight());
    }
}

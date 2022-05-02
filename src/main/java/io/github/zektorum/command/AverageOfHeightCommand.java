package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

public class AverageOfHeightCommand extends ParentCommand implements Command {
    public AverageOfHeightCommand() {
        super(
                "average_of_height",
                "average_of_height",
                "вывести среднее значение поля height для всех элементов коллекции"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg) {
        System.out.printf("%.4f\n\n", peopleCollection.averageOfHeight());
    }
}

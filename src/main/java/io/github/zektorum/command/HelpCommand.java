package io.github.zektorum.command;

import io.github.zektorum.data.PeopleCollection;

import java.util.Set;
import org.reflections.Reflections;

import static org.reflections.scanners.Scanners.SubTypes;

public class HelpCommand extends BaseCommand {
    public HelpCommand() {
        super(
                "help",
                "help",
                "вывести справку по доступным командам"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        Reflections reflections = new Reflections("io.github.zektorum");
        Set<String> subTypes = reflections.get(SubTypes.of(BaseCommand.class));
        try {
            BaseCommand command;
            for (String type : subTypes) {
                command = (BaseCommand)Class.forName(type).newInstance();
                System.out.printf(
                        "%s\n\t%s\n\n",
                        command.getUsage(),
                        command.getDescription()
                );
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {}
    }
}

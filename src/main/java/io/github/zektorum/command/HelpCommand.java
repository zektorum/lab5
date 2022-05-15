package io.github.zektorum.command;

import io.github.zektorum.data.collection.PeopleCollection;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.reflections.Reflections;
import static org.reflections.scanners.Scanners.SubTypes;

import java.util.Set;

/**
 * Реализация команды help.
 */
public class HelpCommand extends BaseCommand {
    public HelpCommand() {
        super(
                "help",
                "help",
                "вывести справку по доступным командам"
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        if (!(arg1.equals("") && arg2.equals("") && arg3.equals(""))) {
            System.out.println("Некорректные аргументы!");
            return;
        }
        Logger.getRootLogger().setLevel(Level.OFF);
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

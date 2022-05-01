package io.github.zektorum.core;

import io.github.zektorum.command.*;
import io.github.zektorum.data.PeopleCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Interpreter {
    private final String PS1;
    private final String[] commandNames;
    private final Command[] commands;
    private final Map<String, Command> commandMap;

    {
        this.PS1 = "$";
        this.commandMap = new TreeMap<>();
        this.commandNames = new String[] {
                "info", "show", "insert", "clear", "save",
                "exit", "average_of_height"
        };
        this.commands = new Command[] {
                new InfoCommand(), new ShowCommand(), new InsertCommand(), new ClearCommand(), new SaveCommand(),
                new ExitCommand(), new AverageOfHeightCommand()
        };

        for (int i = 0; i < commandNames.length; ++i) {
            this.commandMap.put(this.commandNames[i], this.commands[i]);
        }
    }

    public void run(PeopleCollection peopleCollection) {
        Scanner userInput = new Scanner(System.in);
        List<String> tokens = new ArrayList<>();
        String line;
        String arg = "";

        while (true) {
            System.out.printf("%s ", PS1);

            line = userInput.nextLine().toLowerCase();
            tokens.addAll(Arrays.asList(line.split("\\s+")));

            if (tokens.size() == 2) {
                arg = tokens.get(1);
            }

            try {
                this.commandMap.get(tokens.get(0)).execute(peopleCollection, arg);
            } catch (NullPointerException e) {
                System.out.println("Команда не существует! Введите корректное название\n");
            }

            tokens.clear();
        }
    }
}

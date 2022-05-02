package io.github.zektorum.core;

import io.github.zektorum.command.*;
import io.github.zektorum.data.PeopleCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

public class Interpreter {
    private final int interpreterMode;
    private final String PS1;
    private final String PS2;
    private final String[] commandNames;
    private final Command[] commands;
    private final Map<String, Command> commandMap;
    private String scriptName;
    public static final List<String> scriptsStack = new ArrayList<>();
    public static int USER_INPUT = 0;
    public static int SCRIPT_INPUT = 1;

    {
        this.PS1 = "$";
        this.PS2 = ">";
        this.commandMap = new TreeMap<>();
        this.commandNames = new String[] {
                "info", "show", "insert", "clear", "save",
                "exit", "average_of_height", "execute_script", "help"
        };
        this.commands = new Command[] {
                new InfoCommand(), new ShowCommand(), new InsertCommand(), new ClearCommand(), new SaveCommand(),
                new ExitCommand(), new AverageOfHeightCommand(), new ExecuteScriptCommand(), new HelpCommand()
        };

        for (int i = 0; i < commandNames.length; ++i) {
            this.commandMap.put(this.commandNames[i], this.commands[i]);
        }
    }

    public Interpreter() {
        this.interpreterMode = Interpreter.USER_INPUT;
        this.scriptsStack.add("Main");
    }

    public Interpreter(String scriptName) {
        this.interpreterMode = Interpreter.SCRIPT_INPUT;
        this.scriptName = scriptName;
        this.scriptsStack.add(scriptName);
    }

    public void printScriptsStack() {
        for (String script : Interpreter.scriptsStack) {
            System.out.printf("* %s\n", script);
        }
    }

    public void run(PeopleCollection peopleCollection) {
        Scanner userInput = null;
        String input, promptString, arg = "";
        if (this.interpreterMode == Interpreter.USER_INPUT) {
            userInput = new Scanner(System.in);
            promptString = this.PS1;
        } else {
            try {
                userInput = new Scanner(new File(this.scriptName));
            } catch (FileNotFoundException e) {}
            promptString = this.PS2;
        }

        List<String> tokens = new ArrayList<>();
        System.out.printf("%s ", promptString);
        try {
            while (!(input = userInput.nextLine().toLowerCase()).equals(" ")) {
                if (input.equals("")) {
                    continue;
                }
                if (this.interpreterMode == Interpreter.SCRIPT_INPUT) {
                    System.out.println(input);
                }

                tokens.addAll(Arrays.asList(input.split("\\s+")));

                if (tokens.size() == 2) {
                    arg = tokens.get(1);
                }

                if (tokens.get(0).equals("execute_script") && tokens.size() == 2 && tokens.get(1).equals(this.scriptName)) {
                    System.out.println("Ошибка! Попытка рекурсивного запуска файла из самого себя\n");
                    System.out.printf("%s ", promptString);
                    tokens.clear();
                    continue;
                }

                try {
                    this.commandMap.get(tokens.get(0)).execute(peopleCollection, arg);
                } catch (NullPointerException e) {
                    System.out.println("Команда не существует! Введите корректное название\n");
                }

                tokens.clear();

                if (this.interpreterMode == Interpreter.SCRIPT_INPUT && !userInput.hasNextLine()) {
                    break;
                }

                System.out.printf("%s ", promptString);

            }
        } catch (NoSuchElementException e) {}
        Interpreter.scriptsStack.remove(scriptsStack.size() - 1);
    }

}

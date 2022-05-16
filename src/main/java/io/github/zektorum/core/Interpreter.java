package io.github.zektorum.core;

import io.github.zektorum.command.*;
import io.github.zektorum.data.collection.PeopleCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Класс реализует интерпретатор, работающий в двух режимах.
 */
public class Interpreter {
    private final int interpreterMode;
    private final String PS1;
    private final String PS2;
    private final BaseCommand[] commands;
    private final Map<String, BaseCommand> commandMap;
    private String scriptName;
    public static final List<String> scriptsStack = new ArrayList<>();
    public static Scanner input;
    public static int USER_INPUT = 0;
    public static int SCRIPT_INPUT = 1;

    {
        this.PS1 = "$";
        this.PS2 = ">";
        this.commandMap = new TreeMap<>();
        this.commands = new BaseCommand[] {
                new InfoCommand(), new ShowCommand(), new InsertCommand(), new ClearCommand(),
                new SaveCommand(), new ExitCommand(), new AverageOfHeightCommand(), new ExecuteScriptCommand(),
                new HelpCommand(), new RemoveLowerKeyCommand(), new UpdateCommand(), new RemoveLowerCommand(),
                new RemoveKeyCommand(), new ReplaceIfLowerCommand(), new CountGreaterThanEyeColorCommand(),
                new PrintFieldAscendingLocationCommand()
        };

        for (int i = 0; i < commands.length; ++i) {
            this.commandMap.put(this.commands[i].getName(), this.commands[i]);
        }
    }

    /**
     * Используется для создания интерпретатора в режиме ввода с клавиатуры.
     */
    public Interpreter() {
        this.interpreterMode = Interpreter.USER_INPUT;
        Interpreter.scriptsStack.add("Main");
    }

    /**
     * Используется для создания интерпретатора в режиме ввода из файла.
     *
     * @param scriptName название файла, содержащего команды
     */
    public Interpreter(String scriptName) {
        this.interpreterMode = Interpreter.SCRIPT_INPUT;
        this.scriptName = scriptName;
        Interpreter.scriptsStack.add(scriptName);
    }

    public static void checkInput(Scanner userInput) {
        if (!userInput.hasNextLine()) {
           System.exit(0);
        }
    }

    /**
     * Метод выводит в консоль стек вызовов скриптов.
     */
    public void printScriptsStack() {
        for (String script : Interpreter.scriptsStack) {
            System.out.printf("* %s\n", script);
        }
    }

    /**
     * Основной цикл приложения. В нём происходит парсинг пользовательского ввода/ввода из файла -
     * ввод разбивается на токены, происходит выборка команды и её последующий запуск с полученными
     * аргументами.
     * Пользователю выводится приглашение к вводу: PS1 при вводе с клавиатура и PS2 при вводе из файла.
     * Для запуска интерпретатора в режиме ввода с клавиатуры используется флаг Interpreter.USER_INPUT,
     * а для ввода из файла - Interpreter.SCRIPT_INPUT.
     *
     * @param peopleCollection коллекция объектов типа Person
     */
    public void run(PeopleCollection peopleCollection) {
        Scanner userInput = null;
        String input, promptString, arg1 = "", arg2 = "", arg3 = "";
        if (this.interpreterMode == Interpreter.USER_INPUT) {
            userInput = new Scanner(System.in);
            promptString = this.PS1;
        } else {
            try {
                userInput = new Scanner(new File(this.scriptName));
            } catch (FileNotFoundException e) {
                System.out.println("Ошибка! Файл не существует\n");
                return;
            }
            promptString = this.PS2;
        }

        Interpreter.input = userInput;
        List<String> tokens = new ArrayList<>();
        System.out.printf("%s ", promptString);
        try {
            while (userInput.hasNext() && !(input = userInput.nextLine().toLowerCase()).equals(" ")) {
                if (input.equals("")) {
                    continue;
                }
                if (this.interpreterMode == Interpreter.SCRIPT_INPUT) {
                    System.out.println(input);
                }

                tokens.addAll(Arrays.asList(input.split("\\s+")));

                if (tokens.size() > 1) {
                    arg1 = tokens.get(1);
                    if (tokens.size() == 3) {
                        arg2 = tokens.get(2);
                    }
                    if (tokens.size() == 4) {
                        arg2 = tokens.get(2);
                        arg3 = tokens.get(3);
                    }
                }

                if (tokens.get(0).equals("execute_script") && tokens.size() == 2 && tokens.get(1).equals(this.scriptName)) {
                    System.out.println("Ошибка! Попытка рекурсивного запуска файла из самого себя\n");
                    System.out.printf("%s ", promptString);
                    tokens.clear();
                    continue;
                }

                try {
                    this.commandMap.get(tokens.get(0)).execute(peopleCollection, arg1, arg2, arg3);
                } catch (NullPointerException e) {
                    System.out.println("Команда не существует! Введите корректное название\n");
                } catch (NumberFormatException e) {
                    System.out.println("Неверно введены аргументы!\n");
                }

                tokens.clear();

                if (this.interpreterMode == Interpreter.SCRIPT_INPUT && !userInput.hasNextLine()) {
                    break;
                }

                Interpreter.input = userInput;
                System.out.printf("%s ", promptString);

                arg1 = "";
                arg2 = "";
                arg3 = "";
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        Interpreter.scriptsStack.remove(scriptsStack.size() - 1);
    }

}

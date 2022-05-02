package io.github.zektorum.command;

import io.github.zektorum.core.Interpreter;
import io.github.zektorum.data.PeopleCollection;

import java.io.File;

public class ExecuteScriptCommand extends ParentCommand implements Command {
    public ExecuteScriptCommand() {
        super(
                "execute_script",
                "execute_script filename",
                "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды " +
                        "в таком же виде, в котором их вводит пользователь в интерактивном режиме."
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg) {
        if (!(new File(arg).exists())) {
            System.out.println("Некорректное имя! Файл не существует\n");
            return;
        }
        if (Interpreter.scriptsStack.contains(arg)) {
            System.out.println("Ошибка! Попытка циклического запуска скрипта\n");
            return;
        }
        Interpreter interpreter = new Interpreter(arg);
        interpreter.run(peopleCollection);
    }
}

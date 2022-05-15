package io.github.zektorum.command;

import io.github.zektorum.core.Interpreter;
import io.github.zektorum.data.collection.PeopleCollection;

import java.io.File;

public class ExecuteScriptCommand extends BaseCommand {
    public ExecuteScriptCommand() {
        super(
                "execute_script",
                "execute_script filename",
                "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды " +
                        "в таком же виде, в котором их вводит пользователь в интерактивном режиме."
        );
    }

    public void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3) {
        if (!(new File(arg1).exists())) {
            System.out.println("Некорректное имя! Файл не существует\n");
            return;
        }
        if (!new File(arg1).canRead()) {
            System.out.println("Отсутствуют права на чтение!\n");
            return;
        }
        if (Interpreter.scriptsStack.contains(arg1)) {
            System.out.println("Ошибка! Попытка циклического запуска скрипта\n");
            return;
        }
        Interpreter interpreter = new Interpreter(arg1);
        interpreter.run(peopleCollection);
    }
}

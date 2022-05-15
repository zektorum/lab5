package io.github.zektorum.core;

import io.github.zektorum.data.collection.PeopleCollection;
import io.github.zektorum.data.person.Person;
import io.github.zektorum.io.FileReader;
import io.github.zektorum.io.GsonReader;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Точка входа в приложение.
 */
public class Application {
    private final String[] args;

    /**
     * Создаёт объект приложения. Конструктор инициализирует поле класса аргументами командной строки,
     * с которыми было запущено приложение.
     *
     * @param args массив аргументов командной строки
     */
    public Application(String[] args) {
        this.args = args;
    }

    /**
     * Метод, запускающий приложение.
     */
    public void run() {
        try {
            String filename = System.getenv("FILENAME");
            if (filename == null) {
                System.out.println("Ошибка! Переменная окружения не установлена.\nЗавершение работы...");
                System.exit(8);
            }
            if (!new File(filename).canRead()) {
                System.out.println("Отсутствуют права на чтение!\nЗавершение работы...");
                System.exit(3);
            } else if (!new File(filename).canWrite()) {
                System.out.println("Отсутствуют права на запись!\nЗавершение работы...");
                System.exit(4);
            }
            FileReader fileReader = new FileReader(filename);
            Person[] structuredData = fileReader.read(new GsonReader());

            PeopleCollection peopleCollection = new PeopleCollection(structuredData);

            Interpreter interpreter = new Interpreter();
            interpreter.run(peopleCollection);

        } catch(FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }
    }
}

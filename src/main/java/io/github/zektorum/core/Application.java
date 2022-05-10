package io.github.zektorum.core;

import io.github.zektorum.data.PeopleCollection;
import io.github.zektorum.data.Person;
import io.github.zektorum.io.FileReader;
import io.github.zektorum.io.SerializableReader;

import java.io.File;
import java.io.FileNotFoundException;

public class Application {
    private final String[] args;

    public Application(String[] args) {
        this.args = args;
    }

    public void run() {
        try {
            String filename = System.getenv("FILENAME");
            if (filename == null) {
                System.out.println("Некорректное значение переменной среды!");
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
            Person[] structuredData = fileReader.read(new SerializableReader());

            PeopleCollection peopleCollection = new PeopleCollection(structuredData);

            Interpreter interpreter = new Interpreter();
            interpreter.run(peopleCollection);

        } catch(FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }
    }
}

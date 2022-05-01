package io.github.zektorum.core;

import io.github.zektorum.data.PeopleCollection;
import io.github.zektorum.data.Person;
import io.github.zektorum.io.FileReader;
import io.github.zektorum.io.JsonReader;

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
            FileReader fileReader = new FileReader(filename);
            Person[] structuredData = fileReader.read(new JsonReader());

            PeopleCollection peopleCollection = new PeopleCollection(structuredData);

            Interpreter interpreter = new Interpreter();
            interpreter.run(peopleCollection);

        } catch(FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }
    }
}

package io.github.zektorum.data;

import io.github.zektorum.core.Interpreter;
import io.github.zektorum.io.FileWriter;
import io.github.zektorum.io.SerializableWriter;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PeopleCollection {
    private TreeMap<Integer, Person> people;
    private ZonedDateTime initializationDate;
    private ArrayList<Integer> usedIds;
    private String filename;

    public PeopleCollection(Person[] structuredData) {
        this.people = new TreeMap<>();
        this.usedIds = new ArrayList<>();
        this.filename = System.getenv("FILENAME");
        if (structuredData == null) {
            System.out.println("Введён пустой файл. Завершение работы...");
            System.exit(-3);
        }
        for (Person person : structuredData) {
            if (!PersonFieldsChecker.isValidPerson(person)) {
                System.out.printf(
                        "[WARNING] Объект c id %d не соответствует критериям и не добавлен в коллекцию\n",
                        person.getId()
                );
                continue;
            }
            person.setId(this.generateId());
            this.people.put(person.getName().hashCode(), person);
            this.usedIds.add(person.getId());
        }
        this.initializationDate = ZonedDateTime.now();
    }

    public TreeMap<Integer, Person> getPeopleCollection() {
        return this.people;
    }

    public void removeElementByKey(int key) {
        if (this.isValidId(key)){
            this.people.remove(key);
        }
    }

    public void clearCollection() {
        this.usedIds.clear();
        this.people.clear();
    }

    public void saveAsFile() throws IOException {
        FileWriter writer = new FileWriter(this.filename);
        Person[] peopleArray = new Person[this.people.size()];
        int i = 0;
        for (Map.Entry<Integer, Person> person : this.people.entrySet()) {
            peopleArray[i] = person.getValue();
            ++i;
        }
        writer.write(new SerializableWriter(), peopleArray);
    }

    public void print(Integer key, Person person) {
        String format;
        if (person.getLocation() != null) {
            format = "Имя: %s\nId:  %s\nРост: %s\nДата создания: %s\nЛокация: (%.1f, %.1f, %.1f)\nКоординаты: " +
                    "(%.1f, %d)\nЦвет глаз: %s\nЦвет волос: %s\nНациональность: %s\n\n";
        } else {
            format = "Имя: %s\nId:  %s\nРост: %s\nДата создания: %s\nЛокация: (%s, %s, %s)\nКоординаты: (%s, %s)\n" +
                    "Цвет глаз: %s\nЦвет волос: %s\nНациональность: %s\n\n";
        }
        System.out.printf(
                format,
                person.getName(),
                person.getId(),
                person.getHeight(),
                person.getCreationDate().toString(),
                person.getLocation() != null ? person.getLocation().getX() : null,
                person.getLocation() != null ? person.getLocation().getY() : null,
                person.getLocation() != null ? person.getLocation().getZ() : null,
                person.getCoordinates() != null ? person.getCoordinates().getX() : null,
                person.getCoordinates() != null ? person.getCoordinates().getY() : null,
                person.getEyeColor(),
                person.getHairColor(),
                person.getNationality()
        );
    }

    public void showAll() {
        this.people.forEach(this::print);
    }

    public void info() {
        System.out.printf(
                "Тип: %s\nДата инициализации: %s\nКоличество элементов: %s\n\n",
                this.people.getClass().getName(),
                this.initializationDate,
                this.people.size()
        );
    }

    public void insert(Integer key, String name, int height) {
        PersonCreator pc = new PersonCreator(name, height);
        Person person;
        if (!Interpreter.scriptsStack.get(Interpreter.scriptsStack.size() - 1).equals("Main")) {
            person = pc.create(Interpreter.input);
            person.setId(generateId());
            this.people.put(key, person);
        } else {
            person = pc.create();
            person.setId(generateId());
            this.people.put(key, person);
        }
    }

    public double averageOfHeight() {
        double sum = 0;
        for (Map.Entry<Integer, Person> person : this.people.entrySet()) {
            sum += person.getValue().getHeight();
        }
        return sum / this.people.size();
    }

    private int generateId() {
        for (int id = 1; ; ++id) {
            if (this.usedIds.contains(id)) {
                continue;
            }
            this.usedIds.add(id);
            return id;
        }
    }

    private boolean isValidId(int id) {
        if (this.people.get(id) == null || id < 1) {
            System.out.printf("Элемент с id %s отсутствует!\n", id);
            return false;
        }
        return true;
    }
}

package io.github.zektorum.data.collection;

import io.github.zektorum.core.Interpreter;
import io.github.zektorum.data.person.*;
import io.github.zektorum.data.person.creation.Director;
import io.github.zektorum.data.person.creation.PersonBuilder;
import io.github.zektorum.data.person.creation.PersonBuilderFromFile;
import io.github.zektorum.data.person.creation.PersonBuilderFromUserInput;
import io.github.zektorum.io.FileWriter;
import io.github.zektorum.io.GsonWriter;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс-обёртка для хранения коллекции типа TreeMap.
 */
public class PeopleCollection {
    private TreeMap<Integer, Person> people;
    private ZonedDateTime initializationDate;
    private ArrayList<Integer> usedIds;
    private String filename;

    /**
     * Инициализирует коллекцию десериализованными данными.
     *
     * @param structuredData объекты, полученные из файла
     */
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
                        "[WARNING] Объект c именем %s не соответствует критериям и не добавлен в коллекцию\n",
                        person.getName()
                );
                continue;
            }
            person.setId(this.generateId());
            this.people.put(person.getName().hashCode(), person);
            this.usedIds.add(person.getId());
        }
        this.initializationDate = ZonedDateTime.now();
    }

    /**
     * @return коллекция объектов Person
     */
    public TreeMap<Integer, Person> getPeopleCollection() {
        return this.people;
    }

    /**
     * @param key ключ коллекции
     */
    public void removeElementByKey(int key) {
        if (this.isValidId(key)){
            this.people.remove(key);
        }
    }

    /**
     * Реализация команды clear.
     */
    public void clearCollection() {
        this.usedIds.clear();
        this.people.clear();
    }

    /**
     * Реализация команды save.
     *
     * @throws IOException если файл с коллекцией недоступен для записи
     */
    public void saveAsFile() throws IOException {
        FileWriter writer = new FileWriter(this.filename);
        Person[] peopleArray = new Person[this.people.size()];
        int i = 0;
        for (Map.Entry<Integer, Person> person : this.people.entrySet()) {
            peopleArray[i] = person.getValue();
            ++i;
        }
        writer.write(new GsonWriter(), peopleArray);
    }

    /**
     * Выводит один элемент коллекции в консоль.
     *
     * @param key ключ элемента
     * @param person элемент
     */
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

    /**
     * Выводит все элементы коллекции в консоль.
     */
    public void showAll() {
        if (!this.people.isEmpty()) {
            this.people.forEach(this::print);
        } else {
            System.out.println();
        }
    }

    /**
     * Выводит в консоль информацию о коллекции.
     */
    public void info() {
        System.out.printf(
                "Тип: %s\nДата инициализации: %s\nКоличество элементов: %s\n\n",
                this.people.getClass().getName(),
                this.initializationDate,
                this.people.size() // TODO: добавить вывод количества пропущенных элементов и пути к файлу коллекции
        );
    }

    public void insert(Integer key) {
        PersonBuilder personBuilder;
        Person person;
        if (!Interpreter.scriptsStack.get(Interpreter.scriptsStack.size() - 1).equals("Main")) {
            personBuilder = new PersonBuilderFromFile(Interpreter.input);
        } else {
            personBuilder = new PersonBuilderFromUserInput();
        }
        Director director = new Director(personBuilder);
        person = director.createPerson();
        person.setId(generateId());
        this.people.put(key, person);
    }

    /**
     * Реализует команду average_of_height.
     *
     * @return средний рост
     */
    public double averageOfHeight() {
        double sum = 0;
        for (Map.Entry<Integer, Person> person : this.people.entrySet()) {
            sum += person.getValue().getHeight();
        }
        return sum / this.people.size();
    }

    /**
     * Генерирует уникальный id.
     *
     * @return id
     */
    private int generateId() {
        for (int id = 1; ; ++id) {
            if (this.usedIds.contains(id)) {
                continue;
            }
            this.usedIds.add(id);
            return id;
        }
    }

    /**
     * Проверка на валидность идентификатора пользователя.
     *
     * @param id идентификатор пользователя
     * @return для валидных id - true, для остальных - false
     */
    private boolean isValidId(int id) {
        if (this.people.get(id) == null || id < 1) {
            System.out.printf("Элемент с id %s отсутствует!\n", id);
            return false;
        }
        return true;
    }
}

package io.github.zektorum.data;

import io.github.zektorum.io.FileWriter;
import io.github.zektorum.io.JsonWriter;

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
        for (Person person : structuredData) {
            this.people.put(person.getId(), person);
            this.usedIds.add(person.getId());
        }
        this.initializationDate = ZonedDateTime.now();
    }

    public TreeMap<Integer, Person> getPeopleCollection() {
        return this.people;
    }

    public void insertElement(Person person) {
        if (person == null) {
            return;
        }
        person.setId(this.generateId());
        this.people.put(person.getId(), person);

    }

    public void updateValueById(int id, Person newElement) {
        if (this.isValidId(id)) {
            newElement.setId(id);
            this.people.replace(id, newElement);
        }
    }

    public void removeElementById(int id) {
        if (this.isValidId(id)){
            this.people.remove(id);
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
            peopleArray[i] = (Person)person.getValue();
            ++i;
        }
        writer.write(new JsonWriter(), peopleArray);
    }

    public void print(Integer id, Person person) {
        System.out.printf(
                "Имя: %s\nId:  %s\nРост: %s\nЛокация: (%.1f, %.1f, %.1f)\nКоординаты: (%.1f, %d)\n" +
                "Цвет глаз: %s\nЦвет волос: %s\nНациональность: %s\n\n",
                person.getName(),
                id,
                person.getHeight(),
                person.getLocation().getX(),
                person.getLocation().getY(),
                person.getLocation().getZ(),
                person.getCoordinates().getX(),
                person.getCoordinates().getY(),
                person.getEyeColor(),
                person.getHairColor(),
                person.getNationality()
        );
    }

    public void printLocation() {
        this.people.forEach((id, person) -> System.out.println(person.getLocation()));
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

    public double averageOfHeight() {
        double average = 0, sum = 0;
        for (Map.Entry<Integer, Person> person : this.people.entrySet()) {
            sum += person.getValue().getHeight();
        }
        return sum / this.people.size();
    }

    private void changeIdIfNotValid(Person person) {
        int personId = person.getId();
        if (this.usedIds.contains(personId)) {
            person.setId(this.generateId());
        } else {
            this.usedIds.add(person.getId());
        }
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

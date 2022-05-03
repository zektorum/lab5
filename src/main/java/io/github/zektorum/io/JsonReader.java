package io.github.zektorum.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import io.github.zektorum.data.Person;

public class JsonReader implements SerializableFormatReader {
    public Person[] getStructuredData(String content) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Person[] people = new Person[]{};
        try {
            people = gson.fromJson(content, Person[].class);
        } catch (JsonSyntaxException e) {
            System.out.println("Ошибка парсинга Json! Некорректный синтаксис");
            System.out.println("Завершение работы программы...");
            System.exit(-11);
        }
        return people;
    }
}

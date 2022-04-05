package io.github.zektorum.io;

import com.google.gson.Gson;
import io.github.zektorum.data.Person;

public class JsonWriter implements SerializableFormatWriter {
    public String createContentFromStructuredData(Person[] people) {
        return new Gson().toJson(people);
    }
}

package io.github.zektorum.io;

import com.google.gson.Gson;
import io.github.zektorum.data.Person;

public class JsonReader implements SerializableFormatReader {
    public Person[] getStructuredData(String content) {
        return new Gson().fromJson(content, Person[].class);
    }
}

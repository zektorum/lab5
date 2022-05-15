package io.github.zektorum.io;

import io.github.zektorum.data.person.Person;

public interface SerializableFormatReader {
    Person[] getStructuredData(String content);
}

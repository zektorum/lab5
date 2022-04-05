package io.github.zektorum.io;

import io.github.zektorum.data.Person;

public interface SerializableFormatReader {
    Person[] getStructuredData(String content);
}

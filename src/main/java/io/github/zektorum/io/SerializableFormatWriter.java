package io.github.zektorum.io;

import io.github.zektorum.data.person.Person;

public interface SerializableFormatWriter {
    String createContentFromStructuredData(Person[] people);
}

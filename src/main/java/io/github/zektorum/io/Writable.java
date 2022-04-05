package io.github.zektorum.io;

import io.github.zektorum.data.Person;

import java.io.IOException;

public interface Writable {
    void write(SerializableFormatWriter writer, Person[] people) throws IOException;
}

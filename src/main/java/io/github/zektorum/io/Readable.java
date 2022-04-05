package io.github.zektorum.io;

import io.github.zektorum.data.Person;

import java.io.IOException;

public interface Readable {
    Person[] read(SerializableFormatReader reader) throws IOException;
}

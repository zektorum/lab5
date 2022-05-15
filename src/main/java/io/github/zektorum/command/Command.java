package io.github.zektorum.command;

import io.github.zektorum.data.collection.PeopleCollection;

/**
 * Функциональный интерфейс Command.
 */
public interface Command{
    /**
     * Метод, запускающий команду.
     *
     * @param peopleCollection коллекция объектов <code>Person</code>
     * @param arg1             позиционный аргумент №1
     * @param arg2             позиционный аргумент №2
     * @param arg3             позиционный аргумент №3
     */
    void execute(PeopleCollection peopleCollection, String arg1, String arg2, String arg3);
}

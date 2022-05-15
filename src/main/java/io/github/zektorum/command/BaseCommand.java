package io.github.zektorum.command;

/**
 * Родительский класс для всех команд.
 */
public abstract class BaseCommand implements Command {
    private String name;
    private String description;
    private String usage;

    /**
     * Конструктор задаёт информацию о команде.
     *
     * @param name        имя команды
     * @param usage       пример использования команды
     * @param description описание команды
     */
    public BaseCommand(String name, String usage, String description) {
        this.name = name;
        this.usage = usage;
        this.description = description;
    }

    /**
     * Возвращает имя команды.
     *
     * @return имя команды
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает пример использования команды.
     * Строка вида <code>command [arg] {element}</code>, где
     *  [arg] - аргумент команды,
     *  {element} - обозначение ввода элемента с клавиатуры.
     *
     * @return пример использования команды
     */
    public String getUsage() {
        return this.usage;
    }

    /**
     * Возвращает описание команды.
     *
     * @return описание команды
     */
    public String getDescription() {
        return this.description;
    }
}

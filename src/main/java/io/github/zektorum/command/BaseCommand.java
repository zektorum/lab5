package io.github.zektorum.command;

public abstract class BaseCommand implements Command {
    private String name;
    private String description;
    private String usage;

    public BaseCommand(String name, String usage, String description) {
        this.name = name;
        this.usage = usage;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getUsage() {
        return this.usage;
    }

    public String getDescription() {
        return this.description;
    }
}

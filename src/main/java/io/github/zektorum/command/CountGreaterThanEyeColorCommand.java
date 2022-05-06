package io.github.zektorum.command;

import io.github.zektorum.data.Color;
import io.github.zektorum.data.Person;
import io.github.zektorum.data.PeopleCollection;

import java.util.Map;

public class CountGreaterThanEyeColorCommand extends ParentCommand {
    public CountGreaterThanEyeColorCommand() {
        super(
                "count_greater_than_eye_color",
                "count_greater_than_eye_color eye_color",
                "вывести количество элементов, значение поля eyeColor которых больше заданного"
        );
    }

    @Override
    public void execute(PeopleCollection people, String arg1, String arg2, String arg3) {
        try {
            Color.EyeColor.valueOf(arg1.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Некорректный аргумент!\n");
            return;
        }

        int eyeColorCounter = 0;
        for (Map.Entry element : people.getPeopleCollection().entrySet()) {
            if (((Person)element.getValue()).getEyeColor().getValue() >
                Color.EyeColor.valueOf(arg1.toUpperCase()).getValue())
            {
                ++eyeColorCounter;
            }
        }
        System.out.printf("%d\n\n", eyeColorCounter);
    }
}

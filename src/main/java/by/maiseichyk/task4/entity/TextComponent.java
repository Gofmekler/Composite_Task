package by.maiseichyk.task4.entity;

import java.util.List;

public interface TextComponent {
    void add(TextComponent component);

    void remove(TextComponent component);

    int getSize();

    ComponentType getType();

    List<TextComponent> getList();

    String toString();
}

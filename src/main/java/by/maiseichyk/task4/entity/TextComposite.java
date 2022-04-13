package by.maiseichyk.task4.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TextComposite implements TextComponent {
    private ComponentType componentType;
    private List<TextComponent> componentList = new ArrayList<>();

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public void add(TextComponent component) {
        componentList.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        componentList.remove(component);
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getList() {
        return List.copyOf(componentList);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(componentType.getDelimiter(), componentType.getPrefix(), "");
        for (TextComponent textComponent : componentList) {
            stringJoiner.add(textComponent.toString());
        }
        return stringJoiner.toString();
    }
}

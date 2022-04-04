package by.maiseichyk.task4.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent{
    private ComponentType componentType;
    private List<TextComponent> componentList = new ArrayList<>();

    public TextComposite() {
    }

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
    public int getSize() {
        return componentList.size();
    }

    @Override
    public ComponentType getType(){
        return componentType;
    }

    @Override
    public List<TextComponent> getList() {
        return componentList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return "TextComposite{" +
                "componentType=" + componentType +
                ", componentList=" + componentList +
                '}';
    }
}

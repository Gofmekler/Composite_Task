package by.maiseichyk.task4.entity;

import java.util.List;

public class SymbolLeaf implements TextComponent {
    private ComponentType componentType;
    private char symbol;

    public SymbolLeaf(char symbol, ComponentType componentType) {
        this.symbol = symbol;
        this.componentType = componentType;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}

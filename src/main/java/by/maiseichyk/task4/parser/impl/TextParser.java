package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.parser.CustomParser;

public class TextParser implements CustomParser {
    private final String PARAGRAPH_DELIMITER_REGEX = "\\t";
    @Override
    public TextComponent parse(String dataLine) {
        TextComposite composite = new TextComposite(ComponentType.TEXT);
        return null;
    }
}

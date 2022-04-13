package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.parser.CustomParser;

public class TextParser implements CustomParser {
    private static final String PARAGRAPH_DELIMITER_REGEX = "\\t|\\s{4}";
    private final CustomParser successor = new ParagraphParser();

    @Override
    public TextComposite parse(String dataLine) {
        TextComposite textComposite = new TextComposite(ComponentType.TEXT);
        String[] paragraphs = dataLine.split(PARAGRAPH_DELIMITER_REGEX);
        for (String paragraph : paragraphs) {
            textComposite.add(successor.parse(paragraph));
        }
        return textComposite;
    }
}

package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.parser.CustomParser;

public class WordParser implements CustomParser {
    private final CustomParser symbolParser = new SymbolParser();

    @Override
    public TextComposite parse(String dataLine) {
        TextComposite wordComposite = new TextComposite(ComponentType.WORD);
        TextComponent wordComponent = symbolParser.parse(dataLine);
        wordComposite.add(wordComponent);
        return wordComposite;
    }
}

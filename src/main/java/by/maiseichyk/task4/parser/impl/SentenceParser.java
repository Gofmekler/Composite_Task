package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.parser.CustomParser;

public class SentenceParser implements CustomParser {
    private final CustomParser successor = new LexemeParser();

    @Override
    public TextComposite parse(String dataLine) {
        TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);
        TextComponent sentenceComponent = successor.parse(dataLine);
        sentenceComposite.add(sentenceComponent);
        return sentenceComposite;
    }
}

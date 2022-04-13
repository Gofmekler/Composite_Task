package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.parser.CustomParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements CustomParser {
    private static final String SENTENCE_REGEX = ".+?[.?!…](?=\\s|$)";
    private final CustomParser successor = new SentenceParser();

    @Override
    public TextComposite parse(String dataLine) {
        TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);
        Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = sentencePattern.matcher(dataLine);
        while(matcher.find()){
            paragraphComposite.add(successor.parse(matcher.group()));
        }
        return paragraphComposite;
    }
}

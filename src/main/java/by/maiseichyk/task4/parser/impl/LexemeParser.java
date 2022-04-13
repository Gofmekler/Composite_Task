package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.parser.CustomParser;

public class LexemeParser implements CustomParser {
    private static final String WORD_REGEX = "[a-zA-Z\\w\\p{Punct}]+";
    private static final String LEXEME_REGEX = "[(*)*\\w+\\d+\\s*]+";
    private static final String LEXEME_DELIMITER_REGEX = "\\s";
    private static final String SYMBOL_REGEX = "\\d*\\w*\\p{Punct}*";
    private static final String MATH_REGEX = "[\\d+ +*/]{2,}";
    private final CustomParser wordParser = new WordParser();
    private final CustomParser expressionParser = new MathExpressionParser();

    @Override
    public TextComposite parse(String dataLine) {

        TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
        String[] splittedData = dataLine.split(LEXEME_DELIMITER_REGEX);
        for (String component : splittedData) {
            if (component.matches(WORD_REGEX)) {
                TextComponent wordComponent = wordParser.parse(component);
                lexemeComposite.add(wordComponent);
            } else if (component.matches(MATH_REGEX)) {
                System.out.println(component);
                TextComponent mathExpression = expressionParser.parse(component);
                lexemeComposite.add(mathExpression);
            }
        }
        return lexemeComposite;
    }
}


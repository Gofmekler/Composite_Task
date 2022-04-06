package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.parser.CustomParser;

import java.util.regex.Matcher;

public class LexemeParser implements CustomParser{
    private final String WORD_REGEX = "([a-zA-Z]{2,}\\d*\\p{Punct}*)+";
    private final String LEXEME_DELIMITER_REGEX = "\\s+";
    private final String SYMBOL_REGEX = "\\d*\\w*\\p{Punct}*";
    private CustomParser wordParser = new WordParser();
    private CustomParser symbolParser = new SymbolParser();

    @Override
    public TextComponent parse(String dataLine) {
        TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
        String[] splittedData = dataLine.split(LEXEME_DELIMITER_REGEX);
        for(String component : splittedData){
            if(component.matches(WORD_REGEX)){
                TextComponent wordComponent = wordParser.parse(component);
                lexemeComposite.add(wordComponent);
            }
            else if(component.matches(SYMBOL_REGEX)){
                TextComponent symbolComponent = symbolParser.parse(component);
                lexemeComposite.add(symbolComponent);
            }
        }
        return lexemeComposite;
    }
}

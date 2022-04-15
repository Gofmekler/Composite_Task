package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.exception.CustomException;
import by.maiseichyk.task4.parser.FileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser implements FileParser {
    private static final String WORD_REGEX = "([-_]*[a-zA-ZА-я(0-9)?]+)";
    private static final String LEXEME_DELIMITER_REGEX = "\\s";
    private static final String SYMBOL_REGEX = ".+";
    private static final String MATH_REGEX = "([(-]*\\d+[-+*/]+[\\d\\-+*/()]*)";
    private static final Logger LOGGER = LogManager.getLogger();
    private final FileParser wordParser = new WordParser();
    private final FileParser expressionParser = new MathExpressionParser();
    private final FileParser symbolParser = new SymbolParser();

    @Override
    public TextComposite parse(String dataLine) throws CustomException {

        TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
        String[] splittedData = dataLine.split(LEXEME_DELIMITER_REGEX);
        for (String component : splittedData) {
            if (component.matches(MATH_REGEX)) {
                TextComponent mathExpression = expressionParser.parse(component);
                LOGGER.info("Mathematical Expression parser was called from lexeme parser");
                lexemeComposite.add(mathExpression);
            } else if (component.matches(WORD_REGEX)) {
                TextComponent wordComponent = wordParser.parse(component);
                LOGGER.info("Word parser was called from lexeme parser");
                lexemeComposite.add(wordComponent);
            } else if (component.matches(SYMBOL_REGEX)) {
                TextComponent symbolComponent = symbolParser.parse(component);
                LOGGER.info("Symbol parser was called from lexeme parser");
                lexemeComposite.add(symbolComponent);
            }
        }
        return lexemeComposite;
    }
}



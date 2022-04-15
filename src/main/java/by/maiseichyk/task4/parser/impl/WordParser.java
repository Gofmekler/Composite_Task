package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.exception.CustomException;
import by.maiseichyk.task4.parser.FileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements FileParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private final FileParser symbolParser = new SymbolParser();

    @Override
    public TextComposite parse(String dataLine) throws CustomException {
        TextComposite wordComposite = new TextComposite(ComponentType.WORD);
        LOGGER.info("Symbol parser was called from word parser.");
        TextComponent wordComponent = symbolParser.parse(dataLine);
        wordComposite.add(wordComponent);
        return wordComposite;
    }
}

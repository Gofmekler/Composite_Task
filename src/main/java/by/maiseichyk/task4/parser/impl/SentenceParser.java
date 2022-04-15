package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.exception.CustomException;
import by.maiseichyk.task4.parser.FileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser implements FileParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private final FileParser successor = new LexemeParser();

    @Override
    public TextComposite parse(String dataLine) throws CustomException {
        TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);
        TextComponent sentenceComponent = successor.parse(dataLine);
        LOGGER.info("Lexeme parser was called from sentence parser");
        sentenceComposite.add(sentenceComponent);
        return sentenceComposite;
    }
}

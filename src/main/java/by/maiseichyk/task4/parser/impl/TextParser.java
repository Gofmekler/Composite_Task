package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.exception.CustomException;
import by.maiseichyk.task4.parser.FileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser implements FileParser {
    private static final String PARAGRAPH_DELIMITER_REGEX = "\\t|\\s{4}";
    private static final Logger LOGGER = LogManager.getLogger();
    private final FileParser successor = new ParagraphParser();

    @Override
    public TextComposite parse(String dataLine) throws CustomException {
        LOGGER.info("Chain of responsibility has started.");
        TextComposite textComposite = new TextComposite(ComponentType.TEXT);
        if (!dataLine.isEmpty()) {
            String[] paragraphs = dataLine.split(PARAGRAPH_DELIMITER_REGEX);
            for (String paragraph : paragraphs) {
                LOGGER.info("Paragraph parser was called form text parser.");
                textComposite.add(successor.parse(paragraph));
            }
        } else {
            LOGGER.error("Data is empty.");
            throw new CustomException("Data is empty.");
        }
        return textComposite;
    }
}

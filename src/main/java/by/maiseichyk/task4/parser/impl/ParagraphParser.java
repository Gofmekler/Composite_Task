package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.exception.CustomException;
import by.maiseichyk.task4.parser.FileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements FileParser {
    private static final String SENTENCE_REGEX = ".+?[.?!…](?=\\s|$)";
    private static final Logger LOGGER = LogManager.getLogger();
    private final FileParser successor = new SentenceParser();

    @Override
    public TextComposite parse(String dataLine) throws CustomException {
        TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);
        Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = sentencePattern.matcher(dataLine);
        while (matcher.find()) {
            LOGGER.info("Sentence parser was called from paragraph parser");
            paragraphComposite.add(successor.parse(matcher.group()));
        }
        return paragraphComposite;
    }
}

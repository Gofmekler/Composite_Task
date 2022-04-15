package by.maiseichyk.task4;

import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.exception.CustomException;
import by.maiseichyk.task4.parser.impl.TextParser;
import by.maiseichyk.task4.reader.FileReader;
import by.maiseichyk.task4.reader.impl.FileReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {
    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws CustomException {
        FileReader reader = new FileReaderImpl();
        String values = reader.readFile("src/main/resources/datafile.txt");
        TextParser symbolParser = new TextParser();
        TextComposite textComposite;
        textComposite = symbolParser.parse(values);
        LOGGER.info("Parsed Text - " + textComposite.toString());
    }
}

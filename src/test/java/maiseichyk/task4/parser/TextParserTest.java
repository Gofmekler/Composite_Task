package maiseichyk.task4.parser;

import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.exception.CustomException;
import by.maiseichyk.task4.parser.FileParser;
import by.maiseichyk.task4.parser.impl.TextParser;
import by.maiseichyk.task4.reader.FileReader;
import by.maiseichyk.task4.reader.impl.FileReaderImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextParserTest {
    private static final String FILE_PATH = "src/test/resources/formattedText.txt";
    private final FileReader reader = new FileReaderImpl();
    private final FileParser parser = new TextParser();

    @Test
    public void testParse() throws CustomException {
        String data = reader.readFile(FILE_PATH);
        TextComposite actual = parser.parse(data);
        String expected = "\tBut also the leap into to and a electronic, remaining unchanged.";
        assertEquals(actual.toString(), expected);

    }
}
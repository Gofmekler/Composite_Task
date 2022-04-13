package maiseichyk.task4.reader;

import by.maiseichyk.task4.reader.impl.CustomReaderImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomReaderImplTest {

    @Test
    public void testReadFile() {
        CustomReaderImpl customReader = new CustomReaderImpl();
        String actual = customReader.readFile("src/test/resources/dataFileTest.txt");
        String expected = "    Bye.    It is the established fact that a reader will. Be of a page when looking at its layout...    It has survived -not only 5 centuries. But also the leap into electronic, remaining unchanged. It was popularised. In the with the release.";
        assertEquals(actual, expected);
    }
}
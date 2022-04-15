package maiseichyk.task4.interpreter;

import by.maiseichyk.task4.interpreter.FromInfixToPostfixConverter;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class FromInfixToPostfixConverterTest {
    private final FromInfixToPostfixConverter converter = new FromInfixToPostfixConverter();

    @org.testng.annotations.Test
    public void testConverter() {
        String data = "44+5+6";
        List<String> actual = converter.convert(data);
        List<String> expected = new ArrayList<>();
        expected.add("44");
        expected.add("5");
        expected.add("+");
        expected.add("6");
        expected.add("+");
        assertEquals(actual, expected);
    }
}
package maiseichyk.task4.service;

import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.parser.CustomParser;
import by.maiseichyk.task4.parser.impl.TextParser;
import by.maiseichyk.task4.reader.CustomReader;
import by.maiseichyk.task4.reader.impl.CustomReaderImpl;
import by.maiseichyk.task4.service.impl.TextOperationImpl;
import static org.testng.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextOperationImplTest {
    CustomReader reader = new CustomReaderImpl();
    private final CustomParser parser = new TextParser();
    private TextComposite textComposite;
    TextOperationImpl textOperation = new TextOperationImpl();

    @org.testng.annotations.Test
    public void testSortParagraphs() {
        String stringTest = reader.readFile("src/test/resources/dataFileTest.txt");
        textComposite = parser.parse(stringTest);
        List<TextComponent> actualComposite = textOperation.sortParagraphs(textComposite);
        String testString = reader.readFile("src/test/resources/dataFileTest.txt");
        List<TextComponent> expectedComposite = parser.parse(testString).getList();
        assertEquals(actualComposite.toString(), expectedComposite.toString());
    }

    @org.testng.annotations.Test
    public void testFindTheSentenceWithTheLongestWord() {
        String stringTest = reader.readFile("src/test/resources/dataFileTest.txt");
        textComposite = parser.parse(stringTest);
        List<TextComponent> actualComposite = textOperation.findTheSentenceWithTheLongestWord(textComposite);
        String testString = reader.readFile("src/test/resources/longestWordSentence.txt");
        List<TextComponent> expectedComposite = parser.parse(testString).getList();
        assertEquals(actualComposite.toString(), expectedComposite.toString());
    }

    @org.testng.annotations.Test
    public void testFormatTextWithTheTerm() {
        String stringTest = reader.readFile("src/test/resources/dataFileTest.txt");
        textComposite = parser.parse(stringTest);
        List<TextComponent> actualComposite = textOperation.formatTextWithTheTerm(textComposite, 11);
        String testString = reader.readFile("src/test/resources/formattedText.txt");
        List<TextComponent> expectedComposite = parser.parse(testString).getList();
        assertEquals(actualComposite.toString(), expectedComposite.toString());
    }

    @org.testng.annotations.Test
    public void testCountTheSameWords() {
        String stringTest = reader.readFile("src/test/resources/dataFileTest.txt");
        textComposite = parser.parse(stringTest.strip());
        Map<String, Long> actual = textOperation.countTheSameWords(textComposite);
        Map<String, Long> expected = new HashMap<>();
        System.out.println(actual);
        expected.put("the", 4L);
        expected.put("a", 2L);
        expected.put("it", 3L);
        assertEquals(actual, expected);
    }

    @org.testng.annotations.Test
    public void testCountVowels() {
        String stringTest = reader.readFile("src/test/resources/dataFileTest.txt");
        textComposite = parser.parse(stringTest);
        long actualNumber = textOperation.countVowels(textComposite);
        long expectedNumber = 84;
        assertEquals(actualNumber, expectedNumber);
    }

    @org.testng.annotations.Test
    public void testCountConsonants() {
        String stringTest = reader.readFile("src/test/resources/dataFileTest.txt");
        textComposite = parser.parse(stringTest);
        long actualNumber = textOperation.countConsonants(textComposite);
        long expectedNumber = 199;
        assertEquals(actualNumber, expectedNumber);
    }
}
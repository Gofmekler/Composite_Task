package by.maiseichyk.task4.service;

import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;

import java.util.List;
import java.util.Map;

public interface TextOperation {

    List<TextComponent> sortParagraphs(TextComposite textComposite);

    List<TextComponent> findTheSentenceWithTheLongestWord(TextComposite textComposite);

    List<TextComponent> formatTextWithTheTerm(TextComposite textComposite, int term);

    Map<String, Long> countTheSameWords(TextComposite textComposite);

    long countVowels(TextComposite textComposite);

    long countConsonants(TextComposite textComposite);
}

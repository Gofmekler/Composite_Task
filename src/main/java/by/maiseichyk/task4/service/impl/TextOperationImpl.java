package by.maiseichyk.task4.service.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.service.TextOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class TextOperationImpl implements TextOperation {
    private static final String VOWELS_REGEX = "(?i:[aeiouyаоэеиыуёюя])";
    private static final String CONSONANTS_REGEX = "(?i:[^!,()_@*#$&.:&&[^aeiouyаоэеиыуёюя]])";
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<TextComponent> sortParagraphs(TextComposite textComposite) {
        LOGGER.info("Sort paragraphs method was called.");
        return textComposite.getList().stream()
                .sorted(Comparator.comparingInt(o -> o.getList().size()))
                .toList();
    }

    @Override
    public List<TextComponent> findSentenceWithLongestWord(TextComposite textComposite) {
        LOGGER.info("Finding sentence with longest word method was called.");
        int maxLength = findLongestWordLength(textComposite);
        return textComposite.getList().stream()
                .flatMap(p -> p.getList().stream())
                .flatMap(s -> s.getList().stream())
                .filter(l -> l.getList().stream()
                        .anyMatch(w -> w.getType().equals(ComponentType.WORD) && w.toString().length() == maxLength)).toList();
    }

    @Override
    public List<TextComponent> deleteShortSentence(TextComposite textComposite, int term) {
        LOGGER.info("Deleting short sentences method was called.");
        return textComposite.getList().stream()
                .flatMap(p -> p.getList().stream())
                .filter(s -> s.getList().stream()
                        .flatMap(l -> l.getList().stream())
                        .filter(w -> w.getType().equals(ComponentType.WORD)).count() >= term).toList();
    }


    @Override
    public Map<String, Long> countTheSameWords(TextComposite textComposite) {
        LOGGER.info("Counting the same words method was called.");
        Map<String, Long> words = textComposite.getList().stream()
                .flatMap(p -> p.getList().stream())
                .flatMap(s -> s.getList().stream())
                .flatMap(l -> l.getList().stream())
                .filter(w -> w.getType().equals(ComponentType.WORD))
                .collect(Collectors.groupingBy(w -> w.toString().toLowerCase().strip(), Collectors.counting()));
        words.entrySet().removeIf(w -> w.getValue() == 1);
        return words;
    }

    @Override
    public long countVowels(TextComposite textComposite) {
        LOGGER.info("Counting vowels method was called.");
        return textComposite.getList().stream()
                .flatMap(p -> p.getList().stream())
                .flatMap(s -> s.getList().stream())
                .flatMap(l -> l.getList().stream())
                .filter(w -> w.getType().equals(ComponentType.WORD))
                .flatMap(w -> w.getList().stream())
                .flatMap(s -> s.getList().stream())
                .filter(s -> s.toString().matches(VOWELS_REGEX))
                .count();
    }

    @Override
    public long countConsonants(TextComposite textComposite) {
        LOGGER.info("Counting consonants method was called.");
        return textComposite.getList().stream()
                .flatMap(p -> p.getList().stream())
                .flatMap(s -> s.getList().stream())
                .flatMap(l -> l.getList().stream())
                .filter(w -> w.getType().equals(ComponentType.WORD))
                .flatMap(w -> w.getList().stream())
                .flatMap(s -> s.getList().stream())
                .filter(s -> s.toString().matches(CONSONANTS_REGEX))
                .count();
    }

    private int findLongestWordLength(TextComposite textComposite) {
        LOGGER.info("Find longest words length private method was called.");
        TextComponent textComponent = textComposite.getList().stream()
                .flatMap(p -> p.getList().stream())
                .flatMap(s -> s.getList().stream())
                .flatMap(l -> l.getList().stream())
                .filter(w -> w.getType().equals(ComponentType.WORD))
                .max(Comparator.comparingInt(w -> w.toString().length()))
                .get();
        return textComponent.toString().length();
    }
}

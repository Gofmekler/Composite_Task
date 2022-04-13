package by.maiseichyk.task4.service.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.service.TextOperation;

import java.util.*;
import java.util.stream.Collectors;

public class TextOperationImpl implements TextOperation{
    private static final String VOWELS_REGEX = "(?i:[aeiouyаоэеиыуёюя])";
    private static final String CONSONANTS_REGEX = "(?i:[^!,()_@*#$&.:&&[^aeiouyаоэеиыуёюя]])";

    @Override
    public List<TextComponent> sortParagraphs(TextComposite textComposite) {
        return textComposite.getList().stream()
                .sorted(Comparator.comparingInt(o -> o.getList().size()))
                .toList();
    }

    @Override
    public List<TextComponent> findTheSentenceWithTheLongestWord(TextComposite textComposite) {
        int maxLength = findLongestWordLength(textComposite);
        return textComposite.getList().stream()
                .flatMap(p -> p.getList().stream())
                .flatMap(s -> s.getList().stream())
                .filter(l -> l.getList().stream()
                        .anyMatch(w -> w.getType().equals(ComponentType.WORD) && w.toString().length() == maxLength)).toList();
    }

    @Override
    public List<TextComponent> formatTextWithTheTerm(TextComposite textComposite, int term) {
        return textComposite.getList().stream()
                .flatMap(p -> p.getList().stream())
                .filter(s -> s.getList().stream()
                    .flatMap(l -> l.getList().stream())
                    .filter(w -> w.getType().equals(ComponentType.WORD)).count() >= term).toList();
    }


    @Override
    public Map<String, Long> countTheSameWords(TextComposite textComposite) {
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

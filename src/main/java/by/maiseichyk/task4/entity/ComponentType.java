package by.maiseichyk.task4.entity;

public enum ComponentType {
    TEXT("\n\t", "\t"),
    PARAGRAPH(" ", ""),
    SENTENCE(" ", ""),
    LEXEME(" ", ""),
    WORD(" ", ""),
    DIGIT("", ""),
    LETTER("", ""),
    SYMBOL("", ""),
    MATH_EXPRESSION("", ""),
    PUNCTUATION("", "");
    private String delimiter;
    private String prefix;

    ComponentType(String delimiter, String prefix) {
        this.delimiter = delimiter;
        this.prefix = prefix;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getPrefix() {
        return prefix;
    }

}

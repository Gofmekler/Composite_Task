package by.maiseichyk.task4.entity;

public enum ComponentType{
    TEXT("\n\t"),
    PARAGRAPH("\t"),
    SENTENCE(" "),
    LEXEME(" "),
    WORD(""),
    DIGIT(""),
    LETTER(""),
    SYMBOL(""),
    PUNCTUATION("");
    private String delimiter;

    ComponentType(String delimiter){
        this.delimiter = delimiter;
    }

    public String getDelimiter(){
        return delimiter;
    }

}

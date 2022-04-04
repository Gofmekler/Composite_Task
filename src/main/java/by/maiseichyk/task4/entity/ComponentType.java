package by.maiseichyk.task4.entity;

public enum ComponentType{
    PARAGRAPH("\t"),
    SENTENCE(" "),
    LEXEME(" "),
    WORD(""),
    LETTER(""),
    PUNCTUATION("");
    private String delimiter;

    ComponentType(String delimiter){
        this.delimiter = delimiter;
    }

    public String getDelimiter(){
        return delimiter;
    }

}

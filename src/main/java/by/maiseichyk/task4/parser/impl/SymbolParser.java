package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.SymbolLeaf;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.parser.CustomParser;

public class SymbolParser implements CustomParser {

    @Override
    public TextComponent parse(String dataLine) {
        TextComposite symbolComposite = new TextComposite(ComponentType.SYMBOL);
        char[] symbols = dataLine.toCharArray();
        for (char symbol : symbols){
            if(Character.isDigit(symbol)){
            symbolComposite.add(new SymbolLeaf(symbol, ComponentType.DIGIT));
            }
            else if(Character.isLetter(symbol)){
                symbolComposite.add(new SymbolLeaf(symbol, ComponentType.LETTER));
            }
            else{
                symbolComposite.add(new SymbolLeaf(symbol, ComponentType.PUNCTUATION));
            }
        }
        return symbolComposite;
    }
}

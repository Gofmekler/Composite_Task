package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.SymbolLeaf;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.exception.CustomException;
import by.maiseichyk.task4.parser.FileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolParser implements FileParser {
    private static Logger LOGGER = LogManager.getLogger();

    @Override
    public TextComposite parse(String dataLine) throws CustomException {
        LOGGER.info("Symbol parser has started.");
        TextComposite symbolComposite = new TextComposite(ComponentType.SYMBOL);
        char[] symbols = dataLine.toCharArray();
        for (char symbol : symbols) {
            if (Character.isDigit(symbol)) {
                symbolComposite.add(new SymbolLeaf(symbol, ComponentType.DIGIT));
            } else if (Character.isLetter(symbol)) {
                symbolComposite.add(new SymbolLeaf(symbol, ComponentType.LETTER));
            } else {
                symbolComposite.add(new SymbolLeaf(symbol, ComponentType.PUNCTUATION));
            }
        }
        return symbolComposite;
    }
}

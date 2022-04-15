package by.maiseichyk.task4.parser;

import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.exception.CustomException;

public interface FileParser {
    TextComposite parse(String dataLine) throws CustomException;
}

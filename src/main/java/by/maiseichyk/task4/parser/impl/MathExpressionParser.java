package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.exception.CustomException;
import by.maiseichyk.task4.interpreter.Context;
import by.maiseichyk.task4.interpreter.MathematicalExpression;
import by.maiseichyk.task4.interpreter.FromInfixToPostfixConverter;
import by.maiseichyk.task4.interpreter.PolishNotationEstimation;
import by.maiseichyk.task4.parser.FileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MathExpressionParser implements FileParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private final FileParser successor = new SymbolParser();
    private final PolishNotationEstimation polishNotation = new PolishNotationEstimation();

    @Override
    public TextComposite parse(String dataLine) throws CustomException {
        LOGGER.info("Mathematical expression parser has started.");
        Context context = new Context();
        FromInfixToPostfixConverter converter = new FromInfixToPostfixConverter();
        TextComposite mathComposite = new TextComposite(ComponentType.MATH_EXPRESSION);
        List<String> polishNotationList = converter.convert(dataLine);
        List<MathematicalExpression> mathExpressionList = polishNotation.estimate(polishNotationList);
        for (MathematicalExpression expression : mathExpressionList) {
            expression.interpret(context);
        }
        dataLine = context.pop().toString();
        TextComponent mathExpression = successor.parse(dataLine);
        mathComposite.add(mathExpression);
        return mathComposite;
    }
}

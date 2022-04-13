package by.maiseichyk.task4.parser.impl;

import by.maiseichyk.task4.entity.ComponentType;
import by.maiseichyk.task4.entity.TextComponent;
import by.maiseichyk.task4.entity.TextComposite;
import by.maiseichyk.task4.interpreter.Context;
import by.maiseichyk.task4.interpreter.MathematicalExpression;
import by.maiseichyk.task4.interpreter.PolishNotationCalculate;
import by.maiseichyk.task4.interpreter.PolishNotationParser;
import by.maiseichyk.task4.parser.CustomParser;

import java.util.List;

public class MathExpressionParser implements CustomParser {
    private final CustomParser successor = new SymbolParser();
    private final PolishNotationParser polishNotationParser = new PolishNotationParser();

    @Override
    public TextComposite parse(String dataLine) {
        // TODO: 13.04.2022
        Context context = new Context();
        PolishNotationCalculate polishNotationCalculate = new PolishNotationCalculate();
        TextComposite mathComposite = new TextComposite(ComponentType.MATH_EXPRESSION);
        List<String> polishNotationList = polishNotationCalculate.calculate(dataLine);
        List<MathematicalExpression> mathExpressionList = polishNotationParser.parse(polishNotationList);
        mathExpressionList.forEach(expression -> expression.interpret(context));
        dataLine = context.pop().toString();
        TextComponent mathExpression = successor.parse(dataLine);
        mathComposite.add(mathExpression);
        return mathComposite;
    }
}

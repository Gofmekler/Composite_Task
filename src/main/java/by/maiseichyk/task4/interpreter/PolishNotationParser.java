package by.maiseichyk.task4.interpreter;

import java.util.ArrayList;
import java.util.List;

public class PolishNotationParser {
    public List<MathematicalExpression> parse(List<String> polishData) {

        List<MathematicalExpression> mathExpression = new ArrayList<>();
        polishData.forEach(token -> {
            switch (token) {
                case "+" -> mathExpression.add(c -> c.push(c.pop() + c.pop()));
                case "-" -> mathExpression.add(c -> c.push(-c.pop() + c.pop()));
                case "/" -> mathExpression.add(c -> c.push(1 / c.pop() * c.pop()));
                case "*" -> mathExpression.add(c -> c.push(c.pop() * c.pop()));
                default -> mathExpression.add(c -> c.push(Double.parseDouble(token)));
            }
        });
        return mathExpression;
    }
}

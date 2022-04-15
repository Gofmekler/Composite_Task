package by.maiseichyk.task4.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PolishNotationEstimation {
    private static Logger LOGGER = LogManager.getLogger();

    public List<MathematicalExpression> estimate(List<String> polishData) {

        List<MathematicalExpression> mathExpression = new ArrayList<>();
        polishData.forEach(token -> {
            switch (token) {
                case "+" -> {
                    mathExpression.add(c -> c.push(c.pop() + c.pop()));
                    LOGGER.info("Operator plus was found - result is added to result line");
                }
                case "-" -> {
                    mathExpression.add(c -> c.push(-c.pop() + c.pop()));
                    LOGGER.info("Operator minus was found - result is added to result line");
                }
                case "/" -> {
                    mathExpression.add(c -> c.push(1 / c.pop() * c.pop()));
                    LOGGER.info("Operator divide was found - result is added to result line");
                }
                case "*" -> {
                    mathExpression.add(c -> c.push(c.pop() * c.pop()));
                    LOGGER.info("Operator multiply was found - result is added to result line");
                }
                default -> {
                    mathExpression.add(c -> c.push(Double.parseDouble(token)));
                    LOGGER.info("Number was found - result is added to result line");
                }
            }
        });
        return mathExpression;
    }
}

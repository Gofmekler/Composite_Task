package by.maiseichyk.task4.interpreter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FromInfixToPostfixConverter {
    private static final String OPERATOR = "+-*/";
    private static final String DELIMITER = "()";
    private static final Logger LOGGER = LogManager.getLogger();

    public FromInfixToPostfixConverter() {
    }

    public List<String> convert(String dataLine) {
        List<String> resultList = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < dataLine.length(); i++) {
            Character currentSymbol = dataLine.charAt(i);
            if (DELIMITER.contains(currentSymbol.toString())) {
                LOGGER.info("Delimiter - " + currentSymbol + " was found in data line");
                if ("(".equals(currentSymbol.toString())) {
                    stack.push(currentSymbol);
                } else if (")".equals(currentSymbol.toString())) {
                    while (!stack.peek().equals('(')) {
                        resultList.add(stack.pop().toString());
                    }
                    stack.pop();
                }
            } else if (OPERATOR.contains(currentSymbol.toString())) {
                LOGGER.info("Operator (" + currentSymbol + ") was found in data line");
                if ("-".equals(currentSymbol.toString()) && ('(' == dataLine.charAt(i - 1) || i == 0)) {
                    String fullNumber = readFullNumber(dataLine, i + 1);
                    resultList.add("0");
                    resultList.add(fullNumber);
                    resultList.add("-");
                } else {
                    while (!stack.isEmpty() && (getPriority(currentSymbol) <= getPriority(stack.peek()))) {
                        resultList.add(stack.pop().toString());
                    }
                }
                stack.push(currentSymbol);
            } else {
                String fullNumber = readFullNumber(dataLine, i);
                LOGGER.info("Number was found in data = " + fullNumber);
                resultList.add(fullNumber);
                i += fullNumber.length() - 1;
            }
        }
        if (OPERATOR.contains(stack.peek().toString())) {
            while (!stack.isEmpty()) {
                resultList.add(stack.pop().toString());
            }
        } else {
            LOGGER.error("Brackets are not coordinated.");
        }

        return resultList;
    }

    private static String readFullNumber(String data, int index) {
        String number = "";
        while (data.length() > index
                && !DELIMITER.contains(String.valueOf(data.charAt(index)))
                && !OPERATOR.contains(String.valueOf(data.charAt(index)))) {
            number = number.concat(Character.toString(data.charAt(index)));
            index++;
        }
        return number;
    }

    private static int getPriority(Character token) {
        int priority = 0;
        if (token.equals('*') | token.equals('/')) {
            priority = 2;
        }
        if (token.equals('+') | token.equals('-')) {
            priority = 1;
        }
        return priority;
    }
}

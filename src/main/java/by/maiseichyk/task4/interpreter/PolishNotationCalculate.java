package by.maiseichyk.task4.interpreter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PolishNotationCalculate {
    private static final String OPERATOR = "+-*/";
    private static final String DELIMITER = "()";

    public PolishNotationCalculate() {
    }

    public List<String> calculate(String dataLine) {
        List<String> resultList = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < dataLine.length(); i++) {
            Character currentSymbol = dataLine.charAt(i);
            if (DELIMITER.contains(currentSymbol.toString())) {
                if ("(".equals(currentSymbol.toString())) {
                    stack.push(currentSymbol);
                } else if (")".equals(currentSymbol.toString())) {
                    while (!stack.peek().equals('(')) {
                        resultList.add(stack.pop().toString());
                    }
                    stack.pop();
                }
            } else if (OPERATOR.contains(currentSymbol.toString())) {
//                if ("-".equals(currentSymbol.toString()) && ('(' == dataLine.charAt(i - 1) || i == 0)) {
//                    stack.push(currentSymbol);
//                }
//                else{
//                    while (priority(currentSymbol) >= priority(stack.peek()) && !stack.peek().equals("(")) {
//                        resultList.add(stack.pop().toString());
//                    }
//                }

                stack.push(currentSymbol);
            } else {
                resultList.add(currentSymbol.toString());
            }
        }
        return resultList;
    }

    private static int priority(Character token) {
        int priority = 4;
        if (token.equals('(') || token.equals(')')) {
            priority = 1;
        }
        if (token.equals('*') || token.equals('/')) {
            priority = 2;
        }
        if (token.equals('+') || token.equals('-')) {
            priority = 3;
        }
        return priority;
    }
}

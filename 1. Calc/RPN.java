package com.example.u7er.calc;

import java.util.*;
import java.lang.*;

class RPN {
    static String Calculate(String input){
        List<String> expression = Parse(input);
        if (isParse) {
            try {
                return Counting(expression);
            } catch (Exception e) {
                return "Выражение некорректно.";
            }
        }

        return "Неизвестная ошибка.";
    }

    private static String OPERATORS = "+-*/";

    private static String DELIMITERS = "() ," + OPERATORS;

    private static boolean isParse = true;

    private static List<String> Parse(String infix) {
        List<String> postfix = new ArrayList<String>();
        Deque<String> stack = new ArrayDeque<String>();
        StringTokenizer tokenizer = new StringTokenizer(infix, DELIMITERS, true);
        String prev = "";
        String curr = "";
        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                System.out.println("Некорректное выражение.");
                isParse = false;
                return postfix;
            }
            if (curr.equals(" ")) continue;
            if (isFunction(curr)) stack.push(curr);
            else if (isDelimiter(curr)) {
                if (curr.equals("(")) stack.push(curr);
                else if (curr.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                        if (stack.isEmpty()) {
                            System.out.println("Скобки не согласованы.");
                            isParse = false;
                            return postfix;
                        }
                    }
                    stack.pop();
                    if (!stack.isEmpty() && isFunction(stack.peek())) {
                        postfix.add(stack.pop());
                    }
                }
                else {
                    if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev) && !prev.equals(")")))) {
                        // унарный минус
                        curr = "u-";
                    }
                    else {
                        while (!stack.isEmpty() && (getPriority(curr) <= getPriority(stack.peek()))) {
                            postfix.add(stack.pop());
                        }

                    }
                    stack.push(curr);
                }

            }

            else {
                postfix.add(curr);
            }
            prev = curr;
        }

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) postfix.add(stack.pop());
            else {
                System.out.println("Скобки не согласованы.");
                isParse = false;
                return postfix;
            }
        }
        return postfix;
    }

    private static boolean isFunction(String token) {
        return (token.equals("log") ||
                token.equals("sin") ||
                token.equals("pow") ||
                token.equals("cos") );
    }

    private static String Counting(List<String> postfix) {
        Deque<Double> stack = new ArrayDeque<Double>();
        for (String x : postfix) {
            switch (x) {
                case "log":
                    stack.push(Math.log10(stack.pop()));
                    break;
                case "sin":
                    stack.push(Math.sin(stack.pop()));
                    break;
                case "pow":
                    Double a_pow = stack.pop();
                    Double b_pow = stack.pop();
                    stack.push(Math.pow(b_pow, a_pow));
                    break;
                case "cos":
                    stack.push(Math.cos(stack.pop()));
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-": {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/": {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                case "u-":
                    stack.push(-stack.pop());
                    break;
                case ",":
                    break;
                default:
                    stack.push(Double.valueOf(x));
                    break;
            }
        }
        return Double.toString(stack.pop());
    }

    private static boolean isDelimiter(String token) {
        if (token.length() != 1) return false;
        for (int i = 0; i < DELIMITERS.length(); i++) {
            if (token.charAt(0) == DELIMITERS.charAt(i)) return true;
        }
        return false;
    }

    private static boolean isOperator(String token) {
        if (token.equals("u-")) return true;
        for (int i = 0; i < OPERATORS.length(); i++) {
            if (token.charAt(0) == OPERATORS.charAt(i)) return true;
        }
        return false;
    }

    private static int getPriority(String token) {
        if (token.equals("(")) return 1;
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        return 4;
    }
}

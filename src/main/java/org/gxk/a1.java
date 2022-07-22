package org.gxk;

import java.util.Stack;

/**
 * 数学公式计算
 */
public class a1 {

    final static Stack<String> operators = new Stack<>();
    final static Stack<Double> values = new Stack<>();

    public static void main(String[] args) {
        String f = "2 * ( 1 + 7 )";
        calculate(f);
        System.out.println(values.peek());
    }

    static void calculate(String formula) {
        String[] vs = formula.split(" ");
        for (String s : vs) {
            if (s.equals("("))
                continue;
            if (isOperator(s)) {
                operators.push(s);
                continue;
            }
            if (s.equals(")")) {
                calculate();
                continue;
            }
            values.push(Double.valueOf(s));
        }

        while (values.size() > 1) {
            calculate();
        }
    }

    static void calculate() {
        String pop = operators.pop();
        Double v1 = values.pop();
        Double v2 = values.pop();
        double v = switch (pop) {
            case "+" -> v2 + v1;
            case "-" -> v2 - v1;
            case "*" -> v2 * v1;
            case "/" -> v2 / v1;
            default -> throw new RuntimeException("未知计算符号");
        };
        values.push(v);
    }


    static boolean isOperator(String v) {
        return switch (v) {
            case "+", "-", "*", "/" -> true;
            default -> false;
        };
    }

}

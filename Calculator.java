package main.com.vorh.test;

import java.util.regex.Pattern;

/**
 * Created by vorh on 7/18/17.
 */
public class Calculator {

    private static final Pattern PATTERN = Pattern.compile("(?=[\\-\\*\\+\\/])|(?<=[\\-\\*\\+\\/])");

    public static void main(String[] args) {

        String firstValue = null;
        String secondValue = null;
        String operationValue = null;
        try {
            String expression = args[0];
            String[] split = PATTERN.split(expression);

            firstValue = split[0];
            operationValue = split[1];
            secondValue = split[2];

        } catch (Exception e) {
            System.out.println("Invalid argument");
            return;
        }


        Operation operation = Operation.getEnum(operationValue);
        double first = parseNumber(firstValue);
        double second = parseNumber(secondValue);


        double result = calculate(operation, first, second);

        System.out.println("Result:" + ((int) result));


    }

    /**
     * Parse number
     * @param num
     * @throws IllegalArgumentException when parsing
     * @return double value
     */

    private static Double parseNumber(String num) {
        if (!Utils.isNumeric(num)) {
            throw new IllegalArgumentException("Error parsing number");
        } else {
            return Double.parseDouble(num);
        }
    }


    /**
     * Calculate value
     * @param operation
     * @param first
     * @param second
     * @return
     */

    private static double calculate(Operation operation, double first, double second) {
        double result = 0;
        switch (operation) {
            case SUM:
                result = first + second;
                break;
            case DIVISION:
                result = first / second;
                break;
            case SUBTRACTION:
                result = first - second;
                break;
            case MULTIPLICATION:
                result = first * second;
                break;
        }
        return result;
    }


}

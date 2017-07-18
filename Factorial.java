package main.com.vorh.test;

/**
 * Created by vorh on 7/18/17.
 */
public class Factorial {

    public static void main(String[] args) {
        String arg = null;
        try {
            arg = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid argument");
            return;
        }


        if (!arg.isEmpty() && Utils.isNumeric(arg)) {

            int number = 0;
            try {
                number = (int) Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                System.out.println("Input numeric value");
                return;
            }

            System.out.println("Result: " + factorial(number));
            System.out.println("Result recursion: " +factorialRecursion(number));
        } else {
            System.out.println("Entered value is not a number");
        }
    }


    /**
     * Calculate factorial via recursion
     * @param number
     * @return
     */

    private static long factorialRecursion(int number) {
        return (number == 0) ? 1 : number * factorialRecursion(number - 1);
    }


    /**
     * Calculate factorial via an usually method
     * @param number
     * @return
     */

    private static long factorial(int number) {
        int fact = 1;
        for (; number > 0; fact *= number--) ;
        return fact;
    }


}

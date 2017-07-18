package main.com.vorh.test;

/**
 * Created by vorh on 7/18/17.
 */
public class Utils {
    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

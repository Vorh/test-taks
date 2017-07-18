package main.com.vorh.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by vorh on 7/18/17.
 */
public class CalculatorWords {

    private static final Pattern PATTERN = Pattern.compile("[^\\pL]");

    public static void main(String[] args) {

        String path = null;
        String match = null;
        try {
            path = args[0];
            match = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid arguments");
        }

        int countWord = countWord(path, match);

        System.out.println("Count words " + countWord);

    }


    /**
     * Calculate words in file
     * @param path
     * @param token
     * @return Number of words found
     */

    private static int countWord(String path, String token) {
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            try {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = PATTERN.split(line,0);
                    for (String word : words) {
                        if (word.equals(token)) {
                            count++;
                        }
                    }
                }

            } finally {
                br.close();
            }

        } catch (IOException e) {
            System.out.println("No such file or directory");
        }

        return count;
    }
}

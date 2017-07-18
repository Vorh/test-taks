package main.com.vorh.test;

import java.io.*;

/**
 * Created by vorh on 7/18/17.
 */
public class CopyFile {

    public static void main(String[] args) {

        String pathToCopyFile = null;
        String pathOut = null;
        try {
            pathToCopyFile = args[0];
            pathOut = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid arguments");
            return;
        }

        if (pathToCopyFile.isEmpty() || pathOut.isEmpty()) {
            System.out.println("Argument is empty");
            return;
        }

        File source = new File(pathToCopyFile);
        File out = new File(pathOut);


        long startTime = System.nanoTime();
        boolean result = copyFile(source, out);
        long timeCopy = System.nanoTime() - startTime;

        System.out.println("Copy " + (result ? "success" : "error"));

        if (result) {
            System.out.println("Time: \n"
                    + timeCopy + "ns\n"
                    + timeCopy / 1000000 + "ms\n"
                    + timeCopy / 1000000_0 + "s");
        }

    }

    /**
     * Method copies file
     *
     * @param fileToCopy file for copy
     * @param out        directory and name copied file
     * @return boolean copy result
     */

    private static boolean copyFile(File fileToCopy, File out) {

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            try {
                inputStream = new FileInputStream(fileToCopy);
                outputStream = new FileOutputStream(out);

                byte[] buffer = new byte[1024];
                int length;

                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }

            } finally {
                inputStream.close();
                outputStream.close();
            }
        } catch (IOException e) {
            System.out.println("No such file or directory");
            return false;
        }
        return true;
    }
}

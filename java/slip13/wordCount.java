import java.io.*;
import java.util.*;

public class wordCount {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage: java FileWordLineCount filename");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("file does not exist");
            return;
        }

        int lines = 0, words = 0;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lines++;
                String[] w = line.trim().split("s+");
                if (!(w.length == 1 && w[0].equals(""))) {
                    words += w.length;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("error reading file");
        }

        System.out.println("number of lines: " + lines);
        System.out.println("number of words: " + words);
    }
}

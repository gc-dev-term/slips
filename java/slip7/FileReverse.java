
import java.io.*;
import java.util.*;

public class FileReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file txt name : ");
        String fileName = sc.nextLine();

        try {
            StringBuilder content = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }

            content.reverse();

            StringBuilder modified = new StringBuilder();
            for (int i = 0; i < content.length(); i++) {
                char ch = content.charAt(i);
                if (Character.isUpperCase(ch)) {
                    modified.append(Character.toLowerCase(ch));
                } else if (Character.isLowerCase(ch)) {
                    modified.append(Character.toUpperCase(ch));
                } else {
                    modified.append(ch);
                }
            }

            System.out.println("---Modified File Content---");
            System.out.println(modified);

        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }

    }
}

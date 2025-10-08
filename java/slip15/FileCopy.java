import java.io.*;
import java.util.*;

public class FileCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st file name src.txt : ");
        String srcFile = sc.nextLine();

        System.out.print("Enter 2nd file name dest.txt : ");
        String destFile = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(srcFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Contents copied from 1st file to 2nd file successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}

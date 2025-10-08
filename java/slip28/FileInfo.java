import java.io.File;
import java.util.*;

public class FileInfo {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String fName = sc.nextLine();

        File file = new File(fName);

        if (file.exists()) {
            System.out.println("File exists: Yes");
            System.out.println("readable: " + file.canRead());
            System.out.println("writable: " + file.canWrite());

            if (file.isFile()) {
                System.out.println("Type Regular file");
            } else if (file.isDirectory()) {
                System.out.println("Type directory");
            } else {
                System.out.println("Type  unknown");
            }

            System.out.println(" file length: " + file.length());
        } else {
            System.out.println("file does not exist!");
        }

    }
}

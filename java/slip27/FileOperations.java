import java.io.File;
import java.util.Scanner;

public class FileOperations
 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("plz enter either file name or directory name as command line argument");
            return;
        }

        String path = args[0];
        File f = new File(path);

        if (!f.exists()) {
            System.out.println("The path does not exist");
            return;
        }

        if (f.isDirectory()) {
            System.out.println("It is a Directory.");
            File[] files = f.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
            if (files != null && files.length > 0) {
                System.out.println("Text files found in directory: " + files.length);
                Scanner sc = new Scanner(System.in);
                System.out.print("Do you want to delete all text files?[ yes/no ]: ");
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("yes")) {
                    int count = 0;
                    for (File file : files) {
                        if (file.delete()) {
                            count++;
                        }
                    }
                    System.out.println("Deleted " + count + " text files.");
                } else {
                    System.out.println("Deletion cancelled.");
                }
            } else {
                System.out.println("No txt files found in this directory.");
            }
        } else if (f.isFile()) {
            System.out.println("It is a File.");
            System.out.println("Name: " + f.getName());
            System.out.println("Path: " + f.getAbsolutePath());
            System.out.println("Readable: " + f.canRead());
            System.out.println("Writable: " + f.canWrite());
            System.out.println("File size (bytes): " + f.length());
            System.out.println("Parent directory: " + f.getParent());
        } else {
            System.out.println("The given path is neither a regular file nor a directory.");
        }
    }
}

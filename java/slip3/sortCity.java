import java.util.*;

public class sortCity {

    public static void Display_Or(String arr[]) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(" " + arr[i]);
        }
    }

    public static void Display_sorted(String arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(" " + arr[i]);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("how many cities you enter: ");
        int len = sc.nextInt();
         sc.nextLine();

        String arr[] = new String[len];

        System.out.println("Enter cities :");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextLine();
        }
        System.out.println("----Display original----");
        Display_Or(arr);
        System.out.println("----Display original sorted----");
        Display_sorted(arr);
    }
}

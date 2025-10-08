import java.util.*;

public class diagSum {

public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number of row and col: ");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        System.out.println("Enter the elements of 2D:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i][i];
        }

        System.out.println("Sum of diagonal elements = " + sum);
    }

}

import java.util.*;

public class MatrixOperations {

    public static void Add(int arr[][], int brr[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(" " +( arr[i][j] + brr[i][j]));
            }
            System.out.println();
        }
    }

    public static void Mut(int arr[][], int brr[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(" " + arr[i][j] * brr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter row size: ");
        int row = sc.nextInt();

        System.out.println("Enter row size: ");
        int col = sc.nextInt();

        int arr[][] = new int[row][col];
        int brr[][] = new int[row][col];

        System.out.println("Enter 1st arr elements :");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter 2nd arr elements :");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                brr[i][j] = sc.nextInt();
            }
        }

        int ch = 0;
        do {
            System.out.println("0.Exit");
            System.out.println("1.Addition");
            System.out.println("2.Mutiplication");
            System.out.println("--Enter your choice--");
            ch = sc.nextInt();
            switch (ch) {
                case 0:
                    return;
                case 1:
                    Add(arr, brr, row, col);
                    break;
                case 2:
                    Mut(arr, brr, row, col);
                    break;
            }
        } while (ch != 3);

    }
}
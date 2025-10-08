import java.util.Scanner;

public class ArrayTranspose {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of row: ");
        int row = sc.nextInt();
        System.out.print("Enter size of col: ");
        int col = sc.nextInt();

        int[][] arr = new int[row][col];

        System.out.println("Enter  elements in 2D Array :");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] trans = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                trans[j][i] = arr[i][j];
            }
        }

        System.out.println("---Transpose matrix---");
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(trans[i][j] + " ");
            }
            System.out.println();
        }

    }
}

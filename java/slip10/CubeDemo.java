import java.util.*;

interface Cube {
    int calculate(int n);
}

public class CubeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number: ");
        int num = sc.nextInt();

        Cube cube = n -> n * n * n;

        int result = cube.calculate(num);
        System.out.println("cube of " + num + " is: " + result);
    }
}

import java.util.*;

interface SqrOpr {
    int square(int num);
}

public class Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter  number: ");
        int number = sc.nextInt();

        SqrOpr sq = n -> n * n;

        int result = sq.square(number);

        System.out.println("square is " + result);
    }
}

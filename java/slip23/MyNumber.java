import java.util.Scanner;

class MyNum {
    private int num;

    MyNum() {
        this.num = 0;
    }

    MyNum(int num) {
        this.num = num;
    }

    boolean isNegative() {
        return num < 0;
    }

    boolean isPositive() {
        return num > 0;
    }

    boolean isZero() {
        return num == 0;
    }

    boolean isOdd() {
        return num % 2 != 0;
    }

    boolean isEven() {
        return num % 2 == 0;
    }

    void display() {
        System.out.println("--- Number Details ---");
        System.out.println("Number   : " + num);
        System.out.println("Negative : " + isNegative());
        System.out.println("Positive : " + isPositive());
        System.out.println("Zero     : " + isZero());
        System.out.println("Odd      : " + isOdd());
        System.out.println("Even     : " + isEven());
    }
}

public class MyNumber {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int value = sc.nextInt();

        MyNum nm = new MyNum(value);
        nm.display();
    }
}

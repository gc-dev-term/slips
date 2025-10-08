import java.util.*;

class NumberZeroException extends Exception {
    public NumberZeroException(String msg) {
        super(msg);
    }
}

public class PrimeCheck {

    static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= (num/2); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number: ");
        int num = sc.nextInt();

        try {
            if (num == 0) {
                throw new NumberZeroException("number is 0");
            }
            if (isPrime(num)) {
                System.out.println(num + " is prime");
            } else {
                System.out.println(num + " is not prime");
            }
        } catch (NumberZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}

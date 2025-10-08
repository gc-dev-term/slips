import java.util.Scanner;

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class LoginValidation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("enter username: ");
        String username = input.nextLine();

        System.out.print("enter password: ");
        String password = input.nextLine();

        try {
            if (!username.equals(password)) {
                throw new InvalidPasswordException("invalid password: username and password must be same");
            }
            System.out.println("login successful!");
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }

        input.close();
    }
}

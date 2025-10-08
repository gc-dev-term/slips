import java.util.*;

class Customer {
    private String name;
    private String phoneNumber;

    public void readDetails(Scanner sc) {
        System.out.print("Enter customer name: ");
        name = sc.nextLine();
        System.out.print("Enter phone number: ");
        phoneNumber = sc.nextLine();
    }

    public void displayDetails() {
        System.out.println("Name          : " + name);
        System.out.println("Phone Number  : " + phoneNumber);
    }
}

class Depositor extends Customer {
    private String accountNumber;
    private double balance;

    @Override
    public void readDetails(Scanner sc) {
        super.readDetails(sc);
        System.out.print("Enter account number: ");
        accountNumber = sc.nextLine();
        System.out.print("Enter balance: ");
        balance = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance       : " + balance);
    }
}

class Borrower extends Depositor {
    private String loanNumber;
    private double loanAmount;

    @Override
    public void readDetails(Scanner sc) {
        super.readDetails(sc);
        System.out.print("Enter loan number: ");
        loanNumber = sc.nextLine();
        System.out.print("Enter loan amount: ");
        loanAmount = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Loan Number   : " + loanNumber);
        System.out.println("Loan Amount   : " + loanAmount);
    }
}

public class CustomerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = Integer.parseInt(sc.nextLine());

        Borrower[] customers = new Borrower[n];

        for (int i = 0; i < n; i++) {
            System.out.println("--- Enter details for Customer " + (i + 1) + " ---");
            customers[i] = new Borrower();
            customers[i].readDetails(sc);
        }

        System.out.println("=========== Customer Details ===========");
        for (int i = 0; i < n; i++) {
            System.out.println("Customer " + (i + 1) + " Information:");
            System.out.println("------------------------------------");
            customers[i].displayDetails();
        }
    }
}

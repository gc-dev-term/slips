
import java.util.Scanner;

class BankAccount {
    int accNo;
    String accHolderName;
    double bal;

    public BankAccount(int accNo, String accHolderName, double initialBal) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.bal = initialBal;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            bal += amount;
            System.out.println("Amount " + amount + " deposited successfully");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= bal) {
            bal -= amount;
            System.out.println("" + amount + " withdrawn successfully.");
        } else if (amount > bal) {
            System.out.println("Insufficient balance");
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }

    public void getBalance() {
        System.out.println("Account Details:");
        System.out.println("Account No: " + accNo);
        System.out.println("Account Holder: " + accHolderName);
        System.out.println("Current Balance: " + bal);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount act = new BankAccount(99, "Abc", 9999.99);

        int ch;
        do {

            System.out.println("0. Exit");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 0:
                    return;
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    act.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wth = sc.nextDouble();
                    act.withdraw(wth);
                    break;
                case 3:
                    act.getBalance();
                    break;
            }
        } while (ch != 4);

    }
}

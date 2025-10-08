import java.util.*;

class Acct {
    String custName;
    long accNo;

    public Acct() {
        custName = "";
        accNo = 0;
    }

    public Acct(String custName, long accNo) {
        this.custName = custName;
        this.accNo = accNo;
    }
}

class SavAcct extends Acct {
    double savingBal;
    double minBal;

    public SavAcct() {
        super();
        savingBal = 0.0;
        minBal = 0.0;
    }

    public SavAcct(String custName, long accNo, double savingBal, double minBal) {
        super(custName, accNo);
        this.savingBal = savingBal;
        this.minBal = minBal;
    }
}

class AcctDtl extends SavAcct {
    double depositAmt;
    double withdrawalAmt;

    public AcctDtl(String custName, long accNo, double savingBal, double minBal,
                         double depositAmt, double withdrawalAmt) {
        super(custName, accNo, savingBal, minBal);
        this.depositAmt = depositAmt;
        this.withdrawalAmt = withdrawalAmt;
    }

    public void displayDetails() {
        System.out.println("customer name: " + custName);
        System.out.println("account number: " + accNo);
        System.out.println("saving balance: " + savingBal);
        System.out.println("minimum balance: " + minBal);
        System.out.println("deposit amount: " + depositAmt);
        System.out.println("withdrawal amount: " + withdrawalAmt);
        double NBal = savingBal + depositAmt - withdrawalAmt;
        System.out.println("updated balance: " + NBal);
        if (NBal < minBal) {
            System.out.println(" balance below minimum required");
        }
    }
}

public class AccountDetail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter customer name: ");
        String name = sc.nextLine();

        System.out.print("enter account number: ");
        long accNo = sc.nextLong();

        System.out.print("enter saving balance: ");
        double savingBal = sc.nextDouble();

        System.out.print("enter minimum balance: ");
        double minBal = sc.nextDouble();

        System.out.print("enter deposit amount: ");
        double deposit = sc.nextDouble();

        System.out.print("enter withdrawal amount: ");
        double withdrawal = sc.nextDouble();

        AcctDtl customer = new AcctDtl(name, accNo, savingBal, minBal, deposit, withdrawal);
        System.out.println("--- customer account details ---");
        customer.displayDetails();
    }
}

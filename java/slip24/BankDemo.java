abstract class Bank {
    abstract void DisplayBal();
}

class BankA extends Bank {
    private int bal = 100;
    void DisplayBal() {
        System.out.println("Balance in Bank A is :" + bal);
    }
}

class BankB extends Bank {
    private int bal = 150;
    void DisplayBal() {
        System.out.println("Balance in Bank B is :" + bal);
    }
}

class BankC extends Bank {
    private int bal = 200;
    void DisplayBal() {
        System.out.println("Balance in Bank C is :" + bal);
    }
}

public class BankDemo {
    public static void main(String args[]) {

        BankA a = new BankA();
        BankB b = new BankB();
        BankC c = new BankC();

        a.DisplayBal();
        b.DisplayBal();
        c.DisplayBal();
    }
}

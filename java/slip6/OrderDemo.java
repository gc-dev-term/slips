import java.util.*;

abstract class Order {
    int id;
    String description;

    abstract void accept(Scanner sc);
    abstract void display();
}

class PurchaseOrder extends Order {
    String customerName;

    void accept(Scanner sc) {
        System.out.print("Enter Purchase Order ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Description: ");
        description = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();
    }

    void display() {
        System.out.println("--- Purchase Order ---");
        System.out.println("Order ID      : " + id);
        System.out.println("Description   : " + description);
        System.out.println("Customer Name : " + customerName);
    }
}

class SalesOrder extends Order {
    String vendorName;
    void accept(Scanner sc) {
        System.out.print("Enter Sales Order ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Description: ");
        description = sc.nextLine();

        System.out.print("Enter Vendor Name: ");
        vendorName = sc.nextLine();
    }
    void display() {
        System.out.println("--- Sales Order ---");
        System.out.println("Order ID     : " + id);
        System.out.println("Description  : " + description);
        System.out.println("Vendor Name  : " + vendorName);
    }
}

public class OrderDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PurchaseOrder[] po = new PurchaseOrder[3];
        for (int i = 0; i < 3; i++) {
            po[i] = new PurchaseOrder();
            System.out.println("Enter details for Purchase Order " + (i + 1));
            po[i].accept(sc);
        }
        SalesOrder[] so = new SalesOrder[3];
        for (int i = 0; i < 3; i++) {
            so[i] = new SalesOrder();
            System.out.println("Enter details for Sales Order " + (i + 1));
            so[i].accept(sc);
        }

        System.out.println("---Purchase Orders---");
        for (PurchaseOrder p : po) {
            p.display();
        }
        System.out.println("---Sales Orders---");
        for (SalesOrder s : so) {
            s.display();
        }

    }
}

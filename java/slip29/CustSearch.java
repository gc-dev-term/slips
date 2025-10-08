import java.util.Scanner;

class Customer {
    private int customerId;
    private String name;
    private String contact;
    private String address;

    Customer(int customerId, String name, String contact, String address) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    void display() {
        System.out.println("--- Customer Details ---");
        System.out.println("Customer No : " + customerId);
        System.out.println("Name        : " + name);
        System.out.println("Contact     : " + contact);
        System.out.println("Address     : " + address);
    }
}

public class CustSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();
        sc.nextLine();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for customer " + (i + 1) + ":");

            System.out.print("Customer No: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Contact: ");
            String contact = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            customers[i] = new Customer(id, name, contact, address);
        }

        System.out.print("Enter contact number to search: ");
        String searchContact = sc.nextLine();

        boolean found = false;
        for (Customer c : customers) {
            if (c.getContact().equals(searchContact)) {
                System.out.println("Customer Found!");
                c.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No customer found with contact: " + searchContact);
        }

    }
}

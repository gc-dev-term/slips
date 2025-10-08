import java.util.Scanner;

class Item {
    int item_num;
    String item_name;
    double item_price;
    static int count = 0;

    Item() {
        item_num = 0;
        item_name = "";
        item_price = 0.0;
        count++;
    }

    Item(int number, String name, double price) {
        item_num = number;
        item_name = name;
        item_price = price;
        count++;
    }

    static int getCount() {
        return count;
    }

    void display() {
        System.out.println("--- Item Details ---");
        System.out.println("Item Number : " + item_num);
        System.out.println("Item Name   : " + item_name);
        System.out.println("Item Price  : " + item_price);
        System.out.println("Total Objects Created: " + getCount());
    }
}

public class ItemDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many items do you want to enter? ");
        int n = sc.nextInt();
        sc.nextLine();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Item " + (i + 1));
            System.out.print("Enter item number: ");
            int num = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter item name: ");
            String name = sc.nextLine();

            System.out.print("Enter item price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            items[i] = new Item(num, name, price);
        }

        System.out.println("===== All Item Details =====");
        for (Item it : items) {
            it.display();
        }

    }
}

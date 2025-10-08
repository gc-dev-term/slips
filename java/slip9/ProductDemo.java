import java.util.*;

interface Marker {
}

class Product implements Marker {
    int productId;
    String productName;
    double productCost;
    int productQuantity;
    static int count = 0;

    Product() {
        productId = 0;
        productName = "Unknown";
        productCost = 0.0;
        productQuantity = 0;
        count++;
    }

    Product(int id, String name, double cost, int qty) {
        productId = id;
        productName = name;
        productCost = cost;
        productQuantity = qty;
        count++;
    }

    void display() {
        System.out.println("ID: " + productId +
                           ", Name: " + productName +
                           ", Cost: " + productCost +
                           ", Quantity: " + productQuantity);
    }
}

public class ProductDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Product " + (i + 1));

            System.out.print("Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Product Name: ");
            String name = sc.nextLine();

            System.out.print("Product Cost: ");
            double cost = sc.nextDouble();

            System.out.print("Product Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            products[i] = new Product(id, name, cost, qty);
        }

        System.out.println("--- Product Details ---");
        for (Product p : products) {
            p.display();
        }

        System.out.println("Total Products Created: " + Product.count);


    }
}

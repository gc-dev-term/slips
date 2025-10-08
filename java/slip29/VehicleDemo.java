import java.util.Scanner;

class Vehicle {
    String company;
    double price;

    Vehicle(String company, double price) {
        this.company = company;
        this.price = price;
    }

    void display() {
        System.out.println("Company : " + company);
        System.out.println("Price   : " + price);
    }
}

class LightMotorVehicle extends Vehicle {
    double mileage;

    LightMotorVehicle(String company, double price, double mileage) {
        super(company, price);
        this.mileage = mileage;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Mileage : " + mileage + " km/l");
    }
}

class HeavyMotorVehicle extends Vehicle {
    double capacityInTons;

    HeavyMotorVehicle(String company, double price, double capacityInTons) {
        super(company, price);
        this.capacityInTons = capacityInTons;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Capacity: " + capacityInTons + " tons");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Vehicle " + (i + 1));
            System.out.print("Enter type of vehicle [light/heavy]: ");
            String type = sc.nextLine();

            System.out.print("Enter company name: ");
            String company = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            if (type.equalsIgnoreCase("light")) {
                System.out.print("Enter mileage (km/l): ");
                double mileage = sc.nextDouble();
                vehicles[i] = new LightMotorVehicle(company, price, mileage);
            } else if (type.equalsIgnoreCase("heavy")) {
                System.out.print("Enter capacity (tons): ");
                double capacity = sc.nextDouble();
                vehicles[i] = new HeavyMotorVehicle(company, price, capacity);
            } else {
                System.out.println("Invalid type. Try again!");
                i--;
            }
            sc.nextLine();
        }

        System.out.println("===== Vehicle Information =====");
        for (int i = 0; i < n; i++) {
            System.out.println("Vehicle " + (i + 1));
            vehicles[i].display();
        }
    }
}

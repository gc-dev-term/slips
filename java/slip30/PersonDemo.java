import java.util.Scanner;

class Person {
    private String name;
    private String aadhar;
    private String pan;

    Person(String name, String aadhar, String pan) {
        this.name = name;
        this.aadhar = aadhar;
        this.pan = pan;
    }

    void display() {
        System.out.println("--- Person Details ---");
        System.out.println("Name   : " + name);
        System.out.println("Aadhar : " + aadhar);
        System.out.println("PAN    : " + pan);
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        sc.nextLine();

        Person[] persons = new Person[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Aadhar No: ");
            String aadhar = sc.nextLine();

            System.out.print("PAN No: ");
            String pan = sc.nextLine();

            persons[i] = new Person(name, aadhar, pan);
        }

        System.out.println("===== All Person Details =====");
        for (Person p : persons) {
            p.display();
        }


    }
}

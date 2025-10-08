import java.io.*;
import java.util.*;
import java.text.*;

class Donor implements Serializable {
    String name;
    int age;
    String address;
    int cont_No;
    String bloodGroup;
    String lastDonationDate;

    Donor(String name, int age, String address, int cont_no, String bloodGroup, String lastDonationDate) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.cont_No = cont_no;
        this.bloodGroup = bloodGroup;
        this.lastDonationDate = lastDonationDate;
    }

    void display() {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("address: " + address);
        System.out.println("contact number: " + cont_No);
        System.out.println("blood group: " + bloodGroup);
        System.out.println("last donation date: " + lastDonationDate);

    }
}

public class BloodDonor {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter number of donors: ");
        int n = Integer.parseInt(sc.nextLine());

        Donor[] dor = new Donor[n];

        for (int i = 0; i < n; i++) {
            System.out.println("enter details of donor " + (i + 1));
            System.out.print("name: ");
            String name = sc.nextLine();
            System.out.print("age: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.print("address: ");
            String add = sc.nextLine();
            System.out.print("contact number: ");
            int cont = Integer.parseInt(sc.nextLine());
            System.out.print("blood group: ");
            String bloodGroup = sc.nextLine();
            System.out.print("last donation date (dd-MM-yyyy): ");
            String lastdonation_date = sc.nextLine();

            dor[i] = new Donor(name, age, add, cont, bloodGroup, lastdonation_date);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("donors.dat"))) {
            for (Donor d : dor) {
                oos.writeObject(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("donors with blood group a+ve and not donated in last 6 months:");
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, -6);
        Date sixMonthsAgo = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("donors.dat"))) {
            while (true) {
                try {
                    Donor d = (Donor) ois.readObject();
                    Date lastDonation = sdf.parse(d.lastDonationDate);
                    if (d.bloodGroup.equalsIgnoreCase("A+ve") && lastDonation.before(sixMonthsAgo)) {
                        d.display();
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

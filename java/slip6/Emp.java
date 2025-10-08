import java.util.*;

class Employee {
    int Eid;
    String Ename;
    String Edest;
    Double Esal;

    Employee(int id, String str1, String str2, double sl) {
        this.Eid = id;
        this.Ename = str1;
        this.Edest = str2;
        this.Esal = sl;
    }

    public String toString() {
        return ("Eid: " + Eid +
                " Ename: " + Ename +
                " Edest: " + Edest +
                " Esal: " + Esal);
    }
}

public class Emp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Designation: ");
        String designation = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, designation, salary);

        System.out.println("--- Employee Details ---");
        System.out.println(emp);
    }
}

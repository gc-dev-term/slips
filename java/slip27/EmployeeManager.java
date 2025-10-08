import java.util.Scanner;

class Emp {
    String name;
    double salary;

    Emp(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }
}

class Manager extends Emp {
    double ta;
    double hra;

    Manager(String name, double salary, double ta, double hra) {
        super(name, salary);
        this.ta = ta;
        this.hra = hra;
    }

    @Override
    double getSalary() {
        return salary + ta + hra;
    }
}

public class EmployeeManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee Details:");
        System.out.print("Name: ");
        String empName = sc.nextLine();
        System.out.print("Salary: ");
        double empSalary = sc.nextDouble();

        Emp e = new Emp(empName, empSalary);

        sc.nextLine();
        System.out.println("Enter Manager Details:");
        System.out.print("Name: ");
        String mgrName = sc.nextLine();
        System.out.print("Basic Salary: ");
        double mgrSalary = sc.nextDouble();
        System.out.print("Travel Allowance: ");
        double ta = sc.nextDouble();
        System.out.print("House Rent Allowance: ");
        double hra = sc.nextDouble();

        Manager m = new Manager(mgrName, mgrSalary, ta, hra);

        System.out.println("===== Salary Details =====");
        System.out.println("Employee Name   : " + e.name);
        System.out.println("Employee Salary : " + e.getSalary());
        System.out.println("Manager Name    : " + m.name);
        System.out.println("Manager Salary  : " + m.getSalary());


    }
}

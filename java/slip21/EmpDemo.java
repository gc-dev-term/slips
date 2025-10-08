import java.util.Scanner;

class Employee {
    int id;
    String name;
    String department;
    double salary;
    static int count = 0;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        count++;
    }

    void display() {
        System.out.println("ID        : " + id);
        System.out.println("Name      : " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary    : " + salary);
        System.out.println("---------------------------");
    }

    static int getCount() {
        return count;
    }
}

public class EmpDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("--- Enter details for Employee " + (i + 1) + " ---");

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            employees[i] = new Employee(id, name, department, salary);
        }

        System.out.println("=========== Employee Details ===========");
        for (int i = 0; i < n; i++) {
            System.out.println("Employee " + (i + 1));
            employees[i].display();
            System.out.println("Total Employees: " + Employee.getCount());
        }

    }
}

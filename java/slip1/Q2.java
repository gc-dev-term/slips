import java.util.*;
abstract class staff {
    protected int id;
    protected String name;

    public staff(int no, String str) {
        this.id = no;
        this.name = str;
    }
}

class OfficeStaff extends staff {
    public String department;

    OfficeStaff(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public void Display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
    }
}

public class Q2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of Office Staff: ");
        int n = sc.nextInt();

        OfficeStaff[] ofs = new OfficeStaff[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of staff " + (i + 1));
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
              sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            ofs[i] = new OfficeStaff(id, name, dept);
        }
        System.out.println("--- Staff Details ---");
        for (int i = 0; i < n; i++) {
            ofs[i].Display();
        }
    }
}

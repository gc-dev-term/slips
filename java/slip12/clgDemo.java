import java.util.Scanner;

class College {
    private int cno;
    private String cname;
    private String caddr;

    public College(int cno, String cname, String caddr) {
        this.cno = cno;
        this.cname = cname;
        this.caddr = caddr;
    }

    public void showCollegeDetails() {
        System.out.println("--- College Details ---");
        System.out.println("College No   : " + cno);
        System.out.println("College Name : " + cname);
        System.out.println("College Addr : " + caddr);
    }
}

class Department extends College {
    private int dno;
    private String dname;

    public Department(int cno, String cname, String caddr, int dno, String dname) {
        super(cno, cname, caddr);
        this.dno = dno;
        this.dname = dname;
    }

    public void showDepartmentDetails() {
        showCollegeDetails();
        System.out.println("Department No   : " + dno);
        System.out.println("Department Name : " + dname);
    }
}

public class clgDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter College Number: ");
        int cno = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter College Name: ");
        String cname = sc.nextLine();

        System.out.print("Enter College Address: ");
        String caddr = sc.nextLine();

        System.out.print("Enter Department Number: ");
        int dno = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department Name: ");
        String dname = sc.nextLine();

        Department dept = new Department(cno, cname, caddr, dno, dname);
        dept.showDepartmentDetails();


    }
}

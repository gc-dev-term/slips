import student.StudentInfo;
import student.StudentPer;

import java.util.Scanner;

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("enter name: ");
        String name = sc.nextLine();

        System.out.print("enter class: ");
        String studentClass = sc.nextLine();

        int[] marks = new int[6];
        System.out.println("enter marks for 6 subjects:");
        for (int i = 0; i < 6; i++) {
            System.out.print("subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        StudentPer percentageCal = new StudentPer();
        double percentage = percentageCal.calculatePercentage(marks);

        StudentInfo stud = new StudentInfo(rollNo, name, studentClass, percentage);
        stud.display();
    }
}

import sy.*;
import ty.*;
import java.util.*;

class Student {
    public int rollNumber;
    public String name;
    public SYMarks syMarks;
    public TYMarks tyMarks;

    public Student(int rollNumber, String name, SYMarks syMarks, TYMarks tyMarks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.syMarks = syMarks;
        this.tyMarks = tyMarks;
    }

    public int totalComputerMarks() {
        return syMarks.computerTotal + tyMarks.theory + tyMarks.practicals;
    }

    public String calculateGrade() {
        int total = totalComputerMarks();
        if (total >= 70) return "A";
        else if (total >= 60) return "B";
        else if (total >= 50) return "C";
        else if (total >= 40) return "Pass Class";
        else return "FAIL";
    }

    public void display() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("SY Marks - Computer: " + syMarks.computerTotal
                + ", Maths: " + syMarks.mathsTotal
                + ", Electronics: " + syMarks.electronicsTotal);
        System.out.println("TY Marks - Theory: " + tyMarks.theory
                + ", Practicals: " + tyMarks.practicals);
        System.out.println("Total Computer Marks: " + totalComputerMarks());
        System.out.println("Grade: " + calculateGrade());
    }
}

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] std = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");

            System.out.print("Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.println("Enter SY Marks:");
            System.out.print("Computer: ");
            int compSY = sc.nextInt();
            System.out.print("Maths: ");
            int mathsSY = sc.nextInt();
            System.out.print("Electronics: ");
            int elecSY = sc.nextInt();

            System.out.println("Enter TY Marks (Computer subject):");
            System.out.print("Theory: ");
            int theory = sc.nextInt();
            System.out.print("Practicals: ");
            int practicals = sc.nextInt();
            sc.nextLine();

            SYMarks sy = new SYMarks(compSY, mathsSY, elecSY);
            TYMarks ty = new TYMarks(theory, practicals);

            std[i] = new Student(roll, name, sy, ty);
            System.out.println();
        }

        System.out.println("---Student Results---");
        for (Student s : std) {
            s.display();
        }


    }
}
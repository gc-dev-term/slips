import java.io.*;

class student {
    int rollno;
    String name;
    String cls;
    double per;

    void Acptdata() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("enter roll number: ");
        rollno = Integer.parseInt(br.readLine());

        System.out.print("enter name: ");
        name = br.readLine();

        System.out.print("enter class: ");
        cls = br.readLine();

        System.out.print("enter percentage: ");
        per = Double.parseDouble(br.readLine());
    }

    void display() {
        System.out.println("roll number: " + rollno);
        System.out.println("name: " + name);
        System.out.println("class: " + cls);
        System.out.println("percentage: " + per);
    }
}

public class StudentDemo {
    public static void main(String ar[]) throws IOException {
        student s = new student();
        s.Acptdata();
        s.display();
    }
}

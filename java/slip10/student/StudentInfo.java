package student;

public class StudentInfo {
    private int rollno;
    private String name;
    private String cls;
    private double percentage;

    public StudentInfo(int rollno, String name, String cls, double percentage) {
        this.rollno = rollno;
        this.name = name;
        this.cls = cls;
        this.percentage = percentage;
    }

    public void display() {
        System.out.println("--- student information ---");
        System.out.println("roll no   : " + rollno);
        System.out.println("name      : " + name);
        System.out.println("class     : " + cls);
        System.out.println("percentage: " + percentage + "%");
    }
}

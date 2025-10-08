package student;

public class StudentPer {
    public double calculatePercentage(int marks[]) {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return (total / 6.0);
    }
}


import operation.Addition;
import operation.Maximum;

public class OperationDemo {
    public static void main(String[] args) {
        Addition aobj = new Addition();
        Maximum mobj = new Maximum();

        int sum = aobj.add(10, 20);
        float diff = aobj.subtract(15.5f, 5.2f);
        int maximum = mobj.max(50, 40);

        System.out.println("Addition is: " + sum);
        System.out.println("Subtraction is: " + diff);
        System.out.println("Max is: " + maximum);
    }
}

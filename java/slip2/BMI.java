public class BMI {
    public static void main(String args[]) {
        String fname = args[0];
        String lname = args[1];
        double wet = Double.parseDouble(args[2]);
        double heig = Double.parseDouble(args[3]);

        double bmi = wet / (heig * heig);

        System.out.println("Name: " + fname + " " + lname);
        System.out.println("Weight: " + wet);
        System.out.println("Height: " + heig);
        System.out.printf("BMI:" + bmi);
    }
}

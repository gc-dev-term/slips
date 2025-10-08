import java.util.*;

class CovidPositiveException extends Exception {
    public CovidPositiveException(String msg) {
        super(msg);
    }
}

class Patient {
    String pname;
    int page;
    int p_oxy_level;
    int p_hrct_report;

    public Patient(String str, int age, int oxy, int hrct) {
        this.pname = str;
        this.page = age;
        this.p_oxy_level = oxy;
        this.p_hrct_report = hrct;
    }

    public void checkPatient() throws CovidPositiveException {
        if (p_oxy_level < 95 && p_hrct_report > 10) {
            throw new CovidPositiveException("Patient is Covid Positive and Need to Hospital");
        } else {
            System.out.println("----Patient Information----");
            System.out.println("Name: " + pname);
            System.out.println("Age: " + page);
            System.out.println("Oxygen Level: " + p_oxy_level);
            System.out.println("HRCT Report: " + p_hrct_report);
        }
    }
}

public class HRCTReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Oxygen Level: ");
        int oxy = sc.nextInt();

        System.out.print("Enter HRCT Report Score: ");
        int hrct = sc.nextInt();

        Patient p = new Patient(name, age, oxy, hrct);

        try {
            p.checkPatient();
        } catch (CovidPositiveException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

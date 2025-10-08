import java.util.*;

class InvalidDateException extends Exception {
    public InvalidDateException(String msg) {
        super(msg);
    }
}

class Mydate {
    private int day, month, year;

    public void acceptDate() throws InvalidDateException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter day: ");
        day = sc.nextInt();
        System.out.print("Enter month: ");
        month = sc.nextInt();
        System.out.print("Enter year: ");
        year = sc.nextInt();

        if (!isValidDate(day, month, year)) {
            throw new InvalidDateException("Invalid Date ");
        }
    }

    public void displayDate() {
        System.out.println(String.format("%02d", day) + "/" +
                           String.format("%02d", month) + "/" + year);
    }

    private boolean isValidDate(int d, int m, int y) {
        if (y <= 0 || m <= 0 || m > 12 || d <= 0)
            return false;

        int maxday;
        switch (m) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                maxday= 31; break;
            case 4: case 6: case 9: case 11:
                maxday= 30; break;
            case 2:
                if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0))
                    maxday= 29;
                else
                    maxday= 28;
                break;
            default:
                return false;
        }

        return d <= maxday;
    }
}

public class MyDateDemo {
    public static void main(String a[]) {
        Mydate date = new Mydate();
        try {
            date.acceptDate();
            date.displayDate();
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }
    }
}

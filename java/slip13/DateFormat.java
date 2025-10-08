import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    public static void main(String[] args) {
        Date now = new Date();

        SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("current date is : " + f1.format(now));

        SimpleDateFormat f2 = new SimpleDateFormat("MM-dd-yyyy");
        System.out.println("current date is : " + f2.format(now));

        SimpleDateFormat f3 = new SimpleDateFormat("EEEE MMMM dd yyyy");
        System.out.println("current date is : " + f3.format(now));

        SimpleDateFormat f4 = new SimpleDateFormat("E MMMM dd HH:mm:ss z yyyy");
        System.out.println("current date and time is : " + f4.format(now));

        SimpleDateFormat f5 = new SimpleDateFormat("dd/MM/yy hh:mm:ss a Z");
        System.out.println("current date and time is : " + f5.format(now));
    }
}

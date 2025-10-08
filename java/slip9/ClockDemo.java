import java.util.*;

class Clock {
    private int hr;
    private int min;
    private int sec;

    public Clock(int hours, int minutes, int seconds) {
        if (isValid(hours, minutes, seconds)) {
            this.hr= hours;
            this.min = minutes;
            this.sec = seconds;
        } else {
            System.out.println("invalid time setting default 12:00:00");
            this.hr = 12;
            this.min = 00;
            this.sec = 00;
        }
    }

    private boolean isValid(int h, int m, int s) {
        return (h >= 0 && h < 24) && (m >= 0 && m < 60) && (s >= 0 && s < 60);
    }

    public void displayTime() {
        String amPm = (hr < 12) ? "am" : "pm";
        int displayHour = (hr == 0) ? 12 : (hr > 12 ? hr - 12 : hr);
        System.out.printf("time: %02d:%02d:%02d %s ", displayHour, min, sec, amPm);
    }

    public void setTime(int h, int m, int s) {
        if (isValid(h, m, s)) {
            this.hr = h;
            this.min = m;
            this.sec = s;
        } else {
            System.out.println("invalid time time not updated.");
        }
    }
}

public class ClockDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter hours: ");
        int hh = sc.nextInt();
        System.out.print("enter minutes: ");
        int mm = sc.nextInt();
        System.out.print("enter seconds: ");
        int ss = sc.nextInt();

        Clock clk = new Clock(hh, mm, ss);
        clk.displayTime();

    }
}

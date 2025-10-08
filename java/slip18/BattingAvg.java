import java.util.*;

class CricketPlayer {
    String name;
    int no_of_innings;
    int no_of_times_notout;
    int total_runs;
    double bat_avg;

    CricketPlayer(String name, int innings, int notout, int runs) {
        this.name = name;
        this.no_of_innings = innings;
        this.no_of_times_notout = notout;
        this.total_runs = runs;
        this.bat_avg = 0.0;
    }

    public static void avg(CricketPlayer player) {
        int outs = player.no_of_innings - player.no_of_times_notout;
        if (outs > 0) {
            player.bat_avg = (double) player.total_runs / outs;
        } else {
            player.bat_avg = player.total_runs;
        }
    }

    public static void sort(CricketPlayer[] players) {
        for (int i = 0; i < players.length - 1; i++) {

        for (int j = i + 1; j < players.length; j++) {
        if (players[i].bat_avg < players[j].bat_avg) {

        CricketPlayer temp = players[i];
        players[i] = players[j];
        players[j] = temp;
        }
        }
        }
    }

    public void Display() {
        System.out.println("Name       : " + name);
        System.out.println("Innings    : " + no_of_innings);
        System.out.println("Not Out    : " + no_of_times_notout);
        System.out.println("Runs       : " + total_runs);
        System.out.printf("Average    : %.2f%n", bat_avg);
        System.out.println("---------------------------------------");
    }
}

public class BattingAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
sc.nextLine();
        CricketPlayer[] cp = new CricketPlayer[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Player " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Number of Innings: ");
            int innings = sc.nextInt();
            System.out.print("Number of times Not Out: ");
            int notout = sc.nextInt();
            System.out.print("Total Runs: ");
            int run = sc.nextInt();
            sc.nextLine();

            cp[i] = new CricketPlayer(name, innings, notout, run);

            CricketPlayer.avg(cp[i]);
        }
        CricketPlayer.sort(cp);
        System.out.println(" Sorted Player Details  by Batting Average");
        for (CricketPlayer p : cp) {
            p.Display();
        }
    }
}

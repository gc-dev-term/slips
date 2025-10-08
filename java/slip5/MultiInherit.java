import java.util.Scanner;

class Continent {
    String continentName;

    Continent(String cname) {
        continentName = cname;
    }
}

class Country extends Continent {
    String countryName;

    Country(String cname, String coname) {
        super(coname);
        countryName = cname;
    }
}

class State extends Country {
    String stateName;

    State(String sname, String cname, String coname) {
        super(cname, coname);
        stateName = sname;
    }
}

class Place extends State {
    String placeName;

    Place(String pname, String sname, String cname, String coname) {
        super(sname, cname, coname);
        placeName = pname;
    }

    void display() {
        System.out.println("--- Location Details ---");
        System.out.println("Place     : " + placeName);
        System.out.println("State     : " + stateName);
        System.out.println("Country   : " + countryName);
        System.out.println("Continent : " + continentName);
    }
}

public class MultiInherit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Continent: ");
        String continent = sc.nextLine();

        System.out.print("Enter Country: ");
        String country = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

        System.out.print("Enter Place: ");
        String place = sc.nextLine();

        Place p = new Place(place, state, country, continent);
        p.display();


    }
}

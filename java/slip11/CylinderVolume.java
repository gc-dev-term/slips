import java.util.*;

interface Operation {
    double PI = 3.142;
    double volume();
}

class Cylinder implements Operation {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double volume() {
        return PI * radius * radius * height;
    }
}

public class CylinderVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter radius: ");
        double r = sc.nextDouble();

        System.out.print("enter height: ");
        double h = sc.nextDouble();

        Cylinder c = new Cylinder(r, h);
        System.out.println("volume of cylinder: " + c.volume());


    }
}

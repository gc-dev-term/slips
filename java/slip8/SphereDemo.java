import java.util.*;

class Sphere {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getSurfaceArea() {
        return 4 * 3.14 * (radius * radius);
    }

    public double getVolume() {
        return (4.0 / 3.0) * 3.14 * (radius * radius * radius);
    }

    public void display() {
        System.out.println("radius: " + radius);
        System.out.println("surface area: " + getSurfaceArea());
        System.out.println("volume: " + getVolume());
    }
}

public class SphereDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter radius of sphere: ");
        double r = sc.nextDouble();

        Sphere sp = new Sphere(r);
        sp.display();

    }
}

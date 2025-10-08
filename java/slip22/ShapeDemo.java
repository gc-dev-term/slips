abstract class Shape {
    int a, b;

    Shape(int a, int b) {
        this.a = a;
        this.b = b;
    }

    abstract void displayArea();
}

class Rectangle extends Shape {
    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    @Override
    void displayArea() {
        System.out.println("Area of Rectangle = " + (a * b));
    }
}

class Triangle extends Shape {
    Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    void displayArea() {
        System.out.println("Area of Triangle  = " + (0.5 * a * b));
    }
}

class Circle extends Shape {
    Circle(int radius) {
        super(radius, 0);
    }

    @Override
    void displayArea() {
        System.out.println("Area of Circle    = " + (Math.PI * a * a));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Rectangle(10, 5);
        shapes[1] = new Triangle(8, 6);
        shapes[2] = new Circle(7);

        System.out.println("=== Shape Areas ===");
        for (Shape s : shapes) {
            s.displayArea();
        }
    }
}

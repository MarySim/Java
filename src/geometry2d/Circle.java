package geometry2d;
import exceptions.NegativeValueException;
import exceptions.ZeroValueException;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        if (radius < 0) {
            throw new NegativeValueException("Радиус не может быть отрицательным: " + radius);
        }
        if (radius == 0) {
            throw new ZeroValueException("Радиус не может быть нулевым");
        }
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return String.format("Circle(radius=%.2f, area=%.2f, perimeter=%.2f)",
                radius, area(), perimeter());
    }

    // Геттер для радиуса
    public double getRadius() {
        return radius;
    }
}
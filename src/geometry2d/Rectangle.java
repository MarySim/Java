package geometry2d;
import exceptions.NegativeValueException;
import exceptions.ZeroValueException;

public class Rectangle implements Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width < 0 || height < 0) {
            throw new NegativeValueException("Стороны не могут быть отрицательными: " + width + ", " + height);
        }
        if (width == 0 || height == 0) {
            throw new ZeroValueException("Стороны не могут быть нулевыми: " + width + ", " + height);
        }
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public String toString() {
        return String.format("Rectangle(width=%.2f, height=%.2f, area=%.2f, perimeter=%.2f)",
                width, height, area(), perimeter());
    }

    // Геттеры
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
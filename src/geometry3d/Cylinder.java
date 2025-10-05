package geometry3d;
import geometry2d.Figure;
import exceptions.NegativeValueException;
import exceptions.ZeroValueException;

public class Cylinder {
    private Figure base;  // Основание (2D фигура)
    private double height; // Высота

    public Cylinder(Figure base, double height) {
        if (height < 0) {
            throw new NegativeValueException("Высота не может быть отрицательной: " + height);
        }
        if (height == 0) {
            throw new ZeroValueException("Высота не может быть нулевой");
        }
        this.base = base;
        this.height = height;
    }

    // Объем = площадь основания * высота
    public double volume() {
        return base.area() * height;
    }

    @Override
    public String toString() {
        return String.format("Cylinder{base=%s, height=%.2f, volume=%.2f}",
                base.toString(), height, volume());
    }

    // Геттеры
    public Figure getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }
}
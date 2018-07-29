package lesson7.shapes;

import lesson7.helpingclassesandinterfaces.GeometricFigure;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends GeometricFigure {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;

        if (isGeometricFigureInvalid()){
            System.out.println("Окружность задана неверно!");
            this.radius = 0;
        }
    }

    @Override
    public double area() {
        return new BigDecimal(Math.PI * Math.pow(radius, 2)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double perimeter(){
        return new BigDecimal(2 * Math.PI * radius).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    protected boolean isGeometricFigureInvalid() {
        return radius <= 0;
    }

    @Override
    public String toString(){
        return "Радиус окружности: " + radius + ";\n"
                + "Длина окружности: " + perimeter() + ";\n"
                + "Площадь: " + area() + ";\n";
    }

    public double getRadius() {
        return radius;
    }
}

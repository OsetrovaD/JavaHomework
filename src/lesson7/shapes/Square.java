package lesson7.shapes;

import lesson7.helpingclassesandinterfaces.CircumscribedCircle;
import lesson7.helpingclassesandinterfaces.GeometricFigure;
import lesson7.helpingclassesandinterfaces.InscribedCircle;
import lesson7.helpingclassesandinterfaces.Quadrangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Square extends GeometricFigure implements Quadrangle, InscribedCircle, CircumscribedCircle {

    private double side;

    public Square(double side) {
        this.side = side;

        if (isGeometricFigureInvalid()){
            System.out.println("Квадрат задан неверно!");
            this.side = 0;
        }
    }

    @Override
    protected boolean isGeometricFigureInvalid() {
        return side <= 0;
    }

    @Override
    public double area() {
        return new BigDecimal(Math.pow(side, 2)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double perimeter() {
        return new BigDecimal(4 * side).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double diagonal() {
        return new BigDecimal(side * Math.sqrt(2)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double altitude() {
        return side;
    }

    @Override
    public double circumscribedCircleRadius() {
        return new BigDecimal(diagonal() / 2).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double inscribedCircleRadius() {
        return new BigDecimal(side / 2).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "Площадь: " + area() + ";\n"
                + "Периметр: " + perimeter() + ";\n"
                + "Высоты: " + altitude() + ";\n"
                + "Диагонали: " + diagonal() + ";\n"
                + "Радиус вписанной окружности: " + inscribedCircleRadius() + ";\n"
                + "Длина вписанной окружности: " + new Circle(inscribedCircleRadius()).perimeter() + ";\n"
                + "Площадь вписанной окружности: " + new Circle(inscribedCircleRadius()).area() + ";\n"
                + "Радиус описанной окружности: " + circumscribedCircleRadius() + ";\n"
                + "Длина описанной окружности: " + new Circle(circumscribedCircleRadius()).perimeter() + ";\n"
                + "Площадь описанной окружности: " + new Circle(circumscribedCircleRadius()).area() + ".\n";
    }

    public double getSide() {
        return side;
    }
}

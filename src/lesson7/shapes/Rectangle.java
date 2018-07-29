package lesson7.shapes;

import lesson7.helpingclassesandinterfaces.CircumscribedCircle;
import lesson7.helpingclassesandinterfaces.GeometricFigure;
import lesson7.helpingclassesandinterfaces.Quadrangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rectangle extends GeometricFigure implements Quadrangle, CircumscribedCircle {

    private double leftSide;
    private double lowSide;

    public Rectangle(double leftSide, double lowSide) {
        this.leftSide = leftSide;
        this.lowSide = lowSide;

        if (isGeometricFigureInvalid()){
            System.out.println("Прямоугольник задан неверно!");
            this.leftSide = 0;
            this.lowSide = 0;
        }
    }

    @Override
    public double area() {
        return new BigDecimal(leftSide * lowSide).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double perimeter() {
        return new BigDecimal((leftSide + lowSide) * 2).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    protected boolean isGeometricFigureInvalid() {
        return leftSide <= 0 || lowSide <= 0;
    }

    @Override
    public double diagonal() {
        double result = Math.sqrt(Math.pow(lowSide, 2) + Math.pow(leftSide, 2));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double altitude() {
        return leftSide;
    }

    @Override
    public double circumscribedCircleRadius() {
        return new BigDecimal(diagonal() / 2).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "Площадь: " + area() + ";\n"
                + "Периметр: " + perimeter() + ";\n"
                + "Высота к нижней стороне равна боковой стороне: " + altitude() + ";\n"
                + "Высота к боковой стороне равна нижней и верхней стороне: " + lowSide + ";\n"
                + "Диагонали: " + diagonal() + ";\n"
                + "Радиус описанной окружности: " + circumscribedCircleRadius() + ";\n"
                + "Длина описанной окружности: " + new Circle(circumscribedCircleRadius()).perimeter() + ";\n"
                + "Площадь описанной окружности: " + new Circle(circumscribedCircleRadius()).area() + ".\n";
    }

    public double getLeftSide() {
        return leftSide;
    }

    public double getLowSide() {
        return lowSide;
    }
}

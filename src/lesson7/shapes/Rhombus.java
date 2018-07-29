package lesson7.shapes;

import lesson7.helpingclassesandinterfaces.GeometricFigure;
import lesson7.helpingclassesandinterfaces.InscribedCircle;
import lesson7.helpingclassesandinterfaces.Quadrangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rhombus extends GeometricFigure implements Quadrangle, InscribedCircle {

    private double side;
    private int acuteAngle;

    public Rhombus(double side, int acuteAngle) {
        this.side = side;
        this.acuteAngle = acuteAngle;

        if (isGeometricFigureInvalid()){
            System.out.println("Ромб задан неверно!");
            this.side = 0;
            this.acuteAngle = 0;
        }
    }

    @Override
    public double area() {
        double result = Math.pow(side, 2) * Math.sin(Math.toRadians(acuteAngle));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double perimeter() {
        return new BigDecimal(4 * side).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double diagonal() {
        double result = 2 * side * Math.sin(Math.toRadians(acuteAngle / 2));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double biggerDiagonal() {
        double result = 2 * side * Math.cos(Math.toRadians(acuteAngle / 2));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double altitude() {
        return new BigDecimal(area() / side).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    protected boolean isGeometricFigureInvalid() {
        return side <= 0 || acuteAngle <= 0 || acuteAngle >= 90;
    }

    @Override
    public double inscribedCircleRadius() {
        return new BigDecimal(altitude() / 2).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "Площадь: " + area() + ";\n"
                + "Периметр: " + perimeter() + ";\n"
                + "Высоты: " + altitude() + ";\n"
                + "Диагонали: " + diagonal() + ", " + biggerDiagonal() + ";\n"
                + "Радиус вписанной окружности: " + inscribedCircleRadius() + ";\n"
                + "Длина вписанной окружности: " + new Circle(inscribedCircleRadius()).perimeter() + ";\n"
                + "Площадь вписанной окружности: " + new Circle(inscribedCircleRadius()).area() + ".\n";
    }

    public double getSide() {
        return side;
    }

    public int getAcuteAngle() {
        return acuteAngle;
    }
}

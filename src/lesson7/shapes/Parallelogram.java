package lesson7.shapes;

import lesson7.helpingclassesandinterfaces.GeometricFigure;
import lesson7.helpingclassesandinterfaces.Quadrangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Parallelogram extends GeometricFigure implements Quadrangle {

    private double leftSide;
    private double lowSide;
    private int angleBetweenLeftSideAndLowSide;

    public Parallelogram(double leftSide, double lowSide, int angleBetweenLeftSideAndLowSide) {
        this.leftSide = leftSide;
        this.lowSide = lowSide;
        this.angleBetweenLeftSideAndLowSide = angleBetweenLeftSideAndLowSide;

        if (isGeometricFigureInvalid()){
            System.out.println("Параллелограмм задан неверно!");
            this.leftSide = 0;
            this.lowSide = 0;
            this.angleBetweenLeftSideAndLowSide = 0;
        }

    }

    @Override
    protected boolean isGeometricFigureInvalid() {
        return lowSide <= 0 || leftSide <= 0 || angleBetweenLeftSideAndLowSide <= 0
                || angleBetweenLeftSideAndLowSide >= 180 || angleBetweenLeftSideAndLowSide == 90;
    }

    @Override
    public double area() {
        double result = lowSide * leftSide * Math.sin(Math.toRadians(angleBetweenLeftSideAndLowSide));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double perimeter() {
        return new BigDecimal((leftSide + lowSide) * 2).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double diagonal() {
        double result = Math.sqrt(Math.pow(leftSide, 2) + Math.pow(lowSide, 2)
                + (2 * lowSide * leftSide * Math.cos(Math.toRadians(angleBetweenLeftSideAndLowSide))));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double secondDiagonal() {
        double result = Math.sqrt(Math.pow(leftSide, 2) + Math.pow(lowSide, 2)
                - (2 * lowSide * leftSide * Math.cos(Math.toRadians(angleBetweenLeftSideAndLowSide))));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double altitude() {
        return new BigDecimal(area() / lowSide).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double altitudeToLeftSide() {
        return new BigDecimal(area() / leftSide).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "Площадь: " + area() + ";\n"
                + "Периметр: " + perimeter() + ";\n"
                + "Высота к нижней стороне: " + altitude() + ";\n"
                + "Высота к боковой стороне: " + altitudeToLeftSide() + ";\n"
                + "Диагонали: " + diagonal() + ", " + secondDiagonal() + ".\n";
    }

    public double getLeftSide() {
        return leftSide;
    }

    public double getLowSide() {
        return lowSide;
    }

    public int getAngleBetweenLeftSideAndLowSide() {
        return angleBetweenLeftSideAndLowSide;
    }

}

package lesson7.shapes;

import lesson7.helpingclassesandinterfaces.CircumscribedCircle;
import lesson7.helpingclassesandinterfaces.GeometricFigure;
import lesson7.helpingclassesandinterfaces.InscribedCircle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle extends GeometricFigure implements InscribedCircle, CircumscribedCircle {

    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private double halfPerimeter;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        this.halfPerimeter = perimeter()/2;

        if (isGeometricFigureInvalid()){
            System.out.println("Треугольник заданы неверно!");
            this.firstSide = 0;
            this.secondSide = 0;
            this.thirdSide = 0;
            this.halfPerimeter = 0;
        }
    }

    @Override
    protected boolean isGeometricFigureInvalid() {
        boolean result = false;

        if (firstSide <= 0 || secondSide <= 0 || thirdSide <= 0){
            result = true;
        }

        if (firstSide < secondSide + thirdSide
                && secondSide < firstSide + thirdSide
                && thirdSide < firstSide + secondSide){
            result = false;
        }

        return result;
    }

    public double altitudeToFirstSide(){
        return new BigDecimal((2 * area()) / firstSide).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double altitudeToSecondSide(){
        return new BigDecimal((2 * area()) / secondSide).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double altitudeToThirdSide(){
        return new BigDecimal((2 * area()) / thirdSide).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double area() {
        double result = Math.sqrt(halfPerimeter * (halfPerimeter - firstSide)
                * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double perimeter() {
        return new BigDecimal(this.firstSide + this.secondSide + this.thirdSide).setScale(2, RoundingMode.HALF_UP).doubleValue() ;
    }

    @Override
    public double inscribedCircleRadius() {
        return new BigDecimal(area() / halfPerimeter).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double circumscribedCircleRadius() {
        double result = (firstSide * secondSide * thirdSide) / (4 * area());

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString(){
        return "Площадь: " + area() + ";\n"
                + "Периметр: " + perimeter() + ";\n"
                + "Высота к стороне firstSide: " + altitudeToFirstSide() + ";\n"
                + "Высота к стороне secondSide: " + altitudeToSecondSide() + ";\n"
                + "Высота к стороне thirdSide: " + altitudeToThirdSide() + ";\n"
                + "Радиус вписанной окружности: " + inscribedCircleRadius() + ";\n"
                + "Длина вписанной окружности: " + new Circle(inscribedCircleRadius()).perimeter() + ";\n"
                + "Площадь вписанной окружности: " + new Circle(inscribedCircleRadius()).area() + ";\n"
                + "Радиус описанной окружности: " + circumscribedCircleRadius() + ";\n"
                + "Длина описанной окружности: " + new Circle(circumscribedCircleRadius()).perimeter() + ";\n"
                + "Площадь описанной окружности: " + new Circle(circumscribedCircleRadius()).area() + ".\n";
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }
}

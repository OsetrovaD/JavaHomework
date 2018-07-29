package lesson7.shapes;

import lesson7.helpingclassesandinterfaces.GeometricFigure;
import lesson7.helpingclassesandinterfaces.InscribedCircle;
import lesson7.helpingclassesandinterfaces.Quadrangle;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Trapezium extends GeometricFigure implements Quadrangle, InscribedCircle {

    private double highBase;
    private double lowBase;
    private double firstSide;
    private int angleBetweenLowBaseAndFirstSide;

    public Trapezium(double highBase, double lowBase, double firstSide, int angleBetweenLowBaseAndFirstSide) {
        this.highBase = highBase;
        this.lowBase = lowBase;
        this.firstSide = firstSide;
        this.angleBetweenLowBaseAndFirstSide = angleBetweenLowBaseAndFirstSide;

        if (isGeometricFigureInvalid()){
            System.out.println("Трапеция задана неверно!");
            this.highBase = 0;
            this.lowBase = 0;
            this.firstSide = 0;
            this.angleBetweenLowBaseAndFirstSide = 0;
        }
    }

    @Override
    protected boolean isGeometricFigureInvalid() {
        return lowBase <= 0 || highBase <= 0 || firstSide <= 0
                || angleBetweenLowBaseAndFirstSide <= 0 || angleBetweenLowBaseAndFirstSide >= 180;
    }

    public double middleLine(){
        double result = (lowBase + highBase) / 2;

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double altitude() {
        double result = firstSide * Math.sin(Math.toRadians(angleBetweenLowBaseAndFirstSide));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double area() {
        double result = middleLine() * altitude();

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double diagonal() {
        double result = Math.sqrt(Math.pow(altitude(), 2)
                + Math.pow(highBase + altitude() * (1.0 / Math.tan(Math.toRadians(angleBetweenLowBaseAndFirstSide))), 2));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double secondDiagonal() {
        double result = Math.sqrt(Math.pow(altitude(), 2)
                + Math.pow(lowBase - altitude() * (1.0 / Math.tan(Math.toRadians(angleBetweenLowBaseAndFirstSide))), 2));

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double secondSide(){

        double result = Math.sqrt(Math.pow(diagonal(), 2) + Math.pow(secondDiagonal(), 2)
                - Math.pow(firstSide, 2) - (2 * lowBase * highBase)) ;

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double perimeter() {
        double result = lowBase + highBase + firstSide + secondSide();

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public int angleBetweenLowBaseAndSecondSide(){
        return (int) Math.toDegrees(Math.asin(altitude() / secondSide()));
    }

    public int angleBetweenHighBaseAndFirstSide(){
        return 180 - angleBetweenLowBaseAndFirstSide;
    }

    public int angleBetweenHighBaseAndSecondSide(){
        return 180 - angleBetweenLowBaseAndSecondSide();
    }

    private boolean isTrapeziumValidForInscribedCircle(){
        return (int)(lowBase + highBase) == (int)(firstSide + secondSide());
    }

    @Override
    public double inscribedCircleRadius() {
        double result = 0;
        if (isTrapeziumValidForInscribedCircle()) {
            result = new BigDecimal(altitude() / 2).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return result;
    }

    @Override
    public String toString() {
        String describing;
        String informationAboutInscribedCircle = "";

        if (isTrapeziumValidForInscribedCircle()){
            informationAboutInscribedCircle = "Радиус вписанной окружности: " + inscribedCircleRadius() + ";\n"
                    + "Длина вписанной окружности: " + new Circle(inscribedCircleRadius()).perimeter() + ";\n"
                    + "Площадь вписанной окружности: " + new Circle(inscribedCircleRadius()).area() + ".\n";
        }

        describing = "Площадь: " + area() + ";\n"
                + "Периметр: " + perimeter() + ";\n"
                + "Средняя линия: " + middleLine() + ";\n"
                + "Высота: " + altitude() + ";\n"
                + "Боковые стороны: " + firstSide + ", " + secondSide() + ";\n"
                + "Углы при нижнем основании: " + angleBetweenLowBaseAndFirstSide + ", " + angleBetweenLowBaseAndSecondSide() + ";\n"
                + "Углы при верхнем основании: " + angleBetweenHighBaseAndFirstSide() + ", " + angleBetweenHighBaseAndSecondSide() + ";\n"
                + "Диагонали: " + diagonal() + ", " + secondDiagonal() + ";\n"
                + informationAboutInscribedCircle;

        return describing;
    }


    public double getHighBase() {
        return highBase;
    }

    public double getLowBase() {
        return lowBase;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public int getAngleBetweenLowBaseAndFirstSide() {
        return angleBetweenLowBaseAndFirstSide;
    }
}

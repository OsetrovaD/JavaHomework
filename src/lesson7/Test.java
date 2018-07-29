package lesson7;

import lesson7.helpingclassesandinterfaces.GeometricFigure;
import lesson7.helpingclassesandinterfaces.ShapeUtils;
import lesson7.shapes.*;

public class Test {

    public static void main(String[] args) {
        Circle first = new Circle(15);
        System.out.println(first.toString());

        Circle second = new Circle(25);
        System.out.println(first.isTheSameArea(second));
        System.out.println();

        GeometricFigure triangle1 = new Triangle(12, 22, 18);
        System.out.println(triangle1.toString());

        GeometricFigure trapezium1 = new Trapezium(25, 55, 20, 70);
        System.out.println(trapezium1.toString());

        GeometricFigure parallelogram = new Parallelogram(26, 54, 75);
        System.out.println(parallelogram.toString());

        GeometricFigure rectangle = new Rectangle(15, 20);
        System.out.println(rectangle.toString());

        GeometricFigure rhombus = new Rhombus(28, 63);
        System.out.println(rhombus.toString());

        GeometricFigure square = new Square(25);
        System.out.println(square.toString());

        System.out.println(ShapeUtils.isTriangle(parallelogram));
        System.out.println(ShapeUtils.isTriangle(triangle1));
        System.out.println(ShapeUtils.isRectangle(rectangle));
        System.out.println(ShapeUtils.isRectangle(rhombus));
        System.out.println(ShapeUtils.isRectangle(square));

        Circle test = new Circle(-15);
        System.out.println(test.toString());
    }
}

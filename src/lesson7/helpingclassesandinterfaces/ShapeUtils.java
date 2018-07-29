package lesson7.helpingclassesandinterfaces;


import lesson7.shapes.Rectangle;
import lesson7.shapes.Square;
import lesson7.shapes.Triangle;

public class  ShapeUtils {

    private ShapeUtils() {
    }

    public static <T extends GeometricFigure> boolean isTriangle(T shape){
        return shape instanceof Triangle;
    }

    public static <T extends GeometricFigure> boolean isRectangle(T shape){
        return shape instanceof Rectangle || shape instanceof Square;
    }
}

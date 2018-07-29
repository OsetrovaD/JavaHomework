package lesson7.helpingclassesandinterfaces;

public abstract class GeometricFigure {

    public abstract double area();

    public abstract double perimeter();

    protected abstract boolean isGeometricFigureInvalid();

    public boolean isTheSameArea(GeometricFigure geometricFigure){
        return area() == geometricFigure.area();
    }
}

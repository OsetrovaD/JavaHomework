package lesson6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point endPoint){
        double distance =  Math.sqrt(Math.pow((endPoint.x - this.x), 2) + Math.pow((endPoint.y - this.y), 2));

        return new BigDecimal(distance).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}

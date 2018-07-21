package lesson6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rectangle {
    private Point highRight;
    private Point lowLeft;

    public Rectangle(Point highRight, Point lowLeft) {
        this.highRight = highRight;
        this.lowLeft = lowLeft;
    }

    public double rectangleDiagonal(){
        double diagonal =  Math.sqrt(Math.pow((this.highRight.getX() - this.lowLeft.getX()), 2)
                + Math.pow((this.highRight.getY() - this.lowLeft.getY()), 2));

        return new BigDecimal(diagonal).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double rectangleArea(){
        double length = this.highRight.getX() - this.lowLeft.getX();
        double width = this.highRight.getY() - this.lowLeft.getY();

        return length * width;
    }
}

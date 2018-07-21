package lesson6;

public class Test {

    public static void main(String[] args) {
        Point startPoint = new Point(3, 2);
        System.out.println(startPoint.distance(new Point(11, 8)));

        Rectangle rectangle = new Rectangle(new Point(3, 2), new Point(11, 8));
        System.out.println(rectangle.rectangleDiagonal());
        System.out.println(rectangle.rectangleArea());
    }
}

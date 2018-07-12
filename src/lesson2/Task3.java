package lesson2;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner n1 = new Scanner(System.in);
        System.out.println("Квадратное уравнение вида ax ² + bx + c = 0.\nВведите а:");
        int a = n1.nextInt();

        System.out.println("Введите b:");
        int b = n1.nextInt();

        System.out.println("Введите c:");
        int c = n1.nextInt();

        double discriminant = discriminant(a, b, c);

        if (isPositive(discriminant)) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Дискриминант больше нуля. Корни уравнения: " + x1 + ", " + x2);
        } else if (isZero(discriminant)) {
            double x1 = (-b) / (2.0 * a);
            System.out.println("Дискриминант равен нулю. Корень уравнения: " + x1);
        } else {
            System.out.println("Отрицательный дискриминант. Нет корней.");
        }
    }

    public static double discriminant(int a, int b, int c) {
        return b * b - 4.0 * a * c;
    }

    public static boolean isPositive(double discriminant) {
        return discriminant > 0;
    }

    public static boolean isZero(double discriminant) {
        return discriminant == 0;
    }
}

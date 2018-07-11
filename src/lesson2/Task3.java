package lesson2;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner n1=new Scanner(System.in);
        int i = n1.nextInt();
        int j = n1.nextInt();
        int k = n1.nextInt();
        double discriminant = discriminant(i, j, k);
        if (isPositive(discriminant)){
            double x1;
            double x2;
            x1 = (-j+Math.sqrt(discriminant))/(2*i);
            x2 = (-j-Math.sqrt(discriminant))/(2*i);
            System.out.println("Корни уравнения: " + x1 + ", " + x2);
        }
        else if (isZero(discriminant)){
            double x1;
            x1 = (-j)/(2.0*i);
            System.out.println("Дискриминант равен нулю. Корень уравнения: " + x1);
        }
        else if (!isPositive(discriminant)){
            System.out.println("Отрицательный дискриминант. Нет корней.");
        }
    }

    public static double discriminant(int a, int b, int c){
        return b*b-4.0*a*c;
    }

    public static boolean isPositive(double discriminant){
        return discriminant > 0;
    }
    
    public static boolean isZero(double discriminant){
        return discriminant == 0;
    }
}

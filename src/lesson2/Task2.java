package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите ширину первого дома:");
        int a = Integer.parseInt(reader.readLine());

        System.out.println("Введите длину первого дома:");
        int b = Integer.parseInt(reader.readLine());

        System.out.println("Введите ширину второго дома:");
        int c = Integer.parseInt(reader.readLine());

        System.out.println("Введите длину второго дома:");
        int d = Integer.parseInt(reader.readLine());

        System.out.println("Введите ширину участка:");
        int e = Integer.parseInt(reader.readLine());

        System.out.println("Введите длину первого дома:");
        int f = Integer.parseInt(reader.readLine());


        if (isPlotBigEnough(a, b, c, d, e, f)) {
            System.out.println("Дома с размерами " + a + "x" + b + " и " + c + "x" + d + " помещаются на участке с размерами " + e + "x" + f);
        } else {
            System.out.println("Дома с размерами " + a + "x" + b + " и " + c + "x" + d + " не помещаются на участке с размерами " + e + "x" + f);
        }
    }

    public static boolean isPlotBigEnough(int a, int b, int c, int d, int e, int f) {
        return (((a + c) <= f * f && (b + d) <= e) || ((a + d) <= f * f && (b + c) <= e) || ((a + c) <= e && (b + d) <= f * f) || ((a + d) <= e && (b + c) <= f * f));

    }
}

package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());
        int f = Integer.parseInt(reader.readLine());

        if (((a + c) <= f*f && (b + d) <= e) || ((a + d) <= f*f && (b + c) <= e)){
            System.out.println("Дома с размерами " + a + "x" + b + " и " + c + "x" + d + " помещаются на участке с размерами " + e + "x" + f);
        }
        else if (((a + c) <= e && (b + d) <= f*f) || ((a + d) <= e && (b + c) <= f*f)){
            System.out.println("Дома с размерами " + a + "x" + b + " и " + c + "x" + d + " помещаются на участке с размерами " + e + "x" + f);
        }
        else
            System.out.println("Дома с размерами " + a + "x" + b + " и " + c + "x" + d + " не помещаются на участке с размерами " + e + "x" + f);

    }
}

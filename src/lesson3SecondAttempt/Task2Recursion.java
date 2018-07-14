package lesson3SecondAttempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2Recursion {
    public static int recursion(int x){
        if (x == 0){
            return x;
        }
        if (x == 1){
            return x;
        }
        else{
            return recursion(x - 1) + recursion(x - 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число:");
        int number = Integer.parseInt(reader.readLine());

        for (int i = 0; ; i++) {
            int fibonacci = recursion(i);
            if (fibonacci > number || fibonacci == number)
                break;
            System.out.print(fibonacci + " ");
        }

    }
}

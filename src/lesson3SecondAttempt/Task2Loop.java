package lesson3SecondAttempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2Loop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число:");
        int number = Integer.parseInt(reader.readLine());

        int reserve = 0;
        int x = 1;
        int fibonacci = 0;

        while (fibonacci < number) {
            if (fibonacci == 1) {
                System.out.print(fibonacci + " ");
            }
            System.out.print(fibonacci + " ");
            fibonacci = x + reserve;
            reserve = x;
            x = fibonacci;
        }
    }
}

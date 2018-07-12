package lesson3;

import java.util.Scanner;

public class Task2Loop {
    public static void main(String[] args) {
        Scanner n1 = new Scanner(System.in);
        int number = n1.nextInt();
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

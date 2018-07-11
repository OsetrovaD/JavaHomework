package lesson3;

import java.util.Scanner;

public class Task2Loop {
    public static void main(String[] args) {
        Scanner n1 = new Scanner(System.in);
        int i = n1.nextInt();
        int reserve = 0;
        int x = 1;
        int sum = 0;
        while (sum < i){
            if (sum == 1){
                System.out.print(sum + " ");
            }
            System.out.print(sum + " ");
            sum = x + reserve;
            reserve = x;
            x = sum;
        }
    }
}

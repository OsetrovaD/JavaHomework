package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static int recursion(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + recursion(n / 10);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        System.out.println(recursion(number));
    }
}

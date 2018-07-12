package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество дней:");
        int numberOfDays = Integer.parseInt(reader.readLine());
        int day = 1;
        int sumOfPrecipitation = 0;
        int maxPrecipitation = 0;

        for (int i = 0; i < numberOfDays; i++) {
            System.out.println("Введите количество осадков в " + day + " день:");
            int precipitation = Integer.parseInt(reader.readLine());
            if (precipitation > maxPrecipitation) {
                maxPrecipitation = precipitation;
            }
            sumOfPrecipitation += precipitation;
            day++;
        }
        System.out.println("Количество дней: " + numberOfDays);
        System.out.println("Сумма осадков за данный период: " + sumOfPrecipitation);
        System.out.println("Среднее количество осадков за данный период: " + sumOfPrecipitation / numberOfDays);
        System.out.println("Максимальное количество осадков за данный период: " + maxPrecipitation);
    }
}

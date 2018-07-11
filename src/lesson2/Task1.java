package lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите день: ");
        int day = Integer.parseInt(reader.readLine());

        System.out.println("Введите месяц: ");
        int month = Integer.parseInt(reader.readLine());

        System.out.println("Введите год: ");
        int year = Integer.parseInt(reader.readLine());

        formatDate(day, month, year);
    }

    public static void formatDate(int day, int month, int year) {
        if (month >= 1 && month <= 12) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day >= 1 && day < 31) {
                        day++;
                    } else if (day == 31) {
                        day = 1;
                        month++;
                    }else {
                        System.out.println("Дата неверная");
                    }
                    break;
                case 2:
                    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                        if (day >= 1 && day < 29) {
                            day++;
                        } else if (day == 29) {
                            day = 1;
                            month++;
                        }else {
                            System.out.println("Дата неверная");
                        }
                    } else {
                        if (day >= 1 && day < 28) {
                            day++;
                        } else if (day == 28) {
                            day = 1;
                            month++;
                        }else {
                            System.out.println("Дата неверная");
                        }
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day >= 1 && day < 30) {
                        day++;
                    } else if (day == 30) {
                        day = 1;
                        month++;
                    }else {
                        System.out.println("Дата неверная");
                    }
                    break;

            }
        } else {
            System.out.println("Дата неверная");
        }

        System.out.println(day + "." + month + "." + year);
    }
}

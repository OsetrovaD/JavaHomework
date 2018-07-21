package lesson4secondattempt;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        int[] numbers = {3, 22, 6, 15, 12, 3, 14, 15, 20, 6, 22, 22, 22, 17, 30, 3, 17, 21, 19, 6, 11, 22};

        printArray(numbers);
        printArray(identicalValuesToNull(numbers));
    }

    private static int[] identicalValuesToNull(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]){
                    numbers[j] = 0;
                }
            }
        }

        return numbers;
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array).replace(",", ""));
    }
}

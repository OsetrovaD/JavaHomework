package lesson4secondattempt;

import java.util.Arrays;

public class Task1 {
    
    public static void main(String[] args) {
        int[] randomNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        printArray(randomNumbers);
        shiftArrayToRight(randomNumbers);
    }

    private static void shiftArrayToRight(int[] randomNumbers) {
        for (int i = 0; i < randomNumbers.length; i++) {
            for (int j = 1; j < randomNumbers.length; j++) {
                int temp = randomNumbers[j];
                randomNumbers[j] = randomNumbers[0];
                randomNumbers[0] = temp;
            }
            printArray(randomNumbers);
        }
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array).replace(",", ""));
    }
}

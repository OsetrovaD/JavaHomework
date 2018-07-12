package lesson4;

public class Task1 {
    public static void main(String[] args) {
        int[] randomNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printArray(randomNumbers);

        for (int i = 0; i < randomNumbers.length; i++) {
            for (int j = 1; j < randomNumbers.length; j++) {
                int temp = randomNumbers[j];
                randomNumbers[j] = randomNumbers[0];
                randomNumbers[0] = temp;
            }
            printArray(randomNumbers);
        }
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println();
    }
}

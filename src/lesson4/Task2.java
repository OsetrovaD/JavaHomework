package lesson4;

public class Task2 {
    public static void main(String[] args) {
        int[] numbers = {3, 22, 6, 15, 12, 3, 14, 15, 20, 6, 22, 17, 30, 3, 17, 21, 19, 6, 11, 22};
        printArray(numbers);

        printArray(removeIdenticalValues(numbers));
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println();

    }

    public static int[] removeIdenticalValues(int[] numbers) {
        int indexOfMainArray = 0;

        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            int indexOfTempArray = 0;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }
            int[] temp = new int[numbers.length - count];

            for (int j = 0; j < numbers.length; ) {
                if (j > indexOfMainArray) {
                    if (numbers[indexOfMainArray] == numbers[j]) {
                        j++;
                    }
                }
                if (j == numbers.length)
                    break;
                temp[indexOfTempArray] = numbers[j];
                indexOfTempArray++;
                j++;
            }
            numbers = temp;
            indexOfMainArray++;
        }
        return numbers;
    }

}

package lesson4secondattempt;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
        int[] firstArray = {1, 2, 3, 4, 5};
        int[] secondArray = {5, 6, 7};

        int[] thirdArray = {1, 2, 3, 4, 5};
        int[] fourthArray = {5, 6, 7, 8, 9, 10, 11};

        printArray(firstArray);
        printArray(secondArray);
        printArray(mergeArrays(firstArray, secondArray));

        printArray(thirdArray);
        printArray(fourthArray);
        printArray(mergeArrays(thirdArray, fourthArray));
    }

    private static int[] mergeArrays(int[] firstArray, int[] secondArray) {
        int[] commonArray = new int[firstArray.length + secondArray.length];
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;

        for (int i = 0; i < commonArray.length; i++) {
            if (i % 2 == 0 && isIndexLowerLength(firstArrayIndex, firstArray)
                    || !isIndexLowerLength(secondArrayIndex, secondArray)) {
                commonArray[i] = firstArray[firstArrayIndex];
                firstArrayIndex++;
            } else {
                commonArray[i] = secondArray[secondArrayIndex];
                secondArrayIndex++;
            }
        }
        return commonArray;
    }

    private static boolean isIndexLowerLength(int index, int[] array){
        return index < array.length;
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array).replace(",", ""));
    }
}

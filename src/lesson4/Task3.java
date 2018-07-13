package lesson4;

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

    public static int[] mergeArrays(int[] firstArray, int[] secondArray) {
        int[] commonArray = new int[firstArray.length + secondArray.length];
        int indexOfFirstArray = 0;
        int indexOfSecondArray = 0;

        for (int i = 0; i < commonArray.length; i++) {

            if (i % 2 == 0 && indexOfFirstArray < firstArray.length || indexOfSecondArray >= secondArray.length) {
                commonArray[i] = firstArray[indexOfFirstArray];
                indexOfFirstArray++;
            } else {
                commonArray[i] = secondArray[indexOfSecondArray];
                indexOfSecondArray++;
            }
        }
        return commonArray;
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println();

    }
}

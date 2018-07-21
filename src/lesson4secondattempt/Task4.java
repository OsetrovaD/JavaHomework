package lesson4secondattempt;

import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) {
        int[][] rectangleArray = new int[5][4];
        int[][] triangleArray = new int[5][];

        printTwoDimensionalArray(fillRectangleArray(rectangleArray));
        printTwoDimensionalArray(fillTriangleArray(triangleArray));

        printLinearArray(linearize(fillRectangleArray(rectangleArray)));
        printLinearArray(linearize(fillRectangleArray(triangleArray)));

    }

    private static int[][] fillRectangleArray(int[][] rectangleArray) {
        int number = 1;

        for (int i = 0; i < rectangleArray.length; i++) {
            for (int k = 0; k < rectangleArray[i].length; k++) {
                rectangleArray[i][k] = number;
                number++;
            }
        }
        return rectangleArray;
    }

    private static int[][] fillTriangleArray(int[][] triangleArray) {
        int number = 1;

        for (int i = 0; i < triangleArray.length; i++) {
            triangleArray[i] = new int[i + 1];
            for (int k = 0; k < triangleArray[i].length; k++) {
                triangleArray[i][k] = number;
                number++;
            }
        }
        return triangleArray;
    }

    private static int[] linearize(int[][] twoDimensionalArray) {
        int[] linearArray = new int[itemsNumber(twoDimensionalArray)];
        int indexOfLinearArray = 0;

        for (int[] array : twoDimensionalArray) {
            for (int arrayElement : array) {
                linearArray[indexOfLinearArray] = arrayElement;
                indexOfLinearArray++;
            }
        }

        return linearArray;
    }

    private static int itemsNumber(int[][] twoDimensionalArray){
        int numberOfItems = 0;
        for (int[] array : twoDimensionalArray) {
            numberOfItems += array.length;
        }

        return numberOfItems;
    }

    private static void printTwoDimensionalArray(int[][] twoDimensionalArray) {
        for (int[] array : twoDimensionalArray) {
            System.out.println(Arrays.toString(array).replace(",", ""));
        }
    }

    private static void printLinearArray(int[] array) {
        System.out.println(Arrays.toString(array).replace(",", ""));
    }
}

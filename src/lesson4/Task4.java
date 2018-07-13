package lesson4;

public class Task4 {
    public static void main(String[] args) {
        int[][] rectangleArray = new int[5][4];
        int[][] triangleArray = new int[5][];

        printTwoDimensionalArray(fillRectangleArray(rectangleArray));
        printTwoDimensionalArray(fillTriangleArray(triangleArray));

        printLinearArray(linearize(fillRectangleArray(rectangleArray)));
        printLinearArray(linearize(fillRectangleArray(triangleArray)));
    }

    public static int[][] fillTriangleArray(int[][] triangleArray) {
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

    public static int[][] fillRectangleArray(int[][] rectangleArray) {
        int number = 1;

        for (int i = 0; i < rectangleArray.length; i++) {
            for (int k = 0; k < rectangleArray[i].length; k++) {
                rectangleArray[i][k] = number;
                number++;
            }
        }
        return rectangleArray;
    }

    public static void printTwoDimensionalArray(int[][] twoDimensionalArray) {
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                System.out.print(twoDimensionalArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printLinearArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }

    public static int[] linearize(int[][] twoDimensionalArray) {
        int numberOfItems = 0;
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                numberOfItems++;
            }
        }
        int[] linearArray = new int[numberOfItems];
        int indexOfLinearArray = 0;

        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                linearArray[indexOfLinearArray] = twoDimensionalArray[i][j];
                indexOfLinearArray++;
            }
        }
        return linearArray;
    }

}

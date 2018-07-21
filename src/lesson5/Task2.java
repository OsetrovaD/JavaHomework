package lesson5;


import java.util.Scanner;

public class Task2 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число в римском формате:");
        String someNumeral = scanner.nextLine();

        if (!isRomanNumeralValid(someNumeral)){
            System.out.println("Число введено неверно.");
        } else {
            System.out.println(resultArabicNumeral(romanNumeralToArabicNumeral(someNumeral)));
        }

    }

    private static int[] romanNumeralToArabicNumeral(String someNumeral) {
        char[] romanNumeral = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int[] arabicNumeral = {1000, 500, 100, 50, 10, 5, 1};
        int[] result = new int[someNumeral.length()];

        int k = 0;

        for (int i = 0; i < someNumeral.length(); i++) {
            for (int j = 0; j < romanNumeral.length; j++) {
                if (someNumeral.toUpperCase().charAt(i) == romanNumeral[j]) {
                    result[k] = arabicNumeral[j];
                    k++;
                    break;
                }
            }
        }
        return result;
    }

    private static int resultArabicNumeral(int[] romanNumeralValue) {
        int result = 0;

        for (int i = romanNumeralValue.length - 1; i >= 0; i--) {
            if (romanNumeralValue.length == 1) {
                result = romanNumeralValue[0];
            } else if (i == 0 && romanNumeralValue[i] < romanNumeralValue[i + 1]) {
                break;
            } else if (i == 0 || romanNumeralValue[i] <= romanNumeralValue[i - 1]) {
                result += romanNumeralValue[i];
            } else {
                result += (romanNumeralValue[i] - romanNumeralValue[i - 1]);
                i--;
            }
        }
        return result;
    }

    private static boolean isRomanNumeralValid(String someRomanNumeral){
        boolean result = true;
        char[] romanNumeral = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        if (someRomanNumeral.length() == 0){
            result = false;
        }

        for (int i = 0; i < someRomanNumeral.length(); i++) {
            for (int j = 0; j < romanNumeral.length; j++) {
                if (someRomanNumeral.toUpperCase().charAt(i) == romanNumeral[j]){
                    break;
                } else if (j == romanNumeral.length - 1){
                    result = false;
                }
            }
        }

        return result;
    }
}

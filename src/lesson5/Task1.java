package lesson5;


import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение для проверки:");
        String palindrome = scanner.nextLine();

        if (isPalindrome(palindrome)) {
            System.out.println("Данное предложение является палиндромом.");
        } else {
            System.out.println("Данное предложение не является палиндромом.");
        }
    }

    private static boolean isPalindrome(String checkString) {
        String stringWithoutMarks = deletePunctuationMark(checkString).toLowerCase();
        StringBuilder temp = new StringBuilder(stringWithoutMarks);
        String reverseString = temp.reverse().toString();

        return stringWithoutMarks.equals(reverseString);
    }

    private static String deletePunctuationMark(String someString) {

        return someString.replaceAll("[ :,!?'.\\-]", "");
    }
}

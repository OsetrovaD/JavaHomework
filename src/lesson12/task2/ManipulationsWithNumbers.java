package lesson12.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class ManipulationsWithNumbers {

    private ManipulationsWithNumbers() {
    }

    public static void sortNumbersInFile(File file) {
        List<Integer> sortedList = getNumbersFromFile(file);
        Collections.sort(sortedList);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Integer number : sortedList) {
                bufferedWriter.write(Integer.toString(number));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> getNumbersFromFile(File file) {
        List<Integer> numbers = new ArrayList<>();

        try (Scanner scan = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scan.hasNext()) {
                numbers.add(scan.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return numbers;
    }
}
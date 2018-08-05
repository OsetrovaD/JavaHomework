package lesson12.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class LettersInPoem {

    private LettersInPoem() {
    }

    public static Map<Character, Integer> lettersCounter(File file) {
        Map<Character, Integer> letters = new HashMap<>();
        for (Character character : poemToChars(file)) {
            letters.computeIfPresent(character, (Character k, Integer value) -> value + 1);
            letters.putIfAbsent(character, 1);
        }

        return letters;
    }

    private static List<Character> poemToChars(File file) {
        List<Character> letters = new ArrayList<>();

        try (Scanner scan = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scan.hasNextLine()) {
                for (char someChar : scan.nextLine().toLowerCase().toCharArray()) {
                    if (Character.isAlphabetic(someChar)) {
                        letters.add(someChar);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return letters;
    }
}
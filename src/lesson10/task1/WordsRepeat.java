package lesson10.task1;

import java.util.HashMap;
import java.util.Map;

public final class WordsRepeat {

    private WordsRepeat() {
    }

    public static Map<String, Integer> wordCounter(String someString) {
        Map<String, Integer> repeatingWords = new HashMap<>();

        for (String word : wordsFromText(someString)) {
            repeatingWords.computeIfPresent(word, (String key, Integer value) -> value + 1);
            repeatingWords.putIfAbsent(word, 1);
        }
        return repeatingWords;
    }

    private static String[] wordsFromText(String someText) {
        return someText.split("[^A-Za-z']+");
    }
}
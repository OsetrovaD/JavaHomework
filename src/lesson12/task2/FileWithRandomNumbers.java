package lesson12.task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public final class FileWithRandomNumbers {

    private static final int MAX_VALUE = 101;
    private static final int MAX_BOUND = 31;
    private static final int MIN_BOUND = 20;

    private FileWithRandomNumbers() {
    }

    public static File createFile() {
        Path path = Paths.get("src", "lesson12", "task2", "fileWithNumbers.txt");
        Random num = new Random();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path.toFile()))) {
            for (int i = 0; i < num.nextInt(MAX_BOUND) + MIN_BOUND; i++) {
                bufferedWriter.write(Integer.toString(num.nextInt(MAX_VALUE)));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return path.toFile();
    }
}
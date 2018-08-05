package lesson12.task1;

import lesson10.task1.MapTestUtil;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    public static void main(String[] args) {
        Path path = Paths.get("src", "lesson12", "task1", "poem.txt");
        MapTestUtil.printMap(LettersInPoem.lettersCounter(path.toFile()));
    }
}